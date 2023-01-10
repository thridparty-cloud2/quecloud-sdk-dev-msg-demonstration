package com.quec.demo;

import com.alibaba.fastjson.JSONObject;
import com.quec.client.MsgClient;
import com.quec.config.InitClientProfile;
import com.quec.model.device.request.*;
import com.quec.model.device.response.DeviceBatchSendDataResponse;
import com.quec.model.device.response.DeviceDmReadDataResponse;
import com.quec.model.device.response.DeviceSendDataResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class QueCloudDevDownlinkDemo {

    public void msgDownLinkDemo() throws Exception {
        InitClientProfile initClientProfile = new InitClientProfile(
                "${accessKey}",
                "${accessSecret}",
                "${endpoint}");
        // 获取MgrClient对象。建议可以使用单例模式。此对象中包含设备数据下发相关的sdk
        MsgClient msgClient = new MsgClient(initClientProfile);
        // PASSTHROUGH:透传 PROPERTY:属性 SERVICE:服务
        String type="PASSTHROUGH|PROPERTY|SERVICE";
        // GET:上报 DOWN:下发
        String operate="GET|DOWN";

        // 单个设备下发透传数据
        type = "PASSTHROUGH";
        operate = "DOWN";
        DeviceSendDataRequest deviceSendDataRequest = new DeviceSendDataRequest("${productKey}","${deviceKey}","${data}",type,operate);
        // 透传需要设置数据格式 Hex|Text
        deviceSendDataRequest.setPassDataFormat("Text");
        DeviceSendDataResponse result = msgClient.sendDeviceData(deviceSendDataRequest);
        log.info("单个设备下发透传数据返回结果:{}", JSONObject.toJSONString(result));


        // 单设备下发物模型数据
        /**
         * 设备发送下行数据.data为发送下行数据的具体内容.operate=GET,数据格式为"[“key1","key2",…]"(key为物模型标识符)。operate=DOWN,数据格式为”[{key1:value1},{key2:value2}]"(key为物模型标识符).
         * 示例:
         * 属性bool/int/float/double/enum/date/text
         * "[{\"key\":\"value\"}]"
         * 属性array
         * "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]"（id为0）
         * 属性struct
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
         * 属性array含有struct
         * "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]"（id为0）
         * 服务调用bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * 服务调用array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]"（id为0）
         * 服务调用struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * 服务调用array，且array含有struct
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]"(id固定为0)
         */
        type = "PROPERTY";
        operate = "DOWN";
        DeviceSendDataRequest deviceSendTslDataRequest = new DeviceSendDataRequest("${productKey}","${deviceKey}","${data}",type,operate);
        DeviceSendDataResponse tslResult = msgClient.sendDeviceData(deviceSendTslDataRequest);
        log.info("单设备下发物模型数据返回结果:{}", JSONObject.toJSONString(tslResult));


        // 批量设备下发透传数据
        List<DeviceBatchSendDataRequestBody> devices = new ArrayList<>();
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody1 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody2 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        devices.add(deviceBatchSendDataRequestBody1);
        devices.add(deviceBatchSendDataRequestBody2);
        type = "PASSTHROUGH";
        operate = "DOWN";
        DeviceBatchSendDataRequest deviceBatchSendDataRequest =new DeviceBatchSendDataRequest(devices,"${data}",type,operate);
        // 透传需要设置数据格式 Hex|Text
        deviceBatchSendDataRequest.setPassDataFormat("Text");
        DeviceBatchSendDataResponse batchSendDataresult=msgClient.batchSendDeviceData(deviceBatchSendDataRequest);
        log.info("批量设备下发透传数据返回结果:{}", JSONObject.toJSONString(batchSendDataresult));


        // 批量设备下发物模型数据
        /**
         * 设备发送下行数据.data为发送下行数据的具体内容.operate=GET,数据格式为"[“key1","key2",…]"(key为物模型标识符)。operate=DOWN,数据格式为”[{key1:value1},{key2:value2}]"(key为物模型标识符).
         * 示例:
         * 属性bool/int/float/double/enum/date/text
         * "[{\"key\":\"value\"}]"
         * 属性array
         * "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]"（id为0）
         * 属性struct
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
         * 属性array含有struct
         * "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]"（id为0）
         * 服务调用bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * 服务调用array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]"（id为0）
         * 服务调用struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * 服务调用array，且array含有struct
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]"(id固定为0)
         */
        List<DeviceBatchSendDataRequestBody> tslDevices = new ArrayList<>();
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody3 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody4 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        tslDevices.add(deviceBatchSendDataRequestBody3);
        tslDevices.add(deviceBatchSendDataRequestBody4);
        type = "PROPERTY";
        operate = "DOWN";
        DeviceBatchSendDataRequest deviceBatchSendTslDataRequest =new DeviceBatchSendDataRequest(devices,"${data}",type,operate);
        DeviceBatchSendDataResponse batchSendTslDataresult=msgClient.batchSendDeviceData(deviceBatchSendTslDataRequest);
        log.info("批量设备下发物模型数据返回结果:{}", JSONObject.toJSONString(batchSendTslDataresult));


        //设备读取物模型属性数据
        //设备读取物模型属性数据.data为发送下行数据的具体内容.数据格式为"["key1","key2",…]"(key为物模型标识符).
        List<String> strings = new ArrayList<>();
        strings.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest = new DeviceDmReadDataRequest(strings,"${productKey1}","${data}");
        DeviceDmReadDataResponse deviceDmReadDataResponse = msgClient.deviceDmReadData(deviceDmReadDataRequest);
        log.info("设备读取物模型属性数据返回结果:{}", JSONObject.toJSONString(deviceDmReadDataResponse));

        //设备发送下行物模型数据
        /**data数据格式为"[{key1:value1},{key2:value2}]"(key为物模型标识符).
        示例:
        属性bool/int/float/double/enum/date/text
        "[{\"key\":\"value\"}]"
        属性array
        "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]"（id为0）
        属性struct
        "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
        属性array含有struct
        "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]"（id为0）
        服务调用bool/int/float/double/enum/date/text
        "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
        服务调用array
        "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]"（id为0）
        服务调用struct
        "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
        服务调用array，且array含有struct
        "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]"(id固定为0)*/
        List<String> list = new ArrayList<>();
        list.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest1 = new DeviceDmReadDataRequest(strings,"${productKey}","${data}");
        DeviceDmReadDataResponse basicResultResponse = msgClient.deviceDmWriteData(deviceDmReadDataRequest1);
        log.info("设备发送下行物模型数据返回结果:{}", JSONObject.toJSONString(basicResultResponse));

        //设备发送下行透传数据
        //设备发送下行透传数据,data为发送下行数据的具体内容.
        DeviceRawSendDataRequest deviceRawSendDataRequest = new DeviceRawSendDataRequest();
        DeviceRawSendDataRequestbody b = new DeviceRawSendDataRequestbody("${productKey}","{deviceKey}");
        List<DeviceRawSendDataRequestbody> string = new ArrayList<>();
        string.add(b);
        deviceRawSendDataRequest.setData("${data}");
        deviceRawSendDataRequest.setEncode("Text");
        deviceRawSendDataRequest.setDevices(string);
        DeviceDmReadDataResponse deviceDmReadDataResponse1 = msgClient.deviceRawSendData(deviceRawSendDataRequest);
        log.info("设备发送下行透传数据返回结果:{}", JSONObject.toJSONString(deviceDmReadDataResponse1));

        //设备发送下行物模型服务数据
        /**
         * data数据格式为"[{key1:value1},{key2:value2}]"(key为物模型标识符).
         * 示例:
         * 服务调用bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * 服务调用array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]"（id为0）
         * 服务调用struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * 服务调用array，且array含有struct
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]"(id固定为0)*/
        List<String> str = new ArrayList<>();
        str.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest2 = new DeviceDmReadDataRequest(str,"${productKey}","${data}");
        DeviceDmReadDataResponse deviceDmReadDataResponse2 = msgClient.deviceDmsendServiceData(deviceDmReadDataRequest2);
        log.info("设备发送下行物模型服务数据返回结果:{}", JSONObject.toJSONString(deviceDmReadDataResponse2));
    }

}
