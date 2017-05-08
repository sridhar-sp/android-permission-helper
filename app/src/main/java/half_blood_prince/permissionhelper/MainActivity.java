package half_blood_prince.permissionhelper;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import half_blood_prince.permissionhelper.Utility.Utils;
import half_blood_prince.permissionhelper.base.PermissionHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSinglePermission;

    private Button btnGroupPermission;

    private PermissionHelper mPermissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        findingViews();
        settingListeners();
    }

    /**
     * Setup toolbar
     */
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Find the global view instance used in this class
     */
    private void findingViews() {
        btnSinglePermission = (Button) findViewById(R.id.btn_single_permission_main_ac);
        btnGroupPermission = (Button) findViewById(R.id.btn_group_permission_main_ac);
    }

    /**
     * Setup the listeners for the views used in this class
     */
    private void settingListeners() {
        btnSinglePermission.setOnClickListener(this);
        btnGroupPermission.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_single_permission_main_ac:
                askSinglePermission();
                break;
            case R.id.btn_group_permission_main_ac:
                askGroupPermission();
                break;
            default:
                break;
        }
    }

    /**
     * Method called when the click happens in {@link #btnSinglePermission}
     */
    private void askSinglePermission() {
        mPermissionHelper = new PermissionHelper(this, Utils.getSignlePermission()) {
            @Override
            protected void permissionGranted(int permissionID) {
                super.permissionGranted(permissionID);
                Utils.showBriefToast("Permission grandted "+permissionID);
            }
        };
        mPermissionHelper.startCheckingPermission();
    }

    /**
     * Method called when the click happens in {@link #btnGroupPermission}
     */
    private void askGroupPermission() {
        mPermissionHelper = new PermissionHelper(this, Utils.getGroupPermission()) {
            @Override
            protected void permissionGranted(int permissionID) {
                super.permissionGranted(permissionID);
                Utils.showBriefToast("Permission grandted "+permissionID);
            }
        };
        mPermissionHelper.startCheckingPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (null != mPermissionHelper)
            mPermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_code_menu_main_ac) {
            openThisProjectInGithub();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openThisProjectInGithub() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/half-blood-prince/android-permission-helper"));
        if (null != intent.resolveActivity(getPackageManager()))
            startActivity(intent);

    }
}
