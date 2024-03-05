public class Persona {
    int documento;
    String nombre;
    String Apellido;
    int edad;

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.documento = documento;
        this.nombre = nombre;
        this.Apellido = apellido;
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getEdad() {
        return edad;
    }
}
