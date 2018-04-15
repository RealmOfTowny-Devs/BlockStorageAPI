package me.drkmatr1984.storageapi.events;

import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockWaterFromToStorageEvent extends StorageEvent
{
	private static final HandlerList handlerList = new HandlerList();
    private boolean cancelBreak = false;
	
    public BlockWaterFromToStorageEvent(Set<SBaseBlock> sBlocks, Set<Block> blocks) {
    	super(null, sBlocks, blocks);
    }
    
	@Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }
	
	public void setCancelBreak(boolean cancel) {
		this.cancelBreak = cancel;
	}
	
	public boolean isCancelBreak() {
		return this.cancelBreak;
	}
	
}