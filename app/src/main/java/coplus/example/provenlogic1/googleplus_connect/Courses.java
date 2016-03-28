package coplus.example.provenlogic1.googleplus_connect;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Courses extends ListActivity {

    private TextView text;
    private List<String> listValues;
    static List<Question> questions;
    public static Quiz quiz1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses2);

        String carListAsString = getIntent().getStringExtra("list_as_string");

        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();

        List<String> courses = gson.fromJson(carListAsString, type);

        quiz1 = new Quiz();


        //   Toast.makeText(getApplicationContext(), courses.toString(), Toast.LENGTH_LONG).show();
        text = (TextView) findViewById(R.id.mainText);



        // initiate the listadapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.listText, courses);

        // assign the list adapter
        setListAdapter(myAdapter);

    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);
        //String selectedItem = (String) getListAdapter().getItem(position);

        text.setText("You clicked " + selectedItem + " at position " + position);

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Main2Activity.ROOT_URL)
                .build();
        API api = adapter.create(API.class);
        Log.d("userId", Main2Activity.user_id + " ss");
        api.getQuiz(Main2Activity.user_id, selectedItem, new Callback<Quiz>() {


            @Override
            public void success(Quiz quiz, Response response) {
                quiz1 = quiz;

                Toast.makeText(getApplicationContext() , quiz.getName() + "quiz fetched" , Toast.LENGTH_LONG).show();
                questions = quiz.getQuestions();
                int count = -1;
                Collections.reverse(questions);
                int size = questions.size();
                for(Question question: questions){

                    count++;
                    Intent intent = new Intent(Courses.this , QuizQuestions.class );
                    intent.putExtra("question_id", size-count );
                    intent.putExtra("q", "q" + (size-count) );
                    intent.putExtra("q" + (size-count), question.getName());
                    intent.putExtra("option1" , question.getOption1());
                    intent.putExtra("option2" , question.getOption2());
                    intent.putExtra("option3", question.getOption3());
                    intent.putExtra("option4", question.getOption4());

                    startActivity(intent);

                }

            }


            @Override
            public void failure(RetrofitError error) {
                Log.d("fail", "fail");
            }
        });



    }

}



