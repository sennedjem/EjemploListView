package com.ejemplo.claseintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.ejemplo.claseintents.model.Athlete;

public class IdGeneratorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_generator);
        mostrarId();

    }

    public void onClick(View v) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("id",getId());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void mostrarId() {
        ((TextView) findViewById(R.id.youridis)).setText((((TextView) findViewById(R.id.youridis)).getText().toString())+" "+getId());
    }

    @NonNull
    private String getId() {
        Intent intentConParcel = getIntent();
        Athlete athlete = ((Athlete) intentConParcel.getParcelableExtra("objetoParcel"));
        return athlete.getName()+athlete.getAge()+athlete.getSport()+Math.random();
    }


}

