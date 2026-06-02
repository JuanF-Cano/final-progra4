package modelo;

public class Dueño {

    private int idDueño;
    private String nombre;
    private String telefono;
    private String direccion;

    public Dueño() {
    }

    public Dueño(int idDueño, String nombre, String telefono, String direccion) {
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + idDueño);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}