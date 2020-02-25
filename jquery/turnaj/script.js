var blok = 2;
var nazovBloku;
var pocet = 1;

function nastavBloky() {
    bloky = '#blok1 #blok2, #blok3, #blok4, #blok5, #blok6, #blok7, #blok8';
    $(bloky).css('width', '35vh');
}

function kontrolaPoctuTimov() {
    nazovBloku = 'blok' + blok;
    if ($('#pocetTimov').val() == null || $('#pocetTimov').val() == "" || $('#pocetTimov').val() < 4 || $('#pocetTimov').val() > 256) {
        alert("Zadal si nespravnu hodnotu alebo nizku hodnotu");
        return false;
    }
    if ($('#pocetTimov').val() >= 4 && $('#pocetTimov').val() <= 512) {
        var teams = [4, 8, 16, 32, 64, 128, 256, 512];

        pocetTimov = $('#pocetTimov').val();
        for (var i = 0; i < teams.length; i++) {
            if (pocetTimov > teams[i - 1] && pocetTimov < teams[i]) {
                pocetTimov = teams[i];
            }
        }
    }
    return pocetTimov;
}

function pripojPolia() {
    spocitajTimy();
    $('#blok1').append('<p class="input">1. kolo</p>');
    for (var i = 0; i < pocetTimov; i++) {
        $('#blok1').append('<input type="text" class="input" id="ntim' + pocet + '"></input><input type="number" class="vysledok"  id="tim' + pocet + '"></input><br>');
        pocet++;
        if (i % 2) {
            $('#blok1').append('<br>');
        }
    }
    vykresli();
}

function vykresli() {
    nazovBloku = "#blok" + blok;
    if (pocetTimov > 2) {
        pocetTimov = pocetTimov / 2;
        spocitajTimy();
        for (var i = 0; i < pocetTimov; i++) {
            $(nazovBloku).append('<input type="text" class="input" id="ntim' + pocet + '"></input><input type="number" class="vysledok" id="tim' + pocet + '"></input><br>');
            pocet++;
            if (i % 2) {
                $(nazovBloku).append('<br>');
            }
        }
    }
    if (pocetTimov > 2) {
        blok++;
        vykresli();
    } else if ((pocetTimov <= 2) && $('#thirdplace').is(':checked')) {
        tretieMiesto();
    }
}

function tretieMiesto() {
    $(nazovBloku).append('<br><br>');
    $(nazovBloku).append('<p class="input">o 3. miesto</p>');
    $(nazovBloku).append('<input type="text" class="input" id="ntim' + pocet + '"></input><input type="number" class="vysledok" id="tim' + pocet + '"></input><br>');
    pocet++;
    $(nazovBloku).append('<input type="text" class="input" id="ntim' + pocet + '"></input><input type="number" class="vysledok" id="tim' + pocet + '"></input><br>');
}

function spocitajTimy() {
    switch (pocetTimov) {
        case 2: $(nazovBloku).append('<p class="input">FINALE</p>'); break;
        case 4: $(nazovBloku).append('<p class="input">Semifinale</p>'); break;
        case 8: $(nazovBloku).append('<p class="input">Stvrtfinale</p>'); break;
        case 16: $(nazovBloku).append('<p class="input">Osemfinale</p>'); break;
        case 32: $(nazovBloku).append('<p class="input">' + blok + '. kolo</p>'); break;
        case 64: $(nazovBloku).append('<p class="input">' + blok + '. kolo</p>'); break;
        case 128: $(nazovBloku).append('<p class="input">' + blok + '. kolo</p>'); break;
        case 256: $(nazovBloku).append('<p class="input">' + blok + '. kolo</p>'); break;
        default: break;
    }
}

$('#vygeneruj').click(function () {
    for (var i = 1; i < 10; i++) {
        $('#blok' + i).empty();
    }
    blok = 2;
    pocet = 1;
    nastavBloky();
    kontrolaPoctuTimov();
    if (pocetTimov > 3 && pocetTimov < 257) {
        pripojPolia();
    }
});

$(function () {
    $('.row').delegate('input[type="number"]', 'keyup', function () {
        for (var i = 1; i < pocet; i += 2) {
            var j, hodnota1, hodnota2;
            j = parseInt(i) + 1;
            hodnota1 = $('#tim' + i).val();
            hodnota2 = $('#tim' + j).val();
            if (hodnota1.length > 0 && hodnota2.length > 0) {
                if (hodnota1 > hodnota2) {
                    $('#tim' + i).css('background-color', '#AFEE7D');
                    $('#ntim' + i).css('background-color', '#AFEE7D');
                    $('#tim' + j).css('background-color', '#F26248');
                    $('#ntim' + j).css('background-color', '#F26248');
                }
                if (hodnota1 < hodnota2) {
                    $('#tim' + j).css('background-color', '#AFEE7D');
                    $('#ntim' + j).css('background-color', '#AFEE7D');
                    $('#tim' + i).css('background-color', '#F26248');
                    $('#ntim' + i).css('background-color', '#F26248');
                }
            } else if (hodnota1 < 0 || hodnota1 < 0) {
                alert('Zadal si minusovu hodnotu');
            }
        }
    });
});
