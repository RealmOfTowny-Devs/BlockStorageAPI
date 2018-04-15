package me.drkmatr1984.storageapi.listeners;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.material.Attachable;

import me.drkmatr1984.storageapi.objects.blocks.SBlock;
import me.drkmatr1984.storageapi.utils.Utils;
import me.drkmatr1984.storageapi.events.BlockPlayerEmptyBucketStorageEvent;
import me.drkmatr1984.storageapi.events.BlockWaterFromToStorageEvent;
import me.drkmatr1984.storageapi.objects.blocks.SAttachable;
import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockWaterListener implements Listener{

	@EventHandler	 
	public void onWaterPassThrough(BlockFromToEvent event){
		Set<SBaseBlock> sBlocks = new HashSet<SBaseBlock>();
		Set<Block> blocks = new HashSet<Block>();
		if(Utils.isOtherAttachable(event.getToBlock().getType())){
			blocks.add(event.getToBlock());
			sBlocks.add(new SBlock(event.getToBlock()));
		}
		if(event.getToBlock().getState() instanceof Attachable) {
			blocks.add(event.getToBlock());
			sBlocks.add(new SAttachable(event.getToBlock(), ((Attachable)event.getToBlock()).getAttachedFace()));
		}
		for(Block b : Utils.getNearbyLiquids(event.getBlock())){
			sBlocks.add(new SBlock(b));
			blocks.add(b);
		}
		BlockWaterFromToStorageEvent storageEvent = new BlockWaterFromToStorageEvent(sBlocks, blocks);
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelBreak()) {
			event.setCancelled(true);		
		}
	}
	
	@EventHandler
	public void onPlayerBucketEvent(PlayerBucketEmptyEvent event){
		Entity breakingEntity = (Entity) event.getPlayer();
		Set<SBaseBlock> sBlocks = new HashSet<SBaseBlock>();
		Set<Block> blocks = new HashSet<Block>();
		if (event.getBucket() != null){
			Block block = event.getBlockClicked();
			Block liquidBlock = block.getRelative(event.getBlockFace());
			for(BlockFace face : BlockFace.values()){
				if(!face.equals(BlockFace.SELF) && !face.equals(BlockFace.DOWN)){
					if(block.getRelative(face).getType().equals(Material.WATER) || block.getRelative(face).getType().equals(Material.LAVA)){
						liquidBlock = block.getRelative(face);
					}
				}
			}
			if(Utils.isOtherAttachable(block.getType())){
				blocks.add(block);
				sBlocks.add(new SBlock(block, breakingEntity));
			}
			if(block.getState() instanceof Attachable) {
				blocks.add(block);
				sBlocks.add(new SAttachable(block, ((Attachable)block).getAttachedFace(), breakingEntity));
			}
			blocks.add(liquidBlock);
			sBlocks.add(new SBlock(liquidBlock, breakingEntity));
		}
		BlockPlayerEmptyBucketStorageEvent storageEvent = new BlockPlayerEmptyBucketStorageEvent(breakingEntity, sBlocks, blocks);
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelBreak()) {
			event.setCancelled(true);
		}
	}
	
}