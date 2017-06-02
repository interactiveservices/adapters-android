# adapters-android
[![Download](https://api.bintray.com/packages/interactiveservices/maven/adapters-android/images/download.svg)](https://bintray.com/interactiveservices/maven/adapters-android/_latestVersion)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)
[![API](https://img.shields.io/badge/API-14%2B-green.svg)](https://developer.android.com/about/versions/android-4.0.html)

## What's this
This is a library containing base classes for simple RecyclerView adapters, ViewPager adapters and Fragment ViewPager adapters.
- `BaseListAdapter` - base class for simple adapters which contains items of one type;
- `BaseFragmentPagerAdapter` - adapter class for ViewPagers which contains fragments;
- `BaseViewPageAdapter` - adapter class for ViewPagers which contains simple Views;
- `LockedViewPager` - ViewPager in which you can disable or enable swiping right/left.

## Live Template for simple ListAdapter
The source code of library includes live template, which you can use for quck adding of Adapter. It locates in folder `/adapters-android/templates/`.
### How to use live template
In Android Studio go to `Settings > Editor > File and Code Templates`. Click "+" icon to add new live template. Paste text from file `adapter_list.txt`. Save changes.
Now you can quickly add new Adapter by context menu in your Project view. Select appropriate folder and in context menu select `New > Template Name (which you chose on previous step)`. Then you must enter names of classes and layouts which will be autoplaces in newly generated code. Your code will be ready after clicking OK and auto-importing of imports. *Voila* and you have new adapter.

## Example
Source code contains example project to see library in action. Feel free to use code from example project.
