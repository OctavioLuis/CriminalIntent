package com.unsis.criminalintent.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
//public class MainActivity extends AppCompatActivity {
public class MainActivity extends SingleFragmentActivity {

   /*
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        /*give it a fragment to manage.*/
      /*  Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }*/

      /*Todo el codigo de arriba se resume con este siguente, despues de crear la clase abstracta SingleFragmentActivity*/

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
