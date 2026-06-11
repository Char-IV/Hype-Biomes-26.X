package net.hyperfire4k.hypebiomes;

import net.fabricmc.api.ModInitializer;

import net.hyperfire4k.hypebiomes.block.ModBlocks;
import net.hyperfire4k.hypebiomes.creativemodetab.ModCreativeModeTabs;
import net.hyperfire4k.hypebiomes.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HypeBiomes implements ModInitializer {
	public static final String MOD_ID = "hypebiomes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}