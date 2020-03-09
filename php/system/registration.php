<?php 
	require_once 'connect.php';
	session_start();
	if(isset($_SESSION["username"])){
 		header("location: dashboard.php");
	}
?>

<!DOCTYPE html>
<html>

<head>
	<title>Form validator</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="script.js"></script>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<style>
		#email1 {
			color: #fff;
		}

		.text-container {
			display: inline-block;
			position: relative;
			overflow: hidden;
			width: 100%;
		}

		#stateEmail,
		#statePass,
		#checkUsername {
			position: absolute;
			right: 2vh;
			margin: 0;
			position: absolute;
			top: 10%;
			transition: right 0.2s;
		}

		.card-signin .card-img-left {
			width: 45%;
			background: scroll center url("back.JPG");
			/* background: scroll center url('https://source.unsplash.com/WEQbe2jBg40/414x512'); */
			background-size: cover;
		}
		
		.form-label-group {
			padding: 1rem;
		}

		.card {
			border-radius: 2rem;
		}

		.card-img-left {
			border-top-left-radius: 2rem;
			border-bottom-left-radius: 2rem;
		}

		.form-label-group input {
			height: auto;
			border-radius: 2rem;
		}

		.card-title {
			font-family: Quicksand;
		}

		body {
			background-color: #5f088a;
		}
	</style>

	<link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">
</head>

<body>
	<div class="container">
		<form class="formular" id="registrationForm" action="register.php" method="POST">
			<div class="row">
				<div class="col-lg-10 col-xl-9 mx-auto">
					<div class="card card-signin flex-row my-5">
						<div class="card-img-left d-none d-md-flex">
						</div>
						<div class="form-label-group">
							<h5 class="card-title text-center">Register</h5>
							<div class="text-container">
								<input type="text" class="form-control" name="username" id="username" placeholder="Enter username"
								required>
								<span id="checkUsername"></span><br>
							</div>
							<input type="text" class="form-control" name="email" id="email1" class="funkcia"
								placeholder="Enter email" required><br>
							<div class="text-container">
								<input type="text" class="form-control" name="email2" id="email2" class="funkcia"
									disabled="true" required>
								<span id="stateEmail"></span><br>
							</div>
							<div class="text-container">
								<input type="password" class="form-control" name="heslo" id="pass" class="funkcia"
									placeholder="Enter password" required>
								<span id="statePass"></span><br>
							</div>
							<input type="checkbox" id="terms" name="terms" class="text-justify"> Agree with our <a href="#" style="color: royalblue;">Terms & Privacy</a><br><br>
							<input type="submit" class="form-control" name="registruj" value="Submit" disabled="true"
								id="odosli">
						</div>
					</div>
				</div>
			</div>
		</form>
		<div id="error"></div>
	</div>
</body>

</html>