package controller;

public interface Controller {
    public void index();
    public void create();
    public <O> void store(O object);
    public <O> void update(O object);
    public <O> void delete(O object);
}
