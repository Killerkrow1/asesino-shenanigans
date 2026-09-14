package net.killerkrow.asesno;

import net.fabricmc.api.ModInitializer;

import net.killerkrow.asesno.init.mass.AsesinoInit;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsesinoShenanigans implements ModInitializer {
	public static final String MOD_ID = "asesino";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AsesinoInit.MassInit();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
