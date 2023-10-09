package com.example.ejerciciolistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private Button sumar;
    private ListView listView;
    private ArrayList<String> resultList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        sumar = findViewById(R.id.sumar);
        listView = findViewById(R.id.listView);

        resultList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        listView.setAdapter(adapter);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nume1 = Integer.parseInt(num1.getText().toString());
                int nume2 = Integer.parseInt(num2.getText().toString());
                int sum = nume1 + nume2;
                String result = nume1 + " + " + nume2 + " = " + sum;
                resultList.add(result);
                adapter.notifyDataSetChanged();

                // Limpiar los EditText después de sumar los números
                num1.getText().clear();
                num2.getText().clear();
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = resultList.get(position);
            Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}
