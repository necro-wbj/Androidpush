<?php
try{
    $db = new PDO('mysql:host=localhost;dbname=test1;charset=utf8mb4','root','',
        array(
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8mb4'
            )
        );
}catch(PDOException $e){
    http_response_code(500);
    header('Content-Type:text/plain; charset=utf8');
    echo 'ERROR';
    echo $e;
    exit(0);
}
$stmt = $db -> prepare('select * from user');
$stmt -> execute();
?>
<!DOCTYPE <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>使用者資料</title>
</head>
<body>
    <h1>已經登錄的Token</h1>
    <ul>
        <?php
        while($r = $stmt -> fetch()){
            echo '<li>';
            echo $r['neme'];
            echo '(';
            echo $r['token'];
            echo ')</li>';
        }
        ?>
    </ul>
</body>
</html>