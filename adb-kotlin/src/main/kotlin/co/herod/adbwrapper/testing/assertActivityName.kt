package co.herod.adbwrapper.testing

import java.util.concurrent.TimeUnit

fun AdbDeviceTestHelper.assertActivityName(activityName: String) = with(adbDevice) {

    try {
        val value = matchActivity(activityName, 5, TimeUnit.SECONDS)
        assert(value) {
            "Did not see $activityName activity"
        }
    } catch (exception: IllegalStateException) {
        throw AssertionError(exception)
    }
}