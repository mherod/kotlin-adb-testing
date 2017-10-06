package co.herod.adbwrapper.ui.dump

import co.herod.adbwrapper.device.rpcSession
import co.herod.adbwrapper.exceptions.UiAutomatorBridgeUnavailableException
import co.herod.adbwrapper.model.AdbDevice
import co.herod.adbwrapper.ui.Blah.Companion.subject
import co.herod.adbwrapper.ui.isUiAutomatorActive
import co.herod.adbwrapper.uiautomator.RpcSession
import co.herod.adbwrapper.uiautomator.pingUiAutomatorBridge
import co.herod.kotlin.ext.retryWithTimeout
import co.herod.kotlin.log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun AdbDevice.rpcDumpUiHierarchy(): Observable<String> {

//    if (isUiAutomatorActive().not()) {
//        return Observable.error(UiAutomatorBridgeUnavailableException())
//    }

    return RpcSession.dumpWindowHierarchy(rpcSession())
            .toObservable()
            .doOnError { println("Error: $it") } //; subject.onNext(false) }
//            .doOnSubscribe { print("Subscribe rpcDumpUiHierarchy") }
//            .doOnDispose { print("Dispose rpcDumpUiHierarchy") }
            .doOnNext { println(it.substringBefore("class").substringAfterLast("node")) }
            .retryWithTimeout(1800, TimeUnit.MILLISECONDS)
}

