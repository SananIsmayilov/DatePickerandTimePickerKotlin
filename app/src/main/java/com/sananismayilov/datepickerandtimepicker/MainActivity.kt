package com.sananismayilov.datepickerandtimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.sananismayilov.datepickerandtimepicker.databinding.ActivityMainBinding
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minutes = calendar.get(Calendar.MINUTE)

            val timepicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.editTextText.setText("$hourOfDay : $minute")
            },hour,minutes,true)

            timepicker.setTitle("Select time")
            timepicker.setButton(DialogInterface.BUTTON_POSITIVE,"Seç",timepicker)
            timepicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Ləğv et",timepicker)

            timepicker.show()

        }


        binding.editTextText2.setOnClickListener{
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayofmonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.editTextText2.setText("$dayofmonth / $month / $year")
            },year,month,dayofmonth)

            datePickerDialog.setTitle("Select date")

            datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Seç",datePickerDialog)
            datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Ləğv et",datePickerDialog)

            datePickerDialog.show()

        }
    }

}