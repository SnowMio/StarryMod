package moe.mmio.starry.common.item;

import moe.mmio.starry.StarryMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

// 中瓶血药
public class ItemMediumLife extends ItemFood {
    public ItemMediumLife() {
        super(1, 0.0f, false);
        String name = "medium_life";
        this.setUnlocalizedName(StarryMod.MODID+"."+name);
        this.setAlwaysEdible();   // 让这个食物在饱的时候也可以吃
    }

    @ParametersAreNonnullByDefault
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 3));
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
