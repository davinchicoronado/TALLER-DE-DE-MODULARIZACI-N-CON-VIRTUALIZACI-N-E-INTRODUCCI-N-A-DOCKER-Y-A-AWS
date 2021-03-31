/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.app;

/**
 *
 * @author David Coronado
 */


import spark.Request;
import spark.Response;


import static spark.Spark.*;




public class SparkWebApp {
    
    private static int cont = 0;
    
    public static void main(String[] args) {
        
        port(getPort());
        get("/index", (req, res ) -> inputDataPage(req, res));
        get("/result", (req, res) -> serviceRest(req, res));
 
       
    }
    
     /**
    * Permite ver la pagina inicial   
     * 
    */
    
    private static String inputDataPage(Request req, Response res) {
        
   
       res.type("text/html");
       String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Guarde su info</h2>"
                + "<form action=\"/result\" method=\"get\">"
                + "  Dates:<br>"
                + "  <input type=\"text\" name=\"Dates\" value=\"\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Guardar\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    
    /**
    * Cuando el usuario realiza un click sobre el boton este metodo llama una apirest para que 
    * consuma varios servicios que le ofrece
    * 
    */
    
    private static String serviceRest(Request req, Response res){
        
            String value = req.queryParams("Dates"); 
            res.status(202);
            res.type("application/json");
            
                  
            APIServiceRest apiService = new APIServiceRest(cont);
           
            controllRoundRobin();  
            apiService.saveDates(value); 
            
            controllRoundRobin();
            apiService.setCont(cont);
            
            return apiService.queryDates(value);
         
    } 
    
    
    private static void controllRoundRobin(){
            cont++;
            if(cont>=4){
                cont=1;
            }
    
    }
   
       
    public static int getPort() {
            if (System.getenv("PORT") != null) {
                    return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
    
 
        

     
    
}
