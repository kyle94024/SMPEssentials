package com.gmail.kyle94024.smpessentials.economy;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.gmail.kyle94024.smpessentials.SMPEssentials.getEconomy;

public class Essentials implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("getbalance")){
            if (args.length > 0) {
                sender.sendMessage(args[0] + "'s balance is %s" + getEconomy().getBalance(args[0]));
            } else{
                sender.sendMessage("Please declare the player of who you want to get the balance of.");

            }
        }

        else if (label.equalsIgnoreCase("pay")) {
            // TODO: implement

        }

        return false;
    }

}
