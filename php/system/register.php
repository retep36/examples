<?php
    session_start();
    require_once 'connect.php';
    
    if ($_SERVER['REQUEST_METHOD'] == 'POST'){
        if(isset($_POST['registruj'])){
            $username = $_POST['username'];
            $email = $_POST['email'];
            $password = $_POST['heslo'];
            $response = '';
            $pass = password_hash( $password, PASSWORD_BCRYPT, array('cost' => 11));

            try{
                $stmt=$conn->prepare("SELECT * FROM users WHERE username=:uname AND email=:uemail");
                $stmt->bindParam(':uemail', $email);
                $stmt->bindParam(':uname', $username);
                $stmt->execute();
                $count = $stmt->rowCount();
                echo $count;

                if($count==0){
                    $stmt = $conn->prepare("INSERT INTO users(username,pass,email) VALUES(:uname, :pass, :uemail)");
                    $stmt->bindParam(':uemail', $email);
                    $stmt->bindParam(':uname', $username);
                    $stmt->bindParam(":pass", $pass);
                    $stmt->execute();
                    // $response = 1;
                    $_SESSION['username'] = $username;
                    header("location: dashboard.php");
                }
                if($count > 0){
                    $response = -1;
                }
            }
            catch(PDOException $e) {
                echo $e->getMessage();
            }
        }
    }
?>  