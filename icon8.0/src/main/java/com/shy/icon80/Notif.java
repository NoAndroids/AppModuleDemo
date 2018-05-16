package com.shy.icon80;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by ShangHongYu on 2018/5/16.
 */

public  class Notif {
    private Context mContext;

    public Notif(Context mContext) {
        this.mContext = mContext;
    }
    //8.0通知
    /**
     * 需要一个NotificationChannel
     * 最少需要3个参数 渠道ID 保证全局唯一
     * 渠道名称  用于给用户看该通知是干什么的
     * 重要等级  Value is IMPORTANCE_UNSPECIFIED, IMPORTANCE_NONE, IMPORTANCE_MIN,
     *          IMPORTANCE_LOW, IMPORTANCE_DEFAULT or IMPORTANCE_HIGH.
     *
     */
    private  String normolId="normol";
    private int normolTag=1;
    private  String normoldesc="普通通知";
    private  int normolImportance= NotificationManager.IMPORTANCE_DEFAULT;
    private  String specialId="special";
    private int specialTag=2;
    private  String specialdesc="特殊通知";
    private  int specialImportance= NotificationManager.IMPORTANCE_HIGH;
    @TargetApi(Build.VERSION_CODES.O)
    public  void normolNoti(){
        NotificationChannel notificationChannel=new NotificationChannel(normolId,normoldesc,normolImportance);
        notificationChannel.enableLights(true);//设置这个通道上的通知是否应该显示通知灯，在支持该功能的设备上。
        notificationChannel.enableVibration(true);//震动
        notificationChannel.setLightColor(R.color.colorAccent);//如果在这个通道上启用了灯光，并且设备支持该特性，那么就为该通道上的通知设置通知灯颜色。
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);//设置这个通道上的通知是否出现在锁屏上，如果是，是否出现在编辑的表单中。
        NotificationManager notificationManager= (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        Notification notification= new Notification.Builder(mContext,normolId)
                .setContentTitle("普通通知")
                .setContentText("这是一个普通通知")
                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .build();
        notificationManager.notify(normolTag,notification);
    }
    @TargetApi(Build.VERSION_CODES.O)
    public  void speNoti(){
        NotificationChannel notificationChannel=new NotificationChannel(specialId,specialdesc,specialImportance);
        notificationChannel.enableLights(true);//设置这个通道上的通知是否应该显示通知灯，在支持该功能的设备上。
        notificationChannel.enableVibration(true);//震动
        notificationChannel.setLightColor(Color.GREEN);//如果在这个通道上启用了灯光，并且设备支持该特性，那么就为该通道上的通知设置通知灯颜色。
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);//设置这个通道上的通知是否出现在锁屏上，如果是，是否出现在编辑的表单中。
        NotificationManager notificationManager= (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1=notificationManager.getNotificationChannel(specialId);
            if (notificationChannel1.getImportance()==NotificationManager.IMPORTANCE_NONE){ //判断用户是否将通知关闭
                Intent intent=new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE,mContext.getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID,notificationChannel1.getId());
                mContext.startActivity(intent);
                Toast.makeText(mContext,"请将特殊通知打开，否则将不会收到聊天信息",Toast.LENGTH_SHORT).show();
            }
        }
        Notification notification= new Notification.Builder(mContext,normolId)
                .setContentTitle("特殊通知")
                .setContentText("这是一个特殊通知")
                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setFullScreenIntent(null,true)
                .setAutoCancel(true)
                .setNumber(3)
                .build();
        notificationManager.notify(specialTag,notification);
    }
}
