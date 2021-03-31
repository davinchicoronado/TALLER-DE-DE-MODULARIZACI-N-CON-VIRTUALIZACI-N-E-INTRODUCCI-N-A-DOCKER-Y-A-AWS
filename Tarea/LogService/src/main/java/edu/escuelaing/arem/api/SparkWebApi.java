/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger; 




/**
 *
 * @author David Coronado
 */
public class SparkWebApi {
    
    
    
    public static void main(String[] args) {  
        
        port(getPort());
        post("/saveDate", (req,res) -> saveDates(req, res));
        get("/queryDate", (req, res) -> queryDate(req, res));
        get("/hello", (req, res) -> "Hello World Mama");
  
    }
    
    /**
    *  Ofrece el servicio http de guardar datos en una base de datos Mongo 
    * 
    */
    
    private static String saveDates(Request req, Response res) {
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = req.body();
        
        
        res.type("application/json");
        try {
            res.status(202);
            Value val = objectMapper.readValue(json, Value.class);        
            
            
            DBObject value = new BasicDBObject("_id" , val.getValue().substring(val.getValue().length()-10,val.getValue().length())).
                    append("date",new Date().toString());
            
            DBCollection collection = getCollection();
            collection.insert(value);
 
            return "{\"message\":\"Custom 202\"}";
           
        } catch (JsonProcessingException | UnknownHostException ex) {  
            Logger.getLogger(SparkWebApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       res.status(404);
       return  "{\"message\":\"Custom 404\"}";
 
    }
    
    /**
    *  Ofrece el servicio http de consulta de datos en una base de datos Mongo 
    * 
    */
    
    private static String queryDate(Request req, Response res) {
       
        
        
        String value = req.queryParams("Dates");  
        res.type("application/json");
        
        try {
            
            DBCollection collection = getCollection();
     
            DBObject query = new BasicDBObject("_id", value.substring(value.length()-10,value.length()));

            DBCursor cursor = collection.find(query);
 
            
            res.status(202);

            String body = "{"+
                    "\"value\":"+ 
                    "\""+ (String)cursor.one().get("_id") + "\"" +
                    ",\"date\":"+"\"" +(String)cursor.one().get("date")+"\"" +"}";
 
            return body;
   
        } catch (UnknownHostException ex) {

            Logger.getLogger(SparkWebApi.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       res.status(404);
       return  "{\"message\":\"Custom 404\"}";
    }
    
    /**
    * Devuelve una coleccion de una base de datos en Mongo especifica permitiendo hacer   
    * @return value  valor a guardar
    */
    
    private static DBCollection getCollection() throws UnknownHostException{
            
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://172.20.0.6:27017"));
            DB database = mongoClient.getDB("DBValues");
            DBCollection collection = database.getCollection("values");  
            return collection;
    
    }
    
    public static int getPort() {
            if (System.getenv("PORT") != null) {
                    return Integer.parseInt(System.getenv("PORT"));
            }
            return 4568; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
    
    
    
    
    
    
}
