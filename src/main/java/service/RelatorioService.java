package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Conexao.getConnection;

public class RelatorioService {

    private Statement statement;

    public RelatorioService(){
        try{
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaTodosRelatorios(){
        String sql = "SELECT * from relatorioTraidores";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_relatorio") +
                        ", relator id: " + resultSet.getString("rebelde_id_relator") +
                        ", relatado id: " + resultSet.getString("rebelde_id_relatado")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from relatorioTraidores";
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
    public void inseriRelatorio(Long  idRebeldeRelator, Long idRebeldeRelatado){

        String sql = "INSERT INTO relatorioTraidores (rebelde_id_relator, rebelde_id_relatado) VALUES ('"+idRebeldeRelator+"', '"+idRebeldeRelatado+"');";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaCampoRelatorio(Long idRelatorio, String campo, String dado){

        String sql = "UPDATE relatorioTraidores set "+ consultaColunaEspecifica(campo) + " = '" + dado + "' where id_relatorio = '" + idRelatorio +"'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizaTodoRelatorio(Long idRelatorio, Long rebeldeIdRelator,Long rebeldeIdRelatado){

        String sql = "UPDATE relatorioTraidores set id_relatorio, rebelde_id_relator, rebelde_id_relatado ='"
                + idRelatorio + "','"+rebeldeIdRelator+"','"+rebeldeIdRelatado+"where id_relatorio = '" + idRelatorio + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDadosRelatorio(Long id){
        String sql = "DELETE from relatorioTraidores where id_relatorio = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
