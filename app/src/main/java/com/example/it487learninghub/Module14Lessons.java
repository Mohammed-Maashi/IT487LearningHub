package com.example.it487learninghub;

public final class Module14Lessons {

    // Educational content for Module 14: Maps and Sensors.
    private Module14Lessons() {
    }

    public static LessonContent getLesson(int lessonNumber) {
        switch (lessonNumber) {
            case 1:
                return geolocationAndMaps();
            case 2:
                return mapAnnotationsAndPointsOfInterest();
            case 3:
                return motionPositionAndEnvironmentSensors();
            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01 - Geolocation and Maps
    // =====================================
    private static LessonContent geolocationAndMaps() {
        String summary =
                "Understand location services in React Native, "
                        + "how coordinates work, and how to request "
                        + "permission before accessing device location.";

        String explanation =
                "GEOLOCATION:\n"
                        + "Geolocation identifies the approximate position "
                        + "of a device on Earth. A mobile application may "
                        + "use location data for maps, navigation, or "
                        + "nearby services.\n\n"

                        + "LATITUDE AND LONGITUDE:\n"
                        + "Latitude measures the north-south position "
                        + "relative to the equator. Longitude measures "
                        + "the east-west position relative to the "
                        + "prime meridian.\n\n"

                        + "LOCATION SOURCES:\n"
                        + "Mobile devices can estimate their location "
                        + "using satellite positioning, Wi-Fi, and "
                        + "cellular networks. Accuracy depends on "
                        + "device hardware and surroundings.\n\n"

                        + "USER PERMISSION:\n"
                        + "A location-enabled app should request the "
                        + "appropriate permission before reading "
                        + "the device's coordinates. Users may "
                        + "deny or revoke this permission.\n\n"

                        + "FOREGROUND VS BACKGROUND:\n"
                        + "Foreground access is used while the app "
                        + "is in use. Background location requires "
                        + "additional permissions and careful "
                        + "privacy justification.\n\n"

                        + "EXPO LOCATION:\n"
                        + "Expo provides the expo-location package "
                        + "for location functionality in compatible "
                        + "React Native projects.\n\n"

                        + "REQUESTING PERMISSION:\n"
                        + "requestForegroundPermissionsAsync() asks "
                        + "the user for foreground location access.\n\n"

                        + "GETTING COORDINATES:\n"
                        + "getCurrentPositionAsync() can request "
                        + "an estimated current location. The result "
                        + "contains coordinates such as latitude "
                        + "and longitude.\n\n"

                        + "ERROR HANDLING:\n"
                        + "The request may fail because permission "
                        + "was denied, location services are disabled, "
                        + "or the device cannot get a position.\n\n"

                        + "PRIVACY:\n"
                        + "Collect location only when needed, "
                        + "explain its purpose, and avoid sharing "
                        + "precise coordinates unnecessarily.\n\n"

                        + "TESTING:\n"
                        + "An emulator can simulate a location. "
                        + "Actual device accuracy and permission "
                        + "behavior should also be tested.";

        String takeaway =
                "Geolocation uses latitude and longitude "
                        + "to describe a position. Request user "
                        + "permission, handle unavailable location "
                        + "services, and protect location privacy.";

        String code =
                "// Expo React Native example\n"
                        + "// Install: npx expo install expo-location\n"
                        + "// File: App.js\n\n"
                        + "import React, { useState } from 'react';\n"
                        + "import { View, Text, Button } from 'react-native';\n"
                        + "import * as Location from 'expo-location';\n\n"
                        + "export default function App() {\n"
                        + "  const [message, setMessage] = useState(\n"
                        + "    'Tap to request your location'\n"
                        + "  );\n\n"
                        + "  async function getLocation() {\n"
                        + "    try {\n"
                        + "      const permission = await\n"
                        + "        Location.requestForegroundPermissionsAsync();\n\n"
                        + "      if (permission.status !== 'granted') {\n"
                        + "        setMessage('Location permission denied');\n"
                        + "        return;\n"
                        + "      }\n\n"
                        + "      const position = await\n"
                        + "        Location.getCurrentPositionAsync({\n"
                        + "          accuracy: Location.Accuracy.Balanced\n"
                        + "        });\n\n"
                        + "      const { latitude, longitude } =\n"
                        + "        position.coords;\n\n"
                        + "      setMessage(\n"
                        + "        `Lat: ${latitude.toFixed(4)}, ` +\n"
                        + "        `Lon: ${longitude.toFixed(4)}`\n"
                        + "      );\n"
                        + "    } catch (error) {\n"
                        + "      setMessage('Location is unavailable');\n"
                        + "    }\n"
                        + "  }\n\n"
                        + "  return (\n"
                        + "    <View style={{ flex: 1, justifyContent: 'center',\n"
                        + "      padding: 24 }}>\n"
                        + "      <Text>{message}</Text>\n"
                        + "      <Button title=\"Get My Location\"\n"
                        + "        onPress={getLocation} />\n"
                        + "    </View>\n"
                        + "  );\n"
                        + "}";

        String codeExplanation =
                "This example uses expo-location in a "
                        + "compatible Expo project. First install "
                        + "the package with npx expo install.\n\n"
                        + "When the button is pressed, the app "
                        + "requests foreground permission. If access "
                        + "is denied, a message is displayed.\n\n"
                        + "When permission is granted, the app "
                        + "requests the current position and reads "
                        + "latitude and longitude from position.coords.\n\n"
                        + "The example rounds the displayed coordinates "
                        + "to four decimal places and handles failures. "
                        + "A production app should also explain why "
                        + "location is needed.\n\n"
                        + "This JavaScript example is educational. "
                        + "It is not executed inside IT487 Learning Hub.";

        String question =
                "Which Expo Location method asks the user "
                        + "for foreground location permission?";

        String[] options = {
                "getCurrentPositionAsync()",
                "requestForegroundPermissionsAsync()",
                "setInterval()",
                "StyleSheet.create()"
        };

        String answerExplanation =
                "requestForegroundPermissionsAsync() requests "
                        + "permission for location access while the "
                        + "app is in use. Getting coordinates should "
                        + "follow an appropriate permission check.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                answerExplanation
        );
    }

    // =====================================
    // LESSON 02 - Map Annotations and Points of Interest
    // =====================================
    private static LessonContent mapAnnotationsAndPointsOfInterest() {
        String summary =
                "Learn how maps display geographic areas, "
                        + "how markers identify points of interest, "
                        + "and how users interact with map annotations.";

        String explanation =
                "MAP VIEWS:\n"
                        + "A map view displays geographic information "
                        + "and lets users explore different places.\n\n"

                        + "POINTS OF INTEREST:\n"
                        + "A point of interest (POI) is a location "
                        + "such as a museum, campus, or restaurant.\n\n"

                        + "MAP MARKERS:\n"
                        + "A marker highlights a particular coordinate "
                        + "on a map. Markers can have a title and "
                        + "a short description.\n\n"

                        + "ANNOTATIONS:\n"
                        + "An annotation is information displayed "
                        + "at a particular geographic position. "
                        + "For example, a map marker can show "
                        + "details about a place when selected.\n\n"

                        + "MAP REGION:\n"
                        + "A region describes the map's center "
                        + "and visible area. Properties can include "
                        + "latitude, longitude, latitudeDelta, "
                        + "and longitudeDelta.\n\n"

                        + "MAP INTERACTIONS:\n"
                        + "Users can pan and zoom the map. "
                        + "They may tap markers to inspect "
                        + "the corresponding location.\n\n"

                        + "REACT NATIVE MAPS:\n"
                        + "The react-native-maps package provides "
                        + "MapView and Marker components. Its "
                        + "availability depends on the app's "
                        + "platform and build configuration.\n\n"

                        + "INSTALLATION:\n"
                        + "In an Expo project, install the compatible "
                        + "version using npx expo install "
                        + "react-native-maps.\n\n"

                        + "MARKER COORDINATES:\n"
                        + "Markers receive a coordinate object "
                        + "containing latitude and longitude.\n\n"

                        + "MULTIPLE LOCATIONS:\n"
                        + "An app can store POIs in an array and "
                        + "render one Marker for each location.\n\n"

                        + "PERMISSIONS:\n"
                        + "Displaying predefined map markers does "
                        + "not require the user's live location. "
                        + "Showing the user's position generally "
                        + "requires location permission.\n\n"

                        + "TESTING AND CONFIGURATION:\n"
                        + "Native maps may require platform-specific "
                        + "configuration or map service credentials "
                        + "for certain builds. Always check the "
                        + "requirements of the target platform.";

        String takeaway =
                "MapView shows a geographic region, while "
                        + "Marker identifies a point of interest. "
                        + "Use latitude and longitude for coordinates "
                        + "and request location permission only "
                        + "when accessing the user's position.";

        String code =
                "// Expo React Native example\n"
                        + "// Install: npx expo install react-native-maps\n"
                        + "// File: App.js\n\n"
                        + "import React from 'react';\n"
                        + "import { View, StyleSheet } from 'react-native';\n"
                        + "import MapView, { Marker } from 'react-native-maps';\n\n"
                        + "const places = [\n"
                        + "  { id: '1', title: 'Point A',\n"
                        + "    latitude: 24.7136, longitude: 46.6753 },\n"
                        + "  { id: '2', title: 'Point B',\n"
                        + "    latitude: 24.7236, longitude: 46.6853 }\n"
                        + "];\n\n"
                        + "export default function App() {\n"
                        + "  return (\n"
                        + "    <View style={styles.container}>\n"
                        + "      <MapView style={styles.map}\n"
                        + "        initialRegion={{\n"
                        + "          latitude: 24.7136,\n"
                        + "          longitude: 46.6753,\n"
                        + "          latitudeDelta: 0.06,\n"
                        + "          longitudeDelta: 0.06\n"
                        + "        }}>\n"
                        + "        {places.map(place => (\n"
                        + "          <Marker key={place.id}\n"
                        + "            coordinate={{\n"
                        + "              latitude: place.latitude,\n"
                        + "              longitude: place.longitude\n"
                        + "            }}\n"
                        + "            title={place.title}\n"
                        + "            description=\"Example point of interest\"\n"
                        + "          />\n"
                        + "        ))}\n"
                        + "      </MapView>\n"
                        + "    </View>\n"
                        + "  );\n"
                        + "}\n\n"
                        + "const styles = StyleSheet.create({\n"
                        + "  container: { flex: 1 },\n"
                        + "  map: { flex: 1 }\n"
                        + "});";

        String codeExplanation =
                "This example uses react-native-maps to "
                        + "display a map centered on sample coordinates.\n\n"
                        + "The places array contains two points "
                        + "with different latitude and longitude values.\n\n"
                        + "MapView shows the map and its initialRegion "
                        + "controls the starting position and zoom area.\n\n"
                        + "The map() operation creates one Marker "
                        + "for each item in the places array. "
                        + "Each marker has a stable key, coordinates, "
                        + "a title, and a description.\n\n"
                        + "These example locations are predefined, "
                        + "so the app does not need to access "
                        + "the user's current position.\n\n"
                        + "Map display support and configuration "
                        + "vary by platform and build type. "
                        + "The snippet is presented for learning.";

        String question =
                "Which component is commonly used to "
                        + "display a point of interest on a map "
                        + "with react-native-maps?";

        String[] options = {
                "TextInput",
                "ScrollView",
                "Marker",
                "Activity"
        };

        String answerExplanation =
                "The Marker component represents a "
                        + "location on MapView. A marker can "
                        + "include coordinates, a title, "
                        + "and a description.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                2,
                answerExplanation
        );
    }

