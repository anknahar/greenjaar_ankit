package greenjaar.com.greenjaar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.MainThread;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static java.security.AccessController.getContext;

/**
 * Created by ProgrammingKnowledge on 1/5/2016.
 */

       @TargetApi(Build.VERSION_CODES.CUPCAKE)
       @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
       public class BackgroundWorker extends AsyncTask<String,Void,String> {

           String[] data;
           Context context;
           AlertDialog alertDialog;



           BackgroundWorker(Context ctx) {
               context = ctx;

           }


           @Override
           protected String doInBackground(String... params) {

               String type = params[0];
               String login_url = "https://greenjaar.com/Login.php";
               String register_url = "https://greenjaar.com/register.php";
               String send_mail_url = "https://greenjaar.com/forgotPass.php";
               if (type.equals("login")) {
                   try {

                       String user_name = params[1];
                       String password = params[2];

                       URL url = new URL(login_url);
                       HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                       httpURLConnection.setRequestMethod("POST");
                       httpURLConnection.setDoOutput(true);
                       httpURLConnection.setDoInput(true);
                       OutputStream outputStream = httpURLConnection.getOutputStream();

                       //encryption
                       BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                       String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                               + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                       bufferedWriter.write(post_data);
                       bufferedWriter.flush();
                       bufferedWriter.close();
                       outputStream.close();
                       InputStream inputStream = httpURLConnection.getInputStream();

                       //Decryption
                       //httpURLConnection.setRequestMethod("GET");
                       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                       String result = "";
                       String line = "";
                       StringBuilder stringBuilder = new StringBuilder();
                       while ((line = bufferedReader.readLine()) != null) {
                           stringBuilder.append(line);
                           result += line+"\n";
                       }
                       result =stringBuilder.toString();

//                       try
//                       {
//                           JSONArray ja = new JSONArray(result);
//                           JSONObject jo = null;
//
//                           data = new String[5];
//                           for (int i = 0; i< 4; i++){
//                               jo = ja.getJSONObject(i);
//                               data[i] = jo.getString("email");
//
//                               if(data[0].equals("login failed")){
//                                   i=4;
//                               }
//                               else{
//                                   data[i+1] = jo.getString("password");
//                                   data[i+2] = jo.getString("phone");
//                                   data[i+3] = jo.getString("name");
//                                   i=4;
//                               }
//                                  result = data[0];
//                           }
//
//                       }
//                       catch(Exception e) {
//                           e.printStackTrace();
//                       }
                       bufferedReader.close();
                       inputStream.close();
                       httpURLConnection.disconnect();


                       return result;
                   }
                   catch (MalformedURLException e) {
                       e.printStackTrace();
                   }
                   catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               else if (type.equals("register")){

                       try {

                           String email = params[1];
                           String password = params[2];
                           String phone = params[3];
                           String name = params[4];

                           URL url = new URL(register_url);
                           HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                           httpURLConnection.setRequestMethod("POST");
                           httpURLConnection.setDoOutput(true);
                           httpURLConnection.setDoInput(true);
                           OutputStream outputStream = httpURLConnection.getOutputStream();

                           //encryption
                           BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                           String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                   + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                   + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&"
                                   + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");

                           bufferedWriter.write(post_data);
                           bufferedWriter.flush();
                           bufferedWriter.close();
                           outputStream.close();
                           InputStream inputStream = httpURLConnection.getInputStream();

                           //Decryption
                           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                           String result = "";
                           String line = "";
                           while ((line = bufferedReader.readLine()) != null) {
                               result += line;
                           }
                           bufferedReader.close();
                           inputStream.close();
                           httpURLConnection.disconnect();
                           return result;
                       }
                       catch (MalformedURLException e) {
                           e.printStackTrace();
                       }
                       catch (IOException e) {
                           e.printStackTrace();
                       }

               }

               else if (type.equals("sendmail")){
                   try {

                       String email = params[1];


                       URL url = new URL(register_url);
                       HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                       httpURLConnection.setRequestMethod("POST");
                       httpURLConnection.setDoOutput(true);
                       httpURLConnection.setDoInput(true);
                       OutputStream outputStream = httpURLConnection.getOutputStream();

                       //encryption
                       BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                       String post_data =  URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");

                       bufferedWriter.write(post_data);
                       bufferedWriter.flush();
                       bufferedWriter.close();
                       outputStream.close();
                       InputStream inputStream = httpURLConnection.getInputStream();

                       //Decryption
                       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                       String result = "";
                       String line = "";
                       while ((line = bufferedReader.readLine()) != null) {
                           result += line;
                       }
                       bufferedReader.close();
                       inputStream.close();
                       httpURLConnection.disconnect();
                       return result;
                   }
                   catch (MalformedURLException e) {
                       e.printStackTrace();
                   }
                   catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               return null;
           }

           @Override
           protected void onPreExecute() {
               Log.d("tag","In on pre Execute");
               alertDialog = new AlertDialog.Builder(context).create();
               alertDialog.setTitle("Status");
           }

           @Override
           protected void onPostExecute(String result) {

               if (result.equals("success")) {
                   Intent intent = new Intent(context.getApplicationContext(), homeActivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   context.startActivity(intent);
               }
               else
               {
                   alertDialog.setMessage(result);
                   alertDialog.show();
               }
           }

           @Override
           protected void onProgressUpdate(Void... values) {
               super.onProgressUpdate(values);

           }

       }