package com.gmail.kyle94024.smpessentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println(label);
        sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Pong!");

        // If the player (or console) uses our command correctly, we want to return true
        return true;
    }
}
