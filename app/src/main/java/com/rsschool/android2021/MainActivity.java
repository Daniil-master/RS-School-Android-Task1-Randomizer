package com.rsschool.android2021;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
// Context - хранит данные о системе, представляет доступ

public class MainActivity extends AppCompatActivity implements OnClickFirstFragment, OnClickSecondFragment {
    private SecondFragment secondFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.ui_background));
        }
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) { // Первый Фрагмент. Предыдущий результат
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber); // создаем фрагмент и передаем Данные - Предыдущий результат
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); // получаем управляющий фрагментами
        transaction.replace(R.id.container, firstFragment); // заменяем имеющийся на превый
        transaction.commit(); // подтверждаем изменения (замену)
    }

    private void openSecondFragment(int min, int max) { // Второй Фрагмент. Минимум и максимум
        secondFragment = SecondFragment.newInstance(min, max); // создаем фрагмент и предаем Данные - минимум и максимум
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); // получаем управляющий фрагментами
        transaction.replace(R.id.container, secondFragment); //  заменяем на второй фрагмент
        transaction.commit(); // подтверждаем изменения (замену)
    }

    @Override
    public void onGoSecondFragment(int min, int max) {
        openSecondFragment(min, max);
    }

    @Override
    public void onGoFirstFragment(int previousNumber) {
        openFirstFragment(previousNumber);
    }

    @Override
    public void onBackPressed() {
        if (secondFragment.isResumed()) { // проверка что открыт Первый фрагмент
            secondFragment.onToFirstFragment(); // вызов из второго фрагмента первый

        } else
            super.onBackPressed();

    }

}
