package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**https://www.youtube.com/watch?v=HxtZf5VD6lQ**/
public class LoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("{}",execution.getCurrentActivityName());
    }
}
