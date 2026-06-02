package modelo;

public class Veterinario {

    private int idVeterinario;
    private String nombre;
    private String especialidad;

    public Veterinario() {
    }

    public Veterinario(int idVeterinario, String nombre, String especialidad) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void atenderMascota() {
        System.out.println("Atendiendo mascota...");
    }

    public void mostrarDatos() {
        System.out.println("ID: " + idVeterinario);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}