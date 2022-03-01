package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.annotation.Resource;

public class RecieveTask implements JavaDelegate {

    @Resource


    @Override
    public void execute(DelegateExecution execution) throws Exception {

    }
}
