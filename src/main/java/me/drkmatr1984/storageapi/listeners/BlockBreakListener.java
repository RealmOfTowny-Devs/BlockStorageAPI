package me.drkmatr1984.storageapi.listeners;

import java.util.HashSet;
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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Attachable;
import org.bukkit.material.Door;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.Vine;
import org.bukkit.plugin.java.JavaPlugin;

import me.drkmatr1984.storageapi.events.BlockBreakStorageEvent;
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

public class BlockBreakListener implements Listener{
	
	private JavaPlugin plugin;
	
	public BlockBreakListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Set<SBaseBlock> sBlocks = new HashSet<SBaseBlock>();
		Set<Block> blocks = new HashSet<Block>();
		//get list of blocks too for the event, just in case end user wants them
		Entity breakingEntity = (Entity) event.getPlayer();
		//Check for attachables First
		for(BlockFace face : BlockFace.values()){
			if(!face.equals(BlockFace.SELF)){
				if((block.getRelative(face)).getState().getData() instanceof Attachable){
					Block b = (block.getRelative(face));
					Attachable att = (Attachable) (block.getRelative(face)).getState().getData();
					if(b.getRelative(att.getAttachedFace()).equals(block)){
						blocks.add(block.getRelative(face));
						sBlocks.add(new SAttachable((block.getRelative(face)), att.getAttachedFace(), breakingEntity));
					}
				}
				if(block.getRelative(face).getState().getData() instanceof Vine){
					Vine vine = (Vine) block.getRelative(face).getState().getData();
					if(vine.isOnFace(face)){
						blocks.add(block.getRelative(face));
						sBlocks.add(new SVine((block.getRelative(face)), face, breakingEntity));
					}
				}
				if((block.getRelative(face)).getType().equals(Material.CHORUS_PLANT)){
					blocks.add(block.getRelative(face));
					sBlocks.add(new SBlock((block.getRelative(face)), breakingEntity));
				}
				if((block.getRelative(face)).getType().equals(Material.CHORUS_FLOWER)){
					blocks.add(block.getRelative(face));
					sBlocks.add(new SBlock((block.getRelative(face)), breakingEntity));
				}
			}
		}
		if(Utils.isOtherAttachable((block.getRelative(BlockFace.UP)).getType())){
			blocks.add(block.getRelative(BlockFace.UP));
			sBlocks.add(new SBlock((block.getRelative(BlockFace.UP)), breakingEntity));
		}
		if((block.getRelative(BlockFace.UP)).getType().equals(Material.CACTUS) || (block.getRelative(BlockFace.UP)).getType().equals(Material.SUGAR_CANE_BLOCK) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_PLANT) || (block.getRelative(BlockFace.UP)).getType().equals(Material.CHORUS_FLOWER)){
			Block up = block.getRelative(BlockFace.UP);
			do
			{
				if(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER)){
					blocks.add(up);
					sBlocks.add(new SBlock(up, breakingEntity));
				}
				up = ((up.getLocation()).add(0,1,0)).getBlock();
			}while(up.getType().equals(Material.CACTUS) || up.getType().equals(Material.SUGAR_CANE_BLOCK) || up.getType().equals(Material.CHORUS_PLANT) || up.getType().equals(Material.CHORUS_FLOWER));
		}
		//Check for different types of SBlocks
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
		blocks.add(block);
		BlockBreakStorageEvent storageEvent = new BlockBreakStorageEvent(this.plugin, sBlocks, blocks);
		Bukkit.getServer().getPluginManager().callEvent(storageEvent);
		if(storageEvent.isCancelBreak()) {
			event.setCancelled(true);
		}
	}
}