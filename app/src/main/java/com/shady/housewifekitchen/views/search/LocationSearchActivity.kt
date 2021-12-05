package com.shady.housewifekitchen.views.search

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.databinding.ActivityLocationSearchBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class LocationSearchActivity : AppCompatActivity(), GoogleMap.OnMarkerClickListener,OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var latLng: LatLng

    private lateinit var binding: ActivityLocationSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocationSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goCart.setOnClickListener {
            startActivity(Intent(this, CartViewActivity::class.java))
        }

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        Handler().postDelayed({
            getCurrentLocation()
        },4000)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
        val loc = mMap.myLocation

        try {
            val sydney = LatLng(loc.latitude, loc.longitude)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f), 5000, null)

        }catch (e:Exception){

        }
        mMap.setOnMarkerClickListener(this);

        setupLocClient()
        // Add a marker in Sydney and move the camera
    }

    private lateinit var fusedLocClient: FusedLocationProviderClient
    // use it to request location updates and get the latest location

    private fun setupLocClient() {
        fusedLocClient =
            LocationServices.getFusedLocationProviderClient(this)
    }

    @SuppressLint("NewApi")
    private fun getCurrentLocation() {
        setupLocClient()
        // Check if the ACCESS_FINE_LOCATION permission was granted before requesting a location
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {

            // call requestLocPermissions() if permission isn't granted
            requestLocPermissions()
        } else {

            fusedLocClient.lastLocation.addOnCompleteListener {
                // lastLocation is a task running in the background
                val location = it.result //obtain location
                if (location != null) {

                    latLng = LatLng(location.latitude, location.longitude)

                    Toast.makeText(this, latLng.toString(), Toast.LENGTH_SHORT).show()

                    mMap.addMarker(MarkerOptions().position(latLng).title("get by gps").icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.ic_home2)
                    ))

                    mMap.addMarker(MarkerOptions().position(LatLng(latLng.latitude+.005,latLng.longitude)).title("get by gps").snippet("")
                        .icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.ic_home)
                    ))

                    mMap.addMarker(MarkerOptions().position(LatLng(latLng.latitude-.005,latLng.longitude+.001)).title("get by gps").icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.ic_home)
                    ))

                    mMap.addMarker(MarkerOptions().position(LatLng(latLng.latitude-.001,latLng.longitude-.005)).title("get by gps").icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.ic_home)
                    )).tag  = 1

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f), 5000, null)

                    mMap.addCircle(CircleOptions().center(latLng).radius(1000.0).strokeColor(Color.BLUE).strokeWidth(1f).fillColor(getColor(R.color.mapColor1)))

                    mMap.addCircle(CircleOptions().center(latLng).radius(500.0).strokeColor(Color.RED).strokeWidth(1f).fillColor(getColor(R.color.mapColor2)))


                } else {
                    Toast.makeText(this, "not found location", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "No location found")
                }
            }
        }
    }

    private fun requestLocPermissions() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), //permission in the manifest
            REQUEST_LOCATION)
    }

    companion object {
        private const val REQUEST_LOCATION = 1 //request code to identify specific permission request
        private const val TAG = "logapp" // for debugging
    }

    private fun getShowView(tag: Any?) {
        val alertDialogBuilder = AlertDialog.Builder(this,R.style.customDialog)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_meal, null)

        alertDialogBuilder.setView(dialogLayout)
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        if (marker != null) {
            if (marker.position != latLng)
            getShowView(marker.tag)
        }
        Toast.makeText(this,
            "marker.getTitle()" +
                    " has been clicked " + 1 + " times.",
            Toast.LENGTH_SHORT).show();
        return false
    }

}