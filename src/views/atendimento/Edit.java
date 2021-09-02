package views.atendimento;

import util.auth.Auth;

public class Edit {
    public Edit() {
        if(!Auth.getRole().canEdit()) {
            System.out.println("Voce nao tem permissao!");
        } else run();
    }

    public static void run() {
        System.out.println("Estagiario edit.");
    }
}
