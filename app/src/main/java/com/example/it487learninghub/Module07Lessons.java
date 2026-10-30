package com.example.it487learninghub;

public final class Module07Lessons {

    private Module07Lessons() {
    }

    // =====================================
    // GET MODULE 07 LESSON CONTENT
    // =====================================

    public static LessonContent getLesson(int lessonNumber) {

        switch (lessonNumber) {
            case 1:
                return explicitAndImplicitIntents();
            case 2:
                return passingDataBetweenActivities();
            case 3:
                return sharedPreferencesBasics();
            case 4:
                return sqliteDatabaseFundamentals();
            case 5:
                return sqliteCrudOperations();
            case 6:
                return searchingAndDisplayingData();
            default:
                return null;
        }
    }

    // =====================================
    // LESSON 01
    // Explicit and Implicit Intents
    // =====================================

    private static LessonContent explicitAndImplicitIntents() {

        String summary =
                "Understand how Android Intents "
                        + "start Activities and request "
                        + "actions from other applications.";

        String explanation =
                "An Intent is a messaging object "
                        + "used to request an action from "
                        + "another Android component.\n\n"

                        + "EXPLICIT INTENTS:\n"
                        + "An explicit Intent identifies "
                        + "a particular component to start.\n\n"

                        + "For example, MainActivity can "
                        + "use an explicit Intent to open "
                        + "ExploreActivity in the same app.\n\n"

                        + "IMPLICIT INTENTS:\n"
                        + "An implicit Intent describes "
                        + "an action without naming "
                        + "a specific component.\n\n"

                        + "Android can find applications "
                        + "capable of handling that action.\n\n"

                        + "ACTION_VIEW:\n"
                        + "Intent.ACTION_VIEW can request "
                        + "that another application display "
                        + "a web address or other content.\n\n"

                        + "INTENT FILTERS:\n"
                        + "Intent filters describe which "
                        + "implicit Intents a component "
                        + "can accept.\n\n"

                        + "ACTIVITY RESOLUTION:\n"
                        + "An implicit Intent may fail "
                        + "if no installed application "
                        + "can handle the requested action.\n\n"

                        + "Developers should handle "
                        + "that possibility safely.\n\n"

                        + "SECURITY:\n"
                        + "Only send the information "
                        + "needed for the requested action. "
                        + "Avoid exposing private data "
                        + "to unintended applications.";

        String takeaway =
                "An explicit Intent targets a specific "
                        + "component. An implicit Intent "
                        + "requests an action that a suitable "
                        + "application can perform.";

        String code =
                "// Explicit Intent - Activity excerpt\n\n"

                        + "Intent explicitIntent = new Intent(\n"
                        + "        this,\n"
                        + "        ExploreActivity.class\n"
                        + ");\n\n"

                        + "startActivity(explicitIntent);\n\n"

                        + "// Implicit Intent - Open a web page\n\n"

                        + "Intent webIntent = new Intent(\n"
                        + "        Intent.ACTION_VIEW,\n"
                        + "        Uri.parse(\n"
                        + "            \"https://developer.android.com\"\n"
                        + "        )\n"
                        + ");\n\n"

                        + "try {\n"
                        + "    startActivity(webIntent);\n"
                        + "} catch (ActivityNotFoundException e) {\n"
                        + "    Toast.makeText(\n"
                        + "            this,\n"
                        + "            \"No compatible app found\",\n"
                        + "            Toast.LENGTH_SHORT\n"
                        + "    ).show();\n"
                        + "}";

        String codeExplanation =
                "The first Intent explicitly identifies "
                        + "ExploreActivity as the destination.\n\n"

                        + "The second Intent uses ACTION_VIEW "
                        + "and a Uri to request that a suitable "
                        + "application open a website.\n\n"

                        + "The try/catch block handles cases "
                        + "where no compatible Activity is found.\n\n"

                        + "These are Activity code excerpts "
                        + "that require the relevant imports "
                        + "and an existing ExploreActivity.";

        String question =
                "Which type of Intent identifies "
                        + "a specific Android component "
                        + "as its destination?";

        String[] options = {
                "Implicit Intent",
                "Explicit Intent",
                "Broadcast-only Intent",
                "PendingIntent only"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                "An explicit Intent identifies "
                        + "the exact component to start, "
                        + "such as ExploreActivity."
        );
    }

    // =====================================
    // LESSON 02
    // Passing Data Between Activities
    // =====================================

