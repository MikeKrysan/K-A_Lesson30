package com.example.ka_lesson30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.example.ka_lesson30.databinding.ActivityMainBinding

//Чтобы добавить выдвижное меню, необходимо в activity_main.xml поменять сonstraintLayout контейнер на drawerLayout контейнер и добавить два элемента:
//1.Основной контейнер, где будет содержатся весь контент экрана
//2. Второй элемент, который будет выдвигаться, и у которого должен быть обязательный атрибут layout_gravity со значением "start"(выдвигается слева направо) либо "end" (выдвигается справа налево)

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. Открываем из кода боковое меню:
        binding.apply {
            open.setOnClickListener{
                drawer.openDrawer(GravityCompat.START)  //closeDrawer пишем в том случае, когда в выдвинутом меню нужно подтвердить проделанную операцию, и нажать на этом меню. Стандартно меню закрывается при нажатии на экране вне меню в любом месте экрана, либо самому задвинуть
            }
        }
    }
}