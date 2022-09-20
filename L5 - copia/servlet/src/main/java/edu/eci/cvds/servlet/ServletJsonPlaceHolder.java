package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;


@WebServlet(
		 urlPatterns = "/todos"
		)

public class ServletJsonPlaceHolder extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Writer responseWriter = resp.getWriter();
        String message = "";
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.parseInt(optId.get()));
            resp.setStatus(HttpServletResponse.SC_OK);
            ArrayList<Todo> todoSet = new ArrayList<>();
            todoSet.add(todo);
            message = Service.todosToHTMLTable(todoSet);
        }
        catch (MalformedURLException ex){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLError(resp.getStatus(), "error interno en el servidor");
        }
        catch (NumberFormatException ex){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"requerimiento invalido");
        }
        catch (IOException ex){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(),"no existe un item con el identificador");
        }
        catch (Exception ex){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(),"Error inseperado");
        }

		responseWriter.write(message);
	 }	


	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "";
		Writer responseWriter = resp.getWriter();
		try{
			Todo todo = Service.getTodoFromBuffered(req.getReader());
			Todo rtaTodo = Service.postTodo(todo);
			if(rtaTodo == null) throw new Exception("El servidor no permitió este post.");
			resp.setStatus(HttpServletResponse.SC_CREATED);
			ArrayList<Todo> todoSet = new ArrayList<>();
			todoSet.add(rtaTodo);
			message = Service.todosToHTMLTable(todoSet);
		}
		catch (MalformedURLException ex){
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			message = Service.getHTMLError(resp.getStatus(), "error interno en el servidor");
		}
		catch (NumberFormatException ex){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = Service.getHTMLError(resp.getStatus(),"requerimiento invalido");
		}
		catch (IOException ex){
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			message = Service.getHTMLError(resp.getStatus(),"no existe un item con el identificador");
		}
		catch (Exception ex){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = Service.getHTMLError(resp.getStatus(),"Error inseperado." + ex.getMessage());
		}
		
		responseWriter.write(message);
	 }
}

