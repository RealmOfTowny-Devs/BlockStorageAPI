package me.drkmatr1984.blockstorageapi.objects.blocks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;

import me.drkmatr1984.blockstorageapi.enums.BlockTypes;

public class SSign extends SBaseBlock implements Serializable{

	/**
	 *     Constructor for serializable Sign blocks
	 */
	private static final long serialVersionUID = -1741861868282739051L;
	//Info for Storing Signs
	private List<String> signLines = null;
	
	public SSign(Block block) {
		super(block, BlockTypes.SIGN);
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				signLines = new ArrayList<String>();
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}			
		}
	}
	
	public SSign(Block block, Entity entity) {
		super(block, entity, BlockTypes.SIGN);
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				signLines = new ArrayList<String>();
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}			
		}
	}
	
	public SSign(Location loc) {
		super(loc, BlockTypes.SIGN);
		Block block = loc.getBlock();
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());			
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				signLines = new ArrayList<String>();
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}			
		}
	}
	
	public SSign(Location loc, Entity entity) {
		super(loc, entity, BlockTypes.SIGN);
		Block block = loc.getBlock();
		if(block.getState() instanceof Sign){
			Sign sign = (Sign)(block.getState());
			if(!sign.getLines().equals(null) && !(sign.getLines().length <= 0)){
				signLines = new ArrayList<String>();
				for (String line : sign.getLines()){
					signLines.add(line);
				}
			}			
		}
	}
	
	public List<String> getLines() {
		return this.signLines;
	}
	
}