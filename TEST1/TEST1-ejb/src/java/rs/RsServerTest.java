/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import com.sun.xml.internal.ws.api.message.Packet;
import java.math.BigDecimal;
import java.net.URI;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.servlet.jsp.PageContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Super
 */
@Path("/book")
public class RsServerTest {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookTitle(){
        //Client client;
        return("Hello JaxRs by Abdoulaye Diaw");
    }
  
    @Path("/param/{text}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookPath(@PathParam("text") String textparameter){
        
        return("Book info: "+textparameter);
    }
    
     @Path("/param/query")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookQuery(@QueryParam("text") String textparameter){
        
        return("Book info: "+textparameter);
    }
    
       @Path("/param/matrix")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookMatrix(@MatrixParam("text") String textparameter){
        
        return("Book info: "+textparameter);
    }
    
             @Path("/param/formParam")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getBookForm(@FormParam("formParam1") String formParam1,@FormParam("formParam2") String formParam2){
        String reponse="Book info FormParam: \n"
                + "FormParam1:"+formParam1+"\n"
                + "FormParam2:"+formParam2;
        System.out.print(reponse);
        return(reponse);
    }
    
           @Path("/param/headerParam")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookHeader(@HeaderParam("header1") String header1,@HeaderParam("header2") String header2){
        
        return("Book info Header: \n"
                + "header1:"+header1+"\n"
                + "header2:"+header2);
    }
    
         @Path("/param/cookieParam")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookCookie(@CookieParam("cookie1") String cookie1,@CookieParam("cookie2") String cookie2){
        
        return("Book info Cookie: \n"
                + "Cookie1:"+cookie1+"\n"
                + "Cookie2:"+cookie2);
    }
    
           @Path("/format/asXml")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Book getBookXml(){
        Book book=new Book(1, "Livre Xml et Json", "Abdoulaye Diaw", 10);
        return(book);
    }    
    
       @Path("/format/asJson")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookJson(){
        
            /*  JsonObjectBuilder builder= Json.createObjectBuilder();
                
                builder.add("id", 10);
                builder.add("titre", "Version Json");
                builder.add("auteur","Abdolaye Diaw");
                builder.add("nbPages", 10);
                
                JsonObject book=builder.build();*/
        
                Book book=new Book(1, "Livre Xml et Json", "Abdoulaye Diaw", 10);
          
        return(book);
    }   
    
        @Path("/format/asHtml")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getBookHtml(){
        
              String code="<html>"
                      + "<head></head>"
                      + "<body>"
                      + "<h1>Salutations</h1>"
                      + "<br>"
                      + "Votre nom:<input type=\"text\" name=\"nom\" id=\"nom\" > "
                      + "</body> "
                      + "</html>";
          
        return(code);
    }  
    
    
    @Path("/methodes/postMethode")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String PostBook(Book book){
        
        return("Book:\n"
                + "Titre:"+book.getNom()+"\n"
                + "Auteur:"+book.getAuteur());
        
    }
    
        @Path("/methodes/postMethodeString")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String PostString(){
        return("bobo");
    }
    
          @Path("/methodes/putMethode")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)      
    @Produces(MediaType.TEXT_PLAIN)
    public String testPut(Book book){
        book.setAuteur("Mr "+book.getAuteur());
        return("done");
    }
    
             @Path("/methodes/deleteMethode")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)      
    @Produces(MediaType.TEXT_PLAIN)
    public String testDelete(@QueryParam("id") String id){
       
        return("deleted "+id);
    }
    
                @Path("/response/testOk")
    @GET   
    @Produces(MediaType.TEXT_PLAIN)
    public Response testResponseOk(){
       
        return(Response.ok("Reponse Ok", MediaType.TEXT_PLAIN)).build();
    }
    
        @Path("/response/testAccepted")
    @GET   
    @Produces(MediaType.TEXT_PLAIN)
    public Response testAccepted(){
       
        return(Response.accepted("Reponse Accepted")).build();
    }
    
     @Path("/response/testOkCookie")
    @GET   
    @Produces(MediaType.TEXT_PLAIN)
    public Response testOkCookie(){
  
          return(Response.ok().cookie(new NewCookie("sessionId", "0123456789")).build());
                
    }
    
     @Path("/response/testOkHeader")
    @GET   
    @Produces(MediaType.TEXT_PLAIN)
    public Response testOkHeader(){
  
          return(Response.ok().header("token","9876543210").build());
                
    }
    
     @Path("/response/testNoContent")
    @GET   
    @Produces(MediaType.TEXT_PLAIN)
    public Response testNoContent(){
  
          return(Response.noContent().build());
                
    }
       @Path("/mapping")
    @GET   
    @Produces(MediaType.APPLICATION_JSON)
    public Personne  testCreatedSuite(){
         Personne personne=new Personne(1, "Abdoulaye", "Diaw", 10);        
        return(personne); 
    } 
     
    
      
}
