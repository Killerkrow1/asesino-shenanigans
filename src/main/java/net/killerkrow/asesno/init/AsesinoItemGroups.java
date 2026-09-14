package net.killerkrow.asesno.init;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.killerkrow.asesno.AsesinoShenanigans;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AsesinoItemGroups {
    public static final ItemGroup ASESINO = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AsesinoShenanigans.MOD_ID, "reverence_berry"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.asesino"))
                    .icon(() -> new ItemStack(AsesinoItems.GARLIC_BREAD)).entries((displayContext, entries) -> {

                        entries.add(AsesinoItems.GARLIC_BREAD);
                        entries.add(AsesinoItems.SHRIMP);
                        entries.add(AsesinoItems.ROASTED_CHICKEN);
                        entries.add(AsesinoItems.TORTILLA_CHIP);
                        entries.add(AsesinoItems.SPAGHETTI_NOODLE);
                        entries.add(AsesinoItems.MEATBALL);

                        entries.add(AsesinoItems.DISASTER_STARTER);
                        entries.add(AsesinoItems.DISASTER_ENDER);

                    }).build());

    public static void registerItemGroups() {
        AsesinoShenanigans.LOGGER.info("Registering Item Groups for " + AsesinoShenanigans.MOD_ID);
    }
}
