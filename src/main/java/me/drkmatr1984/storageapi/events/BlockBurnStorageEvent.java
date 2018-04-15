package me.drkmatr1984.storageapi.events;

import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;

import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockBurnStorageEvent extends StorageEvent
{

	private static final HandlerList handlerList = new HandlerList();
    private boolean cancelBurn = false;
	
	public BlockBurnStorageEvent(Entity editingEntity, Set<SBaseBlock> sBlocks, Set<Block> blocks) {
		super(editingEntity, sBlocks, blocks);
	}
	
	@Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }
	
	public void setCancelBurn(boolean cancel) {
		this.cancelBurn = cancel;
	}
	
	public boolean isCancelBurn() {
		return this.cancelBurn;
	}
	
}