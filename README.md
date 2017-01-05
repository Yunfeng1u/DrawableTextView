# DrawableTextView



这是一个对TextView进行了简单封装的小控件，可以简单地设置TextView四个方向上的图标，及图标的大小。



![](https://github.com/Yunfeng1u/DrawableTextView/blob/master/art/WX20170105-203619.png)


在开发中我们经常会遇到上图这种情况，多见于设置页，直接的解决办法是
```
    <RelativeLayout
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <ImageView
            android:id="@+id/iv1"
            android:src="@mipmap/ic_launcher"
            android:layout_width="20dp"
            android:layout_height="20dp" />
        <TextView
            android:text="test"
            android:layout_centerVertical="true"
            android:layout_marginLeft="8dp"
            android:layout_toRightOf="@+id/iv1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
        <ImageView
            android:layout_alignParentRight="true"
            android:layout_centerVertical="true"
            android:src="@drawable/arrow_right_thin"
            android:layout_width="16dp"
            android:layout_height="16dp" />
    </RelativeLayout>
```
然后，再好一些的实现是从Android代码中设置。



那程序员最不喜欢的就是重复性工作，使用DrawableTextView，就可以很简单地实现这样的效果
```
    <com.luyunfeng.drawabletextview.DrawableTextView
        app:leftImage="@mipmap/ic_launcher"
        app:rightImage="@drawable/arrow_right_thin"
        app:leftImageSize="20dp"
        app:rightImageSize="16dp"
        android:drawablePadding="8dp"
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:gravity="center_vertical"
        android:text="test"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

除XML布局外，DrawableTextView中提供了如setLeftImage()这样的方法，可以在代码中动态设置。
```
public void setLeftImage(@DrawableRes int drawableId, @DimenRes int dimen) {
        leftImage = getDrawable(drawableId);
        leftImageSize = getSize(dimen);
        refresh();
}
```

如果需要Drawable或int类型参数的方法，大家可以自行添加。

文件只有两个，DrawableTextView.java 和 attr_drawable_textview.xml，现拷现用。
