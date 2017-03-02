package com.capstone.jmt.mapper;


import com.capstone.jmt.data.*;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Jabito on 02/17/2017.
 */
public interface ShopMapper {


    ShopLogin getShopLoginById(@Param("id") String id);

    ShopInfo getShopInfoById(@Param("id") String id);

    ShopLocation getShopLocationById(@Param("id") String id);

    WaterTypesOffered getWaterTypesOfferedById(@Param("id") String id);

    ContainersOffered getContainersOfferedById(@Param("id") String id);

    Integer addShopInfo(@Param("shop") ShopInfo shop);

    Integer updateShopInfo(@Param("shop") ShopInfo shop);

    Integer addShopLogin(@Param("shopUser") ShopLogin shop);

    Integer updateShopLogin(@Param("shopUser") ShopLogin shop);

    Integer addShopLocation(@Param("shop") ShopLocation shop);

    Integer updateShopLocation(@Param("shop") ShopLocation shop);

    Integer addWaterTypesOffered(@Param("shop") WaterTypesOffered shop);

    Integer updateWaterTypesOffered(@Param("shop") WaterTypesOffered shop);

    Integer addContainersOffered(@Param("shop") ContainersOffered shop);

    Integer updateContainersOffered(@Param("shop") ContainersOffered shop);

    ShopLogin loadUserByUsername(@Param("username") String username);
}
