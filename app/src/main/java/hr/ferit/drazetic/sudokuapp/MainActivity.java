package hr.ferit.drazetic.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    public static WeakReference<MainActivity> weakActivity;
    public static MainActivity getmInstanceActivity(){
        return weakActivity.get();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weakActivity = new WeakReference<>(MainActivity.this);

        Intent intent = getIntent();

        TextView textView1=(TextView) findViewById(R.id.textselectedgrid);
        int numb=intent.getIntExtra(StartActivity.EXTRA_NUMBER,0);
        textView1.setText("Praznih ćelija u sudoku je : "+numb);

        Globalstwo g=Globalstwo.getInstance();
        g.setData(numb);
        GameEngine.getInstance().createGrid(this);
    }
    public void solvedSetText(){
        TextView textView1=(TextView) findViewById(R.id.textselectedgrid);
        textView1.setText("ČESTITAMO! RIJEŠILI STE SUDOKU!");
        textView1.setTextColor(Color.BLUE);
    }

}
