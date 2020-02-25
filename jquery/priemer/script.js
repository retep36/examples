function countRows() {
    maxRowId = $("#table  tr:last").attr('id');
    return maxRowId;
}

function controlInput() {
    countRows();
    if (maxRowId == undefined) {
        $('#error').html('Number of inputs is lower then 1. Please add new row.').css('color', 'tomato');
    }
    if (maxRowId == 0) {
        maxRowId++;
    }
    if (maxRowId >= 1) {
        if (fillInputs()) {
            calculation();
        }
    }
}

function fillInputs() {
    for (var i = 0; i <= maxRowId; i++) {
        var weight = $('#weight' + i).val();
        var marks = $('#marks' + i).val();

        if (weight != undefined || marks != undefined) {
            if (weight.length == 0 || marks.length == 0) {
                $('#error').html('Please fill all inputs').css('color', 'tomato');
                return false;
            }
        }
    }
    return true;
}

function calculation() {
    var j = 0;
    var array = [];
    var delitel = 0, delenec = 0;
    for (var i = 0; i <= maxRowId; i++) {
        var weight = $('#weight' + i).val();
        var marks = $('#marks' + i).val();
        if (weight != undefined) {
            if (weight.length >= 1) {
                if (!(/^[0-9](\.[0-9])*$/g).test(weight)) {
                    $('#error').html('Bad input - weight').css('color', 'tomato');
                    return false;
                }
            }
        }
        if (marks != undefined) {
            do {
                if (marks.length != 1) {
                    array.push([]);
                    mark = parseInt(marks);
                    if (!(/^[0-5]\,?/g).test(marks)) {
                        $('#error').html('Bad input - marks').css('color', 'tomato');
                        return false;
                    } else {
                        marks = marks.replace(/^[0-5]\,?/g, "");
                        saveToArray();
                    }
                }
                if (marks.length == 1) {
                    array.push([]);
                    if (!(/^[0-5]/g).test(marks)) {
                        $('#error').html('Bad input - marks').css('color', 'tomato');
                        return false;
                    } else {
                        mark = parseInt(marks);
                        saveToArray();
                    }
                }
            } while (marks.length > 1);
        }
    }
    for (var i = 0; i < array.length; i++) {
        delitel = delitel + parseFloat(array[i][0]);
        delenec = delenec + parseFloat((array[i][0] * array[i][1]));
    }
    var vysledok = (delenec / delitel).toFixed(3);
    $('#solution').html("Result: " + vysledok);
    $('#error').html('OK!').css('color', 'teal');

    function saveToArray() {
        array[j][0] = weight;
        array[j][1] = mark;
        j++;
    }
}

$(function () {
    $('#calc').click(function () {
        $('#error').html(' ');
        controlInput();
    });
});

$(function () {
    var x = 1;
    $('#generateRow').click(function () {
        var cell1 = '<input type="text" class="input form-control" id="weight' + x + '">';
        var cell2 = '<input type="text" class="input form-control" id="marks' + x + '">';
        var deleteButton = '<button type="button" class="deleteRow btn btn-danger" id="' + x + '">X</button>';
        $('#table > tbody:last-child')
            .append('<tr id="' + x + '"><td>' + cell1 + '</td><td>' + cell2 + '</td><td>' + deleteButton + '</td></tr>');
        x++;
    });
});

$(function () {
    $('#table').delegate('.deleteRow', 'click', function () {
        $('#' + this.id).remove();
    });
});