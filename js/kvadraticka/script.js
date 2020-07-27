function validateEquation() {
  let equationValue = document.getElementById('rovnica').value;
  let foundRegex = equationValue.match(/[-]?[1-9]*x\^2([+-][1-9]*x)?([+-][0-9]+)?$/g);

  if (foundRegex != null) {
    document.getElementById('rovnica').style.backgroundColor = "#29a329";
    document.getElementById('rovnaSa').disabled = false;
    return foundRegex.toString();
  }
  else {
    document.getElementById('rovnica').style.backgroundColor = "#cc0000";
  }
}

function calculate() {
  let output = document.getElementById('vysledok');
  let equation = document.getElementById('rovnica').value;

  let a = getA(equation);
  equation = equation.replace(equation.match(/[-]?[1-9]*x\^2/g), "");
  let b = getB(equation);
  equation = equation.replace(equation.match(/[+-][1-9]*x/g), "");
  let c = equation;

  let discriminant = ((b * b) - 4 * a * c);
  if (discriminant > 0) {
    let x1 = ((-b) + Math.sqrt(discriminant)) / (2 * a);
    let x2 = ((-b) - Math.sqrt(discriminant)) / (2 * a);
    if(!Number.isInteger(x1)){
      x1 = x1.toFixed(3);
    }
    if(!Number.isInteger(x2)){
      x2 = x2.toFixed(3);
    }
    output.innerHTML = `Prvy koren: <strong>${x1}</strong>, druhy koren: <strong>${x2}</strong>`;
  }
  if (discriminant == 0) {
    let x = (-b) / (2 * a);
    output.innerHTML = `${x}`;
  }
  if (discriminant < 0) {
    output.innerHTML = `Rovnica nema riesenie v mnozine realnych cisel`;
  }
}

function getA(equation){
    let a;
    if (equation.match(/^x\^2/g)) {
      a = 1;
    }
    else if (equation.match(/^-x\^2/g)) {
      a = -1;
    }
    else if (equation.match(/^[-]?[1-9]*x\^2/g)) {
      a = equation.match(/^[-]?[1-9]*/g);
    }
    return a;
}

function getB(equation){
  let b;
  if (equation.match(/^\+x/g) == "+x") {
    b = 1;
  }
  else if (equation.match(/^-x/g) == "-x") {
    b = -1;
  }
  else if (equation.match(/[+-][1-9]*x/g)) {
    b = equation.match(/^[+-][1-9]*/g);
  }
  else if (b === undefined) {
    b = 0;
  }
  return b;
}