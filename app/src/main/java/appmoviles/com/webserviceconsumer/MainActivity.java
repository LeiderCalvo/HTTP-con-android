package appmoviles.com.webserviceconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

import appmoviles.com.webserviceconsumer.Modelo.Comentario;
import appmoviles.com.webserviceconsumer.Modelo.Materia;
import appmoviles.com.webserviceconsumer.Modelo.Propietario;
import appmoviles.com.webserviceconsumer.Modelo.Usuario;
import appmoviles.com.webserviceconsumer.Modelo.Vehiculo;

public class MainActivity extends AppCompatActivity {

    private Button btn_get, btn_post, btn_getCom, btn_getVeh, btn_getMat, btn_postCom, btn_delCom;
    private TextView txt_conosole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get = findViewById(R.id.btn_get);
        btn_getCom = findViewById(R.id.btn_getCom);
        btn_getVeh = findViewById(R.id.btn_getVeh);
        btn_getMat = findViewById(R.id.btn_getMat);
        btn_postCom = findViewById(R.id.btn_postCom);
        btn_delCom = findViewById(R.id.btn_delCom);

        btn_post = findViewById(R.id.btn_post);
        txt_conosole = findViewById(R.id.txt_console);
        txt_conosole.setMovementMethod(new ScrollingMovementMethod());

        new Thread(()->{
                        Log.e(">>>>>>>", "uno icesi");
            new ServiceManager.SimpleGET(new ServiceManager.SimpleGET.OnResponseListener() {
                @Override
                public void onResponse(String response) {
                    Log.e(">>>>>>>", "dos icesi"+response);
                    runOnUiThread(()->{
                        Log.e(">>>>>>>", "tres icesi");
                        txt_conosole.setText(response);
                    });
                }
            });
        }).start();

        btn_get.setOnClickListener(view -> new Thread(()->{
            new ServiceManager.usuariosGET(new ServiceManager.usuariosGET.OnResponseListener() {
                @Override
                public void onResponse(String response) {
                    Log.e(">>>>>>>", "dos firebase");
                    runOnUiThread(()->{
                        Log.e(">>>>>>>", "tres firebase");
                        txt_conosole.setText(response);

                        Type tipo = new TypeToken< HashMap<String, Usuario> >(){

                        }.getType();

                        Gson g = new Gson();
                        HashMap<String, Usuario> usuarios = g.fromJson(response, tipo);

                        txt_conosole.append("\n\n+Usuarios: "+usuarios.size());
                        txt_conosole.append("\nUsuario 0: "+usuarios.get("0tIu7M5u4kbGpYAD181Holv0pJU2").nombre);

                    });
                }
            });
        }).start());

        btn_getCom.setOnClickListener(view -> new Thread(()->{
            new ServiceManager.comentariosGET(new ServiceManager.comentariosGET.OnResponseListener() {
                @Override
                public void onResponse(String response) {
                    runOnUiThread(()->{
                        txt_conosole.setText(response);
                        Type tipo = new TypeToken< HashMap<String, Comentario> >(){

                        }.getType();

                        Gson g = new Gson();
                        HashMap<String, Comentario> comentarios = g.fromJson(response, tipo);

                        txt_conosole.append("\n\n+comentarios: "+comentarios.size());
                        txt_conosole.append("\ncom 0: "+comentarios.get("-LRODOhP2VzigX1TcLee").mensaje);
                    });
                }
            });
        }).start());

        btn_getVeh.setOnClickListener(view -> new Thread(()->{
            new ServiceManager.vehiculosGET(new ServiceManager.vehiculosGET.OnResponseListener() {
                @Override
                public void onResponse(String response) {
                    runOnUiThread(()->{
                        txt_conosole.setText(response);
                        Type tipo = new TypeToken< HashMap<String, Vehiculo> >(){

                        }.getType();


                        Gson g = new Gson();
                        HashMap<String, Vehiculo> vehiculos = g.fromJson(response, tipo);


                        txt_conosole.append("\n\n+vehiculos: "+vehiculos.size());
                        txt_conosole.append("\nvehiculo 0: "+vehiculos.get("alfa").propietario.nombre);
                    });
                }
            });
        }).start());

        btn_getMat.setOnClickListener(view -> new Thread(()->{
            new ServiceManager.materiasGET(new ServiceManager.materiasGET.OnResponseListener() {
                @Override
                public void onResponse(String response) {
                    runOnUiThread(()->{
                        txt_conosole.setText(response);
                        Type tipo = new TypeToken< HashMap<String, Materia> >(){

                        }.getType();

                        Gson g = new Gson();
                        HashMap<String, Materia> materias = g.fromJson(response, tipo);

                        txt_conosole.append("\n\nmaterias: "+materias.size());

                    });
                }
            });
        }).start());

        btn_post.setOnClickListener(view -> {

            new Thread(()->{
                Usuario usuario = new Usuario("dum@gmail.com", "0", "Dummy", "1234565", "56765756");
                new ServiceManager.usuariosPOST(usuario, new ServiceManager.usuariosPOST.OnResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        runOnUiThread(()->{
                            txt_conosole.setText(response);
                        });
                    }
                });
            }).start();

        });

        btn_postCom.setOnClickListener(view -> {

            new Thread(()->{
                Comentario comentario = new Comentario("23/24/24", "99", "buen mensaje");
                new ServiceManager.comentariosPOST(comentario, new ServiceManager.comentariosPOST.OnResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        runOnUiThread(()->{
                            txt_conosole.setText(response);
                        });
                    }
                });
            }).start();

        });

        btn_delCom.setOnClickListener(view -> {

            new Thread(()->{
                new ServiceManager.comentariosDELETE("-LdMMYXnlIqEDtijBFVt", new ServiceManager.comentariosDELETE.OnResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        runOnUiThread(()->{
                            txt_conosole.setText(response);
                        });
                    }
                });
            }).start();

        });
    }
}
