package util.database;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import models.clientes.Dono;

public class DonosDatabase {
    private static String dir = "src\\util\\database\\records\\";
    private static String recordFileName = dir + "DonosRecords.txt";

    public static void addRecord(Dono objType) {
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

    public static void removeRecord(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Dono> recordList = new ArrayList<Dono>();
            Dono record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Dono) obj_input.readObject();
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
                ObjectOutputStream oos = new ObjectOutputStream(os);
                for (Dono animal : recordList) {
                    oos.writeObject(animal);
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
    

    public static Dono find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Dono record;
            
            // Find the id
            try{
                while(true){
                    record = (Dono) obj_input.readObject();
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

    public static Dono last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Dono record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Dono) obj_input.readObject();
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
    
    public static ArrayList<Dono> all(){
        ArrayList<Dono> recordList = new ArrayList<Dono>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Dono record;
            
            try{
                while(true){
                    record = (Dono) obj_input.readObject();
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

    public static Dono findByAnimal(int id){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Dono record;
            
            // Find the id
            try{
                while(true){
                    record = (Dono) obj_input.readObject();
                    if(record.getAnimalId() == id){
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
    
    public static int getLastId(){
        Dono a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}