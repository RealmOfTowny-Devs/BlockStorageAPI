package me.drkmatr1984.storageapi.events;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockBreakStorageEvent extends Event
{
	private static final HandlerList handlerList = new HandlerList();
    private boolean cancelBreak = false;
    private JavaPlugin plugin;
    private String pluginName = null;
    private Set<SBaseBlock> sBlocks = new HashSet<SBaseBlock>();
    private Set<Block> blocks = new HashSet<Block>();
	
    public BlockBreakStorageEvent(JavaPlugin plugin, Set<SBaseBlock> sBlocks, Set<Block> blocks) {
    	this.plugin = plugin;
    	this.pluginName = plugin.getName().toString();
    	this.sBlocks = sBlocks;
    	this.blocks = blocks;
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
	
	public String getStoringPluginName() {
		return this.pluginName;
	}
	
	public void setCancelBreak(boolean cancel) {
		this.cancelBreak = cancel;
	}
	
	public boolean isCancelBreak() {
		return this.cancelBreak;
	}
	
	public JavaPlugin getStoringPlugin() {
		return this.plugin;
	}
}