package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;

import com.mojang.authlib.GameProfile;

import me.drkmatr1984.blockstorageapi.enums.BlockTypes;
import me.drkmatr1984.blockstorageapi.utils.SkullUtils;
import me.drkmatr1984.blockstorageapi.utils.UUIDUtils;

public class SSkull extends SBaseBlock implements Serializable{

	/**
	 *     Constructor for serializable skull blocks
	 */
	private static final long serialVersionUID = -8238239120462937636L;
	//Info for Storing Skulls
	private Boolean hasOwner = false;
	private String skullType = null;
	private String skullOwner = null;
	private String skullUrl = null;
	private String rotation = null;
	
	public SSkull(Block block) {
		super(block, BlockTypes.SKULL);
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			skullUrl = SkullUtils.getSkullURL(block);
			rotation = skull.getRotation().toString();
			if(skull.hasOwner()){
				hasOwner = skull.hasOwner();
				skullOwner = skull.getOwningPlayer().getUniqueId().toString();
			}
		}
	}
	
	public SSkull(Block block, Entity entity) {
		super(block, entity, BlockTypes.SKULL);
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			skullUrl = SkullUtils.getSkullURL(block);
			rotation = skull.getRotation().toString();
			if(skull.hasOwner()){
				hasOwner = skull.hasOwner();
				skullOwner = skull.getOwningPlayer().getUniqueId().toString();
			}
		}
	}
	
	public SSkull(Location loc) {
		super(loc, BlockTypes.SKULL);
		Block block = loc.getBlock();
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			skullUrl = SkullUtils.getSkullURL(block);
			rotation = skull.getRotation().toString();
			if(skull.hasOwner()){
				hasOwner = skull.hasOwner();
				skullOwner = skull.getOwningPlayer().getUniqueId().toString();
			}
		}
	}
	
	public SSkull(Location loc, Entity entity) {
		super(loc, entity, BlockTypes.SKULL);
		Block block = loc.getBlock();
		if(block.getState() instanceof Skull){
			Skull skull = (Skull) block.getState();
			skullType = skull.getSkullType().name().toString();
			skullUrl = SkullUtils.getSkullURL(block);
			rotation = skull.getRotation().toString();
			if(skull.hasOwner()){
				hasOwner = skull.hasOwner();
				skullOwner = skull.getOwningPlayer().getUniqueId().toString();
			}
		}
	}
	
	public boolean hasOwner() {
		return this.hasOwner;
	}
	
	public SkullType getSkullType() {
		return SkullType.valueOf(this.skullType);
	}
	
	public OfflinePlayer getOwningPlayer() {
		return UUIDUtils.getOfflinePlayerfromUUID(UUID.fromString(skullOwner));
	}
	
	public GameProfile getGameProfile() {
		if(this.hasOwner) {
			return SkullUtils.getGameProfile(getOwningPlayer());
		}else if(SkullUtils.getNonPlayerProfile(this.skullUrl)!=null){
			return SkullUtils.getNonPlayerProfile(this.skullUrl);
		}else {
			return null;
		}
	}
	
	public BlockFace getRotation() {
		return BlockFace.valueOf(this.rotation);
	}
	
	/*
	public ItemStack getItemStack() {
		if(getSkullType().equals(SkullType.PLAYER)) {
			return SkullUtils.
		}
	}
	*/
}