package greenjaar.com.greenjaar;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity implements View.OnClickListener{

    private EditText email,pass,name,phone;
    private Button register_btn;
    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setupview();  // to identify fields from view

        register_btn.setOnClickListener(this);
        signin.setOnClickListener(this);
    }

    private void setupview()
    {
        email = findViewById(R.id.etemail);
        pass = findViewById(R.id.etpassword);
        name = findViewById(R.id.etname);
        phone = findViewById(R.id.etmobile);
        register_btn = findViewById(R.id.btnregister);
        signin = findViewById(R.id.tvsignin);
    }
    // need to check against data base for duplicate entries
    private boolean validateEmail() {

        String emailinput = email.getText().toString().trim();
        if (emailinput.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
            email.setError("Enter a valid Email Address");
            return false;
        }
        else
        {
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {

        String passinput = pass.getText().toString().trim();
        if(passinput.isEmpty()){
            pass.setError("Enter a password");
            return false;
        }
        else
        {
            pass.setError(null);
            return true;
        }
    }
    private boolean validatePhone() {

       String phoneinput = phone.getText().toString().trim();
       if(!phoneinput.isEmpty()) {
           if (!Patterns.PHONE.matcher(phoneinput).matches()){
               phone.setError("Enter a Valid Number without 0");
               return false;
           }
           else{
               phone.setError(null);
               return  true;

           }

       }
       else
       return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            // if valid call method to add to database
            case R.id.btnregister :
                if(validateEmail() && validatePassword() && validatePhone()){
                    register(email.getText().toString(), pass.getText().toString(), phone.getText().toString(), name.getText().toString());
//                    Toast.makeText(this,"Registration successfull",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(this,Login.class);
//                    startActivity(intent);
                }
                else
                    Toast.makeText(this,"Registration Unsuccessfull",Toast.LENGTH_LONG).show();
                break;
            case R.id.tvsignin :
                Intent intent1 = new Intent(this,Login.class);
                finish();
                startActivity(intent1);
                break;
        }
    }

    public void register(String email, String pass, String phone, String name){
        Log.d("tag", "into register");
        String type = "register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(signup.this);
        backgroundWorker.execute(type, email,  pass,  phone,  name);
    }
}
