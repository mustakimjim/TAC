package com.dummy.tac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class TACActivity extends AppCompatActivity {

    private CheckBox checkbox;
    private Button button;
    private MaterialAlertDialogBuilder materialAlertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tac_main);

        getSupportActionBar().hide();

        checkbox = findViewById(R.id.check_id);
        button = findViewById(R.id.button_id);

        materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);

        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TACActivity.this,WelCome.class);
                startActivity(intent);
            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    materialAlertDialogBuilder.setTitle("Terms and Conditions");
                    materialAlertDialogBuilder.setMessage("This is your description");
                    materialAlertDialogBuilder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            button.setEnabled(true);
                            dialogInterface.dismiss();
                        }
                    });
                    materialAlertDialogBuilder.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            checkbox.setChecked(false);
                        }
                    });

                    materialAlertDialogBuilder.show();
                }else{
                    button.setEnabled(false);
                }
            }
        });
    }
}