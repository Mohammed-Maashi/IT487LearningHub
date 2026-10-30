package com.example.it487learninghub;

import java.util.ArrayList;
import java.util.List;

public class CourseContentRepository {

    // Returns the lessons belonging to a selected module
    public static List<LessonAdapter.Lesson> getLessonsForModule(
            int moduleId) {

        List<LessonAdapter.Lesson> lessons = new ArrayList<>();

        switch (moduleId) {

            // MODULE 01 - Course Foundations
            case 1:
                addLessons(lessons, moduleId,
                        "Mobile Application Development Overview",
                        "Development Tools and Workflow",
                        "Git and GitHub Basics");
                break;

            // MODULE 02 - Android and Java Fundamentals
            case 2:
                addLessons(lessons, moduleId,
                        "Introduction to Android",
                        "Java Essentials for Android",
                        "XML in Android Applications",
                        "Android Development Environment");
                break;

            // MODULE 03 - Android Project Structure
            case 3:
                addLessons(lessons, moduleId,
                        "Android Project Anatomy",
                        "Activities and AndroidManifest",
                        "Resources and Build Files");
                break;

            // MODULE 04 - Layouts and Material Design
            case 4:
                addLessons(lessons, moduleId,
                        "Introduction to Android Layouts",
                        "LinearLayout and ConstraintLayout",
                        "Material Design Principles",
                        "CardView and UI Components",
                        "Responsive Android Interfaces");
                break;

            // MODULE 05 - Activity Lifecycle
            case 5:
                addLessons(lessons, moduleId,
                        "Introduction to Activities",
                        "Activity Lifecycle Methods",
                        "Handling Lifecycle Changes");
                break;

            // MODULE 06 - Dialogs and RecyclerView
            case 6:
                addLessons(lessons, moduleId,
                        "Dialogs and DialogFragment",
                        "Toast and User Feedback",
                        "RecyclerView, Adapter and ViewHolder",
                        "Efficient Lists and User Interaction");
                break;

            // MODULE 07 - Intents and Data Storage
            case 7:
                addLessons(lessons, moduleId,
                        "Explicit and Implicit Intents",
                        "Passing Data Between Activities",
                        "SharedPreferences Basics",
                        "SQLite Database Fundamentals",
                        "SQLite CRUD Operations",
                        "Searching and Displaying Local Data");
                break;

            // MODULE 08 - React and React Native
            case 8:
                addLessons(lessons, moduleId,
                        "React Fundamentals",
                        "Introducing React Native",
                        "React vs React Native");
                break;

            // MODULE 09 - JSX and Rendering
            case 9:
                addLessons(lessons, moduleId,
                        "Understanding JSX",
                        "Rendering Elements and Lists",
                        "Conditional Rendering");
                break;

            // MODULE 10 - Props, State and Context
            case 10:
                addLessons(lessons, moduleId,
                        "Component Props",
                        "State and State Updates",
                        "Working with Context",
                        "Props vs State vs Context");
                break;

            // MODULE 11 - Component Lifecycle
            case 11:
                addLessons(lessons, moduleId,
                        "React Component Lifecycle",
                        "Lifecycle and Side Effects",
                        "Managing Component Updates");
                break;

            // MODULE 12 - React Native Projects
            case 12:
                addLessons(lessons, moduleId,
                        "Setting Up React Native",
                        "Creating Projects with Expo",
                        "Testing with Expo Snack");
                break;

            // MODULE 13 - Responsive Flexbox
            case 13:
                addLessons(lessons, moduleId,
                        "Flexbox Layout Fundamentals",
                        "Styling with React Native",
                        "Rows, Columns and Flexible Grids");
                break;

            // MODULE 14 - Maps and Sensors
            case 14:
                addLessons(lessons, moduleId,
                        "Geolocation and Maps",
                        "Map Annotations and Points of Interest",
                        "Motion, Position and Environment Sensors");
                break;

            default:
                break;
        }

        return lessons;
    }

    // Creates numbered lessons automatically
    private static void addLessons(
            List<LessonAdapter.Lesson> lessons,
            int moduleId,
            String... titles) {

        for (int i = 0; i < titles.length; i++) {

            LessonAdapter.Lesson lesson =
                    new LessonAdapter.Lesson(
                            moduleId,
                            i + 1,
                            titles[i],
                            false
                    );

            lessons.add(lesson);
        }
    }
}
