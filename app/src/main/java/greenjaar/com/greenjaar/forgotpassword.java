package greenjaar.com.greenjaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class forgotpassword extends AppCompatActivity implements View.OnClickListener {

    Button sendbtn;
    EditText email_et;
    TextView backtologin_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        sendbtn = (Button) findViewById(R.id.btn_send);
        email_et = (EditText) findViewById(R.id.et_mailadd);
        backtologin_tv = (TextView) findViewById(R.id.tv_backtologin);

        sendbtn.setOnClickListener(this);
        backtologin_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_send:
                if(validateEmail()){
                    sendmail(email_et.getText().toString());
                }
                break;
            case R.id.tv_backtologin:
                Intent intent = new Intent(this,Login.class);
                finish();
                startActivity(intent);
                break;
        }
    }
    private boolean validateEmail() {

        String emailinput = email_et.getText().toString().trim();
        if (emailinput.isEmpty()){
            email_et.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
            email_et.setError("Enter a valid Email Address");
            return false;
        }
        else
        {
            email_et.setError(null);
            return true;
        }
    }

    public void sendmail(String email){
        Log.d("tag", "into sendmail");
        String type = "sendmail";

        BackgroundWorker backgroundWorker = new BackgroundWorker(forgotpassword.this);
        backgroundWorker.execute(type, email);
    }
}
