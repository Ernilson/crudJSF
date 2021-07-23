package br.com.Teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.DAO.CadastroDAO;
import br.com.Model.CadastroModel;

public class testeClass {

	public static void main(String[] args) throws Exception {
		
		CadastroModel cm = new CadastroModel();
		CadastroDAO cdao = new CadastroDAO();
		
//		try {
//			cm.setId(1);
//			cm.setNome("teste1");
//			cm.setEndereco("Quadra 105 ");
//			cm.setFone("61991323236");
//			cm.setEmail("teste@teste.com");			
//			
//			cdao.apagar(cm);
//			System.out.println("Concluido");
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		 List<CadastroModel> lsficha = cdao.listar();        
       
		 for (int i = 0; i < lsficha.size(); i++) {
           System.out.println("ID: " + lsficha.get(i).getId() + "-Nome:" + lsficha.get(i).getNome()+ "-Nome:" + lsficha.get(i).getEndereco());
       }
           
      
	}
	}

