package servlets;

import java.io.BufferedReader;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String a = request.getQueryString();
        System.out.println("This is the query string: " + a);
        
        //read the txt file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //to read file
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        //read first line
        String title = br.readLine();
        String content = br.readLine();
        
        Note note = new Note(title,content);
        
        request.setAttribute("Title", note.getTitle());
        request.setAttribute("Content", note.getContent());
        
        if (a == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return; 
        }else if(a == "") {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return; 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //read the txt file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //to write to the file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
       
        String writeTitles = request.getParameter("Title");
        String writeContents = request.getParameter("Content");
        
        pw.write(writeTitles);
        pw.write(writeContents);
        
        
       getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return;
    }


}
