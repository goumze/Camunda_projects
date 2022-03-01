package com.example.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Resource
  private RuntimeService runtimeService;

  @Override
  public void run(String...args){
    final String businessKey = UUID.randomUUID().toString();

    Map<String,Object> processOrderData = new HashMap<>();
    processOrderData.put("customerName","Goutam Mishra");
    processOrderData.put("item","Mobile");
    processOrderData.put("giftPackagingIsNeeded",true);
    processOrderData.put("zipcode","1234567");

    Map<String,Object> processOrderDataShipment = new HashMap<>();
    processOrderDataShipment.put("customerName","Goutam Mishra");
    processOrderDataShipment.put("item","Mobile");
    processOrderDataShipment.put("zipcode","1234567");

    //Starting order management process
    runtimeService.startProcessInstanceByKey("order-send-receive-task",businessKey,processOrderData);

    //Starting shipping management process
    runtimeService.startProcessInstanceByKey("order-receive-task",businessKey,processOrderData);

  }

}