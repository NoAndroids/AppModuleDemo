package com.shy.yishutansuo;

import android.os.Parcel;
import android.os.Parcelable;

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
 * Created by ShangHongYu on 2017/11/13.
 */

public class Text2 implements Parcelable {
  public int userID;
    public  String userName;
    public boolean isMale;
    public  Text1 text1;

    public Text2(int userID, String userName, boolean isMale, Text1 text1) {
        this.userID = userID;
        this.userName = userName;
        this.isMale = isMale;
//        this.text1 = text1;
    }

    protected Text2(Parcel in) {
        userID = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        text1=in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Creator<Text2> CREATOR = new Creator<Text2>() {
        @Override
        public Text2 createFromParcel(Parcel in) {
            return new Text2(in);
        }

        @Override
        public Text2[] newArray(int size) {
            return new Text2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userID);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
//        dest.writeParcelable(text1,0);
    }
}
