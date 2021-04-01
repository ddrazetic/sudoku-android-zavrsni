package hr.ferit.drazetic.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "hr.ferit.drazetic.sudokuapp.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button buttonStart =findViewById(R.id.startButton);
        EditText editText2 = (EditText) findViewById(R.id.edittext2);
        editText2.setFilters(new InputFilter[]{new InputFilterMinMax("1","80")});


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSudoku();
            }
        });


    }
    private void startSudoku(){


        EditText editText2 = (EditText) findViewById(R.id.edittext2);

        int number=30;

        try {
            number = Integer.parseInt(editText2.getText().toString());
        } catch (NumberFormatException e) {

        }

        Intent intent=new Intent (this, MainActivity.class);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }

}
