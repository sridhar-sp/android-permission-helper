package half_blood_prince.permissionhelper;

/**
 * Created by Half-Blood-Prince on 5/8/2017.
 * Application class created when the process created for this app,
 * terminates when user force stop the app or clear its existence from background
 */

public class Application extends android.app.Application {

    private static Application mAppInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        synchronized (this) {
            mAppInstance = this;
        }
    }

    @Override
    public void onTerminate() {
        synchronized (this) {
            mAppInstance = null;
        }
        super.onTerminate();
    }

    public static Application getAppInstance() {
        return mAppInstance;
    }
}
