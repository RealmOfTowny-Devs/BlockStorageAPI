package me.drkmatr1984.base64utilslib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import me.drkmatr1984.storageapi.objects.blocks.SBaseBlock;

public class BlockBase64Utils {
    public static String blocksToBase64(Collection<SBaseBlock> setBlocks) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            // Save every element in the list
            for (SBaseBlock block : setBlocks) {
                dataOutput.writeObject(block);
            }           
            // Serialize that array
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save blocks.", e);
        }        
    }
    
    public static Collection<SBaseBlock> blocksFromBase64(String data, int size) throws IOException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            Collection<SBaseBlock> setBlocks = new HashSet<SBaseBlock>();
            // Read the serialized list
            for (int i = 0; i < size; i++) {
            	setBlocks.add((SBaseBlock)dataInput.readObject());
            }
            dataInput.close();
            return setBlocks;
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }
    
    public static String blockToBase64(SBaseBlock block) {
    	try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            dataOutput.writeObject(block);        
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save block", e);
        }      
    }
    
    public static SBaseBlock blockFromBase64(String data) throws IOException {
    	try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            SBaseBlock block = (SBaseBlock)dataInput.readObject();
            dataInput.close();
            return block;
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Unable to decode class type.", e);
        }      
    }
    
}