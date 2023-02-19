package com.example.moroz_lesson3

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.moroz_lesson3.databinding.AstonButtonBinding

class AstonButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defResAttrs: Int = 0,
    defResStyles: Int = 0,
) : ConstraintLayout(context, attrs, defResAttrs, defResStyles) {

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
            val titleText = typedArray.getText(R.styleable.AstonButtonView_titleText)
            titleCustomView.text = titleText ?: context.getString(R.string.title_customView)

            val subtitleText = typedArray.getText(R.styleable.AstonButtonView_subtitleText)
            subtitleCustomView.text =
                subtitleText ?: context.getString(R.string.subtitle_customView)

            val titleTextColor =
                typedArray.getColor(R.styleable.AstonButtonView_titleTextColor, Color.BLACK)
            titleCustomView.backgroundTintList = ColorStateList.valueOf(titleTextColor)

            val subtitleTextColor =
                typedArray.getColor(R.styleable.AstonButtonView_subtitleTextColor, Color.BLACK)
            subtitleCustomView.backgroundTintList = ColorStateList.valueOf(subtitleTextColor)

            val customImage =
                typedArray.getDrawable(R.styleable.AstonButtonView_customImage)
            logoCustomView.background = customImage

        }
        typedArray.recycle()
    }

}