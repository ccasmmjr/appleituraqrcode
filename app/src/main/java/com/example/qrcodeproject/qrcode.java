package com.example.qrcodeproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qrcodeproject.api.TemService;
import com.example.qrcodeproject.model.Parametros;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class qrcode extends AppCompatActivity {
    private Button scan;
    private TextView visao;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        scan=findViewById(R.id.button4);
        visao=findViewById(R.id.textView5);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(qrcode.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan QRCode");
                intentIntegrator.setDesiredBarcodeFormats(intentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        IntentResult intentResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null){
            String content= intentResult.getContents();
            if(content!=null){
                String [] resultado=content.split(",");
                recuperaRetrofit(resultado[0],resultado[1]);

            }
        }
    }
    private void recuperaRetrofit(String lat, String logi){

        if(lat == null || logi== null){
        lat = "52.52";
        logi = "13.41";}

        TemService temService = retrofit.create(TemService.class);
        Log.w("retrofit", "forecast?latitude=52.52&longitude=13.41&daily=temperature_2m_max,temperature_2m_min&timeformat=unixtime&forecast_days=1&timezone=auto");
        Call<Parametros> call = temService.Forecast(lat,logi,"temperature_2m_max,temperature_2m_min","unixtime","1","auto");

        call.enqueue(new Callback<Parametros>() {
            @Override
            public void onResponse(Call<Parametros> call, Response<Parametros> response) {


                    Parametros dados = response.body();
                    visao.setText(
                            "Latitude: " + dados.getLatitude()
                                    + "\n------------------"
                                    + "\n Longitude: " + dados.getlongitude()
                                    + "\n------------------"
                                    + "\n Elevação: " + dados.getelevation()
                                    + "\n------------------"
                                    + "\n Time Zone: " + dados.gettimezone()
                                    + "\n------------------"
                                    + "\n Temperatura Max: " + dados.getTemperatureMax()
                                    + "\n------------------"
                                    + "\n Temperatura Min: " + dados.getTemperatureMin()

                    );


            }

            @Override
            public void onFailure(Call<Parametros> call, Throwable t) {

                Log.e("Forecast", "Erro ao buscar:" + t.getMessage());

            }
        });

    }

}