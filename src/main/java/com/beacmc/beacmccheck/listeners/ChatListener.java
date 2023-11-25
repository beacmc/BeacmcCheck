package com.beacmc.beacmccheck.listeners;

import com.beacmc.beacmccheck.BeacmcCheck;
import com.beacmc.beacmccheck.manager.Config;
import com.beacmc.beacmccheck.manager.User;
import com.beacmc.beacmccheck.utils.Hex;
import io.papermc.paper.event.player.AsyncChatEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ChatListener implements Listener {

    private final Config messages = new Config("messages.yml");

    @EventHandler
    public void chatEvent(AsyncChatEvent event) {
        User user = new User(event.getPlayer());
        if(user.isCheck()) {
            event.setCancelled(true);
            TextComponent textComponent = (TextComponent) event.originalMessage();
            String message = textComponent.content();
            String chat_format = Hex.color(BeacmcCheck.getInstance().getConfig().getString("settings.main.chat-format")
                    .replace("%message%", message)
                    .replace("{PREFIX}", messages.getString("messages.prefix")));
            Player moder = user.getModer();
            moder.sendMessage(PlaceholderAPI.setPlaceholders(event.getPlayer(), chat_format));
        }
    }
}
