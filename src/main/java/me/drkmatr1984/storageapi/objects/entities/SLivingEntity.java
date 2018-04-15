package me.drkmatr1984.storageapi.objects.entities;

import java.io.Serializable;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class SLivingEntity extends SEntityBase implements Serializable 
{

	/**
	 *    Constructor for serializable LivingEntity
	 */
	
	private static final long serialVersionUID = -173277463815933569L;

	public SLivingEntity(LivingEntity entity) {
		super(entity);
	}
	
	public SLivingEntity(LivingEntity entity, Entity killingEntity) {
		super(entity, killingEntity);
	}
	
}