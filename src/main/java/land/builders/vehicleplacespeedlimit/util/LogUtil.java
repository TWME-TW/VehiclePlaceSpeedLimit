package land.builders.vehicleplacespeedlimit.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import java.util.logging.Level;

public class LogUtil {
    private static final ConsoleCommandSender console = Bukkit.getConsoleSender();
    public static void log(String logMessage){
        Bukkit.getLogger().log(Level.INFO, ChatColor.translateAlternateColorCodes('&',logMessage));
    }
}
