function validateForm() {
  let status1, status2, status3;
  let email1 = document.getElementById("email1").value;
  let email2 = document.getElementById("email2").value;

  // functions to valid and check
  (email1) => {
    let goodEmailAdress = email1.match(/.+@([a-z])+\.[a-z]{2,3}/g);
    let emailValid = document.getElementById("emailValid");

    if (goodEmailAdress) {
      document.getElementById("email2").disabled = false;
      emailValid.innerHTML = "VALID EMAIL";
      emailValid.style.color = "#33cc33";
      status1 = true;
    } else {
      document.getElementById("email2").disabled = true;
      emailValid.innerHTML = "NOT VALID EMAIL";
      emailValid.style.color = "#ff6347";
      status1 = false;
    }
  };

  checkEmail(email1, email2);
  validPass();

  if (status1 && status2 && status3) {
    document.getElementById("odosli").disabled = false;
  } else {
    document.getElementById("odosli").disabled = true;
  }

  function checkEmail(email1, email2) {
    let emailValid2 = document.getElementById("emailValid2");
    console.log(status1);
    if (email1 === email2 && email1.length > 3) {
      emailValid2.innerHTML = "EQUAL EMAILS";
      emailValid2.style.color = "#33cc33";
      status2 = true;
    } else if (status1) {
      emailValid2.innerHTML = "NOT EQUAL EMAILS";
      emailValid.style.color = "#ff6347";
      status2 = false;
    }
  }

  function validPass() {
    let heslo = document.getElementById("pass").value;
    let regExp = heslo.match(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}/g);
    let strength = document.getElementById("strength");

    if (regExp) {
      strength.innerHTML = "Strong and good password!";
      strength.style.color = "#33cc33";
      status3 = true;
    } else if (heslo.length > 0) {
      strength.innerHTML =
        "Bad password! Pass must contain big letter, small letter and number";
      strength.style.color = "tomato";
      status3 = false;
    } else if (heslo.length == 0) {
      strength.innerHTML = "";
      status3 = false;
    }
  }
}
