package util.database;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import models.clientes.Animal;

public class AnimaisDatabase {
    private static String dir = "util/database/records/";
    private static String recordFileName = dir + "AnimaisRecords.txt";

    public static void addRecord(Animal objType) {
        try{
            FileOutputStream file = new FileOutputStream(new File(recordFileName),true);
            ObjectOutputStream obj_output = new ObjectOutputStream(file);
            
            System.out.println(objType);
            obj_output.writeObject(objType);
            
            obj_output.flush();
            obj_output.close();
            file.close();
        }catch(Exception e){
            e.printStackTrace(); // Ja que esta sendo usado swing, nao tem problema manter esse print
        }
    }

    public static void updateRecord(Animal objType) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Animal> recordList = new ArrayList<Animal>();
            Animal record;
            ObjectInputStream obj_input = new ObjectInputStream(file);

            try{
                while(true){
                    record = (Animal) obj_input.readObject();
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
                for (Animal animal : recordList) {
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
            ArrayList<Animal> recordList = new ArrayList<Animal>();
            Animal record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Animal) obj_input.readObject();
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
                ObjectOutputStream oos = null;
                for (Animal animal : recordList) {
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
            // e.printStackTrace();
        }
    }
    

    public static Animal find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Animal record;
            
            // Find the id
            try{
                while(true){
                    record = (Animal) obj_input.readObject();
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

    public static Animal last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Animal record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Animal) obj_input.readObject();
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
    
    public static Animal findByDono(int id){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Animal record;
            
            // Find the id
            try{
                while(true){
                    record = (Animal) obj_input.readObject();
                    if(record.getDonoId() == id){
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

    public static ArrayList<Animal> all(){
        ArrayList<Animal> recordList = new ArrayList<Animal>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Animal record;
            
            try{
                while(true){
                    record = (Animal) obj_input.readObject();
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
        Animal a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
