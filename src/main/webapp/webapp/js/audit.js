var readyProduct = {
    totalPages: 1,
    thisPage: 1
}

var pid = [];

$(function () {
    $('#check').trigger('click');

    $('#check').on('click', function () {
        $.ajax({
            url: '/ms/selectReadyProduct.do',
            data: JSON.stringify({
                pagenum: 10,
                thispage: readyProduct.thisPage
            }),
            method: 'POST',
            contentType: 'application/json',
            success: function (res) {
                $('.readProductTr').remove();

                readyProduct.totalPages = res.totalpage || 1;
                readyProduct.thisPage = res.thispage || 1;
                res = res.pagedata || [];
                pid = [];
                for (var i = 0; i < res.length; i++) {
                    pid.push(res[i].pid);
                    var tr = $('<tr class="readProductTr"></tr>');
                    //选择
                    var checkTd = $('<td></td>');
                    var check = $('<input class="readProductCheck" type="checkbox">');
                    //商品名称
                    var tdName = $('<td></td>').html(res[i].pname);
                    //一级分类
                    var tdType1 = $('<td></td>').html(res[i].ptypea) || '无';
                    //二级分类
                    var tdType2 = $('<td></td>').html(res[i].ptypeb) || '无';
                    //三级分类
                    var tdType3 = $('<td></td>').html(res[i].ptypec) || '无';
                    //商品进价
                    var tdPurchase = $('<td></td>').html(res[i].pcost);
                    //商品原价
                    var tdOriginal = $('<td></td>').html(res[i].pssellprice);
                    //商品售价
                    var tdPrice = $('<td></td>').html(res[i].psoriprice);
                    //商家名称
                    var tdMerchants = $('<td></td>').html(res.dname);
                    //联系方式
                    var tdPhone = $('<td></td>').html(res[i].dphonenum);
                    $(checkTd).append(check);
                    $(tr).append(checkTd,tdName,tdType1,tdType2,tdType3,tdPurchase,tdOriginal,tdPrice,tdMerchants,tdPhone);
                }
                paging($('.readyProductPaging')[0], {
                    totalPages: readyProduct.totalPages,
                    nowPage: readyProduct.thisPage
                });
                $('.readyProductPaging .page').on('click', function () {
                    var text = '';
                    switch($(this).text()){
                        case '末页':
                            text = totalPages
                            break;
                        case '首页':
                            text = 1
                            break;
                        default:
                            text = this.text
                    }
                    readyProduct.thisPage = text;
                    $('#check').trigger('click');
                })
                $('.readyProductPaging .prev').on('click', function () {
                    readyProduct.thisPage = readyProduct.thisPage - 1;
                    $('#check').trigger('click');
                })
                $('.readyProductPaging .next').on('click', function () {
                    readyProduct.thisPage = parseInt(readyProduct.thisPage) + 1;
                    $('#check').trigger('click');
                })
            }
        })
    })


    $('#success').on('click', function () {
        var len = $('.readProductCheck').length;
        var arr = [];
        for (var i = 0; i < len; i++) {
            if($($('.readProductCheck')[i]).is(":checked")) {
                arr.push(pid[i]);
            }
        }
        $.ajax({
            url:'/ms/checkProduct.do',
            data:JSON.stringify({
                pid:arr,
                check: 1
            }),
            type:'POST',
            contentType: 'application/json',
            success:function (res) {
                $('#check').trigger('click');
                if(res.code == 1){
                    alert('审核成功');
                }
            }
        });


    });

    $('#fail').on('click', function () {
        var len = $('.readProductCheck').length;
        var arr = [];
        for (var i = 0; i < len; i++) {
            if($($('.readProductCheck')[i]).is(":checked")) {
                arr.push(pid[i]);
            }
        }
        $.ajax({
            url:'/ms/checkProduct.do',
            data:JSON.stringify({
                pid:arr,
                check: 0
            }),
            type:'POST',
            contentType: 'application/json',
            success:function (res) {
                $('#check').trigger('click');
                if(res.code == 1){
                    alert('审核成功');
                }
            }
        });
    });

})