package com.beacmc.beacmccheck.data;

import com.beacmc.beacmccheck.BeacmcCheck;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Data {

    private static BeacmcCheck plugin = BeacmcCheck.getInstance();

    public static boolean contains(UUID uuid) {
        return plugin.checkedPlayer.containsKey(uuid);
    }

    public static void addContains(UUID uuid, Player moder) {
        plugin.checkedPlayer.put(uuid, moder);
    }

    public static void removeContains(UUID uuid) {
        plugin.checkedPlayer.remove(uuid);
    }

    public static Player getModer(UUID chekedPlayerUUID) {
        return plugin.checkedPlayer.get(chekedPlayerUUID);
    }
}
