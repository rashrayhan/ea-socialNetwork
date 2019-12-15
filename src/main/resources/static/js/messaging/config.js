$(function(){
    conn();
});


const conn = function( ){
    let url = "/advert-not";
    let sock = new SockJS(url);

    let client = Stomp.over(sock);
    
    client.connect('spring', 'spring', {}, function(fr){
        client.subscribe("/topic/notification", handleData);
    }, function (error) {
        console.log("Failed with error: " + error);
    });

    function handleData(incomingData) {

    }
};
