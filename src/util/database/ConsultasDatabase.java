package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Consulta;

import java.io.*;

import util.log.Activity;

public class ConsultasDatabase {
    private static String dir = "src\\util\\database\\records\\";
    private static String recordFileName = dir + "ConsultasRecords.txt";

    public static void addRecord(Consulta objType) {
        try{
            FileOutputStream file = new FileOutputStream(new File(recordFileName),true);
            ObjectOutputStream obj_output = new ObjectOutputStream(file);
    
            obj_output.writeObject(objType);
            new Activity("Consulta: uma nova consulta foi aberta com o pet: " + objType.getAnimal().getNome());
            
            obj_output.flush();
            obj_output.close();
            file.close();
        }catch(Exception e){
            e.printStackTrace(); // Ja que esta sendo usado swing, nao tem problema manter esse print
        }
    }

    public static void removeRecord(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Consulta> recordList = new ArrayList<Consulta>();
            Consulta record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Consulta) obj_input.readObject();
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
                for (Consulta consulta : recordList) {
                    oos.writeObject(consulta);
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
    

    public static Consulta find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Consulta record;
            
            // Find the id
            try{
                while(true){
                    record = (Consulta) obj_input.readObject();
                    if(record.getId() == id) {
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

    public static Consulta last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Consulta record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Consulta) obj_input.readObject();
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

    public static ArrayList<Consulta> all(){
        ArrayList<Consulta> recordList = new ArrayList<Consulta>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Consulta record;
            
            try{
                while(true){
                    record = (Consulta) obj_input.readObject();
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
    
    public static Consulta findByVet(int id){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Consulta record;
            
            // Find the id
            try{
                while(true){
                    record = (Consulta) obj_input.readObject();
                    if(record.getVeterinario().getId() == id && record.getDataFechamento() == null){
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
        Consulta a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
