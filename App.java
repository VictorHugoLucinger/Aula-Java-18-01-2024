//importação de todos os itens da biblioteca java.sql
import java.sql.*;
//declaração da classe/objeto App
public class App {
    /**
     * declaração do metodo executor main
     * public: porque poderá ser importado por outro objeto/classe
     * static: porque o método não poderá ser alterado ou sobrescrito
     * void porque é um método sem retorno
     * @param String[] porque poderão ser invocados métodos do tipo String e matrises
     * @param args porque poderia ser invocado o objeto da biblioteca java.sql
     */
    public static void main(String[] args) {
        //classe System invocano o metodo println para imprimir o texto digitado
        System.out.println("Conectando ao banco de dados...");
        //invocação do metodo "conectar()"
        conectar();
    //fechamento do metodo "main"
    }
    /**
     * declaração do metodo executor conectar()
     * public: porque poderá ser importado por outro objeto/classe
     * static: porque o método não poderá ser alterado ou sobrescrito
     * Connection: recebe retorno com o banco de dados SQL
     */
    public static Connection conectar() {
        //declarando variavel do tipo String, o texto digitado de status
        String status = "Nada aconteceu ainda...";
        //declarando variavel do tipo String, o texto digitado de ip
        String mysqhost = "127.0.0.1";
        //declarando variavel do tipo String, o texto digitado de "schemas" do MySQL
        String mysqDb = "mysql_connector";
        //declarando variavel do tipo String, o texto digitado de user do MySQL
        String mysqUser = "Victor";
        //declarando variavel do tipo String, o texto digitado
        String mysqPassword = "";
        //declarando variavel do tipo String, o texto digitado de url personalizada do banco de daods
        String mysqUrl = "jdbc:mysql://" + mysqhost + "/" + mysqDb + "?user=" + mysqUser + "&password=" + mysqPassword;
        //objeto "Connection"
        Connection conn = null;
        //invocando a ação "try"
        try {
            //é a ponto que liga com o MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //
            conn = DriverManager.getConnection(mysqUrl);
            status = "Conexão realizada com sucesso!";
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Opss! algo de errado não está certo com a conexão com o banco de daods MySQL! mensagem do servidor : " + e;
            
        }
        System.out.println(status);
        return conn;
    }
}
