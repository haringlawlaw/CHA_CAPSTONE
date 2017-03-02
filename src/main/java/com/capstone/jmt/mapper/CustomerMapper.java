package com.capstone.jmt.mapper;


import com.capstone.jmt.data.CustomerInfo;
import com.capstone.jmt.data.CustomerLocation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jabito on 02/17/2017.
 */
public interface CustomerMapper {

    List getAllCustomers();

    CustomerInfo getCustomerInfoById(@Param("id") String id);

    CustomerLocation getCustomerLocationById(@Param("id") String id);

    Integer addCustomerInfo(@Param("customer") CustomerInfo customer);

    Integer updateCustomerInfo(@Param("customer") CustomerInfo customer);

    Integer addCustomerLocation(@Param("customer") CustomerLocation customer);

    Integer updateCustomerLocation(@Param("customer") CustomerLocation customer);
}
