package me.drkmatr1984.blockstorageapi.objects.tileentities;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.entity.Entity;

public class STileEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3687132256061126706L;
	public String world;
	public String tileType;
	public UUID uid;
	public UUID breakingEntity;
	public int x;
	public int y;
	public int z;
	public byte data;
	
	public STileEntity(Entity entity) {
		world = entity.getWorld().toString();
		tileType = entity.getType().toString();
		uid = entity.getUniqueId();
		this.breakingEntity = null;
		x = entity.getLocation().getBlockX();
		y = entity.getLocation().getBlockY();
		z = entity.getLocation().getBlockZ();
	}
	
	public STileEntity(Entity entity, Entity breakingEntity) {
		world = entity.getWorld().toString();
		tileType = entity.getType().toString();
		uid = entity.getUniqueId();
		this.breakingEntity = breakingEntity.getUniqueId();
		x = entity.getLocation().getBlockX();
		y = entity.getLocation().getBlockY();
		z = entity.getLocation().getBlockZ();
	}

}