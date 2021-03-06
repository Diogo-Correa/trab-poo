package util.database;

import java.util.ArrayList;

import models.clinica.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class UsersDatabase {
    private static String dir = "src\\util\\database\\records\\";
    private static String recordFileName = dir + "UserRecords.txt";

    public static void addRecord(User objType) {
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

    public static void updateRecord(User objType) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<User> recordList = new ArrayList<User>();
            User record;
            ObjectInputStream obj_input = new ObjectInputStream(file);

            try{
                while(true){
                    record = (User) obj_input.readObject();
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
                for (User animal : recordList) {
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
            ArrayList<User> recordList = new ArrayList<User>();
            User record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (User) obj_input.readObject();
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
                for (User user : recordList) {
                    oos = new ObjectOutputStream(os);
                    oos.writeObject(user);
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
    
    public static User find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            User record;
            
            // Find the id
            try{
                while(true){
                    record = (User) obj_input.readObject();
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

    public static User last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            User record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (User) obj_input.readObject();
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

    public static ArrayList<User> all(){
        ArrayList<User> recordList = new ArrayList<User>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            User record;
            
            try{
                while(true){
                    record = (User) obj_input.readObject();
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
        User a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
