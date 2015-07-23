package com.artiffex.lithomat.sistemaweb.businesstier.jasper;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class FirstReportSendToBrowserServlet extends HttpServlet {

    private static final long serialVersionUID = 6229235617659224208L;

    /* NO FUNCIONA PORQUE ES UN SRVLET Y DEBE ESTAR CONFIGURADO EN EL XML */

    protected void doGet( 
    		HttpServletRequest request, 
    		HttpServletResponse response 
    	) throws ServletException, IOException {
        
        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("resources/JRXML/FirstReport.jasper");
        
        try {
            JasperRunManager.runReportToPdfStream( 
            		reportStream, 
            		servletOutputStream, 
            		new HashMap<String, Object>(), 
            		new JREmptyDataSource()
            	);
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch( JRException e ) {
            // display stack trace in the browser
            StringWriter stringWriter   = new StringWriter();
            PrintWriter printWriter     = new PrintWriter( stringWriter );
            e.printStackTrace( printWriter );
            response.setContentType("text/plain");
            response.getOutputStream().print( stringWriter.toString() );
        }
    }
}
