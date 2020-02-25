var i = 2, sucet = 0, status;

$(function(){
	$('calc').click(function(){
		var vaha = 0;
	for(var j = i-1; j > 0; j--){
		var idMark = 'marks' + j;
		var idWeight = 'weight' + j;
		var mark = $("#idMark").val();
		var weight = $("#idWeight").val();

		if(mark.length <= 0){
			alert("prazdne policko");
		}
		mark = mark.replace(/\,/g, " ");
		mark = mark.match(/[0-9]\,*/g);
		var dlzka = mark.length-1;
		var pocet = mark.length;
		vaha1 = weight * pocet;

		do{
			sucet += mark[dlzka] * weight;
			dlzka--;
		}
		while (dlzka >= 0);
		vaha = vaha + vaha1;
	}
	var vysledok = sucet / vaha;
	alert("vazeny priemer: " + vysledok);
	});
});

function generate(){
	var tr = document.getElementById("table");
	var td = tr.insertRow(length-1);
	var cell1 = td.insertCell(0);
	var cell2 = td.insertCell(1);
	cell2.innerHTML = '<input type="text" name="mark" id="marksTMP">';
	cell1.innerHTML = '<input type="text" name="weight" id="weightTMP">';

	var tmp_mrk = document.getElementById("marksTMP");
	var tmp_wght = document.getElementById("weightTMP");

	var connectMark = "marks" + i;
	var connectWeight = "weight" + i;
	tmp_mrk.id = connectMark;
	tmp_wght.id = connectWeight;
	i++;
}

$(function(){
	$('#delete').click(function(){
		if(i != 2){
			$("#table").this(length-1);
			i--;
		}
	});
});