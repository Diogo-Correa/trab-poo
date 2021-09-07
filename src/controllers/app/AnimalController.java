package controllers.app;

import controllers.Controller;
import util.database.Animais;
import views.animal.Show;

public class AnimalController implements Controller {

    public void index() {
        //
    }

    public void show(int id) {
        new Show(Animais.find(id));
    }

    public void create() {
        //
    }

    public <O> void store(O obj) {
        //
    }

    public void update(int id) {
        //
    }

    public void delete(int id) {
        //
    }
    
}
