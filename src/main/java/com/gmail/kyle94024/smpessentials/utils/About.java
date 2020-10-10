package com.gmail.kyle94024.smpessentials.utils;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class About implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p1 = (Player) sender;
            p1.sendMessage("Hey, you are a player!");
            diamond(p1);
        } else
            sender.sendMessage("Hey, you are a console!");

        return true;
    }

    public void diamond(Player player) {
        player.getInventory().addItem(new ItemStack(Material.DIAMOND));
    }
}
