package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class SSpawner extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7762146859080574730L;
	//Info for Storing Spawners
	private String entityType = null;
	private Integer delay = null;
	
	public SSpawner(Block block) {
		super(block);
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Block block, Entity entity) {
		super(block, entity);
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Location loc) {
		super(loc);
		Block block = loc.getBlock();
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Location loc, Entity entity) {
		super(loc, entity);
		Block block = loc.getBlock();
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public EntityType getSpawnedType() {
		return EntityType.valueOf(this.entityType);
	}
	
	public int getDelay() {
		return this.delay;
	}
}