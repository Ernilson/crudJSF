package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ModuloConexao.Conection;
import br.com.Model.CadastroModel;

public class CadastroDAO {
		
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean incluir(CadastroModel cm) {
        conn = Conection.conectaMysql();
        
        try {
            String sql = "insert into tabcadastro(nome,endereco,telefone,email)values(?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, cm.getNome());
            pst.setString(2, cm.getEndereco());
            pst.setString(3, cm.getTelefone());
            pst.setString(4, cm.getEmail());

            pst.execute();
           // pst.close();
            //Conection.conectaMysql().close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean atualizar(CadastroModel cm) {
    	conn = Conection.conectaMysql();
        try {
            String sql = "update tabcadastro set nome=?, endereco=?, telefone=?, email=? where id_c =?";
            pst = conn.prepareStatement(sql);            
            pst.setString(1, cm.getNome());
            pst.setString(2, cm.getEndereco());
            pst.setString(3, cm.getTelefone());
            pst.setString(4, cm.getEmail());
            pst.setInt(5, cm.getId());           

            pst.executeUpdate();
            pst.close();
            Conection.conectaMysql().close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CadastroModel buscar(int id) {
    	conn = Conection.conectaMysql();
        ResultSet rs;
        if (id == 0) {
            return new CadastroModel();
        }
        try {
            String sql = ("select * from tabcadastro where id_c =" + id);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            CadastroModel cm = new CadastroModel();
            cm.setId(rs.getInt("id_c"));
            cm.setNome(rs.getString("NOME"));
            cm.setEndereco(rs.getString("ENDERECO"));
            cm.setTelefone(rs.getString("TELEFONE"));
            cm.setEmail(rs.getString("Email"));
           
            pst.close();
           Conection.conectaMysql().close();
            return cm;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //Remomver
    public boolean apagar(CadastroModel cont) {
    	conn = Conection.conectaMysql();
        try {
            String sql = "delete from tabcadastro where id_c = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, (int) cont.getId());
            pst.execute();
            pst.close();
            Conection.conectaMysql().close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<CadastroModel> listar() throws Exception {
    	conn = Conection.conectaMysql();
        try {
            String sql = "select * from tabcadastro";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<CadastroModel> lista = new ArrayList<CadastroModel>();
            while (rs.next()) {
            	CadastroModel cm = new CadastroModel();
            	cm.setId(rs.getInt("id"));
                cm.setNome(rs.getString("NOME"));
                cm.setEndereco(rs.getString("ENDERECO"));
                cm.setTelefone(rs.getString("TELEFONE"));
                cm.setEmail(rs.getString("Email"));  
                lista.add(cm);
            }
            return lista;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    // '%"+nome+"%'
    public List<CadastroModel> pesquisaPorNome(String nome) throws SQLException {
        conn = Conection.conectaMysql();
        try {
            String sql = ("select * from tabcadastro where nome like " + nome);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<CadastroModel> lsCad = new ArrayList<>();
            while (rs.next()) {
            	CadastroModel cm = new CadastroModel();
            	cm.setId(rs.getInt("id"));
                cm.setNome(rs.getString("NOME"));
                cm.setEndereco(rs.getString("ENDERECO"));
                cm.setTelefone(rs.getString("TELEFONE"));
                cm.setEmail(rs.getString("Email"));
            
                lsCad.add(cm);

                lsCad.add(cm);
            }
            return lsCad;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
