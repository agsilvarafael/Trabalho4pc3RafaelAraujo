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
		
		//Coletando as informações do cliente
		nome = req.getParameter("nome");
		matricula = req.getParameter("matrícula");
		sexo = req.getParameter("sexo");
		idade = Integer.parseInt(req.getParameter("idade"));
		
		// Retornando para a tela do cliente a resposta
		out.println("<HTML><HEAD><TITLE>Resposta");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>Resposta:</H1>");
		out.println("<p>Nome: "+nome);
		out.println("<br>Matrícula: "+matricula);
		out.println("<br>Idade: "+idade);
		out.println("<br>Sexo: "+sexo +"</p>");
		if(sexo.equals("feminino"))
			out.println("<p>Você não precisa servir ao exército!</p>");
		else if(idade >= 18)
			out.println("<p>Você precisa servir ao exército!</p>");
		else 
			out.println("<p>Você está ok com as obrigações militares!</p>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
