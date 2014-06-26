package Model;

import javax.persistence.EntityManager;

import util.JPAUtilis;
import entidades.consulta;
import entidades.medico;
import entidades.paciente;

public class Exclui {

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
