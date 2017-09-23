@file:Suppress("unused", "ObjectPropertyName", "MemberVisibilityCanPrivate")

package co.herod.adbwrapper

import co.herod.adbwrapper.model.AdbUiHierarchy
import co.herod.adbwrapper.model.UiNode
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object AdbBusManager {

    internal val _outputBus: BusSubject<String> = MainBusSubject()
    val outputBus: BusSubject<String>
        get() = _outputBus

    internal val _uiHierarchyBus: BusSubject<AdbUiHierarchy> = AdbUiHierarchyBus()
    val uiHierarchyBus: Observable<AdbUiHierarchy>
        get() = _uiHierarchyBus

    internal val _uiNodeBus: BusSubject<UiNode> = AdbUiNodeBus()
    val uiNodeBus: Observable<UiNode>
        get() = _uiNodeBus

    internal fun throttledBus(): Observable<String>? = outputBus.concatMap {
        Observable.timer(10, TimeUnit.MILLISECONDS)
                .flatMap { _ -> Observable.just(it) }
    }
}

class MainBusSubject : BusSubject<String>()
class AdbUiHierarchyBus : BusSubject<AdbUiHierarchy>()
class AdbUiNodeBus : BusSubject<UiNode>()
