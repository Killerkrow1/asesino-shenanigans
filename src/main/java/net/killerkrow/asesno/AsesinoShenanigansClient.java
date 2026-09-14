package net.killerkrow.asesno;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.killerkrow.asesno.util.WeatherNetworking;

public class AsesinoShenanigansClient implements ClientModInitializer {
    public static boolean clientIsFoodWeatherActive = false;

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(WeatherNetworking.WEATHER_SYNC_ID,
                (client, handler, buf, responseSender) -> {
            boolean active = buf.readBoolean();
            client.execute(() -> {
                clientIsFoodWeatherActive = active;
            });
        });
    }
}
