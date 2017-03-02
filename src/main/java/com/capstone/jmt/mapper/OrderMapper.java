package com.capstone.jmt.mapper;


import com.capstone.jmt.data.OrderContainers;
import com.capstone.jmt.data.OrderInfo;
import com.capstone.jmt.data.OrderStatus;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Jabito on 02/17/2017.
 */
public interface OrderMapper {


    OrderInfo getOrderInfoById(@Param("id") String id);

    OrderStatus getOrderStatusById(@Param("id") String id);

    OrderContainers getOrderContainersById(@Param("id") String id);

    Integer addOrderInfo(@Param("order") OrderInfo order);

    Integer updateOrderInfo(@Param("order") OrderInfo order);

    Integer addOrderStatus(@Param("order") OrderStatus order);

    Integer updateOrderStatus(@Param("order") OrderStatus order);

    Integer rejectOrderStatus(@Param("order") OrderStatus order);

    Integer addOrderContainers(@Param("order") OrderContainers order);

    Integer updateOrderContainers(@Param("order") OrderContainers order);
}
