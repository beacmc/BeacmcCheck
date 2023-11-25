package com.beacmc.beacmccheck.manager.menu;

import com.beacmc.beacmccheck.manager.Config;
import com.beacmc.beacmccheck.utils.Hex;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CheckMenuUtil {

    private static final Config messages = new Config("messages.yml");

    public static ItemStack getCheckStartItem() {
        ItemStack im = new ItemStack(Material.LIME_WOOL);
        ItemMeta itemMeta = im.getItemMeta();
        itemMeta.setDisplayName(Hex.color(messages.getString("gui.check.check-start.display-name")));

        ArrayList<String> list = new ArrayList<>(messages.getList("gui.check.check-start.lore"));
        ArrayList<String> listik = new ArrayList<>();
        for (String execute : list) {
            listik.add(Hex.color(execute));
        }
        itemMeta.setLore(listik);
        im.setItemMeta(itemMeta);
        return im;
    }

    public static ItemStack getCheckFinishItem() {
        ItemStack im = new ItemStack(Material.RED_WOOL);
        ItemMeta itemMeta = im.getItemMeta();
        itemMeta.setDisplayName(Hex.color(messages.getString("gui.check.check-finish.display-name")));

        ArrayList<String> list = new ArrayList<>(messages.getList("gui.check.check-finish.lore"));
        ArrayList<String> listik = new ArrayList<>();
        for (String execute : list) {
            listik.add(Hex.color(execute));
        }
        itemMeta.setLore(listik);
        im.setItemMeta(itemMeta);
        return im;
    }

    public static ItemStack getTeleportItem() {
        ItemStack im = new ItemStack(Material.ENDER_PEARL);
        ItemMeta itemMeta = im.getItemMeta();
        itemMeta.setDisplayName(Hex.color(messages.getString("gui.check.teleport.display-name")));

        ArrayList<String> list = new ArrayList<>(messages.getList("gui.check.teleport.lore"));
        ArrayList<String> listik = new ArrayList<>();
        for (String execute : list) {
            listik.add(Hex.color(execute));
        }
        itemMeta.setLore(listik);
        im.setItemMeta(itemMeta);
        return im;
    }
}
