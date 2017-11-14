//一级分类id
var typeId = {};
//二级分类id
var typeId2 = {};
//fd
var fd = new FormData();
//轮播图fd
var fdl = new FormData();
$(function(){
    //头部
    $("#type-manage").on("click",function(){
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
    });

    //左侧查看分类
    $("#watch-type").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".watch-type").css("display","block");
        //获取一级分类
        $.ajax({
            url:"/ms/selectAllFirstProducttype.do",
            type:"post",
            contentType:"application/json",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    const name = res[i].typename;
                    typeId[name] = res[i].tid;
                    const option = $("<option></option>").html(name);
                    $("#first-type").append(option);
                }
                var json = {
                    tid:typeId[0]
                }
                //获取对应的二级分类
                $.ajax({
                    url:"/ms/selectSecondProducttype.do",
                    type:"post",
                    contentType:"application/json",
                    data: JSON.stringify(json),
                    success: function (res) {
                        $("#second-type option").remove();
                        for(var i = 0;i<res.length;i++){
                            const name = res[i].typename;
                            typeId2[name] = res[i].tid;
                            const option = $("<option></option>").html(name);
                            $("#second-type").append(option);
                        }
                    }
                });
            }
        });
        //一级分类发生变化
        $("#first-type").on("change", function () {
            $("#second-type option").remove();
            var value = $("#first-type").val();
            var json = {
                tid:typeId[value]
            }
            $.ajax({
                url:"/ms/selectSecondProducttype.do",
                type:"post",
                contentType:"application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    for(var i = 0;i<res.length;i++){
                        const name = res[i].typename;
                        typeId2[name] = res[i].tid;
                        const option = $("<option></option>").html(name);
                        $("#second-type").append(option);
                    }
                }
            });
        });

    });

    //添加分类
    $("#add-type").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".add-type").css("display","block");

        $("#add-type-btn").on("click",function(){
            var json = {
                typename:$("#type-value").val()
            }
            $.ajax({
                url:"/ms/ insertFirstProductType.do",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify(json),
                success:function(res){
                    if(res.code == 1){
                        alert("添加成功");
                    }
                }
            })
        });
    });

    //添加品牌
    $("#add-brands").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".add-brands").css("display","block");

        //获取一级分类列表
        $.ajax({
            url:"/ms/selectAllFirstProducttype.do",
            type:"post",
            contentType:"application/json",
            success:function(res){
                for(var i = 0;i<res.length;i++){
                    const name = res[i].typename;
                    typeId[name] = res[i].tid;
                    const option = $("<option></option>").html(name);
                    $("#first-type2").append(option);
                }
            }
        });

        $("#img-file").on("change", function () {
            for(var i=0;i<this.files.length;i++){
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fd.append(i,this.files[i]);
            }
        });

        $("#sub-brands").on("click", function () {
            var value = $("#first-type2").val();
            var json  ={
                file:fd,
                typename:$("#brands").val(),
                highertid:typeId[value]
            }
            $.ajax({
                url:"/ms/ insertFirstProductType.do",
                type:"post",
                data:json,
                success: function (res) {
                    if(res.code == 1){
                        alert("添加成功");
                    }
                }
            });
        });
    });

    //删除分类
    $("#delete-type").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".delete-type").css("display","block");

        $("#delete-type-btn").on("click", function () {
            var value = $("#delete-input").val();
            var json = {
                tid:typeId[value]
            }
            $.ajax({
                url:"/ms/ deleteFirstProductType.do",
                type:"post",
                data:JSON.stringify(json),
                success: function (res) {
                    if(res.code == 1){
                        alert("删除成功");
                    }
                }
            });
        });
    });

    //删除品牌
    $("#delete-brands").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".delete-brands").css("display","block");

        $("#delete-b-btn").on("click", function () {
            var value = $("#delete-b").val();
            var json = {
                tid:typeId2[value]
            }
            $.ajax({
                url:"/ms/ deleteSecondProductType.do",
                type:"post",
                data:JSON.stringify(json),
                success: function (res) {
                    if(res.code == 1){
                        alert("删除成功");
                    }
                }
            });
        });
    });

    //查看普通商品
    $("#watch-common").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".watch-common-s").css("display","block");
        $("#common-s-select option").remove();

        //获取商家名
        $.ajax({
            url:"/ms/ selectAllDealer.do",
            type:"post",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    var option = $("<option></option>").html(res[i].dname);
                    $("#common-s-select").append(option);
                }
            }
        })

    });

    //删除普通商品
    $("#delete-common").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".delete-common-s").css("display","block");

        $("#delete-common-btn").on("click", function () {
            var json =  {
                sid:$("#delete-common-btn").val()
            }
            $.ajax({
                url:"/ms/deleteProductSize.do",
                type:"post",
                data:JSON.stringify(json),
                success: function (res) {
                    if(res.code == 1){
                        alert("删除成功");
                    }
                }
            })
        });
    });

    //查看合伙人商品
    $("#parents-manage").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
    });

    $("#watch-common").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".watch-content").css("display","block");
        $("#parents-table").remove();

        $.ajax({
            url:"/ms/firstRequest.do",
            type:"post",
            success: function (res) {
                var data = res.products;
                for(var i = 0;i<data.length;i++){
                    var tr = $("<tr class='parents-tr'></tr>");
                    //ID
                    var tdId = $("<td></td>").html(data[i].pid);
                    //合伙人商品名称
                    var tdName = $("<td></td>").html(data[i].pname);
                    //原价
                    var tdo = $("<td></td>").html(data[i].psoriprice);
                    //现价
                    var tdnew = $("<td></td>").html(data[i].pssellprice);
                    $(tr).append(tdId,tdName,tdo,tdnew);
                    $("#parents-table").append(tr);
                }
            }
        })
    });

    //添加合伙人商品
    $("#add-parents").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".add-parents-content").css("display","block");

        $("#add-parents-btn").on("click", function () {
            var arr = [];
            arr[0] = $("#add-parents-text").val();
            $.ajax({
                url:"/ms/ setTogether.do",
                type:"post",
                data:arr,
                success: function (res) {
                    if(res.code == 1){
                        alert("添加成功");
                    }
                }
            })
        });
    });

    //商家管理
    $("#merchant-manage").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
    });

    //查看商家信息
    $("#watch-merchant").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
        $(".watch-merchant").css("display","block");
        $(".watch-merchant--tr").remove();

        //获取商家信息
        $.ajax({
            url:"/ms/selectAllDealer.do",
            type:"post",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    var tr = $("<tr class='watch-merchant--tr'></tr>");
                    //ID
                    var tdId = $("<td></td>").html(res[i].did);
                    //商家名字
                    var tdName = $("<td></td>").html(res[i].dname);
                    //商家账号
                    var tdUsername = $("<td></td>").html(res[i].dusername);
                    //商家密码
                    var tdPwd = $("<td></td>").html(res[i].dpassword);
                    //商家手机号
                    var tdPhonenum = $("<td></td>").html(res[i].dphonenum);
                    //商家地址
                    var tdAddress = $("<td></td>").html(res[i].daddress);
                    $(tr).append(tdId,tdName,tdUsername,tdPwd,tdPhonenum,tdAddress);
                    $("#watch-merchant-table").append(tr);
                }
            }
        })
    });

    //添加商家
    $("#add-merchant").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
        $(".add-merchant").css("display","block");

        $("#add-merchant-btn").on("click", function () {
            var json = {
                dname:$("#merchant-name").val(),
                dusername:$("#merchant-username").val(),
                dpassword:$("#merchant-pwd").val(),
                dphonenum:$("#merchant-phonenumber").val(),
                daddress:$("#merchant-address").val(),
                dpower:"dealer"
            }
            $.ajax({
                url:"/ ms/insertDealer.do",
                type:"post",
                data:JSON.stringify(json),
                success: function (res) {
                    if(res.code == 1){
                        alert("添加成功");
                    }
                }
            });
        });
    });

    //轮播图管理
    $("#lun-manage").on("click", function () {
        $(".item").css("display","none");
        $(".lun-img").css("display","block");
    });

    $("#lun-li").on("click", function () {
        $(".item").css("display","none");
        $(".lun-img").css("display","block");
        $(".lun-content").css("display","block");

        $("#lun-input").on("change", function () {
            for(var i=0;i<this.files.length;i++){
                var input = $("<input type='text' placeholder='请输入图片相对应的商品id' class='pid-input'>");
                $(".pid-content").append(input);
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fdl.append(i,this.files[i]);
            }
        });
        $("#lun-btn").on("click", function () {
            var len = $(".lun-input").length;
            var arr = [];
            for(var i = 0;i<len;i++){
                arr[i] = $($(".lun-input")[i]).val();
            }
            var json = {
                miltipartfile:fdl,
                pid:arr
            }
            $.ajax({
                url:"/ms/insertRollingPic",
                type:"post",
                data:json,
                success: function (res) {
                    if(res.code == 1){
                        alert("轮播图设置成功");
                    }
                }
            })
        });
    });




});