package me.anuzsubedi.betternetherite;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new GiveFireRes(this),this);
        this.getCommand("BetterNetherite").setExecutor(new ChangeConfig(this));
        this.getCommand("BetterNetherite").setTabCompleter(new BetterNetheriteTabCompleter());
    }

    @Override
    public void onDisable() {
        
    }
}
