package greenjaar.com.greenjaar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class homeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button push_me, green_jaar,find_cnf;
    private TextView textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.login);
        setContentView(R.layout.activity_home);  // Initial UI

        textview = findViewById(R.id.textView);
        push_me = findViewById(R.id.pushmebtn);
        green_jaar = findViewById(R.id.greenjaar);
        find_cnf = findViewById(R.id.findcnf);
        //uname = (EditText) findViewById(R.id.uname);
        //upass = (EditText) findViewById(R.id.pass);
        //logbtn = (Button) findViewById(R.id.loginbutton);

        push_me.setOnClickListener(this);
        green_jaar.setOnClickListener(this);
        find_cnf.setOnClickListener(this);
        //logbtn.setOnClickListener(this);



       /** push_me.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {

                textview.setText("Thanks for the Push");
            }
        });

         Button greenjaar = (Button) findViewById(R.id.greenjaar);
         greenjaar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                textview.setText("Welcome to green jaar technology");
            }
        }); **/


    }

//    private void validate(EditText name, EditText pass)
//    {
//        if (name.getText().toString() == "Ankit" && pass.getText().toString() == "12345")
//        {
//            setContentView(R.layout.activity_home);
//        }
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.pushmebtn :
                Intent intent = new Intent(homeActivity.this , Login.class);
                startActivity(intent);
                break;
            case R.id.greenjaar:
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.greenjaar.com"));
                startActivity(webintent);
                break;
            case R.id.findcnf :
                Intent Locintent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:26.9112556,75.7433706,15?z=10"));
                startActivity(Locintent);
                break;

        }
    }
    }
