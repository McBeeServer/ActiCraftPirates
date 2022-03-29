package net.acticraft.plugin.actipirates;

import net.acticraft.plugin.actipirates.Commands.Fly;
import net.acticraft.plugin.actipirates.Commands.Gmc;
import net.acticraft.plugin.actipirates.Commands.Gms;
import net.acticraft.plugin.actipirates.Commands.Gmsp;
import net.acticraft.plugin.actipirates.Core.ScoreBoard;
import net.acticraft.plugin.actipirates.Guis.BoatGui;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActiPirates extends JavaPlugin {
    private static ActiPirates instance;
    @Override
    public void onEnable() {
        instance = this;


        getCommand("gmsp").setExecutor(new Gmsp());
        getCommand("gms").setExecutor(new Gms());
        getCommand("gmc").setExecutor(new Gmc());
        getCommand("fly").setExecutor(new Fly());
        getCommand("boats").setExecutor(new BoatGui());


        getServer().getPluginManager().registerEvents(new ScoreBoard(), this);
        getServer().getPluginManager().registerEvents(new BoatGui(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ActiPirates getInstance() {
        return instance;
    }
}
