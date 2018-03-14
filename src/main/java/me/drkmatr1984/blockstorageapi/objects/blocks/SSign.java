package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;

public class SSign extends SBlock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1741861868282739051L;
	//Info for Storing Signs
	public List<String> signLines;
	
	public SSign(Block block) {
		super(block);
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			signLines = new ArrayList<String>();
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}else{
				signLines = null;
			}			
		}
	}
	
	public SSign(Block block, Entity entity) {
		super(block, entity);
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			signLines = new ArrayList<String>();
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}else{
				signLines = null;
			}			
		}
	}
	
	public SSign(Location loc) {
		super(loc);
		Block block = loc.getBlock();
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			signLines = new ArrayList<String>();
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}else{
				signLines = null;
			}			
		}
	}
	
	public SSign(Location loc, Entity entity) {
		super(loc, entity);
		Block block = loc.getBlock();
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			signLines = new ArrayList<String>();
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}else{
				signLines = null;
			}			
		}
	}
	
}