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
        // Create the MsgClient instance. Using a singleton is recommended. This client exposes the SDK APIs for device downlink messaging.
        MsgClient msgClient = new MsgClient(initClientProfile);
        // PASSTHROUGH: passthrough payload PROPERTY: property SERVICE: service
        String type="PASSTHROUGH|PROPERTY|SERVICE";
        // GET: read/report DOWN: push data to the device
        String operate="GET|DOWN";

        // Send a passthrough payload to a single device
        type = "PASSTHROUGH";
        operate = "DOWN";
        DeviceSendDataRequest deviceSendDataRequest = new DeviceSendDataRequest("${productKey}","${deviceKey}","${data}",type,operate);
        // For passthrough payloads, the data format must be Hex or Text.
        deviceSendDataRequest.setPassDataFormat("Text");
        DeviceSendDataResponse result = msgClient.sendDeviceData(deviceSendDataRequest);
        log.info("Single-device passthrough downlink result: {}", JSONObject.toJSONString(result));


        // Send thing model data to a single device
        /**
         * The data field contains the payload to send.
         * When operate=GET, the format is "[\"key1\",\"key2\",...]", where each key is a thing model identifier.
         * When operate=DOWN, the format is "[{key1:value1},{key2:value2}]", where each key is a thing model identifier.
         * Examples:
         * Scalar properties: bool/int/float/double/enum/date/text
         * "[{\"key\":\"value\"}]"
         * Array properties
         * "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]" (id is 0)
         * Struct properties
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
         * Array properties containing structs
         * "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]" (id is 0)
         * Service inputs: bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * Service inputs: array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]" (id is 0)
         * Service inputs: struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * Service inputs: array containing structs
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]" (id is always 0)
         */
        type = "PROPERTY";
        operate = "DOWN";
        DeviceSendDataRequest deviceSendTslDataRequest = new DeviceSendDataRequest("${productKey}","${deviceKey}","${data}",type,operate);
        DeviceSendDataResponse tslResult = msgClient.sendDeviceData(deviceSendTslDataRequest);
        log.info("Single-device thing model downlink result: {}", JSONObject.toJSONString(tslResult));


        // Send a passthrough payload to multiple devices
        List<DeviceBatchSendDataRequestBody> devices = new ArrayList<>();
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody1 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        DeviceBatchSendDataRequestBody deviceBatchSendDataRequestBody2 = new DeviceBatchSendDataRequestBody("${productKey1}","${deviceKey1}");
        devices.add(deviceBatchSendDataRequestBody1);
        devices.add(deviceBatchSendDataRequestBody2);
        type = "PASSTHROUGH";
        operate = "DOWN";
        DeviceBatchSendDataRequest deviceBatchSendDataRequest =new DeviceBatchSendDataRequest(devices,"${data}",type,operate);
        // For passthrough payloads, the data format must be Hex or Text.
        deviceBatchSendDataRequest.setPassDataFormat("Text");
        DeviceBatchSendDataResponse batchSendDataresult=msgClient.batchSendDeviceData(deviceBatchSendDataRequest);
        log.info("Batch passthrough downlink result: {}", JSONObject.toJSONString(batchSendDataresult));


        // Send thing model data to multiple devices
        /**
         * The data field contains the payload to send.
         * When operate=GET, the format is "[\"key1\",\"key2\",...]", where each key is a thing model identifier.
         * When operate=DOWN, the format is "[{key1:value1},{key2:value2}]", where each key is a thing model identifier.
         * Examples:
         * Scalar properties: bool/int/float/double/enum/date/text
         * "[{\"key\":\"value\"}]"
         * Array properties
         * "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]" (id is 0)
         * Struct properties
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
         * Array properties containing structs
         * "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]" (id is 0)
         * Service inputs: bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * Service inputs: array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]" (id is 0)
         * Service inputs: struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * Service inputs: array containing structs
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]" (id is always 0)
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
        log.info("Batch thing model downlink result: {}", JSONObject.toJSONString(batchSendTslDataresult));


        // Read thing model properties from devices.
        // The data field must use the format "[\"key1\",\"key2\",...]", where each key is a thing model identifier.
        List<String> strings = new ArrayList<>();
        strings.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest = new DeviceDmReadDataRequest(strings,"${productKey1}","${data}");
        DeviceDmReadDataResponse deviceDmReadDataResponse = msgClient.deviceDmReadData(deviceDmReadDataRequest);
        log.info("Thing model property read result: {}", JSONObject.toJSONString(deviceDmReadDataResponse));

        // Send thing model property data to devices.
        /** The data format is "[{key1:value1},{key2:value2}]", where each key is a thing model identifier.
        Examples:
        Scalar properties: bool/int/float/double/enum/date/text
        "[{\"key\":\"value\"}]"
        Array properties
        "[{\"key\":[{\"id\":\"value1\"},{\"id\":\"value2\"}]}]" (id is 0)
        Struct properties
        "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"}]}]"
        Array properties containing structs
        "[{\"key\":[{\"id\":[{\"key1\":\"value1\"}]},{\"id\":[{\"key2\":\"value2\"}]}]}]" (id is 0)
        Service inputs: bool/int/float/double/enum/date/text
        "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
        Service inputs: array
        "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]" (id is 0)
        Service inputs: struct
        "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
        Service inputs: array containing structs
        "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]" (id is always 0) */
        List<String> list = new ArrayList<>();
        list.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest1 = new DeviceDmReadDataRequest(strings,"${productKey}","${data}");
        DeviceDmReadDataResponse basicResultResponse = msgClient.deviceDmWriteData(deviceDmReadDataRequest1);
        log.info("Thing model property write result: {}", JSONObject.toJSONString(basicResultResponse));

        // Send a passthrough payload to devices.
        // The data field contains the exact payload to be delivered.
        DeviceRawSendDataRequest deviceRawSendDataRequest = new DeviceRawSendDataRequest();
        DeviceRawSendDataRequestbody b = new DeviceRawSendDataRequestbody("${productKey}","{deviceKey}");
        List<DeviceRawSendDataRequestbody> string = new ArrayList<>();
        string.add(b);
        deviceRawSendDataRequest.setData("${data}");
        deviceRawSendDataRequest.setEncode("Text");
        deviceRawSendDataRequest.setDevices(string);
        DeviceDmReadDataResponse deviceDmReadDataResponse1 = msgClient.deviceRawSendData(deviceRawSendDataRequest);
        log.info("Passthrough downlink result: {}", JSONObject.toJSONString(deviceDmReadDataResponse1));

        // Send thing model service payloads to devices.
        /**
         * The data format is "[{key1:value1},{key2:value2}]", where each key is a thing model identifier.
         * Examples:
         * Service inputs: bool/int/float/double/enum/date/text
         * "[{\"key\":[{\"key1\":\"value1\"},{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]"
         * Service inputs: array
         * "[{\"key\":[{\"key1\":[{\"id\":\"value1\"},{\"id\":\"value1\"}]}]}]" (id is 0)
         * Service inputs: struct
         * "[{\"key\":[{\"key1\":[{\"key2\":\"value2\"},{\"key3\":\"value3\"}]}]}]"
         * Service inputs: array containing structs
         * "[{\"key\":[{\"key1\":[{\"id\":[{\"key2\":\"value2\"}]},{\"id\":[{\"key3\":\"value3\"}]}]}]}]" (id is always 0) */
        List<String> str = new ArrayList<>();
        str.add("${deviceKey}");
        DeviceDmReadDataRequest deviceDmReadDataRequest2 = new DeviceDmReadDataRequest(str,"${productKey}","${data}");
        DeviceDmReadDataResponse deviceDmReadDataResponse2 = msgClient.deviceDmsendServiceData(deviceDmReadDataRequest2);
        log.info("Thing model service downlink result: {}", JSONObject.toJSONString(deviceDmReadDataResponse2));
    }

}
