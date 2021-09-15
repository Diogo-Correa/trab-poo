package controllers;

public interface Controller {
    
    /**
     * Metodo para redirecionar para a view index
     */
    public void index();

    /**
     * Metodo para redirecionar para a view show
     */
    public void show(int id);

    /**
     * Metodo para redirecionar para a view create
     */
    public void create();

    /**
     * Metodo para salvar os dados no ArrayList
     * @param obj Objeto referente ao Model
     */
    public <O> void store(O obj);

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Objeto que queira encontrar
     */
    public void edit(int id);

    /**
     * Metodo para atualizar os dados do banco de dados
     */
    public void update();

    /**
     * Metodo de exclusao de dados do ArrayList
     * @param id Id referente ao Objeto que queira encontrar
     */
    public void delete(int id);
}
