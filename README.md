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
- Create firebase project and add android app with SHA_256 key
- Add URL prefix to dynamic link
  - If you have a domain for app, use it.
  - If not, use subdomain `.page.link` (free) to use.
- [4 ways to generate Dynamic Link](https://firebase.google.com/docs/dynamic-links/create-links)
  - Using Rest API
  - Using Dynamic Link Builder API for android & iOS
  - Firebase console
  - Manually

References:
- https://developer.android.com/training/app-links/deep-linking
- https://firebase.google.com/docs/dynamic-links
