package com.artiffex.lithomat.sistemaweb.businesstier.jasper;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

public class FirstReportFill {
    
    public static void main( String[] args ) {        
        try {
        	String directorio_origen = "WebContent/resources/jasper/";
        	
            System.out.println("Filling report...");
            JasperFillManager.fillReportToFile( 
            		directorio_origen + "FirstReport.jasper", 
            		new HashMap<String, Object>(), 
            		new JREmptyDataSource()
            	);
            System.out.println("Done!");
            
        } catch( JRException e ) {
            e.printStackTrace();
        }
    }
}
