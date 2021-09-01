package views.estagiario;

import util.auth.Auth;

public class Index {

    public Index() {
        if(Auth.getUser().getRole().canShow()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            System.exit(0); 
        }
    }

    public static void run() {
        System.out.println("Estagiario index.");
    }
}
