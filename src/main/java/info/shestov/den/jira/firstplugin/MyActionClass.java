package info.shestov.den.jira.firstplugin;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.pluginsettings.PluginSettings;
import info.shestov.den.jira.firstplugin.service.PluginSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;

import javax.inject.Inject;


public class MyActionClass extends JiraWebActionSupport
{
    private PluginSettingService pluginSettingService;
    private static final Logger log = LoggerFactory.getLogger(MyActionClass.class);

    private String parameter1;
    private String parameter2;

    @Inject
    public MyActionClass(PluginSettingService pluginSettingService) {
        this.pluginSettingService = pluginSettingService;
    }

    @Override
    public String doExecute() throws Exception{
        return SUCCESS;
    }

    public String getParameter1() {
        return pluginSettingService.getParameter1();
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return pluginSettingService.getParameter2();
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String doSave(){
        pluginSettingService.setParameter1(parameter1);
        pluginSettingService.setParameter2(parameter2);
        return SUCCESS;
    }
}