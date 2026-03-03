package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {
    // Ukuran array statis maksimum untuk menyimpan setiap jenis entitas
    private static final int MAX_ENTITIES = 100; // Dapat disesuaikan

    // Array untuk Course
    private static Course[] courses = new Course[MAX_ENTITIES];
    private static int courseCount = 0; // Melacak jumlah Course yang ditambahkan

    // Array untuk Student
    private static Student[] students = new Student[MAX_ENTITIES];
    private static int studentCount = 0; // Melacak jumlah Student yang ditambahkan

    // Array untuk Enrollment
    private static Enrollment[] enrollments = new Enrollment[MAX_ENTITIES];
    private static int enrollmentCount = 0; // Melacak jumlah Enrollment yang ditambahkan

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objek Scanner untuk membaca input
        String line; // Variabel untuk menyimpan setiap baris input

        // Loop utama untuk membaca input hingga pengguna mengetik "---"
        while (scanner.hasNextLine()) {
            line = scanner.nextLine(); // Baca satu baris input

            // Cek jika input adalah tanda berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memproses setiap baris input
            // Format input: command#data1#data2#...
            String[] segments = line.split("#");
            String command = segments[0]; // Bagian pertama adalah perintah

            switch (command) {
                case "course-add":
                    // Format: course-add#code#name#credits#grade
                    if (segments.length == 5) {
                        String code = segments[1];
                        String name = segments[2];
                        int credits = Integer.parseInt(segments[3]); // Konversi String ke int
                        String grade = segments[4]; // Nilai default Course, contoh 'C'
                        
                        if (courseCount < MAX_ENTITIES) {
                            courses[courseCount] = new Course(code, name, credits, grade);
                            courseCount++;
                        } else {
                            System.err.println("Penyimpanan Course penuh, tidak bisa menambah lagi: " + line);
                        }
                    } else {
                        System.err.println("Format input 'course-add' tidak valid: " + line);
                    }
                    break;
                case "student-add":
                    // Format: student-add#id#name#entryYear#studyProgram
                    if (segments.length == 5) {
                        String id = segments[1];
                        String name = segments[2];
                        String entryYear = segments[3];
                        String studyProgram = segments[4];

                        if (studentCount < MAX_ENTITIES) {
                            students[studentCount] = new Student(id, name, entryYear, studyProgram);
                            studentCount++;
                        } else {
                            System.err.println("Penyimpanan Student penuh, tidak bisa menambah lagi: " + line);
                        }
                    } else {
                        System.err.println("Format input 'student-add' tidak valid: " + line);
                    }
                    break;
                case "enrollment-add":
                    // Format: enrollment-add#courseCode#studentId#academicYear#semester
                    if (segments.length == 5) {
                        String courseCode = segments[1];
                        String studentId = segments[2];
                        String academicYear = segments[3];
                        String semester = segments[4];

                        // Grade akan diinisialisasi "None" oleh konstruktor Enrollment
                        if (enrollmentCount < MAX_ENTITIES) {
                            enrollments[enrollmentCount] = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollmentCount++;
                        } else {
                            System.err.println("Penyimpanan Enrollment penuh, tidak bisa menambah lagi: " + line);
                        }
                    } else {
                        System.err.println("Format input 'enrollment-add' tidak valid: " + line);
                    }
                    break;
                default:
                    System.err.println("Perintah tidak dikenal: " + command + " pada baris: " + line);
                    break;
            }
        }

        // --- Bagian Output ---
        // 1. Tampilkan semua Course
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        // 2. Tampilkan semua Student
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }

        // 3. Tampilkan semua Enrollment
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }

        scanner.close(); // Tutup objek Scanner
    }
}