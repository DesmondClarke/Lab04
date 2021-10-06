package servlets;

import java.io.BufferedReader;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //read the txt file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //to read file
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = "";
        String content = "";
        
        //read first line
        title = br.readLine();
        content = br.readLine();
        
        request.setAttribute("Title", title);
        
        System.out.print(title);
        
        // load up a JSP
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //to write to the file
       // PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
    }


}
