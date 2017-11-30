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
package com.example.demo.service.impl;

import com.example.demo.constants.ErrorCode;
import com.example.demo.core.service.IdGenerator;
import com.example.demo.entities.Fruit;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.FruitRepository;
import com.example.demo.service.FruitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author weber
 * @date 9/11/2017 4:18 AM
 */
@Service
public class FruitServiceImpl implements FruitService {
    private Logger logger = LoggerFactory.getLogger(FruitServiceImpl.class);
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit insert(Fruit fruit) {
        Fruit fruit1Exist = fruitRepository.findTopByName(fruit.getName());
        if (fruit1Exist != null) {
            throw new BusinessException("There exist an fruit named: " + fruit.getName(), ErrorCode.BusinessErrorCode.DataExist.errorCode());
        }
        fruit.setId(idGenerator.nextId());
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit update(Long id, Fruit fruit) {
        Fruit fruitExist = this.load(id);
        BeanUtils.copyProperties(fruit, fruitExist, "id");
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit load(Long id) {
        return fruitRepository.findOne(id);
    }
}