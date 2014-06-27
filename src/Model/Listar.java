package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JPAUtilis;
import entidades.Login;
import entidades.consulta;
import entidades.medico;
import entidades.paciente;

public class Listar {

public static List listarMedNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		EntityManager conexao=JPAUtilis.criarManager();
		
		List <medico> medicos = new ArrayList<>();
		try{
		Query q1 = conexao.createQuery("select count(*) from medico p where p.nome LIKE:nomebusca");
		q1.setParameter("nomebusca", "%"+nome+"%");
		List<Integer> qconta = q1.getResultList();
		request.setAttribute("contador", qconta);
		
		Query query = conexao.createQuery("select p From medico p where p.nome LIKE:nomebusca order by p.nome");
		query.setParameter("nomebusca", "%"+nome+"%");
		medicos = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			conexao.close();
		}
	
		return medicos;
		 
		
	}
	
	public static List listarMedId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		EntityManager conexao=JPAUtilis.criarManager();
		
		List <medico> medicos = null;
		
		try{
		Query query = conexao.createQuery("select p From medico p where p.idmed=:idbusca");
		query.setParameter("idbusca", id);
		
		medicos = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			conexao.close();
		}
		
		return medicos;

		
	}


public static List listarPacNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		EntityManager conexao=JPAUtilis.criarManager();
		List<paciente> pacientes = null;
		
		try{
		Query q1 = conexao.createQuery("select count(*) from paciente p where p.nome LIKE:nomebusca");
		q1.setParameter("nomebusca", "%"+nome+"%");
		List<Integer> qconta = q1.getResultList();
		request.setAttribute("contador", qconta);
		
		Query query = conexao.createQuery("select p From paciente p where p.nome LIKE:nomebusca order by p.nome");
		query.setParameter("nomebusca", "%"+nome+"%");
		pacientes = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conexao.close();
		}
	
		return pacientes;
		 
		
	}

public static List listarPacId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<paciente> pacientes = null;
	
	try{
	Query query = conexao.createQuery("select p From paciente p where p.idpac=:idbusca");
	query.setParameter("idbusca", id);
	pacientes = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}

	return pacientes;
	
}


public static List listarPac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<paciente> pacientes = null;
	
	try{
	Query q1 = conexao.createQuery("select count(*) from paciente");
	List<Integer> qconta = q1.getResultList();
	request.setAttribute("contador", qconta);
	
	Query query = conexao.createQuery("select p From paciente p order by p.nome");
	pacientes = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}
	
	return pacientes;
	 
}

public static List listarMed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List <medico> medicos = null;
	
	try{
	Query q1 = conexao.createQuery("select count(*) from medico");
	List<Integer> qconta = q1.getResultList();
	request.setAttribute("contador", qconta);
	
	Query query = conexao.createQuery("select p From medico p order by p.nome");
	medicos = query.getResultList();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		conexao.close();
	}
	
	return medicos;
	 
}

public static List listarCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<consulta> consultas = null;
	
	try{
	Query q1 = conexao.createQuery("select count(*) from consulta");
	List<Integer> qconta = q1.getResultList();
	request.setAttribute("contador", qconta);
	
	Query query = conexao.createQuery("select c From consulta c order by c.id");
	consultas = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}
	
	return consultas;
	 
}

public static List listarConPacNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<consulta> consultas = null;
	
	try{
	Query q1 = conexao.createQuery("select count(*) from consulta c where c.pac.nome LIKE:nomebusca");
	q1.setParameter("nomebusca", "%"+nome+"%");
	List<Integer> qconta = q1.getResultList();
	request.setAttribute("contador", qconta);
	
	Query query = conexao.createQuery("select c From consulta c where c.pac.nome LIKE:nomebusca order by c.pac.nome");
	query.setParameter("nomebusca", "%"+nome+"%");
	consultas = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}
	
	return consultas;
	 
}

public static List listarConId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<consulta> consultas = null;
	
	try{
	Query query = conexao.createQuery("select c From consulta c where c.id=:idbusca");
	query.setParameter("idbusca", id);
	consultas = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}

	return consultas;
	 
	
}

public static List listarConMedNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<consulta> consultas = null;
	
	try{
	Query q1 = conexao.createQuery("select count(*) from consulta c where c.med.nome LIKE:nomebusca");
	q1.setParameter("nomebusca", "%"+nome+"%");
	List<Integer> qconta = q1.getResultList();
	request.setAttribute("contador", qconta);
	
	Query query = conexao.createQuery("select c From consulta c where c.med.nome LIKE:nomebusca order by c.med.nome");
	query.setParameter("nomebusca", "%"+nome+"%");
	consultas = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}
	
	return consultas;
	 
}

public static List listarUsu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	EntityManager conexao=JPAUtilis.criarManager();
	List<Login> usuarios = null;
		
	try{
	Query query = conexao.createQuery("select l From Login l order by l.id");
	usuarios = query.getResultList();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conexao.close();
	}
	return usuarios;
	 
}

	
}
