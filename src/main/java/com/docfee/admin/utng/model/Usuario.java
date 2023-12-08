package com.docfee.admin.utng.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_usuarios")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer id_usuario;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name = "ApPaterno")
    private String apPaterno;
    
    @Column(name = "ApMaterno")
    private String apMaterno;
    
    @Column(name = "Nss")
    private String nss;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @JoinColumn(name = "id_UsuarioConfianza")
    @OneToOne
    private Usuario id_UsuarioConfianza;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "FechaNac")
    private Date fechaNacimiento;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "Ocupacion")
    private String ocupacion;
    
    @Column(name="usuario")
    private String usuario;
    
}
