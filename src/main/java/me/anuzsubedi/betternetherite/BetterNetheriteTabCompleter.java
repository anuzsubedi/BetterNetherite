package me.anuzsubedi.betternetherite;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BetterNetheriteTabCompleter implements TabCompleter {
    List<String> arguments = new ArrayList<String>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (arguments.isEmpty()) {
            arguments.add("enableElytra");
            arguments.add("disableElytra");
            return arguments;
        }
        return null;
    }
}
