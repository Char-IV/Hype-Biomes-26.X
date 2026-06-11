package net.hyperfire4k.hypebiomes.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.hyperfire4k.hypebiomes.HypeBiomes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item ANCIENT_FRAGMENT = registerItem("ancient_fragment", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(
                        Registries.ITEM,
                        Identifier.fromNamespaceAndPath(HypeBiomes.MOD_ID, name)))));
    }

    public static void registerModItems() {
        HypeBiomes.LOGGER.info("Registering Mod Items for " + HypeBiomes.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(ANCIENT_FRAGMENT);
        });
    }
}
