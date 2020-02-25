function validateForm(){
	var status1, status2, status3;

	var email1 = document.getElementById('email1').value;
	var tmp = email1.match(/.+@([a-z])+\.[a-z]{2,3}/g);
	var emailValid = document.getElementById('emailValid');

	if(tmp){
		document.getElementById('email2').disabled = false;
		emailValid.innerHTML = "YES";
		status1 = true;
	}
	else {
		emailValid.innerHTML = "NO";
		status1 = false;
	}

	var email1 = document.getElementById('email1').value;
	var email2 = document.getElementById('email2').value;
	var emailValid2 = document.getElementById('emailValid2');
	var tmp = email1.localeCompare(email2);
	if(email1 == email2){
		emailValid2.innerHTML = "EQUAL";
		status2 = true;
	}
	else if(status1 == true){
		emailValid2.innerHTML = "NOT EQUAL";
		status2 = false;
	}

	var heslo = document.getElementById('pass').value;
	var regExp = heslo.match(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}/g);
	var strength = document.getElementById('strength');

	if(regExp){
		strength.innerHTML = "Strong and good password!";
		status3 = true;
	}
	else if(heslo.length > 0) {
		strength.innerHTML = "Bad password! Pass must contain at least one big letter, one small letter and one number";
		status3 = false;
	}
	else if(heslo.length == 0){
		strength.innerHTML = "";
		status3 = false;
	}


	if(status1 && status2 && status3){
		document.getElementById('odosli').disabled = false;
	}
	else {
		document.getElementById('odosli').disabled = true;
	}
}