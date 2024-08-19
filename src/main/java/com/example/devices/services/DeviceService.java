package com.example.devices.services;

import com.example.devices.entities.Device;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service("deviceService")
public class DeviceService {

    private final RestTemplate restTemplate;

    private final String mockServerUrl = "https://73d7c1a9-ca53-48eb-9085-552b8afecf2f.mock.pstmn.io";

    public DeviceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<Device>> getDevices() {
        ResponseEntity<Device[]> devices = restTemplate.getForEntity(mockServerUrl + "/devices", Device[].class);
        return ResponseEntity.ok(Arrays.asList(Objects.requireNonNull(devices.getBody())));
    }

    public ResponseEntity<Device> findById (int id) {
        ResponseEntity<Device> device = restTemplate.getForEntity(mockServerUrl+"/device/"+id, Device.class);
        return ResponseEntity.ok(device.getBody());
    }
}