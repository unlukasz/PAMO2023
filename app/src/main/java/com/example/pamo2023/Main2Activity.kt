package com.example.pamo2023;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    TextView BMIresult, scoreBMIText, scorePPMText, dinnerTittle, dinnerRecipe;
    float defaultValue;
    Button normalButton, wegeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BMIresult = findViewById(R.id.BMIresult);
        scoreBMIText = findViewById(R.id.scoreBMIText);
        scorePPMText = findViewById(R.id.scorePPMText);
        dinnerRecipe = findViewById(R.id.dinnerRecipe);
        dinnerTittle = findViewById(R.id.dinnerTittle);

        normalButton = findViewById((R.id.normalButton));
        wegeButton = findViewById((R.id.wegeButton));

        String resultBMIVariable = getIntent().getStringExtra("resultBMIVariable");
        float scoreBMIVariable = getIntent().getFloatExtra("scoreBMIVariable", defaultValue);
        float scorePPMVariable = getIntent().getFloatExtra("scorePPMVariable",defaultValue);

        String textBMI = "BMI wynosi: " + String.format("%.2f", scoreBMIVariable);
        String textPPM = "PPM wynosi: " + String.format("%.2f", scorePPMVariable);

        if(resultBMIVariable.equals("Niedowaga") || resultBMIVariable.equals("Nadwaga")){
            BMIresult.setTextColor(Color.rgb(255,127,80));
        }else if(resultBMIVariable.equals("Waga prawidłowa")){
            BMIresult.setTextColor(Color.rgb(0,255,0));
        }else{
            BMIresult.setTextColor(Color.rgb(255,0,0));
        }

        BMIresult.setText(resultBMIVariable);
        scoreBMIText.setText(textBMI);
        scorePPMText.setText(textPPM);
    }
    public void normalDinner(View view) {
        String normal = "Mięso z jelenia dokładnie umyj i osusz. Pokrój na kawałki o boku około 2 cm i dopraw solą i pieprzem.\n" +
                "Do miski włóż mięso. Wsyp rozmaryn i mąkę. Dokładnie wymiesza.\n" +
                "Cebulę pokrój w piórka. Marchewkę obierz i pokrój w kostkę.\n" +
                "Na dużej patelni rozgrzej olej i smaż na nim cebulę, aż się zeszkli. Cały czas mieszaj.\n" +
                "Dodaj marchewkę i mięso. Smaż, aż mięso całkowicie zmieni kolor. Cały czas mieszaj.\n" +
                "Wlej czerwone wino, passatę pomidorową i bulion warzywny. Dodaj liście laurowe, ziarna pieprzu i ziela angielskiego. Wymieszaj i duś pod przykryciem około godziny, aż mięso będzie miękkie.\n" +
                "Podawaj na gorąco z makaronem, kaszą lub ulubionym pieczywem.";
        dinnerTittle.setVisibility(View.VISIBLE);
        dinnerRecipe.setVisibility(View.VISIBLE);
        dinnerTittle.setText("Gulasz z jelenia");
        dinnerRecipe.setText(normal);
    }

    public void wegeDinner(View view) {
        String wege = "Piekarnik rozgrzej do 230 stopni. Dużą blachę wyłóż papierem do pieczenia i posmaruj 1 łyżką oleju.\n" +
                "Obraną dynię i ziemniaki pokrój na kostkę o boku około 1 cm.\n" +
                "Obrane pieczarki pokrój na połówki. Cebulę pokrój na niezbyt cienkie piórka\n" +
                "Warzywa rozłóż jedną warstwą na blasze wyłożonej papierem. Spryskaj 2 łyżkami oleju, lekko posól.\n" +
                "Wstaw do gorącego piekarnika i piecz przez 10-15 minut, aż zmięknie i zacznie się rumienić na brzegach.\n" +
                "Blachę z warzywami wyjmij z piekarnika, dynię i pieczarki oraz cebulę przełóż do misek.\n" +
                "Blachę z ziemniakami wstaw do piekarnika i zapiekaj przez następne 15 minut, aż będą miękkie.\n" +
                "W woku lub dużej patelni rozgrzej 4 łyżki oleju dodaj pastę curry, wymieszaj, smaż chwilę.\n" +
                "Wlej mleko kokosowe. Gotuj na średnim ogniu przez 5 minut.\n" +
                "Dodaj wszystkie ziemniaki, pieczarki i cebulę. Wymieszaj, gotuj przez minutę na małym ogniu.\n" +
                "Dodaj liście szpinaku, wymieszaj, zestaw z ognia. Dodaj upieczoną dynię, dopraw pieprzem i solą. Delikatnie wymieszaj, by kawałki się nie rozpadły.\n" +
                "Najlepiej smakuje z ryżem ugotowanym (z dodatkiem curry) na sypko i pikantną surówką z ogórków";
        dinnerRecipe.setVisibility(View.VISIBLE);
        dinnerTittle.setVisibility(View.VISIBLE);
        dinnerTittle.setText("Tajskie curry z pieczoną dynią, ziemniakami i szpinakiem");
        dinnerRecipe.setText(wege);
    }
}
