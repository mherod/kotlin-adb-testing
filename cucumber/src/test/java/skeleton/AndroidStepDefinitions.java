package skeleton;

import junit.framework.AssertionFailedError;

import java.util.List;

import co.herod.adbwrapper.AdbDeviceActions;
import co.herod.adbwrapper.AdbDeviceManager;
import co.herod.adbwrapper.AdbPackageManager;
import co.herod.adbwrapper.model.AdbDevice;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AndroidStepDefinitions {

    private final AdbTestHelperBridge testHelperBridge;

    private AdbDevice connectedAdbDevice = null;

    public AndroidStepDefinitions() {
        testHelperBridge = new AdbTestHelperBridge(this);
    }

    AdbDevice getConnectedAdbDevice() {
        return connectedAdbDevice;
    }

    @Given("^I am not logged in$")
    public void iAmNotLoggedIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the \"([^\"]*)\" activity$")
    public void iAmOnTheActivity(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am ready$")
    public void iAmReady() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I attempt login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAttemptLoginWithUsernameAndPassword(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the floating action button$")
    public void iClickTheFloatingActionButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the left switcher$")
    public void iClickTheLeftSwitcher() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the right switcher$")
    public void iClickTheRightSwitcher() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I close the navigation drawer$")
    public void iCloseTheNavigationDrawer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I dismiss the tip dialog$")
    public void iDismissTheTipDialog() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I do not see any progress indicators$")
    public void iDoNotSeeAnyProgressIndicators() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I do not see any whitespace$")
    public void iDoNotSeeAnyWhitespace() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I do not see the \"([^\"]*)\" text$")
    public void iDoNotSeeTheText(String text) throws Throwable {
        testHelperBridge.failOnText(text);
    }

    @Then("^I do not see the text \"([^\"]*)\"$")
    public void iDoNotSeeTheText2(String text) throws Throwable {
        testHelperBridge.failOnText(text);
    }

    @Then("^I do not see the text \"([^\"]*)\" disappear$")
    public void iDoNotSeeTheTextDisappear(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag down$")
    public void iDragDown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag down along the left side$")
    public void iDragDownAlongTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag down along the right side$")
    public void iDragDownAlongTheRightSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I drag down from the left side$")
    public void iDragDownFromTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I drag to scroll down$")
    public void iDragToScrollDown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I drag to scroll up$")
    public void iDragToScrollUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag up$")
    public void iDragUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag up along the left side$")
    public void iDragUpAlongTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I drag up along the right side$")
    public void iDragUpAlongTheRightSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I drag up from the left side$")
    public void iDragUpFromTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I enter \"([^\"]*)\" into \"([^\"]*)\"$")
    public void iEnterInto(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I enter \"([^\"]*)\" into input field number (\\d+)$")
    public void iEnterIntoInputFieldNumber(String arg0, int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter text \"([^\"]*)\" into field with id \"([^\"]*)\"$")
    public void iEnterTextIntoFieldWithId(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I go back$")
    public void iGoBack() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have a connected device$")
    public void iHaveAConnectedDevice() throws Throwable {

        if (connectedAdbDevice == null) {
            connectedAdbDevice = AdbDeviceManager.INSTANCE.getConnectedDevice();
        }
    }

    @Then("^I have a connected device with the package \"([^\"]*)\" version \"([^\"]*)\"$")
    public void iHaveAConnectedDeviceWithThePackageVersion(String packageName, String versionName) throws Throwable {

        final List<String> packages = AdbPackageManager.INSTANCE.listPackages(connectedAdbDevice)
                .blockingGet();

        if (!packages.contains(packageName)) {
            throw new AssertionFailedError("Packages list did not contain " + packageName);
        }

        // TODO check version
    }

    @Then("^I have a connected device without the package \"([^\"]*)\"$")
    public void iHaveAConnectedDeviceWithoutThePackage(String packageName) throws Throwable {

        final List<String> packages = AdbPackageManager.INSTANCE.listPackages(connectedAdbDevice)
                .blockingGet();

        if (packages.contains(packageName)) {
            throw new AssertionFailedError("Packages list contained " + packageName);
        }
    }

    @Given("^I have a device with power at least (\\d+)$")
    public void iHaveADeviceWithPowerAtLeast(int minPower) throws Throwable {

        if (connectedAdbDevice == null) {
            connectedAdbDevice = AdbDeviceManager.INSTANCE.getConnectedDevice();
        }

        // TODO assert power
    }

    @When("^I install the apk at \"([^\"]*)\"$")
    public void iInstallTheApkAt(String apkPath) throws Throwable {

        AdbPackageManager.INSTANCE.installPackage(connectedAdbDevice, apkPath);
    }

    @When("^I launch the app \"([^\"]*)\"$")
    public void iLaunchTheApp(String packageName) throws Throwable {

        AdbPackageManager.INSTANCE.launchApp(connectedAdbDevice, packageName);
    }

    @When("^I login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithUsernameAndPassword(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I open the navigation drawer$")
    public void iOpenTheNavigationDrawer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I scroll down$")
    public void iScrollDown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I scroll until I see the text \"([^\"]*)\"$")
    public void iScrollUntilISeeTheText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I scroll until I see the \"([^\"]*)\" text$")
    public void iScrollUntilISeeTheText2(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I scroll up$")
    public void iScrollUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I scroll up until I see the \"([^\"]*)\" text$")
    public void iScrollUpUntilISeeTheText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see a button$")
    public void iSeeAButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see a large image$")
    public void iSeeALargeImage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see the \"([^\"]*)\" text$")
    public void iSeeTheText(String text) throws Throwable {

        testHelperBridge.waitForText(text);
    }

    @When("^I see the text \"([^\"]*)\"$")
    public void iSeeTheText2(String text) throws Throwable {

        testHelperBridge.waitForText(text);
    }

    @When("^I select the \"([^\"]*)\" drawer option$")
    public void iSelectTheDrawerOption(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the lock screen$")
    public void iShouldSeeTheLockScreen() throws Throwable {

    }

    @When("^I swipe down along the left side$")
    public void iSwipeDownAlongTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe down along the right side$")
    public void iSwipeDownAlongTheRightSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe from the bottom$")
    public void iSwipeFromTheBottom() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe from the left$")
    public void iSwipeFromTheLeft() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe from the right$")
    public void iSwipeFromTheRight() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe from the top$")
    public void iSwipeFromTheTop() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I swipe left to the next view$")
    public void iSwipeLeftToTheNextView() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe open the left drawer$")
    public void iSwipeOpenTheLeftDrawer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe open the right drawer$")
    public void iSwipeOpenTheRightDrawer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe up$")
    public void iSwipeUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe up along the left side$")
    public void iSwipeUpAlongTheLeftSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I swipe up along the right side$")
    public void iSwipeUpAlongTheRightSide() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I take a screenshot$")
    public void iTakeAScreenshot() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I touch the menu dropdown$")
    public void iTouchTheMenuDropdown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I touch the \"([^\"]*)\" text$")
    public void iTouchTheText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I turn the screen on$")
    public void iTurnTheScreenOn() throws Throwable {

        AdbDeviceActions.INSTANCE.turnDeviceScreenOn(connectedAdbDevice);
    }

    @When("^I uninstall the package \"([^\"]*)\"$")
    public void iUninstallThePackage(String packageName) throws Throwable {

        AdbPackageManager.INSTANCE.uninstallPackage(connectedAdbDevice, packageName);
    }

    @When("^I update the app with the apk at \"([^\"]*)\"$")
    public void iUpdateTheAppWithTheApkAt(String apkPath) throws Throwable {

        AdbPackageManager.INSTANCE.updatePackage(connectedAdbDevice, apkPath);
    }

    @Then("^I wait$")
    public void iWait() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait for the \"([^\"]*)\" text$")
    public void iWaitForTheText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait for the \"([^\"]*)\" text to disappear$")
    public void iWaitForTheTextToDisappear(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait for \"([^\"]*)\" to appear$")
    public void iWaitForToAppear(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait up to (\\d+) seconds for \"([^\"]*)\" to appear$")
    public void iWaitUpToSecondsForToAppear(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I wait up to (\\d+) seconds to see \"([^\"]*)\"$")
    public void iWaitUpToSecondsToSee(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
