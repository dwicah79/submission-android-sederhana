// DetailActivity.kt
package com.example.submission_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.vapename)
        val tvDescription : TextView = findViewById(R.id.deskripsivape)


        val vapeData = intent.getParcelableExtra<DataVape>(MainActivity.INTENT_PARCELABLE)
        if (vapeData != null) {
            imgPhoto.setImageResource(vapeData.photo)
            tvName.text = vapeData.name
            tvDescription.text = vapeData.lengkap
        }
    }
}
