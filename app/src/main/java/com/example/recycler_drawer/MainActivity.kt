package com.example.recycler_drawer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.extencionfuntions.snackisnacki
import com.example.mylibrery.toolbarActy
import com.example.recycler_drawer.Frags.FragmentArrivals
import com.example.recycler_drawer.Frags.FragmentDeapertures
import com.example.recycler_drawer.Frags.FragmentHome
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

val drawerLayout :DrawerLayout=R.id.drawer_layout as DrawerLayout


class MainActivity :toolbarActy() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        ToLoadToolbar(toolbarmian as androidx.appcompat.widget.Toolbar)   //toolbar caricato

        setNavddrawer()
        headerinformation()

        fragTransition(FragmentHome())


        if (savedInstanceState==null){
            fragTransition(FragmentHome())
            nav_view.menu.getItem(0).isChecked=true
        }

    }





    private fun setNavddrawer() {

        val toogle=ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.opendrawler,R.string.closedrawel)
        toogle.isDrawerIndicatorEnabled=true
        drawer_layout.addDrawerListener(toogle)
        toogle.syncState()
        nav_view.setNavigationItemSelectedListener(this)




    }
    private fun fragTransition(fragment: Fragment){

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {



        when(item.itemId){
            R.id.nav_home->fragTransition(FragmentHome())
            R.id.nav_arrivals->fragTransition(FragmentArrivals())
            R.id.nav_deapertures->fragTransition(FragmentDeapertures())
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        showMessagenavigationViewItemSeleted(item.itemId)


        return true

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }


    }
    private fun headerinformation(){
        val name =nav_view.getHeaderView(0).findViewById<TextView>(R.id.texviewnome)
        val email=nav_view.getHeaderView(0).findViewById<TextView>(R.id.texviewemail)

        name?.let { name.text=getString(R.string.nomeuser) }
        email?.let { email.text=getString(R.string.usermai) }


    }
    private  fun showMessagenavigationViewItemSeleted(id:Int){
        when(id){
            R.id.nav_home ->snackisnacki("home")
            R.id.nav_deapertures ->snackisnacki("deapertures")
            R.id.nav_arrivals ->snackisnacki("arrivals")


        }

    }


}