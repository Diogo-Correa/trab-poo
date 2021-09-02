package views.atendimento;

import util.auth.Auth;

public class Index {

    public Index() {
        if(Auth.getRole().canShow()) run();
        else { 
            System.out.println("Voce nao tem permissao");
        }
    }

    public static void run() {
        System.out.println("Estagiario index.");
    }
}
