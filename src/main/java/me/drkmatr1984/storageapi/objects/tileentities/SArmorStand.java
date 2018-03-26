package me.drkmatr1984.storageapi.objects.tileentities;

import java.io.IOException;
import java.io.Serializable;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import me.drkmatr1984.storageapi.enums.TileEntityTypes;
import me.drkmatr1984.storageapi.utils.InventoryUtil;

public class SArmorStand extends STileEntityBase implements Serializable{

	/**
	 *    Constructor for serializable armor stand
	 */
	private static final long serialVersionUID = -3581904942419698186L;
	//info for storing armorstands
	private Double bodyPoseX = null;
	private Double bodyPoseY = null;
	private Double bodyPoseZ = null;
	private Double headPoseX = null;
	private Double headPoseY = null;
	private Double headPoseZ = null;
	private Boolean hasArms = false;
	private Boolean hasBasePlate = false;
	private Boolean isMarker = false;
	private Boolean isSmall = false;
	private Boolean isVisible = false;
	private Double leftArmPoseX = null;
	private Double leftArmPoseY = null;
	private Double leftArmPoseZ = null;
	private Double rightArmPoseX = null;
	private Double rightArmPoseY = null;
	private Double rightArmPoseZ = null;
	private Double leftLegPoseX = null;
	private Double leftLegPoseY = null;
	private Double leftLegPoseZ = null;
	private Double rightLegPoseX = null;
	private Double rightLegPoseY = null;
	private Double rightLegPoseZ = null;
	private String boots = null;
	private String leggings = null;
	private String chestplate = null;
	private String helmet = null;
	private String itemInMainHand = null;
	private String itemInOffHand = null;
	
	public SArmorStand(ArmorStand entity) {
		super(entity, TileEntityTypes.ARMOR_STAND);
		bodyPoseX = entity.getBodyPose().getX();
		bodyPoseY = entity.getBodyPose().getY();
		bodyPoseZ = entity.getBodyPose().getZ();
		headPoseX = entity.getHeadPose().getX();
		headPoseY = entity.getHeadPose().getY();
		headPoseZ = entity.getHeadPose().getZ();
		hasBasePlate = entity.hasBasePlate();
		isMarker = entity.isMarker();
		isSmall = entity.isSmall();
		isVisible = entity.isVisible();
		if(entity.hasArms()) {
			hasArms = entity.hasArms();
			leftArmPoseX = entity.getLeftArmPose().getX();
			leftArmPoseY = entity.getLeftArmPose().getY();
			leftArmPoseZ = entity.getLeftArmPose().getZ();
		    rightArmPoseX = entity.getRightArmPose().getX();
		    rightArmPoseY = entity.getRightArmPose().getY();
		    rightArmPoseZ = entity.getRightArmPose().getZ();
		}
		leftLegPoseX = entity.getLeftLegPose().getX();
		leftLegPoseY = entity.getLeftLegPose().getY();
		leftLegPoseZ = entity.getLeftLegPose().getZ();
		rightLegPoseX = entity.getRightLegPose().getX();
		rightLegPoseY = entity.getRightLegPose().getY();
		rightLegPoseZ = entity.getRightLegPose().getZ();
		if(entity.getBoots()!=null) {
			boots = InventoryUtil.toBase64(entity.getBoots());
		}
		if(entity.getLeggings()!=null) {
			leggings = InventoryUtil.toBase64(entity.getLeggings());
		}
		if(entity.getChestplate()!=null) {
			chestplate = InventoryUtil.toBase64(entity.getChestplate());
		}
		if(entity.getHelmet()!=null) {
			helmet = InventoryUtil.toBase64(entity.getHelmet());
		}
		if(entity.getEquipment().getItemInMainHand()!=null) {
			itemInMainHand = InventoryUtil.toBase64(entity.getEquipment().getItemInMainHand());
		}
		if(entity.getEquipment().getItemInOffHand()!=null) {
			itemInOffHand = InventoryUtil.toBase64(entity.getEquipment().getItemInOffHand());
		}		
	}
	
