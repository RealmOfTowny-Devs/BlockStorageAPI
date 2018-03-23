package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.IOException;
import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import me.drkmatr1984.blockstorageapi.utils.ChatUtils;
import me.drkmatr1984.blockstorageapi.utils.InventoryUtil;

public class SInventoryBlock extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8304194076933725859L;
	//info for storing Inventories
	private Byte inventoryData = null;
	private String inventory = null;
	private String inventoryType = null;
	
	@SuppressWarnings("deprecation")
	public SInventoryBlock(Block block) {
		super(block);
		if(block.getState() instanceof InventoryHolder) {
			inventoryData = block.getState().getData().getData();
			inventoryType = ((InventoryHolder) block.getState()).getInventory().getType().toString();
			ItemStack[] inv = ((InventoryHolder) block.getState()).getInventory().getContents();
			inventory = InventoryUtil.toBase64(inv);			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SInventoryBlock(Block block, Entity entity) {
		super(block, entity);
		if(block.getState() instanceof InventoryHolder) {
			inventoryData = block.getState().getData().getData();
			inventoryType = ((InventoryHolder) block.getState()).getInventory().getType().toString();
			ItemStack[] inv = ((InventoryHolder) block.getState()).getInventory().getContents();
			inventory = InventoryUtil.toBase64(inv);			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SInventoryBlock(Location loc) {
		super(loc);
		Block block = loc.getBlock();
		if(block.getState() instanceof InventoryHolder) {
			inventoryData = block.getState().getData().getData();
			inventoryType = ((InventoryHolder) block.getState()).getInventory().getType().toString();
			ItemStack[] inv = ((InventoryHolder) block.getState()).getInventory().getContents();
			inventory = InventoryUtil.toBase64(inv);			
		}
	}
	
	@SuppressWarnings("deprecation")
	public SInventoryBlock(Location loc, Entity entity) {
		super(loc, entity);
		Block block = loc.getBlock();
		if(block.getState() instanceof InventoryHolder) {
			inventoryData = block.getState().getData().getData();
			inventoryType = ((InventoryHolder) block.getState()).getInventory().getType().toString();
			ItemStack[] inv = ((InventoryHolder) block.getState()).getInventory().getContents();
			inventory = InventoryUtil.toBase64(inv);			
		}
	}
	
	public byte getByteData() {
		return this.inventoryData;
	}
	
	public InventoryType getInventoryType() {
		return InventoryType.valueOf(this.inventoryType);
	}
	
	public Inventory getInventory() {
		try {
			return InventoryUtil.inventoryFromBase64(this.inventory);
		} catch (IOException e) {
			ChatUtils.sendColoredLog("&cERROR: &eCannot de-serialize Inventory");
		}
		return null;
	}
}