<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.socialmediaintegration">
    <!--
         The ACCESS_COARSE/FINE_LOCATION permissions are not required to use
         Google Maps Android API v2, but you must specify either coarse or fine
         location permissions for the 'MyLocation' functionality.
    -->
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".pacakage_permission.Activity_CameraPermission"></activity>
        <activity android:name=".package_contentprovider.Activity_AccessContact" />
        <activity android:name=".package_broadcast_task.Activity_Sender">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".package_broadcast_task.Activity_Receiver" />
        <activity android:name=".package_broadcastreceiver.Activity_Task2" />
        <activity android:name=".package_broadcastreceiver.Activity_Task" />
        <activity android:name=".package_broadcastreceiver.Activity_DynamicExplicitReceiver" />
        <activity android:name=".package_broadcastreceiver.Activity_StaticImplicitReceiver" />
        <activity android:name=".package_service.Activity_Service5sec" />
        <activity android:name=".package_Login.Activity_Login" />
        <activity android:name=".package_service.Activity_IntentService" />
        <activity android:name=".package_musicplayer.Activity_MusicPlayer" />
        <activity android:name=".package_service.Activity_Service" />
        <activity android:name=".package_googleintegration.Activity_SearchLocation" />
        <activity
            android:name=".package_googleintegration.Activity_CurrentLocationMap"
            android:label="Current_Location" />
        <!--
             The API key for Google Maps-based APIs is defined as a string resource.
             (See the file "res/values/google_maps_api.xml").
             Note that the API key is linked to the encryption key used to sign the APK.
             You need a different API key for each encryption key, including the release key that is used to
             sign the APK for publishing.
             You can define the keys for the debug and release targets in src/debug/ and src/release/.
        -->
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key" />

        <activity
            android:name=".package_googleintegration.MapsActivity"
            android:label="@string/title_activity_maps" />

        <meta-data
            android:name="com.facebook.sdk.ApplicationId"
            android:value="@string/facebook_app_id" />

        <activity
            android:name="com.facebook.FacebookActivity"
            android:configChanges="keyboard|keyboardHidden|screenLayout|screenSize|orientation"
            android:label="@string/app_name" />
        <activity
            android:name="com.facebook.CustomTabActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data android:scheme="@string/fb_login_protocol_scheme" />
            </intent-filter>
        </activity>
        <activity android:name=".package_googleintegration.Activity_FacebookLogin" />
        <activity android:name=".package_googleintegration.Activity_GoogleSignIn" />
        <activity android:name=".MainActivity" />

        <service
            android:name=".package_service.MyService5Sec"
            android:exported="false" />
        <service
            android:name=".package_service.MyService"
            android:exported="false" />
        <service
            android:name=".package_service.MyIntentService"
            android:exported="false" />

        <receiver android:name=".package_broadcastreceiver.MyBroadcastReceiver">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
            </intent-filter>
        </receiver>
    </application>

</manifest>