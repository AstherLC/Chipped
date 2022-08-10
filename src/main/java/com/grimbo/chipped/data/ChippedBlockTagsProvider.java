package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;

import com.grimbo.chipped.block.ChippedBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

import net.minecraftforge.registries.RegistryObject;

public class ChippedBlockTagsProvider extends BlockTagsProvider {

	public ChippedBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Chipped.MOD_ID, existingFileHelper);
	}

	//TODO: Give the blocks the same tags as vanilla so they can function in crafting
	@Override
	protected void addTags() {
		//All blocks with a vanilla variant
		for (ChippedBlockType<Block> type : BlockRegistry.getBlockTypes()) {
			// FIXME this should not just use minecraft:$path to get the vanilla block.
			Block vanillaBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(type.getId()));
			if (vanillaBlock != null && vanillaBlock != Blocks.AIR) {
				TagAppender<Block> tag = tag(type.getBlockTag());
				tag.add(vanillaBlock);
				for (RegistryObject<Block> block : type.getBlocks()) {
					tag.add(block.get());
				}
			}
		}

		//Default Vanilla tags
		for (ChippedWoodType wood : ChippedWoodType.VALUES) {
			tag(BlockTags.PLANKS).addTag(PLANKS.get(wood).getBlockTag());
		}

		tag(BlockTags.NON_FLAMMABLE_WOOD).addTag(PLANKS.get(ChippedWoodType.WARPED).getBlockTag());
		tag(BlockTags.NON_FLAMMABLE_WOOD).addTag(PLANKS.get(ChippedWoodType.CRIMSON).getBlockTag());

		for (int i = 0; i < 16; i++) {
			DyeColor color = DyeColor.byId(i);
			tag(BlockTags.WOOL).addTag(WOOL.get(color).getBlockTag());
			tag(BlockTags.CARPETS).addTag(CARPETS.get(color).getBlockTag());
		}

		tag(BlockTags.DRAGON_IMMUNE).addTag(OBSIDIAN.getBlockTag());
		tag(BlockTags.DRAGON_IMMUNE).addTag(CRYING_OBSIDIAN.getBlockTag());

		tag(BlockTags.CLIMBABLE).addTag(VINES.getBlockTag());

		tag(BlockTags.WALL_POST_OVERRIDE).addTag(TORCHES.getBlockTag());
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(REDSTONE_TORCHES.getBlockTag());

		tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).addTag(SOUL_SANDS.getBlockTag());
		tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).addTag(SOUL_SANDS.getBlockTag());
		tag(BlockTags.SOUL_SPEED_BLOCKS).addTag(SOUL_SANDS.getBlockTag());

		tag(BlockTags.PIGLIN_REPELLENTS).addTag(SOUL_LANTERNS.getBlockTag());
		tag(BlockTags.HOGLIN_REPELLENTS).addTag(WARPED_FUNGUS.getBlockTag());

		//Default Forge tags
		tag(Tags.Blocks.STONE)
				.addTag(ANDESITE.getBlockTag())
				.addTag(STONE.getBlockTag())
				.addTag(DIORITE.getBlockTag())
				.addTag(GRANITE.getBlockTag())
				.addTag(BASALT.getBlockTag())
				.addTag(MOSSY_STONE_BRICKS.getBlockTag())
				.addTag(BRICKS.getBlockTag())
				.addTag(CLAYS.getBlockTag())
				.addTag(DARK_PRISMARINE.getBlockTag())
				.addTag(PRISMARINE.getBlockTag())
				.addTag(GILDED_BLACKSTONES.getBlockTag())
				.addTag(COAL_BLOCK.getBlockTag())
				.addTag(REDSTONE_BLOCK.getBlockTag())
				.addTag(LODESTONE.getBlockTag())
				.addTag(MAGMA_BLOCK.getBlockTag())
				.addTag(PURPUR_BLOCK.getBlockTag())
				.addTag(QUARTZ_BLOCK.getBlockTag())
				.addTag(RED_NETHER_BRICKS.getBlockTag())
				.addTag(RED_SANDSTONE.getBlockTag())
				.addTag(SANDSTONE.getBlockTag())
				.addTag(SMOOTH_STONE.getBlockTag())
				.addTag(NETHER_BRICKS.getBlockTag())
				.addTag(AMETHYST_BLOCK.getBlockTag())
				.addTag(CALCITE.getBlockTag())
				.addTag(DRIPSTONE_BLOCK.getBlockTag())
				.addTag(TUFF.getBlockTag())
				.addTag(DEEPSLATE.getBlockTag())
				.addTag(RAW_IRON_BLOCK.getBlockTag())
				.addTag(RAW_COPPER_BLOCK.getBlockTag())
				.addTag(RAW_GOLD_BLOCK.getBlockTag())
				.addTag(PACKED_ICE.getBlockTag())
				.addTag(ICE.getBlockTag())
				.addTag(BLUE_ICE.getBlockTag())
				.addTag(DIAMOND_BLOCK.getBlockTag())
				.addTag(EMERALD_BLOCK.getBlockTag())
				.addTag(GOLD_BLOCK.getBlockTag())
				.addTag(IRON_BLOCK.getBlockTag())
				.addTag(NETHERITE_BLOCK.getBlockTag());

		tag(Tags.Blocks.COBBLESTONE).addTag(COBBLESTONE.getBlockTag());
		tag(Tags.Blocks.SAND).addTag(SAND.getBlockTag());
		tag(Tags.Blocks.GRAVEL).addTag(GRAVEL.getBlockTag());

		tag(Tags.Blocks.END_STONES).addTag(END_STONE.getBlockTag());




		tag(Tags.Blocks.GLASS).addTag(GLASSES.getBlockTag());
		tag(Tags.Blocks.GLASS_COLORLESS).addTag(GLASSES.getBlockTag());
		tag(Tags.Blocks.GLASS_PANES).addTag(GLASS_PANES.getBlockTag());
		tag(Tags.Blocks.GLASS_PANES_COLORLESS).addTag(GLASS_PANES.getBlockTag());
		for (int id = 0; id < 16; ++id) {
			DyeColor color = DyeColor.byId(id);

			tag(Tags.Blocks.GLASS).addTag(STAINED_GLASSES.get(color).getBlockTag());
			tag(BlockTags.create(new ResourceLocation("forge", "glass/"+color))).addTag(STAINED_GLASSES.get(color).getBlockTag());

			tag(Tags.Blocks.GLASS).addTag(STAINED_GLASS_PANES.get(color).getBlockTag());
			tag(BlockTags.create(new ResourceLocation("forge", "glass_panes/"+color))).addTag(STAINED_GLASS_PANES.get(color).getBlockTag());

			tag(BlockTags.create(new ResourceLocation("forge", "terracotta"))).addTag(TERRACOTTAS.get(color).getBlockTag());
			tag(BlockTags.create(new ResourceLocation("forge", "terracotta/"+color))).addTag(TERRACOTTAS.get(color).getBlockTag());
			tag(BlockTags.create(new ResourceLocation("forge", "glazed_terracotta"))).addTag(GLAZED_TERRACOTTAS.get(color).getBlockTag());
			tag(BlockTags.create(new ResourceLocation("forge", "glazed_terracotta/"+color))).addTag(GLAZED_TERRACOTTAS.get(color).getBlockTag());
		}

		tag(Tags.Blocks.NETHERRACK).addTag(NETHERRACK.getBlockTag());

		tag(Tags.Blocks.OBSIDIAN).addTag(OBSIDIAN.getBlockTag());
	}
}
