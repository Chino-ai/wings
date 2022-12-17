package com.example.interview1.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.interview1.R
import com.example.interview1.databinding.ActivityLoginBinding
import com.example.interview1.helper.ViewModelFactory
import com.example.interview1.ui.productList.ProductListActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)


            loginBinding.btnLogin.setOnClickListener {
                val strLogin = loginBinding.edtUsername.text.toString()
                val strPasssword = loginBinding.edtPassword.text.toString()
                if (strLogin == "" || strPasssword == "") {
                    Toast.makeText(this@LoginActivity, "Mohon Masukan Username dan Password.", Toast.LENGTH_SHORT)
                        .show()
                } else if (strLogin == strLogin || strPasssword == strPasssword) {
                    val intent = Intent(this@LoginActivity, ProductListActivity::class.java)
                    startActivity(intent)

                }
            }




    }
}