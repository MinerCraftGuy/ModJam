package ironlionchefs.modjam.renders;

import ironlionchefs.modjam.blocks.cauldron.PotionCauldron;
import ironlionchefs.modjam.src.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderPotionCauldron extends RenderBlocks implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block par1BlockCauldron, int modelId, RenderBlocks renderer)
	{
		System.out.println("render");
		renderer.renderBlockCauldron((BlockCauldron) par1BlockCauldron, x, y, z);

		Tessellator tessellator = Tessellator.instance;

		PotionCauldron pc = (PotionCauldron) par1BlockCauldron;

		int l = pc.color;

		int i1 = blockAccess.getBlockMetadata(x, y, z);

		Icon icon2 = BlockFluid.func_94424_b("water_still");

		if (i1 > 3)
		{
			i1 = 3;
		}

		float f = (float) (l >> 16 & 255) / 255.0F;
		float f1 = (float) (l >> 8 & 255) / 255.0F;
		float f2 = (float) (l & 255) / 255.0F;

		float f9 = 1.0F;
		float f4 = 1.0F;
		System.out.println(l);
		tessellator.setColorOpaque_F(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);

		renderer.renderFaceYPos(par1BlockCauldron, (double) x, (double) ((float) y - 1.0F + (6.0F + (float) i1 * 3.0F) / 16.0F), (double) z, icon2);

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return ModJam.potionCauldronRenderID;
	}
}