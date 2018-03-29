package me.drkmatr1984.storageapi.listeners;

import org.bukkit.Bukkit;
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
import me.drkmatr1984.storageapi.events.BlockPlaceStorageEvent;
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
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onBlockPlace(BlockPlaceEvent event) {
		SBaseBlock replacedSBlock = null;
		SBaseBlock placedSBlock = null;
		Entity placingEntity = (Entity) event.getPlayer();
		Block placedBlock = event.getBlockPlaced();
		BlockState replacedBlock = event.getBlockReplacedState();
		//Check for different types of SBlocks		
		if(placedBlock.getState().getData() instanceof Door){
			placedSBlock = new SDoor(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof InventoryHolder) {
			placedSBlock = new SInventoryBlock(placedBlock, placingEntity);
		}else if (placedBlock.getState().getData() instanceof PistonExtensionMaterial) {
			placedSBlock = new SPiston(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof Sign){
			placedSBlock = new SSign(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof Skull){
			placedSBlock = new SSkull(placedBlock, placingEntity);
		}else if(placedBlock.getState() instanceof CreatureSpawner){
			placedSBlock = new SSpawner(placedBlock, placingEntity);
		}else if(placedBlock.getState().getData() instanceof Vine) {
			for(BlockFace face : BlockFace.values()) {
				if(((Vine) placedBlock.getState().getData()).isOnFace(face)) {
					placedSBlock = new SVine(placedBlock, face ,placingEntity);
				}
			}	
		}else if(placedBlock.getState().getData() instanceof Attachable) {
			placedSBlock = new SAttachable(placedBlock, ((Attachable)placedBlock.getState().getData()).getAttachedFace() ,placingEntity);
		}else {
			placedSBlock = new SBlock(placedBlock, placingEntity);
		}
		//Got the placed Block and Sblock, now let's get the previous one
		if(replacedBlock.getData() instanceof Door){
			replacedSBlock = new SDoor(replacedBlock.getBlock(), placingEntity);
		}else if(replacedBlock instanceof InventoryHolder) {
			replacedSBlock = new SInventoryBlock(replacedBlock.getBlock(), placingEntity);
		}else if (replacedBlock.getData() instanceof PistonExtensionMaterial) {
			replacedSBlock = new SPiston(replacedBlock.getBlock(), placingEntity);
		}else if(replacedBlock instanceof Sign){
			replacedSBlock = new SSign(replacedBlock.getBlock(), placingEntity);
		}else if(replacedBlock instanceof Skull){
			replacedSBlock = new SSkull(replacedBlock.getBlock(), placingEntity);
		}else if(replacedBlock instanceof CreatureSpawner){
			replacedSBlock = new SSpawner(replacedBlock.getBlock(), placingEntity);
		}else if(replacedBlock.getData() instanceof Vine) {
			for(BlockFace face : BlockFace.values()) {
				if(((Vine) replacedBlock.getData()).isOnFace(face)) {
					replacedSBlock = new SVine(replacedBlock.getBlock(), face ,placingEntity);
				}
			}	
		}else if(replacedBlock.getData() instanceof Attachable) {
			replacedSBlock = new SAttachable(replacedBlock.getBlock(), ((Attachable)replacedBlock.getData()).getAttachedFace() ,placingEntity);
		}else {
			replacedSBlock = new SBlock(replacedBlock.getBlock(), placingEntity);
		}
		if(Bukkit.getServer().getPlayer("Myekaan")!=null) {
			Bukkit.getServer().getPlayer("Myekaan").sendMessage("Player: " + event.getPlayer().getName().toString());
			Bukkit.getServer().getPlayer("Myekaan").sendMessage("Placed Block: " + placedBlock.getType().toString());
			Bukkit.getServer().getPlayer("Myekaan").sendMessage("Replaced Block: " + replacedBlock.getType().toString());
		}
		// Set up event and call it
		BlockPlaceStorageEvent storageEvent = new BlockPlaceStorageEvent(placingEntity, placedBlock, replacedBlock, placedSBlock, replacedSBlock);
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelPlace()) {
			event.setBuild(false);
			event.setCancelled(true);		
		}
	}
	
}
