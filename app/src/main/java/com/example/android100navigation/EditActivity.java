package com.example.android100navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    private Button mSave;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mSave = findViewById(R.id.save_button);
        mEdit = findViewById(R.id.name_edit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mEdit.setText(name);

        mSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", mEdit.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
