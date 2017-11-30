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
package com.example.demo.repository;

import com.example.demo.entities.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author weber
 * @date 9/11/2017 4:48 AM
 */
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Fruit findTopByName(String name);
}