package util.database;

import java.util.ArrayList;

import models.clinica.Veterinario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class VeterinariosDatabase {
    private static String dir = "src\\util\\database\\records\\";
    private static String recordFileName = dir + "VeterinariosRecords.txt";

    public static void addRecord(Veterinario objType) {
        try{
            FileOutputStream file = new FileOutputStream(new File(recordFileName),true);
            ObjectOutputStream obj_output = new ObjectOutputStream(file);
    
            obj_output.writeObject(objType);
            
            obj_output.flush();
            obj_output.close();
            file.close();
        }catch(Exception e){
            // e.printStackTrace(); // Ja que esta sendo usado swing, nao tem problema manter esse print
        }
    }

    public static void updateRecord(Veterinario objType) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Veterinario> recordList = new ArrayList<Veterinario>();
            Veterinario record;
            ObjectInputStream obj_input = new ObjectInputStream(file);

            try{
                while(true){
                    record = (Veterinario) obj_input.readObject();
                    if(record.getId() != objType.getId()){
                        recordList.add(record);
                    }else{
                        recordList.add(objType);
                    }
                    obj_input = new ObjectInputStream(file);
                }
            }catch(Exception e){
                e.printStackTrace();
                obj_input.close();
            }   
            file.close();

            // add all objs from list to file
            OutputStream os = null;
            try {
                os = new FileOutputStream(new File(recordFileName));
                ObjectOutputStream oos = null;
                for (Veterinario animal : recordList) {
                    oos = new ObjectOutputStream(os);
                    oos.writeObject(animal);
                }
                oos.flush();
            } finally {
                if (os != null) {
                    os.close();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void removeRecord(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Veterinario> recordList = new ArrayList<Veterinario>();
            Veterinario record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Veterinario) obj_input.readObject();
                    if(record.getId() != id){
                        recordList.add(record);
                    }
                    obj_input = new ObjectInputStream(file);
                }
            }catch(Exception e){
                // e.printStackTrace();
                obj_input.close();
            }   
            file.close();
            
            // add all objs from list to file
            OutputStream os = null;
            try {
                os = new FileOutputStream(recordFileName);
                ObjectOutputStream oos = null;
                for (Veterinario veterinario : recordList) {
                    oos = new ObjectOutputStream(os);
                    oos.writeObject(veterinario);
                }
                oos.flush();
            } finally {
                if (os != null) {
                    os.close();
                }
            }
        }catch(Exception e){
            // e.printStackTrace();
        }
    }

    public static Veterinario find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Veterinario record;
            
            // Find the id
            try{
                while(true){
                    record = (Veterinario) obj_input.readObject();
                    if(record.getId() == id){
                        return record;
                    }
                    obj_input = new ObjectInputStream(file);
                }
            }catch(Exception e){
                // e.printStackTrace();
                obj_input.close();
            }
            file.close();
        }catch(Exception e){
            // e.printStackTrace();
        }
        return null;
    }

    public static Veterinario last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Veterinario record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Veterinario) obj_input.readObject();
                    obj_input = new ObjectInputStream(file);
                }
            }catch(Exception e){// e.printStackTrace();
                obj_input.close();
                file.close();
                return record;
            }
        }catch(Exception e){
            // e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Veterinario> all(){
        ArrayList<Veterinario> recordList = new ArrayList<Veterinario>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Veterinario record;
            
            try{
                while(true){
                    record = (Veterinario) obj_input.readObject();
                    recordList.add(record);
                    obj_input = new ObjectInputStream(file);
                }
            }catch(Exception e){
                // e.printStackTrace();
                obj_input.close();
            }
            file.close();
        }catch(Exception e){
            // e.printStackTrace();
        }
        return recordList;
    }
    
    public static int getLastId(){
        Veterinario a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
