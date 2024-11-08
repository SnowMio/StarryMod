package moe.mmio.starry.register;

import moe.mmio.starry.common.item.ItemLegendIngot;
import moe.mmio.starry.common.item.ItemMediumLife;
import moe.mmio.starry.common.item.ItemStarryIngot;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemsRegister {
    public static final Item STARRY_INGOT = new ItemStarryIngot();
    public static final Item LEGEND_INGOT = new ItemLegendIngot();
    public static final Item MEDIUM_LIFE = new ItemMediumLife();

    public ItemsRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                STARRY_INGOT, LEGEND_INGOT,
                MEDIUM_LIFE
        );
    }
}
