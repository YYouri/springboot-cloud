package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.example.demo.communicator.RestTemplateClientCommunicator;

@Service
public class DiscoveryService {
	Logger log = LogManager.getLogger();
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    RestTemplateClientCommunicator restTemplateClientCommunicator;
    
    public List getServices(){
        List<String> services = new ArrayList<String>();
 
        /** 람다스트림 표현 */
        discoveryClient.getServices().forEach(serviceName -> {
            discoveryClient.getInstances(serviceName).forEach(instance->{
                services.add( String.format("%s:%s",serviceName,instance.getUri()));
            });
        });
        return services;
    }
    public String resttemplate(String id) {
        log.info("Communicating by RestTemplateClientCommunicator.");
        return restTemplateClientCommunicator.getName(id);
    }
}
