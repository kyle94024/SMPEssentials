package com.gmail.kyle94024.smpessentials.utils;


import com.gmail.kyle94024.smpessentials.SMPEssentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.ChatColor;
import java.util.HashMap;
import java.util.Map;

public class Teleport implements CommandExecutor {

    // [0] => playerRequester [1] => playerTarget
    private static Map<Player, Map.Entry<Player, Integer>> currentRequests = new HashMap<Player,Map.Entry<Player,Integer>>();
    private Integer Id = Map<1>;
    // { {Player player1, Player player2},{Player player3, PLayer player4} }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // This executes when the command sender is not a player.
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This command is for players only.");
            return false;
        }

        final Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("tpa")) {
            // This handles the /tpa command
            if (args.length == 1) {
                final Player targetPlayer = Bukkit.getPlayer(args[0]);

                if (targetPlayer == null) {
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Error: Sorry, that player is not online or does not exist.");
                    return false;
                } else if (targetPlayer == player) {
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Error: You cannot teleport to yourself!");
                    return false;
                }

                int keepAlive = 400;

                sendRequest(player, targetPlayer);

                int task = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) SMPEssentials.getPlugin(), new Runnable() {

                    @Override
                    public void run() {
                        killRequest(targetPlayer);

                    }
                }, keepAlive);

            } else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Incorrect usage! Send a teleport request to a player.");
                player.sendMessage("/tpa <player>");
            }

            return true;
        } else if (command.getName().equalsIgnoreCase("tpaccept")) {
            Player target = player;
            if (currentRequests.containsKey(target)) {
                Player requester = currentRequests.get(target);
                currentRequests.remove(target);
                if (requester.isOnline()) {
                    target.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport request from " + requester.getDisplayName() + " accepted.");
                    requester.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + target.getDisplayName() + " was accepted. Teleporting...");
                    requester.teleport(target, PlayerTeleportEvent.TeleportCause.COMMAND);
                    return true;
                } else {
                    target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Error: The player who requested to teleport has left or does not exist anymore");
                    return false;
                }
            } else {
                target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Error: No open teleport requests exist.");
                return false;
            }
        } else if (command.getName().equalsIgnoreCase("tpdeny")) {
            // TODO: Implement
            if (currentRequests.containsKey(player)){
                killRequest(player,"denied");

                return true;
            }
            else{
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "There is no teleport request to deny.");
            }

        }
        return false;
    }



    public void sendRequest(Player requester, Player target) {
        currentRequests.put(target,<requester,>);
        requester.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD +"Sending a teleport request to " + target.getDisplayName() + ".");

        String[] messages = new String[3];
        messages[0] = ChatColor.BLUE + "" + ChatColor.BOLD + requester.getDisplayName() + " is sending you a teleport request.";
        messages[1] = ChatColor.BLUE + "" + ChatColor.BOLD + "To accept this request type /tpaccept";
        messages[2] = ChatColor.BLUE + "" + ChatColor.BOLD + "To deny this request type /tpdeny";
        target.sendMessage(messages);

    }

    public boolean killRequest(Player target) {
        return killRequest(target,"expired");
    }


    public boolean killRequest(Player target, String status ) {
        if (currentRequests.containsKey(target)) {
            Player requester = currentRequests.get(target);
            if (requester.isOnline()) {
                if (status.equals("expired")){
                    requester.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Your teleport request to " + target.getDisplayName() + " has expired.");
                }
                else if (status.equals("denied")){
                    requester.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Your teleport request to " + target.getDisplayName() + " was denied.");
                }
            }
            if (target.isOnline()) {
                if(status.equals("expired")){
                    target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + requester.getDisplayName() + "'s teleport request to you has expired.");
                }
               else if(status.equals("denied")){
                   target.sendMessage((ChatColor.RED + "" + ChatColor.BOLD + "You have denied " + requester.getDisplayName() + "'s teleport request."));
                }
            }
            currentRequests.remove(target);
            return true;

        }
        return false;
    }


}
