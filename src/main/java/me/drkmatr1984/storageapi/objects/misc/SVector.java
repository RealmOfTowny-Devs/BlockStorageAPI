package me.drkmatr1984.storageapi.objects.misc;

import java.io.Serializable;

import org.bukkit.util.Vector;

public class SVector implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7118485491116624659L;
	private Integer intX = null;
	private Double doubleX = null;
	private Integer intY = null;
	private Double doubleY = null;
	private Integer intZ = null;
	private Double doubleZ = null;
	
	public SVector(Vector vector) {
        intX = vector.getBlockX();
        doubleX = vector.getX();
        intY = vector.getBlockY();
        doubleY = vector.getY();
        intZ = vector.getBlockZ();
        doubleZ = vector.getZ();
	}
	
	public int getBlockX() {
		return this.intX;
	}
	
	public int getBlockY() {
		return this.intY;
	}

	public int getBlockZ() {
	    return this.intZ;
	}
	
	public double getX() {
		return this.doubleX;
	}
	
    public double getY() {
		return this.doubleY;
	}

    public double getZ() {
    	return this.doubleZ;
    }   
    
    public Vector toVector() {
    	Vector vector = new Vector();
		vector.setX(this.doubleX);
		vector.setY(this.doubleY);
		vector.setZ(this.doubleZ);
		return vector;
    }
}