	public SArmorStand(ArmorStand entity, Entity breakingEntity) {
		super(entity, breakingEntity, TileEntityTypes.ARMOR_STAND);
		bodyPoseX = entity.getBodyPose().getX();
		bodyPoseY = entity.getBodyPose().getY();
		bodyPoseZ = entity.getBodyPose().getZ();
		headPoseX = entity.getHeadPose().getX();
		headPoseY = entity.getHeadPose().getY();
		headPoseZ = entity.getHeadPose().getZ();
		hasBasePlate = entity.hasBasePlate();
		isMarker = entity.isMarker();
		isSmall = entity.isSmall();
		isVisible = entity.isVisible();
		if(entity.hasArms()) {
			hasArms = entity.hasArms();
			leftArmPoseX = entity.getLeftArmPose().getX();
			leftArmPoseY = entity.getLeftArmPose().getY();
			leftArmPoseZ = entity.getLeftArmPose().getZ();
		    rightArmPoseX = entity.getRightArmPose().getX();
		    rightArmPoseY = entity.getRightArmPose().getY();
		    rightArmPoseZ = entity.getRightArmPose().getZ();
		}
		leftLegPoseX = entity.getLeftLegPose().getX();
		leftLegPoseY = entity.getLeftLegPose().getY();
		leftLegPoseZ = entity.getLeftLegPose().getZ();
		rightLegPoseX = entity.getRightLegPose().getX();
		rightLegPoseY = entity.getRightLegPose().getY();
		rightLegPoseZ = entity.getRightLegPose().getZ();
		if(entity.getBoots()!=null) {
			boots = InventoryUtil.toBase64(entity.getBoots());
		}
		if(entity.getLeggings()!=null) {
			leggings = InventoryUtil.toBase64(entity.getLeggings());
		}
		if(entity.getChestplate()!=null) {
			chestplate = InventoryUtil.toBase64(entity.getChestplate());
		}
		if(entity.getHelmet()!=null) {
			helmet = InventoryUtil.toBase64(entity.getHelmet());
		}
		if(entity.getEquipment().getItemInMainHand()!=null) {
			itemInMainHand = InventoryUtil.toBase64(entity.getEquipment().getItemInMainHand());
		}
		if(entity.getEquipment().getItemInOffHand()!=null) {
			itemInOffHand = InventoryUtil.toBase64(entity.getEquipment().getItemInOffHand());
		}		
	}
	
	public EulerAngle getBodyPose() {
		return new EulerAngle(bodyPoseX, bodyPoseY, bodyPoseZ);
	}
	
	public EulerAngle getHeadPose() {
		return new EulerAngle(headPoseX, headPoseY, headPoseZ);
	}
	
	public boolean hasBasePlate() {
		return this.hasBasePlate;
	}
	
	public boolean hasArms() {
		return this.hasArms;
	}
	
	public boolean isMarker() {
		return this.isMarker;
	}
	
	public boolean isSmall() {
		return this.isSmall;
	}
	
	public boolean isVisible() {
		return this.isVisible;
	}
	
	public EulerAngle getLeftArmPose() {
		return new EulerAngle(leftArmPoseX, leftArmPoseY, leftArmPoseZ);
	}
	
	public EulerAngle getRightArmPose() {
		return new EulerAngle(rightArmPoseX, rightArmPoseY, rightArmPoseZ);
	}
	
	public EulerAngle getLeftLegPose() {
		return new EulerAngle(leftLegPoseX, leftLegPoseY, leftLegPoseZ);
	}
	
	public EulerAngle getRightLegPose() {
		return new EulerAngle(rightLegPoseX, rightLegPoseY, rightLegPoseZ);
	}
	
	public ItemStack getBoots() {
		if(boots!=null) {
			try {
				return InventoryUtil.stackFromBase64(boots);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ItemStack getLeggings() {
		if(leggings!=null) {
			try {
				return InventoryUtil.stackFromBase64(leggings);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ItemStack getChestplate() {
		if(chestplate!=null) {
			try {
				return InventoryUtil.stackFromBase64(chestplate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ItemStack getHelmet() {
		if(helmet!=null) {
			try {
				return InventoryUtil.stackFromBase64(helmet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ItemStack getItemInMainHand() {
		if(itemInMainHand!=null) {
			try {
				return InventoryUtil.stackFromBase64(itemInMainHand);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ItemStack getItemInOffHand() {
		if(itemInOffHand!=null) {
			try {
				return InventoryUtil.stackFromBase64(itemInOffHand);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}