package me.drkmatr1984.blockstorageapi.objects.blocks.blockdata;

import java.io.Serializable;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class SMaterialData implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4376253928179406599L;
	private Byte data = null;
	private String material = null;
	private Integer typeId = null;
	
	@SuppressWarnings("deprecation")
	public SMaterialData(MaterialData materialData) {
		data = materialData.getData();
		material = materialData.getItemType().toString();
		typeId = materialData.getItemTypeId();
	}
	
	public byte getData() {
		return this.data;
	}
	
	public Material getItemType() {
		return Material.valueOf(this.material);
	}
	
	public int getItemTypeId() {
		return this.typeId;
	}
}