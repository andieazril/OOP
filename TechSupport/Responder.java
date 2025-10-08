 import java.util.Map;  
 import java.util.HashMap;  
 import java.util.Random; 

public class Responder {
    private Map<String, String> responses;  
   private Random random;  
    
    public Responder(){
        responses = new HashMap<>();  
         random = new Random();
         responses.put("login", "Apakah Anda mengalami kesulitan login ke sistem FRS? Coba periksa kembali NIM dan password Anda.");  
        responses.put("akses", "Apakah FRS sudah dibuka oleh pihak akademik? Pastikan jadwal pengisian FRS sudah dimulai.");  
        responses.put("tambah", "Mata kuliah apa yang ingin Anda tambahkan? Pastikan tidak bentrok dengan jadwal lain.");  
        responses.put("hapus", "Apakah Anda yakin ingin menghapus mata kuliah tersebut dari FRS? Periksa kembali beban SKS Anda.");  
        responses.put("pembimbing", "Apakah Anda sudah berkonsultasi dengan dosen pembimbing akademik sebelum menyimpan FRS?");  
        responses.put("simpan", "Apakah sistem menampilkan pesan berhasil setelah disimpan? Coba refresh halaman FRS Anda.");  
        responses.put("validasi", "Sudahkah FRS Anda divalidasi oleh dosen pembimbing? Tanpa validasi, FRS belum dianggap sah.");  
        responses.put("cetak", "Apakah Anda ingin mencetak FRS? Gunakan menu 'Cetak FRS' setelah status validasi disetujui.");  
        responses.put("error", "Apakah muncul pesan kesalahan saat mengisi FRS? Coba logout dan login kembali.");  
        responses.put("help", "Ada yang bisa saya bantu terkait pengisian FRS Anda?");
    }
    
        public String generateResponse(String userInput){
         String[] words = userInput.toLowerCase().split("\\s+");  
         for (String w : words) {  
           if (responses.containsKey(w)) {  
             return responses.get(w);  
           }  
         }  
         // kalau tidak ada kata kunci cocok, jawaban acak generik  
         String[] generic = {  
           "Coba jelaskan lebih rinci.",  
           "Saya belum mengerti, bisa ulangi?",  
           "Bisakah Anda memberi detail lebih lanjut?"  
         };  
         return generic[random.nextInt(generic.length)];  
    }
}