package com.lynnpadc.moviebookingapp.ui.activities.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lynnpadc.moviebookingapp.data.models.MovieBookingModel
import com.lynnpadc.moviebookingapp.data.models.MovieBookingModelImpl
import com.lynnpadc.moviebookingapp.databinding.ActivityRegionBinding
import com.lynnpadc.moviebookingapp.ui.activities.MainActivity
import com.lynnpadc.moviebookingapp.ui.adapters.login.RegionAdapter
import com.lynnpadc.moviebookingapp.ui.delgates.RegionViewHolderDelegate

class RegionActivity : AppCompatActivity(), RegionViewHolderDelegate {

    private lateinit var binding: ActivityRegionBinding
    private lateinit var mRegionAdapter: RegionAdapter

    // Model
    private val mMovieBookingModel: MovieBookingModel = MovieBookingModelImpl

    companion object{
        fun newIntent(context: Context): Intent{
            val intent = Intent(context,RegionActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpCitiesRecyclerView()
    }

    private fun setUpCitiesRecyclerView() {
        mRegionAdapter = mMovieBookingModel.getCities()?.let {
            RegionAdapter(it,this)
        }!!
        binding.rvCitiesList.adapter = mRegionAdapter
        binding.rvCitiesList.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL, false)
    }

    override fun onTapRegion(city: String) {
        startActivity(MainActivity.newIntent(this,city))
    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(this,error, Toast.LENGTH_LONG).show()
    }
}