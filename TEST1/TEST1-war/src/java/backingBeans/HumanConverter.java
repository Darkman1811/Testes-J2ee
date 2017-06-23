/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import testEntity.Beans.Human;

/**
 *
 * @author Super
 */
@FacesConverter("humanConverter")
public class HumanConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Human homme=new Human();
        int id=Integer.valueOf(value);
        homme.setId(id);   
        homme.setPrenom("Abdoulaye");
        homme.setNom("Diaw");
        homme.setAge(20);
        
        return homme;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Human homme=(Human)value;
        String val=String.valueOf(homme.getId());
        return val; 
    }
      
}
