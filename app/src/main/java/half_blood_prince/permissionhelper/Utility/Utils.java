package half_blood_prince.permissionhelper.Utility;

import android.content.pm.PackageManager;
import android.widget.Toast;

import half_blood_prince.permissionhelper.Application;

/**
 * Created by Half-Blood-Prince on 5/8/2017.
 * Class contains utility method used frequently
 */

public class Utils {

    /**
     * Method use the app instance to show the toast on screen
     *
     * @param briefToast Brief toast to display
     */
    public static void showBriefToast(String briefToast) {
        Toast.makeText(Application.getAppInstance(), briefToast, Toast.LENGTH_SHORT).show();
    }

    public static String getPermissionResultAsString(int resultConstantCode) {
        if (resultConstantCode == PackageManager.PERMISSION_GRANTED)
            return "Permission granted";
        else if (resultConstantCode == PackageManager.PERMISSION_DENIED)
            return "Permission denied";
        else return "Unknown permission result";
    }
}
