package com.rdc.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rdc.glide.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /* Glide es una librería para Android introducida por Google, utilizada para descargar
     y guardar en memoria cache las imágenes que se desean mostrar en nuestras aplicaciones.
     Esta librería nos simplifica el proceso de cargar imágenes desde una url */

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnconsulta.setOnClickListener(view1 -> { cargarPicture(); });

    }
    private void cargarPicture() {

        ImageView image = binding.imgpicture;

        //url donde se encuentra la imagen
        final String URL = "https://www.pngmart.com/files/2/Pokemon-PNG-Picture.png";

        // Cargando imagen desde debajo de la URL en imageView
        Glide.with(this)
                .load(URL)// cargamos la url
                .error(R.drawable.error)// imagen para mostrar si ocurre un error al cargar la imagen
                .placeholder(R.drawable.descarga)// imagen para mostrar temporalmente mientras se consigue la imagen remota
                //.circleCrop()// para mostrar la imagen en forma circular
                .into(image);// lugar donde se va a mostrar la imagen
    }
}