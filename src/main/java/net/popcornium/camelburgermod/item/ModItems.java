package net.popcornium.camelburgermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.popcornium.camelburgermod.CamelBurgerMod;

import java.util.function.Function;

public class ModItems {
    public static final Item RAW_CAMEL_MEAT = registerItem("raw_camel_meat", setting -> new Item(setting.food(FoodComponents.BEEF)));
    public static final Item COOKED_CAMEL_MEAT = registerItem("cooked_camel_meat",  setting -> new Item(setting.food(FoodComponents.COOKED_BEEF)));
    public static final Item CAMEL_BURGER = registerItem("camel_burger",  setting -> new Item(setting.food(ModFoodComponenets.CAMEL_BURGER)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(CamelBurgerMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CamelBurgerMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        CamelBurgerMod.LOGGER.info("Registering Mod Items for " + CamelBurgerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RAW_CAMEL_MEAT);
            entries.add(COOKED_CAMEL_MEAT);
            entries.add(CAMEL_BURGER);
        });
    }
}
