package com.capstone.jmt.service;

import com.capstone.jmt.data.*;
import com.capstone.jmt.mapper.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by Jabito on 15/02/2017.
 */
@Service("shopService")
public class ShopService {

    private static final Logger logger = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ShopLogin validateUser(ShopLogin user) {
        logger.info("loadUserByUsername");
        ShopLogin account = shopMapper.loadUserByUsername(user.getUsername());
        logger.info("loadUserByUsername", user);
        if(passwordEncoder.matches(user.getPassword(), account.getPassword()))
            return account;
        else
            return null;
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

    public ShopSalesInformation getShopSalesInformationById(String id){
        logger.info("getShopSalesInformation");
        ShopSalesInformation order = shopMapper.getShopSalesInformationById(id);
        logger.info("getShopSalesInformation", order);
        return order;
    }

    public void updateShopInfo(ShopInfo shop) {
        logger.info("updateShopInfo");
        Integer ret = shopMapper.updateShopInfo(shop);
    }

    public void updateShopLogin(ShopLogin shop) {
        logger.info("updateShopLogin");
        Integer ret = shopMapper.updateShopLogin(shop);
    }

    public void addShopLocation(ShopLocation shop) {
        logger.info("addShopLocation");
        Integer ret = shopMapper.addShopLocation(shop);
    }

    public void updateShopLocation(ShopLocation shop) {
        logger.info("updateShopLocation");
        Integer ret = shopMapper.updateShopLocation(shop);
    }

    public void addShopSalesInformation(ShopSalesInformation shop) {
        logger.info("addContainersOffered");
        Integer ret = shopMapper.addShopSalesInformation(shop);
    }

    public void updateShopSalesInformation(ShopSalesInformation shop) {
        logger.info("updateContainersOffered");
        Integer ret = shopMapper.updateShopSalesInformation(shop);
    }

    public String getTotalSales(String shopId) {
        logger.info("getTotalSales");
        String sales = shopMapper.getTotalSalesById(shopId);

        return sales;
    }

    public String getSalesCount(String shopId) {
        logger.info("getSalesCount");
        String count = shopMapper.getSalesCount(shopId);

        return count;
    }

    public String getShopRating(String shopId) {
        logger.info("getShopRating");
        Integer ratings = shopMapper.getTotalRatings(shopId);
        Integer reviews = shopMapper.getReviewsCount(shopId);

        if(reviews == 0 || null == ratings || null == reviews)
            return "0";
        else {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            String output = formatter.format(ratings/reviews);
            return output;
        }
    }
}
