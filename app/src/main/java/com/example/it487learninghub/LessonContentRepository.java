package com.example.it487learninghub;

public final class LessonContentRepository {

    // Prevent creating repository objects
    private LessonContentRepository() {
    }

    // =====================================
    // GET EDUCATIONAL LESSON CONTENT
    // =====================================

    public static LessonContent getLessonContent(
            int moduleId,
            int lessonNumber) {

        switch (moduleId) {

            // MODULE 01 - Course Foundations
            case 1:
                return Module01Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 02 - Android and Java Fundamentals
            case 2:
                return Module02Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 03 - Android Project Structure
            case 3:
                return Module03Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 04 - Layouts and Material Design
            case 4:
                return Module04Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 05 - Activity Lifecycle
            case 5:
                return Module05Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 06 - Dialogs and RecyclerView
            case 6:
                return Module06Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 07 - Intents and Data Storage
            case 7:
                return Module07Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 08 - React and React Native
            case 8:
                return Module08Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 09 - JSX and Rendering
            case 9:
                return Module09Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 10 - Props, State and Context
            case 10:
                return Module10Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 11 - Component Lifecycle
            case 11:
                return Module11Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 12 - React Native Projects
            case 12:
                return Module12Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 13 - Responsive Flexbox
            case 13:
                return Module13Lessons.getLesson(
                        lessonNumber
                );

            // MODULE 14 - Maps and Sensors
            case 14:
                return Module14Lessons.getLesson(
                        lessonNumber
                );

            default:
                break;
        }

        // Lesson content is not available yet
        return null;
    }

    // Check whether educational content exists
    public static boolean isLessonReady(
            int moduleId,
            int lessonNumber) {

        return getLessonContent(
                moduleId,
                lessonNumber
        ) != null;
    }
}
