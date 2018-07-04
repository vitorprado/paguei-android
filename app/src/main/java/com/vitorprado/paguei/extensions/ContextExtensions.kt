package com.vitorprado.paguei.extensions

import android.app.Activity
import android.content.Context
import android.os.Build
import android.support.annotation.ColorRes
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Context.color(@ColorRes colorId: Int): Int {
    return ResourcesCompat.getColor(resources, colorId, null)
}

fun Activity.disableBackSharedElementAnimation(sharedView: View) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return

    Completable.create { emitter ->
        Thread.sleep(5000)
        emitter.onComplete()
    }
    .subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({
        window.sharedElementReturnTransition = null
        window.sharedElementReenterTransition = null
        sharedView.transitionName = null
    })
}

fun Activity.closeAfterTwoSeconds() {
    Completable.create { emitter ->
        Thread.sleep(2000)
        emitter.onComplete()
    }
    .subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({ this.finish() })
}
