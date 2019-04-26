package appmoviles.com.webserviceconsumer;

import com.google.gson.Gson;

import java.io.IOException;

import appmoviles.com.webserviceconsumer.Modelo.Comentario;
import appmoviles.com.webserviceconsumer.Modelo.Usuario;

public class ServiceManager {

    public static final String SIMPLEGET_URL = "https://www.icesi.edu.co/";
    public static final String USUARIOS_URL = "https://fir-androidicesi.firebaseio.com/user.json";
    public static final String COMENTARIOS_URL = "https://camara-4a96c.firebaseio.com/comentarios.json";
    public static final String COMENTARIOS_DELETE = "https://camara-4a96c.firebaseio.com/comentarios/%ID.json";
    public static final String VEHICULOS_URL = "https://camara-4a96c.firebaseio.com/vehiculos.json";
    public static final String MATERIAS_URL = "https://instalacion-bc3ad.firebaseio.com/materias.json";

    public static class SimpleGET{

        OnResponseListener listener;

        public SimpleGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(SIMPLEGET_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class usuariosGET{

        OnResponseListener listener;

        public usuariosGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(USUARIOS_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class comentariosGET{

        OnResponseListener listener;

        public comentariosGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(COMENTARIOS_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class vehiculosGET{

        OnResponseListener listener;

        public vehiculosGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(VEHICULOS_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class materiasGET{

        OnResponseListener listener;

        public materiasGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(MATERIAS_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }


    public static class usuariosPOST{

        OnResponseListener listener;

        public usuariosPOST(Usuario usuario, OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String response = util.POSTrequest(USUARIOS_URL, g.toJson(usuario));
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class comentariosPOST{

        OnResponseListener listener;

        public comentariosPOST(Comentario comentario, OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String response = util.POSTrequest(COMENTARIOS_URL, g.toJson(comentario));
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }

    public static class comentariosDELETE{

        OnResponseListener listener;

        public comentariosDELETE( String id, OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util =  new HTTPSWebUtilDomi();
            try {
                String response = util.DELETErequest(COMENTARIOS_DELETE.replace("%ID%", id), "");
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public interface OnResponseListener{
            void onResponse(String response);
        }

    }
}