    private static LessonContent
    passingDataBetweenActivities() {

        String summary =
                "Learn how Android Activities "
                        + "exchange small data values "
                        + "using Intent extras.";

        String explanation =
                "Android Activities often need "
                        + "to share information when "
                        + "navigating between screens.\n\n"

                        + "INTENT EXTRAS:\n"
                        + "Intent extras store values "
                        + "that travel with an Intent.\n\n"

                        + "PUTEXTRA:\n"
                        + "The putExtra() method attaches "
                        + "a value using a key.\n\n"

                        + "For example, a learning app "
                        + "can send a module ID, "
                        + "lesson number, or lesson title "
                        + "to another Activity.\n\n"

                        + "READING EXTRAS:\n"
                        + "The destination Activity "
                        + "can call getIntent() "
                        + "to access the Intent "
                        + "that started it.\n\n"

                        + "TYPE-SPECIFIC METHODS:\n"
                        + "getIntExtra() retrieves "
                        + "an integer and allows "
                        + "a default value.\n\n"

                        + "getStringExtra() retrieves "
                        + "a String value or null "
                        + "when no matching value exists.\n\n"

                        + "VALIDATION:\n"
                        + "Always validate incoming "
                        + "data before using it.\n\n"

                        + "For example, a lesson number "
                        + "should be positive and "
                        + "a required title should "
                        + "not be empty.\n\n"

                        + "LARGE DATA:\n"
                        + "Avoid passing large datasets "
                        + "through Intent extras.\n\n"

                        + "For larger data, pass an ID "
                        + "and retrieve the information "
                        + "from a database or repository.";

        String takeaway =
                "Use putExtra() to send small "
                        + "values and type-specific "
                        + "get...Extra() methods to "
                        + "retrieve them. Validate "
                        + "received data before use.";

        String code =
                "// Sending Activity excerpt\n\n"

                        + "Intent intent = new Intent(\n"
                        + "        this,\n"
                        + "        LessonDetailsActivity.class\n"
                        + ");\n\n"

                        + "intent.putExtra(\"module_id\", 7);\n"
                        + "intent.putExtra(\"lesson_number\", 2);\n"
                        + "intent.putExtra(\n"
                        + "        \"lesson_title\",\n"
                        + "        \"Passing Data Between Activities\"\n"
                        + ");\n\n"

                        + "startActivity(intent);\n\n"

                        + "// Receiving Activity excerpt\n\n"

                        + "Intent received = getIntent();\n\n"

                        + "int moduleId = received.getIntExtra(\n"
                        + "        \"module_id\", -1\n"
                        + ");\n\n"

                        + "int lessonNumber = received.getIntExtra(\n"
                        + "        \"lesson_number\", -1\n"
                        + ");\n\n"

                        + "String lessonTitle =\n"
                        + "        received.getStringExtra(\n"
                        + "                \"lesson_title\"\n"
                        + "        );";

        String codeExplanation =
                "The sending Activity creates "
                        + "an explicit Intent and adds "
                        + "three extra values.\n\n"

                        + "The receiving Activity calls "
                        + "getIntent() to obtain "
                        + "those values.\n\n"

                        + "getIntExtra() uses -1 "
                        + "as a default when "
                        + "the requested integer "
                        + "is unavailable.\n\n"

                        + "The receiving Activity must "
                        + "validate the IDs and title "
                        + "before displaying the lesson.\n\n"

                        + "Both sections are code excerpts "
                        + "from separate Activities.";

        String question =
                "Which Intent method attaches "
                        + "a value that another "
                        + "Activity can retrieve?";

        String[] options = {
                "putExtra()",
                "setContentView()",
                "findViewById()",
                "finish()"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                0,
                "putExtra() attaches key-value "
                        + "data to an Intent. "
                        + "The destination Activity "
                        + "can retrieve that data."
        );
    }

    // =====================================
    // LESSON 03
    // SharedPreferences Basics
    // =====================================

