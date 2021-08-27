### Note:
```xml
<activity
  android:name=".ProfileActivity"
  android:exported="true"
  android:launchMode="singleTop">
  <intent-filter android:autoVerify="true">
    <action android:name="android.intent.action.VIEW" />

    <category android:name="android.intent.category.BROWSABLE" />
    <category android:name="android.intent.category.DEFAULT" />

    <data
      android:host="namnh-0652.github.io"
      android:scheme="https"
      android:pathPrefix="/profile" />
  </intent-filter>
</activity>
```
- launchMode should be singleTop or singleTask if you don't want to open a new activity
- Using `Tools > Applink assistant` to generate and verify (test) `assetlink.json`
- Add `assetlink.json` to `https://your_domain/.well-known/assetlinks.json`

Command to test AppLink
- Worked:
  - `adb shell am start -W -a android.intent.action.VIEW -d "https://namnh-0652.github.io/profile?userName=NamNH"`
  
With AppLink, if your app is installed, your app will open immediately without open chooser.
otherwise, default browser will be opened.

References:

- Video: https://www.youtube.com/watch?v=lpaByLW_ctw 
- Docs: https://developer.android.com/training/app-links/deep-linking
