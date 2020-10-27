package com.svalero.a1_6_0_1_estilosytemas.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Film { //Film.jsonFilms
    public static final String jsonFilms="[\n" +
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
            "]\n";
            private static final String ID="id";
            private static final String TITULO="titulo";
            private static final String TRAILER="trailer";
            private static final String SINOPSIS="sinopsis";
            private static final String FECHA_ESTRENO="fechaEstreno";
            private static final String URL="url";
            private static final String DURACION="duracion";
            private static final String VOTOS="nVotos";
            private static final String PUNTUACION="sPuntuacion";
            private static final String PRECIO="precio";

            private int id; //1
            private String titulo; //
            private String trailer; //
            private String sinopsis;
            private String fechaEstreno;
            private String url;
            private int duracion;
            private int nVotos;
            private int sPuntuacion;
            private double precio;
            //private Genero genero; //idGenero, nombreGenero, etc

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getTrailer() {
                return trailer;
        }

        public void setTrailer(String trailer) {
                this.trailer = trailer;
        }

        public String getSinopsis() {
                return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
                this.sinopsis = sinopsis;
        }

        public String getFechaEstreno() {
                return fechaEstreno;
        }

        public void setFechaEstreno(String fechaEstreno) {
                this.fechaEstreno = fechaEstreno;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public int getDuracion() {
                return duracion;
        }

        public void setDuracion(int duracion) {
                this.duracion = duracion;
        }

        public int getnVotos() {
                return nVotos;
        }

        public void setnVotos(int nVotos) {
                this.nVotos = nVotos;
        }

        public int getsPuntuacion() {
                return sPuntuacion;
        }

        public void setsPuntuacion(int sPuntuacion) {
                this.sPuntuacion = sPuntuacion;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double precio) {
                this.precio = precio;
        }

        public static ArrayList<Film> getArrayListFromJSON() throws JSONException {
                JSONArray lstFilmsJSON = new JSONArray(Film.jsonFilms);
                ArrayList<Film> lstFilms = new ArrayList<>();
                for (int i = 0; i < lstFilmsJSON.length() ; i++) {
                        JSONObject filmObject = lstFilmsJSON.getJSONObject(i);
                        Film film = new Film();
                                film.setId(filmObject.getInt(ID));
                                film.setTitulo(filmObject.getString(TITULO));
                                film.setTrailer(filmObject.getString(TRAILER));
                                film.setSinopsis(filmObject.getString(SINOPSIS));
                                film.setFechaEstreno(filmObject.getString(FECHA_ESTRENO));
                                film.setUrl(filmObject.getString(URL));
                                film.setDuracion(filmObject.getInt(DURACION));
                                film.setnVotos(filmObject.getInt(VOTOS));
                                film.setsPuntuacion(filmObject.getInt(PUNTUACION));
                                film.setPrecio(filmObject.getDouble(PRECIO));
                               /*
                                Genero genero = new Genero;
                                JSONObject generoObject = filmObject.getJSONObject("genero");
                                genero.setId(generoObject.getInt("idGenero"));//1
                                film.setGenero(genero);
                                */
                               lstFilms.add(film);
                }
                return lstFilms;
            }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", trailer='" + trailer + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", fechaEstreno='" + fechaEstreno + '\'' +
                ", url='" + url + '\'' +
                ", duracion=" + duracion +
                ", nVotos=" + nVotos +
                ", sPuntuacion=" + sPuntuacion +
                ", precio=" + precio +
                '}';
    }




}
