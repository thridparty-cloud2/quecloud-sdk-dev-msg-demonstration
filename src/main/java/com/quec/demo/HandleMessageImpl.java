package com.quec.demo;

import com.alibaba.fastjson.JSONObject;
import com.quec.amqphandle.HandleMessage;
import com.quec.model.msg.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandleMessageImpl implements HandleMessage {

    /**
     *处理订阅的消息前业务自定义处理
     * @param var1
     */
    @Override
    public void beforeHandleMessage(String var1) {
        // do something
        log.info(var1);
    }

    /**
     *处理订阅的消息后业务自定义处理
     * @param var1
     */
    @Override
    public void afterHandleMessage(String var1) {
        // do something
        log.info(var1);
    }

    /**
     * 上下线事件
     * @param var1
     */
    @Override
    public void upAndDownLine(UpDownLine var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
     * 设备状态
     * @param var1
     */
    @Override
    public void deviceStatus(DeviceStatus var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
     * 上行，透传命令上行
     * @param var1
     */
    @Override
    public void upLink(UpDownLink var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
     * 下行，透传命令下行
     * @param var1
     */
     @Override
     public void downLink(UpDownLink var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
     *ACK确认消息，返回下行数据是否发送成功响应
     * @param var1
     */
     @Override
     public void reqack(Reqack var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
     * 下行，物模型属性读命令下发
     * @param var1
     */
     @Override
     public void mAttrRead(MAttrRead var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，物模型属性读命令响应
     * @param var1
     */
     @Override
     public void mAttrReadresp(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
     * 物模型属性写命令下发
     * @param var1
     */
    @Override
     public void mAttrWrite(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，对应物模型数据包协议的Event消息类型，物模型属性上报
     * @param var1
     */
     @Override
     public void mAttrReport(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 下行，物模型服务执行请求，对应透传数据包协议的Write消息类型
     * @param var1
     */
     @Override
     public void mServInput(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，物模型服务执行响应，对应透传数据包协议的Event消息类型
     * @param var1
     */
     @Override
     public void mServOutput(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，对应物模型数据包协议的Event消息类型，物模型事件信息上报
     * @param var1
     */
     @Override
     public void mEventInfo(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，对应物模型数据包协议的Event消息类型，物模型事件告警上报
     * @param var1
     */
     @Override
     public void mEventWarn(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 上行，对应物模型数据包协议的Event消息类型，物模型事件故障上报
     * @param var1
     */
     @Override
     public void mEventError(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 设置定位信息发送模式
     * @param var1
     */
     @Override
     public void locationMode(Location var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 查询定位信息，为空，则以保存的MODE返回
     * @param var1
     */
     @Override
     public void locationQuery(Location var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 定位信息查询的响应、定位信息的主动上报(原始数据)
     * @param var1
     */
     @Override
     public void locationInfoRaw(LocationInfoRAW var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 定位信息查询的响应、定位信息的主动上报(解析数据-WGS-84)
     * @param var1
     */
     @Override
     public void locationInfoKV(LocationInfoKV var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 终端用户信息变更-新增
     * @param var1
     */
     @Override
     public void enduserUserAdd(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 终端用户信息变更-修改
     * @param var1
     */
     @Override
     public void enduserUserUpdate(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 终端用户信息变更-删除
     * @param var1
     */
     @Override
     public void enduserUserDelete(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 终端用户设备绑定信息
     * @param var1
     */
     @Override
     public void enduserUserBind(EnduserUserBind var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 产品新增/删除
     * @param var1
     */
     @Override
     public void productAddAndDel(ProductAddAndDelete var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 产品信息变更
     * @param var1
     */
     @Override
     public void productUpdate(ProductUpdate var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 产品物模型信息变更
     * @param var1
     */
     @Override
     public void deviceModelInfo(ProductThingmodel var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 设备新增/删除
     * @param var1
     */
     @Override
     public void deviceAddAndDel(DeviceAddAndDelete var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
     * 设备信息修改
     * @param var1
     */
     @Override
     public void deviceUpdate(DeviceUpdate var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };
}
