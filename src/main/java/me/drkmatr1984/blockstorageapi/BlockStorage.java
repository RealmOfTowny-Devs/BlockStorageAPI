package me.drkmatr1984.blockstorageapi;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockStorage extends JavaPlugin 
{
	
	private static BlockStorage plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static BlockStorage getInstance() {
		return plugin;
	}
}