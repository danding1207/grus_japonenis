# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in G:\Program Files\android-sdk-windows/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class com.dodola.rocoofix.** {*;}
-keep class com.lody.legend.** {*;}

-dontwarn com.amap.api.**
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

-keep class org.apache.http.impl.client.**
-dontwarn org.apache.commons.**
-keep class com.blueware.** { *; }
-dontwarn com.blueware.**
-keep class com.oneapm.** {*;}
-dontwarn com.oneapm.**
-keepattributes Exceptions, Signature, InnerClasses
-keepattributes SourceFile, LineNumberTable