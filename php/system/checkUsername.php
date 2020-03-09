<?php
    require_once 'connect.php';
    
    if (isset($_POST['username'])){
        $username = $_POST['username'];
        $response = '';

        $stmt=$conn->prepare("SELECT * FROM users WHERE username=:uname");
        $stmt->bindParam(':uname', $username);
        $stmt->execute();
        $count = $stmt->rowCount();
        if($count > 0){
            $response = '1';
        }
        else {
            $response = '0';
        }

    echo $response;
    }
?>  