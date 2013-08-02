package ironlionchefs.modjam.items.essence;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceLowPickaxe extends ItemPickaxe
{

	public ItemEssenceLowPickaxe(int par1)
	{
		super(par1, EnumToolMaterial.IRON);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("ModJam:LowEssencePickaxe");
		this.setUnlocalizedName("Tier 1 Essence Pickaxe");
	}
}