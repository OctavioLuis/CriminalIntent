package com.unsis.criminalintent.edu;

import android.app.TaskInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;

    private CrimeAdapter mAdapter;

    /*Now that CrimeListFragment ’s view is set up, hook up the view to the fragment. Modify
CrimeListFragment to use this layout file and to find the RecyclerView in the layout fil*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView= view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

/*The next job is to define the ViewHolder that will inflate and own your layout. Define it as an inner
class in CrimeListFragment .*/
    private class CrimeHolder extends RecyclerView.ViewHolder {

    private TextView mTitleTextView;
    private TextView mDateTextView;

    private Crime mCrime;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));

            mTitleTextView = (TextView) itemView.findViewById(R.id.crimen_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crimen_date);

        }

    public void bind(Crime crime) {
        mCrime = crime;


        Toast.makeText(getContext(), mCrime.getTitle(), Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(), mCrime.getDate().toString(), Toast.LENGTH_LONG).show();
       mTitleTextView.setText(mCrime.getTitle());
        mDateTextView.setText(mCrime.getDate().toString());


    }
    }

/*.
CrimeHolder is all skin and bones right now. Later in the chapter, CrimeHolder will beef up as you
give it more work to do.
With the ViewHolder defined, create the adapter.*/
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

/*Next, implement three method overrides in CrimeAdapter . (You can automatically generate these
overrides by putting your cursor on top of extends , keying in Option-Return (Alt+Enter), selecting
Implement methods , and clicking OK.*/
        @Override
        public CrimeHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder( CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    /*Now that you have an Adapter , connect it to your RecyclerView . Implement a method called
updateUI that sets up CrimeListFragment ’s UI. For now it will create a CrimeAdapter and set it on the
RecyclerView .*/
    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }
}
