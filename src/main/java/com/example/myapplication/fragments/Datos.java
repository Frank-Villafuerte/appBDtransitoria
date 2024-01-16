package com.example.myapplication.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.activity.ListaDatos;
import com.example.myapplication.R;
import com.example.myapplication.clases.Empresa;
import com.example.myapplication.gestorBD.DatabaseSingleton;
import com.google.android.material.internal.TextScale;


public class Datos extends Fragment {
    private Button aceptar, cancelar;
    private Bundle recibir;
    private Empresa empresa;
    private  TextView razon, ruc, direccion, mail, telefono, mision, vision, ordenTV;
    private String orden;
    private ViewGroup razonContenedor, rucContenedor,
            direccionContenedor, mailContenedor, telefonoContenedor,misionContenedor, visionContenedor;
    private EditText razonInput, rucInput,
            direccionInput, mailInput, telefonoInput,misionInput, visionInput;
    private DatabaseSingleton databaseSingleton;
    private ImageView status;

    public Datos() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_datos, container, false);
        databaseSingleton=DatabaseSingleton.getInstance(requireContext());

        status=view.findViewById(R.id.logo);
        aceptar = view.findViewById(R.id.aceptar);
        cancelar=view.findViewById(R.id.cancelar);
        //TEXT VIEW PROBABLES
        razon=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        ruc=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        direccion=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        mail=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        telefono=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        mision=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        vision=new TextView(requireContext());
        //razon.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        ordenTV=view.findViewById(R.id.ordenLabel);
        //INPUTS
        razonInput=new EditText(requireContext());
        rucInput=new EditText(requireContext());
        direccionInput=new EditText(requireContext());
        mailInput=new EditText(requireContext());
        telefonoInput=new EditText(requireContext());
        misionInput=new EditText(requireContext());
        visionInput=new EditText(requireContext());
        //CONTENEDORES

        razonContenedor =view.findViewById(R.id.razonContenedor);
        rucContenedor =view.findViewById(R.id.rucContenedor);
        direccionContenedor =view.findViewById(R.id.direccionContenedor);
        mailContenedor =view.findViewById(R.id.mailContenedor);
        telefonoContenedor =view.findViewById(R.id.telefonoContenedor);
        misionContenedor=view.findViewById(R.id.misionContenedor);
        visionContenedor =view.findViewById(R.id.visionContenedor);

        recibir=getArguments();
        if (recibir != null) {

            empresa = (Empresa) recibir.getSerializable("empresa");

            orden= recibir.getString("orden");
            razonContenedor.removeAllViews();
            rucContenedor.removeAllViews();
            direccionContenedor.removeAllViews();
            mailContenedor.removeAllViews();
            telefonoContenedor.removeAllViews();
            misionContenedor.removeAllViews();
            visionContenedor.removeAllViews();
            switch (empresa.getEstado()){
                case "Activo":
                    status.setImageResource(R.drawable.activo);
                    break;
                case "Inactivo":
                    status.setImageResource(R.drawable.inactivo);
                    break;
                case "Eliminado":
                    status.setImageResource(R.drawable.eliminado);
                    break;
                default: status.setImageResource(R.drawable.desconocido);
            }
            if(orden.equalsIgnoreCase("Eliminar")||orden.equalsIgnoreCase("Desactivar")
                    ||orden.equalsIgnoreCase("Reactivar")){
                razon.setText(empresa.getRazon());
                ruc.setText(empresa.getRuc()+"");
                direccion.setText(empresa.getDireccion());
                mail.setText(empresa.getMail());
                telefono.setText(empresa.getTelefono()+"");
                mision.setText(empresa.getMision());
                vision.setText(empresa.getVision());



                razonContenedor.addView(razon);
                rucContenedor.addView(ruc);
                direccionContenedor.addView(direccion);
                mailContenedor.addView(mail);
                telefonoContenedor.addView(telefono);
                misionContenedor.addView(mision);
                visionContenedor.addView(vision);
            }
            if(orden.equalsIgnoreCase("Modificar")){
                razonInput.setText(empresa.getRazon());
                rucInput.setText(empresa.getRuc()+"");
                direccionInput.setText(empresa.getDireccion());
                mailInput.setText(empresa.getMail());
                telefonoInput.setText(empresa.getTelefono()+"");
                misionInput.setText(empresa.getMision());
                visionInput.setText(empresa.getVision());
                razonInput.setTextSize(15);
                rucInput.setTextSize(15);
                direccionInput.setTextSize(15);
                mailInput.setTextSize(15);
                telefonoInput.setTextSize(15);
                misionInput.setTextSize(15);
                visionInput.setTextSize(15);

                rucInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                telefonoInput.setInputType(InputType.TYPE_CLASS_NUMBER);


                razonContenedor.addView(razonInput);
                rucContenedor.addView(rucInput);
                direccionContenedor.addView(direccionInput);
                mailContenedor.addView(mailInput);
                telefonoContenedor.addView(telefonoInput);
                misionContenedor.addView(misionInput);
                visionContenedor.addView(visionInput);
            }
            if(orden.equalsIgnoreCase("Agregar")){
                razonInput.setHint("Ingrese razon social");
                rucInput.setHint("Ingrese ruc");
                direccionInput.setHint("Ingrese direccion física");
                mailInput.setHint("Ingrese correo");
                telefonoInput.setHint("Ingrese numero de telefono");
                misionInput.setHint("Ingrese mision de la empresa");
                visionInput.setHint("Ingrese vision de la empresa");
                razonInput.setTextSize(15);
                rucInput.setTextSize(15);
                direccionInput.setTextSize(15);
                mailInput.setTextSize(15);
                telefonoInput.setTextSize(15);
                misionInput.setTextSize(15);
                visionInput.setTextSize(15);


                razonContenedor.addView(razonInput);
                rucContenedor.addView(rucInput);
                direccionContenedor.addView(direccionInput);
                mailContenedor.addView(mailInput);
                telefonoContenedor.addView(telefonoInput);
                misionContenedor.addView(misionInput);
                visionContenedor.addView(visionInput);
            }

            ordenTV.setText("¿"+orden+"?");


        }

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String razon="", direccion="", mail="", mision="",vision="",telefono="",ruc="";
                if(orden.equalsIgnoreCase("Agregar")||orden.equalsIgnoreCase("Modificar")) {
                    razon = razonInput.getText().toString();
                    direccion = direccionInput.getText().toString();
                    mail = mailInput.getText().toString();
                    mision = misionInput.getText().toString();
                    vision = visionInput.getText().toString();
                    telefono = telefonoInput.getText().toString();
                    ruc = rucInput.getText().toString();
                    if (razon.isEmpty() || direccion.isEmpty() || mail.isEmpty() || mision.isEmpty()
                            || vision.isEmpty() || telefono.isEmpty() || ruc.isEmpty()) {
                        Toast.makeText(requireContext(), "Llenar todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        if (orden.equalsIgnoreCase("Agregar")) {
                            empresa = new Empresa(razon, Integer.parseInt(ruc)
                                    , direccion, mail,
                                    Integer.parseInt(telefono),
                                    "activo", mision, vision, 0);
                            mostrarDialogo(empresa);
                        } else {
                            empresa = new Empresa(razon, Integer.parseInt(ruc)
                                    , direccion, mail,
                                    Integer.parseInt(telefono),
                                    "activo", mision, vision, ((Empresa)recibir.getSerializable("empresa")).getCodigo());
                            databaseSingleton.agregarDato(empresa);
                            ((ListaDatos) requireActivity()).onBackPressed();
                        }

                    }
                }
                switch (orden){
                    case "Eliminar":
                        empresa.setEstado(getResources().getString(R.string.eliminado));
                        Toast.makeText(requireContext(),"Eliminado",Toast.LENGTH_SHORT).show();
                        break;
                    case "Desactivar":
                        empresa.setEstado(getResources().getString(R.string.inactivo));
                        break;
                    case "Reactivar":
                        empresa.setEstado(getResources().getString(R.string.activo));
                        break;
                }
                databaseSingleton.agregarDato(empresa);
                ((ListaDatos) requireActivity()).onBackPressed();

            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListaDatos) requireActivity()).onBackPressed();
            }
        });
        return view;
    }
    private void mostrarDialogo(Empresa empresa1) {
        // Crear un objeto AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        // Obtener el layout inflater
        LayoutInflater inflater = getLayoutInflater();

        // Inflar y establecer el diseño personalizado para el diálogo
        View view = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(view);

        // Configurar otros elementos del diálogo (título, botones, etc.)
        builder.setTitle("Ingresar código");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                EditText editText = view.findViewById(R.id.codigoEmergente);
                String codigo = editText.getText().toString();
                if(codigo.isEmpty()){
                    Toast.makeText(requireContext(), "Campo vacío", Toast.LENGTH_SHORT).show();
                }else{
                    empresa1.setCodigo(Integer.parseInt(codigo));
                    databaseSingleton.agregarDato(empresa1);
                    ((ListaDatos) requireActivity()).onBackPressed();
                }

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Usuario hizo clic en Cancelar
                dialog.cancel();
            }
        });

        // Mostrar el diálogo
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}