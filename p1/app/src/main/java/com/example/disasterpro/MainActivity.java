package com.example.disasterpro;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;


import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS =123 ;
    PlacesClient placesClient;
    AlertDialog.Builder builder;
    Button b1,b2;
     LatLng latLng=null;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button1);
        final String apiKey = "AIzaSyCahDWNu9KHhEF6WawR1uVtb79U0_QSeVc";

      //  Intent intent=new Intent(getApplicationContext(),MainActivity.class);
      //  PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        if (!Places.isInitialized())
        {
            Places.initialize(MainActivity.this, apiKey);
        }
        // Retrieve a PlacesClient (previously initialized - see MainActivity)
                  placesClient = Places.createClient(MainActivity.this);
                  final AutocompleteSupportFragment autocompleteSupportFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
                  autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG,Place.Field.ADDRESS));
                  autocompleteSupportFragment.setOnPlaceSelectedListener(
                new PlaceSelectionListener()
                {
                    @Override
                    public void onPlaceSelected(Place place)
                    {
                         latLng = place.getLatLng();

                        //Toast.makeText(MainActivity.this, ""+latLng.latitude, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(Status status)
                    {
                        Toast.makeText(MainActivity.this, ""+status.getStatusMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


         b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


               // Intent i= new Intent(MainActivity.this,Main2Activity.class);
               // startActivity(i);
                // Code here executes on main thread after user presses button
            }
        });


       b1.setOnClickListener(new View.OnClickListener()
       {
            public void onClick(View v)
            {
                insertDummyContactWrapper();


            }
        });
        // Intent i= new Intent(MainActivity.this,frag.this);
         //startActivity(i);


    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void insertDummyContactWrapper() {
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.SEND_SMS);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.SEND_SMS},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
        insertDummyContact();

    }
   /* public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    insertDummyContact();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/
    public void insertDummyContact()
    {


        SmsManager sms=SmsManager.getDefault();

        PendingIntent pi=null;
        sms.sendTextMessage("9663853003", null, "Send from android", pi,null);


    }


}
