package net.acticraft.plugin.actipirates.Events;

import org.bukkit.Material;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CampFireFix implements Listener {

    @EventHandler
    public void CampFireFix(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.CAMPFIRE) {
            BlockData data = e.getBlock().getBlockData();
            if (data instanceof Campfire) {
                Campfire campfire = (Campfire) data;
                campfire.setLit(false);
                if (campfire.isLit()) {

                }
                e.getBlock().setBlockData(campfire);
            }
        }


    }

    @EventHandler
    public void CampFireFix(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getClickedBlock().getType() == Material.CAMPFIRE) {
                BlockData data = e.getClickedBlock().getBlockData();
                if (data instanceof Campfire) {
                    Campfire campfire = (Campfire) data;
                    campfire.setLit(!campfire.isLit());
                    e.getClickedBlock().setBlockData((BlockData) campfire);
                }
            }
        }
    }
}