//一级分类id
var typeId = {};
//二级分类id
var typeId2 = {};
//三级分类id
var typeId3 = {};

var Subtype = {};

var Supertype = {};

var thirdType = {};
var pId = {};
//fd
var fd = new FormData();
//轮播图fd
var fdl = new FormData();
var dId = {};
//是否可以点击
var flag = true;

var allType = {
    totalPages: 1,
    thisPage: 1
}

var commonProduct = {
    totalPages: 1,
    thisPage: 1
}

var dealer = {
    totalPages: 1,
    thisPage: 1
}

var money = {
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
    });

    //头部
    $("#type-manage").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".type-manage").css("display", "block");
            $("#watch-type").trigger("click");
        }
    });

    //删除商品
    $("#delete-common-btn").on("click", function () {
        if (flag) {
            var len = $(".choose-common-checkbox").length;
            var arr = [];
            var index = 0;
            for (var i = 0; i < len; i++) {
                if ($($(".choose-common-checkbox")[i]).is(":checked")) {
                    arr[index] = $($(".s-id")[i]).html();
                    index++;
                }
            }
            var json = {
                sid: arr
            }
            $.ajax({
                url: "/jin321/ms/deleteProductSize.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                        $("#watch-common").trigger("click");
                    }
                }
            })
        }
    });

    //左侧查看分类
    $("#watch-type").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".type-manage").css("display", "block");
            $(".watch-type").css("display", "block");
            $(".watch-type-tr").remove();

            //获取分类
            $.ajax({
                url: "/jin321/ms/selectAllProductType.do",
                data: JSON.stringify({
                    pagenum: 10,
                    thispage: allType.thisPage
                }),
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    allType.totalPages = res.totalpag || 1;
                    allType.thisPage = res.thispage || 1;
                    res = res.pagedata || [];

                    for (var i = 0; i < res.length; i++) {
                        typeId[res[i].producttype1.typename] = res[i].producttype1.tid;
                        var data = res[i].producttype2List.length > 0 ? res[i].producttype2List : [{
                            producttype2:{
                                typename:'无',
                                tid:-1
                            },
                            producttype3List:[{
                                typename:'无',
                                tid:-1
                            }]
                        }];
                        for (var j = 0; j < data.length; j++) {
                            if (data[j].producttype2.tid) {
                                typeId2[data[j].producttype2.typename] = data[j].producttype2.tid;
                            }
                            var da = data[j].producttype3List.length > 0 ? data[j].producttype3List : [{
                                typename:'无',
                                tid:-1
                            }];
                            for (var k = 0; k < da.length; k++) {
                                if (da[k].tid) {
                                    typeId3[da[k].typename] = da[k].tid;
                                }
                                var tr = $("<tr class='watch-type-tr'></tr>");
                                var tdR = $("<td></td>");
                                var radio = $("<input class='choose-type' checked='false' name='info' type='radio'>");
                                var a = res[i].producttype1.typename || '无';
                                var tdName = $("<td class='typeanme'></td>").html(a);
                                var b = data[j].producttype2.typename || '无';
                                var tdName2 = $("<td class='typename2'></td>").html(b);
                                var c = da[k].typename || '无';
                                var tdName3 = $("<td class='typename3'></td>").html(c);
                                $(tdR).append(radio);
                                $(tr).append(tdR, tdName, tdName2, tdName3);
                                $("#watch-type-table").append(tr);
                            }
                        }
                    }
                    paging($('.watchTypePaging')[0], {
                        totalPages: allType.totalPages,
                        nowPage: allType.thisPage
                    });
                    $('.watchTypePaging .page').on('click', function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = allType.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        allType.thisPage = text;
                        $('#watch-type').trigger('click');
                    })
                    $('.watchTypePaging .prev').on('click', function () {
                        allType.thisPage = allType.thisPage - 1;
                        $('#watch-type').trigger('click');
                    })
                    $('.watchTypePaging .next').on('click', function () {
                        allType.thisPage = parseInt(allType.thisPage) + 1;
                        $('#watch-type').trigger('click');
                    })

                }
            });
        }

    });

    //删除分类
    $("#delete-type-btn").on("click", function () {
        if (flag) {
            console.log(typeId)
            var len = $(".choose-type").length;
            var json = {};
            for (var i = 0; i < len; i++) {
                if ($($(".choose-type")[i]).attr("checked")) {
                    var value = $($(".typeanme")[i]).html();
                    json = {
                        tid: typeId[value]
                    }
                }
            }
            $.ajax({
                url: "/jin321/ms/deleteFirstProductType.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    }
                }
            });
        }
    });

    //删除品牌
    $("#delete-b-btn").on("click", function () {
        if (flag) {
            console.log(typeId2)
            var len = $(".choose-type").length;
            var json = {};
            for (var i = 0; i < len; i++) {
                if ($($(".choose-type")[i]).is(":checked")) {
                    var value = $($(".typename2")[i]).html();
                    json = {
                        tid: typeId2[value]
                    }
                }
            }
            $.ajax({
                url: "/jin321/ms/deleteSecondProductType.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    }
                }
            })
        }
    });

    //删除种类
    $("#delete-kind").on("click", function () {
        if (flag) {
            var len = $(".choose-type").length;
            var json = {};
            for (var i = 0; i < len; i++) {
                if ($($(".choose-type")[i]).is(":checked")) {
                    var value = $($(".typename3")[i]).html();
                    json = {
                        tid: typeId3[value]
                    }
                }
            }
            $.ajax({
                url: "/jin321/ms/deleteThridProductType.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    }
                }
            })
        }
    });

    //添加分类
    $("#add-type").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".type-manage").css("display", "block");
            $(".add-type").css("display", "block");
        }
    });

    $("#add-type-btn").on("click", function () {
        if (flag) {
            var json = {
                typename: $("#type-value").val()
            }
            $.ajax({
                url: "/jin321/ms/insertFirstProductType.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    }
                }
            })
        }
    });

    //添加品牌
    $("#add-brands").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".type-manage").css("display", "block");
            $(".add-brands").css("display", "block");
            $("#first-type2 option").remove();

            //获取一级分类列表
            $.ajax({
                url: "/jin321/ms/selectAllFirstProducttype.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    for (var i = 0; i < res.length; i++) {
                        const name = res[i].typename;
                        typeId[name] = res[i].tid;
                        const option = $("<option></option>").html(name);
                        $("#first-type2").append(option);
                    }
                }
            });
        }
    });

    $("#img-file").on("change", function () {
        if (flag) {
            fd = new FormData();
            for (var i = 0; i < this.files.length; i++) {
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fd.append("file", this.files[i]);
            }
        }
    });

    $("#sub-brands").on("click", function () {
        if (flag) {
            var value = $("#first-type2").val();
            fd.append("typename", $("#brands").val());
            fd.append("highertid", typeId[value]);
            $.ajax({
                url: "/jin321/ms/insertSecondProductType.do",
                type: "post",
                contentType: false,
                data: fd,
                processData: false,
                cache: false,
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    }
                }
            });
        }
    });

    //添加种类
    $("#add-kinds").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".type-manage").css("display", "block");
            $(".add-kind").css("display", "block");

            $.ajax({
                url: "/jin321/ms/selectAllFirstProducttype.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    $("#typea option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        typeId[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#typea").append(option);
                    }
                    var data = {
                        tid: res[0].tid
                    }
                    $.ajax({
                        url: "/jin321/ms/selectSecondProducttype.do",
                        type: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(data),
                        success: function (res) {
                            $("#typeb option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                typeId2[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#typeb").append(option);
                            }
                        }
                    });
                }
            })
        }
    });

    $("#typea").on("change", function () {
        if (flag) {
            var value = $("#typea").val();
            var json = {
                tid: typeId[value]
            }
            $.ajax({
                url: "/jin321/ms/selectSecondProducttype.do",
                method: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    $("#typeb option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        typeId2[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#typeb").append(option);
                    }
                }
            })
        }
    });

    //添加种类按钮
    $("#add-kind-btn").on("click", function () {
        if (flag) {
            var value = $("#typeb").val();
            var json = {
                higherid: typeId2[value],
                typename: $("#typec-input").val()
            }
            $.ajax({
                url: "/jin321/ms/insertThirdProductType.do",
                method: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    }
                }
            })
        }

    });

    $("#common-s-select").on("change", function () {
        if (flag) {
            $(".watch-common-tr").remove();
            var json = {
                did: dId[$("#common-s-select").val()],
                pagenum: 10,
                thispage: commonProduct.thisPage
            }
            $.ajax({
                url: "/jin321/ms/selectProductByDidAdmin.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    commonProduct.totalPages = res.totalpage || 1;
                    commonProduct.thisPage = res.thispage || 1;
                    res = res.pagedata || [];

                    for (var i = 0; i < res.length; i++) {
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
                        const tdPtypeb = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                        //原价
                        const tdPsoriprice = $("<td class='s-psoriprice'></td>").html(res[i].psoriprice);
                        //售价
                        const tdPssellprice = $("<td class='s-pssellprice'></td>").html(res[i].pssellprice);
                        //剩余货物
                        const tdSnumber = $("<td class='s-snumber'></td>").html(res[i].snumber);
                        $(tr).append(checkbox, tdId, tdName, tdPsummary, tdSize, tdPtypea, tdPtypeb, tdPsoriprice, tdPssellprice, tdSnumber, tdSnumber);
                        $("#watch-common-table").append(tr);
                    }
                    setTimeout(function () {
                        var len = $(".watch-common-tr").length;
                        if (res.length < len) {
                            $("#watch-common").trigger("click");
                        }
                    }, 500);
                    paging($('.watchCommonPaging')[0], {
                        totalPages: commonProduct.totalPages,
                        nowPage: commonProduct.thisPage
                    })
                    $('.watchCommonPaging .page').on('click', function () {
                        var text = '';
                        switch($(this).text()){
                            case '末页':
                                text = commonProduct.totalPages
                                break;
                            case '首页':
                                text = 1
                                break;
                            default:
                                text = this.text
                        }
                        commonProduct.thisPage = text;
                        $('#watch-common').trigger('click');
                    })
                    $('.watchCommonPaging .prev').on('click', function () {
                        commonProduct.thisPage = commonProduct.thisPage - 1;
                        $('#watch-common').trigger('click');
                    })
                    $('.watchCommonPaging .next').on('click', function () {
                        commonProduct.thisPage = parseInt(commonProduct.thisPage) + 1;
                        $('#watch-common').trigger('click');
                    })
                }
            });
        }
    });

    //查看普通商品
    $("#watch-common").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".parents-manage").css("display", "block");
            $(".watch-common-content").css("display", "block");
            $("#common-s-select option").remove();
            $(".watch-common-tr").remove();

            $.ajax({
                url: "/jin321/ms/selectAllFirstProducttype.do",
                type: "post",
                contentType: "application/json",
                success: function (res) {
                    $("#common-s-select1 option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Subtype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#common-s-select1").append(option);
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
                            $("#common-s-select2 option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                Supertype[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#common-s-select2").append(option);
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
                                    $("#common-s-select3 option").remove();
                                    for (var i = 0; i < res.length; i++) {
                                        const type1 = res[i].typename;
                                        thirdType[type1] = res[i].tid;
                                        const option = $("<option></option>").text(type1);
                                        $("#common-s-select3").append(option);
                                    }
                                    var json = {
                                        did: dId[$("#common-s-select").val()],
                                        ptypea: Subtype[$('#common-s-select1').val()],
                                        ptypeb: Supertype[$('#common-s-select2').val()],
                                        ptypec: thirdType[$('#common-s-select3').val()],
                                        pagenum: 10,
                                        thispage: commonProduct.thisPage,
                                        isdeleted:0
                                    }
                                    $.ajax({
                                        url: "/jin321/ms//selectProductByDidAdmin.do",
                                        type: "post",
                                        data: JSON.stringify(json),
                                        contentType: "application/json",
                                        success: function (res) {
                                            commonProduct.totalPages = res.totalpage || 1;
                                            commonProduct.thisPage = res.thispage || 1;
                                            res = res.pagedata || [];

                                            for (var i = 0; i < res.length; i++) {
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
                                                const tdPtypeb = $("<td class='s-typeb'></td>").html(res[i].ptypeb);
                                                //三级分类
                                                const tdPtypec = $("<td class='s-typec'></td>").html(res[i].ptypec);
                                                //原价
                                                const tdPsoriprice = $("<td class='s-psoriprice'></td>").html(res[i].psoriprice);
                                                //售价
                                                const tdPssellprice = $("<td class='s-pssellprice'></td>").html(res[i].pssellprice);
                                                //剩余货物
                                                const tdSnumber = $("<td class='s-snumber'></td>").html(res[i].snumber);
                                                tdR.append(checkbox);
                                                $(tr).append(tdR, tdId, tdPid, tdName, tdPsummary, tdSize, tdPtypea, tdPtypeb, tdPtypec, tdPsoriprice, tdPssellprice, tdSnumber, tdSnumber);
                                                $("#watch-common-table").append(tr);
                                            }
                                            paging($('.watchCommonPaging')[0], {
                                                totalPages: commonProduct.totalPages,
                                                nowPage: commonProduct.thisPage
                                            })
                                            $('.watchCommonPaging .page').on('click', function () {
                                                var text = '';
                                                switch($(this).text()){
                                                    case '末页':
                                                        text = commonProduct.totalPages
                                                        break;
                                                    case '首页':
                                                        text = 1
                                                        break;
                                                    default:
                                                        text = this.text
                                                }
                                                commonProduct.thisPage = text;
                                                $('#watch-common').trigger('click');
                                            })
                                            $('.watchCommonPaging .prev').on('click', function () {
                                                commonProduct.thisPage = commonProduct.thisPage - 1;
                                                $('#watch-common').trigger('click');
                                            })
                                            $('.watchCommonPaging .next').on('click', function () {
                                                commonProduct.thisPage = parseInt(commonProduct.thisPage) + 1;
                                                $('#watch-common').trigger('click');
                                            })

                                        }
                                    });
                                }
                            });
                        }
                    });


                }
            });



            // //获取商家名
            // $.ajax({
            //     url: "/jin321/ms/selectAllDealerName.do",
            //     type: "post",
            //     success: function (res) {
            //         if ($("#common-s-select").val()) {
            //
            //         } else {
            //             for (var i = 0; i < res.length; i++) {
            //                 var option = $("<option></option>").html(res[i].dname);
            //                 dId[res[i].dname] = res[i].did;
            //                 $("#common-s-select").append(option);
            //             }
            //         }
            //
            //     }
            // })
        }
    });

    //一级分类改变时获取二级分类内容
    $("#common-s-select1").on("change", function () {
        if (flag) {
            var value = $("#common-s-select1").val();
            var data = {
                tid: Subtype[value]
            };
            $.ajax({
                url: "/jin321/ms/selectSecondProducttype.do",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (res) {
                    $("#common-s-select2 option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        Supertype[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#common-s-select2").append(option);
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
                            $("#common-s-select3 option").remove();
                            for (var i = 0; i < res.length; i++) {
                                const type1 = res[i].typename;
                                thirdType[type1] = res[i].tid;
                                const option = $("<option></option>").text(type1);
                                $("#common-s-select3").append(option);
                            }
                        }
                    });
                }
            })
        }
    });

    //二级分类改变三级分类
    $("#common-s-select2").on("change", function () {
        if (flag) {
            var json = {
                tid: Supertype[$("#common-s-select2").val()]
            }
            $.ajax({
                url: "/jin321/ms/selectThirdProductTypeByhightid.do",
                method: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    $("#common-s-select3 option").remove();
                    for (var i = 0; i < res.length; i++) {
                        const type1 = res[i].typename;
                        thirdType[type1] = res[i].tid;
                        const option = $("<option></option>").text(type1);
                        $("#common-s-select3").append(option);
                    }
                }
            });
        }
    });

    //查看热卖商品
    $("#watch-hot-sale").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".parents-manage").css("display", "block");
            $(".watch-hot-content").css("display", "block");
            $(".hot-tr").remove();

            $.ajax({
                url: "/jin321/ms/firstRequest.do",
                type: "post",
                success: function (res) {
                    var data = res.timeproducs;
                    for (var i = 0; i < data.length; i++) {
                        var tr = $("<tr class='hot-tr'></tr>");
                        var tdR = $("<td></td>");
                        var check = $("<input type='checkbox' class='choose-hot'>");
                        var tdId = $("<td class='hot-id'></td>").html(data[i].tpid);
                        var tdName = $("<td></td>").html(data[i].products.pname);
                        var tdPsoriprice = $("<td></td>").html(data[i].psoriprice);
                        var tdPssellprice = $("<td></td>").html(data[i].pssellprice);
                        $(tdR).append(check);
                        $(tr).append(tdR, tdId, tdName, tdPsoriprice, tdPssellprice);
                        $("#hot-table").append(tr);
                    }
                }
            });
        }
    });

    //添加热卖商品
    $("#add-hot-sale").on("click", function () {
        if (flag) {
            var len = $(".choose-common-checkbox").length;
            var arr = [];
            var index = 0;
            for (var i = 0; i < len; i++) {
                if ($($(".choose-common-checkbox")[i]).is(":checked")) {
                    var value = $($(".s-name")[i]).html();
                    arr[index] = pId[value];
                    index++;
                }
            }
            var json = {
                pid: arr
            }
            $.ajax({
                url: "/jin321/ms/createTimeproduct.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    }
                }
            })
        }
    });

    //删除热卖商品
    $("#delete-hot-btn").on("click", function () {
        if (flag) {
            var len = $(".choose-hot").length;
            var arr = [];
            var index = 0;
            for (var i = 0; i < len; i++) {
                if ($($(".choose-hot")[i]).is(":checked")) {
                    var value = $($(".hot-id")[i]).html();
                    arr[index] = value - 0;
                    index++;
                }
            }
            var json = {
                tpid: arr
            }
            $.ajax({
                url: "/jin321/ms/deleteTimeProduct.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    }
                }
            })
        }
    });

    //添加合伙人商品
    $("#add-parents-btn").on("click", function () {
        if (flag) {
            var len = $(".choose-common-checkbox").length;
            var arr = [];
            var index = 0;
            for (var i = 0; i < len; i++) {
                if ($($(".choose-common-checkbox")[i]).is(":checked")) {
                    var value = $($(".s-name")[i]).html();
                    arr[index] = pId[value] + "";
                    index++;
                }
            }
            var json = {
                pid: arr
            }
            $.ajax({
                url: "/jin321/ms/setTogether.do",
                type: "post",
                data: JSON.stringify(json),
                contentType: "application/json",
                success: function (res) {
                    if (res.code == 1) {
                        alert("添加成功");
                    }
                }
            })
        }
    });

    //查看合伙人商品
    $("#parents-manage").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".parents-manage").css("display", "block");
            $(".parents-tr").remove();
            $("#watch-common").trigger("click");
        }
    });

    $("#watch-parents").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".parents-manage").css("display", "block");
            $(".watch-content").css("display", "block");
            $(".parents-tr").remove();

            $.ajax({
                url: "/jin321/ms/firstRequest.do",
                type: "post",
                success: function (res) {
                    $(".parents-tr").remove();
                    var data = res.productPos;
                    for (var i = 0; i < data.length; i++) {
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
                        $(tr).append(tdR, tdId, tdName, tdo, tdnew);
                        $("#parents-table").append(tr);
                    }
                }
            })
        }
    });

    //删除合伙人商品
    $("#delete-parents-btn").on("click", function () {
        if (flag) {
            var len = $(".parents-choose").length;
            var arr = [];
            var index = 0;
            for (var i = 0; i < len; i++) {
                if ($($(".parents-choose")[i]).is(":checked")) {
                    arr[index] = $($(".parents-id")[i]).html();
                    index++;
                }
            }
            var json = {
                pid: arr
            }
            $.ajax({
                url: "/jin321/ms/deleteTogeter.do",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(json),
                success: function (res) {
                    if (res.code == 1) {
                        alert("删除成功");
                    }
                }
            });
        }
    });

    // //商家管理
    // $("#merchant-manage").on("click", function () {
    //     if (flag) {
    //         $(".item").css("display", "none");
    //         $(".merchant-mange").css("display", "block");
    //         $(".watch-merchant-tr").remove();
    //         $("#watch-merchant").trigger("click");
    //     }
    // });
    //
    // //添加商家
    // $("#add-merchant").on("click", function () {
    //     if (flag) {
    //         $(".item").css("display", "none");
    //         $(".merchant-mange").css("display", "block");
    //         $(".add-merchant").css("display", "block");
    //     }
    // });
    //
    // $("#add-merchant-btn").on("click", function () {
    //     if (flag) {
    //         var json = {
    //             dname: $("#merchant-name").val(),
    //             dusername: $("#merchant-username").val(),
    //             dpassword: $("#merchant-pwd").val(),
    //             dphonenum: $("#merchant-phonenumber").val(),
    //             daddress: $("#merchant-address").val(),
    //             dpower: "dealer"
    //         }
    //         $.ajax({
    //             url: "/jin321/ms/insertDealer.do",
    //             type: "post",
    //             contentType: "application/json",
    //             data: JSON.stringify(json),
    //             success: function (res) {
    //                 if (res.code == 1) {
    //                     alert("添加成功");
    //                 }
    //             }
    //         });
    //     }
    // });

    //轮播图管理
    $("#lun-manage").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".lun-img").css("display", "block");
            $("#lun-li").trigger("click");
        }
    });

    $("#lun-li").on("click", function () {
        if (flag) {
            $(".item").css("display", "none");
            $(".lun-img").css("display", "block");
            $(".lun-content").css("display", "block");
        }
    });

    $("#lun-input").on("change", function () {
        if (flag) {
            $(".pid-input").remove();
            fdl = new FormData();
            for (var i = 0; i < this.files.length; i++) {
                var input = $("<input type='text' placeholder='请输入图片相对应的商品pid' class='pid-input'>");
                var br = $("<br>");
                $(".pid-content").append(input, br);
                var reader = new FileReader();
                reader.readAsDataURL(this.files[i]);
                fdl.append("file", this.files[i]);
            }
        }
    });

    $("#lun-btn").on("click", function () {
        if (flag) {
            var len = $(".pid-input").length;
            fdl.delete("pid");
            var arr = [];
            for (var i = 0; i < len; i++) {
                arr[i] = $($(".pid-input")[i]).val();
            }
            for (var i = 0; i < len; i++) {
                fdl.append("pid", arr[i]);
            }
            var lay = $("<div class='black-overlay'></div>");
            $(".content").append(lay);
            $.ajax({
                url: "/jin321/ms/insertRollingPic.do",
                type: "post",
                data: fdl,
                contentType: false,
                processData: false,
                cache: false,
                success: function (res) {
                    $(".black-overlay").remove();
                    if (res.code == 1) {
                        alert("轮播图设置成功");
                    }
                }
            })
        }
    });

    $('#money-manage').on('click', function () {
        $('.item').css('display', 'none');
        $('.money').css('display', 'block');
        $('.watch-money').css('display', 'block');


        $.ajax({
            url: '/jin321/ms/showCommisions.do',
            data: JSON.stringify({
                pagenum: 10,
                thispage: money.thisPage
            }),
            type: 'POST',
            contentType: 'application/json',
            success: function (res) {
                $('.moneyTr').remove();
                money.totalPages = res.totalpage || 1;
                money.thisPage = res.thispage || 1;
                res = res.pagedata || [];

                for (var i = 0; i < res.length; i++) {
                    var tr = $('<tr class="moneyTr"></tr>');
                    //名字
                    var tdName = $('<td></td>').html(res[i].uid);
                    //金额
                    var tdPaynum = $('<td></td>').html(res[i].tdPaynum);
                    //成为会员时间
                    var tdTime = $('<td></td>').html(new Date(res[i].paydate).toLocaleString());
                    //佣金记录
                    var tdMessage = $('<td></td>').html(res[i].paymsg);
                    $(tr).append(tdName,tdPaynum,tdTime,tdMessage);
                    $('#moneyTable').append(tr);
                }
                paging($('.moneyPaging')[0], {
                    totalPages: money.totalPages,
                    nowPage: money.thisPage
                });
                $('.moneyPaging .page').on('click', function () {
                    var text = '';
                    switch($(this).text()){
                        case '末页':
                            text = money.totalPages
                            break;
                        case '首页':
                            text = 1
                            break;
                        default:
                            text = this.text
                    }
                    money.thisPage = text;
                    $('#money-li').trigger('click');
                })
                $('.moneyPaging .prev').on('click', function () {
                    money.thisPage = money.thisPage - 1;
                    $('#money-li').trigger('click');
                })
                $('.moneyPaging .next').on('click', function () {
                    money.thisPage = parseInt(money.thisPage) + 1;
                    $('#money-li').trigger('click');
                })


            }
        });
    });

    //点击频率设置
    $('li').on('click', function () {
        flag = false;
        setTimeout(function () {
            flag = true
        }, 200)
    });


    //秒杀管理
    // $("#time-kill-manage").on("click", function () {
    //     $(".item").css("display","none");
    //     $(".time-kill").css("display","block");
    //     $(".time-kill-content").css("display","block");
    //     $("#time-kill").trigger("click");
    // });
    //
    // //查看秒杀
    // $("#time-kill").on("click", function () {
    //     $(".item").css("display","none");
    //     $(".time-kill").css("display","block");
    //     $(".time-kill-content").css("display","block");
    //     $(".kill-tr").remove();
    //
    //     $.ajax({
    //         url:"/jin321/ms/firstRequest.do",
    //         method:"post",
    //         success: function (res) {
    //             for(var i = 0;i < res.timeproducs.length;i++){
    //                 var tr = $("<tr class='kill-tr'></tr>");
    //                 //选择
    //                 var tdR = $("<td></td>");
    //                 var check = $("<input class='kill-check' type='checkbox'>")
    //                 ///id
    //                 var tdId = $("<td class='kill-id'></td>").html(res.timeproducs[i].tpid);
    //                 //名称
    //                 var tdName = $("<td></td>").html(res.timeproducs[i].products.pname);
    //                 //原价
    //                 var tdPsoriprice = $("<td></td>").html(res.timeproducs[i].psoriprice);
    //                 //售价
    //                 var tdPssellprice = $("<td></td>").html(res.timeproducs[i].pssellprice);
    //                 $(tdR).append(check);
    //                 $(tr).append(tdR,tdId,tdName,tdPsoriprice,tdPssellprice);
    //                 $("#time-kill-table").append(tr);
    //             }
    //         }
    //     })
    // });

    //删除秒杀
    // $("#time-kill-btn").on("click", function () {
    //     var len = $(".kill-tr").length;
    //     var arr = [];
    //     var index = 0;
    //     for(var i = 0;i<len;i++){
    //         if($($(".kill-check")[i]).is(":checked")){
    //             arr[index] = $($(".kill-id")[i]).html()-0;
    //             index++;
    //         }
    //     }
    //     var json = {
    //         tpid:arr
    //     }
    //     $.ajax({
    //         url:"/jin321/ms/deleteTimeProduct.do",
    //         method:"post",
    //         contentType:"application/json",
    //         data:JSON.stringify(json),
    //         success: function (res) {
    //             if(res.code == 1){
    //                 alert("删除成功");
    //                 $("#time-kill").trigger("click");
    //             }
    //         }
    //     })
    // });

    //添加秒杀
    // $("#time-add").on("click", function () {
    //     $(".item").css("display","none");
    //     $(".time-kill").css("display","block");
    //     $(".add-time-kill").css("display","block");
    // });
    // $("#add-time-kill").on("click",function(){
    //     var start = new Date($("#time-start").val()).getTime();
    //     var end = new Date($("#time-end").val()).getTime();
    //     var json = {
    //         pid:$("#time-text").val(),
    //         timestart:start,
    //         timeend:end
    //     }
    //     $.ajax({
    //         url:"/jin321/ms/createTimeproduct.do",
    //         method:"post",
    //         contentType:"application/json",
    //         data:JSON.stringify(json),
    //         success: function (res) {
    //             if(res.code == 1){
    //                 alert("添加成功");
    //             }
    //         }
    //     });
    // });
});

