package com.app.navigationdrawerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Outbox
import android.view.Gravity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.navigationdrawerandroid.Fragment.*
import com.app.navigationdrawerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var drawerToggle:ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.application.toolBar.title="Home"
        setSupportActionBar(binding.application.toolBar)

        addFragment(HomeFragment(),"Home")
        drawerToggle= ActionBarDrawerToggle(this,binding.drawerLayout,binding.application.toolBar,R.string.nav_open,R.string.nav_colse)
        // to toggle the button
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        binding.navigationView.setNavigationItemSelectedListener{
            return@setNavigationItemSelectedListener when(it.itemId){
                R.id.nav_home->{
                    addFragment(HomeFragment(),"Home")
                    true
                }
                R.id.nav_profile->{
                    addFragment(ProfileFragment(),"Profile")
                    true
                }
                R.id.nav_order->{
                    addFragment(OrderFragment(),"Order")
                    true
                }
                R.id.nav_notification->{
                    addFragment(NotificationFragment(),"Notification")
                    true
                }
                R.id.nav_setting->{

                    true
                }
                R.id.nav_privacy_policy->{
                    true
                }
                R.id.nav_logout->{
                    true
                }else->false

            }
        }
    }

    private fun addFragment(fragment: Fragment,tittle:String) {
        var manager=supportFragmentManager
        var transaction=manager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(tittle)
        transaction.commit()
        binding.application.toolBar.title="$tittle"
        binding.drawerLayout.closeDrawer(GravityCompat.START)


    }
}