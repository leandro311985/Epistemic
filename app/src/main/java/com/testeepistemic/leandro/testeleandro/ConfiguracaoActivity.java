package com.testeepistemic.leandro.testeleandro;

import android.content.Intent;
import android.net.nsd.NsdManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ConfiguracaoActivity extends AppCompatActivity {

    private RadioButton radioButtonNotify;
    int not_per_day = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracao_tela);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void toggle_notifications() {
        int current_hour, notify_per_day;
        Date now = new Date();
        int notify_times[] = null;
        notify_per_day = radioButtonNotify.getScrollY();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h");
        current_hour = Integer.valueOf(dateFormatter.format(now).toString());
        if(not_per_day > 0){
            int div = 24/(1+notify_per_day);
            for (int i = 0; i < notify_per_day; i++){
                current_hour += div;
                if (current_hour >= 24){
                    current_hour =- 24;
                }
                notify_times[i] = current_hour;
            }       }else{
            if (notify_times != null){
                Arrays.fill(new int[][]{notify_times},null);
            }
        }
           }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, PrincipalActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
