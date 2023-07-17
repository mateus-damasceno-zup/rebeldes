package service;

import model.Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class RebeldeService {

    private Statement statement;

    public RebeldeService(){
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //métodos de consulta
    public void consultaTodosRebeldes(){
        String sql = "SELECT * from rebeldes";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_rebelde") +
                                    ", nome: " + resultSet.getString("nome_rebelde") +
                                    ", idade: " + resultSet.getString("idade_rebelde") +
                                    ", genero: "+ resultSet.getString("genero_rebelde") +
                                    ", traidor: "+ resultSet.getString("traidor_rebelde") +
                                    ", base: " +resultSet.getString("base_id") +
                                    ", inventario: " + resultSet.getString("inventario_id")
                                    );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from rebeldes";
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
    public String consultaColunaEspecificaInventario(String column){
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
    //método para inserir dados
    public void inseriRebelde(String nome, int idade, String genero, boolean traidor, Long baseId, Inventario inventario){
        String id=consultaColunaEspecificaInventario("id_inventario");
        String sql = "INSERT INTO rebeldes (nome_rebelde, idade_rebelde, genero_rebelde, traidor_rebelde, base_id, inventario_id) VALUES ('"+nome+"', '"+idade+"', '"+genero+"', "+traidor+", '"+baseId+"', '"+id+"');";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaCampoRebelde(Long id, String campo, String dado){

        String sql = "UPDATE rebeldes set "+ consultaColunaEspecifica(campo) + " = '" + dado + "' where id_rebelde = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaTodoRebelde(Long id, String nome,int idade,String genero,boolean traidor,
                                    Long baseId, Inventario inventario){

        String sql = "UPDATE rebeldes set nome_rebelde, idade_rebelde, genero_rebelde, traidor_rebelde,base_id," +
                "inventario_id ='" + nome + "','"+idade+"','"+genero+"','"+traidor+"','"+baseId+"','"+inventario.getId()+"'" +
                "where id_rebelde = '" + id + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDadosNaTabela(Long id){
        String sql = "DELETE from rebeldes where id_rebelde = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
