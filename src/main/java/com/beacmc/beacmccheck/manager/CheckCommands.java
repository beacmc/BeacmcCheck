package com.beacmc.beacmccheck.manager;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.utils.Hex;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.clip.placeholderapi.PlaceholderAPI;

import java.util.List;

public class CheckCommands {

    public static void start(Player player, String path) {
        List<String> strings = BeacmcCheck.getInstance().getConfig().getStringList(path);

        for (String execute : strings) {
            Bukkit.dispatchCommand(
                    Bukkit.getConsoleSender(),
                    Hex.color(PlaceholderAPI.setPlaceholders(player, execute))
            );
        }

    }

}
