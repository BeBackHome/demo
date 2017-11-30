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
package com.example.demo.service.impl;

import com.example.demo.constants.ErrorCode;
import com.example.demo.core.service.IdGenerator;
import com.example.demo.entities.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

/**
 * Description:
 *
 * @author weber
 * @date 9/6/2017 8:08 PM
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public JPAQueryFactory jpaQueryFactory;

    @PersistenceContext
    public HibernateEntityManager entityManager;

    @Override
    @Transactional
    public User insert(User user) {
        User userExist = userRepository.findTopByName(user.getName());
        if (userExist != null) {
            throw new BusinessException("There exist an user named: " + user.getName(), ErrorCode.BusinessErrorCode.DataExist.errorCode());
        }
        user.setId(idGenerator.nextId());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        User userExist = this.load(id);
        BeanUtils.copyProperties(user, userExist, "id");
        return userRepository.save(user);
    }

    @Override
    public User load(Long id) {
        return userRepository.findOne(id);
    }
}