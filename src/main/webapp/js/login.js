$(function(){
    $("#verificationÏmg").on("click", function () {
        $.ajax({
            url:"/jin321/ms/getCaptcha.do",
            type:"post",
            contentType:"application/json",
            success: function () {
                var time = new Date();
                $("#verificationÏmg").attr("src","/jin321/ms/getCaptcha.do?time="+time.getTime());
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
            url:"/jin321/ms/dealerLogin.do",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success: function (res) {
                if(res.code == 4){
                    window.location = "admin.html";
                }else if(res.code == 6){
                    window.location = "SuperAdmin.html";
                }
            }
        });
    });
});
