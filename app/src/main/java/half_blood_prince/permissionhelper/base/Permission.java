package half_blood_prince.permissionhelper.base;

import android.Manifest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sridhar on 5/8/2017.
 * Class holds the permission info
 */

public class Permission {

    public enum PermissionMap {

        REQ_CODE_CALL_PHONE(0x01, Manifest.permission.CALL_PHONE),
        REQ_CODE_WRITE_EXTERNAL_STORAGE(0x02, Manifest.permission.WRITE_EXTERNAL_STORAGE),
        REQ_CODE_WRITE_CALENEDER(0x03, Manifest.permission.WRITE_CALENDAR),
        REQ_CODE_SEND_SMS(0x04, Manifest.permission.SEND_SMS),
        REQ_CODE_WRITE_CONTACTS(0x05, Manifest.permission.WRITE_CONTACTS);

        private int reqCode;
        private String permission;

        PermissionMap(int reqCode, String permission) {
            this.reqCode = reqCode;
            this.permission = permission;
        }

    }

    public static Map<Integer, PermissionHelper.PermissionModel> getSignlePermission() {

        Map<Integer, PermissionHelper.PermissionModel> permissions = new LinkedHashMap<>();
        permissions.put(PermissionMap.REQ_CODE_CALL_PHONE.reqCode,
                new PermissionHelper.PermissionModel(
                        PermissionMap.REQ_CODE_CALL_PHONE.permission,
                        "Call phone",
                        "This permission is required to make phone calls"));
        return permissions;
    }

    public static Map<Integer, PermissionHelper.PermissionModel> getGroupPermission() {
        Map<Integer, PermissionHelper.PermissionModel> permissions = new LinkedHashMap<>();

        permissions.put(PermissionMap.REQ_CODE_WRITE_EXTERNAL_STORAGE.reqCode,
                new PermissionHelper.PermissionModel(
                        PermissionMap.REQ_CODE_WRITE_EXTERNAL_STORAGE.permission,
                        "Write external",
                        "This permission is required to write data on memory"));
        permissions.put(PermissionMap.REQ_CODE_WRITE_CALENEDER.reqCode,
                new PermissionHelper.PermissionModel(
                        PermissionMap.REQ_CODE_WRITE_CALENEDER.permission,
                        "Write calender",
                        "This permission is required to write on calender"));
        permissions.put(PermissionMap.REQ_CODE_SEND_SMS.reqCode,
                new PermissionHelper.PermissionModel(
                        PermissionMap.REQ_CODE_SEND_SMS.permission,
                        "Send Sms",
                        "This permission is required to send sms"));
        permissions.put(PermissionMap.REQ_CODE_WRITE_CONTACTS.reqCode,
                new PermissionHelper.PermissionModel(
                        PermissionMap.REQ_CODE_WRITE_CONTACTS.permission,
                        "Write contacts",
                        "This permission is required to write contacts"));

        return permissions;
    }

}
