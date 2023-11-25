package com.beacmc.beacmccheck.commands.CheckCommand.managers;

import com.beacmc.beacmccheck.api.handlers.CheckConfirmEvent;
import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CheckConfirm implements Listener {


    @EventHandler
    public void start(CheckConfirmEvent event) {
        if(event.getCheckedPlayer() != null && event.getModerator() != null) {
            User moder = new User(event.getModerator());
            User checkedPlayer = new User(event.getCheckedPlayer());
            if(checkedPlayer.isCheck()) {
                moder.sendMessage("success-check-moderator", null, null);
                checkedPlayer.sendMessage("success-check", null, null);
                checkedPlayer.sendTitle("titles.check-confirm.title", "titles.check-confirm.subtitle");
                CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-confirm");
                checkedPlayer.removePlayerCheck();
                return;
            }
            checkedPlayer.sendMessage("messages.no-check", null, null);
        }
    }
}
