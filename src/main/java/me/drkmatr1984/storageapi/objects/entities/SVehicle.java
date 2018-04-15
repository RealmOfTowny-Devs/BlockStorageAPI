package me.drkmatr1984.storageapi.objects.entities;

import java.io.Serializable;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.util.Vector;

import me.drkmatr1984.storageapi.objects.misc.SVector;

public abstract class SVehicle extends SEntityBase implements Serializable
{

	/**
	 *    Constructor for Serializable Vehicle class
	 */
	private static final long serialVersionUID = -5074055872070413346L;
	private SVector velocity = null;
	
	public SVehicle(Vehicle entity, Entity killingEntity) {
		super(entity, killingEntity);
		this.velocity = new SVector(entity.getVelocity());
	}
	
	public SVehicle(Vehicle entity) {
		super(entity);
		this.velocity = new SVector(entity.getVelocity());
	}
	
	public Vector getVelocity() {
		return this.velocity.toVector();
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = new SVector(velocity);
	}
}