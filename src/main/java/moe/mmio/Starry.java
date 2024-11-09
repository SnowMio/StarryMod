package moe.mmio;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Starry implements ModInitializer {
	public static final String MOD_ID = "starry";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item STARRY_INGOT = new Item(new FabricItemSettings());
	public static final Item LEGEND_INGOT = new Item(new FabricItemSettings());

	public static final Block STARRY_STONE = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
	public static final Block LEGEND_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(2.5f));


	@Override
	public void onInitialize() {
		LOGGER.info("Starry Mod Loaded!");

		LOGGER.info("Starry Mod :: Registering Items");
		Registry.register(Registry.ITEM, new Identifier("starry", "starry_ingot"), STARRY_INGOT);
		Registry.register(Registry.ITEM, new Identifier("starry", "legend_ingot"), LEGEND_INGOT);

		LOGGER.info("Starry Mod :: Registering Blocks");
		Registry.register(Registry.BLOCK, new Identifier("starry", "starry_stone"), STARRY_STONE);
		Registry.register(Registry.ITEM, new Identifier("starry", "starry_stone"), new BlockItem(STARRY_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("starry", "legend_ore"), LEGEND_ORE);
		Registry.register(Registry.ITEM, new Identifier("starry", "legend_ore"), new BlockItem(LEGEND_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

	}

	// Item group
	public static final ItemGroup STARRY_GROUP = FabricItemGroupBuilder.create(
			new Identifier("starry", "starry_item_group"))
			.icon(() -> new ItemStack(Starry.STARRY_INGOT))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(Starry.STARRY_INGOT));
				stacks.add(new ItemStack(Starry.STARRY_STONE));
				stacks.add(new ItemStack(Starry.LEGEND_ORE));
				stacks.add(new ItemStack(Starry.LEGEND_INGOT));
			})
			.build();
}