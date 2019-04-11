
//*********************** Add this code **********************
private RecyclerView mRecyclerView;
private EarthquakeRecyclerViewAdapter mEarthquakeAdapter=
        new EarthquakeRecyclerViewAdapter(mEarthquakes);
//*********************** Add this code **********************

@Override
public View onCreateView(LayoutInflater inflater,ViewGroup container,
        Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_earthquake_list,
        container,false);

        //*********************** Add this code **********************

        mRecyclerView=(RecyclerView)view.findViewById(R.id.list);

        //*********************** Add this code **********************

        return view;
        }


//************************** Add this code ***************************
@Override
public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
// Set the Recycler View adapter
        Context context=view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEarthquakeAdapter);
        }

//************************** Add this code ****************************