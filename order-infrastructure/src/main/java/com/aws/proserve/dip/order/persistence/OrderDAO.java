package com.aws.proserve.dip.order.persistence;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存订单与订单项（订单项在存储层被弱化，例如和订单打散为一个MongoDB中的Collection）
 *
 * 具体的DAO实现，可以是JPA或者自己写的JDBC的类
 * 主要目的是数据库/存储的数据操作
 * 可以根据需要进一步抽象为接口层，有多种不同的数据源实现
 */
@Component
public class OrderDAO {
    public static void insert(OrderPO orderPO) {
    }

    public static void update(OrderPO orderPO) {
    }

    public static void remove(String id) {

    }

    public OrderPO selectById(String id) {
        return new OrderPO();
    }

    public List<OrderPO> selectByUserId(Long createPersonId) {
        ArrayList<OrderPO> list = new ArrayList<>();
        list.add(new OrderPO());
        return list;
    }
}
