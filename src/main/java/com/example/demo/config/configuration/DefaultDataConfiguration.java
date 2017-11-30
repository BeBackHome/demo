/**
 * Copyright(c) Cloudolp Technology Co.,Ltd
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Cloudolp
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Cloudolp.
 * For more information about Cloudolp, welcome to http://www.cloudolp.com
 * <p>
 * Revision History:
 * Date		Version		Name				Description
 * 12/2/2016	1.0			Franklin			Creation File
 */
package com.example.demo.config.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Description:
 *
 * @author Franklin
 * @Date 12/2/2016 5:35 PM
 */
@Configuration
@EntityScan(basePackages = {"com.example.demo.entities"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
public class DefaultDataConfiguration {
    //下面的目的是初始化JPAQueryFactory的配置，JPAQueryFactory用来使用queryDSL。去过只是使用Spring Date 则不需要下面的
    @PersistenceContext
    private HibernateEntityManager entityManager;

    @PersistenceContext
    private EntityManager em;

    @Bean
    public JPAQueryFactory getQueryFactory() {
        return new JPAQueryFactory(this.em);
    }
}
