### Note:
```xml
<activity
    android:name=".ProfileActivity"
    android:exported="true"
    android:launchMode="singleTask">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.BROWSABLE" />
        <category android:name="android.intent.category.DEFAULT" />
        <!--for app://huunam118.github.io/profile-->
        <data
            android:host="huunam118.github.io"
            android:pathPrefix="/profile"
            android:scheme="app" />
    </intent-filter>
</activity>
```
- launchMode should be singleTop or singleTask if you don't want to open a new activity
- with custom scheme, if app is not installed, nothing happens
- with https, http, if app is not installed, will open the web url (if a default browser is set)

Command to test Deeplink
- Worked:
  - `adb shell am start -W -a android.intent.action.VIEW -d "app://huunam118.github.io/profile?userName=NamNH"`
  - `adb shell am start -W -a android.intent.action.VIEW -d "https://huunam118.github.io/profile?userName=NamNH"`
  
However, with the link starts with `https`, an chooser will be show.
If you want it to not show, setup the `AppLink`.
