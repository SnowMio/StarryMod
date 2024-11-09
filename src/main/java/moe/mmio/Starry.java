package moe.mmio;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starry implements ModInitializer {
	public static final String MOD_ID = "starry";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item STARRY_INGOT = new Item(new FabricItemSettings());
	public static final Item LEGEND_INGOT = new Item(new FabricItemSettings());

	public static final Block STARRY_STONE = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.5f));

	@Override
	public void onInitialize() {
		LOGGER.info("Starry Mod Loaded!");

		LOGGER.info("Starry Mod :: Registering Items");
		Registry.register(Registry.ITEM, new Identifier("starry", "starry_ingot"), STARRY_INGOT);
		Registry.register(Registry.ITEM, new Identifier("starry", "legend_ingot"), LEGEND_INGOT);

		LOGGER.info("Starry Mod :: Registering Blocks");
		Registry.register(Registry.BLOCK, new Identifier("starry", "starry_stone"), STARRY_STONE);
		Registry.register(Registry.ITEM, new Identifier("starry", "starry_stone"), new BlockItem(STARRY_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

	}
}