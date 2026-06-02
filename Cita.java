package modelo;

public class Cita {

    private int idCita;
    private String fecha;
    private String motivo;
    private double costo;

    public Cita() {
    }

    public Cita(int idCita, String fecha, String motivo, double costo) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.motivo = motivo;
        this.costo = costo;
    }

    public void registrarCita() {
        System.out.println("Cita registrada correctamente.");
    }

    public void mostrarCita() {
        System.out.println("ID Cita: " + idCita);
        System.out.println("Fecha: " + fecha);
        System.out.println("Motivo: " + motivo);
        System.out.println("Costo: " + costo);
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
