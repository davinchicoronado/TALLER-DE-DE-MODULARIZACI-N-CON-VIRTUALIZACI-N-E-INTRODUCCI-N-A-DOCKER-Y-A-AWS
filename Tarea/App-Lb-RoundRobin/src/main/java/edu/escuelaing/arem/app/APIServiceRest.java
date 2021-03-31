/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author David Coronado
 */
public class APIServiceRest {
    
    private  int cont;

    private String url1 = "http://172.20.0.2:35001";
    private String url2 = "http://172.20.0.3:35002";
    private String url3 = "http://172.20.0.4:35003";
    private String url4 = "http://localhost:4568";
    private String url5 = "http://localhost:8087";
    
    public APIServiceRest(int cont){
        this.cont=cont;
    }
    
    
     /**
    * Permite guardar datos por medio de peticiones http  en una base de datos MongoDB   
     * @param value  valor a guardar
    */
    
    public  void saveDates(String value) {
 
            java.lang.String payload ="{"
                    +"\"value\":" + "\""+ value + "\"" + "}";

            StringEntity entity = new StringEntity(payload,
                        ContentType.APPLICATION_JSON);

            try {
                    HttpClient httpClient = HttpClientBuilder.create().build();
                    HttpPost request = new HttpPost(balanceoRoundRobin()+"/saveDate");


                    request.setEntity(entity);

                    HttpResponse response;
                    response = httpClient.execute(request);
                    

                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }       
    }
     /**
    * Permite consultar datos  por medio de peticiones http en una base de datos MongoDB   
     * @param value  valor a ser consultado
     * @return un objeto string representando el json con informacion de los ultimos diez caracteres almacenados con su respectiva fecha de almacenamiento
     * 
    */

    public String queryDates(String value){
        
        
        try {
                
                HttpClient httpClient = HttpClientBuilder.create().build();
                
    
                URI uri = new URI(balanceoRoundRobin()+"/queryDate?Dates="+value);
                
                HttpGet request = new HttpGet(uri);
                
                HttpResponse response;
                
                response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();
                
                String body = EntityUtils.toString(entity);
                
                return body;

            } catch (IOException ex) {
                Logger.getLogger(IOException.class.getName()).log(Level.SEVERE, null, ex);
              
            } catch (URISyntaxException ex) {    
                Logger.getLogger(SparkWebApp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return  "{\"message\":\"Custom 404\"}";
    
    } 
  
    public void setCont(int cont) {
        this.cont = cont;
    }
    
     /**
    *   
     * Realiza el balanceo Round Robin cambiando de url y permitiendo hacer las peticiones http a diferentes containers  
     * @return una url especifica
     * 
    */
    
    private String balanceoRoundRobin(){
        switch (cont) {
            case 1:
                return url1;
            case 2:
                return url2;
            case 3:
                return url3;
            default:
                break;
        }
 
 
        return null;
    }
    
    
    
    
    
    
}
