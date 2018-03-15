package me.drkmatr1984.blockstorageapi.objects.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import me.drkmatr1984.blockstorageapi.objects.misc.SLocation;

public class SEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3687132256061126706L;
	private UUID uid = null;
	private UUID killingEntity = null;
	private UUID passenger = null;
	private List<UUID> passengers = null;
	private SLocation location = null;
	private Integer fireTicks = null;
	private Integer maxFireTicks = null;
	private String customName = null;
	private String name = null;
	private Integer id = null;
	private Float fallDistance = null;
	private Double height = null;
	private Double width = null;
	private Integer portalCooldown = null;
	private Set<String> scoreboardTags = null;
	
	@SuppressWarnings("deprecation")
	public SEntity(Entity entity) {
		uid = entity.getUniqueId();
		this.killingEntity = null;
		location = new SLocation(entity.getLocation());
		fireTicks = entity.getFireTicks();
		maxFireTicks = entity.getMaxFireTicks();
		customName = entity.getCustomName();
		name = entity.getName();
		id = entity.getEntityId();
		fallDistance = entity.getFallDistance();
		height = entity.getHeight();
		width = entity.getWidth();
		passenger = entity.getPassenger().getUniqueId();
		if(!(entity.getPassengers().isEmpty())) {
			passengers = new ArrayList<UUID>();
			for(Entity e : entity.getPassengers()) {
				passengers.add(e.getUniqueId());
			}
		}
		portalCooldown = entity.getPortalCooldown();
		if(!(entity.getScoreboardTags().isEmpty())) {
			scoreboardTags = new HashSet<String>();
			for(String s : entity.getScoreboardTags()) {
				scoreboardTags.add(s);
			}
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public SEntity(Entity entity, Entity killingEntity) {
		uid = entity.getUniqueId();
		this.killingEntity = killingEntity.getUniqueId();
		location = new SLocation(entity.getLocation());
		fireTicks = entity.getFireTicks();
		maxFireTicks = entity.getMaxFireTicks();
		customName = entity.getCustomName();
		name = entity.getName();
		id = entity.getEntityId();
		fallDistance = entity.getFallDistance();
		height = entity.getHeight();
		width = entity.getWidth();
		passenger = entity.getPassenger().getUniqueId();
		if(!(entity.getPassengers().isEmpty())) {
			passengers = new ArrayList<UUID>();
			for(Entity e : entity.getPassengers()) {
				passengers.add(e.getUniqueId());
			}
		}
		portalCooldown = entity.getPortalCooldown();
		if(!(entity.getScoreboardTags().isEmpty())) {
			scoreboardTags = new HashSet<String>();
			for(String s : entity.getScoreboardTags()) {
				scoreboardTags.add(s);
			}
		}
	}
	
	public World getWorld() {
		return this.location.getWorld();
	}
	
	public Entity getKillingEntity(){
		for (World world : Bukkit.getWorlds()) {
			for (Entity entity : world.getEntities()) {
				if (entity.getUniqueId().equals(this.killingEntity)){
					return entity;
	            }
			}
	    }
	    return null;
	}
	
	public UUID getUUID() {
		return this.uid;
	}
	
	public double getX() {
		return this.location.getX();
	}
	
	public double getY() {
		return this.location.getY();
	}
	
	public double getZ() {
		return this.location.getZ();
	}
	
	public int getFireTicks() {
		return this.fireTicks;
	}
	
	public int getMaxFireTicks() {
		return this.getMaxFireTicks();
	}
	
}