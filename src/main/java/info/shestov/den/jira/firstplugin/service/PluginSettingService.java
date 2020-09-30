package info.shestov.den.jira.firstplugin.service;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;
import info.shestov.den.jira.firstplugin.MyActionClass;


import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PluginSettingService {

    private final PluginSettings pluginSettings;
    private final PluginSettingsFactory pluginSettingsFactory;

    private static final String PLUGIN_STORAGE_KEY = "info.shestov.den.jira.firstplugin.jira-menu-items";

    @Inject
    public PluginSettingService(@ComponentImport PluginSettingsFactory pluginSettingsFactory){
        this.pluginSettingsFactory = pluginSettingsFactory;
        this.pluginSettings = pluginSettingsFactory.createGlobalSettings();
    }

    public String getParameter1() throws NullPointerException {
        //return pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1") == null ? "no value" : pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1").toString();
        try{
            String p1 = pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1").toString();
            return isIntValidation(p1) ? p1 : "Please input int value > 0";
        }catch (NullPointerException n){
            return "no value";
        }
    }
    public void setParameter1(String parameter1){
        pluginSettings.put(PLUGIN_STORAGE_KEY + ".parameter1", parameter1);
    }

    public String getParameter2() {
        return pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter2") == null ? "no value" : pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter2").toString();
    }
    public void setParameter2(String parameter2){
        pluginSettings.put(PLUGIN_STORAGE_KEY + ".parameter2", parameter2);
    }

    private static boolean isIntValidation(String value) throws NumberFormatException{
        try {
            return Integer.parseInt(value) > 0 ? true : false;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
