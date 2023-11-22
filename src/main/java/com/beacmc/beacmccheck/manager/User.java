package com.beacmc.beacmccheck.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Player {

    private final org.bukkit.entity.Player player;

    public Player(org.bukkit.entity.Player player) {
        this.player = player;
    }

    public void teleport(String world, double x, double y, double z) {
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        player.teleport(location);
    }

    public Location getLocation(String world, double x, double y, double z) {
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        return location;
    }
}
