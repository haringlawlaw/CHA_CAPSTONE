package com.capstone.jmt.service;

import com.capstone.jmt.data.*;
import com.capstone.jmt.mapper.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Jabito on 15/02/2017.
 */
@Service("shopService")
public class ShopService {

    private static final Logger logger = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    ShopMapper shopMapper;

    public ShopLogin loadUserByUsername(String username) {
        logger.info("loadUserByUsername");
        ShopLogin user = shopMapper.loadUserByUsername(username);
        logger.info("loadUserByUsername", user);
        return user;
    }

    public ShopLogin getShopLoginById(String id){
        logger.info("getShopLoginById");
        ShopLogin shopUser = shopMapper.getShopLoginById(id);
        logger.info("getShopLoginById", shopUser);
        return shopUser;
    }

    public ShopInfo getShopInfoById(String id){
        logger.info("getShopInfoById");
        ShopInfo shopUser = shopMapper.getShopInfoById(id);
        logger.info("getShopInfoById", shopUser);
        return shopUser;
    }

    public ShopLocation getShopLocationById(String id){
        logger.info("getShopLocationById");
        ShopLocation customer = shopMapper.getShopLocationById(id);
        logger.info("getShopLocationById", customer);
        return customer;
    }

    public WaterTypesOffered getWaterTypesOfferedById(String id){
        logger.info("getWaterTypesOfferedById");
        WaterTypesOffered order = shopMapper.getWaterTypesOfferedById(id);
        logger.info("getWaterTypesOfferedById", order);
        return order;
    }

    public ContainersOffered getContainersOfferedById(String id){
        logger.info("getContainersOfferedById");
        ContainersOffered order = shopMapper.getContainersOfferedById(id);
        logger.info("getContainersOfferedById", order);
        return order;
    }

    public void addShopInfo(ShopInfo shop) {
        logger.info("addShopInfo");
        shop.setId(UUID.randomUUID().toString());
        Integer ret = shopMapper.addShopInfo(shop);
        System.out.println(ret);
    }

    public void updateShopInfo(ShopInfo shop) {
        logger.info("updateShopInfo");
        Integer ret = shopMapper.updateShopInfo(shop);
        System.out.println(ret);
    }

    public void addShopLogin(ShopLogin shop) {
        logger.info("addShopLogin");
        shop.setId(UUID.randomUUID().toString());
        Integer ret = shopMapper.addShopLogin(shop);
        System.out.println(ret);
    }

    public void updateShopLogin(ShopLogin shop) {
        logger.info("updateShopLogin");
        Integer ret = shopMapper.updateShopLogin(shop);
        System.out.println(ret);
    }

    public void addShopLocation(ShopLocation shop) {
        logger.info("addShopLocation");
        Integer ret = shopMapper.addShopLocation(shop);
        System.out.println(ret);
    }

    public void updateShopLocation(ShopLocation shop) {
        logger.info("updateShopLocation");
        Integer ret = shopMapper.updateShopLocation(shop);
        System.out.println(ret);
    }

    public void addWaterTypesOffered(WaterTypesOffered shop) {
        logger.info("addWaterTypesOffered");
        Integer ret = shopMapper.addWaterTypesOffered(shop);
        System.out.println(ret);
    }

    public void updateWaterTypesOffered(WaterTypesOffered shop) {
        logger.info("updateWaterTypesOffered");
        Integer ret = shopMapper.updateWaterTypesOffered(shop);
        System.out.println(ret);
    }

    public void addContainersOffered(ContainersOffered shop) {
        logger.info("addContainersOffered");
        Integer ret = shopMapper.addContainersOffered(shop);
        System.out.println(ret);
    }

    public void updateContainersOffered(ContainersOffered shop) {
        logger.info("updateContainersOffered");
        Integer ret = shopMapper.updateContainersOffered(shop);
        System.out.println(ret);
    }
}
