package me.drkmatr1984.storageapi.events;

import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;

import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockIgniteStorageEvent extends StorageEvent
{

	private static final HandlerList handlerList = new HandlerList();
    private boolean cancelIgnite = false;
	
	public BlockIgniteStorageEvent(Entity ignitingEntity, Set<SBaseBlock> sBlocks, Set<Block> blocks) {
		super(ignitingEntity, sBlocks, blocks);
	}
	
	@Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }
	
	public void setCancelIgnite(boolean cancel) {
		this.cancelIgnite = cancel;
	}
	
	public boolean isCancelIgnite() {
		return this.cancelIgnite;
	}
	
}