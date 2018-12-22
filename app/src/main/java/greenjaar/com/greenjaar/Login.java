package greenjaar.com.greenjaar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText uname, upass;
    private Button logbtn;
    private TextView errmsg , signuplk, forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = findViewById(R.id.edusername);
        upass = findViewById(R.id.edpassword);
        logbtn = findViewById(R.id.loginbutton);
        errmsg = findViewById(R.id.errormsg);
        signuplk = findViewById(R.id.signuplink);
        forgotpassword = findViewById(R.id.forgotpassword);

        logbtn.setOnClickListener(this);
        signuplk.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);

    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.loginbutton :
                Log.d("tag", "Login clicked");
                validate(uname.getText().toString(), upass.getText().toString());
                break;
            case R.id.signuplink :
                Log.d("tag","sign up link");
                Intent intent = new Intent(Login.this, signup.class);
                finish();
                startActivity(intent);
                break;
            case  R.id.forgotpassword :
                Intent intent1 = new Intent(this,forgotpassword.class);
                finish();
                startActivity(intent1);
        }

    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void validate(String Name, String pass) {

        Log.d("tag", "into validate");
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(Login.this);
        backgroundWorker.execute(type, Name, pass);

        //if (Name.equals("ank") && pass.equals("12345")) {

         //   Log.d("tag", "into if");
//           Intent intent = new Intent(Login.this, homeActivity.class);
//           startActivity(intent);
       // } else {
         //   Log.d("tag", "into else");
           // errmsg.setText("Incorrect id/password");
        //}


    }




}
