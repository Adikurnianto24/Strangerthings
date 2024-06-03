package com.adiandroid.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacter: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacter = findViewById(R.id.rv_Character)
        rvCharacter.setHasFixedSize(true)
        list.addAll(getListCharaters())
        showRecyclerList()
    }

    private fun getListCharaters(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val databg = resources.obtainTypedArray(R.array.data_bg)
        val datacast= resources.getStringArray(R.array.cast_name)
        val dataage= resources.getStringArray(R.array.age_name)
        val listbg= resources.obtainTypedArray(R.array.list_bg)

        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            val Character = Character(dataName[i], dataDescription[i],
                dataPhoto.getResourceId(i, -1),databg.getResourceId(i, -1),datacast[i], dataage[i],listbg.getResourceId(i, -1))
            listCharacter.add(Character)
        }
        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list)
        rvCharacter.adapter = listCharacterAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCharacter.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCharacter.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}