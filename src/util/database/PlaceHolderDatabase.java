package util.database;

import java.util.ArrayList;
import util.log.Activity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Database {
    private String recordFileName;
    private int lastId;

    public Database(String recordType){
        this.recordFileName = recordType + "Records.txt";
        this.lastId = 0;
    }

    public static void addRecord(Object objType) {
        try{
            FileOutputStream file = new FileOutputStream(new File(this.recordFileName),true);
            ObjectOutputStream obj_output = new ObjectOutputStream(file);
    
            obj_output.writeObject(objType);
            
            obj_output.flush();
            obj_output.close();
            file.close();
        }catch(Exception e){
            e.printStackTrace(); // Ja que esta sendo usado swing, nao tem problema manter esse print
        }
    }

    public static void removeRecord(int id) {
        FileInputStream file = new FileInputStream(new File(this.recordFileName));
        ObjectInputStream obj_input;
        ArrayList<Object> recordList = new ArrayList<Object>();
        Object record;

        // Find the id, don't add to list
        try{
            while(true){
                obj_input = new ObjectInputStream(file);
                record = (Object) obj_input.readObject();
                if(record.getId() != id){
                    recordList.add(record);
                }
                obj_input.close();
            }
        }catch(Exception e){}
        file.close();

        // add all objs from list to file
        OutputStream os = null;
        try {
          os = new FileOutputStream(this.recordFileName);
          ObjectOutputStream oos = new ObjectOutputStream(os);
          for (Object object : objects) {
            oos.writeObject(object);
          }
          oos.flush();
        } finally {
          if (os != null) {
            os.close();
          }
        }
    }

    // public static Object find(int id) {}

    // public static Object last(){}
        
}
