package com.phati.springmicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class RequestController {

    @GetMapping("/get-java-version")
    public ResponseEntity<?> getJavaVersion() {
        Map<String, Object> responseMap = new HashMap<>();
        String javaVersion = System.getProperty("java.version");
        responseMap.put("javaVersion", javaVersion);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getHealth() {
        Map<String, Object> responseMap = new HashMap<>();
        InetAddress ipAddr = null;
        String javaVersion = System.getProperty("java.version");
        try {
            ipAddr = InetAddress.getLocalHost();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseMap.put("javaVersion", javaVersion);
        responseMap.put("message", "Hello from server");
        responseMap.put("Ip Address", ipAddr.getHostAddress());
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}