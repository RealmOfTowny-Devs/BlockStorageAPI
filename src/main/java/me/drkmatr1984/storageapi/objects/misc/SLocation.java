package me.drkmatr1984.storageapi.objects.misc;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class SLocation implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2185982130721731539L;
	private Double x = null;
	private Double y = null;
	private Double z = null;
	private Float pitch = null;
	private Float yaw = null;
	private UUID world = null;
	
	
	public SLocation(Location loc) {
		x = loc.getX();
		y = loc.getY();
		z = loc.getZ();
		pitch = loc.getPitch();
		yaw = loc.getYaw();
		world = loc.getWorld().getUID();
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public float getPitch() {
		return this.pitch;
	}
	
	public float getYaw() {
		return this.yaw;
	}
	
	public World getWorld() {
		return Bukkit.getServer().getWorld(this.world);
	}
	
	public Location toLocation() {
		return new Location(this.getWorld(), this.x, this.y, this.z, this.yaw, this.pitch);
	}
	
}