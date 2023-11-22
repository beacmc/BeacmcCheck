package com.beacmc.beacmccheck.commands.CheckCommand.subcommands;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckStart {

    public boolean start(CommandSender sender, String[] args) {
        if (args.length == 1 && Bukkit.getPlayer(args[0]).isOnline()) {
            User moder = new User((Player) sender);
            User checkedPlayer = new User(Bukkit.getPlayer(args[0]));
            if (checkedPlayer.isCheck()) {
                moder.sendMessage("already-check", null, null);
                return true;
            }

            new BukkitRunnable() {

                @Override
                public void run() {
                    if(checkedPlayer.isCheck()) {
                        checkedPlayer.sendTitle("titles.check-start.title", "titles.check-start.subtitle");
                    }
                }
            }.runTaskTimer(BeacmcCheck.getInstance(), 10L, 10L);

            checkedPlayer.addPlayerCheck((Player) sender);

            CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-start");


            moder.sendMessage("on-check-moderator", null, null);
            checkedPlayer.sendMessage("on-check", "{moderator}", moder.getName());
            return true;
        }
        return false;
    }
}
