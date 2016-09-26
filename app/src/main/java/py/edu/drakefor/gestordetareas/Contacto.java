package py.edu.drakefor.gestordetareas;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LUIS on 14/09/2016.
 */

@DatabaseTable
public class Contacto {
    //auto generar el id y tambien crear la colummna id en la tabla
    @DatabaseField(generatedId = true)
    private  int id;

    //crear la columna nombre en la tabla
    @DatabaseField
    private String nombre;

    //crear la columna email en la tabla
    @DatabaseField
    private String email;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
