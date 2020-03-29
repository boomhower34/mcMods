package com.example.sword.init;

import java.util.function.Supplier;

import com.example.sword.Sword;
import com.example.sword.Sword.ExampleCreativeTab;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
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
	
	//tools
	public static final Item example_sword = null;
	public static final Item example_pickaxe = null;
	public static final Item example_axe = null;
	public static final Item example_shovel = null;
	public static final Item example_hoe = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ExampleCreativeTab.instance)
				.food(new Food.Builder().hunger(2).saturation(1.0f).effect(new EffectInstance(Effects.GLOWING, 2000, 5), 0.5f)
						.build())).setRegistryName("example_item2"));
		//tools
		event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 4f, 
				new Item.Properties().group(ExampleCreativeTab.instance)).setRegistryName("example_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 7, 4f, 
				new Item.Properties().group(ExampleCreativeTab.instance)).setRegistryName("example_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 7, 4f, 
				new Item.Properties().group(ExampleCreativeTab.instance)).setRegistryName("example_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE, 7, 4f, 
				new Item.Properties().group(ExampleCreativeTab.instance)).setRegistryName("example_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 4f, 
				new Item.Properties().group(ExampleCreativeTab.instance)).setRegistryName("example_hoe"));
	}
	
	public enum ModItemTier implements IItemTier {
		
		EXAMPLE(4, 1500, 15.0f, 4f, 50, ()-> {
			return Ingredient.fromItems(ItemInit.example_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
}
