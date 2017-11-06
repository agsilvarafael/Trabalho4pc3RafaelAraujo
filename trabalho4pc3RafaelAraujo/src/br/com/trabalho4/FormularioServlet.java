package br.com.trabalho4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class FormularioServlet extends HttpServlet{
	private static final long serialVersionUID = 3012971939359047256L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		String nome, matricula, sexo; 
		Integer idade;
		
		//Coletando as informa��es do cliente
		nome = req.getParameter("nome");
		matricula = req.getParameter("matr�cula");
		sexo = req.getParameter("sexo");
		idade = Integer.parseInt(req.getParameter("idade"));
		
		// Retornando para a tela do cliente a resposta
		out.println("<HTML><HEAD><TITLE>Resposta");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>Resposta:</H1>");
		out.println("<p>Nome: "+nome);
		out.println("<br>Matr�cula: "+matricula);
		out.println("<br>Idade: "+idade);
		out.println("<br>Sexo: "+sexo +"</p>");
		if(sexo.equals("feminino"))
			out.println("<p>Voc� n�o precisa servir ao ex�rcito!</p>");
		else if(idade >= 18)
			out.println("<p>Voc� precisa servir ao ex�rcito!</p>");
		else 
			out.println("<p>Voc� est� ok com as obriga��es militares!</p>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
