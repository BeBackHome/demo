/**
 * Copyright(c) Cloudolp Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Cloudolp
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Cloudolp Technology Co.,Ltd.
 * For more information about Cloudolp, welcome to http://www.cloudolp.com
 * <p>
 * project: demo
 * <p>
 * Revision History:
 * Date         Version     Name                Description
 * 9/11/2017  1.0         weber         Creation File
 */
package com.example.demo.api;

import com.example.demo.entities.Fruit;
import com.example.demo.service.FruitService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author weber
 * @date 9/11/2017 4:17 AM
 */
@RestController
public class FruitController {
    private Logger logger = LoggerFactory.getLogger(FruitController.class);
    @Autowired
    private FruitService fruitService;

    private static final String URL_PREFIX = "/api/fruit";

    @ApiOperation(value = "插入水果，id 不需要填写，后台会自动生成", notes = "插入水果")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/insert", method = RequestMethod.POST)
    public Fruit insert(@RequestBody Fruit fruit) {
        logger.debug("Request /api/data/fruit/insert, fruit is [{}]" + fruit);
        Fruit fruitEntity = fruitService.insert(fruit);
        logger.debug("Insert fruit successfully, fruit is [{}]" + fruitEntity);
        return fruitEntity;
    }

    @ApiOperation(value = "修改水果", notes = "修改水果")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/update/{id}", method = RequestMethod.POST)
    public Fruit update(@PathVariable Long id, @RequestBody Fruit fruit) {
        logger.debug("Request /api/data/fruit/update, fruit is [{}]" + fruit);
        Fruit fruitEntity = fruitService.update(id, fruit);
        logger.debug("Update fruit successfully, fruit is [{}]" + fruitEntity);
        return fruitEntity;
    }

    @ApiOperation(value = "加载一条水果", notes = "加载水果")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/load/{id}", method = RequestMethod.GET)
    public Fruit load(@PathVariable Long id) {
        logger.debug("Request /api/data/fruit/load, id is [{}]" + id);
        Fruit fruitEntity = fruitService.load(id);
        logger.debug("load fruit successfully, fruit is [{}]" + fruitEntity);
        return fruitEntity;
    }
}