    private static LessonContent sharedPreferencesBasics() {

        String summary =
                "Discover how SharedPreferences "
                        + "stores small persistent settings "
                        + "and retrieves them when "
                        + "the application restarts.";

        String explanation =
                "SharedPreferences is an Android "
                        + "API for storing small "
                        + "key-value preferences.\n\n"

                        + "COMMON USES:\n"
                        + "It can store interface settings, "
                        + "such as notification preferences "
                        + "or whether an introduction "
                        + "has already been shown.\n\n"

                        + "KEY-VALUE STORAGE:\n"
                        + "Each preference has a String key "
                        + "and an associated value.\n\n"

                        + "SUPPORTED VALUES:\n"
                        + "SharedPreferences supports "
                        + "primitive values such as "
                        + "boolean, int, long, float, "
                        + "and String, plus sets of Strings.\n\n"

                        + "GETSHAREDPREFERENCES:\n"
                        + "This method opens a named "
                        + "preference file.\n\n"

                        + "MODE_PRIVATE:\n"
                        + "MODE_PRIVATE limits direct "
                        + "file access to the "
                        + "owning application under "
                        + "normal Android app isolation.\n\n"

                        + "EDITING VALUES:\n"
                        + "edit() provides an Editor "
                        + "that can save, remove, "
                        + "or clear stored preferences.\n\n"

                        + "APPLY VS COMMIT:\n"
                        + "apply() updates the in-memory "
                        + "preferences immediately "
                        + "and writes to disk asynchronously.\n\n"

                        + "commit() writes synchronously "
                        + "and returns a success value.\n\n"

                        + "DATASTORE:\n"
                        + "Jetpack DataStore is a modern "
                        + "alternative for managing "
                        + "persistent application settings.\n\n"

                        + "SECURITY:\n"
                        + "SharedPreferences is not "
                        + "an encrypted secret vault. "
                        + "Do not store passwords "
                        + "or sensitive tokens "
                        + "in plain text.";

        String takeaway =
                "SharedPreferences saves small "
                        + "persistent settings as "
                        + "key-value pairs. "
                        + "It is different from SQLite, "
                        + "which is suited to "
                        + "structured collections of data.";

        String code =
                "// Activity excerpt\n\n"

                        + "SharedPreferences preferences =\n"
                        + "        getSharedPreferences(\n"
                        + "                \"learning_settings\",\n"
                        + "                MODE_PRIVATE\n"
                        + "        );\n\n"

                        + "// Save a setting\n\n"

                        + "preferences.edit()\n"
                        + "        .putBoolean(\n"
                        + "                \"notifications_enabled\",\n"
                        + "                true\n"
                        + "        )\n"
                        + "        .apply();\n\n"

                        + "// Read the setting\n\n"

                        + "boolean enabled = preferences.getBoolean(\n"
                        + "        \"notifications_enabled\",\n"
                        + "        false\n"
                        + ");";

        String codeExplanation =
                "getSharedPreferences() opens "
                        + "the named preferences file "
                        + "in private mode.\n\n"

                        + "putBoolean() saves a "
                        + "boolean preference using "
                        + "a String key.\n\n"

                        + "apply() persists the change "
                        + "without blocking for "
                        + "a synchronous disk write.\n\n"

                        + "getBoolean() reads the setting "
                        + "and returns false if "
                        + "the key does not exist.";

        String question =
                "Which method saves "
                        + "SharedPreferences changes "
                        + "asynchronously?";

        String[] options = {
                "getString()",
                "getBoolean()",
                "setContentView()",
                "apply()"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                3,
                "SharedPreferences.Editor.apply() "
                        + "updates preferences in memory "
                        + "and schedules the disk write "
                        + "asynchronously."
        );
    }

    // =====================================
    // LESSON 04
    // SQLite Database Fundamentals
    // =====================================

