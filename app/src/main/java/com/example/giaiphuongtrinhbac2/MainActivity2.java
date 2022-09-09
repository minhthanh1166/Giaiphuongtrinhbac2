package com.example.giaiphuongtrinhbac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView ketQua;
    private Button exitTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InitTwo();

        exitTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("Xác nhận thoát");
                builder.setMessage("Bạn có chắc chắn thoát chương trình không?");
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


        try {
            Intent intent = getIntent();
            float a = Float.parseFloat(intent.getStringExtra("sta"));
            float b = Float.parseFloat(intent.getStringExtra("stb"));
            float c = Float.parseFloat(intent.getStringExtra("stc"));
            Solvetheequation(a, b, c);
        } catch (NumberFormatException e){
            Toast.makeText(MainActivity2.this, "Bạn vui lòng nhập ký tự số!", Toast.LENGTH_SHORT ).show();
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity2.this, "Vui lòng bấm nút thoát!", Toast.LENGTH_SHORT).show();
    }

    private void InitTwo(){
        ketQua = findViewById(R.id.ketQua);
        exitTwo = findViewById(R.id.exitTwo);
    }

    private void Solvetheequation(float a, float b, float c) {
        if (a == 0 && b == 0 && c == 0) {
            ketQua.setText(String.format("%s", "Phương trình vô nghiệm!"));
        } else if (a == 0) {
            float x = -c / b;
            ketQua.setText(String.format("x = %.2f", x));
        } else {
            // tính delta
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                ketQua.setText(String.format("x1 = %.2f và x2 = %.2f", x1, x2));
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                ketQua.setText(String.format("x1 = x2 = %.2f", x1));
            } else {
                ketQua.setText(String.format("%s", "Phương trình vô nghiệm!"));
            }
        }
    }
}