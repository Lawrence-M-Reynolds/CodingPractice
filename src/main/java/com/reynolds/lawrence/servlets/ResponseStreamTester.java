package com.reynolds.lawrence.servlets;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet to investigate how the response is chunked when flushing output to the
 * response printwriter.
 *
 *  --> when flushing a print writer/outputstream the response is committed so no new headers can be added. but
 *   in this case the "Content-Length" header is omitted and "Transfer-Encoding: chunked" header is added. To
 *   indicate the ending, an empty chunk is added. This was tested using:
 *   curl --verbose --raw "http://localhost:8080/{context_path}/{servlet_mapping}?flush=true&count=2&milis=0
 * "
 */
public class ResponseStreamTester extends HttpServlet {

    private static final int MAX = 3;
    private static final int MILIS = 1000;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean flush = Boolean.valueOf(request.getParameter("flush"));
        int count;
        try{
            count = Integer.valueOf(request.getParameter("count"));
        } catch(Exception e){
            count = MAX;
        }

        int milis;
        try{
            milis = Integer.valueOf(request.getParameter("milis"));
        } catch(Exception e){
            milis = MILIS;
        }

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        for(int i = 0; i < count; i++){
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("<div>Message: " + i + "</div>");
            if(flush){
                out.flush();
            }
        }

    }

}