# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Administrator\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interfaces
# class:
#-keepclassmembers class fqcn.of.javascript.interfaces.for.webview {
#   public *;
#}

#指定代码的压缩级别
-optimizationpasses 5
#表明不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#预校验
-dontpreverify
#忽略警告
-ignorewarnings
#混淆时是否记录日志
-verbose
#混淆时所采用的算法
# 指定混淆时采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不改变
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保持哪些类不被混淆
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference

-keepattributes *Annotation*
-keepattributes *JavascriptInterface*

#app bean
-keep class com.zada.mxgcash.bean.** { *; }
-keep class com.zada.mxgcash.entity.** { *; }
#loan bean
-keep class com.loan.mxgcash.bean.** { *; }
#base
-keep class com.cash.mxgcash.bean.**{*;}
-keep class com.cash.mxgcash.widget.**{*;}
-keep class com.cash.mxgcash.service.**{*;}
#lib bean
-keep class com.lib.mxgcash.bean.** { *; }
#pay bean
-keep class com.pay.zadacash.bean.** { *; }
-keep class com.pay.zadacash.entity.** { *; }
-keep class com.pay.zadacash.enums.** { *; }
#repay bean
-keep class com.repayment.mxgcash.bean.** { *; }
#auth bean
-keep class com.auth.mxgcash.bean.** { *; }
-keep class com.auth.mxgcash.entity.** { *; }
#user bean
-keep class com.user.mxgcash.entity.** { *; }
-keep class com.user.mxgcash.bean.** { *; }

##############other 随机保持混淆###############
#lib
#-keep class com.lib.zada.widget.** { *; }
#-keep class com.lib.zada.listener.** { *; }
#-keep class com.lib.zada.toast.** { *; }
#-keep class com.lib.zada.config.** { *; }

#user
#-keep class com.user.zada.adapter.** { *; }
#-keep class com.user.zada.dialog.** { *; }

#repay
#-keep class com.repayment.zada.adapter.** { *; }
#-keep class com.repayment.zada.dialog.** { *; }

#pay
#-keep class com.pay.zada.adapter.** { *; }

#app
#-keep class com.zora.cash.adapter.** { *; }
#-keep class com.zora.cash.dialog.** { *; }
#-keep class com.auth.zada.popup.** { *; }
#-keep class com.auth.zada.picker.** { *; }

# ViewBinding
-keepclassmembers class * implements androidx.viewbinding.ViewBinding {
  public static ** inflate(...);
  public static ** bind(***);
}

#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
#保持枚举 enum 类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#保持 Serializable 不被混淆
-keep public class * implements java.io.Serializable { public *; }
-keep public class * implements android.os.Parcelable { public *; }

-keepattributes Signature

-keepnames class * implements android.os.Parcelable {
public static final ** CREATOR;
}

# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

# 有了verbose这句话，混淆后就会生成映射文件
# 包含有类名->混淆后类名的映射关系
# 然后使用printmapping指定映射文件的名称
-printmapping priguardMapping.txt


# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable
#不混淆内部类
-keepattributes InnerClasses


#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt

#不混淆内部类
-keepattributes InnerClasses


#------------------  下方是android平台自带的排除项，这里不要动         ----------------

-keep public class * extends android.app.Activity{
	public <fields>;
	public <methods>;
}
-keep public class * extends android.app.Application{
	public <fields>;
	public <methods>;
}

-keepclasseswithmembernames class *{
	native <methods>;
}

#------------------  下方是共性的排除项目         ----------------
# 方法名中含有“JNI”字符的，认定是Java Native Interface方法，自动排除
# 方法名中含有“JRI”字符的，认定是Java Reflection Interface方法，自动排除

-keepclasseswithmembers class * {
    ... *JNI*(...);
}

-keepclasseswithmembernames class * {
	... *JRI*(...);
}

-keep class **JNI* {*;}

-keep class org.devio.takephoto.** { *; }
-dontwarn org.devio.takephoto.**

-keep class com.soundcloud.android.crop.** { *; }
-dontwarn com.soundcloud.android.crop.**

#com.github.dfqin.grantor
-keep class com.github.dfqin.** { *; }

#oss
-keep class com.alibaba.sdk.android.oss.** { *; }
-dontwarn okio.**
-dontwarn org.apache.commons.codec.binary.**

#apache
-keep class org.apache.http.** { *; }
#luban
-keep class top.zibin.luban.** { *; }

#okhttputils
-dontwarn com.zhy.http.**
-keep class com.zhy.http.**{*;}

#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}

#okio
-dontwarn okio.**
-keep class okio.**{*;}

#apache
-keep class org.apache.http.** { *; }

#butterknife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector{ *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

-dontwarn com.bumptech.glide.**
-keep class com.bumptech.glide.** {*;}

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# adjust
-keep class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }


# BaseRecyclerViewAdapterHelper
-keep class com.chad.library.adapter.** {*;}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(...);
}

# 沉浸式状态栏 immersionbar
-keep class com.gyf.immersionbar.* {*;}
-dontwarn com.gyf.immersionbar.**

#EventBus
-keepattributes *Annotation*
-keepclassmembers class * {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# And if you use AsyncExecutor:
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# arouter 混淆规则
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}

# 如果使用了 byType 的方式获取 Service，需添加下面规则，保护接口
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider

# 如果使用了 单类注入，即不定义接口实现 IProvider，需添加下面规则，保护实现x
 -keep class * implements com.alibaba.android.arouter.facade.template.IProvider


-dontwarn dalvik.**
-dontwarn com.tencent.smtt.**

-keep class com.tencent.smtt.** {
    *;
}

-keep class com.tencent.tbs.** {
    *;
}

-keep class com.appsflyer.** { *; }

-keep class com.xingyuhudongchuanmei.yuenan.ui.**{*;}

-keep class com.xingyuhudong.jia001.APPsFLyers.**{*;}

-keep class com.xingyuhudong.jia001.Gson.**{*;}
-keep class com.xingyuhudong.jia001.ExternalCollect.**{*;}
-keep class com.xingyuhudong.jia001.WebView.**{*;}


#rxjava
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#LRecyclerview
-dontwarn com.github.jdsjlzx.**
-keep class com.github.jdsjlzx.progressindicator.indicators.** { *; }

#gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.examples.android.model.** { *; }

#retroift
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions