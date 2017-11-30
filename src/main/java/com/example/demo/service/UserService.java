package com.example.demo.service;

import com.example.demo.entities.User;

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
public interface UserService {
    User insert(User user);

    User update(Long id, User user);

    User load(Long id);
}
