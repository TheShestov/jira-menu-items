package info.shestov.den.jira.firstplugin.webwork;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.pluginsettings.PluginSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;

import javax.inject.Inject;


public class MyActionClass extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(MyActionClass.class);

    private PluginSettings pluginSettings;

    private static final String PLUGIN_STORAGE_KEY = "com.atlassian.jira.firstplugin.jira-menu-items";

    private String parameter1;
    private String parameter2;

    @Inject
    public MyActionClass(@ComponentImport PluginSettingsFactory pluginSettingsFactory) {
        this.pluginSettings = pluginSettingsFactory.createGlobalSettings();
    }


    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }

    public String getParameter1() {
        /*if (pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1") == null || pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1").equals("")){
            String noName = "";
            pluginSettings.put(PLUGIN_STORAGE_KEY +".parameter1", noName);
        }*/
        return (String) pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1");
    }

    public void setParameter1(String parameter1) {
        pluginSettings.put(PLUGIN_STORAGE_KEY + ".parameter1", parameter1);
    }

    public String getParameter2() {
        /*if (pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter2") == null || pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter2").equals("")){
            String noName = "";
            pluginSettings.put(PLUGIN_STORAGE_KEY +".parameter2", noName);
        }*/
        return (String) pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter2");
    }

    public void setParameter2(String parameter2) {
        pluginSettings.put(PLUGIN_STORAGE_KEY + ".parameter2", parameter2);
    }
/*
    public void clear(){
        pluginSettings.put("111",PLUGIN_STORAGE_KEY + ".parameter1");
        PluginSettings bu = pluginSettings.get("button");
    }*/
    //For test
    /*public String temp(){

        if (pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1") == null){
            return "в PLUGIN_STORAGE_KEY + .parameter1 пусто";
        }
        return (String) pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1");
    }*/
}