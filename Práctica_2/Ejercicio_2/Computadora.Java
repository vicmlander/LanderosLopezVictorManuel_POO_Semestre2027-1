/*====================================
    Práctica 2
    Programación Orientada a Objetos 2027-1

    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/

public class Computadora {

    // == Atributos ==
    String cpu;
    int ram;
    int almacenamiento;
    boolean gpu;
    int fuenteEnergia;

    // == Constructor vacío ==
    public Computadora() {
    }

    // == Constructor completo ==
    public Computadora(String cpu, int ram, int almacenamiento,
                       boolean gpu, int fuenteEnergia) {
        this.cpu = cpu;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.gpu = gpu;
        this.fuenteEnergia = fuenteEnergia;
    }

    // == Setters ==
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void setGpu(boolean gpu) {
        this.gpu = gpu;
    }

    public void setFuenteEnergia(int fuenteEnergia) {
        this.fuenteEnergia = fuenteEnergia;
    }

    // == Getters ==
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public boolean getGpu() {
        return gpu;
    }

    public int getFuenteEnergia() {
        return fuenteEnergia;
    }
}