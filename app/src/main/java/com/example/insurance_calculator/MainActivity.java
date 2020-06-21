package com.example.insurance_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // отслеживаем нажатие на кнопку "Рассчитать"
        calculateButton = (Button) findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Результат вычисления
                float result = 0F;
                // Франшиза
                boolean use_franchise =  false;
                // Считываем данные из выпадающих списков
                Spinner year = (Spinner) findViewById(R.id.spinner_year);
                String selected_year = year.getSelectedItem().toString();
                Spinner amount = (Spinner) findViewById(R.id.spinner_amount);
                String selected_amount = amount.getSelectedItem().toString();
                Spinner model = (Spinner) findViewById(R.id.spinner_model);
                String selected_model = model.getSelectedItem().toString();
                Spinner experience = (Spinner) findViewById(R.id.spinner_experience);
                String selected_experience = experience.getSelectedItem().toString();
                Spinner age = (Spinner) findViewById(R.id.spinner_age);
                String selected_age = age.getSelectedItem().toString();
                Spinner region = (Spinner) findViewById(R.id.spinner_region);
                String selected_region = region.getSelectedItem().toString();
                Spinner geography = (Spinner) findViewById(R.id.spinner_geography);
                String selected_geography = geography.getSelectedItem().toString();
                Spinner franchise = findViewById(R.id.spinner_franchise);
                String selected_franchise = franchise.getSelectedItem().toString();

                // Вычисляем основной тариф
                // Определяем наличие франшизы
                if(selected_franchise.equals("С франшизой")) {
                    use_franchise = true;
                }
                 // Если есть
                if(use_franchise){
                     // Авто 2019, 2018, 2017 года выпуска
                    if(selected_year.equals("2019") || selected_year.equals("2018") || selected_year.equals("2017")){
                        switch (selected_amount){
                            case "До 10.000 EUR":
                                result = 4F;
                                if(selected_model.equals("DACIA") || selected_model.equals("NISSAN")){
                                    result *= 1.05F;
                                }
                                if(selected_model.equals("FORD") || selected_model.equals("TOYOTA")){
                                    result *= 0.95F;
                                }
                                break;
                            case "10 - 25.000 EUR":
                                result = 4.2F;
                                if(selected_model.equals("HYUNDAI") || selected_model.equals("NISSAN") || selected_model.equals("MAZDA") || selected_model.equals("KIA")){
                                    result *= 1.05F;
                                }
                                if(selected_model.equals("DACIA") || selected_model.equals("TOYOTA") || selected_model.equals("MITSUBISHI")){
                                    result *= 0.95F;
                                }
                                break;
                            case "25 - 50.000 EUR":
                                result = 3.6F;
                                if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("BMW")){
                                    result *= 0.95F;
                                }
                                break;
                            case "Более 50.000 EUR":
                                result = 3.42F;
                                break;
                        }
                    }
                     // Авто 2016, 2015, 2014 года выпуска
                    if(selected_year.equals("2016") || selected_year.equals("2015") || selected_year.equals("2014")){
                        switch (selected_amount){
                            case "До 10.000 EUR":
                                result = 4.4F;
                                if(selected_model.equals("DACIA") || selected_model.equals("NISSAN") || selected_model.equals("FORD") || selected_model.equals("KIA")){
                                    result *= 1.05F;
                                }
                                if(selected_model.equals("RENAULT") || selected_model.equals("SKODA") || selected_model.equals("MAZDA") || selected_model.equals("TOYOTA")){
                                    result *= 0.95F;
                                }
                            case "10 - 25.000 EUR":
                                result = 4.4F;
                                if(selected_model.equals("HYUNDAI") || selected_model.equals("NISSAN") || selected_model.equals("BMW") || selected_model.equals("VOLVO")){
                                    result *= 1.05F;
                                }
                                if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("TOYOTA") || selected_model.equals("VOLKSWAGEN") || selected_model.equals("SUBARU")){
                                    result *= 0.95F;
                                }
                                break;
                            case "25 - 50.000 EUR":
                                result = 4.2F;
                                if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("BMW") || selected_model.equals("TOYOTA")){
                                    result *= 0.95F;
                                }
                                break;
                            case "Более 50.000 EUR":
                                result = 3.99F;
                                break;
                        }
                    }
                     // Авто 2013, 2012 года выпуска
                    if(selected_year.equals("2013") || selected_year.equals("2012")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                                 result = 5.7F;
                                 break;
                             case "10 - 25.000 EUR":
                                 result = 5.4F;
                                 break;
                             case "25 - 50.000 EUR":
                             case "Более 50.000 EUR":
                                 result = 5F;
                                 break;
                         }
                     }
                     // Авто 2011 года выпуска
                    if(selected_year.equals("2011")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                             case "10 - 25.000 EUR":
                                 result = 6.05F;
                                 break;
                             case "25 - 50.000 EUR":
                             case "Более 50.000 EUR":
                                 result = 5.4F;
                                 break;
                         }
                     }
                }
                 // Если нет
                else{
                     // Авто 2019, 2018, 2017 года выпуска
                     if(selected_year.equals("2019") || selected_year.equals("2018") || selected_year.equals("2017")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                                 result = 5F;
                                 if(selected_model.equals("DACIA") || selected_model.equals("NISSAN")){
                                     result *= 1.05F;
                                 }
                                 if(selected_model.equals("FORD") || selected_model.equals("TOYOTA")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "10 - 25.000 EUR":
                                 result = 4.5F;
                                 if(selected_model.equals("HYUNDAI") || selected_model.equals("NISSAN") || selected_model.equals("MAZDA") || selected_model.equals("KIA")){
                                     result *= 1.05F;
                                 }
                                 if(selected_model.equals("DACIA") || selected_model.equals("TOYOTA") || selected_model.equals("MITSUBISHI")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "25 - 50.000 EUR":
                                 result = 4.2F;
                                 if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("BMW")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "Более 50.000 EUR":
                                 result = 3.99F;
                                 break;
                         }
                     }
                     // Авто 2016, 2015, 2014 года выпуска
                     if(selected_year.equals("2016") || selected_year.equals("2015") || selected_year.equals("2014")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                                 result = 5.5F;
                                 if(selected_model.equals("DACIA") || selected_model.equals("NISSAN") || selected_model.equals("FORD") || selected_model.equals("KIA")){
                                     result *= 1.05F;
                                 }
                                 if(selected_model.equals("RENAULT") || selected_model.equals("SKODA") || selected_model.equals("MAZDA") || selected_model.equals("TOYOTA")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "10 - 25.000 EUR":
                                 result = 4.8F;
                                 if(selected_model.equals("HYUNDAI") || selected_model.equals("NISSAN") || selected_model.equals("BMW") || selected_model.equals("VOLVO")){
                                     result *= 1.05F;
                                 }
                                 if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("TOYOTA") || selected_model.equals("VOLKSWAGEN") || selected_model.equals("SUBARU")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "25 - 50.000 EUR":
                                 result = 4.5F;
                                 if(selected_model.equals("MERCEDES-BENZ") || selected_model.equals("BMW") || selected_model.equals("TOYOTA")){
                                     result *= 0.95F;
                                 }
                                 break;
                             case "Более 50.000 EUR":
                                 result = 4.28F;
                                 break;
                         }
                     }
                     // Авто 2013, 2012 года выпуска
                     if(selected_year.equals("2013") || selected_year.equals("2012")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                                 result = 6.4F;
                                 break;
                             case "10 - 25.000 EUR":
                                 result = 5.8F;
                                 break;
                             case "25 - 50.000 EUR":
                             case "Более 50.000 EUR":
                                 result = 5.2F;
                                 break;
                         }
                     }
                     // Авто 2011 года выпуска
                     if(selected_year.equals("2011")){
                         switch (selected_amount){
                             case "До 10.000 EUR":
                             case "10 - 25.000 EUR":
                                 result = 6.9F;
                                 break;
                             case "25 - 50.000 EUR":
                             case "Более 50.000 EUR":
                                 result = 6.1F;
                                 break;
                         }
                     }
                }

                // Вычмсляем дополнительные коэффициенты
                // !!! Коэффициент "Марка ТС учтён" при вычислении основного тарифа

                // Возраст/Стаж
                if(selected_age.equals("18 – 25 лет") || selected_age.equals("Не указан")){
                    result *= 1.05F;
                }
                else if (selected_age.equals("25 – 45 лет")){
                    switch(selected_experience){
                        case "До 5 лет":
                        case "Не указан":
                            result *= 1.05F;
                            break;
                        default:
                            result *= 1F;
                            break;
                    }
                }
                else{
                    switch(selected_experience){
                        case "5 – 10 лет":
                        case "Более 10 лет":
                            result *= 0.95F;
                            break;
                        case "Не указан":
                            result *= 1.05F;
                            break;
                        default:
                            result *= 1F;
                            break;
                    }
                }

                // В зависимости от региона Молдавии
                if(selected_region.equals("Другой")){
                    result *= 0.97F;
                }

                // В зависимости от страныы
                if(selected_geography.equals("Республика Молдова")){
                    result -= 0.2F;
                }

                displayResult(result);
            }
        });


    }

    private void displayResult(float result) {
        TextView new_result = findViewById(R.id.textView_result);
        Float.toString(result);
        new_result.setText(String.format("%.2f",result));
    }
}
