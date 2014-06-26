package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.JPAUtilis;
import entidades.consulta;
import entidades.medico;
import entidades.paciente;

/**
 * Servlet implementation class listar
 */
@WebServlet("/listar")
public class listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listar() {
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
		
		String nome = request.getParameter("nome");
		String opc = request.getParameter("opc");
		
		HttpSession sessao = request.getSession();
		
		if(sessao.getAttribute("usuario")!=null){
		
		switch(opc){
		
		case("listarmednome"):{
			listarMedNome(nome, request, response);
			break;
		}
		
		case("listarmedid"):{
			int id = Integer.parseInt(request.getParameter("id"));
			listarMedId(id, request, response);
			break;
		}
		
		case("listarpacnome"):{
			listarPacNome(nome, request, response);
			break;
		}
		case("listarpac"):{
			listarPac(request, response);
			break;
		}
		
		case("listarpacid"):{
			int id = Integer.parseInt(request.getParameter("id"));
			listarPacId(id, request, response);
			break;
		}
		
		case("listarmed"):{
			listarMed(request, response);
			break;
		}
		case("listarcon"):{
			listarCon(request, response);
			break;
		}
		case("listarconpacnome"):{
			listarConPacNome(nome, request, response);
			break;
		}
		case("listarconmednome"):{
			listarConMedNome(nome, request, response);
			break;
		}
		
		case("listarconid"):{
			int id = Integer.parseInt(request.getParameter("id"));
			listarConId(id, request, response);
			break;
		}
		
		}
		
		}else{
			response.sendRedirect("logindb");
		}
	
		
	}
	
	protected void listarMedNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List<medico> medicos = Model.Listar.listarMedNome(nome, request, response);
		
		request.setAttribute("medlista", medicos);
		request.getRequestDispatcher("/WEB-INF/listarMedico.jsp").forward(request, response);
		
	}
	
	protected void listarMedId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		List<medico> medicos = Model.Listar.listarMedId(id, request, response);
		
		if(medicos.isEmpty()){
			String erro = "Id Inexistente!!!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("/WEB-INF/erros.jsp").forward(request, response);
		}else{
		request.setAttribute("medlista", medicos);
		request.getRequestDispatcher("/WEB-INF/atualizaMed.jsp").forward(request, response);
		}
	}	
	
protected void listarPacNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			
		List<paciente> pacientes = Model.Listar.listarPacNome(nome, request, response);
	
		request.setAttribute("paclista", pacientes);
		request.getRequestDispatcher("/WEB-INF/listarPaciente.jsp").forward(request, response);
		
	}

protected void listarPacId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	
	List<paciente> pacientes = Model.Listar.listarPacId(id, request, response);
	
	if(pacientes.isEmpty()){
		String erro = "Id Inexistente!!!";
		request.setAttribute("erro", erro);
		request.getRequestDispatcher("/WEB-INF/erros.jsp").forward(request, response);
	}else{
	
	request.setAttribute("paclista", pacientes);
	request.getRequestDispatcher("/WEB-INF/atualizaPac.jsp").forward(request, response);
	}
}


protected void listarPac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	List<paciente> pacientes = Model.Listar.listarPac(request, response);
	
	request.setAttribute("paclista", pacientes);
	request.getRequestDispatcher("/WEB-INF/listarPaciente.jsp").forward(request, response);
	
}

protected void listarMed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	List<medico> medicos = Model.Listar.listarMed(request, response);
	
	request.setAttribute("medlista", medicos);
	request.getRequestDispatcher("/WEB-INF/listarMedico.jsp").forward(request, response);
	
}

protected void listarCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	List<consulta> consultas = Model.Listar.listarCon(request, response);
	
	request.setAttribute("conlista", consultas);
	request.getRequestDispatcher("/WEB-INF/listarConsulta.jsp").forward(request, response);
	
}

protected void listarConPacNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	List<consulta> consultas = Model.Listar.listarConPacNome(nome, request, response);
	
	request.setAttribute("conlista", consultas);
	request.getRequestDispatcher("/WEB-INF/listarConsulta.jsp").forward(request, response);
	
}

protected void listarConMedNome(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	List<consulta> consultas = Model.Listar.listarConMedNome(nome, request, response);
	
	request.setAttribute("conlista", consultas);
	request.getRequestDispatcher("/WEB-INF/listarConsulta.jsp").forward(request, response);
	
}

protected void listarConId(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	
	List<consulta> consultas = Model.Listar.listarConId(id, request, response);
	for(consulta con: consultas){
		con.setDtcons(converterdatas.DateToData(con.getDtcons()));
	}
	
	
	List<medico> medicos = Model.Listar.listarMed(request, response);
	
	List<paciente> pacientes = Model.Listar.listarPac(request, response);

	if(consultas.isEmpty()){
		String erro = "Id Inexistente!!!";
		request.setAttribute("erro", erro);
		request.getRequestDispatcher("/WEB-INF/erros.jsp").forward(request, response);
	}else{
	
	request.setAttribute("conlista", consultas);
	request.setAttribute("medlista", medicos);
	request.setAttribute("paclista", pacientes);
	request.getRequestDispatcher("/WEB-INF/atualizaCon.jsp").forward(request, response);
	
}
}

}
