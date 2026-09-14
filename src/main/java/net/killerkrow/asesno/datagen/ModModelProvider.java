package net.killerkrow.asesno.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.killerkrow.asesno.init.AsesinoItems;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AsesinoItems.GARLIC_BREAD, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.ROASTED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.SHRIMP, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.TORTILLA_CHIP, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.SPAGHETTI_NOODLE, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.MEATBALL, Models.GENERATED);

        itemModelGenerator.register(AsesinoItems.DISASTER_STARTER, Models.GENERATED);
        itemModelGenerator.register(AsesinoItems.DISASTER_ENDER, Models.GENERATED);
    }
}