package co.herod.adbwrapper;

import co.herod.adbwrapper.model.AdbDevice;
import co.herod.adbwrapper.rx.MuteErrorTransformer;

/**
 * Created by matthewherod on 23/04/2017.
 */
public class Playground {

    public static void main(final String[] args) {

        AdbStreams.streamAdbCommands().subscribe(System.out::println);

        final AdbDevice connectedAdbDevice = AdbDeviceManager.getConnectedDevice();

        AdbDeviceActions.turnDeviceScreenOn(connectedAdbDevice);

        AdbUi.startStreamingUiHierarchy(connectedAdbDevice).subscribe();

        AdbBusManager.ADB_UI_HIERARCHY_BUS
                .doOnNext(System.out::println)
                .subscribe();

        AdbBusManager.ADB_UI_NODE_BUS
                .doOnNext(System.out::println)
                .subscribe();

        AdbBusManager.ADB_UI_NODE_BUS
                // .filter(s -> nodeTextContains(s, "0%"))
                // .compose(new FixedDurationTransformer(10, TimeUnit.SECONDS))
                // .debounce(1, TimeUnit.SECONDS)
                // .distinct()
                // .doOnNext(s -> AdbDeviceActions.tapUiNode(connectedAdbDevice, s))
                // .doOnNext(s -> AdbDeviceActions.tapCoords(connectedAdbDevice, 80, 100))
                .subscribe();

        AdbBusManager.ADB_UI_NODE_BUS
                .filter(adbUiNode -> adbUiNode.toString().contains("android.widget.ImageView"))
                .filter(adbUiNode -> adbUiNode.getWidth() > 100 && adbUiNode.getHeight() > 100)
                .doOnNext(uiNode -> ScreenshotHelper.screenshotUiNode(connectedAdbDevice, uiNode))
                .compose(new MuteErrorTransformer<>())
                .subscribe();

        // wait for terminate
        AdbBusManager.ADB_BUS.blockingSubscribe();
    }
}