    private static LessonContent
    sqliteDatabaseFundamentals() {

        String summary =
                "Understand SQLite tables, "
                        + "rows, columns, primary keys, "
                        + "and Android database helpers.";

        String explanation =
                "SQLite is a lightweight "
                        + "relational database engine "
                        + "that can store structured "
                        + "data locally on a device.\n\n"

                        + "RELATIONAL TABLES:\n"
                        + "SQLite organizes information "
                        + "into tables containing "
                        + "rows and columns.\n\n"

                        + "For example, a notes table "
                        + "might contain id, title, "
                        + "and content columns.\n\n"

                        + "PRIMARY KEY:\n"
                        + "A primary key uniquely "
                        + "identifies a row in a table.\n\n"

                        + "SQL:\n"
                        + "Structured Query Language "
                        + "is used to define tables "
                        + "and retrieve or modify data.\n\n"

                        + "CREATE TABLE:\n"
                        + "The CREATE TABLE statement "
                        + "defines a table's columns "
                        + "and constraints.\n\n"

                        + "SQLITEOPENHELPER:\n"
                        + "SQLiteOpenHelper helps Android "
                        + "applications create, open, "
                        + "and upgrade SQLite databases.\n\n"

                        + "ONCREATE:\n"
                        + "onCreate() runs when "
                        + "a database is first created.\n\n"

                        + "ONUPGRADE:\n"
                        + "onUpgrade() is used when "
                        + "a database requires migration "
                        + "to a newer schema version.\n\n"

                        + "DATA PERSISTENCE:\n"
                        + "SQLite data normally remains "
                        + "available when the app "
                        + "is closed and reopened.\n\n"

                        + "CURSORS:\n"
                        + "A Cursor allows Android code "
                        + "to read rows returned "
                        + "by a database query.\n\n"

                        + "GOOD PRACTICE:\n"
                        + "Close Cursor resources "
                        + "after reading them. "
                        + "Use database transactions "
                        + "where multiple changes "
                        + "must succeed together.";

        String takeaway =
                "SQLite provides structured "
                        + "local storage. "
                        + "SQLiteOpenHelper manages "
                        + "database creation and "
                        + "schema upgrades.";

        String code =
                "// Example SQL table definition\n\n"

                        + "CREATE TABLE notes (\n"
                        + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "    title TEXT NOT NULL,\n"
                        + "    content TEXT\n"
                        + ");\n\n"

                        + "// Android Java helper excerpt\n\n"

                        + "public class NotesDbHelper\n"
                        + "        extends SQLiteOpenHelper {\n\n"

                        + "    public NotesDbHelper(Context context) {\n"
                        + "        super(\n"
                        + "                context,\n"
                        + "                \"sample_notes.db\",\n"
                        + "                null,\n"
                        + "                1\n"
                        + "        );\n"
                        + "    }\n\n"

                        + "    @Override\n"
                        + "    public void onCreate(SQLiteDatabase db) {\n"
                        + "        db.execSQL(\n"
                        + "            \"CREATE TABLE notes (\" +\n"
                        + "            \"id INTEGER PRIMARY KEY, \" +\n"
                        + "            \"title TEXT NOT NULL, \" +\n"
                        + "            \"content TEXT)\"\n"
                        + "        );\n"
                        + "    }\n\n"

                        + "    @Override\n"
                        + "    public void onUpgrade(\n"
                        + "            SQLiteDatabase db,\n"
                        + "            int oldVersion,\n"
                        + "            int newVersion) {\n"
                        + "        // Add schema migrations here\n"
                        + "        // before increasing the version.\n"
                        + "    }\n"
                        + "}";

        String codeExplanation =
                "The first section demonstrates "
                        + "SQL table creation.\n\n"

                        + "The Java section shows "
                        + "how SQLiteOpenHelper "
                        + "can create a notes table.\n\n"

                        + "The helper initializes "
                        + "a database named sample_notes.db.\n\n"

                        + "The onCreate() method "
                        + "executes a CREATE TABLE "
                        + "statement when the database "
                        + "is first created.\n\n"

                        + "onUpgrade() is intentionally "
                        + "left as a migration placeholder. "
                        + "Real schema changes require "
                        + "appropriate migration logic.\n\n"

                        + "This is an educational example, "
                        + "not a modification to the "
                        + "LearningDatabaseHelper "
                        + "already used by this application.";

        String question =
                "Which Android class "
                        + "helps manage SQLite database "
                        + "creation and schema upgrades?";

        String[] options = {
                "Intent",
                "RecyclerView",
                "SQLiteOpenHelper",
                "Toast"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                2,
                "SQLiteOpenHelper provides "
                        + "lifecycle methods such as "
                        + "onCreate() and onUpgrade() "
                        + "for managing database schemas."
        );
    }

    // =====================================
    // LESSON 05
    // SQLite CRUD Operations
    // =====================================

