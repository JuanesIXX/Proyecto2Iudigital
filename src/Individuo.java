public class Individuo {
    private final String nombre;
    private final String apellido;
    private String sexo;
    private int edad;

    public Individuo(String nombre, String apellido, String sexo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }