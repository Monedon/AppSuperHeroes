package com.example.appsuperheroes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsuperheroes.model.Heroes
import com.example.appsuperheroes.api.HeroesRep
import kotlinx.coroutines.launch

class HeroesViewModel: ViewModel() {

    val repository= HeroesRep()
    val superList = repository.superList
    val detailHero=repository.detailHero
    private val detail= MutableLiveData<Heroes>()


    init {
        viewModelScope.launch {
            repository.getSuperHeroFromApi()
        }

    }
    private lateinit var seledtedHeroes:Heroes



    fun setSelected(heroes:Heroes)  {

        seledtedHeroes=heroes
    }
    fun getDetail() : LiveData<Heroes> {
        return repository.getHeroes(seledtedHeroes.id)
    }

}