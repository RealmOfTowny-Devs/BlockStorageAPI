package me.drkmatr1984.storageapi.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Attachable;
import org.bukkit.material.Door;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.Vine;

import me.drkmatr1984.storageapi.events.BlockExplodeStorageEvent;
import me.drkmatr1984.storageapi.events.EntityExplodeStorageEvent;
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
import me.drkmatr1984.storageapi.utils.Utils;

public class BlockExplodeListener implements Listener{
	
	@SuppressWarnings("unchecked")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onEntityExplode(EntityExplodeEvent event) {
		List<Block> blocks = event.blockList();
		ArrayList<SBaseBlock> sBlocks = new ArrayList<SBaseBlock>();
		Entity breakingEntity = event.getEntity();		
		for(ListIterator<Block> blockIterator = blocks.listIterator(); blockIterator.hasNext();){			
			Block block = blockIterator.next();
			for(BlockFace face : BlockFace.values()){
				if(!face.equals(BlockFace.SELF)){
					if(block.getRelative(face).getState().getData() instanceof Attachable){
						sBlocks.add(new SAttachable((block.getRelative(face)), face, breakingEntity));
						blockIterator.add(block.getRelative(face));
					}
					if((block.getRelative(face)).getType().equals(Material.VINE)) {
						sBlocks.add(new SVine((block.getRelative(face)), face, breakingEntity));
						blockIterator.add(block.getRelative(face));
					}
					if((block.getRelative(face)).getType().equals(Material.CHORUS_PLANT) || (block.getRelative(face)).getType().equals(Material.CHORUS_FLOWER)) {
						sBlocks.add(new SBlock((block.getRelative(face)), breakingEntity));
						blockIterator.add(block.getRelative(face));
					}
				}
			}
			if(Utils.isOtherAttachable((block.getRelative(BlockFace.UP)).getType())){
				sBlocks.add(new SBlock((block.getRelative(BlockFace.UP)), breakingEntity));
				blockIterator.add(block.getRelative(BlockFace.UP));
			}
			if((block.getRelative(BlockFace.UP)).getType().equals(Material.CACTUS) || (block.getRelative(BlockFace.UP)).getType().equals(Material.SUGAR_CANE_BLOCK) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_PLANT) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_FLOWER)){
				Block up = block.getRelative(BlockFace.UP);
				do
				{
					if(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER)){
						sBlocks.add(new SBlock(up, breakingEntity));
						blockIterator.add(up);
					}
					up = ((up.getLocation()).add(0,1,0)).getBlock();
				}while(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER));
			}
			if(block.getState().getData() instanceof Door){
				sBlocks.add(new SDoor(block, breakingEntity));
			}else if(block.getState() instanceof InventoryHolder) {
				sBlocks.add(new SInventoryBlock(block, breakingEntity));
			}else if (block.getState().getData() instanceof PistonExtensionMaterial) {
				sBlocks.add(new SPiston(block, breakingEntity));
			}else if(block.getState() instanceof Sign){
				sBlocks.add(new SSign(block, breakingEntity));
			}else if(block.getState() instanceof Skull){
				sBlocks.add(new SSkull(block, breakingEntity));
			}else if(block.getState() instanceof CreatureSpawner){
				sBlocks.add(new SSpawner(block, breakingEntity));
			}else if(block.getState().getData() instanceof Vine) {
				for(BlockFace face : BlockFace.values()) {
					if(((Vine) block.getState().getData()).isOnFace(face)) {
						sBlocks.add(new SVine(block, face ,breakingEntity));
					}
				}	
			}else if(block.getState().getData() instanceof Attachable) {
				sBlocks.add(new SAttachable(block, ((Attachable)block.getState().getData()).getAttachedFace() ,breakingEntity));
			}else {
				sBlocks.add(new SBlock(block, breakingEntity));
			}
			
		}
		EntityExplodeStorageEvent storageEvent = new EntityExplodeStorageEvent(breakingEntity, (Set<SBaseBlock>)Utils.listToSet(sBlocks), (Set<Block>)Utils.listToSet(blocks));
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelBreak()) {
			event.setCancelled(true);		
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onBlockExplode(BlockExplodeEvent event) {
		List<Block> blocks = event.blockList();
		ArrayList<SBaseBlock> sBlocks = new ArrayList<SBaseBlock>();		
		for(ListIterator<Block> blockIterator = blocks.listIterator(); blockIterator.hasNext();){
			Block block = blockIterator.next();
			for(BlockFace face : BlockFace.values()){
				if(!face.equals(BlockFace.SELF)){
					if(block.getRelative(face).getState().getData() instanceof Attachable){
						sBlocks.add(new SAttachable((block.getRelative(face)), face));
						blockIterator.add(block.getRelative(face));
					}
					if((block.getRelative(face)).getType().equals(Material.VINE)) {
						sBlocks.add(new SVine((block.getRelative(face)), face));
						blockIterator.add(block.getRelative(face));
					}
					if((block.getRelative(face)).getType().equals(Material.CHORUS_PLANT) || (block.getRelative(face)).getType().equals(Material.CHORUS_FLOWER)) {
						sBlocks.add(new SBlock((block.getRelative(face))));
						blockIterator.add(block.getRelative(face));
					}
				}
			}
			if(Utils.isOtherAttachable((block.getRelative(BlockFace.UP)).getType())){
				sBlocks.add(new SBlock((block.getRelative(BlockFace.UP))));
				blockIterator.add(block.getRelative(BlockFace.UP));
			}
			if((block.getRelative(BlockFace.UP)).getType().equals(Material.CACTUS) || (block.getRelative(BlockFace.UP)).getType().equals(Material.SUGAR_CANE_BLOCK) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_PLANT) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_FLOWER)){
				Block up = block.getRelative(BlockFace.UP);
				do
				{
					if(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER)){
						sBlocks.add(new SBlock(up));
						blockIterator.add(up);
					}
					up = ((up.getLocation()).add(0,1,0)).getBlock();
				}while(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER));
			}
			if(block.getState().getData() instanceof Door){
				sBlocks.add(new SDoor(block));
			}else if(block.getState() instanceof InventoryHolder) {
				sBlocks.add(new SInventoryBlock(block));
			}else if (block.getState().getData() instanceof PistonExtensionMaterial) {
				sBlocks.add(new SPiston(block));
			}else if(block.getState() instanceof Sign){
				sBlocks.add(new SSign(block));
			}else if(block.getState() instanceof Skull){
				sBlocks.add(new SSkull(block));
			}else if(block.getState() instanceof CreatureSpawner){
				sBlocks.add(new SSpawner(block));
			}else if(block.getState().getData() instanceof Vine) {
				for(BlockFace face : BlockFace.values()) {
					if(((Vine) block.getState().getData()).isOnFace(face)) {
						sBlocks.add(new SVine(block, face));
					}
				}	
			}else if(block.getState().getData() instanceof Attachable) {
				sBlocks.add(new SAttachable(block, ((Attachable)block.getState().getData()).getAttachedFace()));
			}else {
				sBlocks.add(new SBlock(block));
			}
		}
		
		//Create event and call it
		BlockExplodeStorageEvent storageEvent = new BlockExplodeStorageEvent((Set<SBaseBlock>)Utils.listToSet(sBlocks), (Set<Block>)Utils.listToSet(blocks));
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelBreak()) {
			event.setCancelled(true);		
		}
	}
}