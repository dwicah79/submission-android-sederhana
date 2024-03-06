package com.example.submission_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var tombol : Button
    private lateinit var vape: RecyclerView
    private val list = ArrayList<DataVape>()

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vape = findViewById(R.id.datavape)
        vape.setHasFixedSize(true)

        list.addAll(getListDataVape())
        showRecyclerList()

        tombol = findViewById(R.id.button_about_me)
        tombol.setOnClickListener{
            startActivity(Intent(this,DataSaya::class.java))
        }
    }



    private fun showRecyclerList() {
        vape.layoutManager = LinearLayoutManager(this)
        val listVapeAdapter = ListAdapter(list)
        vape.adapter = listVapeAdapter
    }

    private fun getListDataVape(): ArrayList<DataVape> {
        val dataName = resources.getStringArray(R.array.datanama)
        val dataDescription = resources.getStringArray(R.array.desklengkap)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLengkap = resources.getStringArray(R.array.desksingkat)
        val listVape = ArrayList<DataVape>()
        for (i in dataName.indices) {
            val vape = DataVape(dataName[i], dataLengkap[i],dataDescription[i],dataPhoto.getResourceId(i, -1))
            listVape.add(vape)
        }
        return listVape
    }

    }
