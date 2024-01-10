package com.example.myapplication.clases;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Empresa /*implements Parcelable */{
    private String razon;
    private int ruc;
    private String direccion;
    private String mail;
    private int telefono;
    private String estado;
    private String mision;
    private String vision;

    private int codigo;
    public Empresa(){

    }
    public Empresa(String razon, int ruc, String direccion, String mail, int telefono, String estado, String mision, String vision, int codigo) {
        this.razon = razon;
        this.ruc = ruc;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
        this.estado = estado;
        this.mision = mision;
        this.vision = vision;
        this.codigo=codigo;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

//parcelable/*/*
   /* protected Empresa(Parcel in) {
        razon= in.readString();
        ruc= in.readInt();
        direccion= in.readString();
        mail= in.readString();
        telefono=in.readInt();
        estado= in.readString();
        mision= in.readString();
        vision= in.readString();
        codigo=in.readInt();

    }

    public static final Creator<Empresa> CREATOR = new Creator<Empresa>() {
        @Override
        public Empresa createFromParcel(Parcel in) {

            return new Empresa(in);
        }

        @Override
        public Empresa[] newArray(int size) {
            return new Empresa[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(razon);
        parcel.writeInt(ruc);
        parcel.writeString(direccion);
        parcel.writeString(mail);
        parcel.writeInt(telefono);
        parcel.writeString(estado);
        parcel.writeString(mision);
        parcel.writeString(vision);
        parcel.writeInt(codigo);
    }*/
}
