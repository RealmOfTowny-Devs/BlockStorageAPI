package me.drkmatr1984.blockstorageapi.objects.tileentities;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import me.drkmatr1984.blockstorageapi.objects.entities.SEntity;

public class STileEntity extends SEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3687132256061126706L;
	private String tileType = null;
	private UUID breakingEntity = null;
	private Integer blockX = null;
	private Integer blockY = null;
	private Integer blockZ = null;
	private String tileEntityType = null;
	
	public STileEntity(Entity entity) {
		super(entity);
		tileType = entity.getType().toString();
		this.breakingEntity = null;
		blockX = entity.getLocation().getBlockX();
		blockY = entity.getLocation().getBlockY();
		blockZ = entity.getLocation().getBlockZ();
	}
	
	public STileEntity(Entity entity, Entity breakingEntity) {
		super(entity);
		tileType = entity.getType().toString();
		this.breakingEntity = breakingEntity.getUniqueId();
		blockX = entity.getLocation().getBlockX();
		blockY = entity.getLocation().getBlockY();
		blockZ = entity.getLocation().getBlockZ();
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
	
	public EntityType getTileType() {
		return EntityType.valueOf(this.tileType);
	}
	
	public int getBlockX() {
		return this.blockX;
	}
	
    public int getBlockY() {
		return this.blockY;
	}
    
    public int getBlockZ() {
    	return this.blockZ;
    }
}