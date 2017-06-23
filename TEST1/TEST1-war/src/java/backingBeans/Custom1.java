/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import testEntity.Beans.Human;

/**
 *
 * @author Super
 */
@ManagedBean
@SessionScoped
public class Custom1 {
    private int i=0;
    private int j=0;
    private Human homme;
    
    public String navitage(){
     return "/customs/page2.xhtml"   ;
    }

    public Human getHomme() {
        homme=new Human();
        homme.setId(2);
        homme.setPrenom("Yacine");
        homme.setNom("Diop");
        homme.setAge(26);
        return homme;
    }

    public void setHomme(Human homme) {
        this.homme = homme;
    }

    
    public void processValidate(FacesContext context, UIComponent comp,Object value){
        Long age= (Long)value;
        if(age<18){
            UIInput toValidate=(UIInput)comp;
            toValidate.setValid(false);
            String message="Vous etes trop jeune";
            context.addMessage(comp.getClientId(context),new FacesMessage(message));
        }
    }
    public void processValueChange(ValueChangeEvent event){
        j=j+1; 
    }
    
    public void testActioListener(ActionEvent event){
        i=i+1;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
}
