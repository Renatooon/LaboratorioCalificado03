package com.cortez.renato.laboratoriocalificado03

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cortez.renato.laboratoriocalificado03.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding
    private val viewModel: ComprobarConexion by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.teachers.observe(this, { teachers ->
            binding.recyclerView.adapter = ItemsProfesor(this, teachers)
        })

        viewModel.fetchTeachers()
    }
}