    private static LessonContent sqliteCrudOperations() {

        String summary =
                "Learn the four fundamental "
                        + "database operations: "
                        + "Create, Read, Update, and Delete.";

        String explanation =
                "CRUD is an abbreviation "
                        + "for Create, Read, Update, "
                        + "and Delete.\n\n"

                        + "CREATE:\n"
                        + "Creating a record adds "
                        + "a new row to a table.\n\n"

                        + "SQLiteDatabase.insert() "
                        + "can add a new row "
                        + "using ContentValues.\n\n"

                        + "READ:\n"
                        + "Reading data retrieves "
                        + "records from a database.\n\n"

                        + "SQLiteDatabase.query() "
                        + "returns a Cursor "
                        + "containing query results.\n\n"

                        + "UPDATE:\n"
                        + "Updating data changes "
                        + "existing records.\n\n"

                        + "SQLiteDatabase.update() "
                        + "can modify matching rows.\n\n"

                        + "DELETE:\n"
                        + "Deleting data removes "
                        + "records from a table.\n\n"

                        + "SQLiteDatabase.delete() "
                        + "removes rows matching "
                        + "the supplied condition.\n\n"

                        + "CONTENTVALUES:\n"
                        + "ContentValues stores "
                        + "column-value pairs "
                        + "for insertion and updates.\n\n"

                        + "WHERE CONDITIONS:\n"
                        + "A WHERE condition determines "
                        + "which rows are updated "
                        + "or deleted.\n\n"

                        + "PARAMETERIZED ARGUMENTS:\n"
                        + "Use selection placeholders "
                        + "and separate arguments "
                        + "instead of concatenating "
                        + "untrusted input into SQL.\n\n"

                        + "DATA SAFETY:\n"
                        + "Always validate inputs "
                        + "and confirm destructive "
                        + "actions when appropriate.";

        String takeaway =
                "CRUD operations allow "
                        + "an application to create, "
                        + "read, update, and delete "
                        + "local database records. "
                        + "Use parameterized conditions "
                        + "for safe row selection.";

        String code =
                "// Java excerpts using a NotesDbHelper\n"
                        + "// with a notes(id, title, content) table\n\n"

                        + "SQLiteDatabase db =\n"
                        + "        helper.getWritableDatabase();\n\n"

                        + "// CREATE\n"
                        + "ContentValues values = new ContentValues();\n"
                        + "values.put(\"title\", \"Activity Lifecycle\");\n"
                        + "values.put(\"content\", \"Review onResume()\");\n\n"

                        + "long newId = db.insert(\n"
                        + "        \"notes\", null, values\n"
                        + ");\n\n"

                        + "// READ\n"
                        + "try (Cursor cursor = db.query(\n"
                        + "        \"notes\",\n"
                        + "        new String[]{\"id\", \"title\"},\n"
                        + "        null, null, null, null, null\n"
                        + ")) {\n"
                        + "    while (cursor.moveToNext()) {\n"
                        + "        String title = cursor.getString(\n"
                        + "                cursor.getColumnIndexOrThrow(\n"
                        + "                        \"title\"\n"
                        + "                )\n"
                        + "        );\n"
                        + "    }\n"
                        + "}\n\n"

                        + "if (newId != -1) {\n"
                        + "    // UPDATE\n"
                        + "    ContentValues updates = new ContentValues();\n"
                        + "    updates.put(\"title\", \"Updated Note\");\n\n"

                        + "    db.update(\n"
                        + "            \"notes\", updates,\n"
                        + "            \"id = ?\",\n"
                        + "            new String[]{String.valueOf(newId)}\n"
                        + "    );\n\n"

                        + "    // DELETE (example only)\n"
                        + "    db.delete(\n"
                        + "            \"notes\",\n"
                        + "            \"id = ?\",\n"
                        + "            new String[]{String.valueOf(newId)}\n"
                        + "    );\n"
                        + "}";

        String codeExplanation =
                "The example demonstrates all "
                        + "four CRUD operations.\n\n"

                        + "ContentValues stores "
                        + "the data for insertion.\n\n"

                        + "insert() creates a new note "
                        + "and returns its row ID "
                        + "or -1 if insertion fails.\n\n"

                        + "query() returns a Cursor "
                        + "used to read note titles.\n\n"

                        + "update() modifies a row "
                        + "selected by its ID.\n\n"

                        + "delete() removes that row.\n\n"

                        + "The selection arguments "
                        + "avoid inserting the ID "
                        + "directly into SQL text.\n\n"

                        + "This example deliberately "
                        + "shows a deletion operation. "
                        + "Do not run it against "
                        + "important user notes.";

        String question =
                "Which SQLiteDatabase method "
                        + "is used to modify "
                        + "existing table records?";

        String[] options = {
                "insert()",
                "update()",
                "query()",
                "open()"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                1,
                "SQLiteDatabase.update() "
                        + "modifies existing rows "
                        + "according to the provided "
                        + "values and selection condition."
        );
    }

    // =====================================
    // LESSON 06
    // Searching and Displaying Local Data
    // =====================================

