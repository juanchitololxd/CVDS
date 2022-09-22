package edu.eci.cvds.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import com.google.gson.Gson;
import edu.eci.cvds.servlet.model.Todo;
public class Service {
 public static Todo getTodo(int id) throws MalformedURLException, IOException {
    URL urldemo = new URL("https://jsonplaceholder.typicode.com/todos/" + id);
    URLConnection yc = urldemo.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    Todo todo = Service.getTodoFromBuffered(in);    
    in.close();
    return todo;
 }

 public static Todo getTodoFromBuffered(BufferedReader in){
    Gson gson = new Gson();
    Todo todo = gson.fromJson(in, Todo.class);
    return todo;
 }

 public static Todo postTodo(Todo todo) throws IOException{
    String url = "https://jsonplaceholder.typicode.com/posts";  
    Todo oTodo = null;
    URL urlObj = new URL(url);  
    HttpURLConnection postCon = (HttpURLConnection) urlObj.openConnection();  
    postCon.setRequestMethod("POST");    
    postCon.setRequestProperty("Content-Type", "application/json");  
    postCon.setDoOutput(true);  

    String messageContent = todo.get();
    OutputStream osObj = postCon.getOutputStream();  
    osObj.write(messageContent.getBytes());  
    osObj.flush();  
    osObj.close();  
    if (postCon.getResponseCode() == HttpURLConnection.HTTP_CREATED)   
    {   
        InputStreamReader irObj = new InputStreamReader(postCon.getInputStream());   
        BufferedReader br = new BufferedReader(irObj);  
        oTodo = Service.getTodoFromBuffered(br);
        br.close();  
    } 
    postCon.disconnect();  
    return oTodo;
}  
 private static String todoToHTMLRow(Todo todo) {
 return new StringBuilder("<tr>")
 .append("<td>")
 .append(todo.getUserId())
 .append("</td><td>")
 .append(todo.getId())
 .append("</td><td>")
 .append(todo.getTitle())
 .append("</td><td>")
 .append(todo.getCompleted())
 .append("</td>")
 .append("</tr>")
 .toString();
 }
 public static String todosToHTMLTable(List<Todo> todoList) {
 StringBuilder stringBuilder = new StringBuilder("<table>")
 .append("<tr>")
 .append("<th>User Id</th>")
 .append("<th>Id</th>")
 .append("<th>Title</th>")
 .append("<th>Completed</th>")
 .append("</tr>");
 for (Todo todo : todoList) {
 stringBuilder.append(todoToHTMLRow(todo));
 }
 return stringBuilder.append("</table>").toString();
 }

 public static String getHTMLError(int errorNumber, String message){
    String error = "<html><head>ERROR "+message+" ERROR</head></html>";
    return error;
}
}