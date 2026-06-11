package net.hyperfire4k.hypebiomes;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hyperfire4k.hypebiomes.datagen.ModBlockLootTableProvider;
import net.hyperfire4k.hypebiomes.datagen.ModBlockTagsProvider;
import net.hyperfire4k.hypebiomes.datagen.ModModelProvider;

public class HypeBiomesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
	}
}
