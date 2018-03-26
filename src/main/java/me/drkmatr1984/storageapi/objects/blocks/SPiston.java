package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.PistonExtensionMaterial;

import me.drkmatr1984.storageapi.enums.BlockTypes;

public class SPiston extends SBaseBlock implements Serializable{

	/**
	 *     Constructor for serializable Piston Blocks
	 */
	private static final long serialVersionUID = -885579843478491099L;
	//info for storing Pistons
	private String face = null;
	private Boolean isSticky = null;
	private Byte extensionByte = null;
	private Byte pistonByte = null;
	
	@SuppressWarnings("deprecation")
	public SPiston(Block block) {
		super(block, BlockTypes.PISTON);
		if (block.getState().getData() instanceof PistonExtensionMaterial) {
			PistonExtensionMaterial extension = (PistonExtensionMaterial) block.getState().getData();
			face = extension.getFacing().name().toString();
			isSticky = extension.isSticky();
			extensionByte = extension.getData();
			Block piston = block.getRelative(extension.getAttachedFace());
			pistonByte = piston.getState().getData().getData();
		}
	}
	
	@SuppressWarnings("deprecation")
	public SPiston(Block block, Entity entity) {
		super(block, BlockTypes.PISTON);
		if (block.getState().getData() instanceof PistonExtensionMaterial) {
			PistonExtensionMaterial extension = (PistonExtensionMaterial) block.getState().getData();
			face = extension.getFacing().name().toString();
			isSticky = extension.isSticky();
			extensionByte = extension.getData();
			Block piston = block.getRelative(extension.getAttachedFace());
			pistonByte = piston.getState().getData().getData();
		}
	}
	
	@SuppressWarnings("deprecation")
	public SPiston(Location loc) {
		super(loc, BlockTypes.PISTON);
		Block block = loc.getBlock();
		if (block.getState().getData() instanceof PistonExtensionMaterial) {
			PistonExtensionMaterial extension = (PistonExtensionMaterial) block.getState().getData();
			face = extension.getFacing().name().toString();
			isSticky = extension.isSticky();
			extensionByte = extension.getData();
			Block piston = block.getRelative(extension.getAttachedFace());
			pistonByte = piston.getState().getData().getData();
		}
	}
	
	@SuppressWarnings("deprecation")
	public SPiston(Location loc, Entity entity) {
		super(loc, entity, BlockTypes.PISTON);
		Block block = loc.getBlock();
		if (block.getState().getData() instanceof PistonExtensionMaterial) {
			PistonExtensionMaterial extension = (PistonExtensionMaterial) block.getState().getData();
			face = extension.getFacing().name().toString();
			isSticky = extension.isSticky();
			extensionByte = extension.getData();
			Block piston = block.getRelative(extension.getAttachedFace());
			pistonByte = piston.getState().getData().getData();
		}
	}
	
	public BlockFace getFacing() {
		return BlockFace.valueOf(this.face);
	}
	
	public boolean isSticky() {
		return this.isSticky;
	}
	
	public byte getExtensionData() {
		return this.extensionByte;
	}
	
	public byte getPistonData() {
		return this.pistonByte;
	}
}