package net.acticraft.plugin.actipirates.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("acti.fly")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.of("#C5AC7A") + "You changed your gamemode to: " + ChatColor.of("#C5AC7A") + "CREATIVE");
            }else{
                sender.sendMessage(ChatColor.of("#C5AC7A") + "You do not have permission to execute this command!");
            }
        }
        return true;}

    }

