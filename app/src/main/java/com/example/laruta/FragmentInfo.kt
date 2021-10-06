package com.example.laruta

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class FragmentInfo : Fragment() {

    private lateinit var place: String
    private lateinit var description: String
    private lateinit var temp: String
    private lateinit var location: String
    private lateinit var interest: String
    private lateinit var t_place: TextView
    private lateinit var t_description: TextView
    private lateinit var t_temp: TextView
    private lateinit var t_location: TextView
    private lateinit var t_interest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            place = it.getString(ARG_PLACE, "")
            description = it.getString(ARG_DESCRIPTION, "")
            temp = it.getString(ARG_TEMP, "")
            location = it.getString(ARG_LOCATION, "")
            interest = it.getString(ARG_INTEREST, "")
        }
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        t_description = view.findViewById(R.id.tv_description)
        t_temp = view.findViewById(R.id.tv_temp)
        t_location = view.findViewById(R.id.tv_location)
        t_interest = view.findViewById(R.id.tv_interest)

    }

    override fun onStart() {
        super.onStart()
        readBundle(arguments)
        updateDisplay()
    }

    private fun readBundle(bundle: Bundle?) {
        if (bundle != null) {
            place = bundle.getString("place", "")
            description = bundle.getString("description", "")
            temp = bundle.getString("temp", "")
            location = bundle.getString("location", "")
            interest = bundle.getString("interest", "")

        }
    }

    fun setName(place: String, description: String, temp: String, location: String,
                interest: String) {
        this.place = place
        this.description = description
        this.temp = temp
        this.location = location
        this.interest = interest
        updateDisplay()
    }

    private fun updateDisplay() {
        t_description.text = requireContext().getString(R.string.tx_description, description)
    }

    companion object {

        private const val TAG = "FragmentInfo"
        private const val ARG_PLACE = "place"
        private const val ARG_DESCRIPTION = "description"
        private const val ARG_TEMP = "temp"
        private const val ARG_LOCATION = "location"
        private const val ARG_INTEREST = "interest"
        const val FRAGMENT_INFO_TAG = "FragmentInfo"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param place Parameter 1.
         * @return A new instance of fragment FragmentB.
         */
        @JvmStatic
        fun newInstance(place: String, description: String, temp: String, location: String,
                        interest: String) =
            FragmentInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLACE, place)
                    putString(ARG_DESCRIPTION, description)
                    putString(ARG_TEMP, temp)
                    putString(ARG_LOCATION, location)
                    putString(ARG_INTEREST, interest)

                }
            }
    }

}