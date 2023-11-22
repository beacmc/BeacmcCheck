package com.beacmc.beacmccheck.api.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class onCheckAddEvent extends Event implements Cancellable {

    private final Player moderator;
    private final Player checkedPlayer;

    private boolean isCancelled;

    public onCheckAddEvent(Player moderator, Player checkedPlayer) {

        this.moderator = moderator;
        this.checkedPlayer = checkedPlayer;
        this.isCancelled = false;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }


    public @NotNull HandlerList getHandlersList() {
        return null;
    }

    public Player getCheckedPlayer() {
        return checkedPlayer;
    }

    public Player getModerator() {
        return moderator;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }
}
