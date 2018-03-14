package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;

public class SSkull extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8238239120462937636L;
	//Info for Storing Skulls
	public String skullType;
	public String skullOwner = "";
	
	public SSkull(Block block) {
		super(block);
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			if(skull.hasOwner()){
				skullOwner = skull.getOwningPlayer().toString();
			}
		}
	}
	
	public SSkull(Block block, Entity entity) {
		super(block, entity);
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			if(skull.hasOwner()){
				skullOwner = skull.getOwningPlayer().toString();
			}
		}
	}
	
	public SSkull(Location loc) {
		super(loc);
		Block block = loc.getBlock();
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			if(skull.hasOwner()){
				skullOwner = skull.getOwningPlayer().toString();
			}
		}
	}
	
	public SSkull(Location loc, Entity entity) {
		super(loc, entity);
		Block block = loc.getBlock();
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			if(skull.hasOwner()){
				skullOwner = skull.getOwningPlayer().toString();
			}
		}
	}
}