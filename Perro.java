package modelo;

import interfaces.Vacunable;

public class Perro extends Animal implements Vacunable {

    private String nivelEnergia;

    public Perro() {
    }

    public Perro(int id, String nombre, int edad, double peso, String raza, String nivelEnergia) {
        super(id, nombre, edad, peso, raza);
        this.nivelEnergia = nivelEnergia;
    }

    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Nivel de energía: " + nivelEnergia);
    }

    @Override
    public double calcularCostoConsulta() {
        return 50000;
    }

    @Override
    public void aplicarVacuna() {
        System.out.println("Vacuna aplicada al perro.");
    }

    public String getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(String nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }
}