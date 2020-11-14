package com.gmail.kyle94024.smpessentials.economy;

import com.gmail.kyle94024.smpessentials.SMPEssentials;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Essentials implements CommandExecutor {

    Economy econ = SMPEssentials.getEconomy();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("getbalance")){
            if (args.length > 0) {
                OfflinePlayer player = SMPEssentials.getPlugin().getServer().getPlayer(args[0]);
                if (player != null) {
                    double money = 0;
                    try {
                        money = econ.getBalance(player);
                    } catch(NullPointerException e) {
                        econ.createPlayerAccount(player);
                        money = econ.getBalance(player);
                    }
                    sender.sendMessage(player.getName() + "'s balance is %s" + econ.format(money));
                } else
                    sender.sendMessage("This player " + args[0] + " does not exist or has not joined the server.");
            } else{
                sender.sendMessage("Please declare the player of who you want to get the balance of.");

            }
        }

        else if (command.getName().equalsIgnoreCase("pay")) {
            // TODO: implement
            Player player = Bukkit.getServer().getPlayer(args[0]);
            Double money = Double.parseDouble(args[1]);
            SMPEssentials.getEconomy().withdrawPlayer(player, money);
            SMPEssentials.getEconomy().depositPlayer((OfflinePlayer) sender,money);

        // Player: /openaccount
        } else if (command.getName().equalsIgnoreCase("openaccount")) {
            OfflinePlayer player = (Player) sender;
            econ.createPlayerAccount(player);
            sender.sendMessage("Created " + args[0] + ".");
        }

        return true;
    }

}
