package me.drkmatr1984.storageapi.objects.tileentities;

import java.io.IOException;
import java.io.Serializable;

import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

import me.drkmatr1984.storageapi.enums.TileEntityTypes;
import me.drkmatr1984.storageapi.utils.InventoryUtil;

public class SItemFrame extends STileEntityBase implements Serializable
{

	/**
	 *    Constructor for serializable item frame
	 */
	
	private String itemInFrame = null;
	private String rotation = null;
	private String face = null;
	private String attachedFace = null;
	
	
	private static final long serialVersionUID = -6480852894358526010L;

	public SItemFrame(ItemFrame entity) {
		super(entity, TileEntityTypes.ITEM_FRAME);
		itemInFrame = InventoryUtil.toBase64(entity.getItem());
		rotation = entity.getRotation().name().toString();
		face = entity.getFacing().name().toString();
		attachedFace = entity.getAttachedFace().name().toString();
	}
	
	public SItemFrame(ItemFrame entity, Entity breakingEntity) {
		super(entity, breakingEntity, TileEntityTypes.ITEM_FRAME);
		itemInFrame = InventoryUtil.toBase64(entity.getItem());
		rotation = entity.getRotation().name().toString();
		face = entity.getFacing().name().toString();
		attachedFace = entity.getAttachedFace().name().toString();
	}
	
	public ItemStack getItem() {
		try {
			return InventoryUtil.stackFromBase64(this.itemInFrame);
		} catch (IOException e) {
			return null;
		}
	}
	
	public Rotation getRotation() {
		return Rotation.valueOf(this.rotation);
	}
	
	public BlockFace getFacing() {
		return BlockFace.valueOf(this.face);
	}
	
	public BlockFace getAttachedFace() {
		return BlockFace.valueOf(this.attachedFace);
	}
}