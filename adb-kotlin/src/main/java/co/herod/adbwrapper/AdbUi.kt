package co.herod.adbwrapper

import co.herod.adbwrapper.AdbBusManager.uiNodeBus
import co.herod.adbwrapper.device.dumpsys
import co.herod.adbwrapper.device.windows
import co.herod.adbwrapper.model.*
import co.herod.adbwrapper.rx.FixedDurationTransformer
import co.herod.adbwrapper.rx.ResultChangeFixedDurationTransformer
import co.herod.adbwrapper.util.UiHelper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun AdbDevice.streamUiHierarchy(): Observable<UiNode> =
        Adb.dumpUiHierarchy(this, 30, TimeUnit.SECONDS)
                .compose(ResultChangeFixedDurationTransformer())
                .map { AdbUiHierarchy(it, this) }
                .doOnEach(AdbBusManager._uiHierarchyBus)
                .map { it.xmlString }
                .compose { UiHelper.uiXmlToNodes(it) }
                .doOnEach(AdbBusManager._uiNodeBus)
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe { System.out.println("Starting streamUiHierarchy") }
                .doOnDispose { System.out.println("Disposing streamUiHierarchy") }

fun AdbDevice.streamUiNodes(packageIdentifier: String? = null): Observable<UiNode> =
        streamUiNodeStringsInternal()
                .map { UiNode(it) }
                .filter { it.packageName == packageIdentifier }

fun AdbDevice.streamUiNodeStrings() =
        streamUiNodeStringsInternal()
                .map { UiNode(it) }
                .map { it.toString() }

fun streamUiNodeStringsInternal(): Observable<String> =
        uiNodeBus
                .map { it.toString() }
                .compose(FixedDurationTransformer(1, TimeUnit.DAYS))
                .onErrorReturn { throwable -> throwable.printStackTrace(); "" }
                .repeat()
                .filter { it.trim().isEmpty().not() }

fun AdbDevice.subscribeUiNodesSource(): Observable<UiNode> =
        Adb.dumpUiNodes(this, 30, TimeUnit.SECONDS)
                .compose(ResultChangeFixedDurationTransformer())
                .distinct { it.toString() }

@Deprecated(
        replaceWith = ReplaceWith("windowBounds"),
        message = "Use the 'windowBounds' property"
)
fun AdbDevice.getWindowBounds(): UiBounds =
        dumpsys().windows().filterProperty("mBounds")
                .map { it.value }
                .filter { '[' in it && ']' in it }
                .map { it.substring(it.lastIndexOf('[') + 1, it.lastIndexOf(']')) }
                .map { it.split(',') }
                .map { it.map { Integer.parseInt(it) } }
                .map { it.toIntArray() }
                .map { UiBounds(it) }
                .blockingGet()