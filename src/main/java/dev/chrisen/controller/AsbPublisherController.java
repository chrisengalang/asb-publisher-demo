package dev.chrisen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsbPublisherController {

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/{message}")
    public void publishMessage(@PathVariable String message) {
        streamBridge.send("publisher-0", message);
    }

}
