package me.drkmatr1984.storageapi.objects.tileentities;

import java.io.Serializable;

import org.bukkit.entity.Entity;

import me.drkmatr1984.storageapi.enums.TileEntityTypes;

public class STileEntity extends STileEntityBase implements Serializable
{

	/**
	 *    Constructor for generic serializable Tile Entity
	 */
	private static final long serialVersionUID = -8184154271772803782L;

	public STileEntity(Entity entity) {
		super(entity, TileEntityTypes.GENERIC);
	}
	
	public STileEntity(Entity entity, Entity breakingEntity) {
		super(entity, breakingEntity ,TileEntityTypes.GENERIC);
	}
	
}