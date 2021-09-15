package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Atendimento;

import java.io.*;

import util.log.Activity;

public class AtendimentosDatabase {
    private static String dir = "util/database/records/";
    private static String recordFileName = dir + "AtendimentosRecords.txt";

    public static void addRecord(Atendimento objType) {
        try{
            FileOutputStream file = new FileOutputStream(new File(recordFileName),true);
            ObjectOutputStream obj_output = new ObjectOutputStream(file);
    
            obj_output.writeObject(objType);
            new Activity("Atendimento: " + objType + " foi adicionado ao sistema por " + objType.getEstagiario().getNome() + ".");
            
            obj_output.flush();
            obj_output.close();
            file.close();
        }catch(Exception e){
            e.printStackTrace(); // Ja que esta sendo usado swing, nao tem problema manter esse print
        }
    }

    public static void updateRecord(Atendimento objType) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ArrayList<Atendimento> recordList = new ArrayList<Atendimento>();
            Atendimento record;
            ObjectInputStream obj_input = new ObjectInputStream(file);

            try{
                while(true){
                    record = (Atendimento) obj_input.readObject();
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
                for (Atendimento animal : recordList) {
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
            ArrayList<Atendimento> recordList = new ArrayList<Atendimento>();
            Atendimento record;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            // Find the id, don't add to list
            try{
                while(true){
                    record = (Atendimento) obj_input.readObject();
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
                for (Atendimento atendimento : recordList) {
                    oos.writeObject(atendimento);
                    oos = new ObjectOutputStream(os);
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

    public static Atendimento find(int id) {
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Atendimento record;
            
            // Find the id
            try{
                while(true){
                    record = (Atendimento) obj_input.readObject();
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

    public static Atendimento last(){
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            Atendimento record = null;
            ObjectInputStream obj_input = new ObjectInputStream(file);
            
            try{
                while(true){
                    record = (Atendimento) obj_input.readObject();
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

    public static ArrayList<Atendimento> all(){
        ArrayList<Atendimento> recordList = new ArrayList<Atendimento>();
        try{
            FileInputStream file = new FileInputStream(new File(recordFileName));
            ObjectInputStream obj_input = new ObjectInputStream(file);
            Atendimento record;
            
            try{
                while(true){
                    record = (Atendimento) obj_input.readObject();
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
        Atendimento a = last();
        if(a != null){
            return a.getId();
        }
        return 0;
    }
}
