package com.example.myapplication.clases;

import java.io.Serializable;

public class MaeCliente implements Serializable {
    private int id;
    private String nombreEmpresa;
    private String infoContacto;
    private char estadoRegistro;

    public MaeCliente(String nombreEmpresa, String infoContacto, char estadoRegistro) {
        this.nombreEmpresa = nombreEmpresa;
        this.infoContacto = infoContacto;
        this.estadoRegistro = estadoRegistro;
    }
}
