package com.hermes.web.addorder;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOrderFlowHandler extends AbstractFlowHandler {

    private static final String DEFAULT_URL = "/addorder";

    @Override
    public String handleExecutionOutcome(FlowExecutionOutcome outcome,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        System.out.println("Something happenning!");
        return DEFAULT_URL;
    }

    @Override
    public String handleException(FlowException e,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        if (e instanceof NoSuchFlowExecutionException) {
            return DEFAULT_URL;
        } else {
            throw e;
        }
    }

}
