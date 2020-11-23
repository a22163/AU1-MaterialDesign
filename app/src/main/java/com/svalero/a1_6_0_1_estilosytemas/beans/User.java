package com.svalero.a1_6_0_1_estilosytemas.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class User {
static{
    String jpaMovies="[\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"fdadfsa\",\n" +
            "    \"sinopsis\": \"fdsa\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 1,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"A\",\n" +
            "    \"sinopsis\": \"A\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 2,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"A\",\n" +
            "    \"sinopsis\": \"A\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 3,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"A\",\n" +
            "    \"sinopsis\": \"A\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 4,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"A\",\n" +
            "    \"sinopsis\": \"A\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 5,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"titulo\": \"A\",\n" +
            "    \"trailer\": \"A\",\n" +
            "    \"sinopsis\": \"A\",\n" +
            "    \"fechaEstreno\": \"2019\",\n" +
            "    \"url\": \"parasitos\",\n" +
            "    \"duracion\": 0,\n" +
            "    \"nVotos\": 5,\n" +
            "    \"sPuntuacion\": 5,\n" +
            "    \"id\": 6,\n" +
            "    \"precio\": 5.0,\n" +
            "    \"genero\": {\n" +
            "      \"idGenero\": 1\n" +
            "    }\n" +
            "  }\n" +
            "]";
}
    /*
        private Asignatura asignatura;
        private Estudiante estudiante;
        private int idTarea;
        private int nombreTarea;
        private int tareaNota;
    */
    /**** JSON ***/
    /*******/ // TRANSFORMADORES DE JSON--> A JAVA Y DE JAVA TO--> JSON
    /**** XML ***/
    /*******/
    private static final String ID_USUARIO="idUsuario";
    private static final String ID="id";
    private static final String EMAIL="email";
    private static final String PASSWORD="password";

    private long id; // 155
    private String email; //
    private String password; //

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<User> toArrayFromJSON(JSONArray lstUsers) throws JSONException {
        String cad="";
        ArrayList<User> lstUser = new ArrayList();

        for (int i = 0 ; i < lstUsers.length() ; i++){
            JSONObject userJSON = lstUsers.getJSONObject(i);
                User user = new User();
                    user.setId(userJSON.getInt(ID));
                    user.setEmail(userJSON.getString(EMAIL));
                    user.setPassword(userJSON.getString(PASSWORD));
            lstUser.add(user);
        }
        return lstUser;
        // [
        // {
        //  "ID":1; "EMAIL":"a@svalero.com"; "PASSWORDS":"1234"
        // },
        // {},
        // ]

    }
    private void toObjectFromJSON(){
        // {
        //  "ID":1; "EMAIL":"a@svalero.com"
        // }
        //
    }
    private void toJSONFromObject(){
        //
    }
    private void toJSONFromArray(){
        //
    }
}
