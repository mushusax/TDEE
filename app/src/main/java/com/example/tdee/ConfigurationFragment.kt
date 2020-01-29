package com.example.tdee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_configuration.view.*

/**
 * A simple [Fragment] subclass.
 */
class ConfigurationFragment : Fragment(), View.OnClickListener {

    lateinit var btnStartDate: Button
    lateinit var txtStartDate: TextView
    lateinit var spinnerWeight: Spinner
    lateinit var spinnerEnergy: Spinner
    lateinit var txtStartWeight: EditText
    lateinit var txtGoalWeight: EditText
    lateinit var txtGainPerWeek: EditText
    lateinit var txtTargetDailySurplus: TextView

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

        // Set contents of weight spinner
        spinnerWeight = view.findViewById(R.id.spinner_weight)
        ArrayAdapter.createFromResource(
            context!!,
            R.array.units_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerWeight.adapter = adapter
        }

        // Set contents of energy spinner
        spinnerEnergy = view.findViewById(R.id.spinner_energy)
        ArrayAdapter.createFromResource(
            context!!,
            R.array.energy_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerEnergy.adapter = adapter
        }

        txtStartWeight = view.findViewById(R.id.text_initial_weight)
        txtGoalWeight = view.findViewById(R.id.text_goal_weight)
        txtGainPerWeek = view.findViewById(R.id.text_gain_per_week)
        txtTargetDailySurplus = view.findViewById(R.id.text_target_daily_surplus)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button_start_date -> {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                val newFragment = DatePickerFragment()
                newFragment.show(fragmentManager!!, "datePicker")
            }

            R.id.text_gain_per_week -> {
                // Do not return anything if initial weight and goal weight are null
            }
        }
    }


}
