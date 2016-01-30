package com.ejemplo.claseintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ejemplo.claseintents.model.Athlete;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int EXTRA = 12;

    public void preguntarId(View v){
        Intent intent = new Intent(this,IdGeneratorActivity.class);
        intent.putExtra("objetoParcel", generarElParcel());
        startActivityForResult(intent, EXTRA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            ((TextView) findViewById(R.id.id)).setText(data.getStringExtra("id"));
        }

    }

    private Athlete generarElParcel(){
        String nombre = ((EditText) findViewById(R.id.nametext)).getText().toString();
        Integer age = Integer.parseInt(((EditText) findViewById(R.id.agetext)).getText().toString());
        String sport = ((EditText) findViewById(R.id.sportext)).getText().toString();
        return new Athlete(nombre,age,sport);
    }
}
