package util;

public class ComboBoxItem {
        private int id;
        private String descricao;

        /**
         * 
         * @param id recebe o ID referente ao objeto
         * @param descricao recebe o valor de exibicao do objeto no ComboBox
         */
        public ComboBoxItem(int id, String descricao)
        {
            this.id = id;
            this.descricao = descricao;
        }

        /**
         * Metodo para obter o ID referente ao objeto do ComboBox
         * @return ComboBoxItem id
         */
        public int getId()
        {
            return this.id;
        }

        /**
         * Metodo para obter a descricao do objeto
         * @return
         */
        public String getDescricao()
        {
            return this.descricao;
        }

        /**
         * Metodo para exibir a descricao como valor a ser exibido no ComboBox
         * @return descricao display
         */
        public String toString()
        {
            return this.descricao;
        }
}
