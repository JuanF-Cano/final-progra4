package modelo;

import interfaces.Vacunable;

public class Gato extends Animal implements Vacunable {

    private boolean esInterior;

    public Gato() {
    }

    public Gato(int id, String nombre, int edad, double peso, String raza, boolean esInterior) {
        super(id, nombre, edad, peso, raza);
        this.esInterior = esInterior;
    }

    public void maullar() {
        System.out.println(nombre + " está maullando.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Es de interior: " + esInterior);
    }

    @Override
    public double calcularCostoConsulta() {
        return 45000;
    }

    @Override
    public void aplicarVacuna() {
        System.out.println("Vacuna aplicada al gato.");
    }

    public boolean isEsInterior() {
        return esInterior;
    }

    public void setEsInterior(boolean esInterior) {
        this.esInterior = esInterior;
    }
}

