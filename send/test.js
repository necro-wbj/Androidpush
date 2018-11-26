
var admin = require("firebase-admin");

var serviceAccount = require("./push.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
  //databaseURL: "https://android-push-8f5d9.firebaseio.com" 接資料庫用
});

// This registration token comes from the client FCM SDKs.
var registrationToken = 'evb0OyH4Wog:APA91bHGpTUO_Qe4R_6cIIIWb3sC8TphM9Zhhq7h169mCphcjN3fP5sYqB2GgNrrNs-Q0M7u97Gv9a8NwNjZ0GRO2LQ3YV80kwm3roZlCh-B7M7pUP7MnQ-g1dmfihEfduAVP5ohkW0E';

// See documentation on defining a message payload.
var message = {
  data: {
    score: '850',
    time: '2:45'
  },
  token: registrationToken
};

// Send a message to the device corresponding to the provided
// registration token.
admin.messaging().send(message)
  .then((response) => {
    // Response is a message ID string.
    console.log('Successfully sent message:', response);
    process.exit(0);
})
.catch((error) => {
    console.log('Error sending message:', error);
    process.exit(0);
  });