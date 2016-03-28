package coplus.example.provenlogic1.googleplus_connect;

/**
 * Created by nikhil on 13/3/16.
 */

import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;


public interface API {

    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Employee
    */
    @GET("/user/")
    public void getAllUsers(Callback<List<Student>> response);

    @GET("/courses/")
    public void getAllCourses(Callback<List<String>> response);

    @GET("/user/{id}/quiz/{course_name}")
    public void getQuiz(@Path("id") int id, @Path("course_name") String course_name, Callback<Quiz> response);

    @POST("/user/{id}/quizanswers")
    public void sendResponse(@Path("id") int id, @Body Quiz quiz, Callback<Quiz> response);

    @DELETE("/user/{id}/")
    public void deleteUser(@Path("id") String id, Callback<Student> response);

    @DELETE("/user/")
    public void deleteAllUser(Callback<Student> response);

    @POST("/user/")
    public void postUser(@Body HashMap<String, String> body, Callback<Student> callback);

    @PUT("/user/{id}")
    public void updateUser(@Path("id") String id, @Body HashMap<String, String> body, Callback<Student> callback);

}