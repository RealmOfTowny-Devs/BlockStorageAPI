package me.drkmatr1984.storageapi.objects.blocks;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import me.drkmatr1984.storageapi.enums.BlockTypes;

public class SSpawner extends SBaseBlock implements Serializable{

	/**
	 *     Constructor for serializable spawner blocks
	 */
	private static final long serialVersionUID = -7762146859080574730L;
	//Info for Storing Spawners
	private String entityType = null;
	private Integer delay = null;
	
	public SSpawner(Block block) {
		super(block, BlockTypes.SPAWNER);
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Block block, Entity entity) {
		super(block, entity, BlockTypes.SPAWNER);
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Location loc) {
		super(loc, BlockTypes.SPAWNER);
		Block block = loc.getBlock();
		if(block.getState() instanceof CreatureSpawner){
			CreatureSpawner spawner = (CreatureSpawner) block.getState();
			entityType = spawner.getSpawnedType().toString();
			delay = spawner.getDelay();
		}
	}
	
	public SSpawner(Location loc, Entity entity) {
		super(loc, entity, BlockTypes.SPAWNER);
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