package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;
    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    // Created a solo instance in the setUp method
    @Override
    public void setUp(){
        solo =new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();
    }

    // All test methods must have a test keyword in the method name
    public void testTweet(){
        // Check if the current activity used is the lonelytwitter activity
        solo.assertCurrentActivity("wrong Activity", "LonelyTwitterActivity");
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void testEqual(){
        assertEquals("not equal", 5, 5);
    }

    public void testAddTweet(){
        solo.enterText((EditText) solo.getView(R.id.body), "new thing");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("new thing"));
    }
}