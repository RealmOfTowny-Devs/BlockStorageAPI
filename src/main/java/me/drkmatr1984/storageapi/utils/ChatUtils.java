package me.drkmatr1984.storageapi.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatUtils
{
	
	public static void sendColoredLog(String log) {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', log));
	}
	
}
