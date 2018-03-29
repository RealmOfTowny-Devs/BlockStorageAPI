package me.drkmatr1984.storageapi.events;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockPlaceStorageEvent extends Event 
{
	private static final HandlerList handlerList = new HandlerList();
    private boolean cancelPlace = false;
    private Entity buildingEntity;
    private Block placedBlock;
    private BlockState replacedBlock;
    private SBaseBlock placedSBlock;
    private SBaseBlock replacedSBlock;
	
    public BlockPlaceStorageEvent(Entity buildingEntity, Block placedBlock, BlockState replacedBlock, SBaseBlock placedSBlock, SBaseBlock replacedSBlock) {
    	this.buildingEntity = buildingEntity;
    	this.placedBlock = placedBlock;
    	this.replacedBlock = replacedBlock;
    	this.placedSBlock = placedSBlock;
    	this.replacedSBlock = replacedSBlock;
    }
    
    public Entity getPlacingEntity() {
    	return this.buildingEntity;
    }
    
    public Block getPlacedBlock() {
    	return this.placedBlock;
    }
    
    public BlockState getReplacedBlock() {
    	return this.replacedBlock;
    }
    
    public SBaseBlock getPlacedSBlock() {
    	return this.placedSBlock;
    }
    
    public SBaseBlock getReplacedSBlock() {
    	return this.replacedSBlock;
    }
    
	@Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }
    
    public void setCancelPlace(boolean cancel) {
		this.cancelPlace = cancel;
	}
	
	public boolean isCancelPlace() {
		return this.cancelPlace;
	}
}