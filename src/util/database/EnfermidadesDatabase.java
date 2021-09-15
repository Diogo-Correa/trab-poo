package util.database;

import java.util.ArrayList;

import util.Enfermidade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EnfermidadesDatabase {
    private static String dir = "src\\util\\database\\records\\";
    private static String recordFileName = dir + "EnfermidadesRecords.txt";

    public static void addRecord(Enfermidade objType) {
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
            ArrayList<Enfermidade> recordList = new ArrayList<Enfermidade>();
            Enfermidade record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Enfermidade) obj_input.readObject();
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
                for (Enfermidade enfermidade : recordList) {
                    oos.writeObject(enfermidade);
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
    
    public static Enfermidade find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Enfermidade record;
            
            // Find the id
            try{
                while(true){
                    record = (Enfermidade) obj_input.readObject();
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

    public static Enfermidade last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Enfermidade record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Enfermidade) obj_input.readObject();
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

    public static ArrayList<Enfermidade> all(){
        ArrayList<Enfermidade> recordList = new ArrayList<Enfermidade>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Enfermidade record;
            
            try{
                while(true){
                    record = (Enfermidade) obj_input.readObject();
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
        Enfermidade a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
