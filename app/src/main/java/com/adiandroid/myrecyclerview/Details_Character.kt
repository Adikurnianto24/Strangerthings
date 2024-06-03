package com.adiandroid.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details_Character : AppCompatActivity() {
    companion object {
        const val extraname = "EXTRA_NAME"
        const val extradesc = "EXTRA_DESC"
        const val extrapic = "EXTRA_PIC"
        const val extrabg = "EXTRA_BG"
        const val extracast = "EXTRA_CAST"
        const val extraage = "EXTRA_AGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(extraname)
        val desc = intent.getStringExtra(extradesc)
        val pic = intent.getIntExtra(extrapic, 0)
        val bg = intent.getIntExtra(extrabg, 0)
        val cast = intent.getStringExtra(extracast)
        val age = intent.getStringExtra(extraage)

        val nametext: TextView = findViewById(R.id.character_name)
        val desctext: TextView = findViewById(R.id.character_desc)
        val crewpic: ImageView = findViewById(R.id.character_pic)
        val charbg: ImageView = findViewById(R.id.character_bg)
        val casttext: TextView = findViewById(R.id.char_cast)
        val agetext: TextView = findViewById(R.id.char_age)

        crewpic.setImageResource(pic)
        charbg.setImageResource(bg)

        nametext.text = name
        desctext.text = desc
        casttext.text = cast
        agetext.text = age

        val shareButton = findViewById<Button>(R.id.share_button)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this character: $name - $desc")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}