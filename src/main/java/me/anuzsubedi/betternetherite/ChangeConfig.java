package me.anuzsubedi.betternetherite;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ChangeConfig implements CommandExecutor {
    static Main plugin;
    public ChangeConfig(Main main) {
        plugin=main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("BetterNetherite")) {
            try {
                if (sender.hasPermission("betternetherite.change")) {
                    if (args[0].equalsIgnoreCase("enableElytra")) {
                        final boolean allowElytra = ChangeConfig.plugin.getConfig().getBoolean("allow-elytra");
                        if (allowElytra) {
                            sender.sendMessage(ChatColor.GOLD + "This setting is already enabled.");
                            return true;
                        }
                        final FileConfiguration config = ChangeConfig.plugin.getConfig();
                        config.set("allow-elytra", true);
                        plugin.saveConfig();
                        sender.sendMessage(ChatColor.GOLD + "Enabled Fire Resistance while Wearing Elytra.");
                        return true;
                    } else {
                        if (!args[0].equalsIgnoreCase("disableElytra")) {
                            return false;
                        }
                        final boolean allowElytra = ChangeConfig.plugin.getConfig().getBoolean("allow-elytra");
                        if (allowElytra) {
                            final FileConfiguration config = ChangeConfig.plugin.getConfig();
                            config.set("allow-elytra", false);
                            plugin.saveConfig();
                            sender.sendMessage(ChatColor.GOLD + "Disabled Fire Resistance while Wearing Elytra.");
                            return true;
                        }
                        sender.sendMessage(ChatColor.GOLD + "This setting is already disabled.");
                        return true;
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "You are not allowed to change this setting.");
                }
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "Correct Usage:/betterNetherite enableElytra or /betterNetherite disableElytra");
            }
        }return false;
        }
    }

