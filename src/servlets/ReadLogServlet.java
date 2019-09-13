package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/readLog.do", loadOnStartup = 1)
public class ReadLogServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File folder = new File(req.getServletContext().getRealPath("") + "../../logs");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                try {
                    File file = listOfFiles[i];
                    if (file.isFile() && file.getName().contains("std") && (file.getName().endsWith(".txt") || file.getName().endsWith(".log") || file.getName().endsWith(".out"))) {
                        resp.getWriter().println("<h1>" + file.getName() + "</h1>");
                        InputStreamReader reader = new FileReader(file);
                        BufferedReader reader1 = new BufferedReader(reader);
                        List<String> collect = reader1.lines().collect(Collectors.toList());
                        for (String s : collect) {
                            resp.getWriter().println(s + "<br/>");
                        }
                        resp.getWriter().println("<br/><br/><br/>-------------------------------------------------");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
