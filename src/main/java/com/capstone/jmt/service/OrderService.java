package com.capstone.jmt.service;

import com.capstone.jmt.data.OrderContainers;
import com.capstone.jmt.data.OrderInfo;
import com.capstone.jmt.data.OrderStatus;
import com.capstone.jmt.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jabito on 15/02/2017.
 */
@Service("orderService")
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderMapper orderMapper;

    public OrderInfo getOrderInfoById(String id){
        logger.info("getOrderInfoById");
        OrderInfo order = orderMapper.getOrderInfoById(id);
        logger.info("getOrderInfoById", order);
        return order;
    }

    public OrderStatus getOrderStatusById(String id){
        logger.info("getOrderStatusById");
        OrderStatus order = orderMapper.getOrderStatusById(id);
        logger.info("getOrderStatusById", order);
        return order;
    }

    public OrderContainers getOrderContainersById(String id){
        logger.info("getOrderContainersById");
        OrderContainers order = orderMapper.getOrderContainersByShopId(id);
        logger.info("getOrderContainersById", order);
        return order;
    }

    public void addOrderInfo(OrderInfo order) {
        logger.info("addOrderInfo");
        order.setId(UUID.randomUUID().toString());
        Integer ret = orderMapper.addOrderInfo(order);
        System.out.println(ret);
    }

    public void updateOrderInfo(OrderInfo order) {
        logger.info("updateOrderInfo");
        Integer ret = orderMapper.updateOrderInfo(order);
        System.out.println(ret);
    }

    public void addOrderStatus(OrderStatus order) {
        logger.info("addOrderStatus");
        Integer ret = orderMapper.addOrderStatus(order);
        System.out.println(ret);
    }

    public void updateOrderStatus(OrderStatus order) {
        logger.info("updateOrderStatus");
        Integer ret = orderMapper.updateOrderStatus(order);
        System.out.println(ret);
    }

    public void rejectOrderStatus(OrderStatus order) {
        logger.info("rejectOrderStatus");
        Integer ret = orderMapper.rejectOrderStatus(order);
        System.out.println(ret);
    }

    public void addOrderContainers(OrderContainers order) {
        logger.info("addOrderContainers");
        Integer ret = orderMapper.addOrderContainers(order);
        System.out.println(ret);
    }

    public void updateOrderContainers(OrderContainers order) {
        logger.info("updateOrderContainers");
        Integer ret = orderMapper.updateOrderContainers(order);
        System.out.println(ret);
    }

    public List<OrderInfo> getOrdersByShopId(String shopId) {
        logger.info("getOrdersByShopId");
        List orders = orderMapper.getOrdersByShopId(shopId);
        return orders;
    }

}
