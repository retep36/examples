$(function () {
	var status1, status2, status3, email1, email2, regExp;
	var statusName = false, statusSurname = false, statusTerms = false;

	$('#name').keyup(function () {
		if ($('#name').val().length > 0) {
			statusName = true;
		} else {
			statusName = false;
		}
		controll();
	});

	$('#surname').keyup(function () {
		if ($('#surname').val().length > 0) {
			statusSurname = true;
		} else {
			statusSurname = false;
		}
		controll();
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
		console.log(statusTerms);
		if (status1 && status2 && status3 && statusName && statusSurname && statusTerms) {
			$('#odosli').prop('disabled', false);
			console.log('tu');
		}
		else {
			$('#odosli').prop('disabled', true);
			console.log('tam');
		}
	}
});