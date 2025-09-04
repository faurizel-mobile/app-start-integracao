package br.gov.sp.startapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var email =  findViewById<EditText>(R.id.editTextEmail)
        var senha = findViewById<EditText>(R.id.editTextSenha)
        var btnLogar = findViewById<Button>(R.id.buttonLogar)
        var btnCadastrar = findViewById<Button>(R.id.buttonCadastrar)
        btnLogar.setOnClickListener {
            if(email.text.isEmpty()|| senha.text.isEmpty()){
                Toast.makeText(this,"E-mail ou  senha vazio",Toast.LENGTH_LONG).show()
            }else{
               var intent =  Intent(this, SeguroActivity::class.java)
                startActivity(intent)
            }
        }

        btnCadastrar.setOnClickListener{
           var intent =  Intent(this, CadastroUsuuarioActivity::class.java)
            startActivity(intent)
        }


    }
}