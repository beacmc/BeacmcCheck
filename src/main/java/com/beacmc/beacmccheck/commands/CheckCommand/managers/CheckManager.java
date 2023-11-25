package com.beacmc.beacmccheck.commands.CheckCommand.managers;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.api.handlers.CheckCancelEvent;
import com.beacmc.beacmccheck.api.handlers.CheckConfirmEvent;
import com.beacmc.beacmccheck.api.handlers.CheckStartEvent;
import com.beacmc.beacmccheck.manager.CheckCommands;
import com.beacmc.beacmccheck.manager.Config;
import com.beacmc.beacmccheck.manager.User;
import com.beacmc.beacmccheck.manager.menu.CheckMenuUtil;
import com.beacmc.beacmccheck.utils.Hex;
import com.devoirr.guilib.api.annotations.Click;
import com.devoirr.guilib.containers.Panel;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CheckManager extends Panel {

    private final Config messages = new Config("messages.yml");

    private User moder;
    private User checkedPlayer;



    public CheckManager(User moder, User checkedPlayer) {

        super(BeacmcCheck.getInstance());
        this.checkedPlayer = checkedPlayer;
        this.moder = moder;
    }







    @Override
    public String getTitle() {
        return Hex.color(messages.getString("gui.check.title"));
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public void setItems() {

        inventory.setItem(11, CheckMenuUtil.getTeleportItem());

        if (checkedPlayer.isCheck()) {
            inventory.setItem(13, CheckMenuUtil.getCheckFinishItem());
        } else {
            inventory.setItem(13, CheckMenuUtil.getCheckStartItem());
        }
    }

    @Click(slots = 11)
    public void click11(InventoryClickEvent event) {
        if(checkedPlayer != null) {
            moder.teleport(checkedPlayer.getLocation());
        }
    }


    @Click(slots = 13)
    public void click13(InventoryClickEvent event) {
        if (checkedPlayer.isCheck()) {
            if(event.isLeftClick()) {
                Bukkit.getPluginManager().callEvent(new CheckCancelEvent(moder.getPlayer(), checkedPlayer.getPlayer()));
            }
            else if (event.isRightClick()) {
                Bukkit.getPluginManager().callEvent(new CheckConfirmEvent(moder.getPlayer(), checkedPlayer.getPlayer()));
            }
            checkedPlayer.removePlayerCheck();
            inventory.close();
        }
        else {
            Bukkit.getPluginManager().callEvent(new CheckStartEvent(moder.getPlayer(), checkedPlayer.getPlayer()));
            if (checkedPlayer.getPlayer() != null && moder.getPlayer() != null) {
                if (checkedPlayer.isCheck()) {
                    moder.sendMessage("already-check", null, null);
                    return;
                }
                checkedPlayer.addPlayerCheck(checkedPlayer.getPlayer());
                CheckCommands.start(checkedPlayer.getPlayer(), "settings.commands.check-start");
                moder.sendMessage("on-check-moderator", null, null);
                checkedPlayer.sendMessage("on-check", "{moderator}", moder.getName());
                checkedPlayer.addPlayerCheck(moder.getPlayer());
            }
            inventory.close();
        }
    }
}
