package com.gmail.kyle94024.smpessentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.Random;

public class ChooseColor implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {




        double randomnum = Math.random()*9;
        if (Math.round(randomnum) == 1) {
            sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Aqua!");
        }
        if (Math.round(randomnum) == 2) {
            sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue!");
        }
        if (Math.round(randomnum) == 3) {
            sender.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + "Black!");
        }
        if (Math.round(randomnum) == 4) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Gold!");
        }
        if (Math.round(randomnum) == 5) {
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Red!");
        }
        if (Math.round(randomnum) == 6) {
            sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Green!");
        }
        if (Math.round(randomnum) == 7) {
            sender.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "White!");
        }
        if (Math.round(randomnum) == 8) {
            sender.sendMessage(ChatColor.MAGIC + "" + ChatColor.BOLD + "uwu");
        }
        if (Math.round(randomnum) == 9) {
            sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Yellow!");
        }





        return true;
    }

}