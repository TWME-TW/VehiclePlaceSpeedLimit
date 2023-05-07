package land.builders.vehicleplacespeedlimit;

import land.builders.vehicleplacespeedlimit.commands.ReloadCommand;
import land.builders.vehicleplacespeedlimit.configuration.Config;
import land.builders.vehicleplacespeedlimit.listeners.VehicleCreateListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class VehiclePlaceSpeedLimit extends JavaPlugin {
    private static VehiclePlaceSpeedLimit plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.createConfig();
        Config.loadConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new VehicleCreateListener(), this);
        getCommand("vpslreload").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {}

    public static VehiclePlaceSpeedLimit getPlugin() {
        return plugin;
    }
}
