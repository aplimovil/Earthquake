/**
 *
 * Applications development for mobile devices
 * -------------------------------------------
 *
 * EarthquakeRecyclerViewAdapter implements an adapter to hold a
 * reference to each View from the Earthquake item layout definition
 * throughout a View Holder.
 *
 * @author Francisco Martinez
 *
 * This example is based on the source code from the book
 * of Reto Meier and Ian Lake - Professional Android
 * licensed under the Apache License, Version 2.0 (the "License"):
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 */


package aplimovil.com.earthquake;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {
    private final List<Earthquake> mEarthquakes;

    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes) {
        mEarthquakes = earthquakes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.earthquake = mEarthquakes.get(position);
        holder.detailsView.setText(mEarthquakes.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View parentView;
        public final TextView detailsView;
        public Earthquake earthquake;

        public ViewHolder(View view) {
            super(view);
            parentView = view;
            detailsView = (TextView)
                    view.findViewById(R.id.list_item_earthquake_details);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }
    }
}
