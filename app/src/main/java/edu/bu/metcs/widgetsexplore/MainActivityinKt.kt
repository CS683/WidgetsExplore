package edu.bu.metcs.widgetsexplore

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// This class is the same as MainActivity.java, but in kotlin
class MainActivityinKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the reference of the submit button
        buttonId_submit.setOnClickListener { view -> onClickSubmit(view) }
    }

    fun onClickSubmit(v: View) {
        // get the name from the EditText
        val name = editTextId_name.text.toString()

        // get the country name from the Spinner
        val country = spinnerId_country.selectedItem.toString()

        // check if the user is an adult from CheckBox
        val isAdult = checkBoxId_age.isChecked

        // get the gender from the RadioGroup
        var gender = ""

        when (radioGroupId_gender.checkedRadioButtonId) {
            R.id.radioButtonId_female -> gender = "female"
            R.id.radioButtonId_male -> gender = "male"
            else -> {
            }
        }

        // get isPublic from the Switch
        val isPublic = switchId_public.isChecked

        // get comments from the Multiline EditText
        val comments = editTextId_comments.text.toString()

        // compose a message from the above information
        val msg = " Here is your information: \n" + name + " in " +
                country + (if (isAdult) " \n 18 years or old " else "\n 18 years younger ") +
                gender + "\n Your info is made " +
                (if (isPublic) "public " else " private ") +
                "\n Your comments: \n" + comments


        //set the message in the TextView
        textViewId_info.text = msg


        // display a toast message
        Toast.makeText(this, "Submit successfully!", Toast.LENGTH_LONG).show()

        editTextId_name.setText("")
        spinnerId_country.id = 0
        checkBoxId_age.isChecked = false
        radioGroupId_gender.clearCheck()
        switchId_public.isChecked = false
        editTextId_comments.setText("")
        editTextId_name.requestFocus()
    }

}
