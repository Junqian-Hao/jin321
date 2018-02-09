package com.jin321.ms.event;

import com.jin321.ms.dao.GetSaleBydateDao;
import com.jin321.pl.dao.OrderformMapper;
import com.jin321.pl.dao.OrderformproductMapper;
import com.jin321.pl.dao.ProductsizeMapper;
import com.jin321.pl.dao.UserMapper;
import com.jin321.pl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Tyranitarx on 2018/2/9.
 *
 * @Description : 每月合伙人分平台利润的20%
 */
@Component
public class TogetherMoneyEvent {
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private OrderformproductMapper orderFormProductMapper;
    @Autowired
    private ProductsizeMapper productsizeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GetSaleBydateDao getSaleBydateDao;
    private List<Dealerbuyform> dealerbuyformList;
    private List<Orderformproduct> orderformproductList;
    private List<User> togetherUserList;
    private Dealerbuyform dealerbuyform;
    private Orderformproduct orderFormProduct;
    private Productsize productsize;
    private User user;
    private String date;
    private String datesplit[];
    private BigDecimal total;
    @Scheduled(cron = "0 0 1 1 * ?")
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.format(new Date());
        datesplit = date.split("-");
        String month=datesplit[1];
        if (datesplit[1].equals("1"))
            month="12";
        else
            month=String.valueOf(Integer.parseInt(datesplit[1])-1);
        dealerbuyformList = getSaleBydateDao.getSaleByMonth(month);
        Iterator<Dealerbuyform> dealerbuyformIterator = dealerbuyformList.iterator();
        //得到当月所有支付单进行迭代
        while (dealerbuyformIterator.hasNext()) {
            //查询到支付单相应商品
            total=new BigDecimal(0);
            dealerbuyform=dealerbuyformIterator.next();
            OrderformproductExample orderformproductExample=new OrderformproductExample();
            OrderformproductExample.Criteria criteria=orderformproductExample.createCriteria();
            criteria.andDbfidEqualTo(dealerbuyform.getDbfid());
            orderformproductList=orderFormProductMapper.selectByExample(orderformproductExample);
            //查询对应商品进货价格计算利润
            Iterator<Orderformproduct> orderformproductIterator=orderformproductList.iterator();
            while (orderformproductIterator.hasNext()){
                //根据商品单查到商品进货价格
                orderFormProduct = orderformproductIterator.next();
                productsize=productsizeMapper.selectByPrimaryKey(orderFormProduct.getSid());
                BigDecimal oricost=productsize.getPscost();
                BigDecimal gain=(orderFormProduct.getPbuyprice().subtract(oricost)).multiply(new BigDecimal(orderFormProduct.getPamount()));
                total=total.add(gain);
            }
        }
        //为每一位合伙人分0.2利润
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andIsTogetherEqualTo(true);
        togetherUserList=userMapper.selectByExample(userExample);
        BigDecimal per=total.multiply(new BigDecimal(0.2)).divide(new BigDecimal(togetherUserList.size()));
        Iterator<User> userIterator=togetherUserList.iterator();
        while (userIterator.hasNext()){
            user=userIterator.next();
            user.setUcommition(user.getUcommition()+per.floatValue());
            userMapper.updateByPrimaryKey(user);
        }
    }
}
