package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.PistonExtensionMaterial;

public class SPiston extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -885579843478491099L;
	//info for storing Pistons
	private String face = null;
	private Boolean isSticky = null;
	private Byte extensionByte = null;
	private Byte pistonByte = null;
	
	@SuppressWarnings("deprecation")
	public SPiston(Block block) {
		super(block);
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
		super(block);
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
		super(loc);
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
		super(loc, entity);
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