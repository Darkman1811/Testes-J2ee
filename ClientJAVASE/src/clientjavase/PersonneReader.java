/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author Super
 */
public class PersonneReader implements MessageBodyReader<Personne>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public Personne readFrom(Class<Personne> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Personne personne= new Personne();
        JsonParser parser=Json.createParser(in);
        while (parser.hasNext()) {
            switch (parser.next()){
                case KEY_NAME:
                    String key=parser.getString();
                    switch(key){
                        case "id": personne.setId(parser.getInt());
                                   break;
                          default: break;
                    }
                    break;
           default: break;
            }
            
        }
        return personne;
    }
    
}
