var prve, druhe, tretie, stvrte;
var tmp1 = 1, tmp2 = 0, tmp3 = 'x0,01&#x2126;', tmp4 = '&#xb1;10%';

$(function () {
    colors = [
        'silver', 'gold', 'black',
        'brown', 'red', 'orange',
        'yellow', 'green', 'blue',
        'purple', 'gray', 'white'
    ];

    offset = ['silver', 'gold', 'brown', 'red', 'green', 'white']

    prve = $('#prve');
    prve.css('background-color', colors[3]);
    druhe = $('#druhe');
    druhe.css('background-color', colors[2]);
    tretie = $('#tretie');
    tretie.css('background-color', colors[0]);
    stvrte = $('#stvrte');
    stvrte.css('background-color', offset[0]);
})

$('.tlacidlo').click(function () {
    switch (this.id) {
        case 'prve':
            index = getNameColor(prve.css('background-color'));
            if (index == 11) {
                index = 2;
            }
            index++;
            tmp1 = index - 2;
            prve.css('background-color', colors[index]);
            break;
        case 'druhe':
            index = getNameColor(druhe.css('background-color'));
            if (index == 11) {
                index = 1;
            }
            index++;
            tmp2 = index - 2;
            druhe.css('background-color', colors[index]);
            break;
        case 'tretie':
            index = getNameColor(tretie.css('background-color'));
            if (index == 9) {
                index = -1;
            }
            index++;
            switch (index) {
                case 0: tmp3 = 'x0,01&#x2126;'; break;
                case 1: tmp3 = 'x0,1&#x2126;'; break;
                case 2: tmp3 = 'x1&#x2126;'; break;
                case 3: tmp3 = 'x10&#x2126;'; break;
                case 4: tmp3 = 'x100&#x2126;'; break;
                case 5: tmp3 = 'x1k&#x2126;'; break;
                case 6: tmp3 = 'x10k&#x2126;'; break;
                case 7: tmp3 = 'x100k&#x2126;'; break;
                case 8: tmp3 = 'x1M&#x2126;'; break;
                case 9: tmp3 = 'x10M&#x2126;'; break;
                default: break;
            }
            tretie.css('background-color', colors[index]);
            break;
        case 'stvrte':
            index = getOffsetColor(stvrte.css('background-color'));
            if (index == 5) {
                index = 0;
            }
            index++;
            switch (index) {
                case 0: tmp4 = '&#xb1;10%'; break;
                case 1: tmp4 = '&#xb1;5%'; break;
                case 2: tmp4 = '&#xb1;2%'; break;
                case 3: tmp4 = '&#xb1;1%'; break;
                case 4: tmp4 = '&#xb1;0,5%'; break;
                case 5: tmp4 = '&#xb1;20%'; break;
                default: break;
            }
            stvrte.css('background-color', offset[index]);
            break;
        default:
            alert('Niekde nastala chyba');
            break;
    }
    $('#score').html(parseInt(tmp1) + '' + parseInt(tmp2) + tmp3 + ' ' + tmp4);
    parseStringToNumber();
});

function getNameColor(color) {
    if (color == ('rgb(165, 42, 42)')) {
        return index = jQuery.inArray('brown', colors);
    }
    else if (color == ('rgb(255, 0, 0)')) {
        return index = jQuery.inArray('red', colors);
    }
    else if (color == ('rgb(192, 192, 192)')) {
        return index = jQuery.inArray('silver', colors);
    }
    else if (color == ('rgb(128, 128, 128)')) {
        return index = jQuery.inArray('gray', colors);
    }
    else if (color == ('rgb(255, 215, 0)')) {
        return index = jQuery.inArray('gold', colors);
    }
    else if (color == ('rgb(255, 165, 0)')) {
        return index = jQuery.inArray('orange', colors);
    }
    else if (color == ('rgb(0, 0, 0)')) {
        return index = jQuery.inArray('black', colors);
    }
    else if (color == ('rgb(255, 255, 255)')) {
        return index = jQuery.inArray('white', colors);
    }
    else if (color == ('rgb(255, 255, 0)')) {
        return index = jQuery.inArray('yellow', colors);
    }
    else if (color == ('rgb(0, 128, 0)')) {
        return index = jQuery.inArray('green', colors);
    }
    else if (color == ('rgb(128, 0, 128)')) {
        return index = jQuery.inArray('purple', colors);
    }
    else if (color == ('rgb(0, 0, 255)')) {
        return index = jQuery.inArray('blue', colors);
    }
}

function getOffsetColor(color) {
    if (color == ('rgb(165, 42, 42)')) {
        return index = jQuery.inArray('brown', offset);
    }
    else if (color == ('rgb(255, 0, 0)')) {
        return index = jQuery.inArray('red', offset);
    }
    else if (color == ('rgb(192, 192, 192)')) {
        return index = jQuery.inArray('silver', offset);
    }
    else if (color == ('rgb(255, 215, 0)')) {
        return index = jQuery.inArray('gold', colors);
    }
    else if (color == ('rgb(128, 128, 128)')) {
        return index = jQuery.inArray('gray', offset);
    }
    else if (color == ('rgb(0, 128, 0)')) {
        return index = jQuery.inArray('green', offset);
    }
    else if (color == ('rgb(255, 255, 255)')) {
        return index = jQuery.inArray('white', offset);
    }
}

function parseStringToNumber() {
    var zaklad = parseInt(tmp1) + '' + parseInt(tmp2);
    var nasobitel = (tmp3.replace('x', ''));
    nasobitel = (nasobitel.replace(',', '.'));
    nasobitel = (nasobitel.replace('&#x2126;', ''));
    if (nasobitel == '1k') {
        nasobitel = 1000;
    } else if (nasobitel == '10k') {
        nasobitel = 10000;
    } else if (nasobitel == '100k') {
        nasobitel = 100000;
    } else if (nasobitel == '1M') {
        nasobitel = 1000000;
    } else if (nasobitel == '10M') {
        nasobitel = 10000000;
    }
    var vysledok = (parseInt(zaklad) * parseFloat(nasobitel)).toFixed(2);
    var result = vysledok.match(/^[0-9]*/g);
    if(result[0] >= 10){
        vysledok = result[0];
    }
    switch (result[0].length) {
        case 4: vysledok = result[0].substr(0, 1) + ' ' + result[0].substr(1, 3); break;
        case 5: vysledok = result[0].substr(0, 2) + ' ' + result[0].substr(2, 3); break;
        case 6: vysledok = result[0].substr(0, 3) + ' ' + result[0].substr(3, 3); break;
        case 7: vysledok = result[0].substr(0, 1) + ' ' + result[0].substr(1, 3) + ' ' + result[0].substr(3, 3); break;
        case 8: vysledok = result[0].substr(0, 2) + ' ' + result[0].substr(2, 3) + ' ' + result[0].substr(4, 3); break;
        case 9: vysledok = result[0].substr(0, 3) + ' ' + result[0].substr(3, 3) + ' ' + result[0].substr(5, 3); break;
        default: break;
    }
    $('#aktualnaHodnota').html(vysledok + '&#x2126;' + tmp4);
}