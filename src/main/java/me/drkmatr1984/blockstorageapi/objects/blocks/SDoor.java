package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.material.Door;

public class SDoor extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6114608404476236788L;
	//Info for Storing Doors and their movements
	public String doorTopWorld;
	public String doorTopMat;
	public int doorTopX;
	public int doorTopY;
	public int doorTopZ;
	public byte doorTopData;
	public String doorBotWorld;
	public String doorBotMat;
	public int doorBotX;
	public int doorBotY;
	public int doorBotZ;
	public byte doorBotData;
	
	@SuppressWarnings("deprecation")
	public SDoor(Block block) {
		super(block);
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
			doorTopWorld = topHalf.getLocation().getWorld().getName().toString();		
			doorTopX = topHalf.getLocation().getBlockX();
			doorTopY = topHalf.getLocation().getBlockY();
			doorTopZ = topHalf.getLocation().getBlockZ();
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			doorBotWorld = bottomHalf.getLocation().getWorld().getName().toString();		
			doorBotX = bottomHalf.getLocation().getBlockX();
			doorBotY = bottomHalf.getLocation().getBlockY();
			doorBotZ = bottomHalf.getLocation().getBlockZ();
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Block block, Entity entity) {
		super(block, entity);
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
			doorTopWorld = topHalf.getLocation().getWorld().getName().toString();		
			doorTopX = topHalf.getLocation().getBlockX();
			doorTopY = topHalf.getLocation().getBlockY();
			doorTopZ = topHalf.getLocation().getBlockZ();
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			doorBotWorld = bottomHalf.getLocation().getWorld().getName().toString();		
			doorBotX = bottomHalf.getLocation().getBlockX();
			doorBotY = bottomHalf.getLocation().getBlockY();
			doorBotZ = bottomHalf.getLocation().getBlockZ();
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Location loc) {		
		super(loc);
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
			doorTopWorld = topHalf.getLocation().getWorld().getName().toString();		
			doorTopX = topHalf.getLocation().getBlockX();
			doorTopY = topHalf.getLocation().getBlockY();
			doorTopZ = topHalf.getLocation().getBlockZ();
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			doorBotWorld = bottomHalf.getLocation().getWorld().getName().toString();		
			doorBotX = bottomHalf.getLocation().getBlockX();
			doorBotY = bottomHalf.getLocation().getBlockY();
			doorBotZ = bottomHalf.getLocation().getBlockZ();
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SDoor(Location loc, Entity entity) {		
		super(loc, entity);
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
			doorTopWorld = topHalf.getLocation().getWorld().getName().toString();		
			doorTopX = topHalf.getLocation().getBlockX();
			doorTopY = topHalf.getLocation().getBlockY();
			doorTopZ = topHalf.getLocation().getBlockZ();
			doorTopMat = topHalf.getType().name().toString();
			doorTopData = topHalf.getData();
			doorBotWorld = bottomHalf.getLocation().getWorld().getName().toString();		
			doorBotX = bottomHalf.getLocation().getBlockX();
			doorBotY = bottomHalf.getLocation().getBlockY();
			doorBotZ = bottomHalf.getLocation().getBlockZ();
			doorBotMat = bottomHalf.getType().name().toString();
			doorBotData = bottomHalf.getData();			
		}
	}
}