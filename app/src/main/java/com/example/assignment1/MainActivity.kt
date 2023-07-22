package com.example.assignment1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.assignment1.R


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var genreSpinner: Spinner
    private lateinit var getRecommendationButton: Button
    private lateinit var recommendationText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genreSpinner = findViewById(R.id.genre_spinner)
        getRecommendationButton = findViewById(R.id.get_recommendation_btn)
        recommendationText = findViewById(R.id.recommendation_text)


        val genres = listOf("Action", "Comedy", "Drama", "Sci-Fi", "Thriller")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genres)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        genreSpinner.adapter = adapter
        genreSpinner.onItemSelectedListener = this@MainActivity

        getRecommendationButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                getMovieRecommendation()
            }
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun getMovieRecommendation() {
        val selectedGenre = genreSpinner.selectedItem.toString()


        val recommendation = "You might enjoy a great $selectedGenre movie!"
        recommendationText.text = recommendation
    }
}
