package Model;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JPAUtilis;
import entidades.consulta;
import entidades.medico;
import entidades.paciente;

/**
 * Servlet implementation class Exclusao
 */
@WebServlet("/Exclusao")
public class Exclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exclusao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static boolean excluirPaciente(int id){
		
		//criar conexao
		 EntityManager conexao=JPAUtilis.criarManager();
		 
		 paciente pac = conexao.find(paciente.class, id);
		 try{
		 conexao.getTransaction().begin();
		 conexao.remove(pac);
		 conexao.getTransaction().commit();
		 } catch(Exception e){
		 return false;
		 }finally{
		 conexao.close();
		 }
		return true;
		 
		
	}

public static boolean excluirMedico(int id){
		
		//criar conexao
		 EntityManager conexao=JPAUtilis.criarManager();
		 
		 medico med = conexao.find(medico.class, id);
		 try{
		 conexao.getTransaction().begin();
		 conexao.remove(med);
		 conexao.getTransaction().commit();
		 } catch(Exception e){
		 return false;
		 }finally{
		 conexao.close();
		 }
		return true;
		 
		
	}

public static boolean excluirConsulta(int id){
	
	//criar conexao
	 EntityManager conexao=JPAUtilis.criarManager();
	 
	 consulta con = conexao.find(consulta.class, id);
	 try{
	 conexao.getTransaction().begin();
	 conexao.remove(con);
	 conexao.getTransaction().commit();
	 } catch(Exception e){
	 return false;
	 }finally{
	 conexao.close();
	 }
	return true;
	 
	
}

	
}
