package me.drkmatr1984.storageapi.objects.tileentities;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import me.drkmatr1984.storageapi.enums.TileEntityTypes;
import me.drkmatr1984.storageapi.objects.entities.SEntityBase;

public abstract class STileEntityBase extends SEntityBase implements Serializable{

	/**
	 *     Abstract base constructor for serializing Tile Entities
	 */
	private static final long serialVersionUID = -3687132256061126706L;
	private UUID breakingEntity = null;
	private Integer blockX = null;
	private Integer blockY = null;
	private Integer blockZ = null;
	private String tileEntityType = null;
	
	public STileEntityBase(Entity entity, TileEntityTypes type) {
		super(entity);
		this.breakingEntity = null;
		blockX = entity.getLocation().getBlockX();
		blockY = entity.getLocation().getBlockY();
		blockZ = entity.getLocation().getBlockZ();
		tileEntityType = type.toString();
	}
	
	public STileEntityBase(Entity entity, Entity breakingEntity, TileEntityTypes type) {
		super(entity);
		this.breakingEntity = breakingEntity.getUniqueId();
		blockX = entity.getLocation().getBlockX();
		blockY = entity.getLocation().getBlockY();
		blockZ = entity.getLocation().getBlockZ();
		tileEntityType = type.toString();
	}
	
	public Entity getBreakingEntity(){
		for (World world : Bukkit.getWorlds()) {
			for (Entity entity : world.getEntities()) {
				if (entity.getUniqueId().equals(this.breakingEntity)){
					return entity;
	            }
			}
	    }
	    return null;
	}
	
	public TileEntityTypes getTileType() {
		return TileEntityTypes.valueOf(this.tileEntityType);
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