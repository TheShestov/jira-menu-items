package com.atlassian.jira.firstplugin.jira.webwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

public class MyActionClass extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(MyActionClass.class);

    @Override
    public String execute() throws Exception {

        return SUCCESS; //returns SUCCESS
    }
}
