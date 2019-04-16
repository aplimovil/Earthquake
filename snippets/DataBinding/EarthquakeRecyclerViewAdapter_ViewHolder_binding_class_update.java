public static class ViewHolder extends RecyclerView.ViewHolder {
    public final ListItemEarthquakeBinding binding;

    public ViewHolder(ListItemEarthquakeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.setTimeformat(TIME_FORMAT);
        binding.setMagnitudeformat(MAGNITUDE_FORMAT);
    }
}