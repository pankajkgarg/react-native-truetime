
# react-native-truetime

## Getting started

`$ npm install react-native-truetime --save`

### Mostly automatic installation

`$ react-native link react-native-truetime`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.pkgarg.truetime.RNTrueTimePackage;` to the imports at the top of the file
  - Add `new RNTrueTimePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-truetime'
  	project(':react-native-truetime').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-truetime/android')
  	```
3. Add maven repository to `android/build.gradle`:
    ```
    allprojects {
        repositories {
            maven { url "https://jitpack.io" }  // Add this line
        }
    }
    ```
4. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-truetime')
      compile 'com.github.instacart.truetime-android:library-extension-rx:3.3'
  	```



## Usage
```javascript
import RNTrueTime from 'react-native-truetime';

// Initialize TrueTime
RNTrueTime.initTrueTime()

// Returns time in millisecond (as a string)
...
const trueTimeStr = await RNTrueTime.getTrueTime();
const trueTime = parseInt(trueTimeStr);
```
