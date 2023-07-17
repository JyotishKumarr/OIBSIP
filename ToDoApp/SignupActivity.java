package com.example.todoappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    private EditText signupUsernameEditText, signupPasswordEditText;
    private Button signupButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupUsernameEditText = findViewById(R.id.signupUsernameEditText);
        signupPasswordEditText = findViewById(R.id.signupPasswordEditText);
        signupButton = findViewById(R.id.signupButton);
        databaseHelper = new DatabaseHelper(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signupUsernameEditText.getText().toString().trim();
                String password = signupPasswordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else if (UserNameValidator.isUsernameValid(username)){
                    User user = new User(username, password);
                    databaseHelper.addUser(user);
                    Toast.makeText(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(SignupActivity.this, "Enter the user name with atleast 1 capital letter", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private static class UserNameValidator {
        public static boolean isUsernameValid(String username) {
            // Regular expression to match at least one capital and one small letter
            String regex = "^(?=.*[a-z])(?=.*[A-Z]).+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(username);

            return matcher.matches();
        }
    }
}
