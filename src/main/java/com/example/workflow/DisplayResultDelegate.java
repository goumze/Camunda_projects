package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**https://www.youtube.com/watch?v=HxtZf5VD6lQ**/
public class DisplayResultDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(DisplayResultDelegate.class.getName());

    public void execute(DelegateExecution execution) throws InterruptedException {
        LOGGER.info("Hello Camunda");
        LOGGER.info("{}",execution.getVariable("name"));
        //execution.getVariable("name");
        //execution.setVariable("name","Goutam Mishra");
        //execution.setVariable("isNameFine",true);
    }
}