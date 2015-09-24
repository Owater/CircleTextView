# CircleTextView
CircleTextView --- Android draw a CircleTextView

# Screenshots
![Main screen](/screenshots/main.png)


#Including in Your Project
Last version is 1.0.0

Just add the following statement in your build.gradle

```xml
compile 'com.owater.library:library:0.8.1'
```

You may also add the library as an Android Library to your project. All the library files live in library.

#Usage
To add the PickerUI to your layout add this to your xml

```xml
    <com.owater.library.CircleTextView
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:ct_backgroundColor="#0099CC"
        android:textColor="@color/white"
        android:gravity="center"
        android:textSize="16sp"
        android:text="22:30"/>

    <com.owater.library.CircleTextView
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:ct_backgroundColor="#0099CC"
        app:ct_border_width="10dp"
        app:ct_border_color="#0099CC"
        app:ct_border_alpha="0.5"
        app:ct_type="shadow_alpha"
        android:textColor="@color/white"
        android:gravity="center"
        android:textSize="16sp"
        android:layout_marginTop="20dp"
        android:text="22:30"/>

    <com.owater.library.CircleTextView
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:ct_backgroundColor="#0099CC"
        app:ct_border_width="5dp"
        app:ct_border_color="#0099CC"
        app:ct_type="shadow_gradual"
        android:textColor="@color/white"
        android:gravity="center"
        android:textSize="16sp"
        android:layout_marginTop="20dp"
        android:text="22:30"/>
```



# License
```
Copyright 2015 Owater

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---