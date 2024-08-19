package com.example.devices.controllers;

import com.example.devices.entities.Device;
import com.example.devices.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
