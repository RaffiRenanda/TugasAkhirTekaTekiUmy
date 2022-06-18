package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class FakTeknik extends AppCompatActivity {
    RadioGroup rg1, rg2, rg3, rg4, rg5;
    private Button submit;
    private RadioButton jawaban1, jawaban2, jawaban3, jawaban4, jawaban5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fak_teknik);

        rg1 = findViewById(R.id.radiogroup1);
        rg2 = findViewById(R.id.radiogroup2);
        rg3 = findViewById(R.id.radiogroup3);
        rg4 = findViewById(R.id.radiogroup4);
        rg5 = findViewById(R.id.radiogroup5);

        submit = findViewById(R.id.buttonSimpanNilai);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int skorA = rg1.getCheckedRadioButtonId();
                jawaban1 = (RadioButton) findViewById(skorA);

                int skorB = rg2.getCheckedRadioButtonId();
                jawaban2 = (RadioButton) findViewById(skorB);

                int skorC = rg3.getCheckedRadioButtonId();
                jawaban3 = (RadioButton) findViewById(skorC);

                int skorD = rg4.getCheckedRadioButtonId();
                jawaban4 = (RadioButton) findViewById(skorD);

                int skorE = rg5.getCheckedRadioButtonId();
                jawaban5 = (RadioButton) findViewById(skorE);


                int value = 0; // menampung nilai
                if(jawaban1.getText().toString().toLowerCase().equals("asroni")){
                    value = value+20;
                }
                if(jawaban2.getText().toString().toLowerCase().equals("aris widyo nugroho")){
                    value = value+20;
                }
                if(jawaban3.getText().toString().toLowerCase().equals("teknik elektro medis")){
                    value = value+20;
                }
                if(jawaban4.getText().toString().toLowerCase().equals("f4")){
                    value = value+20;
                }
                if(jawaban5.getText().toString().toLowerCase().equals("kmte")){
                    value = value+20;
                }


                Intent inten = new Intent(FakTeknik.this, HasilActivity.class);
                inten.putExtra("value1", value);
                startActivity(inten);
                finish();
            }
        });
    }
}