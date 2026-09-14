package net.killerkrow.asesno.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add("itemgroup.asesino", "Asesino Tab");

        translationBuilder.add("item.asesino.garlic_bread", "Garlic Bread");
        translationBuilder.add("item.asesino.shrimp", "Shrimp");
        translationBuilder.add("item.asesino.roasted_chicken", "Roasted Chicken");
        translationBuilder.add("item.asesino.tortilla_chip", "Tortilla Chip");
        translationBuilder.add("item.asesino.spaghetti_noodle", "Spaghetti Noodle");
        translationBuilder.add("item.asesino.meatball", "Meatball");

        translationBuilder.add("item.asesino.disaster_starter", "Disaster Starter");
        translationBuilder.add("item.asesino.disaster_ender", "Disaster Ender");
    }
}