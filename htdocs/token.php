<?php
// 預期用戶會發POST過來
$token = isset($_POST['t']) ? $_POST['t']:'';
$token = isset($_POST['n']) ? $_POST['n']:'';

//連線資料庫
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
    exit(0);
}

//存到資料庫
$stmt = $db -> prepare('INSERT INTO user (name,token) VALUES(?,?)');
$ok = $stmt -> execute([$name,$token]);
if($ok){
    http_response_code(200);
    header('Content-Type:text/plain; charset=utf8');
    echo 'SUCCESS';
}else{
    http_response_code(500);
    header('Content-Type:text/plain; charset=utf8');
    echo 'FAIL';
}