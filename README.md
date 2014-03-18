Neverendingview
===============


Neverendingview is an Open Source Android library that allows developers to easily add a neverending scroll view to their projects. Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.


![Screenshot](https://raw2.github.com/Florismart/Neverendingview/master/screen-app.png)


Setup
-----
__1.__ In Eclipse, import the library as an Android library project. Project > Clean to generate the binaries 
you need, like R.java, etc.

__2.__ Then, add Neverendingview as a dependency to your existing project.


XML Usage
-----
All options are optional. Use only those you really want to customize.

Horizontal
-----

```xml
<com.fattorini.luca.android.neverending.view.HorizontalNeverendingView
    xmlns:neverending="http://schemas.android.com/apk/res-auto"
    android:id="@+id/my_neverendingview1"
    style="@style/Neverendingview.Horizontal"
    app:enabled="true"
    app:mode="natural" >

    <LinearLayout
        style="@style/NeverendingContainer.Horizontal"
        android:orientation="vertical" >

        <TextView
            style="@style/Content.TextView"
            android:text="@string/quote_one" />
            
    </LinearLayout>
        
</com.fattorini.luca.android.neverending.view.HorizontalNeverendingView>
```

Vertical
-----

```xml
<com.fattorini.luca.android.neverending.view.VerticalNeverendingView
    xmlns:neverending="http://schemas.android.com/apk/res-auto"
    android:id="@+id/my_neverendingview2"
    style="@style/Neverendingview.Vertical"
    app:enabled="true"
    app:mode="natural" >

    <LinearLayout
        style="@style/NeverendingContainer.Vertical"
        android:orientation="vertical" >

        <TextView
            style="@style/Content.TextView"
            android:text="@string/quote_two" />
            
    </LinearLayout>
        
</com.fattorini.luca.android.neverending.view.VerticalNeverendingView>
```


