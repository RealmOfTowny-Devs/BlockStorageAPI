package me.drkmatr1984.storageapi;

import org.bukkit.plugin.java.JavaPlugin;

public class Storage extends JavaPlugin 
{
	
	private static Storage plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Storage getInstance() {
		return plugin;
	}
}