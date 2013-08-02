package ironlionchefs.modjam.items.pendants;

import ironlionchefs.modjam.src.ModJam;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pendant extends ItemArmor
{
	private PendantLevel level;

	// TODO finish these items
	static EnumArmorMaterial armorPendant = EnumArmorMaterial.IRON;

	public Pendant(int id, PendantLevel level)
	{
		super(id, armorPendant, 0, 1);
		setLevel(level);
		this.setMaxDamage(1);
		this.setMaxStackSize(1);
		this.setFull3D();
	}

	public PendantLevel getLevel()
	{
		return level;
	}

	public void setLevel(PendantLevel l)
	{
		this.level = l;
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		if (getLevel() == PendantLevel.stone)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantStone");
			this.setUnlocalizedName("Stone Pendant");
		}
		else if (getLevel() == PendantLevel.iron)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantIron");
			this.setUnlocalizedName("Iron Pendant");
		}
		else if (getLevel() == PendantLevel.gold)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantGold");
			this.setUnlocalizedName("Gold Pendant");
		}
		else if (getLevel() == PendantLevel.diamond)
		{
			this.itemIcon = register.registerIcon("ModJam:PendantDiamond");
			this.setUnlocalizedName("Diamond Pendant");
		}
	}
}