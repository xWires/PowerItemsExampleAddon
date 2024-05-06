package xyz.tangledwires.PowerItemsAddon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.tangledwires.poweritems.PowerItems;
import xyz.tangledwires.poweritems.RarityManager;

public class App extends JavaPlugin {
    private PowerItems powerItems;
    private RarityManager manager;

    @Override
    public void onEnable() {
        if (Bukkit.getServer().getPluginManager().getPlugin("PowerItems") == null) { // Make sure that PowerItems is actually installed.
            this.getLogger().severe("PowerItems is not installed, disabling.");
            Bukkit.getServer().getPluginManager().disablePlugin(this); // If it isn't, you won't be able to register any rarities, so make sure you don't try to otherwise you will get lots of errors in the console.
            return;
        }
        powerItems = (PowerItems) Bukkit.getServer().getPluginManager().getPlugin("PowerItems"); // If it is installed, great! Get the instance of PowerItems from Bukkit.
        manager = powerItems.getRarityManager(); // Then get the RarityManager from PowerItems
        manager.registerRarity("test", ChatColor.AQUA + "TEST"); // Finally, register your rarities.
        manager.registerRarity("test2", ChatColor.GOLD + "ANOTHER TEST"); // The first argument is what the player will type when creating the item, and the second argument is what will show on the item.

        getLogger().info(this.getDescription().getFullName() + " loaded!");
    }
    @Override
    public void onDisable() {
        // You should unregister your rarities when your plugin disables. This isn't required, but it is better if you do.
        if (manager != null) {
            manager.unregisterRarity("test");
            manager.unregisterRarity("test2");
        }
        getLogger().info(this.getDescription().getFullName() + " disabled!");
    }
}