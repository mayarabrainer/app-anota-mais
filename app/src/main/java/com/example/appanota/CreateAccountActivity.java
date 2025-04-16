package com.example.appanota;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    EditText nameInput, emailInput, passwordInput;
    Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        createAccountButton = findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();


            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                SharedPreferences sharedPref = getSharedPreferences("UserDetails", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("userEmail", email);
                editor.putString("userPassword", password);
                editor.apply();  // Salva os dados

                Toast.makeText(CreateAccountActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(CreateAccountActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
