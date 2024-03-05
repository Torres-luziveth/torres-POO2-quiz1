public class Propietario extends Persona{
    String Id_Propietario;

    public Propietario(String nombre,  String apellido, int edad, int documento, String id) {
        super(nombre, apellido, edad, documento);
        this.Id_Propietario = id;
    }
    public Object[] getInformacion( Propietario propietario) {

        Object[] lista = {propietario.getNombre(), propietario.getApellido(), propietario.getEdad(), propietario.getDocumento(), propietario.getId_Propietario()};

        return lista;
    }
    public String getId_Propietario() {
        return this.Id_Propietario;
    }


}

