package util.database;

import java.util.ArrayList;

import models.clinica.Estagiario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EstagiariosDatabase {
    private static String dir = "util/database/records/";
    private static String recordFileName = dir + "EstagiariosRecords.txt";

    public static void addRecord(Estagiario objType) {
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

    public static void updateRecord(Estagiario objType) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Estagiario> recordList = new ArrayList<Estagiario>();
            Estagiario record;
            ObjectInputStream obj_input = new ObjectInputStream(file);

            try{
                while(true){
                    record = (Estagiario) obj_input.readObject();
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
                for (Estagiario animal : recordList) {
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
            ArrayList<Estagiario> recordList = new ArrayList<Estagiario>();
            Estagiario record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Estagiario) obj_input.readObject();
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
                for (Estagiario estagiario : recordList) {
                    oos.writeObject(estagiario);
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
    
    public static Estagiario find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Estagiario record;
            
            // Find the id
            try{
                while(true){
                    record = (Estagiario) obj_input.readObject();
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

    public static Estagiario last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Estagiario record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Estagiario) obj_input.readObject();
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

    public static ArrayList<Estagiario> all(){
        ArrayList<Estagiario> recordList = new ArrayList<Estagiario>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Estagiario record;
            
            try{
                while(true){
                    record = (Estagiario) obj_input.readObject();
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
        Estagiario a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
