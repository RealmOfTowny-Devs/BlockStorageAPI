package me.drkmatr1984.storageapi.objects.blocks;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.material.MaterialData;

import me.drkmatr1984.base64utilslib.BlockBase64Utils;
import me.drkmatr1984.storageapi.enums.BlockTypes;
import me.drkmatr1984.storageapi.objects.blocks.blockdata.SMaterialData;
import me.drkmatr1984.storageapi.objects.misc.SLocation;

@SuppressWarnings("deprecation")
public abstract class SBaseBlock implements Serializable{
	
	private static final long serialVersionUID = -5944092517430475805L;
	
	private SLocation location = null;
	private String mat = null;
	private UUID breakingEntity = null;
	private Byte data = null;
	private SMaterialData materialData = null;
	private String blockType = null;
	
	/**
	 *     Abstract base constructor for serializing Blocks
	 */
	
	public SBaseBlock(Block block, Entity entity, BlockTypes type){
		location = new SLocation(block.getLocation());
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
		if(entity!=null) {
			breakingEntity = entity.getUniqueId();
		}
		materialData = new SMaterialData(block.getState().getData());
		blockType = type.toString();
	}
	
	public SBaseBlock(Block block, BlockTypes type){
		location = new SLocation(block.getLocation());
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
		materialData = new SMaterialData(block.getState().getData());
		blockType = type.toString();
	}
	
	public SBaseBlock(Location loc, BlockTypes type){
		location = new SLocation(loc);
		Block block = loc.getBlock();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
		materialData = new SMaterialData(block.getState().getData());
		blockType = type.toString();
	}
	
	public SBaseBlock(Location loc, Entity entity, BlockTypes type){
		location = new SLocation(loc);
		Block block = loc.getBlock();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = null;
		if(entity!=null) {
			breakingEntity = entity.getUniqueId();
		}
		materialData = new SMaterialData(block.getState().getData());
		blockType = type.toString();
	}
	
	public SBaseBlock(Location loc, Entity entity, BlockTypes type, Material blockMat, Byte blockData, MaterialData materialData) {
		location = new SLocation(loc);
		mat = blockMat.name().toString();
		data = blockData;
		breakingEntity = null;
		if(entity!=null) {
			breakingEntity = entity.getUniqueId();
		}
		this.materialData = new SMaterialData(materialData);
		blockType = type.toString();
	}
	
	public SBaseBlock(Block block, Entity entity, BlockTypes type, Material blockMat, Byte blockData, MaterialData materialData) {
		location = new SLocation(block.getLocation());
		mat = blockMat.name().toString();
		data = blockData;
		breakingEntity = null;
		if(entity!=null) {
			breakingEntity = entity.getUniqueId();
		}
		this.materialData = new SMaterialData(materialData);
		blockType = type.toString();
	}
	
	public Block getBaseBlock(){
		Location l = new Location(this.location.getWorld(), this.location.getX(), this.location.getY(), this.location.getZ());
		return l.getBlock();
	}
	  
	public Location getLocation(){
		if(this.getWorld()!=null) {
			return new Location(this.location.getWorld(), this.location.getX(), this.location.getY(), this.location.getZ());
		}
		return null;
	}
	
	public World getWorld() {
		if(Bukkit.getServer().getWorld(this.location.getWorld().getUID())!=null) {
			return Bukkit.getServer().getWorld(this.location.getWorld().getUID());
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
		return this.location.getX();
	}
	
	public double getY(){
		return this.location.getY();
	}
	
	public double getZ(){
		return this.location.getZ();
	}
	
	public byte getData(){
		return this.data;
	}
	
	public MaterialData getMaterialData() {
		return new MaterialData(materialData.getItemType(), materialData.getData());
	}
	
	public BlockTypes getBlockType() {
		return BlockTypes.valueOf(this.blockType);
	}
	
	public String serialize() {
		return BlockBase64Utils.blockToBase64(this);
	}
	
	public static SBaseBlock deSerialize(String base64){
		try {
			return BlockBase64Utils.blockFromBase64(base64);
		} catch (IOException e) {
			return null;
		}
	}
}