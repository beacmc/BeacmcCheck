package com.beacmc.beacmccheck.commands.CheckCommand;

import com.beacmc.beacmccheck.commands.CheckCommand.managers.CheckManager;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckCommandMain implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        User moder = new User((Player) sender);

        if(!moder.hasPermission("beacmccheck.use")) {
            moder.sendMessage("no-permission", null, null);
            return false;
        }

        if(args.length < 1 || args.length > 2) {
            moder.sendMessage("error-use", null, null);
            return false;
        }

        if(args.length == 1) {
            if(Bukkit.getPlayer(args[0]) != null) {
                new CheckManager(User.getUserByName(sender.getName()), User.getUserByName(args[0])).open((Player) sender);
                return true;
            }
            moder.sendMessage("player-offline", null, null);
            return false;
        }
        return true;
    }
}
