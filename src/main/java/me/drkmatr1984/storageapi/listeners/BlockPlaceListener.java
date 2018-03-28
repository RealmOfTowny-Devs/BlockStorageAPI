package me.drkmatr1984.storageapi.listeners;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Attachable;
import org.bukkit.material.Door;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.Vine;

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

public class BlockPlaceListener implements Listener
{
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent event) {
		SBaseBlock sBlock = null;
		Entity placingEntity = (Entity) event.getPlayer();
		Block placedBlock = event.getBlockPlaced();
		BlockState replacedBlock = event.getBlockReplacedState();
		//Check for different types of SBlocks
		
		if(placedBlock.getState().getData() instanceof Door){
			sBlock = new SDoor(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof InventoryHolder) {
			sBlock = new SInventoryBlock(placedBlock, placingEntity);
		}else if (placedBlock.getState().getData() instanceof PistonExtensionMaterial) {
			sBlock = new SPiston(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof Sign){
			sBlock = new SSign(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof Skull){
			sBlock = new SSkull(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof CreatureSpawner){
			sBlock = new SSpawner(placedBlock, placingEntity);
		}else if(placedBlock.getState().getData() instanceof Vine) {
			for(BlockFace face : BlockFace.values()) {
				if(((Vine) placedBlock.getState().getData()).isOnFace(face)) {
					sBlock = new SVine(placedBlock, face ,placingEntity);
				}
			}	
		}else if(placedBlock.getState().getData() instanceof Attachable) {
			sBlock = new SAttachable(placedBlock, ((Attachable)placedBlock.getState().getData()).getAttachedFace() ,placingEntity);
		}else {
			sBlock = new SBlock(placedBlock, placingEntity);
		}
		//Got the placed Block and Sblock, now let's get the previous one
		
	}
	
}
