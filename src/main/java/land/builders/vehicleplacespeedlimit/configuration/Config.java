package land.builders.vehicleplacespeedlimit.configuration;

import land.builders.vehicleplacespeedlimit.VehiclePlaceSpeedLimit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;

public class Config {
    public static boolean debug;
    public static double createCooldowns;
    public static String cancelSpawn;
    public static String spawnVehicle;
    public static String timeLeft;
    public static String reloadConfig;


    public static void createConfig() {

        final YamlFile config = new YamlFile("plugins/VehiclePlaceSpeedLimit/config.yml");
        try {
            if (!config.exists()) {
                config.createNewFile();
                System.out.println("New file has been created: " + config.getFilePath() + "\n");
            } else {
                System.out.println(config.getFilePath() + " already exists, loading configurations...\n");
            }
            config.load(); // Loads the entire file
            // If your file has comments inside you have to load it with yamlFile.loadWithComments()
        } catch (final Exception e) {
            e.printStackTrace();
        }
        // debug
        config.addDefault("debug", false);

        // config
        config.addDefault("Config.CreateCooldown", 0.7);
        config.setComment("Config.CreateCooldown", "# How many seconds between placing vehicles");

        config.setComment("Messages.CancelSpawn","# debug messages(console)");
        config.addDefault("Messages.CancelSpawn", "&7Cancels spawning a %vehicle%.");
        config.addDefault("Messages.SpawnVehicle", "&fA %c%vehicle% &fhas been spawned.");
        config.addDefault("Messages.TimeLeft", "&7Time left : %time%s");
        config.addDefault("Messages.Reload", "&3Reloaded VehiclePlaceSpeedLimit config.yml");

        try {
            config.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadConfig() {
        VehiclePlaceSpeedLimit plugin = VehiclePlaceSpeedLimit.getPlugin();

        String path = "config.yml";

        File configFile = new File(plugin.getDataFolder(), path);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        debug = config.getBoolean("debug", false);
        createCooldowns = config.getDouble("Config.CreateCooldown");
        cancelSpawn = config.getString("Messages.CancelSpawn");
        spawnVehicle = config.getString("Messages.SpawnVehicle");
        timeLeft = config.getString("Messages.TimeLeft");
        reloadConfig = config.getString("Messages.Reload");
    }

}
