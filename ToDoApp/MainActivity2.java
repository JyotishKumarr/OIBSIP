package com.example.todoappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private Button logoutButton, addTaskButton;
    private EditText taskEditText;
    private ListView tasksListView;
    private List<String> tasksList;
    private TaskAdapter taskAdapter;
    private DatabaseHelper databaseHelper;
    private Layout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        logoutButton = findViewById(R.id.logoutButton);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskEditText = findViewById(R.id.taskEditText);
        tasksListView = findViewById(R.id.tasksListView);
        tasksList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasksList);
        tasksListView.setAdapter(taskAdapter);
        databaseHelper = new DatabaseHelper(this);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskEditText.getText().toString().trim();
                if (!task.isEmpty()) {
                    tasksList.add(task);
                    taskAdapter.notifyDataSetChanged();
                    taskEditText.setText("");
                    Toast.makeText(MainActivity2.this, "Task added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}