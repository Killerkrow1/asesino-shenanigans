package net.killerkrow.asesno.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.killerkrow.asesno.AsesinoShenanigans;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AsesinoItems {
    public static final Item GARLIC_BREAD = registerItem("garlic_bread",
            new Item(new FabricItemSettings()));
    public static final Item SHRIMP = registerItem("shrimp",
            new Item(new FabricItemSettings()));
    public static final Item ROASTED_CHICKEN = registerItem("roasted_chicken",
            new Item(new FabricItemSettings()));
    public static final Item TORTILLA_CHIP = registerItem("tortilla_chip",
            new Item(new FabricItemSettings()));
    public static final Item SPAGHETTI_NOODLE = registerItem("spaghetti_noodle",
            new Item(new FabricItemSettings()));
    public static final Item MEATBALL = registerItem("meatball",
            new Item(new FabricItemSettings()));

    public static final Item DISASTER_STARTER = registerItem("disaster_starter",
            new Item(new FabricItemSettings()));
    public static final Item DISASTER_ENDER = registerItem("disaster_ender",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AsesinoShenanigans.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AsesinoShenanigans.LOGGER.info("Registering Mod Items for " + AsesinoShenanigans.MOD_ID);
    }
}
