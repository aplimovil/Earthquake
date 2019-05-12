/**
 * Applications development for mobile devices
 * -------------------------------------------
 * <p>
 * EarthquakeListFragment implements a fragment for handling
 * an array of Earthquake instances representing the list of
 * earthquakes to show.
 *
 * @author Francisco Martinez
 * <p>
 * This example is based on the source code from the book
 * of Reto Meier and Ian Lake - Professional Android
 * licensed under the Apache License, Version 2.0 (the "License"):
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 */


package aplimovil.com.earthquake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment {

    private ArrayList<Earthquake> mEarthquakes = new ArrayList<Earthquake>();
    private RecyclerView mRecyclerView;
    private EarthquakeRecyclerViewAdapter mEarthquakeAdapter =
            new EarthquakeRecyclerViewAdapter(mEarthquakes);
    // set a listener to handle events from RecyclerView
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            Earthquake thisItem = mEarthquakes.get(position);
            //Toast.makeText(getContext(), "You Clicked: " + thisItem.getDetails(), Toast.LENGTH_SHORT).show();
            //Create the intent for navigation purposes; the context is the current Activity, so getActivity() must be called
            Intent i = new Intent(getActivity(), EarthquakeDetailActivity.class);
            //Set information in the intent for the next Activity
            i.putExtra("DETAILS", thisItem.getDetails());
            i.putExtra("TIME", thisItem.getDate().toString());
            //Launch the new Activity
            startActivity(i);
        }
    };

    public EarthquakeListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list,
                container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// Set the Recycler View adapter
        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEarthquakeAdapter);

        //Step 1 of 4: Create and set OnItemClickListener to the adapter.
        mEarthquakeAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        for (Earthquake earthquake : earthquakes) {
            if (!mEarthquakes.contains(earthquake)) {
                mEarthquakes.add(earthquake);
                mEarthquakeAdapter
                        .notifyItemInserted(mEarthquakes.indexOf(earthquake));
            }
        }
    }
}
