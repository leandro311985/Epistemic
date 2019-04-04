package com.testeepistemic.leandro.testeleandro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrincipalActivity extends AppCompatActivity {

    TextView date ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        date = findViewById(R.id.date);



        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        String meses = "";
        int dia = c.get(c.DAY_OF_WEEK);
        int mes = c.get(c.MONTH);
        int diaMes = c.get(c.DAY_OF_MONTH);
        int ano = c.get(c.YEAR);
        switch(dia){
            case Calendar.SUNDAY: nome = "Domingo ";break;
            case Calendar.MONDAY: nome = "Segunda feira ";break;
            case Calendar.TUESDAY: nome = "Terça feira ";break;
            case Calendar.WEDNESDAY: nome = "Quarta feira ";break;
            case Calendar.THURSDAY: nome = "Quinta feira ";break;
            case Calendar.FRIDAY: nome = "Sexta feira ";break;
            case Calendar.SATURDAY: nome = "sábado ";break;
        }
        switch(mes){
            case Calendar.JANUARY: meses = "janeiro ";break;
            case Calendar.FEBRUARY: meses = "fevereiro ";break;
            case Calendar.MARCH: meses = "março ";break;
            case Calendar.APRIL: meses = "abril ";break;
            case Calendar.MAY: meses = "maio ";break;
            case Calendar.JUNE: meses= "junho ";break;
            case Calendar.JULY: meses = "julho ";break;
            case Calendar.AUGUST: meses = "agosto ";break;
            case Calendar.SEPTEMBER: meses = "setembro ";break;
            case Calendar.OCTOBER: meses = "outubro ";break;
            case Calendar.NOVEMBER: meses = "novembro ";break;
            case Calendar.DECEMBER:meses = "dezembro ";break;
        }


        date.setText(String.valueOf(nome +", "+ diaMes +" de " + meses + "de " + ano));

        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(PrincipalActivity.this,ConfiguracaoActivity.class);
                startActivity(intent);
                break;

        }

        return true;

    }


}


