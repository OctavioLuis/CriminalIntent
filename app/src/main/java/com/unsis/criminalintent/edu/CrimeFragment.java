package com.unsis.criminalintent.edu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/* CrimeFragment is a controller that interacts with model and view objects. Its job is to present the
details of a specific crime and update those details as the user changes them.*/

public class CrimeFragment extends Fragment  {

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCrime=new Crime();
    }

    /*This method is where you inflate the layout for the fragment’s view and return the inflated View to the
hosting activity. The LayoutInflater and ViewGroup parameters are necessary to inflate the layout.
The Bundle will contain data that this method can use to re-create the view from a saved state.

Within onCreateView(...) , you explicitly inflate the fragment’s view by calling
LayoutInflater.inflate(...) and passing in the layout resource ID. The second parameter is your
view’s parent, which is usually needed to configure the widgets properly. The third parameter tells the
layout inflater whether to add the inflated view to the view’s parent. You pass in false because you
will add the view in the activity’s code.*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mDateButton = (Button) v.findViewById(R.id.crime_date);
        /*TextWatcher has three methods,
but you only care about one: onTextChanged(...) .
In onTextChanged(...) , you call toString() on the CharSequence that is the user’s input. This method
returns a string, which you then use to set the Crime ’s title.*/
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
/*Next, connect the Button to display the date of the crime*/

        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        /*Moving on to the CheckBox , get a reference and set a listener that will update the mSolved field of the
Crime*/
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }
}
