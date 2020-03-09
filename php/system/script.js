$(function () {
	var status1, status2, status3, email1, email2, regExp, statusUser = false;
	var statusName = false, statusTerms = false;

	$(function(){
		$('#username').keyup(function () {
			if ($('#username').val().length > 0) {
				statusName = true;
			} else {
				statusName = false;
			}
			$.ajax({
				type: 'POST',
				url: 'checkUsername.php',
				data: { username: $(this).val().trim() },
				success: function (response) {
					if (response == 0) {
						$('#checkUsername').html('username available');
						$('#checkUsername').css("color", "#29a329");
						statusUser = true;
					}
					if (response == 1) {
						$('#checkUsername').html('username not available');
						$('#checkUsername').css('color', '#cc0000');
						statusUser = false;
					}
				controll();
				}
			});
		});
	});

	$('#email1').keyup(function () {
		email1 = $('#email1').val();
		if (email1.match(/.+@([a-z])+\.[a-z]{2,3}/g)) {
			$('#email2').prop('disabled', false);
			$('#email1').css("background-color", "#29a329");
			status1 = true;
		}
		else {
			$('#email1').css("background-color", "#cc0000");
			status1 = false;
		}
		controll();
	});

	$('#email2').keyup(function () {
		email2 = $('#email2').val();
		if (email1 == email2) {
			$('#stateEmail').html("equal");
			$('#stateEmail').css("color", "#29a329");
			status2 = true;
		}
		else if (status1) {
			$('#stateEmail').html("not equal");
			$('#stateEmail').css('color', '#cc0000');
			status2 = false;
		}
		controll();
	});

	$('#terms').on('click', function () {
		statusTerms = !statusTerms;
		controll();
	});

	$('#pass').keyup(function () {
		regExp = $('#pass').val().match(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}/g);
		if (regExp) {
			$('#statePass').html("Strong and good password!");
			$('#statePass').css("color", "#29a329");
			status3 = true;
		}
		else if ($('#pass').val().length > 0) {
			$('#statePass').html("Bad password!");
			$('#statePass').css('color', '#cc0000');
			status3 = false;
		}
		else if ($('#pass').val().length == 0) {
			$('#statePass').html("");
			status3 = false;
		}
		controll();
	});

	function controll() {
		if (status1 && status2 && status3 && statusName && statusTerms && statusUser) {
			$('#odosli').prop('disabled', false);
		}
		else {
			$('#odosli').prop('disabled', true);
		}
	}
});