package com.artiffex.lithomat.sistemaweb.businesstier.jasper;

import java.io.File;

import net.sf.jasperreports.engine.JasperCompileManager;

public class CompiladorJasper {
    
    public static void main( String[] args ) {
        
        /*
         * 
         * 1) se crea archivo .jrxml manualmente o con herramienta.
         * 2) se compila archivo .jrxml ---> produce .jasper
         * 3) se llena el reporte con los datos + .jasper ---> produce .jrprint
         * 4) .jrprint es el archivo que se imprime en pantalla
         * 
         * */
        
        try {
            File archivoDos = new File("archivo.txt");
            System.out.println( "absolutePath: " + archivoDos.getAbsolutePath() ); 
            System.out.println( "getParent: " + archivoDos.getParent() );            
            
            String path = archivoDos.getAbsolutePath();
            System.out.println( "path indexOf archivo.txt: " + path.indexOf("archivo.txt") );
            String path_base = path.substring( 0, path.indexOf("archivo.txt") );
            System.out.println( "path_base: " + path_base );
            
            String directorio_origen 	= path_base + "src/main/webapp/resources/jrxml/";
            String directorio_destino 	= path_base + "src/main/webapp/resources/jasper/";
            
            /*
            String[] folder = path_corto.split("/");
            StringBuilder directorio = new StringBuilder();
            for( int i=0; i<folder.length-1; i++ ) {
                //System.out.println( folder[i] );
                directorio.append( folder[i] );
                directorio.append("/");
            }
            */
            //System.out.println( str.toString() );
            //directorio.append("sistemweb_web/public_html/resources/jasper/");
            
            System.out.println( "directorio_origen: " + directorio_origen );
            System.out.println( "directorio_destino: " + directorio_destino );
            System.out.println();
            // ---------
            
            System.out.println("Compiling report...");
            JasperCompileManager.compileReportToFile( directorio_origen + "Remision_OK.jrxml", directorio_destino + "Remision_OK.jasper");
            System.out.println("Done!");
            
            
        } catch( /*JRException*/ Exception e ) {
            e.printStackTrace();
        }
    }
}














