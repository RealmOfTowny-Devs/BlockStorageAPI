package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

import me.drkmatr1984.storageapi.enums.BlockTypes;

public class SBlock extends SBaseBlock implements Serializable
{

	/**
	 * 		Constructor for serializable regular Blocks
	 */
	private static final long serialVersionUID = -4834696106573264703L;

	public SBlock(Block block) {
		super(block, BlockTypes.BLOCK);
		// TODO Auto-generated constructor stub
	}
	
	public SBlock(Block block, Entity entity) {
		super(block, entity, BlockTypes.BLOCK);
	}
	
	public SBlock(Location loc) {
		super(loc, BlockTypes.BLOCK);
	}
	
	public SBlock(Location loc, Entity entity) {
		super(loc, entity, BlockTypes.BLOCK);
	}
	
}