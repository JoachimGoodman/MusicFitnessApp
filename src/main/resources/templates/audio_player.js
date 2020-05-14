let music = {
    music_name: "audio_test",
    time_stamp: "00:00:07"
}

const x = document.getElementById("audio");

function playAudio() {
    x.play();
}

function pauseAudio() {
    x.pause();
}


$('#postButton').click(function () {
    var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds() + ":" + today.getMilliseconds();
    var dateTime = date+':'+time;
    $.post("http://localhost:5000/syncU",
        {
            path: "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            time_stamp: x.currentTime
        },
        function () {
            console.log("send")
        }
    )
})

// ajax
$("#button").click(function(){
    $.get("http://localhost:5000/sync", function(data, status){
        const audioPlayer = document.getElementById("audio");
        audioPlayer.src = data.path +  "#t=" + data.time_stamp
        audioPlayer.play()
    });
});