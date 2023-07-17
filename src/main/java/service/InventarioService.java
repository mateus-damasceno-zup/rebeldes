package service;

import model.Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class InventarioService {

    private Statement statement;

    public InventarioService(){
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaTodosInventarios(){
        String sql = "SELECT * from inventario";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_inventario") +
                        ", rebelde id: " + resultSet.getString("rebelde_id") +
                        ", item id: " + resultSet.getString("item_id")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from inventario";
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
    public void inseriInventario(Long idInventario, Long  idRebelde, Long idItem){

        String sql = "INSERT INTO inventario (id_inventario, rebelde_id, item_id) VALUES ('"+idInventario+"', '"+idRebelde+"', '"+idItem+"');";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaCampoInventario(Long idInventario, String campo, String dado){

        String sql = "UPDATE inventario set "+ consultaColunaEspecifica(campo) + " = '" + dado + "' where id_inventario = '" + idInventario +"'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaTodoInventario(Long idInventario, Long rebeldeId,Long itemId){

        String sql = "UPDATE inventario set id_inventario, rebelde_id, genero_rebelde, traidor_rebelde,base_id," +
                "inventario_id ='" + idInventario + "','"+rebeldeId+"','"+itemId+"where id_invetario = '" + idInventario + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDadosNoInventario(Long id){
        String sql = "DELETE from inventario where id_invetario = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
