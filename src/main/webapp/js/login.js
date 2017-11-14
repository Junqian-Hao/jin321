$(function(){
    $("#verificationÏmg").on("click", function () {
        $.ajax({
            url:"/ms/getCaptcha.do",
            type:"post",
            contentType:"application/json",
            success: function () {
                $("#verificationÏmg").attr("src","/ms/getCaptcha.do");
            }
        })
    });

    $("#login-btn").on("click",function(){
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        var verification = $("#verification").val();
        var data = {
            dusername:username,
            dpassword:pwd,
            verifycode:verification
        }
        $.ajax({
            url:"/ms/dealerLogin.do",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success: function (res) {
                if(res.code == 6){
                    window.location = "admin.html"
                }
            }
        });
    });
});
