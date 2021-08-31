package util.middlewares.auth;

import java.util.*;

import util.database.Roles;
import util.log.Activity;

public class Role {
    private ArrayList<Permission> permissions = new ArrayList<Permission>();
    private String name;
  
    public Role(String name) {
      this.name = name;
      Roles.addRole(this);
    }
  
    public String getNome() { return this.name; }

    public void addPermission(Permission permission) {
      if(!permissions.contains(permission)) {
        permissions.add(permission);
        new Activity("Role["+this.name+"]: a permissão " + permission + " foi adicionada a role.");
      } else {
        new Activity("Role["+this.name+"]: a permissão " + permission + " já pertence a role.");
      }
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
