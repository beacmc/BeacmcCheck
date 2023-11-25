package com.beacmc.beacmccheck.api.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CheckStartEvent extends Event implements Cancellable {


    private static final HandlerList handlers = new HandlerList();
    private final Player moderator;
    private final Player checkedPlayer;

    private boolean isCancelled;

    public CheckStartEvent(Player moderator, Player checkedPlayer) {

        this.moderator = moderator;
        this.checkedPlayer = checkedPlayer;
        this.isCancelled = false;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }


    public @NotNull HandlerList getHandlerList() {
        return handlers;
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
