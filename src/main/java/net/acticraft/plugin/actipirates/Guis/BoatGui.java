package net.acticraft.plugin.actipirates.Guis;


import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class BoatGui implements CommandExecutor, Listener {
@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
        Player player = (Player) sender;
        if (player.hasPermission("actipirates.boat")) {


            Inventory BoatGui = Bukkit.createInventory(null, 9, ChatColor.of("#78B5DA") + "Boat Menu");

            // SetItems
            ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
            ItemStack playerboat = new ItemStack(Material.OAK_BOAT, 1);
            ItemStack notunlockedyet = new ItemStack(Material.RED_STAINED_GLASS, 1);


            ItemMeta morning_meta = none.getItemMeta();
            morning_meta.setDisplayName(ChatColor.of("#DA7878") + "");
            none.setItemMeta(morning_meta);

            ItemMeta playerboat_meta = playerboat.getItemMeta();
            playerboat_meta.setDisplayName(ChatColor.of("#F1981E") + "Your Boat");
            ArrayList<String> playerboat_lore = new ArrayList<>();
            playerboat_lore.add(ChatColor.of("#E8977F") + "Value: 1000");
            playerboat_lore.add(ChatColor.of("#E8977F") + "Crew: 3");
            playerboat_lore.add(ChatColor.of("#E8977F") + "Captain: ");
            playerboat_meta.setLore(playerboat_lore);
            playerboat.setItemMeta(playerboat_meta);

            ItemMeta notunlucked_meta = notunlockedyet.getItemMeta();
            notunlucked_meta.setDisplayName(ChatColor.of("#F23700") + "Not Unlocked");
            ArrayList<String> notunlucked_lore = new ArrayList<>();
            notunlucked_lore.add(ChatColor.of("#DA7878") + "Requirements: Test");
            notunlucked_lore.add(ChatColor.of("#DA7878") + "Price: 1000");
            notunlucked_meta.setLore(notunlucked_lore);
            notunlockedyet.setItemMeta(notunlucked_meta);


            String money = "%vault_eco_balance_fixed%";
            String playername = "%player_displayname%";


            money = PlaceholderAPI.setPlaceholders(player, money);
            playername = PlaceholderAPI.setPlaceholders(player, playername);

        /*ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headmeta = (SkullMeta) head.getItemMeta();
        headmeta.setOwningPlayer(player);
        headmeta.setDisplayName(ChatColor.of(new Color(61, 145, 255))+""+ChatColor.BOLD+"PROFILE");
        ArrayList<String> profile_lore = new ArrayList<>();
        profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+sender.getName());
        profile_lore.add(ChatColor.of(new Color(130, 139, 147))+"Money: "+ ChatColor.of(new Color(224, 134, 0))+money+"$");
        headmeta.setLore(profile_lore);
        head.setItemMeta(headmeta);
        //Translate Head
*/

       /*ItemStack language = getSkull("https://textures.minecraft.net/texture/879e54cbe87867d14b2fbdf3f1870894352048dfecd962846dea893b2154c85");
        SkullMeta langhead = (SkullMeta) language.getItemMeta();
        langhead.setDisplayName(ChatColor.of(new Color(130, 139, 147))+"Name: "+ ChatColor.of(new Color(0, 141, 183))+"LANGUAGE");
        language.setItemMeta(langhead);*/

            //Design
            BoatGui.setItem(0, none);
            BoatGui.setItem(1, playerboat);
            BoatGui.setItem(2, notunlockedyet);
            BoatGui.setItem(3, notunlockedyet);
            BoatGui.setItem(4, notunlockedyet);
            BoatGui.setItem(5, notunlockedyet);
            BoatGui.setItem(6, notunlockedyet);
            BoatGui.setItem(7, notunlockedyet);
            BoatGui.setItem(8, none);

            player.openInventory(BoatGui);


        }else{
            player.sendMessage(ChatColor.of("#F23700") + "You do not have required permissions to use this command!");
        }}
    return false;}


@EventHandler
public void GamemodeSelector(InventoryClickEvent event) {
    if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of("#78B5DA") + "Boat Menu") && event.getCurrentItem() != null) {

        if (event.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
            if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
            } else {
                event.setCancelled(true);
            }
        }

        if (event.getCurrentItem().getType() == Material.OAK_BOAT) {
            if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                event.getWhoClicked().closeInventory();
            } else {
                event.setCancelled(true);
            }
        }

        if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS) {
            if (event.getClick().equals(ClickType.RIGHT) || event.getClick().equals(ClickType.LEFT)) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                event.getWhoClicked().sendMessage(ChatColor.of("#78B5DA") + "You didnt unlocked this boat yet!");
                event.getWhoClicked().closeInventory();
            } else {
                event.setCancelled(true);
            }
            event.setCancelled(true);}}

}

}
