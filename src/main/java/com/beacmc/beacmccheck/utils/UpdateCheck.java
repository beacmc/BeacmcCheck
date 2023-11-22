package com.beacmc.beacmccheck.utils;

import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateCheck {
    public static void check(String version, String latestVersion) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=112394").openConnection();

            int timeout = 1750;
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();

        } catch (Exception exception) {}
    }
}
