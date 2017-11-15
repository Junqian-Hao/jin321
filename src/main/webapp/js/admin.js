
//存放一级分类id
var Subtype = {};
//存放二级分类id
var Supertype = {};
//存放pid
var pId = [];
//fd传送图片
var fd = new FormData();
//商品详情图片
var fdDeatil = new FormData();

$(function(){
    //商品管理左侧栏
    $("#s-manage").on("click",function(){
        $(".item").css("display","none");
        $(".left-s").css("display","block");
    });

    //商品管理产看和修改商品信息
    $("#watch-s").on("click", function () {
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".watch-s-content").css("display","block");

        $(".s-info-tr").remove();
        //获取商家商品的信息
        $.ajax({
            url:"/ms/getDetail1ByDid.do",
            type:"post",
            contentType:"application/json",
            success: function (res) {
                for(var i = 0;i<res.length;i++){
                    //pId
                    pId[i] = res[i].pid;
                    const tr = $("<tr class='s-info-tr'></tr>");
                    //单选框
                    const radio = $("<input checked='false' name='info' class='info-choose' type='radio'>");
                    //id
                    const tdId = $("<td class='s-id'></td>").html(res[i].sid);
                    //名称
                    const tdName = $("<td class='s-name' contentEditable='true'></td>").html(res[i].pname);
                    //介绍
                    const tdPsummary = $("<td class='s-summary' contentEditable='true'></td>").html(res[i].psummary);
                    //规格
                    const tdSize = $("<td class='size-s' contentEditable='true'></td>").html(res[i].sizename);
                    //一级分类
                    const tdPtypea = $("<td class='s-typea'></td>").html(res[i].ptypea);
                    //二级分类
                    const tdPtypeb  = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                    //原价
                    const tdPsoriprice = $("<td class='s-psoriprice' contentEditable='true'></td>").html(res[i].psoriprice);
                    //售价
                    const tdPssellprice = $("<td class='s-pssellprice' contentEditable='true'></td>").html(res[i].pssellprice);
                    //剩余货物
                    const tdSnumber = $("<td class='s-snumber' contentEditable='true'></td>").html(res[i].snumber);
                    $(tr).append(radio,tdId,tdName,tdPsummary,tdSize,tdPtypea,tdPtypeb,tdPsoriprice,tdPssellprice,tdSnumber,tdSnumber);
                    $("#s-info-table").append(tr);
                }
            }
        })

        //商家更改商品信息
        $("#info-s-btn").on("click", function () {
            var len = $(".info-choose").length;
            for(var i = 0;i<len;i++){
                if($($(".info-choose")[i]).attr("checked")){
                    //id
                    var sid = $($(".s-id")[i]).html();
                    //名字
                    var pname = $($(".s-name")[i]).html();
                    //介绍
                    var psummary = $($(".s-summary")[i]).html();
                    //规格
                    var sizename = $($(".size-s")[i]).html();
                    //原价
                    var psoriprice = $($(".s-psoriprice")[i]).html();
                    //售价
                    var pssellprice = $($(".s-pssellprice")[i]).html();
                    //剩余数量
                    var snumber = $($(".s-snumber")[i]).html();
                    var json = {
                        pid:pId[i],
                        sid:sid,
                        pname:pname,
                        psummary:psummary,
                        sizename:sizename,
                        psoriprice:psoriprice,
                        pssellprice:pssellprice,
                        snumber:snumber
                    }
                    $.ajax({
                       url:"/ms/updateProduct.do",
                        type:"post",
                        contentType:"application/json",
                        data:JSON.stringify(json),
                        success:function(res){

                            if(res.code == 1){
                                alert("修改成功")
                            }
                        }

                    });
                }
            }
        });

    });

    //商品管理添加商品
    $("#add-s").on("click", function () {
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".add-s-content").css("display","block");
        $("#subType option").remove();

        //获取一级分类内容
        $.ajax({
            url:"/ms/selectAllFirstProducttype.do",
            type:"post",
            contentType:"application/json",
            success:function(res){
                $("#subType option").remove();
                for(var i = 0;i<res.length;i++){
                    const type1 = res[i].typename;
                    Subtype[type1] = res[i].tid;
                    const option = $("<option></option>").text(type1);
                    $("#subType").append(option);
                }
                var value = res[0].typename;
                var data = {
                    tid:Subtype[value]
                };
                $.ajax({
                    url:"/ms/selectSecondProducttype.do",
                    type:"POST",
                    contentType:"application/json",
                    data:JSON.stringify(data),
                    success: function (res) {
                        $("#change-typeb option").remove();
                        for(var i = 0;i<res.length;i++){
                            const type1 = res[i].typename;
                            Supertype[type1] = res[i].tid;
                            const option = $("<option></option>").text(type1);
                            $("#change-typeb").append(option);
                        }
                    }
                })
            }
        });

        //一级分类改变时获取二级分类内容
        $("#subType").on("change", function () {
            var value = $("#subType").val();
            var data = {
                tid:Subtype[value]
            };
            $.ajax({
                url:"/ms/selectSecondProducttype.do",
                type:"POST",
                contentType:"application/json",
                data:JSON.stringify(data),
                success: function (res) {
                    $("#supType option").remove();
                    for(var i = 0;i<res.length;i++){
                        const type1 = res[i].typename;
                        Supertype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#supType").append(option);
                    }
                }
            })
        });

        //添加规格的加号按钮
        $("#add-size").on("click", function () {
            var box = $("<div class='size'></div>");
            var labell = $("<label></label>").text("商品规格 ");
            var inputl = $("<input text='type' class='s-size'/>");
            var label2 = $("<label></label>").text("商品进价");
            var input2 = $("<input type='number' class='s-jin'>");
            var label3 = $("<label></label>").text("商品原价 ");
            var input3 = $("<input type='number' class='s-oprice'>");
            var label4 = $("<label></label>").text("商品售价 ");
            var input4 = $("<input type='number' class='s-nprice'>");
            var label5 = $("<label></label>").text("商品数量");
            var input5 = $("<input type='number' class='s-number'>");
            $(box).append(labell,inputl,label2,input2,label3,input3,label4,input4,label5,input5);
            $("#size").append(box);
        });

        //点击添加按钮
        $("#add-s-btn").on("click", function () {
            //var is_together = $("#is-together").val();
            //if(is_together == "不是合伙人商品"){
            //    is_together = 0;
            //}else if(is_together == "是合伙人商品") {
            //    is_together = 1;
            //}else {
            //    is_together = 0;
            //}
            var arr = [];
            for(var i = 0;i<$(".size").length;i++){
                arr[i]  = {
                    pscost:$($(".s-jin")[i]).val(),
                    psoriprice:$($(".s-oprice")[i]).val(),
                    pssellprice:$($(".s-nprice")[i]).val(),
                    sizename:$($(".s-size")[i]).val(),
                    snumber:$($(".s-number")[i]).val()
                }
            }
            var json = {
                product:{
                    pname:$("#s-name").val(),
                    psummary:$("#s-say").val(),
                    ptypea:Subtype[$("#subType").val()],
                    ptypeb:Supertype[$("#supType").val()],
                    is_together:0
                },
                productsizes:arr
            };
            $.ajax({
                url:"/ms/insertProduct.do",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify(json),
                success: function (res) {
                    if(res.code == 1){
                        alert("添加成功");
                    }else {
                        alert("添加失败");
                    }
                }
            })
        });


    });

    //商品管理删除商品
    $("#delete-s").on("click",function(){
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".delete-s-content").css("display","block");

        $("#delete-s-btn").on("click", function () {
            var data = {
                sid:$("#delete-s-id").val()
            }
            $.ajax({
                url:"/ms/deleteProductSize.do",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify(data),
                success: function (res) {
                    if(res.code == 1){
                        alert("删除成功");
                    }else{
                        alert("删除失败");
                    }
                }
            })
        });
    });

    //商品管理

    //商品管理商品图片上传
    $("#upload-s").on("click",function(){
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".upload-s-content").css("display","block");

        $("#file-input").on("change", function () {
            fd = new FormData();
            for(var i=0;i<this.files.length;i++){
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fd.append("file",this.files[i]);　　　　　　　　　
            }
        });

        $("#file-btn").on("click", function () {
            fd.append("pid",$("#file-s-id").val());
            fd.append("header",0);
            $.ajax({
                url:"/ms/productPicUpload.do",
                type:"post",
                contentType: false,
                data:fd,
                processData: false,
                cache: false,
                success: function (res) {
                    if(res.code == 1){
                        alert("上传成功");
                    }
                }
            })
        });

    });

    //商品管理商品详情图片上传
    $("#upload-detail").on("click", function () {
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".upload-s-detail-img").css("display","block");

        $("#file-detail-input").on("click", function () {
            for(var i=0;i<this.files.length;i++){
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fdDeatil.append(i,this.files[i]);
            }
        });

        $("#file-detail-btn").on("click", function () {
            var json = {
                pid:$("#file-s-detail--id").val,
                multipartFile:fdDeatil
            }
            $.ajax({
                url:"/ms/ productDetailUpload.do",
                type:"post",
                data:json,
                success: function (res) {
                    if(res.code == 1){
                        alert("上传成功");
                    }
                }
            })
        });

    });

    //改变商品分类
    $("#change-type").on("click",function () {
        $(".item").css("display","none");
        $(".left-s").css("display","block");
        $(".change-type-content").css("display","block");

        $.ajax({
            url:"/ms/getDetail1ByDid.do",
            type:"post",
            contentType:"application/json",
            success:function (res) {
                for(var i = 0;i<res.length;i++){
                    var name = res[i].pname;
                    pId[name] = res[i].pid;
                    var option = $("<option></option>").html(name);
                    $("#change-type-id").append(option);
                }
            }
        })
        $.ajax({
            url:"/ms/selectAllFirstProducttype.do",
            type:"post",
            contentType:"application/json",
            success:function(res){
                $("#change-typea option").remove();
                for(var i = 0;i<res.length;i++){
                    const type1 = res[i].typename;
                    Subtype[type1] = res[i].tid;
                    const option = $("<option></option>").text(type1);
                    $("#change-typea").append(option);
                }var value = res[0].typename;
                var data = {
                    tid:Subtype[value]
                };
                $.ajax({
                    url:"/ms/selectSecondProducttype.do",
                    type:"POST",
                    contentType:"application/json",
                    data:JSON.stringify(data),
                    success: function (res) {
                        $("#change-typeb option").remove();
                        for(var i = 0;i<res.length;i++){
                            const type1 = res[i].typename;
                            Supertype[type1] = res[i].tid;
                            const option = $("<option></option>").text(type1);
                            $("#change-typeb").append(option);
                        }
                    }
                })


            }
        });

        //一级分类改变时获取二级分类内容
        $("#change-typea").on("change", function () {
            var value = $("#change-typea").val();
            var data = {
                tid:Subtype[value]
            };
            $.ajax({
                url:"/ms/selectSecondProducttype.do",
                type:"POST",
                contentType:"application/json",
                data:JSON.stringify(data),
                success: function (res) {
                    $("#change-typeb option").remove();
                    for(var i = 0;i<res.length;i++){
                        const type1 = res[i].typename;
                        Supertype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#change-typeb").append(option);
                    }
                }
            })
        });
        $("#change-type-btn").on("click",function () {
            var value = $("#change-type-id").val();
            var pid = pId[value];
            var json = {
                pid:pid,
                ptypea:Subtype[$("#change-typea").val()],
                ptypeb:Supertype[$("#change-typeb").val()]
            }
            $.ajax({
                url:"/ms/updateProductOwnType.do",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify(json),
                success:function (res) {
                    if(res.code == 1){
                        alert("修改成功");
                    }
                }
            });
        });

    });

});