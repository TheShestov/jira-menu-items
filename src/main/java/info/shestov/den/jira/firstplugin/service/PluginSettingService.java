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

    public String getParameter1() {
        return pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1") == null ? "no value" : pluginSettings.get(PLUGIN_STORAGE_KEY + ".parameter1").toString();
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
}
