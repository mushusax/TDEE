package com.example.tdee


import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ConfigurationFragment : Fragment(), View.OnClickListener {

    lateinit var btnStartDate: Button
    lateinit var txtStartDate: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnStartDate = view.findViewById(R.id.button_start_date)
        btnStartDate.setOnClickListener(this)

        txtStartDate = view.findViewById(R.id.text_start_date)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button_start_date -> {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                val newFragment = DatePickerFragment()
                newFragment.show(fragmentManager!!, "datePicker")
            }
        }
    }
}
