package listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * Created by regnatrix on 24.11.16.
 */
public class Weather implements Listener{

    @EventHandler
    public void onWaether(WeatherChangeEvent e) {
        e.setCancelled(true);
    }


}
