package com.example.devices.controllers;

import com.example.devices.entities.Device;
import com.example.devices.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    @Qualifier("deviceService")
    private DeviceService deviceService;


    @GetMapping("/getall")
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getDevices().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> findById (@PathVariable("id") int id) {
        return ResponseEntity.ok(deviceService.findById(id).getBody());
    }

    @PostMapping("/createdevice")
    public ResponseEntity<String> sendDataToMockServer(@RequestBody Device device) {
        String response = deviceService.sendDataToMockServer(device);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletedevice/{id}")
    public ResponseEntity<String> deleteDeviceFromMockServer(@PathVariable("id") int idDevice) {
        //DELETEg
        ResponseEntity<String> response = deviceService.deleteDeviceFromMockServer(idDevice);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
