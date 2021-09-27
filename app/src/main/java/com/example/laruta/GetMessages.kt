package com.example.laruta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlin.system.exitProcess

class GetMessages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_messages)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_messages, menu )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main -> {
                finish()
                startActivity(Intent( this, MainActivity::class.java))
                true
            }
            R.id.action_configure_sound -> {
                finish()
                startActivity(Intent( this, ConfigureSound::class.java))
                true
            }
            R.id.action_notifications -> {
                item.setChecked(true);
                true
            }
            R.id.action_sound -> {
                item.setChecked(true);
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