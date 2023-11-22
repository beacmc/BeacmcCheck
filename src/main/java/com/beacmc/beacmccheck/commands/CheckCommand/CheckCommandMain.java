package com.beacmc.beacmccheck.commands.CheckCommand;

import com.beacmc.beacmccheck.commands.CheckCommand.subcommands.CheckCancel;
import com.beacmc.beacmccheck.commands.CheckCommand.subcommands.CheckConfirm;
import com.beacmc.beacmccheck.commands.CheckCommand.subcommands.CheckStart;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckCommandMain implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        User moder = new User((Player) sender);
        if(args.length < 1 || args.length > 2) {
            moder.sendMessage("error-use", null, null);
            return false;
        }

        if(args.length == 1) {
            if(Bukkit.getPlayer(args[0]) != null) {
                User checkedPlayer = new User(Bukkit.getPlayer(args[0]));
                return new CheckStart().start((CommandSender) moder.getPlayer(), args);
            }
            moder.sendMessage("player-offline", null, null);
            return false;
        }



        if(args.length == 2) {
            switch (args[1].toLowerCase()) {
                case "confirm": {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        return new CheckConfirm().start(moder.getPlayer(), args);
                    }
                    return false;
                }
                case "cancel": {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        return new CheckCancel().start(moder.getPlayer(), args);
                    }
                    return false;
                }
            }
        }
        return false;

    }
}
