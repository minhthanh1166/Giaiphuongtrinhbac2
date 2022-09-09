package com.example.giaiphuongtrinhbac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText a , b , c;
    private Button submit, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận thoát");
                builder.setMessage("Bạn có chắc chắn muốn thoát chương trình không?");
                builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataTransmission();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "Vui lòng bấm nút thoát!", Toast.LENGTH_SHORT).show();
    }

    private void Init() {
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        submit = findViewById(R.id.submit);
        exit = findViewById(R.id.exit);
    }

    public void DataTransmission () {
        if(a.getText().toString().equals("") || b.getText().toString().equals("") || c.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ các số a, b, c", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            // gửi dữ liệu qua intent
            intent.putExtra("sta", a.getText().toString());
            intent.putExtra("stb", b.getText().toString());
            intent.putExtra("stc", c.getText().toString());
            startActivity(intent);
        }
    }
}