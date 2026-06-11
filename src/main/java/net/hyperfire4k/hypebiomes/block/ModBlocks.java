package net.hyperfire4k.hypebiomes.block;

import net.hyperfire4k.hypebiomes.HypeBiomes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block LOOT_CRATE = registerBlock("loot_crate",
            properties -> new Block(properties
                    .strength(2f)
                    .sound(SoundType.HANGING_SIGN)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        HypeBiomes.LOGGER.info("Registering Mod Blocks for " + HypeBiomes.MOD_ID);
    }
}
