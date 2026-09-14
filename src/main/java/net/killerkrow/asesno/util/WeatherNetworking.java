package net.killerkrow.asesno.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.killerkrow.asesno.AsesinoShenanigans;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class WeatherNetworking {
    public static final Identifier WEATHER_SYNC_ID = new Identifier(AsesinoShenanigans.MOD_ID, "weather_sync");

    public static void sendWeatherStateToAll(ServerWorld world, boolean isActive) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBoolean(isActive);

        for (ServerPlayerEntity player : world.getPlayers()) {
            ServerPlayNetworking.send(player, WEATHER_SYNC_ID, buf);
        }
    }
}