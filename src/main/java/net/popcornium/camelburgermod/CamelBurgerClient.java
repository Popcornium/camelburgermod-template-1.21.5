package net.popcornium.camelburgermod;

import net.fabricmc.api.ClientModInitializer;
import net.popcornium.camelburgermod.item.ModItems;

public class CamelBurgerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItems.registerModItems();
    }
}
