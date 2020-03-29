package com.example.sword;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.sword.init.BlockInit;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("sword")
public class Sword
{
	public static final String MOD_ID="sword";
	public static Sword instance;
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Sword() {
    	
    	final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
    	eventBus.addListener(this::setup);

        // Register the doClientStuff method for modloading
    	eventBus.addListener(this::doClientStuff);

        instance = this;
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
    
    public static class ExampleCreativeTab extends ItemGroup {
    	
    	public static final ExampleCreativeTab instance = new ExampleCreativeTab(ItemGroup.GROUPS.length, "Example tab");
    	
		public ExampleCreativeTab(int index, String label) {
			super(index, label);
			
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.example_block);
		}
    }
}

