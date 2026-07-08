
package Modelo;
import java.io.Serializable;
/**
 *
 * @author juand
 */
public class Departamento implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private Zona zona;

    public Departamento(String nombre, Zona zona) {
        this.nombre = nombre;
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
