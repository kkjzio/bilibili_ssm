//隐藏
var html = "";

function ajaxForm(res) {
    var ht = eval("(" + res + ")");
    var i = 0;
    var reshtml = "";
    $.each(ht, function (index, m) {
        reshtml += "<li class='item'><a href='video.sf/av"
            + m.videoID + "'><i class='n2'>" + (++i) + "</i>" + m.videoName
            + "</a></li>";
    });
    return reshtml;

}

$(document).ready(
    function () {


        $("#div2").hide();
        /*			$("#div2").hide();
                    function asjdh() {//移出
                          //alert("1");
                        $("#div2").hide();
                        }
                    function project() {//移入
                        //alert("2");
                        $("#div2").show();
                        }*/


        $.post("ajaxTuiJian1", function (res) {
            html = ajaxForm(res);
            $("#did1").html(html);

        });


        $.post("ajaxTuiJian2", function (res) {
            html = ajaxForm(res);
            $("#did2").html(html);

        });


        $.post("ajaxTuiJian3", function (res) {
            html = ajaxForm(res);
            // alert(html);
            $("#did3").html(html);
        });


        $("#qiulingyang").click(function () {
            alert("你点我也没用啊! 瞄~");
        })
        $("#shuaxin").click(function () {
            alert("功能未完成... ");
        })
        $("#shuaxin1").click(function () {
            alert("功能未完成... ");
        })
        $("#shuaxin2").click(function () {
            alert("功能未完成... ");
        })

    });

function asjdh() {//移出
    //alert("1");
    $("#div2").hide();
}

function project() {//移入
    //alert("2");
    $("#div2").show();
}


window.onload = function () {

    function clickAjax(bid, eid, posturl) {
        this.disabled = true;
        html = "";
        var i = 0;
        x = document.getElementById(bid);
        x.innerHTML = "正在刷新....";
        // 向后台ajax
        $.post(posturl, function (res) {
                html = ajaxForm(res);
                // alert(html);
                console.log(html);
                $(eid).html(html);
                x.innerHTML = "查看更多";
                document.getElementById(bid).disabled = false;
            }
        );

        // 服务器无连接时的动作
        setTimeout(function () {
            x = document.getElementById(bid);
            x.innerHTML = "查看更多";
            document.getElementById(bid).disabled = false;
        }, 4000);

    }


    document.getElementById('chakan1').onclick = function () {
        clickAjax("chakan1", "#did1", "ajaxTuiJian1");

    }
    document.getElementById('chakan2').onclick = function () {
        clickAjax("chakan2", "#did2", "ajaxTuiJian2")

    }

    document.getElementById('chakan3').onclick = function () {
        clickAjax("chakan3", "#did3", "ajaxTuiJian3")

    }

}
