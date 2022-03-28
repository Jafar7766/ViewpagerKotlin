package com.example.viewpagerkotlin

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PageAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){tab, index ->
            tab.text = when(index){
                 0 -> {"First"}
                 1 -> {"Second"}
                 2 -> {"Third"}
                else -> {throw Resources.NotFoundException("Postion Not Found")}
            }
        }.attach()
    }
}