package com.example.workflow;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.DecisionServiceImpl;
import org.camunda.bpm.engine.impl.ProcessEngineImpl;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**https://www.youtube.com/watch?v=HxtZf5VD6lQ**/
public class DisplayResultDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(DisplayResultDelegate.class.getName());

    @Autowired
    ResourceLoader resourceLoader;


    public void execute(DelegateExecution execution) throws InterruptedException, FileNotFoundException {
        //DecisionService decisionService = new DecisionServiceImpl();

        LOGGER.info("Hello Camunda");
        LOGGER.info("Name: {}",execution.getVariable("name"));

        /*DmnEngine dmnEngine = DmnEngineConfiguration
                .createDefaultDmnEngineConfiguration()
                .buildEngine();*/

        //https://docs.camunda.org/manual/7.15/user-guide/process-engine/process-engine-api/
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //https://docs.camunda.org/manual/7.15/user-guide/dmn-engine/evaluate-decisions/
        //https://forum.camunda.org/t/dmn-table-error-classnotfoundexception-de-odysseus-el-util-simplecontext/9635
        DecisionService decisionService = processEngine.getDecisionService();
        VariableMap variables = Variables.createVariables().putValue("name", execution.getVariable("name"));
        DmnDecisionTableResult process =  decisionService.evaluateDecisionTableByKey("food-decision", variables);
        Boolean result = process.getSingleEntry();
        LOGGER.info("Decision input: {}",execution.getVariable("name"));
        LOGGER.info("Decision result: {}",result);
        execution.setVariable("isNameFine",result);
    }
}