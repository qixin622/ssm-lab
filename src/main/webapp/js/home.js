$(function() {
    $(".small").click(function() {
        var thisele = $(".article-content").css("font-size");
        var textfontsize = parseFloat(thisele);
        textfontsize -= 2;
        $(".article-content").css('font-size', textfontsize);
//        $(".article-content").animate({fontSize:"-=2"});
    });

    $(".big").click(function() {
        var thisele = $(".article-content").css("font-size");
        var textfontsize = parseFloat(thisele);
        textfontsize += 2;
        $(".article-content").css('font-size', textfontsize);
//        $(".article-content").animate({fontSize:"+=2"});
    });

    $(".article-content").click(function() {
        if ($(".article-content").css('background-color') === 'rgb(199, 237, 204)')
            $(".article-content").css('background', '#F5F5F5');
        else
            $(".article-content").css('background', 'rgb(199, 237, 204)');
    });
});

//展开合并下级
function DisplayRows(id)
{
    var rowpid = $("div[rel='rowpid_" + id + "']");
    var rowid = $("span[id='rowid_" + id + "']");

    if (rowid.attr("class") === "disimg")
    {
        rowpid.slideUp(200);
        rowid.attr("class", "disimg2");
    }
    else
    {
        rowpid.slideDown(200);
        rowid.attr("class", "disimg");
    }
}

//全部显示行
function ShowAllRows()
{
    $("div[rel^='rowpid'][rel!='rowpid_0']").slideDown(200);
    ;
    $("span[id^='rowid']").attr("class", "disimg");
}


//全部隐藏行
function HideAllRows()
{
    $("div[rel^='rowpid'][rel!='rowpid_0']").slideUp(200);
    ;
    $("span[id^='rowid']").attr("class", "disimg2");
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