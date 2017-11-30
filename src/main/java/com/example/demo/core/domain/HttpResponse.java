/**
 * Copyright(c) Macrame Technology Co.,Ltd
 * All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of Macrame
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Macrame.
 * For more information about Macrame, welcome to http://www.macrame.com
 * <p/>
 * Revision History:
 * Date			Version		Name				Description
 * 9/24/2015	1.0			Franklin			Creation File
 */
package com.example.demo.core.domain;

import com.example.demo.constants.Constants;


/**
 * description:
 *
 * @author Franklin
 *         date  9/24/2015
 */
public class HttpResponse<T> {

    private Integer resultCode;
    private String message;
    private T data;
    private Object accessory;

    /*private Map<String, Object> values;
    private JsonGenerator generator;
    public HttpResponse(Integer resultcode){
        this.append(Constant.HTTPSERVICE_RESULT, resultcode);
    }
    public HttpResponse(){
        this(Constant.RESULT_SUCCESS);
    }
    public HttpResponse(String message){
        this.append(Constant.HTTPSERVICE_RESULT, Constant.RESULT_FAILURE)
                .append(Constant.HTTPSERVICE_DESCRIPTION, message);
    }

    public HttpResponse setMessage(String message){
        return this.append(Constant.HTTPSERVICE_DESCRIPTION, message);
    }
    public HttpResponse setErrorMessage(String message){
        return setMessage(Constant.RESULT_FAILURE,message);
    }
    public HttpResponse setErrorMessage(Integer errorCode,String message){
        return append(Constant.HTTPSERVICE_RESULT,errorCode)
                .append(Constant.HTTPSERVICE_DESCRIPTION, message);
    }
    public HttpResponse setData(Object data){
        return append(Constant.HTTPSERVICE_DATA, data);
    }
    public void setResultcode(Integer resultcode){
        append(Constant.HTTPSERVICE_RESULT,resultcode);
    }

    private HttpResponse append(String key, Object value) {
        if (values == null)
            values = new HashMap<String, Object>();
        values.put(key, value);
        return this;
    }

    public String toString(){
        ByteArrayOutputStream  out = new ByteArrayOutputStream();
        if (generator == null) {
            try {
                generator = (new JsonFactory()).createGenerator(out);
                generator.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }*/
    public HttpResponse(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public HttpResponse() {
        this(Constants.RESULT_SUCCESS);
    }

    public HttpResponse(String errorMessage) {
        setErrorMessage(errorMessage);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpResponse setErrorMessage(String message) {
        return setErrorMessage(Constants.RESULT_FAILURE, message);
    }

    public HttpResponse setErrorMessage(Integer errorCode, String message) {
        this.resultCode = errorCode;
        this.message = message;
        return this;
    }

    public HttpResponse setData(T data) {
        this.data = data;
        return this;
    }

    public HttpResponse setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Object getAccessory() {
        return accessory;
    }

    public void setAccessory(Object accessory) {
        this.accessory = accessory;
    }
}
