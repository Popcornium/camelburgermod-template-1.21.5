package net.popcornium.camelburgermod;

import net.fabricmc.api.ModInitializer;

import net.popcornium.camelburgermod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelBurgerMod implements ModInitializer {
	public static final String MOD_ID = "camelburgermod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModLootTableModifiers.modifyLootTables();
	}
}