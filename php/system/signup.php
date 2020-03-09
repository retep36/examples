<?php
    session_start();
    require_once 'connect.php';

    if ($_SERVER['REQUEST_METHOD'] == 'POST'){
        if(isset($_POST['prihlas'])){
            $username = $_POST['username'];
            $password = $_POST['heslo'];
        }
    }

    $stmt=$conn->prepare("SELECT * FROM users WHERE username = :username");
    $stmt->bindParam(':username', $username);
    $stmt->execute();

    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    if($user === false){
        die('Incorrect username / password combination!');
    } else{
        $validPassword = password_verify($password, $user['pass']);
        if($validPassword){
            $_SESSION['username'] = $username;
            $_SESSION['logged_in'] = time();
            header('Location: dashboard.php');
            exit;
        } else{
            die('Incorrect username / password combination!');
        }
    }
?>