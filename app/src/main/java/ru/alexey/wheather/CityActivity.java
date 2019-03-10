package ru.alexey.wheather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity {

    private TextView textCityName;
    private TextView textCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        init();
        getAddData();
    }

    private void init() {
        String cityName;
        try {
            cityName = getIntent().getExtras().getString(MainActivity.CITY, "empty search");
        } catch (Exception e) {
            e.printStackTrace();
            cityName = "empty search";
        }
        textCityName = findViewById(R.id.text_view_city_name);
        textCityName.setText(cityName);
        textCell = findViewById(R.id.linear_layout_cell);
        textCell.setText(DataWeather.getTemperature());
    }

    private void getAddData(){
        boolean [] showAddData;
        try {
            showAddData = getIntent().getExtras().getBooleanArray(MainActivity.DATA);
        } catch (Exception e) {
            e.printStackTrace();
            showAddData = null;
        }
        if (showAddData != null) {
            for (int i = 0 ; i < showAddData.length; i++){
                if (showAddData[i] && i == 0) {
                    textCell.append("\n " + DataWeather.getWind() + ",  " + DataWeather.getWindDirection());
                }
                if (showAddData[i] && i == 1) {
                    textCell.append("\n " + DataWeather.getHumidity());
                }
                if (showAddData[i] && i == 2) {
                    textCell.append("\n " + DataWeather.getPressure());
                }
            }
        }
    }
}
