package br.com.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.CadastroDAO;
import br.com.Model.CadastroModel;

@ManagedBean
@RequestScoped
public class CadastroController implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private CadastroModel cm = new CadastroModel();
	private List<CadastroModel>lsCm = new ArrayList<>();
	
	public CadastroController() {
		// TODO Auto-generated constructor stub
	}
		
	public CadastroController(CadastroModel cm, List<CadastroModel> lsCm) {
		super();
		this.cm = cm;
		this.lsCm = lsCm;
	}

	//Metodo para adicionar
	public String salvaCadastro() {
		try {
			CadastroDAO cdao = new CadastroDAO();
			cdao.incluir(cm);
			limpaCampos();
		} catch (Exception e) {
			System.out.println(e);
		}		
		return "sorte.xhtml";
	}
	
	//Metodo para limpar campos
	private void limpaCampos() {
		cm.setNome("");
		cm.setEndereco("");
		cm.setTelefone("");
		cm.setEmail("");
	}
	
	public CadastroModel getCm() {
		return cm;
	}
	public void setCm(CadastroModel cm) {
		this.cm = cm;
	}
	
	public List<CadastroModel> getLsCm() throws Exception {
		CadastroDAO cdao = new CadastroDAO();
        lsCm = new ArrayList<>(cdao.listar());
		return lsCm;
	}
	public void setLsCm(List<CadastroModel> lsCm) {
		this.lsCm = lsCm;
	}
	
		

}
