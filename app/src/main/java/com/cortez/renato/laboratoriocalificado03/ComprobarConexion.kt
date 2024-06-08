package com.cortez.renato.laboratoriocalificado03

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ComprobarConexion : ViewModel() {
    private val _teachers = MutableLiveData<List<Profesor>>()
    val teachers: LiveData<List<Profesor>> get() = _teachers

    fun fetchTeachers() {
        viewModelScope.launch {
            try {
                val response = UrlConexion.instance.getTeachers()
                if (response.isSuccessful) {
                    _teachers.value = response.body()?.teachers
                } else {
                    // fallo fatal
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
