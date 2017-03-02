package com.capstone.jmt.service;

import com.capstone.jmt.data.CustomerInfo;
import com.capstone.jmt.data.CustomerLocation;
import com.capstone.jmt.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jabito on 15/02/2017.
 */
@Service("customerService")
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerMapper customerMapper;

    public List getAllCustomers() {
        logger.info("getAllCustomers");
        List customers = customerMapper.getAllCustomers();
        logger.info("getAllCustomers", customers);
        return customers;
    }

    public CustomerInfo getCustomerInfoById(String id){
        logger.info("getCustomerInfoByUsername");
        CustomerInfo customer = customerMapper.getCustomerInfoById(id);
        logger.info("getCustomerInfoByUsername", customer);
        return customer;
    }

    public CustomerLocation getCustomerLocationById(String id){
        logger.info("getCustomerLocationById");
        CustomerLocation customer = customerMapper.getCustomerLocationById(id);
        logger.info("getCustomerLocationById", customer);
        return customer;
    }

    public void addCustomerInfo(CustomerInfo customer) {
        logger.info("addCustomerInfo");
        customer.setId(UUID.randomUUID().toString());
        Integer ret = customerMapper.addCustomerInfo(customer);
        System.out.println(ret);
    }

    public void updateCustomerInfo(CustomerInfo customer) {
        logger.info("updateCustomerInfo");
        Integer ret = customerMapper.updateCustomerInfo(customer);
        System.out.println(ret);
    }

    public void addCustomerLocation(CustomerLocation customer) {
        logger.info("addCustomerLocation");
        Integer ret = customerMapper.addCustomerLocation(customer);
        System.out.println(ret);
    }

    public void updateCustomerLocation(CustomerLocation customer) {
        logger.info("updateCustomerLocation");
        Integer ret = customerMapper.updateCustomerLocation(customer);
        System.out.println(ret);
    }
}
