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

        /************************* Comment or delete this line **************************/
        //Toast.makeText(getContext(), "You Clicked: " + thisItem.getDetails(), Toast.LENGTH_SHORT).show();

/******************************* Add this code **********************************/
        //Create the intent for navigation purposes; the context is the current Activity, so getActivity() must be called
        Intent i = new Intent(getActivity(), EarthquakeDetailActivity.class);
        //Set information in the intent for the next Activity
        i.putExtra("DETAILS", thisItem.getDetails());
        i.putExtra("TIME", thisItem.getDate().toString());
        //Launch the new Activity
        startActivity(i);
/******************************* Add this code **********************************/
        }
        };