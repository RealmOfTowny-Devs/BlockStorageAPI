package me.drkmatr1984.storageapi;

import org.bukkit.plugin.java.JavaPlugin;

public class StorageAPI extends JavaPlugin 
{
	
	private static StorageAPI plugin;
	private API api;
	
	@Override
	public void onEnable() {
		plugin = this;
		api = new API(this);
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