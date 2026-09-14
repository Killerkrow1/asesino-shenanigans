package net.killerkrow.asesno;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.killerkrow.asesno.datagen.ModLanguageProvider;
import net.killerkrow.asesno.datagen.ModModelProvider;

public class AsesinoShenanigansDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLanguageProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
