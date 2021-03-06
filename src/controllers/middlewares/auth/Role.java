package controllers.middlewares.auth;

import java.io.Serializable;
import java.util.*;

import util.database.RolesDatabase;
import util.log.Activity;

public class Role implements Serializable {
    private ArrayList<Permission> permissions = new ArrayList<Permission>();
    private String name;
    private int id = 0;
  
    public Role(String name) {
      this.name = name;
      this.id = RolesDatabase.getLastId() + 1;
      RolesDatabase.addRecord(this);
    }

    public int getId() { return id; }
  
    public String getNome() { return this.name; }

    public void addPermission(Permission permission) {
      if(!permissions.contains(permission)) {
        permissions.add(permission);
        new Activity("Role["+this.name+"]: a permissão " + permission + " foi adicionada a role.");
      } else {
        new Activity("Role["+this.name+"]: a permissão " + permission + " já pertence a role.");
      }
    }
  
    public boolean canCreate() {
      for(Permission permission : permissions) {
        if(permission == Permission.CREATE) return true;
      }
      return false;
    }

    public boolean canShow() {
      for(Permission permission : permissions) {
        if(permission == Permission.SHOW) return true;
      }
      return false;
    }
  
    public boolean canDelete() {
      for(Permission permission : permissions) {
        if(permission == Permission.DELETE) return true;
      }
      return false;
    }
  
    public boolean canEdit() {
      for(Permission permission : permissions) {
        if(permission == Permission.EDIT) return true;
      }
      return false;
    }
    
}
