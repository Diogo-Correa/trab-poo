package util;

public class ComboBoxItem {
        private int id;
        private String descricao;

        public ComboBoxItem(int id, String descricao)
        {
            this.id = id;
            this.descricao = descricao;
        }

        public int getId()
        {
            return id;
        }

        public String getDescricao()
        {
            return descricao;
        }

        public String toString()
        {
            return descricao;
        }
}
