<?php
    session_start();
    require_once 'connect.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
    body {
		background-color: #5f088a;
    }

    .text {
        color: #fff;
    }

    .row p {
        display: inline-block;
        vertical-align: top;
    }

    .logout {
        text-align: right;
    }
    </style>
</head>
<body>
    <div class="row">
        <p class="text">Login as: <strong><?php echo $_SESSION['username']; ?></strong></p> 
        <p class="logout"><a class="text" href="logout.php">Logout</a></p>
    </div>
</body>
</html>