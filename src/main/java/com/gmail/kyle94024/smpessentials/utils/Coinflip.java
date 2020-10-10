package com.gmail.kyle94024.smpessentials.utils;
import java.util.Scanner;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.Random;

public class Coinflip implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int ascii = 0x2713;
        String checkmark = Character. toString((char) ascii);

        double randomnum = Math.random();
        if (Math.round(randomnum) == 1) {
            sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + checkmark + " You Win!");
        } else {
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You Lose!");

        }
        return true;
    }

}
