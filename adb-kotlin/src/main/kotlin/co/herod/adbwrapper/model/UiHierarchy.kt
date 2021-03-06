@file:Suppress("MemberVisibilityCanPrivate", "unused")

package co.herod.adbwrapper.model

import co.herod.adbwrapper.util.UiHelper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.time.Instant
import java.util.*

class UiHierarchy(
        val adbDevice: AdbDevice?,
        val xmlString: String,
        val dumpDate: Date = Date()
) {
    val dumpTime: Instant by lazy {
        dumpDate.toInstant()
    }

    val uiNodes: MutableList<UiNode> by lazy {
        UiHelper.uiXmlToNodes(Observable.just(xmlString), dumpDate, adbDevice)
                .observeOn(Schedulers.computation())
                .filter { Objects.nonNull(it) }
                .toList()
                .blockingGet()
    }

    @Deprecated(
            replaceWith = ReplaceWith("uiNodes"),
            message = "Property name changed to 'uiNodes'"
    )
    val childUiNodes: MutableList<UiNode> by lazy { uiNodes }

    override fun toString(): String {
        return "UiHierarchy(xmlString='$xmlString', adbDevice=$adbDevice, dumpDate=$dumpDate)"
    }
}
