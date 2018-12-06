package com.rafaelbarreto.alzheimerscares.ui

import android.Manifest
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import com.maxcruz.reactivePermissions.ReactivePermissions
import com.maxcruz.reactivePermissions.entity.Permission
import com.rafaelbarreto.alzheimerscares.R
import org.jetbrains.anko.*



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //External lib for request permissions
    private val REQUEST_CODE = 554
    val reacPermission = ReactivePermissions(this, REQUEST_CODE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            makeCallPhone()
            //alert("LIIGOU PRA UM NUMERO DE EMERGENCIA!").show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun displayScreen(id: Int){
        val fragment = when (id) {
            R.id.nav_about -> {
                AboutFragment()
            }
            R.id.nav_tips -> {
                TipsFragment()
            }
            R.id.nav_personal_information -> {
                PersonalInformationsFragment()
            }
            R.id.nav_reminders -> {
                RemindersFragment()
            }
            R.id.nav_useful_links -> {
                UsefulLinksFragment()
            }
            R.id.nav_share -> {
                share("baixe o app em: https://play.google.com/store", "[Alzheimer's Care]")
                AboutFragment()
            }
            else -> {
                AboutFragment()
            }
        }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit()

    }

    private fun makeCallPhone(){
        val phone = Permission(
                Manifest.permission.CALL_PHONE,
                R.string.request_call_phone,
                true
        )

        val permissions = listOf( phone )

        reacPermission.observeResultPermissions().subscribe{
            event ->
            if (event.second) {
                Log.d("RAFAA","Ligou")
                makeCall("999887766")
            }
        }

        reacPermission.observeResultPermissions().subscribe{
            event ->
            if (event.first == Manifest.permission.CALL_PHONE
                    && event.second) {

                makeCall("999887766")
            }
            else if (event.first == Manifest.permission.SEND_SMS
                    && event.second) {
                sendSMS("999887766")
            }
        }

        reacPermission.evaluate(permissions)
    }


    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if( requestCode == REQUEST_CODE ){
            reacPermission.receive(permissions, grantResults)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        displayScreen(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
