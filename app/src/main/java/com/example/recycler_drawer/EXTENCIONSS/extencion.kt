package com.example.extencionfuntions

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.recycler_drawer.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso





fun Activity.gotoActivityResult(action: String,requestcode:Int ,init: Intent.() -> Unit={}){
    val intent=Intent(action)
    intent.init()
    startActivityForResult(intent,requestcode)
}

inline fun  < reified T:Activity>Activity.goToActivity(  noinline init: Intent.()-> Unit ={} ){
     val intent=Intent(this,T::class.java)
     intent.init()
     startActivity(intent)
}

fun ImageView.imageviewloaderbyurl(url: String)=
    Picasso.get()
    .load(url)
    //.transform(Trans())
    .into(this)

fun ViewGroup.infla(layoutId: Int)= LayoutInflater.from(context).inflate(layoutId,this,false)
fun Int.isnatural()=this >=0
fun Activity.toastt(message: CharSequence, duration:Int=Toast.LENGTH_LONG)= Toast.makeText(this,message,duration).show()
fun Activity.snackisnacki(message: CharSequence, view: View? =findViewById(R.id.container), duration: Int=Snackbar.LENGTH_LONG, action:String?=null, actionsEvent:(v:View)->Unit={}){





    if (view!=null){
        val snack = Snackbar.make(view,message,duration)
        if (!action.isNullOrEmpty()){
            snack.setAction(action,actionsEvent)
        }
        snack.show()
    }


}