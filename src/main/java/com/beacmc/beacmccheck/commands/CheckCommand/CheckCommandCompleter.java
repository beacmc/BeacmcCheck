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
import java.util.stream.Collectors;

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

        if(args.length == 2) {
            return args.length == 2 ? (List)getCompletions().stream().filter((category) -> {
                return category.toLowerCase().startsWith(args[1].toLowerCase());
            }).collect(Collectors.toList()) : null;
        }
        return list;
    }

    private static List<String> getCompletions() {
        ArrayList<String> list = new ArrayList<>();

        list.add("cancel");
        list.add("confirm");
        return list;
    }
}
