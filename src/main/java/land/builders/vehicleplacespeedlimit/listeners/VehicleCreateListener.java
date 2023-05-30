package land.builders.vehicleplacespeedlimit.listeners;

import land.builders.vehicleplacespeedlimit.configuration.Config;
import land.builders.vehicleplacespeedlimit.util.LogUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;


public class VehicleCreateListener implements Listener {
    private static long createCooldowns = 1L;

    @EventHandler(
            priority = EventPriority.LOW,
            ignoreCancelled = true
    )
    public void vehicleCreate(VehicleCreateEvent event) {
        long currentTime = System.currentTimeMillis();
        String vehicleName = event.getVehicle().getName();

        long lastCreateTime = createCooldowns;

        float timeSinceLastCreate = (currentTime - lastCreateTime) / 1000.0F;

        if (timeSinceLastCreate < Config.createCooldowns) {
            event.setCancelled(true);
        } else {
            createCooldowns = currentTime;
        }

        if (Config.debug) {
            if (event.isCancelled()) {
                LogUtil.log(
                        Config.cancelSpawn.replaceAll("%vehicle%", vehicleName) + " " +
                                Config.timeLeft.replaceAll("%time%", String.valueOf(timeSinceLastCreate))
                );
            } else {
                LogUtil.log(Config.spawnVehicle.replaceAll("%vehicle%", vehicleName));
            }
        }
    }
}
