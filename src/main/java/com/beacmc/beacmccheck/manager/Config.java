package com.beacmc.beacmccheck.manager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class Config {

    private final File file;
    private YamlConfiguration configuration;

    public Config(String file) {
        this.file = new File("plugins/BeacmcCheck/" + file);
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void reloadConfig() {
        File config = new File("plugins/BeacmcCheck/" + file);
        configuration = YamlConfiguration.loadConfiguration(config);
    }

    public String getString(String path) {
        return configuration.getString(path);
    }

    public boolean getBoolean(String path) {
        return configuration.getBoolean(String.valueOf(Boolean.valueOf(path)));
    }

    public List<String> getList(String path) {
        return configuration.getStringList(path);
    }
}
