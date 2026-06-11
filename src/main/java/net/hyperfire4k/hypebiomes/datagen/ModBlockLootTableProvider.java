package net.hyperfire4k.hypebiomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.hyperfire4k.hypebiomes.block.ModBlocks;
import net.hyperfire4k.hypebiomes.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        add(ModBlocks.LOOT_CRATE, createLootCrateDrops(ModBlocks.LOOT_CRATE));
    }

    public LootTable.Builder createLootCrateDrops(final Block block) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(Items.WHEAT)
                                .when(LootItemRandomChanceCondition.randomChance(0.4F))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                )
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
                                )))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.4F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.BROWN_MUSHROOM).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.35F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.POISONOUS_POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.GOLD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.DIAMOND)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.02F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(ModItems.ANCIENT_FRAGMENT)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.SADDLE)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.POTATO).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.005F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.005F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.QUARTZ).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.001F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.ENDER_PEARL)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.WHEAT_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.BEETROOT_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.15F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.MELON_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.OAK_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.SPRUCE_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.BIRCH_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.ACACIA_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.JUNGLE_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.CHERRY_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.PALE_OAK_SAPLING)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        block, LootItem.lootTableItem(Items.MANGROVE_PROPAGULE)
                                )))
                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
        );
    }
}
