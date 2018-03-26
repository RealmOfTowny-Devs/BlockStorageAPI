package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.Door;

import me.drkmatr1984.storageapi.enums.BlockTypes;
import me.drkmatr1984.storageapi.objects.misc.SLocation;

public class SDoor extends SBaseBlock implements Serializable{

	/**
	 *      Constructor for serializable door blocks
	 */
	private static final long serialVersionUID = -6114608404476236788L;
	//Info for Storing Doors and their movements
	private SLocation topLocation = null;
	private String doorTopMat = null;
	private Byte doorTopData = null;
	private SLocation botLocation = null;
	private String doorBotMat = null;
	private Byte doorBotData = null;
	
	@SuppressWarnings("deprecation")
	public SDoor(Block block) {
		super(block, BlockTypes.DOOR);
		if(block.getState().getData() instanceof Door){
			Door door = (Door) block.getState().getData();
			Block topHalf;
			Block bottomHalf;
			if (door.isTopHalf()) {
				topHalf = block.getState().getBlock();
				bottomHalf = block.getState().getBlock().getRelative(BlockFace.DOWN);
			} else {
				bottomHalf = block.getState().getBlock();
				topHalf = block.getState().getBlock().getRelative(BlockFace.UP);
			}
			topLocation = new SLocation(topHalf.getLocation());		
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			botLocation = new SLocation(bottomHalf.getLocation());
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Block block, Entity entity) {
		super(block, entity, BlockTypes.DOOR);
		if(block.getState().getData() instanceof Door){
			Door door = (Door) block.getState().getData();
			Block topHalf;
			Block bottomHalf;
			if (door.isTopHalf()) {
				topHalf = block.getState().getBlock();
				bottomHalf = block.getState().getBlock().getRelative(BlockFace.DOWN);
			} else {
				bottomHalf = block.getState().getBlock();
				topHalf = block.getState().getBlock().getRelative(BlockFace.UP);
			}
			topLocation = new SLocation(topHalf.getLocation());
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			botLocation = new SLocation(bottomHalf.getLocation());
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Location loc) {		
		super(loc, BlockTypes.DOOR);
		Block block = loc.getBlock();
		if(block.getState().getData() instanceof Door){
			Door door = (Door) block.getState().getData();
			Block topHalf;
			Block bottomHalf;
			if (door.isTopHalf()) {
				topHalf = block.getState().getBlock();
				bottomHalf = block.getState().getBlock().getRelative(BlockFace.DOWN);
			} else {
				bottomHalf = block.getState().getBlock();
				topHalf = block.getState().getBlock().getRelative(BlockFace.UP);
			}
			topLocation = new SLocation(topHalf.getLocation());
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			botLocation = new SLocation(bottomHalf.getLocation());
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Location loc, Entity entity) {		
		super(loc, entity, BlockTypes.DOOR);
		Block block = loc.getBlock();
		if(block.getState().getData() instanceof Door){
			Door door = (Door) block.getState().getData();
			Block topHalf;
			Block bottomHalf;
			if (door.isTopHalf()) {
				topHalf = block.getState().getBlock();
				bottomHalf = block.getState().getBlock().getRelative(BlockFace.DOWN);
			} else {
				bottomHalf = block.getState().getBlock();
				topHalf = block.getState().getBlock().getRelative(BlockFace.UP);
			}
			topLocation = new SLocation(topHalf.getLocation());
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			botLocation = new SLocation(bottomHalf.getLocation());
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	public Location getTopLocation() {
		return this.topLocation.toLocation();
	}
	
	public Location getBotLocation() {
		return this.botLocation.toLocation();
	}
	
	public Material getTopType() {
		return Material.valueOf(this.doorTopMat);
	}
	
	public Material getBotType() {
		return Material.valueOf(this.doorBotMat);
	}
	
	public byte getTopByteData() {
		return this.doorTopData;
	}
	
	public byte getBotByteData() {
		return this.doorBotData;
	}
}