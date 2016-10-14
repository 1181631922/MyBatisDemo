package com.fanyafeng.mapper;

import com.fanyafeng.model.Orders;
import com.fanyafeng.model.OrdersCustom;
import com.fanyafeng.model.User;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/10/13 16:11
 * Email: fanyafeng@live.cn
 */
public interface IOrdersCustomMapper {

    public List<OrdersCustom> findUserByOrderId();

    public List<Orders> findUserByOrderIdResultMap();

    public List<Orders> findOrderAndDetailResultMap();

    public List<User> findUserAndOrderDetailResultMap();
}
