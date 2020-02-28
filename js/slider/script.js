var images = [
	'<img src="img1.jpg">', //0
	'<img src="img2.jpg">', //1
	'<img src="img3.jpg">', //2
	'<img src="img4.jpg">'  //3
];

var time, index = 0;

slideShow();

function slideShow() {
	document.getElementById('slider').innerHTML = images[index];
	index = index + 1;
	index == images.length ? index = 0 : null;
	time = setTimeout(function() { slideShow() }, 3000);
}

function prev() {
	clearTimeout(time);
	var tmp = index - 2;
	tmp == -2 ? tmp = images.length - 2 : false;
	tmp == -1 ? tmp = images.length - 1 : false;
	index = tmp;
	document.getElementById('slider').innerHTML = images[index];
	slideShow();	
}

function next() {
	clearTimeout(time);
	document.getElementById('slider').innerHTML = images[index];
	slideShow();
}