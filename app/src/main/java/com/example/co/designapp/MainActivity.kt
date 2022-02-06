package com.example.co.designapp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation
import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricPrompt
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.co.designapp.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private var cancelationsignal:CancellationSignal?=null
    private val autenticationcallback:BiometricPrompt.AuthenticationCallback
    get() =
        @RequiresApi(Build.VERSION_CODES.P)
    object :BiometricPrompt.AuthenticationCallback(){
        override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
            super.onAuthenticationError(errorCode, errString)
            ShowToast("error $errString")
        }

        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
            super.onAuthenticationSucceeded(result)
            ShowToast("welcome !!!!!")
        }

    }
    private lateinit var binding:ActivityMainBinding
    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CheckedBiometricsupport()
        val biometricPrompt: BiometricPrompt = BiometricPrompt.Builder(this)
            .setTitle("fingetprint")
            .setTitle("your security is needed")
            .setDescription("this app is use the finger print")
            .setNegativeButton(
                "cancel",
                this.mainExecutor,
                DialogInterface.OnClickListener { dialogInterface, i ->
                    ShowToast("canel")
                }).build()
        biometricPrompt.authenticate(getcancelationsignal(), mainExecutor, autenticationcallback)
        binding.cardSix.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottem_sheet_callus, null)
            val btnclose = view.findViewById<Button>(R.id.btn_close)
            btnclose.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }

        binding.btnBack.setOnClickListener {
            ShowToast("back to first Activity", 2000)
        }

        binding.cardFour.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://speed-interior.shatel.ir/")
            startActivity(intent)
        }
        binding.cardOne.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://my.shatel.ir")
            startActivity(intent)
        }

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val username: String = binding.textViewUserName.text.toString()
            intent.putExtra(Constants.username, username)
            startActivity(intent)
        }
        val openIntentforResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    binding.textViewUserName.text = it.data.toString()
                } else {
                    ShowToast("empty massage")
                }
            }
        binding.cardFive.setOnClickListener {
            openIntentforResult.launch(Intent(this, SecondActivity::class.java))
        }
        binding.cardTwo.setOnClickListener {
            val intent = Intent(this, NavigationComponentActivity::class.java)
            startActivity(intent)
        }







    }
    private fun getcancelationsignal():CancellationSignal{
        cancelationsignal= CancellationSignal()
        cancelationsignal?.setOnCancelListener {
            ShowToast("your fingerprint is canceld by user")
        }
        return cancelationsignal as CancellationSignal
    }

    private fun CheckedBiometricsupport() : Boolean {
        val keygardmanager:KeyguardManager=getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (!keygardmanager.isDeviceSecure){
            ShowToast("your device dose not have finger print")
            return false
        }
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.USE_BIOMETRIC)
            !=PackageManager.PERMISSION_GRANTED){
            ShowToast("finger print is not enable")
            return false
        }
        return if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            true
        } else true
    }

}