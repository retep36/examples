const images = [
  '<img class="image-slider cropp" src="assets/img1.jpg">', //0
  '<img class="image-slider cropp" src="assets/img2.jpg">', //1
  '<img class="image-slider cropp" src="assets/img3.jpg">', //2
  '<img class="image-slider cropp" src="assets/img4.jpg">', //3
];

let numberOfTimer,
  index = 0;

slideShow();

function slideShow() {
  document.getElementById("slider").innerHTML = images[index];
  index = ++index;
  index == images.length ? (index = 0) : null;
  numberOfTimer = setTimeout(() => slideShow(), 3000);
}

function prev() {
  clearTimeout(numberOfTimer);
  let tmp = index - 2;
  tmp == -2 ? (tmp = images.length - 2) : false;
  tmp == -1 ? (tmp = images.length - 1) : false;
  index = tmp;
  document.getElementById("slider").innerHTML = images[index];
  slideShow();
}

function next() {
  clearTimeout(numberOfTimer);
  document.getElementById("slider").innerHTML = images[index];
  slideShow();
}
