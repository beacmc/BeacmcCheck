package com.beacmc.beacmccheck.utils;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Runner {

    public static void start(long delay, long period) {
        new BukkitRunnable() {

            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    User user = new User(player);
                    if (user.isCheck()) {
                        user.sendTitle("titles.check-start.title", "titles.check-start.subtitle");
                    }
                }
            }
        }.runTaskTimer(BeacmcCheck.getInstance(), delay, period);
    }
}