    private static LessonContent
    searchingAndDisplayingData() {

        String summary =
                "Learn how to search SQLite "
                        + "records, read Cursor results, "
                        + "and display matching data "
                        + "in an Android interface.";

        String explanation =
                "Applications often need "
                        + "to retrieve records "
                        + "based on user search terms.\n\n"

                        + "DATABASE SEARCH:\n"
                        + "SQLite queries can filter "
                        + "records using conditions "
                        + "such as equality or LIKE.\n\n"

                        + "THE LIKE OPERATOR:\n"
                        + "LIKE can compare text "
                        + "with a search pattern.\n\n"

                        + "For example, %Android% "
                        + "matches text containing "
                        + "the word Android under "
                        + "SQLite's default LIKE behavior.\n\n"

                        + "QUERY ARGUMENTS:\n"
                        + "Selection arguments allow "
                        + "values to be bound separately "
                        + "from the SQL condition.\n\n"

                        + "CURSOR:\n"
                        + "A Cursor provides access "
                        + "to rows returned by a query.\n\n"

                        + "MOVETONEXT:\n"
                        + "moveToNext() advances "
                        + "through the result set.\n\n"

                        + "READING COLUMNS:\n"
                        + "getColumnIndexOrThrow() "
                        + "finds the column index "
                        + "by its name.\n\n"

                        + "getString() retrieves "
                        + "text from a selected column.\n\n"

                        + "ORDERING RESULTS:\n"
                        + "ORDER BY can sort "
                        + "matching rows by "
                        + "a particular column.\n\n"

                        + "DISPLAYING DATA:\n"
                        + "An application can place "
                        + "the query results in a list "
                        + "and show them through "
                        + "a RecyclerView Adapter.\n\n"

                        + "SEARCH PERFORMANCE:\n"
                        + "Large datasets may require "
                        + "indexes, background operations, "
                        + "or more specialized search "
                        + "strategies.\n\n"

                        + "RESOURCE MANAGEMENT:\n"
                        + "Always close a Cursor "
                        + "when finished reading "
                        + "the query results.";

        String takeaway =
                "Use parameterized SQLite "
                        + "queries to search local "
                        + "data. Read results with "
                        + "a Cursor, then display "
                        + "them using RecyclerView "
                        + "or another suitable component.";

        String code =
                "// Search example using a notes table\n\n"

                        + "String searchText = \"Android\";\n"
                        + "List<String> matchingTitles =\n"
                        + "        new ArrayList<>();\n\n"

                        + "SQLiteDatabase db =\n"
                        + "        helper.getReadableDatabase();\n\n"

                        + "try (Cursor cursor = db.query(\n"
                        + "        \"notes\",\n"
                        + "        new String[]{\"title\"},\n"
                        + "        \"title LIKE ?\",\n"
                        + "        new String[]{\"%\" + searchText + \"%\"},\n"
                        + "        null,\n"
                        + "        null,\n"
                        + "        \"title COLLATE NOCASE ASC\"\n"
                        + ")) {\n\n"

                        + "    int titleColumn =\n"
                        + "            cursor.getColumnIndexOrThrow(\"title\");\n\n"

                        + "    while (cursor.moveToNext()) {\n"
                        + "        matchingTitles.add(\n"
                        + "                cursor.getString(titleColumn)\n"
                        + "        );\n"
                        + "    }\n"
                        + "}\n\n"

                        + "// Pass matchingTitles to a list adapter\n"
                        + "// to display the search results.";

        String codeExplanation =
                "The example searches a local "
                        + "notes table for titles "
                        + "containing Android.\n\n"

                        + "The LIKE condition filters "
                        + "matching records.\n\n"

                        + "The question-mark placeholder "
                        + "binds the search pattern "
                        + "as a separate argument.\n\n"

                        + "The Cursor loops through "
                        + "matching rows and collects "
                        + "their titles into an ArrayList.\n\n"

                        + "The try-with-resources statement "
                        + "closes the Cursor automatically.\n\n"

                        + "A RecyclerView Adapter can "
                        + "then display the titles.\n\n"

                        + "For production search, consider "
                        + "escaping LIKE wildcard characters "
                        + "entered by users and running "
                        + "large queries off the main thread.";

        String question =
                "Which SQL operator can be used "
                        + "to search text using "
                        + "a pattern such as %Android%?";

        String[] options = {
                "DELETE",
                "CREATE",
                "LIKE",
                "DROP"
        };

        return new LessonContent(
                summary,
                explanation,
                takeaway,
                code,
                codeExplanation,
                question,
                options,
                2,
                "The SQL LIKE operator "
                        + "matches text patterns. "
                        + "The % wildcard represents "
                        + "a sequence of zero "
                        + "or more characters."
        );
    }
}
