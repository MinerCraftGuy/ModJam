package ironlionchefs.modjam.world.generator.magic;

import ironlionchefs.modjam.src.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGeneratorMagicWorld extends BiomeGenBase
{
	public final Material blockMaterial;

	public BiomeGeneratorMagicWorld(int par1)
	{
		super(par1);
		this.blockMaterial = Material.water;
		this.minHeight = 0.1F;
		this.maxHeight = 0.6F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
		
		this.topBlock = ((byte) ModJam.blockNewDimGrass.blockID);
		this.fillerBlock = ((byte) Block.dirt.blockID);
		this.setBiomeName("Magic");
		this.waterColorMultiplier = 0xE42D17;
	}
}