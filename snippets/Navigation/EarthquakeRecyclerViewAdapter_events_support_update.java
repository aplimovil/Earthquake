public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {

    . . .

    //Step 1 of 3: Defines a variable for listening user interactions with the items list
    private static View.OnClickListener mOnItemClickListener;

    . . .


    //Step 2 of 3: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    . . .

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ListItemEarthquakeBinding binding;

        public ViewHolder(ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setTimeformat(TIME_FORMAT);
            binding.setMagnitudeformat(MAGNITUDE_FORMAT);

            //Step 3 of 3: setTag() as current view holder along with
            // setOnClickListener() as your local View.OnClickListener variable.
            // You can set the same mOnItemClickListener on multiple views if required
            // and later differentiate those clicks using view's id.
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }