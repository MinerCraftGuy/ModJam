package ironlionchefs.modjam.src;

import ironlionchefs.modjam.blocks.cauldron.PotionCauldron;
import ironlionchefs.modjam.blocks.ore.OreEssenceHighOverworld;
import ironlionchefs.modjam.blocks.ore.OreEssenceLowOverworld;
import ironlionchefs.modjam.blocks.ore.OreEssenceMedOverworld;
import ironlionchefs.modjam.items.essence.ItemEssenceHigh;
import ironlionchefs.modjam.items.essence.ItemEssenceHighIngot;
import ironlionchefs.modjam.items.essence.ItemEssenceLow;
import ironlionchefs.modjam.items.essence.ItemEssenceLowIngot;
import ironlionchefs.modjam.items.essence.ItemEssenceLowPickaxe;
import ironlionchefs.modjam.items.essence.ItemEssenceMed;
import ironlionchefs.modjam.items.essence.ItemEssenceMedIngot;
import ironlionchefs.modjam.items.pendants.PendantDiamond;
import ironlionchefs.modjam.items.pendants.PendantEnchantRegistry;
import ironlionchefs.modjam.items.pendants.PendantGold;
import ironlionchefs.modjam.items.pendants.PendantIron;
import ironlionchefs.modjam.items.pendants.PendantStone;
import ironlionchefs.modjam.renders.RenderPotionCauldron;
import ironlionchefs.modjam.world.generator.overworld.EssenceHighOreOverworldGenerator;
import ironlionchefs.modjam.world.generator.overworld.EssenceLowOreOverworldGenerator;
import ironlionchefs.modjam.world.generator.overworld.EssenceMedOreOverworldGenerator;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ModJamILC", name = "ModJam IronLionChefs", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModJam
{
	public static Item stonePendant = new PendantStone(3072);
	public static Item ironPendant = new PendantIron(3073);
	public static Item goldPendant = new PendantGold(3074);
	public static Item diamondPendant = new PendantDiamond(3075);

	public static Item essenceLow = new ItemEssenceLow(3076);
	public static Item essenceMed = new ItemEssenceMed(3077);
	public static Item essenceHigh = new ItemEssenceHigh(3078);

	public static Item essenceLowIngot = new ItemEssenceLowIngot(3079);
	public static Item essenceMedIngot = new ItemEssenceMedIngot(3080);
	public static Item essenceHighIngot = new ItemEssenceHighIngot(3081);

	public static Item essenceLowPickaxe = new ItemEssenceLowPickaxe(3082);
	
	public static Block potionCauldron = new PotionCauldron(3100);

	public static Block essenceLowOreOverworld = new OreEssenceLowOverworld(3101);
	public static Block essenceMedOreOverworld = new OreEssenceMedOverworld(3102);
	public static Block essenceHighOreOverworld = new OreEssenceHighOverworld(3103);

	public static int potionCauldronRenderID = RenderingRegistry.getNextAvailableRenderId();

	public CreativeTabs tabModjam = new CreativeTabs("ModJam")
	{
		public ItemStack getIconItemStack()
		{
			return new ItemStack(ModJam.stonePendant, 1, 0);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	public void registerOre(Block b, IWorldGenerator i, String name, CreativeTabs ct)
	{
		registerObject(b, ct, name);
		GameRegistry.registerWorldGenerator(i);
		b.setCreativeTab(ct);
	}

	public void registerObject(Object obj, CreativeTabs ct, String name)
	{
		if (obj instanceof Block)
		{
			GameRegistry.registerBlock((Block) obj);
			LanguageRegistry.addName((Block) obj, name);
			Block b = (Block) obj;
			b.setCreativeTab(ct);
		}
		else if (obj instanceof Item)
		{
			Item a = (Item) obj;
			GameRegistry.registerItem(a, name);
			LanguageRegistry.addName(a, name);
			a.setCreativeTab(ct);
		}
	}

	public void registerStonePendantEnchants()
	{
		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.moveSpeed.getId(), 0, 1)));
		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.jump.getId(), 0, 1)));

		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.weakness.getId(), 0, 1)));
	}

	public void registerIronPendantEnchants()
	{
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.blindness.getId(), 0, 1));

		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.damageBoost.getId(), 0, 1));
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.fireResistance.getId(), 0, 1));
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.moveSpeed.getId(), 0, 1));
	}

	public void registerGoldPendantEnchants()
	{
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.confusion.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.digSlowdown.getId(), 0, 2));

		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.digSpeed.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.heal.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.nightVision.getId(), 0, 2));
	}

	public void registerDiamondPendantEnchants()
	{
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.digSpeed.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.heal.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.nightVision.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.damageBoost.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.fireResistance.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.invisibility.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.jump.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.moveSpeed.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.resistance.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.waterBreathing.getId(), 0, 3));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.regeneration.getId(), 0, 3));
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Creative Tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.ModJam", "en_US", "ModJam: Iron Lion Chefs");
		RenderingRegistry.registerBlockHandler(potionCauldronRenderID, new RenderPotionCauldron());

		registerStonePendantEnchants();
		registerIronPendantEnchants();
		registerGoldPendantEnchants();
		registerDiamondPendantEnchants();

		// Ores Overworld
		registerOre(essenceLowOreOverworld, new EssenceLowOreOverworldGenerator(), "Low Essence Ore", this.tabModjam);
		registerOre(essenceMedOreOverworld, new EssenceMedOreOverworldGenerator(), "Medium Essence Ore", this.tabModjam);
		registerOre(essenceHighOreOverworld, new EssenceHighOreOverworldGenerator(), "High Essence Ore", this.tabModjam);

		ModLoader.addSmelting(essenceLow.itemID, new ItemStack(essenceLowIngot));
		ModLoader.addSmelting(essenceMed.itemID, new ItemStack(essenceMedIngot));
		ModLoader.addSmelting(essenceHigh.itemID, new ItemStack(essenceHighIngot));

		ModLoader.addRecipe(new ItemStack(diamondPendant, 1), new Object[] { "X X", " X ", " D ", 'D', Item.diamond, 'X', Item.silk});
		ModLoader.addRecipe(new ItemStack(essenceLowPickaxe, 1), new Object[] { "XXX", " I ", " I ", 'X', essenceLowIngot, 'I', Item.stick});

		// Blocks
		registerObject(potionCauldron, this.tabModjam, "Potion Cauldron");

		// Items
		registerObject(stonePendant, this.tabModjam, "Stone Pendant");
		registerObject(ironPendant, this.tabModjam, "Iron Pendant");
		registerObject(goldPendant, this.tabModjam, "Gold Pendant");
		registerObject(diamondPendant, this.tabModjam, "Diamond Pendant");
		registerObject(essenceLow, this.tabModjam, "Tier 1 Essence");
		registerObject(essenceMed, this.tabModjam, "Tier 2 Essence");
		registerObject(essenceHigh, this.tabModjam, "Tier 3 Essence");
		registerObject(essenceLowIngot, this.tabModjam, "Tier 1 Essence Ingot");
		registerObject(essenceMedIngot, this.tabModjam, "Tier 2 Essence Ingot");
		registerObject(essenceHighIngot, this.tabModjam, "Tier 3 Essence Ingot");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}