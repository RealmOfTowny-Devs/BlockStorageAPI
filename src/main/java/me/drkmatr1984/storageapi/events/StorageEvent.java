package me.drkmatr1984.storageapi.events;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class StorageEvent extends Event {

	private static final HandlerList handlerList = new HandlerList();
	
    private Set<SBaseBlock> sBlocks = new HashSet<SBaseBlock>();
    private Set<Block> blocks = new HashSet<Block>();
    private Entity editingEntity = null;
	
    public StorageEvent(Entity editingEntity, Set<SBaseBlock> sBlocks, Set<Block> blocks) {
    	this.sBlocks = sBlocks;
    	this.blocks = blocks;
    	this.editingEntity = editingEntity;
    }
    
	@Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }
	
	public Set<SBaseBlock> getSerializableBlocks() {
		return this.sBlocks;
	}
	
	public Set<Block> getBlocks() {
		return this.blocks;
	}
	
	public Entity getBreakingEntity() {
		return this.editingEntity;
	}
	
}