package com.example.seguridad;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Immutable
@Subselect("select id_cliente as id, nombre as name, correo as email, telefono as mobile, usuario, clave FROM apitecnistore.cliente join apitecnistore.usuario using(id_usuario) where tipo_usuario = 'administrador'")
public class Usuario {
    @Id
    private Integer id;

    private String name;
    private String email;
    private String mobile;

    private String usuario;
    private String clave;
}
