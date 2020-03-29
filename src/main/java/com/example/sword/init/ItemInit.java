package com.example.sword.init;

import com.example.sword.Sword;
import com.example.sword.Sword.ExampleCreativeTab;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Sword.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Sword.MOD_ID)
public class ItemInit {
	
	public static final Item example_item = null;
	public static final Item example_item2 = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ExampleCreativeTab.instance)
				.food(new Food.Builder().hunger(2).saturation(1.0f).effect(new EffectInstance(Effects.GLOWING, 2000, 5), 0.5f)
						.build())).setRegistryName("example_item2"));
	}
}
