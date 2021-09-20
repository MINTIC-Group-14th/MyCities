package com.mintic.myaddressbook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var mPois: ArrayList<Poi>
    private lateinit var mAdapter: PoisAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.contact_list)
        setupRecyclerView()
        generateContacts()
//        mContacts = createMockContacts()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mPois = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = PoisAdapter(mPois)
        recycler.adapter = mAdapter
    }

    /**
     * Generates mock contact data to populate the UI from a JSON file in the
     * assets directory, called from the options menu.
     */
    private fun generateContacts() {
        val contactsString = readContactJsonFile()
        try {
            val contactsJson = JSONArray(contactsString)
            for (i in 0 until contactsJson.length()) {
                val contactJson = contactsJson.getJSONObject(i)
                val contact = Poi(
                    contactJson.getString("poiName"),
                    contactJson.getString("poiPuntuation"),
                    contactJson.getString("poiDescription"),
                    contactJson.getString("poiPhotoURL")
                )
                Log.d(TAG, "generateContacts: $contact")
                mPois.add(contact)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    /**
     * Reads a file from the assets directory and returns it as a string.
     *
     * @return The resulting string.
     */
    private fun readContactJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = assets.open("mock_pois.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }

    private fun createMockContacts(): ArrayList<Poi> {
        return arrayListOf(
            Poi("Jose", "Perez", "jose@gmail.com", "Alta"),
            Poi("Jose", "Perez", "jose@gmail.com", "Media"),
            Poi("Jose", "Perez", "jose@gmail.com", "Baja")
        )
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}