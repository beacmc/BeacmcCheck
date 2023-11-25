package com.beacmc.beacmccheck.commands.CheckCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CheckCommandCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        ArrayList<String> list = new ArrayList<>();

        if(args.length == 1) {
            String input = args[0].toLowerCase();

            for (Player player : Bukkit.getOnlinePlayers()) {
                String name = player.getName();
                if(name.toLowerCase().startsWith(input)) {
                    list.add(name);
                }
            }
        }
        return null;
    }
}
