package br.edu.imed;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuariosPermitidos = new ArrayList<Usuario>();
    public Boolean permitido;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario user1 = new Usuario("admin", "admin");
        Usuario user2 = new Usuario("adm", "adm");
        Usuario user3 = new Usuario("teste1", "teste");
        Usuario user4 = new Usuario("teste2", "teste");

        this.usuariosPermitidos.add(user1);
        this.usuariosPermitidos.add(user2);
        this.usuariosPermitidos.add(user3);
        this.usuariosPermitidos.add(user4);

        String u = request.getParameter("username");
        String s = request.getParameter("password");

        Usuario u2 = new Usuario(u, s);

        for (Usuario i : usuariosPermitidos) {
            if (usuariosPermitidos.contains(u2)) {
                this.permitido = true;
            } 
            else {
                this.permitido = false;
        }
      }
        if (this.permitido == true) {
            response.sendRedirect("loading.html");
        }
        else {
            response.sendRedirect("acesso-negado.html");
        }
}
}
