package Model;

import javax.persistence.EntityManager;

import util.JPAUtilis;
import entidades.Login;
import entidades.consulta;
import entidades.medico;
import entidades.paciente;

public class Cadastra {

	public static boolean Inserir(medico med) {
		EntityManager conexao=JPAUtilis.criarManager();
		 try{
		 conexao.getTransaction().begin();
		 conexao.persist(med);
		 conexao.getTransaction().commit();
		 }catch(Exception e){
			 return false;
		 }finally{
			 conexao.close();
		 }
		 
		return(true); 
		}
	
	public static boolean Inserir(paciente pac) {
		EntityManager conexao=JPAUtilis.criarManager();
		 try{
		 conexao.getTransaction().begin();
		 conexao.persist(pac);
		 conexao.getTransaction().commit();
		 }catch(Exception e){
			 return false;
		 }finally{
			 conexao.close();
		 }
		 
		 
		return(true); 
		}

	public static boolean InserirCon(consulta con, paciente pac, medico med) {
		EntityManager conexao=JPAUtilis.criarManager();
		
		try{
		conexao.getTransaction().begin();
		med.setCons(con);
		pac.setCons(con);
		conexao.persist(con);
		conexao.getTransaction().commit();
		}catch(Exception e){
			return false;
		}finally{
			conexao.close();
		}
		return(true); 
		}
	
	public static boolean InserirUsu(Login log) {
		
		EntityManager conexao=JPAUtilis.criarManager();
		
		try{
		conexao.getTransaction().begin();
		conexao.persist(log);
		conexao.getTransaction().commit();
		}catch(Exception e){
			return false;
		}finally{
			conexao.close();
		}
		return(true); 
		}
	
}
