package net.hyperfire4k.hypebiomes.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.hyperfire4k.hypebiomes.HypeBiomes;
import net.hyperfire4k.hypebiomes.block.ModBlocks;
import net.hyperfire4k.hypebiomes.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab HYPE_BIOMES_MOD_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, "hype_biomes_tab"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ANCIENT_FRAGMENT))
                    .title(Component.translatable("creativemodetab.hypebiomes.hype_biomes_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ANCIENT_FRAGMENT);
                        output.accept(ModBlocks.LOOT_CRATE);

                    }).build());

    public static void registerModCreativeModeTabs() {
        HypeBiomes.LOGGER.info("Registering Creative Mode Tabs for " + HypeBiomes.MOD_ID);
    }
}
