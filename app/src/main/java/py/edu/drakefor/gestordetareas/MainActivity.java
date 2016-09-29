package py.edu.drakefor.gestordetareas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText nombreEditex;
    EditText emailEditex;
    Button guardarBtn;
    ListView usuariosListView;
   List<String> contacto = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ContactoDao contactoDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cast and upcast
        nombreEditex = (EditText) findViewById(R.id.editexNombre);
        emailEditex = (EditText) findViewById(R.id.editTextEmail);
        guardarBtn = (Button) findViewById(R.id.buttonGuardar);


        contactoDao = new ContactoDao(this);

        //recuperar contactos
        List<Contacto> contactoEntidad = contactoDao.seleccionarTodo();
        contacto = contactosToString(contactoEntidad);


        usuariosListView = (ListView)findViewById((R.id.listViewUsuario));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, contacto);

        usuariosListView.setAdapter(adapter);


        guardarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditex.getText().toString();
                String email = emailEditex.getText().toString();

                if (!validarNombre(nombre)) {

                    nombreEditex.setError(getString(R.string.nombre_error));

                }else if (!validarEmail(email)){

                    emailEditex.setError(getString(R.string.email_error));

                }else {
                    String mensaje = getString(R.string.welcome_msj)+nombre+""+email;
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

                    Contacto c = new Contacto();
                    c.setNombre(nombre);
                    c.setEmail(email);
                    contactoDao.crear(c);

                    String datos = nombre+"\n "+email;

                  contacto.add(datos);

                    adapter.notifyDataSetChanged();


                    nombreEditex.setText(null);
                    emailEditex.setText(null);
                }

               }
            });

        }

    private List<String> contactosToString(List<Contacto> contactoEntidad) {
        List<String> result = new ArrayList<>();
        for (Contacto c:contactoEntidad){
            result.add(c.getNombre()+"\n"+c.getEmail());
        }
        return result;
    }

    private boolean validarNombre(String nombre) {
              return !nombre.equals("");


            }
             private  boolean validarEmail(String email){
               return Patterns.EMAIL_ADDRESS.matcher(email).matches();


             }





}






