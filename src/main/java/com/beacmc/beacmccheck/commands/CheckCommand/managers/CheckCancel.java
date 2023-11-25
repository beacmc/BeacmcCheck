package com.beacmc.beacmccheck.commands.CheckCommand.managers;

import com.beacmc.beacmccheck.api.handlers.CheckCancelEvent;
import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CheckCancel implements Listener {

    @EventHandler
    public void start(CheckCancelEvent event) {
        if(event.getCheckedPlayer() != null && event.getModerator() != null) {
            User checkedPlayer = new User(event.getCheckedPlayer());
            User moder = new User(event.getModerator());
            if (checkedPlayer.isCheck()) {
                checkedPlayer.removePlayerCheck();
                moder.sendMessage("failed-check-moderator", null, null);
                CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-cancel");
                return;
            }
            checkedPlayer.sendMessage("messages.no-check", null, null);
        }
    }
}
