package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

@SuppressWarnings("deprecation")
public class SBlock implements Serializable{
	
	private static final long serialVersionUID = -5944092517430475805L;
	
	public String world;
	public String mat;
	public UUID breakingEntity;
	public int x;
	public int y;
	public int z;
	public byte data;
	
	
	/*
	//info for storing itemframes
	public String itemInFrame;
	public String rotation;
	//info for storing armorstands
	public Double bodyPoseX;
	public Double bodyPoseY;
	public Double bodyPoseZ;
	public Double headPoseX;
	public Double headPoseY;
	public Double headPoseZ;
	public Double leftArmPoseX;
	public Double leftArmPoseY;
	public Double leftArmPoseZ;
	public Double rightArmPoseX;
	public Double rightArmPoseY;
	public Double rightArmPoseZ;
	public Double leftLegPoseX;
	public Double leftLegPoseY;
	public Double leftLegPoseZ;
	public Double rightLegPoseX;
	public Double rightLegPoseY;
	public Double rightLegPoseZ;
	public String itemInMainHand;
	public String itemInOffHand;
	public String armor;*/
	
	
	public SBlock(Block block, Entity entity){
		//type = "block";
		world = block.getLocation().getWorld().getName().toString();		
		x = block.getLocation().getBlockX();
		y = block.getLocation().getBlockY();
		z = block.getLocation().getBlockZ();
		mat = block.getType().name().toString();
		data = block.getData();
		breakingEntity = entity.getUniqueId();		
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
	
	public Block getBlock(){
		Location l = new Location(Bukkit.getServer().getWorld(this.world),this.x,this.y,this.z);
		return l.getBlock();
	}
	  
	public Location getLocation(){
		return new Location(Bukkit.getServer().getWorld(this.world),this.x,this.y,this.z);
	}
	
	public Material getType(){
		return Material.valueOf(this.mat);
	}
	
	public Entity getEntity(){
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
	
	public BlockState getState(){
		Location l = new Location(Bukkit.getServer().getWorld(this.world),this.x,this.y,this.z);
		return l.getBlock().getState();
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
	}
	
	public SBlock(ArmorStand e){
		type = "armorstand";
		ent = null;
		world = e.getLocation().getWorld().getName().toString();
		x = e.getLocation().getBlockX();
		y = e.getLocation().getBlockY();
		z = e.getLocation().getBlockZ();
		bodyPoseX = e.getBodyPose().getX();
		bodyPoseY = e.getBodyPose().getY();
		bodyPoseZ = e.getBodyPose().getZ();
		headPoseX = e.getHeadPose().getX();
		headPoseY = e.getHeadPose().getY();
		headPoseZ = e.getHeadPose().getZ();
		leftArmPoseX = e.getLeftArmPose().getX();
		leftArmPoseY = e.getLeftArmPose().getY();
		leftArmPoseZ = e.getLeftArmPose().getZ();
		rightArmPoseX = e.getRightArmPose().getX();
		rightArmPoseY = e.getRightArmPose().getY();
		rightArmPoseZ = e.getRightArmPose().getZ();
		leftLegPoseX = e.getLeftLegPose().getX();
		leftLegPoseY = e.getLeftLegPose().getY();
		leftLegPoseZ = e.getLeftLegPose().getZ();
		rightLegPoseX = e.getRightLegPose().getX();
		rightLegPoseY = e.getRightLegPose().getY();
		rightLegPoseZ = e.getRightLegPose().getZ();
		EntityEquipment inv = e.getEquipment();
		armor = InventoryUtil.toBase64(inv.getArmorContents());
		itemInMainHand = InventoryUtil.toBase64(inv.getItemInMainHand());
		itemInOffHand = InventoryUtil.toBase64(inv.getItemInOffHand());
	}
	
	public SBlock(ArmorStand e, Entity entity){
		type = "armorstand";
		ent = entity.getUniqueId();
		world = e.getLocation().getWorld().getName().toString();
		x = e.getLocation().getBlockX();
		y = e.getLocation().getBlockY();
		z = e.getLocation().getBlockZ();
		bodyPoseX = e.getBodyPose().getX();
		bodyPoseY = e.getBodyPose().getY();
		bodyPoseZ = e.getBodyPose().getZ();
		headPoseX = e.getHeadPose().getX();
		headPoseY = e.getHeadPose().getY();
		headPoseZ = e.getHeadPose().getZ();
		leftArmPoseX = e.getLeftArmPose().getX();
		leftArmPoseY = e.getLeftArmPose().getY();
		leftArmPoseZ = e.getLeftArmPose().getZ();
		rightArmPoseX = e.getRightArmPose().getX();
		rightArmPoseY = e.getRightArmPose().getY();
		rightArmPoseZ = e.getRightArmPose().getZ();
		leftLegPoseX = e.getLeftLegPose().getX();
		leftLegPoseY = e.getLeftLegPose().getY();
		leftLegPoseZ = e.getLeftLegPose().getZ();
		rightLegPoseX = e.getRightLegPose().getX();
		rightLegPoseY = e.getRightLegPose().getY();
		rightLegPoseZ = e.getRightLegPose().getZ();
		EntityEquipment inv = e.getEquipment();
		armor = InventoryUtil.toBase64(inv.getArmorContents());
		itemInMainHand = InventoryUtil.toBase64(inv.getItemInMainHand());
		itemInOffHand = InventoryUtil.toBase64(inv.getItemInOffHand());
	}*/
}