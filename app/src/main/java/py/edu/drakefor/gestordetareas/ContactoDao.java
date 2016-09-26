package py.edu.drakefor.gestordetareas;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LUIS on 14/09/2016.
 */
public class ContactoDao {

    public ContactoDao(Context context){
        DBA.init(context);

    }
    public void crear( Contacto c){
        try {
            DBA.getContactoDao().create(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Contacto seleccionar(int id){
        try {
            return DBA.getContactoDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }

    }

    public List<Contacto> seleccionarTodo(){
        try {
            return DBA.getContactoDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    public void eliminar(int id){
        try {
            DBA.getContactoDao().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Contacto c){
        try {
            DBA.getContactoDao().update(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
