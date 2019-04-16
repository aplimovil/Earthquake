
//***** Add this code to EarthquakeRecyclerViewAdapter variables definition section ********

private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm", Locale.US);
private static final NumberFormat MAGNITUDE_FORMAT = new DecimalFormat("0.0");

//***** Add this code to EarthquakeRecyclerViewAdapter variables definition section ********


//******** Override the ViewHolder class definition ***********

public static class ViewHolder extends RecyclerView.ViewHolder {
    public final TextView date;
    public final TextView details;
    public final TextView magnitude;

    public ViewHolder(View view) {
        super(view);
        date = (TextView) view.findViewById(R.id.date);
        details = (TextView) view.findViewById(R.id.details);
        magnitude = (TextView) view.findViewById(R.id.magnitude);
    }
}

//******** Override the ViewHolder class definition ***********


//******** Override the onBindViewHolder method implementation ******

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Earthquake earthquake = mEarthquakes.get(position);
        holder.date.setText(TIME_FORMAT.format(earthquake.getDate()));
        holder.details.setText(earthquake.getDetails());
        holder.magnitude.setText(
                MAGNITUDE_FORMAT.format(earthquake.getMagnitude()));
    }

//******** Override the onBindViewHolder method implementation ******