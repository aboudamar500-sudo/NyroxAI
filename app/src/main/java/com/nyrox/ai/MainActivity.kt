package com.nyrox.ai

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 40, 32, 24)
            setBackgroundColor(Color.rgb(12, 12, 16))
        }

        val title = TextView(this).apply {
            text = "Nyrox AI"
            textSize = 30f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "مساعدك الذكي في مكان واحد"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 30)
        }

        val chat = TextView(this).apply {
            text = "مرحبًا! أنا Nyrox AI 👋\\n\\nاكتب رسالتك بالأسفل للبدء."
            textSize = 17f
            setTextColor(Color.WHITE)
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(28, 28, 36))
        }

        val input = EditText(this).apply {
            hint = "اكتب رسالتك..."
            textSize = 16f
            setTextColor(Color.WHITE)
            setHintTextColor(Color.GRAY)
            setSingleLine(true)
        }

        val send = Button(this).apply {
            text = "إرسال"
            setOnClickListener {
                val message = input.text.toString().trim()
                if (message.isNotEmpty()) {
                    chat.text = "أنت: $message\\n\\nNyrox AI: تم استلام رسالتك. سنربط محرك الذكاء الاصطناعي في الخطوة التالية."
                    input.text.clear()
                }
            }
        }

        root.addView(title, LinearLayout.LayoutParams(-1, -2))
        root.addView(subtitle, LinearLayout.LayoutParams(-1, -2))
        root.addView(chat, LinearLayout.LayoutParams(-1, 0, 1f))

        val bottom = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }

        bottom.addView(input, LinearLayout.LayoutParams(0, -2, 1f))
        bottom.addView(send, LinearLayout.LayoutParams(-2, -2))

        root.addView(bottom)
        setContentView(root)
    }
}
