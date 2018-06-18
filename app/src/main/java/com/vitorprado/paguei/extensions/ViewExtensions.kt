package com.vitorprado.paguei.extensions

import android.animation.Animator
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.view.View
import android.view.ViewAnimationUtils

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.circularHide() {
    val cx = (width) / 2
    val cy = (height) / 2

    val dx = Math.max(cx, width - cx)
    val dy = Math.max(cy, height - cy)
    val startRadius = Math.hypot(dx.toDouble(), dy.toDouble()).toFloat()

    ViewAnimationUtils.createCircularReveal(this, cx, cy, startRadius, 0f).apply {
        interpolator = FastOutLinearInInterpolator()
        duration = 400
        addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                this@circularHide.visibility = View.GONE
            }
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}
        })
        start()
    }
}
