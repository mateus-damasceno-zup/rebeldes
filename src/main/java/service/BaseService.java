package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class BaseService {


    private Statement statement;

    public BaseService(){
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaTodasBases(){
        String sql = "SELECT * from base";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_base") +
                        ", nome base: " + resultSet.getString("nome_base") +
                        ", item id: " + resultSet.getString("itens_id") +
                        ", rebeldes id"+resultSet.getString("rebelde_id")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from base";
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

    public void inseriBase( String  nomeBase, Long itemId, Long rebeldeId){

        String sql = "INSERT INTO base (nome_base, rebelde_id, itens_id) VALUES ('"+nomeBase+"', '"+itemId+"', '"+rebeldeId+"');";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaCampoBase(Long idBase, String campo, String dado){

        String sql = "UPDATE base set "+ consultaColunaEspecifica(campo) + " = '" + dado + "' where id_base = '" + idBase +"'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaTodaBase(Long idBase, String nomeBase, Long rebeldeId,Long itemId){

        String sql = "UPDATE base set id_base, nome_base, rebelde_id, itens_id ='" + idBase + "','"+nomeBase+"','"+rebeldeId+"','"+itemId+ " where id_base = '" + idBase + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDadosNaBase(Long id){
        String sql = "DELETE from base where id_base = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
