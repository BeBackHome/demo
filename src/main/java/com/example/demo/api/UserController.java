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
 * 9/6/2017  1.0         weber         Creation File
 */
package com.example.demo.api;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
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
 * @date 9/6/2017 8:06 PM
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String URL_PREFIX = "/api/user";

    @Autowired
    private UserService userService;

    @ApiOperation(value = "插入用户，id 不需要填写，后台会自动生成", notes = "插入用户")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/insert", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        logger.debug("Request /api/data/user/insert, user is [{}]" + user);
        User userEntity = userService.insert(user);
        logger.debug("Insert user successfully, user is [{}]" + userEntity);
        return userEntity;
    }

    @ApiOperation(value = "修改用户", notes = "插入用户")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/update/{id}", method = RequestMethod.POST)
    public User update(@PathVariable Long id, @RequestBody User user) {
        logger.debug("Request /api/data/user/update, user is [{}]" + user);
        User userEntity = userService.update(id, user);
        logger.debug("Update user successfully, user is [{}]" + userEntity);
        return userEntity;
    }

    @ApiOperation(value = "加载一条用户", notes = "加载用户")
    @ApiImplicitParam(name = "user_identity", value = "user Id", required = true, paramType = "header", dataType = "String")
    @RequestMapping(value = URL_PREFIX + "/load/{id}", method = RequestMethod.GET)
    public User load(@PathVariable Long id) {
        logger.debug("Request /api/data/user/load, id is [{}]" + id);
        User userEntity = userService.load(id);
        logger.debug("load user successfully, user is [{}]" + userEntity);
        return userEntity;
    }

}