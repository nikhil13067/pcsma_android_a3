package coplus.example.provenlogic1.googleplus_connect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class QuizQuestions extends AppCompatActivity {

    private Button submit_button;
    int question_id;
    int choice_selected;
    RadioButton option1 ;
    RadioButton option2 ;
    RadioButton option3 ;
    RadioButton option4 ;
    static List<Question> questions;
    RestAdapter adapter;
    API api;
    Quiz quiz;
    int user_id;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(question_id==questions.size()){
            Toast.makeText(getApplicationContext() , "Sending" , Toast.LENGTH_LONG).show();

            api.sendResponse(user_id, quiz, new Callback<Quiz>() {


                @Override
                public void success(Quiz quiz, Response response) {
                    Log.d("send quiz response" , "success " );
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("send quiz response" , "fail" );

                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        adapter = new RestAdapter.Builder()
                .setEndpoint(Main2Activity.ROOT_URL)
                .build();
        api = adapter.create(API.class);
        quiz = new Quiz();
        quiz = Courses.quiz1;
        user_id = Main2Activity.user_id;
        questions=Courses.questions;
        TextView Ques_id = (TextView) findViewById(R.id.question_number);
        final TextView question = (TextView) findViewById(R.id.question);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);

        setListeners();



        String q_count = getIntent().getExtras().getString("q");
        Log.d("count", q_count + " count" + getIntent().getExtras().getString(q_count) + getIntent().getExtras().getString("option4"));
        Ques_id.setText(q_count);
        question.setText(getIntent().getExtras().getString(q_count));
        option1.setText(getIntent().getExtras().getString("option1"));
        option2.setText(getIntent().getExtras().getString("option2"));
        option3.setText(getIntent().getExtras().getString("option3"));
        option4.setText(getIntent().getExtras().getString("option4"));
        question_id = getIntent().getExtras().getInt("question_id");
        submit_button = (Button) findViewById(R.id.mark_question);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "This is "+ question_id + "You selected option "+
                        choice_selected , Toast.LENGTH_SHORT).show();
                Question question =  questions.get(question_id -1 );
                switch (choice_selected){
                    case 0:
                        Toast.makeText(getApplicationContext() , "Please mark one answer" , Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        question.setOption1_count(question.getOption1_count() + 1);
                        break;
                    case 2:
                        question.setOption2_count(question.getOption2_count() + 1);
                        break;
                    case 3:
                        question.setOption3_count(question.getOption3_count() + 1);
                        break;
                    case 4:
                        question.setOption4_count(question.getOption4_count() + 1);
                        break;

                }

            finish();
            }
        });



    }

    private void setListeners() {
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice_selected = 1;
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice_selected=2;
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice_selected=3;
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice_selected=4;
            }
        });
    }
}
