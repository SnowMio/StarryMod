package moe.mmio.starry.common.item;

import moe.mmio.starry.StarryMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemLegendIngot extends Item {
    private static final String name = "legend_ingot";
    public ItemLegendIngot() {
        this.setRegistryName(name);
        this.setUnlocalizedName(StarryMod.MODID+"."+name);
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
