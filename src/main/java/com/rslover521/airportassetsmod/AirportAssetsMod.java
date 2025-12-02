package com.rslover521.airportassetsmod;

import com.mojang.logging.LogUtils;
import com.rslover521.airportassetsmod.registry.ModBlockEntities;
import com.rslover521.airportassetsmod.registry.ModBlocks;
import com.rslover521.airportassetsmod.registry.ModCreativeTabs;
import com.rslover521.airportassetsmod.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AirportAssetsMod.MODID)
public class AirportAssetsMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "airportassetsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AirportAssetsMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModCreativeTabs.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        
    }
}
