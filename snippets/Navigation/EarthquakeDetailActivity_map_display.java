
/************* Modify the class declaration to implement View.OnClickListener interface ************/

public class EarthquakeDetailActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables to store the information from the intent
    String earthquakeLocation;
    String earthquakeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_detail);
        //Capture the intent from previous activity
        Intent i = getIntent();
        //Get the intent information
        Bundle b = i.getExtras();
        earthquakeLocation = b.getString("DETAILS");
        earthquakeTime = b.getString("TIME");

        TextView earthquakeDetails = (TextView) findViewById(R.id.earthquakedetails);
        earthquakeDetails.setText("An earthquake took place in: " + earthquakeLocation + " at " + earthquakeTime + ". We were delivering more information soon.");

        /****************************** Add this code ************************************/
        Button mapButton = (Button)findViewById(R.id.mapbutton);
        mapButton.setOnClickListener(this);
        /****************************** Add this code ************************************/
    }

    /****************************** Add this code ************************************/
    @Override
    public void onClick(View view) {
        String coordinates;
        if (earthquakeLocation.equals("San Jose")) coordinates = "37.330233,-121.888113";
        else if (earthquakeLocation.equals("LA")) coordinates = "34.039907, -118.261863";
        else coordinates = "37.440092, -122.143413";
        //Create an URI for Google Maps
        Uri uri = Uri.parse("geo:" + coordinates);
        //Create an implicit intent the Android runtime will resolve to display the correct Activity (Google Maps)
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
    /****************************** Add this code ************************************/
}