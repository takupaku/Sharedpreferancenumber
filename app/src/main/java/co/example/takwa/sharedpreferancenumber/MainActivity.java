package co.example.takwa.sharedpreferancenumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.etscoreId);
        loadScore();




    }

    private void loadScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("db", Context.MODE_PRIVATE);
                int score = sharedPreferences.getInt("name",0);
                editText.setText(score+ "");

    }



    public void Click(View view) {

        if(view.getId() == R.id.increaseId){
            //in
            increase();
        }
        if(view.getId()== R.id.decreaseId){
            //de
            decrease();

        }
    }

    private void decrease() {
        int score =0;
        if(editText.getText().toString().trim().isEmpty()){
            score= 0;
        }


        try {
            score = Integer.parseInt(editText.getText().toString());
        }
        catch (Exception e){

        }


        score -= 5;
        editText.setText(""+score);
        save(score);


    }

    private void increase() {
        int score =0;
        if(editText.getText().toString().trim().isEmpty()){
            score= 0;
        }
        try {
            score = Integer.parseInt(editText.getText().toString());
        }
        catch (Exception e){

        }


        score += 5;
        editText.setText(""+score);
        save(score);
    }
    private void save(int score){


        SharedPreferences sharedPreferences = getSharedPreferences("db", Context.MODE_PRIVATE);

     SharedPreferences.Editor editor=   sharedPreferences.edit();


        editor.putInt("nmae",score);


      editor.commit();


      


    }

}
