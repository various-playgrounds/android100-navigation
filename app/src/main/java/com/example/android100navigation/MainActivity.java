package com.example.android100navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mEdit;
    private TextView mName;
    private Button mWeb;
    private static final int REQ_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mName = findViewById(R.id.name_text);
        this.mEdit = findViewById(R.id.edit_button);
        this.mWeb = findViewById(R.id.web_button);

        mEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("name", mName.getText().toString());
                startActivityForResult(intent, REQ_CODE);
            }
        });

        mWeb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                // resolveActivity will try to resolve to locally installed app or web version,
                // we have to make sure it resolves to non-null value or system will throw exception
                if (web.resolveActivity(getPackageManager()) != null) {
                    startActivity(web);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            mName.setText(name);
        }
    }
}
