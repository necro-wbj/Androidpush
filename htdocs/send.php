<?php
require __DIR__.'/vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;
use Kreait\Firebase\Messaging\CloudMessage;

$serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'./../.json'); //TODO: 待新增

$firebase = (new Factory)
    ->withServiceAccount($serviceAccount)
    ->create();

$token = isset($_POST['t']) ? $_POST['t']:'';
$message = isset($_POST['m']) ? $_POST['m']:'';

$msg = CloudMessage::fromArray([
    'token' => $token,
    'notification' =>[
        'title' => '我們的推播',
        'body' => $message
    ]
]);

$msger = $firebase -> getMessaging();
$msger = send($message);
