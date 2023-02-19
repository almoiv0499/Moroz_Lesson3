package com.example.moroz_lesson3

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.moroz_lesson3.databinding.AstonButtonBinding

class AstonButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defResAttrs: Int = DEFAULT_VALUE_FOR_DEF_RES,
    defResStyles: Int = DEFAULT_VALUE_FOR_DEF_RES,
) : ConstraintLayout(context, attrs, defResAttrs, defResStyles) {

    companion object {
        private const val DEFAULT_VALUE_FOR_DEF_RES = 0
    }

    private lateinit var binding: AstonButtonBinding

    init {
        initBinding()
        setAttrs(attrs, defResAttrs, defResStyles)
    }

    private fun initBinding() {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.aston_button, this, true)
        binding = AstonButtonBinding.bind(this)
    }

    private fun setAttrs(attrs: AttributeSet?, defResAttrs: Int, defResStyles: Int) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.AstonButtonView, defResAttrs, defResStyles
        )

        with(binding) {

            // Get values from attrs
            val titleText = typedArray.getString(R.styleable.AstonButtonView_titleText)
                ?: context.getString(R.string.title_customView)
            val subtitleText =
                typedArray.getString(R.styleable.AstonButtonView_subtitleText)
                    ?: context.getString(R.string.subtitle_customView)
            val titleTextColor =
                typedArray.getColor(R.styleable.AstonButtonView_titleTextColor, Color.BLACK)
            val subtitleTextColor =
                typedArray.getColor(R.styleable.AstonButtonView_subtitleTextColor, Color.BLACK)
            val customImage = typedArray.getDrawable(R.styleable.AstonButtonView_customImage)

            // Set values to attrs via xml
            titleCustomView.text = titleText
            subtitleCustomView.text = subtitleText
            titleCustomView.backgroundTintList = ColorStateList.valueOf(titleTextColor)
            subtitleCustomView.backgroundTintList = ColorStateList.valueOf(subtitleTextColor)
            logoCustomView.background = customImage

            // Set value to attrs via code
            setTitleText(titleText)
            setSubtitleText(subtitleText)
            setTitleTextColor(titleTextColor)
            setSubtitleTextColor(subtitleTextColor)
            setImageCustom(customImage)
        }
        typedArray.recycle()
    }

    fun setTitleText(text: String) {
        binding.titleCustomView.text = text
    }

    fun setSubtitleText(text: String) {
        binding.subtitleCustomView.text = text
    }

    fun setTitleTextColor(color: Int) {
        binding.titleCustomView.backgroundTintList = ColorStateList.valueOf(color)
    }

    fun setSubtitleTextColor(color: Int) {
        binding.subtitleCustomView.backgroundTintList = ColorStateList.valueOf(color)
    }

    fun setImageCustom(image: Drawable?) {
        binding.logoCustomView.background = image
    }

}