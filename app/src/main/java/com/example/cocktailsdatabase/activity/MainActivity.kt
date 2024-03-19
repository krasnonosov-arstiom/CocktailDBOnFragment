package com.example.cocktailsdatabase.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.cocktailsdatabase.R
import com.example.cocktailsdatabase.presentation.MainSearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.container, MainSearchFragment.newInstance())
        }
    }
}