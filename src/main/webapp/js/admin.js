$(function(){
    $(".leftnav h2").click(function(){
        $(this).next().slideToggle(200);
        $(this).toggleClass("on");
    });
    $(".leftnav ul li a").click(function(){
        $("#a_leader_txt").text($(this).text());
        $(".leftnav ul li a").removeClass("on");
        $(this).addClass("on");
    });
    showTime();
});

function conf() {
    if (confirm("确认删除这条记录吗？")) {
        return true;
    } else {
        return false;
    }
}

function showTime() {
    var show_day = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
    var time = new Date();
    var year = time.getYear();
    if (year < 1000) {
        year += 1900;
    }
    var month = time.getMonth();
    var date = time.getDate();
    var day = time.getDay();
    var hour = time.getHours();
    var minutes = time.getMinutes();
    var second = time.getSeconds();
    var dn="AM";
    if (hour>=12) { dn="PM"; }

    month = month + 1;
    month < 10 ? month = '0' + month : month;
    hour < 10 ? hour = '0' + hour : hour;
    minutes < 10 ? minutes = '0' + minutes : minutes;
    second < 10 ? second = '0' + second : second;
    var now_time = year + '年' + month + '月' + date + '日' + ' ' + show_day[day] + ' ' + hour + ':' + minutes + ':' + second + " " + dn;
    document.getElementById('showtime').innerHTML = now_time;
    setTimeout("showTime();", 1000);
}