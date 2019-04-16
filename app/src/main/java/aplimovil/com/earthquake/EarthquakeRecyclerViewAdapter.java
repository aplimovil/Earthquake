/**
 * Applications development for mobile devices
 * -------------------------------------------
 * <p>
 * EarthquakeRecyclerViewAdapter implements an adapter to hold a
 * reference to each View from the Earthquake item layout definition
 * throughout a View Holder.
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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import aplimovil.com.earthquake.databinding.ListItemEarthquakeBinding;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {

    private final List<Earthquake> mEarthquakes;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm", Locale.US);
    private static final NumberFormat MAGNITUDE_FORMAT = new DecimalFormat("0.0");

    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes) {
        mEarthquakes = earthquakes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemEarthquakeBinding binding = ListItemEarthquakeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Earthquake earthquake = mEarthquakes.get(position);
        holder.binding.setEarthquake(earthquake);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ListItemEarthquakeBinding binding;

        public ViewHolder(ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setTimeformat(TIME_FORMAT);
            binding.setMagnitudeformat(MAGNITUDE_FORMAT);
        }
    }
}
