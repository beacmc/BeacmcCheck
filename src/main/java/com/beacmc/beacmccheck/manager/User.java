package com.beacmc.beacmccheck.manager;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.data.Data;
import com.beacmc.beacmccheck.utils.Hex;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class User {

    private final org.bukkit.entity.Player player;
    private final Config messages = new Config("messages.yml");
    public User(org.bukkit.entity.Player player) {
        this.player = player;
    }

    public void sendMessage(String message, @Nullable String target, @Nullable String replacement) {

        String replace;

        if(target != null && replacement != null) {
            replace = Hex.color(
                    messages.getString("messages." + message)
                            .replace("{PREFIX}", Hex.color(messages.getString("messages.prefix")))
                    ).replace(target, replacement);
        } else {
            replace = Hex.color(
                    messages.getString("messages." + message)
                            .replace("{PREFIX}", Hex.color(messages.getString("messages.prefix")))
            );
        }

        player.sendMessage(
                replace
        );
    }

    public boolean hasPermission(String permission) {
        if (player.hasPermission(permission)) {
            return true;
        } else {
            return false;
        }
    }

    public void addPlayerCheck(Player moder) {
        if (!Data.contains(player.getUniqueId())) {
            Data.addContains(player.getUniqueId(), moder);
        }
    }

    public void removePlayerCheck() {
        if (Data.contains(player.getUniqueId())) {
            Data.removeContains(player.getUniqueId());
        }
    }



    public Player getModer() {
        return BeacmcCheck.getInstance().checkedPlayer.get(player.getUniqueId());
    }

    public boolean isCheck() {
        return Data.contains(player.getUniqueId());
    }


    public String getName() {
        return player.getName();
    }

    public UUID getUUID() {
        return player.getUniqueId();
    }

    public void sendTitle(String title, String subtitle) {
        player.sendTitle(
                Hex.color(messages.getString(title)),
                Hex.color(messages.getString(subtitle)),
                1, 35, 20
        );
        System.out.println("true");
    }

    public void teleport(String world, double x, double y, double z) {
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        player.teleport(location);
    }

    public Location getLocation(String world, double x, double y, double z) {
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        return location;
    }

    public Player getPlayer() {
        return player;
    }
}
