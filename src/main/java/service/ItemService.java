package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class ItemService {

    private Statement statement;

    public ItemService(){
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaTodosItens(){
        String sql = "SELECT * from itens";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_item") +
                        ", nome: " + resultSet.getString("nome_item") +
                        ", valor: " + resultSet.getString("valor_item") +
                        ", base id: "+ resultSet.getString("base_id")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from itens";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return resultSet.getString(column);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sql;
    }

    public void inseriItem(String  nomeItem, Double valor,Long baseId){

        String sql = "INSERT INTO itens (nome_item, valor_item, base_id) " +
                "VALUES ('"+nomeItem+"', '"+valor+"', '"+baseId+"');";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void atualizaCampoItem(Long idItem, String campo, String dado){

        String sql = "UPDATE itens set "+ consultaColunaEspecifica(campo) + " = '" + dado + "' where id_item = '" + idItem +"'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaTodoItem(Long idItem, Long nomeItem,Double valor, Long baseId){

        String sql = "UPDATE item set id_item, nome_item, valor_item, base_id ='" + idItem + "','"+nomeItem+"','"+valor+"','"+baseId+"' where id_item = '" + idItem + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDadosItem(Long id){
        String sql = "DELETE from itens where id_item = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
