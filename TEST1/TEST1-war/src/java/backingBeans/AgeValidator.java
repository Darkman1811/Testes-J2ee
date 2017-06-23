/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Super
 */
@FacesValidator("ageValidator")
public class AgeValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         Long age=(Long)value;
         if(age<18){
            UIInput toValidate=(UIInput)component;
            toValidate.setValid(false);
            String message="Vous etes trop jeune version 2";
            context.addMessage(component.getClientId(context),new FacesMessage(message));
        }
    }
    
}
