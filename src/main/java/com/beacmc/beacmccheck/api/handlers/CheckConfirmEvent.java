package com.beacmc.beacmccheck.api.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CheckConfirmEvent extends Event {


    private static final HandlerList handlers = new HandlerList();

    private final Player moderator;
    private final Player checkedPlayer;

    public CheckConfirmEvent(Player moder, Player checkedPlayer) {
        this.moderator = moder;
        this.checkedPlayer = checkedPlayer;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getModerator() {
        return moderator;
    }

    public Player getCheckedPlayer() {
        return checkedPlayer;
    }
}
