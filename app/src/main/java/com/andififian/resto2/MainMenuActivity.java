package com.andififian.resto2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView D1,D2,D3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        D1 = findViewById(R.id.d1);
        D1.setOnClickListener((View.OnClickListener) this);

        D2 = findViewById(R.id.d2);
        D2.setOnClickListener((View.OnClickListener) this);

        D3 = findViewById(R.id.d3);
        D3.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.d1 : i = new Intent(this,MainActivity.class); startActivity(i);break;
            case R.id.d2 : i = new Intent(this,MainActivityMinuman.class); startActivity(i);break;
            case R.id.d3 : i = new Intent(this,MainActivityMaPembuka.class); startActivity(i);break;
        }
    }
}