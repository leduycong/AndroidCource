package com.example.a8_5_2019;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    float fltPrice = 0;
    float dblDiscount = 0;
    int intExchange = 1;
    String strMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Display(View view){

        EditText name =findViewById(R.id.txtName);
        EditText Phone = findViewById(R.id.txtPhone);
        Spinner spinnerCurrency = findViewById(R.id.currencySpiner);

        String currency = spinnerCurrency.getSelectedItem().toString();

        if (currency.equals("USD"))
            intExchange= 20000;
        else
            intExchange= 1;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (name.getText().toString().isEmpty()){


            builder.setTitle("Error");
            builder.setMessage("Don't let your Name empty, please!");

            builder.setPositiveButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();

        }else if (Phone.getText().toString().isEmpty()){


            builder.setTitle("Error");
            builder.setMessage("Don't let your Phone number empty, please!");

            builder.setPositiveButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();

        }else if(fltPrice == 0){


            builder.setTitle("Error");
            builder.setMessage("Please select your seat type!");

            builder.setPositiveButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else{
            String price = String.format("%.2f", (fltPrice - (fltPrice * dblDiscount)) / intExchange) ;
            strMessage =    "Your name: " + name.getText().toString() + "\n" +
                            "Your Phone: " + Phone.getText().toString() + "\n"  +
                            "Your ticket Price :" + price + " " + currency;

            builder.setTitle("Successful!");
            builder.setMessage(strMessage);

            builder.setPositiveButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }

    public void exit(View view) {
        finish();
    }

    public void onRadioButtonClick(View view) {
        boolean check = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbtnSeat:
                if (check)
                    fltPrice = 600000;
                break;
            case R.id.rbtnBerth:
                if (check)
                    fltPrice = 1200000;
                break;
        }
    }

    public void onCheck(View view) {
        boolean check = ((CheckBox) view).isChecked();
        if((view.getId() == R.id.cbxVip) && check)
                dblDiscount = (float) 0.3;
        else
                dblDiscount = 0;
    }


}