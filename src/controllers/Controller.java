package controllers;

public interface Controller {
    public void index();
    public void create();
    public <O> void store(O obj);
    public void update(int id);
    public void delete(int id);
}
