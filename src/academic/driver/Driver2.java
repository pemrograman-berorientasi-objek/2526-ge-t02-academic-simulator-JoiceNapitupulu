package academic.driver;

import academic.model.Student;
import java.util.Scanner; // Digunakan untuk membaca input dari konsol

public class Driver2 {
    // Ukuran array statis untuk menyimpan objek Student.
    // Anda bisa mengubah ukuran ini sesuai kebutuhan.
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0; // Melacak jumlah mahasiswa yang sudah ditambahkan

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

            // Memproses setiap baris input data mahasiswa
            // Contoh format input: 12S20999#Wiro Sableng#2020#Information Systems
            String[] segments = line.split("#"); // Pisahkan string berdasarkan "#"

            // Validasi format input: harus ada 4 bagian (ID, Nama, Tahun Masuk, Prodi)
            if (segments.length == 4) {
                String id = segments[0];
                String name = segments[1];
                String entryYear = segments[2];
                String studyProgram = segments[3];

                // Tambahkan objek Student baru ke array jika masih ada ruang
                if (studentCount < MAX_STUDENTS) {
                    students[studentCount] = new Student(id, name, entryYear, studyProgram);
                    studentCount++; // Tambah hitungan mahasiswa
                } else {
                    // Beri peringatan jika array penuh
                    System.err.println("Penyimpanan mahasiswa penuh, tidak bisa menambah lagi: " + line);
                }
            } else {
                // Beri peringatan jika format input tidak valid
                System.err.println("Format input tidak valid untuk mahasiswa: " + line);
            }
        }

        // Setelah semua input selesai, tampilkan semua objek Student yang tersimpan
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString()); // Gunakan method toString untuk format output
        }

        scanner.close(); // Tutup objek Scanner untuk mencegah resource leak
    }
}