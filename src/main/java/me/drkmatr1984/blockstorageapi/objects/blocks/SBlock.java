package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.material.MaterialData;

import me.drkmatr1984.blockstorageapi.objects.blocks.blockdata.SMaterialData;

@SuppressWarnings("deprecation")
public class SBlock implements Serializable{
	
	private static final long serialVersionUID = -5944092517430475805L;
	
	private String world = null;
	private String mat = null;
	private UUID breakingEntity = null;
	private Integer x = null;
	private Integer y = null;
	private Integer z = null;
	private Byte data = null;
	private SMaterialData materialData = null;
	
	
	/*
	//info for storing itemframes
	public String itemInFrame;
	public String rotation;
	*/
	
	
	public SBlock(Block block, Entity entity){
		//type = "block";
		world = block.getLocation().getWorld().getName().toString();		
		x = block.getLocation().getBlockX();
		y = block.getLocation().getBlockY();
		z = block.getLocation().getBlockZ();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = entity.getUniqueId();
		materialData = new SMaterialData(block.getState().getData());
	}
	
	public SBlock(Block block){
		//type = "block";
		world = block.getLocation().getWorld().getName().toString();		
		x = block.getLocation().getBlockX();
		y = block.getLocation().getBlockY();
		z = block.getLocation().getBlockZ();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
	}
	
	public SBlock(Location loc){
		Block block = loc.getBlock();
		world = block.getLocation().getWorld().getName().toString();		
		x = block.getLocation().getBlockX();
		y = block.getLocation().getBlockY();
		z = block.getLocation().getBlockZ();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
	}
	
	public SBlock(Location loc, Entity entity){
		Block block = loc.getBlock();
		world = block.getLocation().getWorld().getName().toString();		
		x = block.getLocation().getBlockX();
		y = block.getLocation().getBlockY();
		z = block.getLocation().getBlockZ();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = entity.getUniqueId();
	}
	
	public Block getBaseBlock(){
		Location l = new Location(Bukkit.getServer().getWorld(this.world),this.x,this.y,this.z);
		return l.getBlock();
	}
	  
	public Location getLocation(){
		if(this.getWorld()!=null) {
			return new Location(Bukkit.getServer().getWorld(this.world),this.x,this.y,this.z);
		}
		return null;
	}
	
	public World getWorld() {
		if(Bukkit.getServer().getWorld(this.world)!=null) {
			return Bukkit.getServer().getWorld(this.world);
		}
		return null;
	}
	
	public Material getType(){
		return Material.valueOf(this.mat);
	}
	
	public Entity getBreakingEntity(){
		for (World world : Bukkit.getWorlds()) {
			for (Entity entity : world.getEntities()) {
				if (entity.getUniqueId().equals(breakingEntity)){
					return entity;
	            }
			}
	    }
	    return null;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}
	
	public byte getData(){
		return this.data;
	}
	
	public MaterialData getMaterialData() {
		return new MaterialData(materialData.getItemType(), materialData.getData());
	}
	
	/*public SBlock(ItemFrame e){
		type = "itemframe";
		ent = null;
		world = e.getLocation().getWorld().getName().toString();
		x = e.getLocation().getBlockX();
		y = e.getLocation().getBlockY();
		z = e.getLocation().getBlockZ();
		itemInFrame = InventoryUtil.toBase64(e.getItem());
		rotation = e.getRotation().name().toString();
		face = e.getFacing().name().toString();
	}
	
	public SBlock(ItemFrame e, Entity entity){
		type = "itemframe";
		ent = entity.getUniqueId();
		world = e.getLocation().getWorld().getName().toString();
		x = e.getLocation().getBlockX();
		y = e.getLocation().getBlockY();
		z = e.getLocation().getBlockZ();
		itemInFrame = InventoryUtil.toBase64(e.getItem());
		rotation = e.getRotation().name().toString();
		face = e.getFacing().name().toString();
	}*/
}