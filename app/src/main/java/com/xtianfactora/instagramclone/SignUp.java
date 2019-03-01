package com.xtianfactora.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName,
            edtPunchSpeed,
            edtPunchPower,
            edtKickSpeed,
            edtKickPower;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = (Button) findViewById(R.id.btnSave);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPunchSpeed = (EditText) findViewById(R.id.edtPunchSpeed);
        edtPunchPower = (EditText) findViewById(R.id.edtPunchPower);
        edtKickSpeed = (EditText) findViewById(R.id.edtKickSpeed);
        edtKickPower = (EditText) findViewById(R.id.edtKickPower);

        btnSave.setOnClickListener(SignUp.this);
    }

    @Override
    public void onClick(View v) {

        try {
            final ParseObject kickBoxer = new ParseObject("kickBoxer");
            kickBoxer.put("name", edtName.getText().toString());
            kickBoxer.put("punchSpeed", Integer.parseInt(edtPunchSpeed.getText().toString()));
            kickBoxer.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
            kickBoxer.put("kickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
            kickBoxer.put("kickPower", Integer.parseInt(edtKickPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null) {
//                    Toast.makeText(SignUp.this, kickBoxer.get("name") + " is save to server" , Toast.LENGTH_SHORT).show();
                        FancyToast.makeText(SignUp.this,kickBoxer.get("name") + " is save to server" ,
                                FancyToast.LENGTH_LONG, FancyToast.SUCCESS,true).show();
                    } else {
                        Toast.makeText(SignUp.this, e.getMessage() , Toast.LENGTH_LONG).show();
                    }
                }
            });

        } catch (Exception e) {
            FancyToast.makeText(SignUp.this,e.getMessage() ,
                    FancyToast.LENGTH_LONG, FancyToast.ERROR,true).show();
        }

    }
}
