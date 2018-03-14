package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.material.PistonExtensionMaterial;

public class SPiston extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -885579843478491099L;
	//info for storing Pistons
	public String face;
	public boolean isSticky;
	public byte extensionByte;
	public byte pistonByte;
	
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
	
}