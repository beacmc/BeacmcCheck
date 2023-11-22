package com.beacmc.beacmccheck.commands.CheckCommand.subcommands;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.Config;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckConfirm {

    private final Config messages = new Config("messages.yml");

    public boolean start(CommandSender sender, String[] args) {
        if(args[1].equalsIgnoreCase("confirm") && Bukkit.getPlayer(args[0]).isOnline()) {
            User moder = new User((Player) sender);
            User checkedPlayer = new User(Bukkit.getPlayer(args[0]));
            if(checkedPlayer.isCheck()) {
                moder.sendMessage("success-check-moderator", null, null);
                checkedPlayer.sendMessage("success-check", null, null);


                checkedPlayer.sendTitle("titles.check-confirm.title", "titles.check-confirm.subtitle");



                CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-confirm");

                checkedPlayer.removePlayerCheck();
                return true;
            }
            return false;
        }
        return false;
    }
}
