package com.example.ejercicioandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ejercicioandroid1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val listaPersonas=mutableListOf<Persona>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 1..6){

            listaPersonas.add(Persona("Persona $i", Random.nextInt(18,25), Random.nextInt(0,10),Random.nextInt(160,180)))
        }

        val numeroAleatorio=Random.nextInt(0,3)

        when(numeroAleatorio){

            0->{listaPersonas.sortByDescending { it.nombre }
                binding.textView2.text="Ordenado de mayor a menor por nombre."}

            1-> {
                listaPersonas.sortDescending()
                binding.textView2.text="Ordenado de mayor a menor por edad."
            }
            2-> {
                listaPersonas.sort()
                binding.textView2.text="Ordenado de menor a mayor por edad."
            }

            3-> {
                listaPersonas.sortByDescending { it.altura }
                binding.textView2.text="Ordenado de mayor a menor por altura."
            }
            else -> Log.e("Carlos","Error inesperado")

        }

        var cadena=""

        listaPersonas.forEach {
            cadena+= "$it"
            //binding.textView1.text+=it.toString()
        }
        binding.textView1.text=cadena

    }
}



data class Persona(var nombre: String, var edad: Int, var nota: Int, var altura: Int): Comparable<Persona>{

    override fun toString(): String {
        return "Soy $nombre, tengo $edad años, mido $altura y mi nota media es de $nota \n"
    }

    override fun compareTo(other: Persona): Int {
        return edad - other.edad
    }

}