package CyberWinPHP.SuperHardSysten;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UsbReceiver extends BroadcastReceiver {
    long currenttime = 0L;

    long lasttime = 0L;

    public void onReceive(Context paramContext, Intent paramIntent) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic currentTimeMillis : ()J
        //   4: putfield currenttime : J
        //   7: getstatic android/os/Build$VERSION.SDK_INT : I
        //   10: bipush #28
        //   12: if_icmplt -> 76
        //   15: aload_2
        //   16: invokevirtual getAction : ()Ljava/lang/String;
        //   19: ldc 'android.intent.action.MEDIA_MOUNTED'
        //   21: invokevirtual equals : (Ljava/lang/Object;)Z
        //   24: ifeq -> 56
        //   27: aload_0
        //   28: getfield currenttime : J
        //   31: aload_0
        //   32: getfield lasttime : J
        //   35: lsub
        //   36: ldc2_w 1000
        //   39: lcmp
        //   40: ifle -> 55
        //   43: aload_0
        //   44: aload_0
        //   45: getfield currenttime : J
        //   48: putfield lasttime : J
        //   51: aload_1
        //   52: invokestatic GetSdPath : (Landroid/content/Context;)V
        //   55: return
        //   56: iconst_0
        //   57: putstatic com/zcadc/util/CommonData.MOUNTED_SD : I
        //   60: aconst_null
        //   61: putstatic com/zcadc/util/CommonData.extSdDir : Ljava/lang/String;
        //   64: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   67: bipush #49
        //   69: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   72: invokevirtual sendToTarget : ()V
        //   75: return
        //   76: aload_2
        //   77: invokevirtual getData : ()Landroid/net/Uri;
        //   80: invokevirtual getPath : ()Ljava/lang/String;
        //   83: astore_3
        //   84: getstatic com/zcadc/util/CommonData.iszcboard : I
        //   87: lookupswitch default -> 112, 2 -> 192, 8 -> 192
        //   112: ldc 'USB'
        //   114: astore_1
        //   115: aload_3
        //   116: invokevirtual toUpperCase : ()Ljava/lang/String;
        //   119: aload_1
        //   120: invokevirtual indexOf : (Ljava/lang/String;)I
        //   123: ifgt -> 132
        //   126: getstatic com/zcadc/util/CommonData.iszcboard : I
        //   129: ifge -> 272
        //   132: aload_2
        //   133: invokevirtual getAction : ()Ljava/lang/String;
        //   136: ldc 'android.intent.action.MEDIA_MOUNTED'
        //   138: invokevirtual equals : (Ljava/lang/Object;)Z
        //   141: ifeq -> 198
        //   144: aload_0
        //   145: getfield currenttime : J
        //   148: aload_0
        //   149: getfield lasttime : J
        //   152: lsub
        //   153: ldc2_w 1000
        //   156: lcmp
        //   157: ifle -> 55
        //   160: aload_0
        //   161: aload_0
        //   162: getfield currenttime : J
        //   165: putfield lasttime : J
        //   168: ldc 'U盘动作'
        //   170: ldc 'U盘接入'
        //   172: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   175: pop
        //   176: aload_3
        //   177: putstatic com/zcadc/util/CommonData.UsbDisk : Ljava/lang/String;
        //   180: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   183: bipush #70
        //   185: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   188: invokevirtual sendToTarget : ()V
        //   191: return
        //   192: ldc 'UDISK'
        //   194: astore_1
        //   195: goto -> 115
        //   198: aload_2
        //   199: invokevirtual getAction : ()Ljava/lang/String;
        //   202: ldc 'android.intent.action.MEDIA_REMOVED'
        //   204: invokevirtual equals : (Ljava/lang/Object;)Z
        //   207: ifeq -> 235
        //   210: ldc 'U盘动作'
        //   212: ldc 'U盘拔出'
        //   214: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   217: pop
        //   218: ldc ''
        //   220: putstatic com/zcadc/util/CommonData.UsbDisk : Ljava/lang/String;
        //   223: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   226: bipush #71
        //   228: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   231: invokevirtual sendToTarget : ()V
        //   234: return
        //   235: aload_2
        //   236: invokevirtual getAction : ()Ljava/lang/String;
        //   239: ldc 'android.intent.action.MEDIA_UNMOUNTED'
        //   241: invokevirtual equals : (Ljava/lang/Object;)Z
        //   244: ifeq -> 55
        //   247: ldc 'U盘动作'
        //   249: ldc 'U盘未接入'
        //   251: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   254: pop
        //   255: ldc ''
        //   257: putstatic com/zcadc/util/CommonData.UsbDisk : Ljava/lang/String;
        //   260: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   263: bipush #71
        //   265: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   268: invokevirtual sendToTarget : ()V
        //   271: return
        //   272: aload_2
        //   273: invokevirtual getAction : ()Ljava/lang/String;
        //   276: ldc 'android.intent.action.MEDIA_MOUNTED'
        //   278: invokevirtual equals : (Ljava/lang/Object;)Z
        //   281: ifeq -> 312
        //   284: ldc 'SD卡动作'
        //   286: ldc 'SD卡接入'
        //   288: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   291: pop
        //   292: iconst_1
        //   293: putstatic com/zcadc/util/CommonData.MOUNTED_SD : I
        //   296: aload_3
        //   297: putstatic com/zcadc/util/CommonData.extSdDir : Ljava/lang/String;
        //   300: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   303: bipush #49
        //   305: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   308: invokevirtual sendToTarget : ()V
        //   311: return
        //   312: aload_2
        //   313: invokevirtual getAction : ()Ljava/lang/String;
        //   316: ldc 'android.intent.action.MEDIA_REMOVED'
        //   318: invokevirtual equals : (Ljava/lang/Object;)Z
        //   321: ifeq -> 352
        //   324: ldc 'SD卡动作'
        //   326: ldc 'SD卡拔出'
        //   328: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   331: pop
        //   332: iconst_0
        //   333: putstatic com/zcadc/util/CommonData.MOUNTED_SD : I
        //   336: aconst_null
        //   337: putstatic com/zcadc/util/CommonData.extSdDir : Ljava/lang/String;
        //   340: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   343: bipush #49
        //   345: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   348: invokevirtual sendToTarget : ()V
        //   351: return
        //   352: aload_2
        //   353: invokevirtual getAction : ()Ljava/lang/String;
        //   356: ldc 'android.intent.action.MEDIA_UNMOUNTED'
        //   358: invokevirtual equals : (Ljava/lang/Object;)Z
        //   361: ifeq -> 55
        //   364: ldc 'SD卡动作'
        //   366: ldc 'SD卡未接入'
        //   368: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   371: pop
        //   372: iconst_0
        //   373: putstatic com/zcadc/util/CommonData.MOUNTED_SD : I
        //   376: aconst_null
        //   377: putstatic com/zcadc/util/CommonData.extSdDir : Ljava/lang/String;
        //   380: getstatic com/zcadc/util/CommonData.handler : Landroid/os/Handler;
        //   383: bipush #49
        //   385: invokevirtual obtainMessage : (I)Landroid/os/Message;
        //   388: invokevirtual sendToTarget : ()V
        //   391: return
    }
}


/* Location:              D:\wlzc_institute\wlzc\wlzc1-dex2jar.jar!\com\zcadc\main\UsbReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
