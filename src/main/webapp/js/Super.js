//一级分类id
var typeId = {};
//二级分类id
var typeId2 = {};
//三级分类id
var typeId3 = {};
var pId = {};
//fd
var fd = new FormData();
//轮播图fd
var fdl = new FormData();
var dId = {};
$(function(){
    //头部
    $("#type-manage").on("click",function(){
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $("#watch-type").trigger("click");
    });

    //删除商品
    $("#delete-common-btn").on("click", function () {
        var len = $(".choose-common-checkbox").length;
        var arr = [];
        var index = 0;
        for(var i = 0;i<len;i++){
            if($($(".choose-common-checkbox")[i]).is(":checked")){
                arr[index] =  $($(".s-id")[i]).html();
                index++;
            }
        }
        var json =  {
            sid:arr
        }
        $.ajax({
            url:"/jin321/ms/deleteProductSize.do",
            type:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success: function (res) {
                if(res.code == 1){
                    alert("删除成功");
                    $("#watch-common").trigger("click");
                }
            }
        })
    });

    //左侧查看分类
    $("#watch-type").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".watch-type").css("display","block");
        $(".watch-type-tr").remove();

        //获取分类
        $.ajax({
            url:"/jin321/ms/selectAllProductType.do",
            type:"post",
            contentType:"application/json",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    typeId[res[i].typename] = res[i].tid;
                    var data = res[i].producttype2List;
                    for(var j = 0;j<data.length;j++){
                        typeId2[data[j].producttype2.typename] = data[j].tid;
                        var da = data[j].producttype3List;
                        for(var k = 0;k<da.length;k++){
                            typeId3[da[k].typename] = da[k].tid;
                            var tr = $("<tr class='watch-type-tr'></tr>");
                            var tdR = $("<td></td>");
                            var radio = $("<input class='choose-type' checked='false' name='info' type='radio'>");
                            var tdName = $("<td class='typeanme'></td>").html(res[i].producttype1.typename);
                            var tdName2 = $("<td class='typename2'></td>").html(data[j].producttype2.typename);
                            var tdName3 = $("<td class='typename3'></td>").html(da[k].typename);
                            $(tdR).append(radio);
                            $(tr).append(tdR,tdName,tdName2,tdName3);
                            $("#watch-type-table").append(tr);
                        }
                    }
                }
            }
        });

    });

    //删除分类
    $("#delete-type-btn").on("click", function () {
        var len = $(".choose-type").length;
        var json = {};
        for(var i = 0;i<len;i++){
            if($($(".choose-type")[i]).attr("checked")){
                var value = $($(".typeanme")[i]).html();
                json = {
                    tid:typeId[value]
                }
            }
        }
        $.ajax({
            url:"/jin321/ms/deleteFirstProductType.do",
            type:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success: function (res) {
                if(res.code == 1){
                    alert("删除成功");
                }
            }
        });
    });

    //删除品牌
    $("#delete-b-btn").on("click",function () {
        var len = $(".choose-type").length;
        var json = {};
        for(var i = 0;i<len;i++){
            if($($(".choose-type")[i]).is(":checked")){
                var value = $($(".typename2")[i]).html();
                json = {
                    tid:typeId2[value]
                }
            }
        }
        $.ajax({
            url:"/jin321/ms/deleteSecondProductType.do",
            type:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success:function (res) {
                if(res.code == 1){
                    alert("删除成功");
                }
            }
        })
    });

    //删除种类
    $("#delete-kind").on("click",function () {
        var len = $(".choose-type").length;
        var json = {};
        for(var i = 0;i<len;i++){
            if($($(".choose-type")[i]).is(":checked")){
                var value = $($(".typename3")[i]).html();
                json = {
                    tid:typeId3[value]
                }
            }
        }
        $.ajax({
            url:"/jin321/ms/deleteThridProductType.do",
            type:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success:function (res) {
                if(res.code == 1){
                    alert("删除成功");
                }
            }
        })
    });

    //添加分类
    $("#add-type").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".add-type").css("display","block");
    });

    $("#add-type-btn").on("click",function(){
        var json = {
            typename:$("#type-value").val()
        }
        $.ajax({
            url:"/jin321/ms/insertFirstProductType.do",
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

    //添加品牌
    $("#add-brands").on("click", function () {
        $(".item").css("display","none");
        $(".type-manage").css("display","block");
        $(".add-brands").css("display","block");
        $("#first-type2 option").remove();

        //获取一级分类列表
        $.ajax({
            url:"/jin321/ms/selectAllFirstProducttype.do",
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
    });

    $("#img-file").on("change", function () {
        fd = new FormData();
        for(var i=0;i<this.files.length;i++){
            var reader = new FileReader();
            reader.readAsDataURL(this.files[i]);
            fd.append("file",this.files[i]);
        }
    });

    $("#sub-brands").on("click", function () {
        var value = $("#first-type2").val();
        fd.append("typename",$("#brands").val());
        fd.append("highertid",typeId[value]);
        $.ajax({
            url:"/jin321/ms/insertSecondProductType.do",
            type:"post",
            contentType: false,
            data:fd,
            processData: false,
            cache: false,
            success: function (res) {
                if(res.code == 1){
                    alert("添加成功");
                }
            }
        });
    });

    //添加种类
    $("#add-kinds").on("click",function () {
       $(".item").css("display","none");
       $(".type-manage").css("display","block");
       $(".add-kind").css("display","block");

       $.ajax({
           url:"/jin321/ms/selectAllFirstProducttype.do",
           type:"post",
           contentType:"application/json",
           success:function (res) {
               $("#typea option").remove();
               for(var i = 0;i<res.length;i++){
                   const type1 = res[i].typename;
                   typeId[type1] = res[i].tid;
                   const option = $("<option></option>").text(type1);
                   $("#typea").append(option);
               }
               var data = {
                   tid:res[0].tid
               }
               $.ajax({
                   url:"/jin321/ms/selectSecondProducttype.do",
                   type:"POST",
                   contentType:"application/json",
                   data:JSON.stringify(data),
                   success:function (res) {
                       $("#typeb option").remove();
                       for(var i = 0;i<res.length;i++){
                           const type1 = res[i].typename;
                           typeId2[type1] = res[i].tid;
                           const option = $("<option></option>").text(type1);
                           $("#typeb").append(option);
                       }
                   }
               });
           }
       })
    });

    $("#typea").on("change",function () {
        var value = $("#typea").val();
        var json = {
            tid:typeId[value]
        }
        $.ajax({
            url:"/jin321/ms/selectSecondProducttype.do",
            method:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success:function (res) {
                $("#typeb option").remove();
                for(var i = 0;i<res.length;i++){
                    const type1 = res[i].typename;
                    typeId2[type1] = res[i].tid;
                    const option = $("<option></option>").text(type1);
                    $("#typeb").append(option);
                }
            }
        })
    });

    //添加种类按钮
    $("#add-kind-btn").on("click",function () {
       var value = $("#typeb").val();
       var json = {
           higherid:typeId2[value],
           typename:$("#typec-input").val()
       }
       $.ajax({
           url:"/jin321/ms/insertThirdProductType.do",
           method:"post",
           data:JSON.stringify(json),
           contentType:"application/json",
           success:function (res) {
               if(res.code == 1){
                   alert("添加成功");
               }
           }
       })

    });

    $("#common-s-select").on("change",function () {
        $(".watch-common-tr").remove();
        var json = {
            did:dId[$("#common-s-select").val()]
        }
        $.ajax({
            url:"/jin321/ms/selectProductByDidAdmin.do",
            type:"post",
            data: JSON.stringify(json),
            contentType:"application/json",
            success:function (res) {
                for(var i = 0;i<res.length;i++){
                    var tr = $("<tr class='watch-common-tr'></tr>");
                    var checkbox = $("<input type='checkbox' class='choose-common-checkbox'>");
                    //id
                    const tdId = $("<td class='s-id'></td>").html(res[i].sid);
                    //名称
                    const tdName = $("<td class='s-name'></td>").html(res[i].pname);
                    //介绍
                    const tdPsummary = $("<td class='s-summary'></td>").html(res[i].psummary);
                    //规格
                    const tdSize = $("<td class='size-s'></td>").html(res[i].sizename);
                    //一级分类
                    const tdPtypea = $("<td class='s-typea'></td>").html(res[i].ptypea);
                    //二级分类
                    const tdPtypeb  = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                    //原价
                    const tdPsoriprice = $("<td class='s-psoriprice'></td>").html(res[i].psoriprice);
                    //售价
                    const tdPssellprice = $("<td class='s-pssellprice'></td>").html(res[i].pssellprice);
                    //剩余货物
                    const tdSnumber = $("<td class='s-snumber'></td>").html(res[i].snumber);
                    $(tr).append(checkbox,tdId,tdName,tdPsummary,tdSize,tdPtypea,tdPtypeb,tdPsoriprice,tdPssellprice,tdSnumber,tdSnumber);
                    $("#watch-common-table").append(tr);
                }
                setTimeout(function () {
                    var len = $(".watch-common-tr").length;
                    if(res.length<len){
                        $("#watch-common").trigger("click");
                    }
                },500)
            }
        });
    });

    //查看普通商品
    $("#watch-common").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".watch-common-content").css("display","block");
        $("#common-s-select option").remove();
        $(".watch-common-tr").remove();

        //获取商家名
        $.ajax({
            url:"/jin321/ms/selectAllDealer.do",
            type:"post",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    var option = $("<option></option>").html(res[i].dname);
                    dId[res[i].dname] = res[i].did;
                    $("#common-s-select").append(option);
                }
                var json = {
                    did:dId[$("#common-s-select").val()]
                }
                $.ajax({
                    url:"/jin321/ms/selectProductByDidAdmin.do",
                    type:"post",
                    data: JSON.stringify(json),
                    contentType:"application/json",
                    success:function (res) {
                        for(var i = 0;i<res.length;i++){
                            var tr = $("<tr class='watch-common-tr'></tr>");
                            pId[res[i].pname] = res[i].pid;
                            var tdR = $("<td></td>");
                            var checkbox = $("<input type='checkbox' class='choose-common-checkbox'>");
                            //id
                            const tdId = $("<td class='s-id'></td>").html(res[i].sid);
                            //轮播图id
                            const tdPid = $("<td class='p-id'></td>").html(res[i].pid);
                            //名称
                            const tdName = $("<td class='s-name'></td>").html(res[i].pname);
                            //介绍
                            const tdPsummary = $("<td class='s-summary'></td>").html(res[i].psummary);
                            //规格
                            const tdSize = $("<td class='size-s'></td>").html(res[i].sizename);
                            //一级分类
                            const tdPtypea = $("<td class='s-typea'></td>").html(res[i].ptypea);
                            //二级分类
                            const tdPtypeb  = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                            //三级分类
                            const tdPtypec = $("<td class='s-typec'></td>").html(res[i].ptypec);
                            //原价
                            const tdPsoriprice = $("<td class='s-psoriprice'></td>").html(res[i].psoriprice);
                            //售价
                            const tdPssellprice = $("<td class='s-pssellprice'></td>").html(res[i].pssellprice);
                            //剩余货物
                            const tdSnumber = $("<td class='s-snumber'></td>").html(res[i].snumber);
                            tdR.append(checkbox);
                            $(tr).append(tdR,tdId,tdPid,tdName,tdPsummary,tdSize,tdPtypea,tdPtypeb,tdPtypec,tdPsoriprice,tdPssellprice,tdSnumber,tdSnumber);
                            $("#watch-common-table").append(tr);
                        }
                        setTimeout(function () {
                            var len = $(".watch-common-tr").length;
                            if(res.length<len){
                                $("#watch-common").trigger("click");
                            }
                        },500);
                    }
                });
            }
        })

    });

    //添加合伙人商品
    $("#add-parents-btn").on("click", function () {
        var len = $(".choose-common-checkbox").length;
        var arr = [];
        var index = 0;
        for(var i = 0;i<len;i++){
            if($($(".choose-common-checkbox")[i]).is(":checked")){
                var value = $($(".s-name")[i]).html();
                arr[index] = pId[value]+"";
                index++;
            }
        }
        var json =  {
            pid:arr
        }
        $.ajax({
            url:"/jin321/ms/setTogether.do",
            type:"post",
            data:JSON.stringify(json),
            contentType:"application/json",
            success: function (res) {
                if(res.code == 1){
                    alert("添加成功");
                }
            }
        })
    });

    //查看合伙人商品
    $("#parents-manage").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".parents-tr").remove();
        $("#watch-common").trigger("click");

    });

    $("#watch-parents").on("click", function () {
        $(".item").css("display","none");
        $(".parents-manage").css("display","block");
        $(".watch-content").css("display","block");
        $(".parents-tr").remove();

        $.ajax({
            url:"/jin321/ms/firstRequest.do",
            type:"post",
            success: function (res) {
                $(".parents-tr").remove();
                var data = res.productPos;
                for(var i = 0;i<data.length;i++){
                    var tdR = $("<td></td>");
                    var checkbox = $("<input type='checkbox' checked='false' class='parents-choose'>");
                    var tr = $("<tr class='parents-tr'></tr>");
                    //ID
                    var tdId = $("<td class='parents-id'></td>").html(data[i].pid);
                    //合伙人商品名称
                    var tdName = $("<td></td>").html(data[i].pname);
                    //原价
                    var tdo = $("<td></td>").html(data[i].psoriprice);
                    //现价
                    var tdnew = $("<td></td>").html(data[i].pssellprice);
                    $(tdR).append(checkbox);
                    $(tr).append(tdR,tdId,tdName,tdo,tdnew);
                    $("#parents-table").append(tr);
                }
                var len = $(".parents-tr").length;
                setTimeout(function () {
                    if(res.productPos.length<len){
                        $("#watch-common").trigger("click");
                    }
                },500);
            }
        })
    });

    //删除合伙人商品
    $("#delete-parents-btn").on("click", function () {
        var len = $(".parents-choose").length;
        var arr = [];
        var index = 0;
        for(var i = 0;i<len;i++){
            if($($(".parents-choose")[i]).is(":checked")){
                arr[index] = $($(".parents-id")[i]).html();
                index++;
            }
        }
        var json = {
            pid:arr
        }
        $.ajax({
            url:"/jin321/ms/deleteTogeter.do",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(json),
            success: function (res) {
                if(res.code == 1){
                    alert("删除成功");
                }
            }
        });
    });

    //商家管理
    $("#merchant-manage").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
        $(".watch-merchant-tr").remove();
        $("#watch-merchant").trigger("click");
    });

    //查看商家信息
    $("#watch-merchant").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
        $(".watch-merchant").css("display","block");
        $(".watch-merchant-tr").remove();

        //获取商家信息
        $.ajax({
            url:"/jin321/ms/selectAllDealer.do",
            type:"post",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    var tr = $("<tr class='watch-merchant-tr'></tr>");
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
                setTimeout(function () {
                    var len = $(".watch-merchant-tr").length;
                    if(res.length<len){
                        $("#watch-merchant").trigger("click");
                    }
                },500);
            }
        })
    });

    //添加商家
    $("#add-merchant").on("click", function () {
        $(".item").css("display","none");
        $(".merchant-mange").css("display","block");
        $(".add-merchant").css("display","block");
    });

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
            url:"/jin321/ms/insertDealer.do",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(json),
            success: function (res) {
                if(res.code == 1){
                    alert("添加成功");
                }
            }
        });
    });

    //轮播图管理
    $("#lun-manage").on("click", function () {
        $(".item").css("display","none");
        $(".lun-img").css("display","block");
        $("#lun-li").trigger("click");
    });

    $("#lun-li").on("click", function () {
        $(".item").css("display","none");
        $(".lun-img").css("display","block");
        $(".lun-content").css("display","block");
    });

    $("#lun-input").on("change", function () {
        $(".pid-input").remove();
        fdl = new FormData();
        for(var i=0;i<this.files.length;i++){
            var input = $("<input type='text' placeholder='请输入图片相对应的商品pid' class='pid-input'>");
            var br = $("<br>");
            $(".pid-content").append(input,br);
            var reader = new FileReader();
            reader.readAsDataURL(this.files[i]);
            fdl.append("file",this.files[i]);
        }
    });

    $("#lun-btn").on("click", function () {
        var len = $(".pid-input").length;
        fdl.delete("pid");
        var arr = [];
        for(var i = 0;i<len;i++){
            arr[i] = $($(".pid-input")[i]).val();
        }
        for(var i = 0;i<len;i++){
            fdl.append("pid",arr[i]);
        }
        $.ajax({
            url:"/jin321/ms/insertRollingPic.do",
            type:"post",
            data:fdl,
            contentType: false,
            processData: false,
            cache: false,
            success: function (res) {
                if(res.code == 1){
                    alert("轮播图设置成功");
                }
            }
        })
    });

});