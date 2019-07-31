package com.example.imagescaletype

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.media.ThumbnailUtils
import android.os.Bundle
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)

        if(resultCode == Activity.RESULT_OK) {
            val data = resultData!!.data
            val inputStream = contentResolver.openInputStream(data)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            original.setImageBitmap(bitmap)
            center.setImageBitmap(bitmap)
            centerCrop.setImageBitmap(bitmap)
            centerInside.setImageBitmap(bitmap)
            fitStart.setImageBitmap(bitmap)
            fitEnd.setImageBitmap(bitmap)
            fitCenter.setImageBitmap(bitmap)
            fitXY.setImageBitmap(bitmap)
            matrix.setImageBitmap(bitmap)

            container.visibility = VISIBLE

        }
    }
}