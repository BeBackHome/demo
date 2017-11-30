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
package com.example.demo.core.service.Impl;

import com.example.demo.core.domain.IdWorker;
import com.example.demo.core.service.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author weber
 * @date 9/11/2017 4:50 AM
 */
@Service(value = "idGenerator")
public class SnowflakeIdGenerator implements IdGenerator {
    @Value("${common.id.dataCenterId}")
    private long dataCenterId;
    @Value("${common.id.workId}")
    private long workId;

    @Autowired
    private IdWorker idWorker;

    public long nextId() {
        return idWorker.getId();
    }

    @Bean
    IdWorker idWorker() {
        return new IdWorker(workId, dataCenterId);
    }
}