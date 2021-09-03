package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("executionlistener")
public class ManualTaskDelegate implements ExecutionListener {

    private final Logger LOGGER = LoggerFactory.getLogger(ManualTaskDelegate.class.getName());

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        LOGGER.info("Manual Task Process: " + execution.getCurrentActivityName());
    }
}
