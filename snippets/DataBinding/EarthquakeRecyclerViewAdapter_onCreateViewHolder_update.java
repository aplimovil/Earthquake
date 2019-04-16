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