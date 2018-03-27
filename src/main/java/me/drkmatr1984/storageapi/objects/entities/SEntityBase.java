package me.drkmatr1984.storageapi.objects.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;

import me.drkmatr1984.storageapi.objects.misc.SLocation;
import me.drkmatr1984.storageapi.objects.misc.SVector;

public abstract class SEntityBase implements Serializable{

	/**
	 *    Abstract constructor for generic serializable Entity
	 */
	private static final long serialVersionUID = -3687132256061126706L;
	private UUID uid = null;
	private UUID killingEntity = null;
	private UUID passenger = null;
	private UUID vehicle = null;
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
	private Integer ticksLived = null;
	private String entityType = null;
	private SVector velocity = null;
	
	@SuppressWarnings("deprecation")
	public SEntityBase(Entity entity) {
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
		ticksLived = entity.getTicksLived();
		entityType = entity.getType().toString();
		vehicle = entity.getVehicle().getUniqueId();
		velocity = new SVector(entity.getVelocity());
	}
	
	@SuppressWarnings("deprecation")
	public SEntityBase(Entity entity, Entity killingEntity) {
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
		ticksLived = entity.getTicksLived();
		entityType = entity.getType().toString();
		vehicle = entity.getVehicle().getUniqueId();
		velocity = new SVector(entity.getVelocity());
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
		return this.maxFireTicks;
	}
	
	public Entity getPassenger() {
		for (World world : Bukkit.getWorlds()) {
			for (Entity entity : world.getEntities()) {
				if (entity.getUniqueId().equals(this.passenger)){
					return entity;
	            }
			}
	    }
	    return null;
	}
	
	public List<Entity> getPassengers() {
		if(this.passengers!=null && (!(this.passengers.isEmpty()))) {
			List<Entity> passengersList = new ArrayList<Entity>();
			for (World world : Bukkit.getWorlds()) {
				for (Entity entity : world.getEntities()) {
					for(UUID id : this.passengers) {
						if (entity.getUniqueId().equals(id)){
							passengersList.add(entity);
						}
					}
				}
		    }
			return passengersList;
		}
		
	    return null;
	}
	
	public Entity getVehicle() {
		for (World world : Bukkit.getWorlds()) {
			for (Entity entity : world.getEntities()) {
				if (entity.getUniqueId().equals(this.vehicle)){
					return entity;
	            }
			}
	    }
	    return null;
	}
	
	public String getCustomName() 
	{
		return this.customName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getEntityId() {
		return this.id;
	}
	
	public float getFallDistance() {
		return this.fallDistance;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public int getPortalCooldown() {
		return this.portalCooldown;
	}
	
	public Set<String> getScoreboardTags() {
		return this.scoreboardTags;
	}
	
	public int getTicksLived() {
		return this.ticksLived;
	}
	
	public EntityType getType() {
		return EntityType.valueOf(this.entityType);
	}
	
	public Vector getVelocity() {
		return this.velocity.toVector();
	}
}