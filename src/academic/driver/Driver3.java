package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner; // Digunakan untuk membaca input dari konsol

public class Driver3 {
    // Ukuran array statis untuk menyimpan objek Enrollment.
    // Anda bisa mengubah ukuran ini sesuai kebutuhan.
    private static final int MAX_ENROLLMENTS = 100;
    private static Enrollment[] enrollments = new Enrollment[MAX_ENROLLMENTS];
    private static int enrollmentCount = 0; // Melacak jumlah enrollment yang sudah ditambahkan

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

            // Memproses setiap baris input data enrollment
            // Contoh format input: 12S2203#12S20999#2021/2022#even
            String[] segments = line.split("#"); // Pisahkan string berdasarkan "#"

            // Validasi format input: harus ada 4 bagian (CourseCode, StudentID, AcademicYear, Semester)
            if (segments.length == 4) {
                String courseCode = segments[0];
                String studentId = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                // Tambahkan objek Enrollment baru ke array jika masih ada ruang
                if (enrollmentCount < MAX_ENROLLMENTS) {
                    enrollments[enrollmentCount] = new Enrollment(courseCode, studentId, academicYear, semester);
                    enrollmentCount++; // Tambah hitungan enrollment
                } else {
                    // Beri peringatan jika array penuh
                    System.err.println("Penyimpanan enrollment penuh, tidak bisa menambah lagi: " + line);
                }
            } else {
                // Beri peringatan jika format input tidak valid
                System.err.println("Format input tidak valid untuk enrollment: " + line);
            }
        }

        // Setelah semua input selesai, tampilkan semua objek Enrollment yang tersimpan
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString()); // Gunakan method toString untuk format output
        }

        scanner.close(); // Tutup objek Scanner untuk mencegah resource leak
    }
}