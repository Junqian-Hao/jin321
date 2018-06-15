var totalPages = 1;

function paging(el, obj) {
    //总页数(必须数据)
    totalPages = parseInt(obj.totalPages) || 1;
    //当前页数(必须数据)
    var nowPage = parseInt(obj.nowPage) || 1;
    //首页名字(可选数据)
    var homePage = obj.homePage || '1';
    //末页名字(可选数据)
    var endPage = obj.endPage || '末页';
    //上一页(可选数据)
    var prevContent = obj.prevContent || '上一页';
    //下一页(可选数据)
    var nextContent = obj.nextContent || '下一页';
    //获取当前页码的位置
    var position = totalPages - nowPage;
    var empty = "";
    var more = "..."

    var code = '';
    if (totalPages < 3) {
        if (nowPage === 1) {
            code = '<a class="btn btn-primary btn-sm prev">' + prevContent + '</a>\n' +
                '        <a class="btn page btn-primary btn-sm active">' + homePage + '</a>';
            for (var i = 1; i < totalPages; i++) {
                code += '<a class="btn page btn-primary btn-sm">' + endPage + '</a>';
            }
            code += '<a class="btn btn-primary btn-sm next">' + nextContent + '</a>\n' +
                '        <input class="jump">\n' +
                '        <a class="btn btn-primary btn-sm" onclick="jump(this)">跳转</a>';
            el.innerHTML = code;
            return
        }else {
            code = '<a class="btn btn-primary btn-sm prev">' + prevContent + '</a>\n' +
                '        <a class="btn page btn-primary btn-sm active">' + homePage + '</a>';
            for (var i = 1; i < totalPages; i++) {
                code += '<a class="btn page btn-primary btn-sm active">' + endPage + '</a>';
            }
            code += '<a class="btn btn-primary btn-sm next">' + nextContent + '</a>\n' +
                '        <input class="jump">\n' +
                '        <a class="btn btn-primary btn-sm" onclick="jump(this)">跳转</a>';
            el.innerHTML = code;
            return
        }
    }

    if (position > 0 && position < totalPages - 1) {
        code = '<a class="btn btn-primary btn-sm prev">' + prevContent + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm">' + (nowPage - 1 > 1 ? nowPage - 1 : homePage) + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm active">' + nowPage + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm">' + (nowPage + 1 > totalPages - 1 ? endPage : nowPage + 1) + '</a>\n' +
            '        <p class="pText">' + (nowPage + 1 > totalPages - 1 ? empty : more) + '</p>\n' +
            '        <a class="btn btn-primary btn-sm next">' + nextContent + '</a>\n' +
            '        <input class="jump">\n' +
            '        <a class="btn btn-primary btn-sm" onclick="jump(this)">跳转</a>';
        el.innerHTML = code;
        return
    } else if (position === totalPages - 1) {
        //如果跳转到第一页
        code += '    <a class="btn page btn-primary btn-sm active">' + homePage + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm">2</a>\n' +
            '        <a class="btn page btn-primary btn-sm">3</a>\n' +
            '        <p class="pText">...</p>\n' +
            '        <a class="btn btn-primary btn-sm next">' + nextContent + '</a>\n' +
            '        <input class="jump">\n' +
            '        <a class="btn btn-primary btn-sm" onclick="jump(this)">跳转</a>';
        el.innerHTML = code;
        return
    } else if (position === 0) {
        //如果跳转到最后一页
        code += '<a class="btn btn-primary btn-sm prev">' + prevContent + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm">' + (nowPage - 2) + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm">' + (nowPage - 1) + '</a>\n' +
            '        <a class="btn page btn-primary btn-sm active">' + endPage + '</a>\n' +
            '        <input class="jump">\n' +
            '        <a class="btn btn-primary btn-sm" onclick="jump(this)">跳转</a>';
        el.innerHTML = code;
        return
    }
}

function jump(e) {
    var nowPage = e.previousSibling.previousSibling.value;
    var className = e.parentNode.className.split(' ')[0];
    switch (className){
        case 'infoPaging':
            detailProduct.thisPage = nowPage
            $('#watch-s').trigger('click')
            break;
        case 'noSendPaging':
            noSend.thisPage = nowPage
            $('#noSend').trigger('click')
            break;
        case 'noRecPaging':
            noRec.thisPage = nowPage
            $('#noRec').trigger('click')
            break;
        case 'alreadyPaging':
            already.thisPage = nowPage
            $('#already').trigger('click')
            break;
        case 'watchTypePaging':
            allType.thisPage = nowPage
            $('#watch-type').trigger('click')
            break;
        case 'watchCommonPaging':
            commonProduct.thisPage = nowPage
            $('#watch-common').trigger('click')
            break;
        case 'watchMerchantPaging':
            dealer.thisPage = nowPage
            $('#watch-merchant').trigger('click')
            break;
        case 'moneyPaging':
            money.thisPage = nowPage
            $('#money-li').trigger('click')
            break;
    }


    if (nowPage) {
        paging(e.parentNode, {
            totalPages: totalPages,
            nowPage: trim(nowPage)
        });
    }
}

function trim(str) {
    for (var i = 0; i < str.length; i++) {
        if (str.charAt(i) !== ' ') {
            break
        } else {
            str = str.substr(1, str.length);
        }
    }
    for (var j = str.length - 1; j > 0; j--) {
        if (str.charAt(j) !== ' ') {
            break
        } else {
            str = str.substr(0, str.length - 1);
        }
    }
    return str
}
