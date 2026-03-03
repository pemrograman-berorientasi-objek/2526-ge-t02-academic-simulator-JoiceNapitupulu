package academic.driver;

import academic.model.Course; // Pastikan kelas Course Anda ada di academic/model
import java.util.Scanner;

public class Driver1 { // Nama kelas HARUS Driver1
    private static final int MAX_COURSES = 100;
    private static Course[] courses = new Course[MAX_COURSES];
    private static int courseCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                int credits = Integer.parseInt(segments[2]);
                String grade = segments[3]; // Contoh: 'C' atau 'A'

                if (courseCount < MAX_COURSES) {
                    courses[courseCount] = new Course(code, name, credits, grade);
                    courseCount++;
                } else {
                    System.err.println("Penyimpanan course penuh, tidak bisa menambah lagi.");
                }
            } else {
                System.err.println("Format input tidak valid: " + line);
            }
        }

        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        scanner.close();
    }
}