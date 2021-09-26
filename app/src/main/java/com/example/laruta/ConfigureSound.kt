package com.example.laruta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlin.system.exitProcess

class ConfigureSound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_sound)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sound, menu )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main -> {
                finish()
                startActivity(Intent( this, MainActivity::class.java))
                true
            }
            R.id.action_get_messages -> {
                finish()
                startActivity(Intent( this, GetMessages::class.java))
                true
            }
            R.id.action_exit -> {
                exitProcess(0)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}