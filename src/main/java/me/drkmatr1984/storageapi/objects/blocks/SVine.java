package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.MaterialData;
import me.drkmatr1984.storageapi.enums.BlockTypes;
import me.drkmatr1984.storageapi.objects.blocks.blockdata.SMaterialData;

public class SVine extends SBaseBlock implements Serializable
{

	/**
	 *     Constructor for serializable vine blocks
	 */
	
	private static final long serialVersionUID = 3726229371661986355L;
	private SMaterialData mVine = null;
	private String attachedFace = null;
    
	public SVine(Block block, BlockFace attachedFace) {
		super(block, BlockTypes.VINE);
		mVine = new SMaterialData(block.getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SVine(Block block, BlockFace attachedFace, Entity breakingEntity) {
		super(block, breakingEntity, BlockTypes.VINE);
		mVine = new SMaterialData(block.getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SVine(Location loc, BlockFace attachedFace) {
		super(loc, BlockTypes.VINE);
		mVine = new SMaterialData((loc.getBlock()).getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public SVine(Location loc, BlockFace attachedFace, Entity breakingEntity) {
		super(loc, breakingEntity, BlockTypes.VINE);
		mVine = new SMaterialData((loc.getBlock()).getState().getData());
		this.attachedFace = attachedFace.name().toString();
	}
	
	public boolean isOnFace(BlockFace face) {
		if(face.equals(getAttachedFace())) {
			return true;
		}
		return false;
	}

	public MaterialData getMaterialData() {
		return mVine.toMaterialData();
	}
	
	public BlockFace getAttachedFace() {
		return BlockFace.valueOf(this.attachedFace);
	}
}