package me.drkmatr1984.base64utilslib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import me.drkmatr1984.storageapi.objects.entities.SEntityBase;

public class EntityBase64Utils 
{
	public static String entitiesToBase64(Collection<SEntityBase> entities) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            // Save every element in the list
            for (SEntityBase entity : entities) {
                dataOutput.writeObject(entity);
            }           
            // Serialize that array
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save entities.", e);
        }        
    }
    
    public static Collection<SEntityBase> entitiesFromBase64(String data, int size) throws IOException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            Collection<SEntityBase> entities = new HashSet<SEntityBase>();
            // Read the serialized list
            for (int i = 0; i < size; i++) {
            	entities.add((SEntityBase)dataInput.readObject());
            }
            dataInput.close();
            return entities;
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }
    
    public static String entityToBase64(SEntityBase entity) {
    	try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            dataOutput.writeObject(entity);        
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save entity", e);
        }      
    }
    
    public static SEntityBase entityFromBase64(String data) throws IOException {
    	try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            SEntityBase entity = (SEntityBase)dataInput.readObject();
            dataInput.close();
            return entity;
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Unable to decode class type.", e);
        }      
    }
}