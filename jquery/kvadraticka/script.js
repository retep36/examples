$(function() {
  $('#rovnica').keyup(function(){
    var equation = $('#rovnica').val();
    var found = equation.match(/[0-9]+x\^2[+-][0-9]+x[+-][0-9]+/g);
    if(found != null){
      $('#rovnica').css('background-color', '#29a329');
      $('#rovnaSa').prop('disabled', false);
    }
    else {
      $('#rovnica').css('background-color', '#cc0000');
      $('#rovnaSa').prop('disabled', true);
    }
  });
});

$(function(){
  $('#rovnaSa').click(function(){
    var celaRovnica, a, zmaz, b, c, d, prepocet, x1, x2, x;
    celaRovnica = $('#rovnica').val();
    a = celaRovnica.match(/^[0-9]+/g);
    zmaz = celaRovnica.match(/[0-9]+x\^2[+-]/g);
    celaRovnica = celaRovnica.replace(zmaz,"");
    b = celaRovnica.match(/^[0-9]+/g);
    zmaz = celaRovnica.match(/[0-9]+x[+-]/g);
    celaRovnica = celaRovnica.replace(zmaz,"");
    c = celaRovnica;
    d = (b*b)-4*(a*c);
  
    if(d>0){
      prepocet = Math.sqrt(d);
      x1 = ((-b)+prepocet)/(2*a);
      x2 = ((-b)-prepocet)/(2*a);
      x1 = x1.toFixed(5);
      x2 = x2.toFixed(5);
      $('#vysledok').html('Prvy koren:'+ x1 + ', druhy koren:' + x2);
    }
  
    if(d==0){
      x = (-b)/(2*a);
      $('#vysledok').html(x);
    }
  
    if(d<0){
      $('#vysledok').html("Rovnica nema riesenie v mnozine realnych cisel");
    }
  });
});