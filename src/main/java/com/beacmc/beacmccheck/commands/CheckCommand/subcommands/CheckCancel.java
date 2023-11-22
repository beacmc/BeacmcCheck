package com.beacmc.beacmccheck.commands.CheckCommand.subcommands;

import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckCancel {

    public boolean start(CommandSender sender, String[] args) {
        if(args[1].equalsIgnoreCase("cancel") && Bukkit.getPlayer(args[0]) != null) {
            User checkedPlayer = new User(Bukkit.getPlayer(args[0]));
            User moder = new User((Player) sender);
            if(checkedPlayer.isCheck()) {
                checkedPlayer.removePlayerCheck();
                moder.sendMessage("failed-check-moderator", null, null);
                CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-cancel");
                return true;
            }
            return false;
        }
        return false;
    }
}
