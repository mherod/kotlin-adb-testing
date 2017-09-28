@file:Suppress("MemberVisibilityCanPrivate", "unused")

package co.herod.adbwrapper.model

import co.herod.adbwrapper.util.UiHelper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

class UiHierarchy(
        val xmlString: String,
        val adbDevice: AdbDevice?,
        val dumpDate: Date = Date()
) {

    val childUiNodes: MutableList<UiNode> by lazy {
        UiHelper.uiXmlToNodes(Observable.just(xmlString))
                .observeOn(Schedulers.computation())
                .toList()
                .blockingGet()
    }

    override fun toString(): String {
        return "UiHierarchy(xmlString='$xmlString', adbDevice=$adbDevice, dumpDate=$dumpDate)"
    }
}
