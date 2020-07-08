# HUD IMUData Sample 
A simple application showing how to obtain the IMU data from the HUD SDK. 

## Prerequisites
You will need a HD4000 in order to run this demo.

## Examples
After installing the application, ensure the HD4000 is connected to your device. Onec connected, run the application and the IMU data should being printing to the logcat. You should see results similar to:

```
2020-07-08 09:54:05.580 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Received IMU Data
2020-07-08 09:54:05.586 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Accelerometer Data - X: 0.050000, Y: -0.473000, Z: -0.571000
2020-07-08 09:54:05.592 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Gyroscope Data - X: 232.412000, Y: -274.885000, Z: -200.794000
2020-07-08 09:54:05.596 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Magnetometer Data - X: 0.000000, Y: 0.000000, Z: 0.000000
2020-07-08 09:54:05.602 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Quaternion Vector Data - X: 1.000000, Y: 0.000000, Z: 0.000000, W: 0.000000
2020-07-08 09:54:05.605 2688-2688/com.zebra.jamesswinton.hudimudatasample I/MainActivity: Temp Data - Temp: 20.620000
```

## Contributing
This project welcomes contributions. Pleae check out our [Contributing guide](https://github.com/JamesSwinton/HUD-IMU-Data-Sample/blob/master/contributing.md) to learn more on how to get started.

## License
This project is protected by Zebra's EULA, as detailed in the [License.md](https://github.com/JamesSwinton/HUD-IMU-Data-Sample/blob/master/Zebra%20EULA%20Licence.md) file
