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
package com.example.demo.constants;

/**
 * Description:
 *
 * @author weber
 * @date 9/11/2017 4:38 AM
 */
public class ErrorCode {
    public enum BusinessErrorCode {
        DataUnExist(0x00010000, "opertating data not existed"),
        DataExist(0x00010001, "opertating data not existed");
        private String errorMsg;
        private Integer errorCode;

        BusinessErrorCode(Integer errorCode, String errorMsg) {
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }

        public Integer errorCode() {
            return errorCode;
        }


        public String errorMsg() {
            return errorMsg;
        }

    }

}