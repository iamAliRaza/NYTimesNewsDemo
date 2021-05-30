package com.mvvm_arch.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

// Here we can define all our extension function

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}