//214715 Juan Andres Di Giovannantonio
package Modelo;
import java.io.Serializable;

/**
 *
 * @author juand
 */
public class Cliente extends Persona implements Comparable<Cliente>, Serializable{
    private static final long serialVersionUID = 1L;
    private String correoElectronico;

    public Cliente(String nombre, String celular, String correoElectronico) {
        super(nombre, celular);
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public int compareTo(Cliente unCliente){
        return this.getNombre().compareToIgnoreCase(unCliente.getNombre());
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }
    
}
