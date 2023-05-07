package land.builders.vehicleplacespeedlimit.commands;

import land.builders.vehicleplacespeedlimit.configuration.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender.hasPermission("vpsl.reload")) {
            Config.createConfig();
            Config.loadConfig();
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.reloadConfig));
            return true;
        }
        return false;
    }
}
