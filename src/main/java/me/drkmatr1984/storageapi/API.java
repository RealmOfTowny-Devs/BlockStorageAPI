package me.drkmatr1984.storageapi;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Attachable;
import org.bukkit.material.Door;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.Vine;

import me.drkmatr1984.base64utilslib.BlockBase64Utils;
import me.drkmatr1984.storageapi.objects.blocks.SAttachable;
import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;
import me.drkmatr1984.storageapi.objects.blocks.SBlock;
import me.drkmatr1984.storageapi.objects.blocks.SDoor;
import me.drkmatr1984.storageapi.objects.blocks.SInventoryBlock;
import me.drkmatr1984.storageapi.objects.blocks.SPiston;
import me.drkmatr1984.storageapi.objects.blocks.SSign;
import me.drkmatr1984.storageapi.objects.blocks.SSkull;
import me.drkmatr1984.storageapi.objects.blocks.SSpawner;
import me.drkmatr1984.storageapi.objects.blocks.SVine;

public class API 
{
	
	private StorageAPI plugin;
	
	public API(StorageAPI plugin) {
		this.plugin = plugin;
	}
	
	public SBaseBlock getSBlock(Block block) {
		return getSBlock(block, null);
	}
	
	public SBaseBlock getSBlock(Block block, Entity editingEntity) {
		if(block.getState().getData() instanceof Door){
			return new SDoor(block, editingEntity);
		}else if(block.getState() instanceof InventoryHolder) {
			return new SInventoryBlock(block, editingEntity);
		}else if (block.getState().getData() instanceof PistonExtensionMaterial) {
			return new SPiston(block, editingEntity);
		}else if(block.getState() instanceof Sign){
			return new SSign(block, editingEntity);
		}else if(block.getState() instanceof Skull){
			return new SSkull(block, editingEntity);
		}else if(block.getState() instanceof CreatureSpawner){
			return new SSpawner(block, editingEntity);
		}else if(block.getState().getData() instanceof Vine) {
			for(BlockFace face : BlockFace.values()) {
				if(((Vine) block.getState().getData()).isOnFace(face)) {
					return new SVine(block, face ,editingEntity);
				}
			}	
		}else if(block.getState().getData() instanceof Attachable) {
			return new SAttachable(block, ((Attachable)block.getState().getData()).getAttachedFace() ,editingEntity);
		}else {
			return new SBlock(block, editingEntity);
		}
		return null;
	}
	
	public SBaseBlock getSBlock(Location loc) {
		return getSBlock(loc.getBlock());
	}
	
	public SBaseBlock getSBlock(Location loc, Entity editingEntity) {
		return getSBlock(loc.getBlock(), editingEntity);
	}
	
	public String sblockToString(SBaseBlock sBlock) {
		return BlockBase64Utils.blockToBase64(sBlock);
	}
	
	public SBaseBlock stringToSBlock(String base64sBlock) {
		try {
			return BlockBase64Utils.blockFromBase64(base64sBlock);
		} catch (IOException e) {
			return null;
		}
	}
}