package com.gmail.kyle94024.smpessentials;

import com.gmail.kyle94024.smpessentials.utils.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMPEssentials extends JavaPlugin {

    private static SMPEssentials plugin;
    private static Economy econ;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getLogger().info("SMPEssentials is now enabled!");
        this.getCommand("ping").setExecutor(new Ping());
        this.getCommand("about").setExecutor(new About());
        this.getCommand("coinflip").setExecutor(new Coinflip());
        this.getCommand("choosecolor").setExecutor(new ChooseColor());
        this.getCommand("tpa").setExecutor(new Teleport());
        this.getCommand("tpaccept").setExecutor(new Teleport());
        this.getCommand("tpdeny").setExecutor(new Teleport());
        setupEconomy();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static SMPEssentials getPlugin() {
        return plugin;
    }
    public static Economy getEconomy() { return econ; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("SMPEssentials is now disabled!");
    }

}
