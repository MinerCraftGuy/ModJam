package ironlionchefs.modjam.blocks.cauldron;

import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.block.BlockCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionCauldron extends BlockCauldron
{
	@SideOnly(Side.CLIENT)
	private static Icon field_94378_a;
	@SideOnly(Side.CLIENT)
	private Icon cauldronTopIcon;
	@SideOnly(Side.CLIENT)
	private static Icon cauldronBottomIcon;
	public int color = 0000000000;
	
	public PotionCauldron(int par1)
	{
		super(par1);
		this.setHardness(5f);
		this.setResistance(40f);
	}

	public boolean hasEffect(ItemStack s)
	{
		return true;
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.cauldronTopIcon : (par1 == 0 ? this.cauldronBottomIcon : this.blockIcon);
	}

    public int getRenderType()
    {
        return ModJam.potionCauldronRenderID;
    }
    
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.field_94378_a = par1IconRegister.registerIcon("ModJam:potionCauldronInner");
		this.cauldronTopIcon = par1IconRegister.registerIcon("ModJam:potionCauldronTop");
		this.cauldronBottomIcon = par1IconRegister.registerIcon("ModJam:potionCauldronBottom");
		this.blockIcon = par1IconRegister.registerIcon("ModJam:potionCauldronSide");
	}

	public static Icon func_94375_b(String par0Str)
	{
		return par0Str.equals("inner") ? PotionCauldron.field_94378_a : (par0Str.equals("bottom") ? PotionCauldron.cauldronBottomIcon : null);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
		
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			if (itemstack == null)
			{
				return true;
			}

			else
			{
				int i1 = par1World.getBlockMetadata(par2, par3, par4);
				int j1 = func_111045_h_(i1);
				
				if (itemstack.itemID == Item.potion.itemID)
				{
					if (j1 > 0)
					{
						ItemStack itemstack1 = new ItemStack(Item.potion, 1, 0);

						if (!par5EntityPlayer.inventory.addItemStackToInventory(itemstack1))
						{
							par1World.spawnEntityInWorld(new EntityItem(par1World, (double) par2 + 0.5D, (double) par3 + 1.5D, (double) par4 + 0.5D, itemstack1));
						}
						else if (par5EntityPlayer instanceof EntityPlayerMP)
						{
							((EntityPlayerMP) par5EntityPlayer).sendContainerToPlayer(par5EntityPlayer.inventoryContainer);
						}

						--itemstack.stackSize;

						if (itemstack.stackSize <= 0)
						{
							par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, (ItemStack) null);
						}

						par1World.setBlockMetadataWithNotify(par2, par3, par4, j1 - 1, 2);
						par1World.func_96440_m(par2, par3, par4, this.blockID);
					}
						

					this.color = Item.potion.getColorFromDamage(itemstack.getItemDamage());
					Minecraft.getMinecraft().renderGlobal.markBlockForUpdate(par2, par3, par4);
					
					for (Object e : Item.potion.getEffects(itemstack.getItemDamage()))
					{
						if (e instanceof PotionEffect)
						{
							PotionEffect e1 = (PotionEffect) e;

							switch (e1.getEffectName())
							{
								case "potion.regeneration":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.moveSpeed":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.moveSlowdown":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.harm":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.invisibility":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.fireResistance":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.poison":	
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.heal":	
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.nightVision":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.weakness":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;
								case "potion.damageBoost":
									if (!par5EntityPlayer.capabilities.isCreativeMode)
									{
										par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle));
									}
									break;	
							}
						}
					}
				}
				return true;
			}
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	@Override
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return this.blockID;
	}

	public static int func_111045_h_(int par0)
	{
		return par0;
	}
}