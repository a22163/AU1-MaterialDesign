package com.svalero.a1_5_0_2_linearlayoutlogin.entities;

public class User {
    // Reflejo de la tabla USUARIO de Base de Datos +
    // algo que requiera la pantalla
    private String email;
    private String password;

    public User() {
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /*

    public String toJSON(){}
    [
        {
        "id":2,
        "titulo":"300"
        },
        {
        }
    ]
    public String toXML(){}
        <peliculas>
            <pelicula id="1">
                <titulo>300</titulo>
            </pelicula>
        </peliculas>
    */
}
