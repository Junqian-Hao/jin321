//存放一级分类id
var Subtype = {};
//存放二级分类id
var Supertype = {};
//存放三级id
var thirdType = {};
//存放pid
var pId = [];
//fd传送图片
var fd = new FormData();
//商品详情图片
var fdDeatil = new FormData();
var oid = [];
//是否可以点击
var flag = true;
//商家商品
var detailProduct = {
    totalPages: 1,
    thisPage: 1,
    isdeleted:0
}
//未发货商品
var noSend = {
    totalPages: 1,
    thisPage: 1
}
//未收货商品
var noRec = {
    totalPages: 1,
    thisPage: 1
}
//已收货商品
var already = {
    totalPages: 1,
    thisPage: 1
}

$(function () {
    //bootstrap
    $('.list-group-item').on('click', function () {
        if (flag) {
            $(this).siblings().removeClass('myLiStyle');
            $(this).addClass('myLiStyle');
        }
    })

    //商品管理左侧栏
    $("#s-manage").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".left-s").css("display", "block");
        }
    });

    //商家更改商品信息
    $("#info-s-btn").on("click", function () {
        if (flag) {
            var len = $(".info-choose").length;
            for (var i = 0; i < len; i++) {
                if ($($(".info-choose")[i]).is(":checked")) {
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
                        pid: pId[i],
                        sid: sid,
                        pname: pname,
                        psummary: psummary,
                        sizename: sizename,
                        psoriprice: psoriprice,
                        pssellprice: pssellprice,
                        snumber: snumber
                    }
                }
            }
            $.ajax({
                url: "/jin321/ms/updateProduct.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("修改成功");
                    }
                }

            });
        }
    });

    //删除商品
    $("#delete-s-btn").on("click", function () {
        if (flag) {
            var len = $(".info-choose").length;
            var data = {};
            var arr = [];
            for (var i = 0; i < len; i++) {
                if ($($(".info-choose")[i]).is(":checked")) {
                    arr[0] = $($(".s-id")[i]).html();
                    data = {
                        sid: arr
                    }
                }
            }
            $.ajax({
                url: "/jin321/ms/deleteProductSize.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    } else {
                        alert("删除失败");
                    }
                }
            })
        }
    });

    //上传图片
    $("#file-input").on("change", function () {
        if (flag) {
            fd = new FormData();
            for (var i = 0; i < this.files.length; i++) {
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fd.append("file", this.files[i]);
            }
        }
    });

    $("#file-btn").on("click", function () {
        if (flag) {
            var len = $(".info-choose").length;
            fd.delete("header");
            fd.delete("pid");
            for (var i = 0; i < len; i++) {
                if ($($(".info-choose")[i]).is(":checked")) {
                    fd.append("pid", pId[i]);
                }
            }
            fd.append("header", 0);
            $.ajax({
                url: "/jin321/ms/productPicUpload.do",
                type: "post",
                contentType: false,
                data: fd,
                processData: false,
                cache: false,
                success: function (res) {
                    if (res.code == 1) {
                        alert("上传成功");
                    }
                }
            })
        }
    });

    //上传商品缩略图
    $("#file-suo-btn").on("click", function () {
        if (flag) {
            var len = $(".info-choose").length;
            fd.delete("header");
            fd.delete("pid");
            console.log(fd.get("header"));
            for (var i = 0; i < len; i++) {
                if ($($(".info-choose")[i]).is(":checked")) {
                    fd.append("pid", pId[i]);
                }
            }
            fd.append("header", 1);
            $.ajax({
                url: "/jin321/ms/productPicUpload.do",
                type: "post",
                contentType: false,
                data: fd,
                processData: false,
                cache: false,
                success: function (res) {
                    if (res.code == 1) {
                        alert("上传成功");
                    }
                }
            })
        }
    });

    //上传商品详情图片
    $("#file-detail-btn").on("click", function () {
        if (flag) {
            var len = $(".info-choose").length;
            var data = {};
            fd.delete("header");
            fd.delete("pid");
            console.log(fd.get("header"));
            for (var i = 0; i < len; i++) {
                if ($($(".info-choose")[i]).is(":checked")) {
                    fd.append("pid", pId[i]);
                }
            }
            $.ajax({
                url: "/jin321/ms/productDetailUpload.do",
                type: "post",
                data: fd,
                contentType: false,
                processData: false,
                cache: false,
                success: function (res) {
                    if (res.code == 1) {
                        alert("上传成功");
                    }
                }
            })
        }
    });

    //商品管理查看和修改商品信息
    $("#watch-s").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".left-s").css("display", "block");
            $(".watch-s-content").css("display", "block");

            $(".s-info-tr").remove();
            //获取商家商品的信息
            $.ajax({
                url: "/jin321/ms/getDetail1ByDid.do",
                data: JSON.stringify({
                    pagenum: 10,
                    thispage: detailProduct.thisPage,
                    isdeleted:detailProduct.isdeleted
                }),
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    detailProduct.totalPages = res.totalpage || 1;
                    detailProduct.thisPage = res.thispage || 1;
                    res = res.pagedata || [];
                    for (var i = 0; i < res.length; i++) {
                        //pId
                        pId[i] = res[i].pid;
                        const tr = $("<tr class='s-info-tr'></tr>");
                        //单选框
                        const tdR = $("<td></td>");
                        const radio = $("<input name='info' class='info-choose' type='radio'>");
                        $(tdR).append(radio);
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
                        const tdPtypeb = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                        //三级分类
                        const tdPtypec = $("<td class='s-typec'></td>").html(res[i].ptypec);
                        //原价
                        const tdPsoriprice = $("<td class='s-psoriprice' contentEditable='true'></td>").html(res[i].psoriprice);
                        //售价
                        const tdPssellprice = $("<td class='s-pssellprice' contentEditable='true'></td>").html(res[i].pssellprice);
                        //剩余货物
                        const tdSnumber = $("<td class='s-snumber' contentEditable='true'></td>").html(res[i].snumber);
                        $(tr).append(tdR, tdId, tdName, tdPsummary, tdSize, tdPtypea, tdPtypeb, tdPtypec, tdPsoriprice, tdPssellprice, tdSnumber, tdSnumber);
                        $("#s-info-table").append(tr);
                    }
                    paging($('.infoPaging')[0], {
                        totalPages: detailProduct.totalPages,
                        nowPage: detailProduct.thisPage
                    });
                    $('.infoPaging .page').on('click',function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = detailProduct.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        detailProduct.thisPage = text;
                        $('#watch-s').trigger('click');
                    });
                    $('.infoPaging .prev').on('click',function () {
                        detailProduct.thisPage = detailProduct.thisPage - 1;
                        $('#watch-s').trigger('click');
                    })
                    $('.infoPaging .next').on('click',function () {
                        detailProduct.thisPage = parseInt(detailProduct.thisPage) + 1;
                        $('#watch-s').trigger('click');
                    })
                }
            })
        }
    });

    $('#productSelect').on('change',function () {
       var text = $('#productSelect').val();
       switch (text){
           case '通过审核':
               detailProduct.isdeleted = 0
               break;
           case '待审核':
               detailProduct.isdeleted = 2
               break;
           case '未通过审核':
               detailProduct.isdeleted = 3
               break;
       }
       $('#watch-s').trigger('click');
    });

    //商品管理添加商品
    $("#add-s").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".left-s").css("display", "block");
            $(".add-s-content").css("display", "block");
            $("#subType option").remove();
            $("#thirdType option").remove();

            //获取一级分类内容
            $.ajax({
                url: "/jin321/ms/selectAllFirstProducttype.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    $("#subType option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Subtype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#subType").append(option);
                    }
                    var value = res[0].typename;
                    var data = {
                        tid: Subtype[value]
                    };
                    $.ajax({
                        url: "/jin321/ms/selectSecondProducttype.do",
                        type: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(data),
                        success: function (res) {
                            console.log(res);
                            $("#change-typeb option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                Supertype[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#change-typeb").append(option);
                            }
                            var json = {
                                tid: res[0].tid
                            }
                            $.ajax({
                                url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                                method: "post",
                                contentType: "application/json",
                                data: JSON.stringify(json),
                                success: function (res) {
                                    $("#thirdType option").remove();
                                    for (var i = 0; i < res.length; i++) {
                                        const type1 = res[i].typename;
                                        thirdType[type1] = res[i].tid;
                                        const option = $("<option></option>").text(type1);
                                        $("#thirdType").append(option);
                                    }
                                }
                            });
                        }
                    })
                }
            });
        }
    });

    //一级分类改变时获取二级分类内容
    $("#subType").on("change", function () {
        if (flag) {
            var value = $("#subType").val();
            var data = JSON.stringify({
                tid: Subtype[value]
            });
            $.ajax({
                url: "/jin321/ms/selectSecondProducttype.do",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (res) {
                    $("#supType option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Supertype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#supType").append(option);
                    }
                    var json = {
                        tid: res[0].tid
                    }
                    $.ajax({
                        url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                        method: "post",
                        contentType: "application/json",
                        data: JSON.stringify(json),
                        success: function (res) {
                            $("#thirdType option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                thirdType[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#thirdType").append(option);
                            }
                        }
                    });
                }
            })
        }
    });

    $("#supType").on("change", function () {
        if (flag) {
            var json = {
                tid: Supertype[$("#supType").val()]
            }
            $.ajax({
                url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    $("#thirdType option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        thirdType[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#thirdType").append(option);
                    }
                }
            })
        }
    });

    //添加规格的加号按钮
    $("#add-size").on("click", function () {
        if (flag) {
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
            $(box).append(labell, inputl, label2, input2, label3, input3, label4, input4, label5, input5);
            $("#size").append(box);
        }
    });

    //点击添加按钮
    $("#add-s-btn").on("click", function () {
        if (flag) {
            var arr = [];
            for (var i = 0; i < $(".size").length; i++) {
                arr[i] = {
                    pscost: $($(".s-jin")[i]).val(),
                    psoriprice: $($(".s-oprice")[i]).val(),
                    pssellprice: $($(".s-nprice")[i]).val(),
                    sizename: $($(".s-size")[i]).val(),
                    snumber: $($(".s-number")[i]).val()
                }
            }
            var json = {
                product: {
                    pname: $("#s-name").val(),
                    psummary: $("#s-say").val(),
                    ptypea: Subtype[$("#subType").val()],
                    ptypeb: Supertype[$("#supType").val()],
                    ptypec: thirdType[$("#thirdType").val()],
                    is_together: 0
                },
                productsizes: arr
            };
            $.ajax({
                url: "/jin321/ms/insertProduct.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    } else {
                        alert("添加失败");
                    }
                }
            })
        }
    });

    //改变商品分类
    $("#change-type").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".left-s").css("display", "block");
            $(".change-type-content").css("display", "block");
            $("#change-typea option").remove();
            $("#change-typeb option").remove();
            $("#change-typec option").remove();

            $.ajax({
                url: "/jin321/ms/selectProdutByDid.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    for (var i = 0; i < res.length; i++) {
                        var name = res[i].pname;
                        pId[name] = res[i].pid;
                        var option = $("<option></option>").html(name);
                        $("#change-type-id").append(option);
                    }
                }
            })
            $.ajax({
                url: "/jin321/ms/selectAllFirstProducttype.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    $("#change-typea option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Subtype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#change-typea").append(option);
                    }
                    var value = res[0].typename;
                    var data = {
                        tid: Subtype[value]
                    };
                    $.ajax({
                        url: "/jin321/ms/selectSecondProducttype.do",
                        type: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(data),
                        success: function (res) {
                            $("#change-typeb option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                Supertype[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#change-typeb").append(option);
                            }
                            var json = {
                                tid: res[0].tid
                            }
                            $.ajax({
                                url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                                method: "post",
                                contentType: "application/json",
                                data: JSON.stringify(json),
                                success: function (res) {
                                    $("#change-typec option").remove();
                                    for (var i = 0; i < res.length; i++) {
                                        const type1 = res[i].typename;
                                        thirdType[type1] = res[i].tid;
                                        const option = $("<option></option>").text(type1);
                                        $("#change-typec").append(option);
                                    }
                                }
                            });
                        }
                    });


                }
            });
        }
    });

    //一级分类改变时获取二级分类内容
    $("#change-typea").on("change", function () {
        if (flag) {
            var value = $("#change-typea").val();
            var data = {
                tid: Subtype[value]
            };
            $.ajax({
                url: "/jin321/ms/selectSecondProducttype.do",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (res) {
                    $("#change-typeb option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Supertype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#change-typeb").append(option);
                    }
                    var json = {
                        tid: res[0].tid
                    }
                    $.ajax({
                        url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                        method: "post",
                        contentType: "application/json",
                        data: JSON.stringify(json),
                        success: function (res) {
                            $("#change-typec option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                thirdType[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#change-typec").append(option);
                            }
                        }
                    });
                }
            })
        }
    });

    //二级分类改变三级分类
    $("#change-typeb").on("change", function () {
        if (flag) {
            var json = {
                tid: Supertype[$("#change-typeb").val()]
            }
            $.ajax({
                url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                method: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    $("#change-typec option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        thirdType[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#change-typec").append(option);
                    }
                }
            });
        }
    });

    //点击修改
    $("#change-type-btn").on("click", function () {
        if (flag) {
            var value = $("#change-type-id").val();
            var pid = pId[value];
            var json = {
                pid: pid,
                ptypea: Subtype[$("#change-typea").val()],
                ptypeb: Supertype[$("#change-typeb").val()]
            }
            $.ajax({
                url: "/jin321/ms/updateProductOwnType.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("修改成功");
                    }
                }
            });
        }
    });

    $('#order-manage').on('click', function () {
        if (flag) {
            $('.item').css('display', 'none');
            $('.left-order').css('display', 'block');
        }
    });

    //未发货订单
    $('#noSend').on('click', function () {
        if (flag) {
            $('.item').css('display', 'none');
            $('.left-order').css('display', 'block');
            $('.noSend').css('display', 'block');
            $('.ordertr').remove();

            $.ajax({
                url: '/jin321/ms/getOrderform.do',
                method: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    select: 1,
                    pagenum:10,
                    thispage:noSend.thisPage
                }),
                success: function (res) {
                    noSend.totalPages = res.totalpage || 1;
                    noSend.thisPage = res.thispage || 1;
                    res = res.pagedata || [];
                    for (var i = 0; i < res.length; i++) {
                        for (var j = 0; j < res[i].orderFormProductDetails.length; j++) {
                            oid[i] = res[i].orderform.oid;
                            var tr = $('<tr class="ordertr"></tr>');
                            var checktd = $('<td></td>');
                            var check = $('<input type="checkbox" class="order-check">');
                            //姓名
                            var name = $('<td></td>').html(res[i].useraddress.ubname);
                            //电话
                            var phonenumber = $('<td></td>').html(res[i].useraddress.uphonenum);
                            //地址
                            var address = $('<td></td>').html(res[i].useraddress.uprovince + res[i].useraddress.ucity + res[i].useraddress.uarea + res[i].useraddress.uaddress);
                            //购买产品
                            var product = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pname + res[i].orderFormProductDetails[j].updateProductSizeDetail.sizename);
                            //购买数量
                            var number = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pamount);
                            //购买时间
                            var time = $('<td></td>').html(new Date(res[i].orderform.opaydate).toLocaleString());
                            //买家留言
                            var message = $('<td></td>').html(res[i].orderform.omessage);
                            $(checktd).append(check);
                            $(tr).append(checktd, name, phonenumber, address, product, number, time, message);
                            $('#noSend-table').append(tr);
                        }
                    }
                    paging($('.noSendPaging')[0],{
                        totalPages: noSend.totalPages,
                        nowPage: noSend.thisPage
                    });
                    $('.noSendPaging .page').on('click',function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = noSend.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        noSend.thisPage = text;
                        $('#noSend').trigger('click');
                    })
                    $('.noSendPaging .prev').on('click',function () {
                        noSend.thisPage = noSend.thisPage - 1;
                        $('#noSend').trigger('click');
                    })
                    $('.noSendPaging .next').on('click',function () {
                        noSend.thisPage = parseInt(noSend.thisPage) + 1;
                        $('#noSend').trigger('click');
                    })
                }
            });
        }
    });

    $('#send').on('click', function () {
        if (flag) {
            var check = $('.order-check');
            for (var i = 0; i < check.length; i++) {
                if ($($(".order-check")[i]).is(":checked")) {
                    if (oid[i + 1] != oid[i] && oid[i - 1] != oid[i]) {
                        var id = oid[i];
                        var json = {
                            oid: id,
                            osendmethod: $('#express').val(),
                            osendnumber: ""
                        }
                        $.ajax({
                            url: '/jin321/ms/changeOrderStatue.do',
                            method: "post",
                            contentType: "application/json",
                            data: JSON.stringify(json),
                            success: function (res) {
                                if (res.code == 1) {
                                    alert('发货成功');
                                }
                            }
                        })
                    } else {
                        alert('该用户购买了多个商品 请全部勾选！');
                    }
                }
            }
        }
    });

    //未收货订单
    $('#noRec').on('click', function () {
        if (flag) {
            $('.item').css('display', 'none');
            $('.left-order').css('display', 'block');
            $('.noRec').css('display', 'block');
            $('.ordertr2').remove();

            $.ajax({
                url: '/jin321/ms/getOrderform.do',
                method: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    select: 2,
                    pagenum:10,
                    thispage:noRec.thisPage
                }),
                success: function (res) {
                    noRec.totalPages = res.totalpage || 1;
                    noRec.thisPage = res.thispage || 1;
                    res = res.pagedata || [];
                    for (var i = 0; i < res.length; i++) {
                        for (var j = 0; j < res[i].orderFormProductDetails.length; j++) {
                            var tr = $('<tr class="ordertr2"></tr>');
                            //姓名
                            var name = $('<td></td>').html(res[i].useraddress.ubname);
                            //电话
                            var phonenumber = $('<td></td>').html(res[i].useraddress.uphonenum);
                            //地址
                            var address = $('<td></td>').html(res[i].useraddress.uprovince + res[i].useraddress.ucity + res[i].useraddress.uarea + res[i].useraddress.uaddress);
                            //购买产品
                            var product = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pname + res[i].orderFormProductDetails[j].updateProductSizeDetail.sizename);
                            //购买数量
                            var number = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pname);
                            //购买时间
                            var time = $('<td></td>').html(new Date(res[i].orderform.opaydate).toLocaleString());
                            //买家留言
                            var message = $('<td></td>').html(res[i].orderform.omessage);
                            //快递单号
                            var expressid = $('<td></td>').html(res[i].orderform.osendnumber);
                            //发货时间
                            var sendTime = $('<td></td>').html(new Date(res[i].orderform.osenddate).toLocaleString());
                            $(tr).append(name, phonenumber, address, product, number, time, message, expressid, sendTime);
                            $('#noRec-table').append(tr);
                        }
                    }
                    paging($('.noRecPaging')[0],{
                        totalPages: noRec.totalPages,
                        nowPage: noRec.thisPage
                    });
                    $('.noRecPaging .page').on('click',function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = noRec.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        noRec.thisPage = text;
                        $('#noRec').trigger('click');
                    })
                    $('.noRecPaging .prev').on('click',function () {
                        noRec.thisPage = noRec.thisPage - 1;
                        $('#noRec').trigger('click');
                    })
                    $('.noRecPaging .next').on('click',function () {
                        noRec.thisPage = parseInt(noRec.thisPage) + 1;
                        $('#noRec').trigger('click');
                    })

                }
            });
        }
    });


    //已收货订单
    $('#already').on('click', function () {
        if (flag) {
            $('.item').css('display', 'none');
            $('.left-order').css('display', 'block');
            $('.already').css('display', 'block');
            $('.ordertr3').remove();

            $.ajax({
                url: '/jin321/ms/getOrderform.do',
                method: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    select: 3,
                    pagenum:10,
                    thispage:already.thisPage
                }),
                success: function (res) {
                    already.totalPages = res.totalpage || 1;
                    already.thisPage = res.thispage || 1;
                    res = res.pagedata || [];

                    for (var i = 0; i < res.length; i++) {
                        for (var j = 0; j < res[i].orderFormProductDetails.length; j++) {
                            var tr = $('<tr class="ordertr3"></tr>');
                            //姓名
                            var name = $('<td></td>').html(res[i].useraddress.ubname);
                            //电话
                            var phonenumber = $('<td></td>').html(res[i].useraddress.uphonenum);
                            //地址
                            var address = $('<td></td>').html(res[i].useraddress.uprovince + res[i].useraddress.ucity + res[i].useraddress.uarea + res[i].useraddress.uaddress);
                            //购买产品
                            var product = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pname + res[i].orderFormProductDetails[j].updateProductSizeDetail.sizename);
                            //购买数量
                            var number = $('<td></td>').html(res[i].orderFormProductDetails[j].updateProductSizeDetail.pname);
                            //购买时间
                            var time = $('<td></td>').html(new Date(res[i].orderform.opaydate).toLocaleString());
                            //买家留言
                            var message = $('<td></td>').html(res[i].orderform.omessage);
                            $(tr).append(name, phonenumber, address, product, number, time, message);
                            $('#already-table').append(tr);
                        }
                    }
                    paging($('.alreadyPaging')[0],{
                        totalPages: already.totalPages,
                        nowPage: already.thisPage
                    });
                    $('.alreadyPaging .page').on('click',function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = already.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        already.thisPage = text;
                        $('#already').trigger('click');
                    })
                    $('.alreadyPaging .prev').on('click',function () {
                        already.thisPage = already.thisPage - 1;
                        $('#already').trigger('click');
                    })
                    $('.alreadyPaging .next').on('click',function () {
                        already.thisPage = parseInt(already.thisPage) + 1;
                        $('#already').trigger('click');
                    })

                }
            });
        }
    });

    //点击频率设置
    $('li').on('click', function () {
        flag = false;
        setTimeout(function () {
            flag = true
        }, 200)
    });

});