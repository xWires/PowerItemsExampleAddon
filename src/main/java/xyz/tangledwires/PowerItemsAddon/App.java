package xyz.tangledwires.PowerItemsAddon;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tangledwires.poweritems.RarityManager;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        RarityManager.registerRarity("test", ChatColor.AQUA + "TEST");
        getLogger().info("Hello, SpigotMC!");
    }
    @Override
    public void onDisable() {
        RarityManager.unregisterRarity("test");
        getLogger().info("See you again, SpigotMC!");
    }
}