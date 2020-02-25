function validateEquation(){
  var equation2 = document.getElementById('rovnica')
  var equation = document.getElementById('rovnica').value;
  var info = document.getElementById('info');

  var regex = /[0-9]+x\^2[+-][0-9]+x[+-][0-9]+/g;
  var found = equation.match(regex);

  if(found != null){
    equation2.style.backgroundColor = "#29a329";
    document.getElementById('rovnaSa').disabled = false;
    var hotovo = found.toString();
  }
  else {
    equation2.style.backgroundColor = "#cc0000";
  }
  return hotovo;
}

function vypocet(){
  var output = document.getElementById('vysledok');
  var celaRovnica = document.getElementById('rovnica').value;
  var a = celaRovnica.match(/^[0-9]+/g);
  var zmaz = celaRovnica.match(/[0-9]+x\^2[+-]/g);
  celaRovnica = celaRovnica.replace(zmaz,"");
  var b = celaRovnica.match(/^[0-9]+/g);
  zmaz = celaRovnica.match(/[0-9]+x[+-]/g);
  celaRovnica = celaRovnica.replace(zmaz,"");
  var c = celaRovnica;
  var d = (b*b)-(4*a*c);

  if(d>0){
    var prepocet = Math.sqrt(d);
    var x1 = ((-b)+prepocet)/(2*a);
    var x2 = ((-b)-prepocet)/(2*a);
    x1 = x1.toFixed(5);
    x2 = x2.toFixed(5);
    output.innerHTML ='Prvy koren:'+ x1 + ', druhy koren:' + x2;
  }

  if(d==0){
    var x =(-b)/(2*a);
    output.innerHTML = x;
  }

  if(d<0){
    output.innerHTML = "Rovnica nema riesenie v mnozine realnych cisel";
  }
}
