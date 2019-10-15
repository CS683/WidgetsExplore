package edu.bu.metcs.widgetsexplore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   get the reference of the submit button
        Button submitBtn = findViewById(R.id.buttonId_submit);
        // register the button with an OnClickListener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSubmit(view);
            }
        });
    }



    public void onClickSubmit(View v){
        // get the name from the EditText
        EditText nameEditText = findViewById(R.id.editTextId_name);
        String name = nameEditText.getText().toString();

        // get the country name from the Spinner
        Spinner countrySpinner = findViewById(R.id.spinnerId_country);
        String country = countrySpinner.getSelectedItem().toString();

        // check if the user is an adult from CheckBox
        CheckBox adultCheckBox = findViewById(R.id.checkBoxId_age);
        Boolean isAdult = adultCheckBox.isChecked();

        // get the gender from the RadioGroup
        RadioGroup genderRadioGroup = findViewById(R.id.radioGroupId_gender);
        String gender = "";

        switch (genderRadioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButtonId_female:
                gender = "female";
                break;
            case R.id.radioButtonId_male:
                gender = "male";
                break;
            default: break;
        }

        // get isPublic from the Switch
        Switch publicSwitch = findViewById(R.id.switchId_public);
        boolean isPublic = publicSwitch.isChecked();

        // get comments from the Multiline EditText
        EditText commentsEditText = findViewById(R.id.editTextId_comments);
        String comments =  commentsEditText.getText().toString();

        // compose a message from the above information
        String msg =  " Here is your information: \n" + name + " in " +
                country + (isAdult? " \n 18 years or old ": "\n 18 years younger ") +
                gender + "\n Your info is made " +
                (isPublic? "public ":" private ") +
                "\n Your comments: \n" + comments;


        //set the message in the TextView
        TextView infoTextView = findViewById(R.id.textViewId_info);
        infoTextView.setText(msg);

        // display a toast message
        Toast.makeText(this, "Submit successfully!", Toast.LENGTH_LONG).show();

        nameEditText.setText("");
        countrySpinner.setId(0);
        adultCheckBox.setChecked(false);
        genderRadioGroup.clearCheck();
        publicSwitch.setChecked(false);
        commentsEditText.setText("");
        nameEditText.requestFocus();
    }

}
