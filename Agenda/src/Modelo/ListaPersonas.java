package Modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personas")
public class ListaPersonas {
    private List<Persona> personas;
    
    @XmlElement(name = "persona")
    public List<Persona> getPersonas(){
        return personas;
    }
    
    public void setPersonas(List<Persona> personas){
        this.personas = personas;
    }
    
}
