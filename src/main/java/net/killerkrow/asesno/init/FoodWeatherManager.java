package net.killerkrow.asesno.init;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.killerkrow.asesno.util.WeatherNetworking;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.Heightmap;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodWeatherManager {
    public static boolean isRedWeatherActive = false;
    private static final Random RANDOM = new Random();

    private static final List<ItemStack> RAIN_ITEMS = Arrays.asList(
            new ItemStack(AsesinoItems.GARLIC_BREAD),
            new ItemStack(AsesinoItems.ROASTED_CHICKEN),
            new ItemStack(AsesinoItems.SHRIMP),
            new ItemStack(AsesinoItems.TORTILLA_CHIP),
            new ItemStack(AsesinoItems.SPAGHETTI_NOODLE),
            new ItemStack(AsesinoItems.MEATBALL)
    );

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (world.getRegistryKey() == ServerWorld.OVERWORLD) {
                // Checks for activations every 20 ticks, aka second
                if (world.getTime() % 20 == 0) {
                    checkItemSacrifices(world);
                }
                // DO THE RAIN IF ACTIVE
                if (isRedWeatherActive) {
                    processItemRain(world);
                }
            }
        });
    }

    private static void checkItemSacrifices(ServerWorld world) {
        BlockPos targetPos = new BlockPos(0, 0, 0);
        // Scan for all item entities in the world
        List<ItemEntity> items = world.getEntitiesByClass(ItemEntity.class,
                new Box(world.getTopPosition(Heightmap.Type.WORLD_SURFACE, targetPos)).expand(5000, 256, 5000), item -> true);

        for (ItemEntity itemEntity : items) {
            BlockPos pos = itemEntity.getBlockPos();
            if (world.getFluidState(pos).isStill() && itemEntity.isOnGround() || world.getFluidState(pos).getFluid().isStill(world.getFluidState(pos))) {
                ItemStack stack = itemEntity.getStack();

                // Activates Cloudy with a Chance of meatballs
                if (!isRedWeatherActive && stack.isOf(AsesinoItems.DISASTER_STARTER)) {
                    isRedWeatherActive = true;
                    itemEntity.discard();
                    syncWeatherToAll(world, true);
                }
                // Deactivates Cloudy with a chance of meatballs
                else if (isRedWeatherActive && stack.isOf(AsesinoItems.DISASTER_ENDER)) {
                    isRedWeatherActive = false;
                    itemEntity.discard();
                    syncWeatherToAll(world, false);
                }
            }
        }
    }

    private static void processItemRain(ServerWorld world) {
        // Loops through all players online to see where rain goes
        for (ServerPlayerEntity player : world.getPlayers()) {
            if (RANDOM.nextFloat() < 1.00f) {
                double x = player.getX() + (RANDOM.nextDouble() - 0.5) * 40;
                double z = player.getZ() + (RANDOM.nextDouble() - 0.5) * 40;
                // Spawns high to imitate rain
                double y = world.getTopY(Heightmap.Type.MOTION_BLOCKING, (int)x, (int)z) + 30;

                ItemStack randomItem = RAIN_ITEMS.get(RANDOM.nextInt(RAIN_ITEMS.size())).copy();
                ItemEntity droppedItem = new ItemEntity(world, x, y, z, randomItem);

                // DOwn velocity tto stop it from floating
                droppedItem.setVelocity(0, -0.2, 0);
                world.spawnEntity(droppedItem);
            }
        }
    }

    private static void syncWeatherToAll(ServerWorld world, boolean active) {
        WeatherNetworking.sendWeatherStateToAll(world, active);
    }
}