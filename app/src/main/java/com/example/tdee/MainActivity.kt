package com.example.tdee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fui_auth_method_picker_layout)

        createSignInIntent()
    }

    private fun checkCurrentUser(): Boolean {
        val user = FirebaseAuth.getInstance().getCurrentUser()
        return user != null
    }

    private fun createSignInIntent() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RC_SIGN_IN) {
//            val response = IdpResponse.fromResultIntent(data)

            if(resultCode == Activity.RESULT_OK) {
                //success
                Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
            }
            else {
                // Sign in failed
                Log.d("MAIN_ACTIVITY", "failed to sign in")
            }
        }
    }

    override fun onStop() {
        super.onStop()
        signOut()
    }

    private fun signOut() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                Log.d("MAIN_ACTIVITY", "successfully signed out")
            }

    }
}
