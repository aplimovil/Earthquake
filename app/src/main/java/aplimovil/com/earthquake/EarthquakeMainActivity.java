/**
 * Applications development for mobile devices
 * -------------------------------------------
 * <p>
 * Earthquake example implements an an app that will use a feed of earthquake
 * data from the United States Geological Survey (USGS) to display a list
 * (and eventually a map) of recent earthquakes.
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

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EarthquakeMainActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";
    EarthquakeListFragment mEarthquakeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_main);
        FragmentManager fm = getSupportFragmentManager();
// Android will automatically re-add any Fragments that
// have previously been added after a configuration change, // so only add it if this isn't an automatic restart.
        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();
            mEarthquakeListFragment = new EarthquakeListFragment();
            ft.add(R.id.main_activity_frame,
                    mEarthquakeListFragment, TAG_LIST_FRAGMENT);
            ft.commitNow();
        } else {
            mEarthquakeListFragment = (EarthquakeListFragment) fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        Date now = Calendar.getInstance().getTime();
        List<Earthquake> dummyQuakes = new ArrayList<Earthquake>(0);
        dummyQuakes.add(new Earthquake("0", now, "San Jose", null, 7.3, null));
        dummyQuakes.add(new Earthquake("1", now, "LA", null, 6.5, null));
        dummyQuakes.add(new Earthquake("2", now, "Palo alto", null, 5.1, null));
        mEarthquakeListFragment.setEarthquakes(dummyQuakes);
    }
}
