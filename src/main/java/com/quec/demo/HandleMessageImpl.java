package com.quec.demo;

import com.alibaba.fastjson.JSONObject;
import com.quec.amqphandle.HandleMessage;
import com.quec.model.msg.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandleMessageImpl implements HandleMessage {

    /**
    * Hook for custom processing before a subscribed message is handled.
     * @param var1
     */
    @Override
    public void beforeHandleMessage(String var1) {
        // do something
        log.info(var1);
    }

    /**
    * Hook for custom processing after a subscribed message is handled.
     * @param var1
     */
    @Override
    public void afterHandleMessage(String var1) {
        // do something
        log.info(var1);
    }

    /**
     * Online/offline event.
     * @param var1
     */
    @Override
    public void upAndDownLine(UpDownLine var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
     * Device status.
     * @param var1
     */
    @Override
    public void deviceStatus(DeviceStatus var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
    * Uplink passthrough command.
     * @param var1
     */
    @Override
    public void upLink(UpDownLink var1) {
        // do something
        log.info(JSONObject.toJSONString(var1));
    }

    /**
    * Downlink passthrough command.
     * @param var1
     */
     @Override
     public void downLink(UpDownLink var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
    * ACK message indicating whether the downlink payload was delivered successfully.
     * @param var1
     */
     @Override
     public void reqack(Reqack var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
    * Downlink property read request for the thing model.
     * @param var1
     */
     @Override
     public void mAttrRead(MAttrRead var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink response to a thing model property read request.
     * @param var1
     */
     @Override
     public void mAttrReadresp(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };


    /**
    * Thing model property write request.
     * @param var1
     */
    @Override
     public void mAttrWrite(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink thing model property report.
     * @param var1
     */
     @Override
     public void mAttrReport(MAttr var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Downlink thing model service invocation request, corresponding to the Write message type in the passthrough payload protocol.
     * @param var1
     */
     @Override
     public void mServInput(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink response to a thing model service invocation, corresponding to the Event message type in the passthrough payload protocol.
     * @param var1
     */
     @Override
     public void mServOutput(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink informational event report, corresponding to the Event message type in the thing model payload protocol.
     * @param var1
     */
     @Override
     public void mEventInfo(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink warning event report, corresponding to the Event message type in the thing model payload protocol.
     * @param var1
     */
     @Override
     public void mEventWarn(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Uplink error event report, corresponding to the Event message type in the thing model payload protocol.
     * @param var1
     */
     @Override
     public void mEventError(MServ var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Configures the location reporting mode.
     * @param var1
     */
     @Override
     public void locationMode(Location var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Queries location data. If no value is provided, the saved mode is returned.
     * @param var1
     */
     @Override
     public void locationQuery(Location var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Response to a location query or proactive location report in raw format.
     * @param var1
     */
     @Override
     public void locationInfoRaw(LocationInfoRAW var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Response to a location query or proactive location report in parsed WGS-84 format.
     * @param var1
     */
     @Override
     public void locationInfoKV(LocationInfoKV var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * End-user profile created event.
     * @param var1
     */
     @Override
     public void enduserUserAdd(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * End-user profile updated event.
     * @param var1
     */
     @Override
     public void enduserUserUpdate(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * End-user profile deleted event.
     * @param var1
     */
     @Override
     public void enduserUserDelete(EnduserUser var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * End-user device binding event.
     * @param var1
     */
     @Override
     public void enduserUserBind(EnduserUserBind var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Product created or deleted event.
     * @param var1
     */
     @Override
     public void productAddAndDel(ProductAddAndDelete var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Product metadata updated event.
     * @param var1
     */
     @Override
     public void productUpdate(ProductUpdate var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Product thing model updated event.
     * @param var1
     */
     @Override
     public void deviceModelInfo(ProductThingmodel var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Device created or deleted event.
     * @param var1
     */
     @Override
     public void deviceAddAndDel(DeviceAddAndDelete var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };

    /**
    * Device metadata updated event.
     * @param var1
     */
     @Override
     public void deviceUpdate(DeviceUpdate var1){
         // do something
         log.info(JSONObject.toJSONString(var1));
     };
}
