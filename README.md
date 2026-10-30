
# IT487 Learning Hub

### Mobile Application Development – Academic Project

IT487 Learning Hub is a native Android educational application designed to help students learn, practice, and review mobile application development concepts through interactive lessons, quizzes, personal notes, and progress tracking.

The application covers Android development, Java, XML layouts, React, and React Native in a structured learning environment.

## Project Overview

The application provides a centralized learning experience where students can explore course modules, study educational content, review code examples, practice questions, and monitor their academic progress.

The project was developed for the IT487 – Mobile Application Development course.

## Key Features

### 1. Learning Dashboard
- Course completion percentage
- Completed and remaining lesson counts
- Quick access to learning modules
- Quick Practice entry point
- Navigation between major application sections

### 2. Explore Learning Modules
- 14 organized learning modules
- 50 educational lessons
- Module searching and category filtering
- Android and React Native learning paths
- Individual module completion tracking

### 3. Interactive Lessons
Each lesson provides:
- Educational explanations
- Important concepts and key takeaways
- Code examples
- Practice questions and answer feedback
- Lesson completion tracking
- Bookmark functionality

### 4. Module Quizzes
- Quizzes available for all 14 modules
- Randomized questions for practice
- 10 questions per quiz attempt
- Multiple-choice answers
- Answer feedback and explanations
- Final scores and retry functionality

### 5. Progress Tracking
- Overall course progress
- Completed and remaining lessons
- Progress by learning module
- Latest quiz score
- Best quiz score
- Average quiz score
- Quiz attempt history and statistics

### 6. Personal Notes
- Create notes
- Edit existing notes
- Delete notes
- Search saved notes
- Persistent local storage

## Course Modules

| No. | Module |
|-----|--------|
| 01 | Course Foundations |
| 02 | Android and Java Fundamentals |
| 03 | Android Project Structure |
| 04 | Layouts and Material Design |
| 05 | Activity Lifecycle |
| 06 | Dialogs and RecyclerView |
| 07 | Intents and Data Storage |
| 08 | React and React Native |
| 09 | JSX and Rendering |
| 10 | Props, State and Context |
| 11 | Component Lifecycle |
| 12 | React Native Projects |
| 13 | Responsive Flexbox |
| 14 | Maps and Sensors |

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Android application logic |
| XML | User interface layouts |
| Android Studio | Development environment |
| SQLite | Local data persistence |
| RecyclerView | Displaying dynamic lists |
| Android SDK | Native Android functionality |
| Gradle | Build and dependency management |
| Git and GitHub | Version control and source hosting |

## Application Architecture

The project follows a modular structure with separate classes for application screens, adapters, educational content, question management, and database operations.

### Main Components

- `MainActivity` – Home dashboard
- `ExploreActivity` – Learning module discovery
- `ModuleLessonsActivity` – Module lesson listing
- `LessonDetailsActivity` – Interactive lesson content
- `QuizActivity` – Module quizzes
- `NotesActivity` – Personal notes management
- `ProgressActivity` – Learning progress and analytics
- `LearningDatabaseHelper` – SQLite database management
- `QuizQuestionRepository` – Quiz question bank
- `LessonContentRepository` – Educational lesson content

Individual module content is organized into `Module01Lessons.java` through `Module14Lessons.java`.

## Database

SQLite is used to persist application data locally.

The database manages:

- Lesson completion and bookmarks
- Personal notes
- Quiz attempts and scores

This allows learning progress and saved information to remain available after closing and reopening the application.

## How to Run the Project

### Requirements
- Android Studio
- Android SDK
- Android Emulator or a physical Android device
- Java and Gradle support configured through Android Studio

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/Mohammed-Maashi/IT487LearningHub.git
   ```

2. Open Android Studio.

3. Select **Open** and choose the downloaded `IT487LearningHub` folder.

4. Allow Gradle synchronization to complete.

5. Start an Android emulator or connect an Android device.

6. Click **Run** to build and launch the application.

## Project Structure

```text
IT487LearningHub/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/it487learninghub/
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── drawable/
│   │       │   ├── mipmap-*/
│   │       │   └── values/
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew
```

## User Interface

The application uses a dark-themed interface with modern card-based layouts, clear navigation, and consistent visual styling.

The main screens include:

1. Home
2. Explore
3. Lesson Details
4. Module Quizzes
5. My Notes
6. My Progress

## Academic Information

**Project:** IT487 Learning Hub

**Course:** IT487 – Mobile Application Development

**Project Type:** Native Android Educational Application

**Language:** English

**Development:** Java, XML, and SQLite

## Repository

The complete Android Studio project, including source code, layouts, resources, and Gradle configuration, is available in this repository.

---

**IT487 Learning Hub – Learn, Practice, and Track Your Progress.**
