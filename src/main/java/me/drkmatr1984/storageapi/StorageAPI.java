package me.drkmatr1984.storageapi;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.drkmatr1984.storageapi.listeners.BlockBreakListener;
import me.drkmatr1984.storageapi.listeners.BlockExplodeListener;
import me.drkmatr1984.storageapi.listeners.BlockFireListener;
import me.drkmatr1984.storageapi.listeners.BlockPlaceListener;
import me.drkmatr1984.storageapi.listeners.BlockWaterListener;

public class StorageAPI extends JavaPlugin 
{
	
	private static StorageAPI plugin;
	private API api;
	
	@Override
	public void onEnable() {
		plugin = this;
		api = new API(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockBreakListener(), this);
		pm.registerEvents(new BlockExplodeListener(), this);
		pm.registerEvents(new BlockFireListener(), this);
		pm.registerEvents(new BlockPlaceListener(), this);
		pm.registerEvents(new BlockWaterListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static StorageAPI getInstance() {
		return plugin;
	}
	
	public API getAPI() {
		return this.api;
	}
}