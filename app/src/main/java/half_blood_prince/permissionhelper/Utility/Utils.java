package half_blood_prince.permissionhelper.Utility;

import android.Manifest;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

import half_blood_prince.permissionhelper.Application;
import half_blood_prince.permissionhelper.base.PermissionHelper;

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

    public static Map<Integer, PermissionHelper.PermissionModel> getSignlePermission() {
        Map<Integer, PermissionHelper.PermissionModel> permissions = new LinkedHashMap<>();
        permissions.put(0x01, new PermissionHelper.PermissionModel(
                Manifest.permission.CALL_PHONE,
                "Call phone",
                "This permission is required to make phone calls"));
        return permissions;
    }

    public static Map<Integer, PermissionHelper.PermissionModel> getGroupPermission() {
        Map<Integer, PermissionHelper.PermissionModel> permissions = new LinkedHashMap<>();
        permissions.put(0x01, new PermissionHelper.PermissionModel(
                Manifest.permission.CALL_PHONE,
                "Call phone",
                "This permission is required to make phone calls"));
        permissions.put(0x02, new PermissionHelper.PermissionModel(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                "Write external",
                "This permission is required to write data on memory"));
        return permissions;
    }
}
