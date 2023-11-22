package com.beacmc.beacmccheck;

import com.beacmc.beacmccheck.commands.CheckCommand.CheckCommandCompleter;
import com.beacmc.beacmccheck.commands.CheckCommand.CheckCommandMain;
import com.beacmc.beacmccheck.listeners.ChatListener;
import com.beacmc.beacmccheck.listeners.CheckListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class BeacmcCheck extends JavaPlugin {


    public HashMap<UUID, Player> checkedPlayer = new HashMap<>();

    private YamlConfiguration messages;
    private static BeacmcCheck instance;

    @Override
    public void onEnable() {
        this.getCommand("check").setExecutor(new CheckCommandMain());
        Bukkit.getPluginManager().registerEvents(new CheckListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        instance = this;
        saveDefaultConfig();

        this.getCommand("check").setTabCompleter(new CheckCommandCompleter());
        this.messageConfig();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static BeacmcCheck getInstance() {
        return instance;
    }

    public void messageConfig() {
        this.saveResource("messages.yml", false);
        File file = new File(this.getDataFolder().getAbsolutePath() + "messages.yml");
        messages = YamlConfiguration.loadConfiguration(file);
    }

    public YamlConfiguration getMessages() {
        return messages;
    }



    static {
        instance = null;
    }
}
