package com.example.ka_lesson30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.ka_lesson30.databinding.ActivityMainBinding

//Для Navigation View:
//1. Мы создали разметку для меню и создали Navigation View в nav_menu.xml. Но мы не указали что наша разметка будет находится внутри нашего navigation view
//2. Чтобы совместить нашу разметку с NavigationView, идем в activity_main.xml и в NavigationView в атрибуте menu выбираем наше созданное nav_menu.xml из папки menu. Теперь я указал, какое меню будет использовать мой NavigationView

//Cоздаем header для Navigation View:
//создать отдельную разметку в layout -> layout resource file -> header.xml. Далее в разметке activity_main.xml в добавленном элементе создаем атрибут headerLayout и указываем на header.xml из папки layout

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.item1 ->  Toast.makeText(this@MainActivity, "Item1", Toast.LENGTH_SHORT).show()

                    R.id.item2 -> Toast.makeText(this@MainActivity, "Item2", Toast.LENGTH_SHORT).show()

            }
                drawer.closeDrawer(GravityCompat.START)     //мы хотим закрыть Navigation View в нем же по нажатию одного из item
                true
            }
            open.setOnClickListener{
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }
}

