package com.rsschool.android2021

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(text: CharSequence) { // отображение тостов
    Toast.makeText(
        context,
        text, Toast.LENGTH_SHORT
    ).show()
}