    // =====================================
    // LESSON 03 - Motion, Position and Environment Sensors
    // =====================================
    private static LessonContent motionPositionAndEnvironmentSensors() {
        String summary =
                "Explore common smartphone sensors and "
                        + "learn how React Native applications can "
                        + "read accelerometer data and safely "
                        + "manage sensor subscriptions.";

        String explanation =
                "SMARTPHONE SENSORS:\n"
                        + "Sensors allow applications to observe "
                        + "movement, orientation, and environmental "
                        + "conditions when supported by the device.\n\n"

                        + "ACCELEROMETER:\n"
                        + "An accelerometer measures acceleration "
                        + "along the x, y, and z axes. Applications "
                        + "may use this data to detect motion.\n\n"

                        + "GYROSCOPE:\n"
                        + "A gyroscope measures angular velocity. "
                        + "It can help detect how a device rotates.\n\n"

                        + "MAGNETOMETER:\n"
                        + "A magnetometer measures magnetic field "
                        + "strength and can support compass-like "
                        + "features when available.\n\n"

                        + "POSITION INFORMATION:\n"
                        + "A device may combine sensors and location "
                        + "services to estimate movement or orientation. "
                        + "An accelerometer alone does not provide "
                        + "accurate geographic coordinates.\n\n"

                        + "ENVIRONMENT SENSORS:\n"
                        + "Some devices have sensors such as an "
                        + "ambient light sensor or barometer. "
                        + "Sensor availability varies by model.\n\n"

                        + "EXPO SENSORS:\n"
                        + "The expo-sensors package provides APIs "
                        + "for supported device sensors, including "
                        + "the Accelerometer.\n\n"

                        + "SENSOR EVENTS:\n"
                        + "An app can subscribe to sensor readings "
                        + "and update the interface as data arrives.\n\n"

                        + "UPDATE INTERVAL:\n"
                        + "The update interval affects how frequently "
                        + "readings are requested. Frequent updates "
                        + "can increase processing and battery usage.\n\n"

                        + "SUBSCRIPTION CLEANUP:\n"
                        + "When a component no longer needs sensor "
                        + "updates, it should remove its subscription. "
                        + "This avoids unnecessary background work.\n\n"

                        + "HARDWARE LIMITATIONS:\n"
                        + "Emulators may not provide realistic "
                        + "sensor readings. Real-device testing is "
                        + "important for hardware-dependent features.\n\n"

                        + "PRIVACY AND USER EXPERIENCE:\n"
                        + "Applications should explain why sensors "
                        + "are used, request permissions when required, "
                        + "and avoid collecting unnecessary data.";

        String takeaway =
                "Sensors measure physical information such "
                        + "as acceleration and rotation. Subscribe "
                        + "only when needed, remove subscriptions "
                        + "during cleanup, and test on actual hardware.";

        String code =
                "// Expo React Native example\n"
                        + "// Install: npx expo install expo-sensors\n"
                        + "// File: App.js\n\n"
                        + "import React, { useEffect, useState }\n"
                        + "  from 'react';\n"
                        + "import { View, Text, StyleSheet }\n"
                        + "  from 'react-native';\n"
                        + "import { Accelerometer } from 'expo-sensors';\n\n"
                        + "export default function App() {\n"
                        + "  const [motion, setMotion] = useState({\n"
                        + "    x: 0, y: 0, z: 0\n"
                        + "  });\n\n"
                        + "  useEffect(() => {\n"
                        + "    Accelerometer.setUpdateInterval(500);\n"
                        + "    const subscription =\n"
                        + "      Accelerometer.addListener(reading => {\n"
                        + "        setMotion(reading);\n"
                        + "      });\n\n"
                        + "    return () => subscription.remove();\n"
                        + "  }, []);\n\n"
                        + "  return (\n"
                        + "    <View style={styles.container}>\n"
                        + "      <Text style={styles.title}>\n"
                        + "        Accelerometer Readings\n"
                        + "      </Text>\n"
                        + "      <Text style={styles.text}>\n"
                        + "        X: {motion.x.toFixed(2)}\n"
                        + "      </Text>\n"
                        + "      <Text style={styles.text}>\n"
                        + "        Y: {motion.y.toFixed(2)}\n"
                        + "      </Text>\n"
                        + "      <Text style={styles.text}>\n"
                        + "        Z: {motion.z.toFixed(2)}\n"
                        + "      </Text>\n"
                        + "    </View>\n"
                        + "  );\n"
                        + "}\n\n"
                        + "const styles = StyleSheet.create({\n"
                        + "  container: {\n"
                        + "    flex: 1, justifyContent: 'center',\n"
                        + "    padding: 24, backgroundColor: '#0B1020'\n"
                        + "  },\n"
                        + "  title: {\n"
                        + "    fontSize: 22, fontWeight: 'bold',\n"
                        + "    color: '#F8FAFC', marginBottom: 16\n"
                        + "  },\n"
                        + "  text: { fontSize: 18, color: '#AAB8CF' }\n"
                        + "});";

        String codeExplanation =
                "The example subscribes to accelerometer "
                        + "updates through the expo-sensors package.\n\n"
                        + "useState() stores the x, y, and z readings "
                        + "that appear on the screen.\n\n"
                        + "setUpdateInterval(500) requests an update "
                        + "interval of 500 milliseconds.\n\n"
                        + "addListener() receives sensor readings "
                        + "and updates the component state.\n\n"
                        + "The useEffect cleanup calls "
                        + "subscription.remove() to stop listening "
                        + "when the component unmounts.\n\n"
                        + "Values may differ across hardware, "
                        + "and simulated devices may not produce "
                        + "realistic readings. A production app "
                        + "should check sensor availability.";

        String question =
                "Why should an app remove an accelerometer "
                        + "subscription when the component unmounts?";

        String[] options = {
                "To change the device's location",
                "To increase the screen brightness",
                "To save the readings in AndroidManifest.xml",
                "To stop unnecessary sensor updates"
        };

        String answerExplanation =
                "Removing the subscription stops further "
                        + "sensor notifications to the component, "
                        + "which helps avoid unnecessary work "
                        + "and resource usage.";

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                3,
                answerExplanation
        );
    }
}
