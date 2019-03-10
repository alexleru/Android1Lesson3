package ru.alexey.wheather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private SwitchCompat [] switchCompat = new SwitchCompat[3];
    final static String CITY = "CITY";
    final static String DATA = "DATA";
    private boolean [] showAddData = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        textView = findViewById(R.id.weather);
        textView.setText(getString(R.string.label));
        editText = findViewById(R.id.edit_text);
        switchCompat[0] = findViewById(R.id.show_wind);
        switchCompat[1] = findViewById(R.id.show_humidity);
        switchCompat[2] = findViewById(R.id.show_pressure);
    }

    public void onClickBtnSearch(View view) {
        Intent intent = new Intent(this, CityActivity.class);
        intent.putExtra(CITY, editText.getText().toString());
        getDataFromSwitchCompat();
        intent.putExtra(DATA, showAddData);
        this.startActivity(intent);
    }

    public void getDataFromSwitchCompat(){
        for (int i = 0; i < showAddData.length; i++){
                showAddData[i] = switchCompat[i].isChecked();
        }
    }
}
