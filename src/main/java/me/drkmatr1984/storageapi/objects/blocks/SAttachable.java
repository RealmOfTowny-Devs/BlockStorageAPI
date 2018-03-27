package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.MaterialData;

import me.drkmatr1984.storageapi.enums.BlockTypes;
import me.drkmatr1984.storageapi.objects.blocks.blockdata.SMaterialData;

public class SAttachable extends SBaseBlock implements Serializable
{

	/**
	 *     Constructor for serializable attachable blocks
	 */
	
	private static final long serialVersionUID = -7698305957544976296L;
	private SMaterialData mAttachable = null;
	private String attachedFace = null;
    
	public SAttachable(Block block, BlockFace attachedFace) {
		super(block, BlockTypes.ATTACHABLE);
		mAttachable = new SMaterialData(block.getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SAttachable(Block block, BlockFace attachedFace, Entity breakingEntity) {
		super(block, breakingEntity, BlockTypes.ATTACHABLE);
		mAttachable = new SMaterialData(block.getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SAttachable(Location loc, BlockFace attachedFace) {
		super(loc, BlockTypes.ATTACHABLE);
		mAttachable = new SMaterialData((loc.getBlock()).getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SAttachable(Location loc, BlockFace attachedFace, Entity breakingEntity) {
		super(loc, breakingEntity, BlockTypes.ATTACHABLE);
		mAttachable = new SMaterialData((loc.getBlock()).getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public boolean isOnFace(BlockFace face) {
		if(face.equals(getAttachedFace())) {
			return true;
		}
		return false;
	}

	public MaterialData getMaterialData() {
		return mAttachable.toMaterialData();
	}
	
	public BlockFace getAttachedFace() {
		return BlockFace.valueOf(this.attachedFace);
	}
}