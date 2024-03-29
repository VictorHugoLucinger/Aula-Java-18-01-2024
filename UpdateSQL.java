//importação de todos os itens da biblioteca java.sql
import java.sql.*;
//importação de todos os items da biblioteca java.sql
import java.util.*;
//declaração da classe/objeto UpdateSQL
public class UpdateSQL {
    /**
     * declaração do metodo executor main
     * public: porque poderá ser importado por outro objeto/classe
     * static: porque o método não poderá ser alterado ou sobrescrito
     * void porque é um método sem retorno
     * @param String[] porque poderão ser invocados métodos do tipo String e matrises
     * @param args porque poderia ser invocado o objeto da biblioteca java.sql
     */
    public static void main(String[] args) {
        //declarando variavel como "boolean" "sair" e "sair2" ambas atribuidas como "false"
        boolean sair = false, sair2 = false;
        //declarando variavel como String e matrix, tento a variavel "menu" com duas informações dentro
        String[] menu = {"Alterar perfil","Sair do programa"};
        //invocando a ação Scanner na variavel "confLogin" com uma nova instancia
        Scanner confLogin = new Scanner(System.in);
        //invocando a ação Scanner na variavel "confSenha" com uma nova instancia
        Scanner confSenha = new Scanner(System.in);
        //invocando a ação Scanner na variavel "resp" com uma nova instancia
        Scanner resp = new Scanner(System.in);

        //invocando a ação "while", utilizando o teste lógico da variavel "sair"
        while (sair == false) {
                //invocando classe System invocando o metodo println
                System.out.println("\n\rDigite seu login: ");
                //atribuindo uma variavel tipo String com o nome "strLogin" e recebendo o valor da variavel "confLogin"
                String strLogin = confLogin.nextLine();
                //invocando classe System invocando o metodo println
                System.out.println("Digite sua senha: ");
                //atribuindo uma variavel tipo String com o nome "strSenha" e recebendo o valor da variavel "confSenha"
                String strSenha = confSenha.nextLine();

                //invocando a ação "for" com o teste lógico "i"
                for (int i = 0; i <= 1; i++) {
                    //invocando classe System invocando o metodo println
                    System.out.println(i+1 + " - [" + menu[i] + "].");
                //fechamento da ação "for"
                }

                //atribuindo uma variavel tipo String com o nome "sairPrograma" e recebendo o valor da variavel "resp"
                String sairPrograma = resp.nextLine();
                //invocando a ação "if" com o teste lógico com a variavel "sairPrograma"
                if (sairPrograma.equals("1")) {
                    //invocando a ação "while", utilizando o teste lógico da variavel "sair2"
                    while (sair2 == false) {
                        //objeto "connection" na variavel "conn", recebendo do objeto "App" com o método "conectar()"
                        Connection conn = App.conectar();
                        //classe String recebendo a variavel "menu2", como matrix
                        String[] menu2 = {"Alterar nome","Alterar senha","sair"};
                        //classe String recebendo a variavel "input"
                        String input;
                        //classe String recebendo a variavel "status"
                        String status = "Nada aconteceu ainda...";
                    //invocando a ação "try"
                    try {
                        
                            //classe String recbendo a variavel "strSqlSelect" recebendo um comando para procurar no banco de dados
                            String strSqlSelect = "select * from `mysql_connector`.`tbl_login` where `login` = '" + strLogin + "' and `senha` = '" + strSenha + "';";
                            //objeto Statement com a variavel "stmSql" adquirindo o valor da conexão da variavel "conn"
                            Statement stmSql = conn.createStatement();
                            //objeto ResultSet com a variavel "rsSql" adquirindo o valor da variavel "stmSql" da declaração executora do banco de dados
                            ResultSet rsSql = stmSql.executeQuery(strSqlSelect);
        
                            //invocando classe System invocando o metodo println
                            System.out.println("\n\r");
        
                            //classe String recbendo a variavel "login"
                            String login = "";
                            //classe String recbendo a variavel "senha"
                            String senha = "";
                            //invocando a ação "while" com o teste lógico da variavel "rsSql" criando um loop
                            while (rsSql.next()) {
                                //variavel "login" está procurando no banco de dados a informação digitada
                                login = "[" + rsSql.getString("login") + "] ";
                                //variavel "senha" está procurando no banco de dados a informação digitada
                                senha = "[" + rsSql.getString("senha") + "] ";
                            //fechamento da ação while
                            }
                            // ação "if" com operação lógica "login" ou "senha", se elas não receberam nenhumma atribuição esta operação será realizada
                            if (login.equals("") || senha.equals("")) {
                                //variavel "status" de tipo String
                                status = "\nLogin Invalido! Tente Novamente.";
                                //classe System invocando o metodo println a variavel "status"
                                System.out.println(status);
                            //fechamento da ação "if", ação "else"
                            } else {
                            //classe System invocano o metodo println para imprimir o texto digitado
                            System.out.println("Digite um dos números abaixo:");
                            //ação "for" com operação logica i, criando um ciclo de repetição que dura até 3 vezes
                            for (int i = 0; i <= 2; i++) {
                                //classe System invocando o metodo println criando o menu do usuario
                                System.out.println(i+1 + " - [" + menu2[i] + "].");
                            //fechamento da ação "for"
                            }
                            //variavel "input" recebendo o valor digitado em "resp"
                            input = resp.nextLine();
                            //ação "switch" com operação lógica "input"
                            switch (input) {
                                //ação "case" que será acionada caso o user digite "1"
                                case "1":
                                    //classe System invocano o metodo println para imprimir o texto digitado
                                    System.out.println("\n\rDigite o nome: ");
                                    //variavel "input" recebendo o que for digitado em "resp"
                                    input = resp.nextLine();
                                    //conexão com o banco de dados
                                    String update = "UPDATE `mysql_connector`.`tbl_login` SET `nome` = '" + input + "' WHERE (`login` = '" + strLogin + "');";
                                    //faz a atualização no banco de dados com o que foi digitado no "resp"
                                    PreparedStatement preparedStm1 = conn.prepareStatement(update);
                                    //executa a operação de atualização
                                    preparedStm1.executeUpdate();
                                    //para a ação "case"
                                    break;
                                //ação "case" que será acionada caso o user digite "2"
                                case "2":
                                    //classe System invocano o metodo println para imprimir o texto digitado
                                    System.out.println("\n\rDigite a senha: ");
                                    //variavel "input" recebendo o que for digitado em "resp"
                                    input = resp.nextLine();
                                    //conexão com o banco de dados
                                    update = "UPDATE `mysql_connector`.`tbl_login` SET `senha` = '" + input + "' WHERE (`login` = '" + strLogin + "');";
                                    //faz a atualização no banco de dados com o que foi digitado no "resp"
                                    PreparedStatement preparedStm2 = conn.prepareStatement(update);
                                    //executa a operação de atualização
                                    preparedStm2.executeUpdate();
                                    //para a ação "case"
                                    break;
                                //ação "case" que será acionada caso o user digite "3"
                                case "3":
                                    //variavel "sair2" se torna true para sair do laço de repetição
                                    sair2 = true;
                                    //para a ação "case"
                                    break;
                                //ação "case" que será acionada caso o user digite algo que não tenha sido válido nas opções de resposta
                                default:
                                //classe System invocano o metodo println para imprimir o texto digitado
                                System.out.println("Opção inválida.");
                                    //para a ação "case"
                                    break;
                            //fechamento da ação "switch"
                            }
                            //fechamento da ação "else"
                            }
                        //fechamento da ação "try", ação "catch" com operação lógica "Exeption" atribuida na variavel "e" que captura erros durante a execução do programa e informa ao user
                        } catch (Exception e) {
                            //classe System invocano o metodo println para imprimir o texto digitado de erro
                            System.out.println("Pane no sistema! erro " + e + ".");
                        //fechamento da ação "catch"
                        }
                //fechamento da ação "while"
                }
                //fechamento da ação "if", ação "else" caso o user deseja sair do programa no inicio de sua execução
                } else {
                    //variavel "sair" é atribuida como true
                    sair = true;
                //fechamento da ação "else"
                }
        //fechamento da ação "while"
        }
        //fechamento do Scanner "confLogin"
        confLogin.close();
        //fechamento do Scanner "confSenha"
        confSenha.close();
        //fechamento do Scanner "resp"
        resp.close();
    //fechamento do método
    }
//fechamento do objeto
}
