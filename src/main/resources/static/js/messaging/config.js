$(function(){
    conn();
});


const conn = function( ){
    let url = "test";
    let client = new SockJS(url);

    client.onopen = function () {
        console.log("Connection opened!");
        client.send("How are you buddy!");
    };

    client.onmessage = function(data) {
        console.log("Feedback: " + data);
    };
    /*let client = Stomp.client(url, "v11.stomp");
    let username = '';
    let passcode = '';

    let callbackSuccess = function () {
        console.log("I am connected with the server!")
    };

    let callbackError = function () {
        console.log("Cannot connect to the server!");
    };

    client.connect(username, passcode, callbackSuccess, callbackError);*/
};
