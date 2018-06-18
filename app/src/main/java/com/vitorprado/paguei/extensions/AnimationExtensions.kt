package br.com.digipronto.tradeapp.extensions

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator

fun View.circularReveal(anchorView: View? = null, onDone: () -> Any?) {
    val anchorX = anchorView?.let { it.x + it.width  / 2 } ?: right
    val anchorY = anchorView?.let { it.y + it.height / 2 } ?: bottom

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        circularReveal((anchorX as Number).toInt(), (anchorY as Number).toInt(), onDone)
    } else {
        onDone()
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.circularReveal(anchorX: Int, anchorY: Int, onDone: () -> Any?) {
    val startRadius = 0
    val endRadius = Math.hypot(width.toDouble(), height.toDouble()).toInt()

    val animReveal = ViewAnimationUtils.createCircularReveal(this, anchorX, anchorY, startRadius.toFloat(), endRadius.toFloat())
    animReveal.interpolator = AccelerateDecelerateInterpolator()
    animReveal.duration = 500
    this.visibility = View.VISIBLE
    animReveal.addListener(object: Animator.AnimatorListener {
        override fun onAnimationEnd(p0: Animator?) {
            onDone()
        }
        override fun onAnimationRepeat(p0: Animator?) {}
        override fun onAnimationCancel(p0: Animator?) {}
        override fun onAnimationStart(p0: Animator?) {}
    })
    animReveal.start()
}

fun View.animateColorChange(onDone: () -> Any?, toColor: Int) {
    val fromColor = if (background is ColorDrawable) {
        (background as ColorDrawable).color
    } else {
        Color.parseColor("#FF4081")
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        animateColorChange(onDone, fromColor, toColor)
    } else {
        background = ColorDrawable(toColor)
        onDone()
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.animateColorChange(onDone: () -> Any?, fromColor: Int, toColor: Int) {
    val newAnimation = ObjectAnimator.ofObject(this, "backgroundColor", ArgbEvaluator(), fromColor, toColor)
    newAnimation.addListener(object: Animator.AnimatorListener {
        override fun onAnimationEnd(p0: Animator?) {
            onDone()
        }
        override fun onAnimationRepeat(p0: Animator?) {}
        override fun onAnimationCancel(p0: Animator?) {}
        override fun onAnimationStart(p0: Animator?) {}
    })
    newAnimation.start()
}