/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import clientjavase.Personne;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ProjectStage;
import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author Super
 */
public class testJsonDom {
   
    public static void main(String [] args){
              
        String jsonString="{\"id\":1,\"prenom\":\"Abdoulaye\",\"nom\":\"Diaw\",\"age\":30,\"adresse\":[{\"Pays\":\"Sénégal\",\"Region\":\"Dakar\",\"Ville\":\"Dakar\",\"Rue\":\"Ouagouniayes\"},{\"Pays\":\"Sénégal\",\"Region\":\"Dakar\",\"Ville\":\"Dakar\",\"Rue\":\"OuestFoire\"}]}" ;
            
            
        Personne personne=new Personne();
        personne.setId(1);
        personne.setPrenom("Abdoulaye");
        personne.setNom("Diaw");
        personne.setAge(30);
        testJsonDom test=new testJsonDom();
       
        
      //  System.out.println(test.personneToJson(personne));
        
       /* Personne pers=test.JsonToPersonne(jsonString);
        System.out.println("id: "+pers.getId()+"\n Prenom: "+pers.getPrenom()+"\n Nom: "+pers.getNom()+"\n Age: "+pers.getAge());*/
        test.toXml(jsonString);
    }
    
    public String personneToJson(Personne personne){
        
        JsonObjectBuilder adresseBuilder1=Json.createObjectBuilder();
            adresseBuilder1.add("Pays", "Sénégal");
            adresseBuilder1.add("Region", "Dakar");
            adresseBuilder1.add("Ville", "Dakar");
            adresseBuilder1.add("Rue", "Ouagouniayes");
            
        JsonObjectBuilder adresseBuilder2=Json.createObjectBuilder();
            adresseBuilder2.add("Pays", "Sénégal");
            adresseBuilder2.add("Region", "Dakar");
            adresseBuilder2.add("Ville", "Dakar");
            adresseBuilder2.add("Rue", "OuestFoire");
        
        JsonArrayBuilder adresses= Json.createArrayBuilder().add(adresseBuilder1.build()).add(adresseBuilder2.build());
            
        JsonObjectBuilder personBuilder= Json.createObjectBuilder();
            personBuilder.add("id",personne.getId());
            personBuilder.add("prenom",personne.getPrenom());
            personBuilder.add("nom", personne.getNom());
            personBuilder.add("age", personne.getAge());
            personBuilder.add("adresse", adresses);
        JsonObject jsonString=personBuilder.build();
        
       return jsonString.toString();
    }
    
    public Personne JsonToPersonne(String jsonString){
        Personne personne=new Personne();
        JsonReader reader=Json.createReader(new StringReader(jsonString));
        JsonObject objet=reader.readObject();
        
        personne.setId(objet.getInt("id"));
        personne.setPrenom(objet.getString("prenom"));
        personne.setNom(objet.getString("nom"));
        personne.setAge(objet.getInt("age"));
        
        JsonArray ar = objet.getJsonArray("adresse");
        for(int i=0;i<ar.size();i++){
            JsonObject adresse=ar.getJsonObject(i);
            System.out.println(adresse.getString("Pays"));
            System.out.println(adresse.getString("Region"));
            System.out.println(adresse.getString("Ville"));
            System.out.println(adresse.getString("Rue"));
        }
        return personne;
    }
    
    public String toXml(String jsonString){
        try{
            JsonParser parser= Json.createParser(new StringReader(jsonString));
            Event event=null;
            
            ArrayList ar=new ArrayList();
         
            
            String parent_name=null;
            int nParents=0;
            boolean parent=false;
            int deep=0;
            String key=null;
            String arrayKey=null;
                    while(parser.hasNext()){
                       event=parser.next();
                       switch(event){
                           case KEY_NAME: 
                             //  System.out.print("\n"+parser.getString());
                               key=parser.getString();
                             
                               break;
                           case VALUE_STRING:
                               System.out.println(key+":"+parser.getString());
                               break;
                           case VALUE_NUMBER:
                               System.out.println(key+":"+parser.getLong());
                               break;
                           case START_ARRAY:
                            /*   nParents+=1;*/
                               arrayKey=key;  
                               //System.out.print("< array name='"+arrayKey+"'>\n");
                            parent=true;
                             //System.out.println("array==>");
                               break;
                           case END_ARRAY:
                               parent=false;
                           //System.out.println("</ array name='"+arrayKey+">\n");
                               arrayKey=null;
                               break;
                           case START_OBJECT:
                                   if(parent==true){System.out.print("<array name='"+arrayKey+"'>\n");}
                               break;
                           case END_OBJECT:
                                if(parent==true){System.out.println("</array name='"+arrayKey+">\n");}
                               break;                               
                           default:
                               System.out.println("NAN");
                               break;
                       }
                    }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return "";
    }
}
