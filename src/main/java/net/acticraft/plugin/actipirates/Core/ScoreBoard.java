package net.acticraft.plugin.actipirates.Core;

import fr.mrmicky.fastboard.FastBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import net.acticraft.plugin.actipirates.ActiPirates;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreBoard implements Listener {


    private final Map<UUID, FastBoard> boards = new HashMap<>();

    public ScoreBoard() {
        Bukkit.getServer().getScheduler().runTaskTimer(ActiPirates.getInstance(), () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }

    @EventHandler

    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        FastBoard lobbysb = new FastBoard(player);

        lobbysb.updateTitle(ChatColor.of("#C5AC7A") + "" + ChatColor.BOLD + "ActiPirates");

        this.boards.put(player.getUniqueId(), lobbysb);


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard lobbysb = this.boards.remove(player.getUniqueId());

        if (lobbysb != null) {
            lobbysb.delete();
        }

    }


    private void updateBoard(FastBoard lobbysb) {
        lobbysb.updateLines(
                "",
                ChatColor.of("#C5AC7A")+""+ChatColor.BOLD + "Personal Stats:",
                ChatColor.of("#738291") + "» " + ChatColor.of("#C5AC7A") + "PVP: " + ChatColor.of("#E8CD95") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"%player_allow_flight%"),
                ChatColor.of("#738291") + "» " + ChatColor.of("#C5AC7A") + "Kills: " + ChatColor.of("#E8CD95") + lobbysb.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                ChatColor.of("#738291") + "» " + ChatColor.of("#C5AC7A") + "Deaths: " + ChatColor.of("#E8CD95") + lobbysb.getPlayer().getStatistic(Statistic.DEATHS),
                ChatColor.of("#738291") + "» " + ChatColor.of("#C5AC7A") + "Coins: " + ChatColor.of("#E8CD95") + PlaceholderAPI.setPlaceholders(lobbysb.getPlayer(),"100"),
                "",
                ChatColor.of("#C5AC7A") + "" + ChatColor.BOLD + "www.acticraft.net");


        ;
    }
}
