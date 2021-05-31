package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class SecondFragment : Fragment() {

    private lateinit var onSecondFragment: OnClickSecondFragment // Вызов Первого врагмента для Второго
    private var backButton: Button? = null // кнопка Назад
    private var result: TextView? = null // текст результат

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onSecondFragment = context as OnClickSecondFragment // преведение типа интерфейса
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false) // расширяем фрагмент
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result = view.findViewById(R.id.result) // инициализация результата
        backButton = view.findViewById(R.id.back) // инициализация кнопки назад

        val min = arguments?.getInt(MIN_VALUE_KEY) ?: 0 // получаем из аргумента минимум
        val max = arguments?.getInt(MAX_VALUE_KEY) ?: 0// получаем из аргумента  максимум

        result?.text = generate(
            min,
            max
        ).toString() // заносим в результат данные из функции переданной функции и приводим в строку

        backButton?.setOnClickListener { // кнопка назад
            onSecondFragment.onGoFirstFragment(result?.text.toString().toInt() ?: 0)
        }

    }

    private fun generate(min: Int, max: Int): Int { // генерация и возврат
        return Random.nextInt(min, max)
    }


    fun onToFirstFragment() {
        onSecondFragment.onGoFirstFragment(result?.text.toString().toInt() ?: 0)
    }

    companion object { // статичные данные

        @JvmStatic // для вызова из Java доступным -  генерация доп метода
        fun newInstance(min: Int, max: Int): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()

            args.putInt(MIN_VALUE_KEY, min)
            args.putInt(MAX_VALUE_KEY, max)

            fragment.arguments = args
            return fragment
        }

        const val MIN_VALUE_KEY = "MIN_VALUE"
        const val MAX_VALUE_KEY = "MAX_VALUE"
    }
}