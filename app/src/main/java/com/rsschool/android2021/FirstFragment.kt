package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private lateinit var onClickFirstFragment: OnClickFirstFragment // Интерфейс клика для генрации, проинецилизированна переменная после в коде
    private var generateButton: Button? = null // Кнопка для Генерации
    private var previousResult: TextView? = null // Предыдущий результат
    private var editMinValue: EditText? = null // Редактирование Минимума
    private var editMaxValue: EditText? = null // Редактирование максимума

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onClickFirstFragment = context as OnClickFirstFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false) // расширяем фрагмент
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // создаем View
        super.onViewCreated(view, savedInstanceState)
        // инициализация
        previousResult = view.findViewById(R.id.previous_result) // предыдущий результат
        generateButton = view.findViewById(R.id.generate) // кнопка генерация

        editMinValue = view.findViewById(R.id.min_value) // EditText минимального диапазона
        editMaxValue = view.findViewById(R.id.max_value) // EditText максимального диапазона

        val result =
            arguments?.getInt(PREVIOUS_RESULT_KEY) // получаем из аргумента последний результат
        previousResult?.text = "Previous result: ${result.toString()}" // заносим в TextView


        generateButton?.setOnClickListener {

            val min: Long =
                editMinValue?.text.toString().toLongOrNull()
                    ?: 0 // получаем минимальное значения из EditText
            val max: Long =
                editMaxValue?.text.toString().toLongOrNull()
                    ?: 0 // получаем максимальное значени EditText

            if (editMinValue?.text.toString() == "" ||  editMaxValue?.text.toString() == "")
                showToast("Вы не ввели все данные")
            else if(min == max)
                showToast("Не корректно введены данные. \nНельзя вводить min и max одинаковыми")
            else if (min > Int.MAX_VALUE || max > Int.MAX_VALUE) // проверка на диапозон Int хранимых значений для Long
                showToast("Введены значения превышающие хранимых данных в памяти! \nОбратитесь к разработчику, для перевода в Long значения =)")
            else if (min in 0 until max) // min от 0 и больше max (min не включает max)
                onClickFirstFragment.onGoSecondFragment(min.toInt(), max.toInt())

        }
    }


    companion object { // статичные данные

        @JvmStatic // для вызова из Java доступным -  генерация доп метода
        fun newInstance(previousResult: Int): FirstFragment { // получаем Предыдущий результат
            val fragment = FirstFragment() // получаем фрагмент
            val args = Bundle() // получаем бандл
            args.putInt(
                PREVIOUS_RESULT_KEY,
                previousResult
            ) // послаем результат - предыдущий результат
            fragment.arguments = args // заносим в аргументы
            return fragment // возвращаем фрагмент с аргументами
        }

        const val PREVIOUS_RESULT_KEY =
            "PREVIOUS_RESULT" // константа для отправки предыдущего результата
    }
}

