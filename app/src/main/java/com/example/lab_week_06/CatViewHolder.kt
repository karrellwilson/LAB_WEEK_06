package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class CatViewHolder(
    containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.cat_biography) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.cat_breed) }
    private val catGenderView: TextView by lazy { containerView.findViewById(R.id.cat_gender) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.cat_name) }
    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.cat_photo) }

    private val FEMALE_SYMBOL = "♀"
    private val MALE_SYMBOL = "♂"
    private val UNKNOWN_SYMBOL = "?"

    fun bindData(cat: CatModel) {
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}