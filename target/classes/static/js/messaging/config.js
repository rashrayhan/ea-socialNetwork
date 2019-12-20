$(function(){
    conn();
});


const conn = function(){
    let url = "http://" + window.location.host + "/advert-not";
    let sock = new SockJS(url);

    let client = Stomp.over(sock);
    
    client.connect({}, function(fr){
        client.subscribe("/queue/post-notification", handleData);
    }, function (error) {
        console.log("Failed with error: " + error);
    });

    function handleData(incomingData) {
        console.log("Received Notification: " + incomingData.body.message);
    }
};
