/*====================================
    Práctica 2
    Programación Orientada a Objetos 2027-1
    Landeros López Victor Manuel.
    Equipo 1
    No: 3-16229849
====================================*/
public class Alumno {

    // == Atributos ==
    int edad;
    float promedio;
    String nombre, semestre;
    char sexo;

    // == Constructor vacío ==
    public Alumno() {
    }

    // == Constructor completo ==
    public Alumno(int edad, float promedio, String nombre, String semestre, char sexo) {
        this.edad = edad;
        this.promedio = promedio;
        this.nombre = nombre;
        this.semestre = semestre;
        this.sexo = sexo;
    }

    // == Setters ==
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    // == Getters ==
    public int getEdad() {
        return edad;
    }
    public float getPromedio() {
        return promedio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getSemestre() {
        return semestre;
    }
    public char getSexo() {
        return sexo;
    }
}