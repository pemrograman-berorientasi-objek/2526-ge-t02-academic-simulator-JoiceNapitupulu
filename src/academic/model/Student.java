package academic.model;

public class Student {
    private String id;
    private String name;
    private String entryYear; // Tahun masuk
    private String studyProgram; // Program studi

    public Student(String id, String name, String entryYear, String studyProgram) {
        this.id = id;
        this.name = name;
        this.entryYear = entryYear;
        this.studyProgram = studyProgram;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    // Overriding toString method untuk format output yang diminta
    @Override
    public String toString() {
        return id + "|" + name + "|" + entryYear + "|" + studyProgram;
    }
}