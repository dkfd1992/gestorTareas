package py.edu.drakefor.gestordetareas;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText nombreEditex;
    EditText emailEditex;
    Button guardarBtn;
    ListView usuariosListView;
    List<String> usuarios = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cast and upcast
        nombreEditex = (EditText) findViewById(R.id.editexNombre);
        emailEditex = (EditText) findViewById(R.id.editTextEmail);
        guardarBtn = (Button) findViewById(R.id.buttonGuardar);

        usuariosListView = (ListView)findViewById((R.id.listViewUsuario));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,usuarios);

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

                    String datos = nombre+" "+email;
                    usuarios.add(datos);
                    adapter.notifyDataSetChanged();





                    nombreEditex.setText(null);
                    emailEditex.setText(null);
                }


               }
            });
        }

            private boolean validarNombre(String nombre) {
              return !nombre.equals("");


            }
             private  boolean validarEmail(String email){
               return Patterns.EMAIL_ADDRESS.matcher(email).matches();


    }


}






