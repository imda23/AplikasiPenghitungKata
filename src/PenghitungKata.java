/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dimas
 */
public class PenghitungKata {
    // Menghitung jumlah kata
    public int hitungKata(String teks) {
        if (teks == null || teks.trim().isEmpty()) {
            return 0;
        }
        // Menggunakan regex untuk menghitung kata
        String[] kata = teks.trim().split("\\s+");
        return kata.length;
    }
    
    // Menghitung jumlah karakter dengan spasi
    public int hitungKarakterDenganSpasi(String teks) {
        if (teks == null) {
            return 0;
        }
        return teks.length();
    }
    
    // Menghitung jumlah karakter tanpa spasi
    public int hitungKarakterTanpaSpasi(String teks) {
        if (teks == null) {
            return 0;
        }
        return teks.replaceAll("\\s", "").length();
    }
    
    // Menghitung jumlah kalimat
    public int hitungKalimat(String teks) {
        if (teks == null || teks.trim().isEmpty()) {
            return 0;
        }
        // Regex untuk mendeteksi akhir kalimat (. ! ?)
        Pattern pattern = Pattern.compile("[.!?]+");
        Matcher matcher = pattern.matcher(teks);
        int jumlah = 0;
        while (matcher.find()) {
            jumlah++;
        }
        return jumlah;
    }
    
    // Menghitung jumlah paragraf
    public int hitungParagraf(String teks) {
        if (teks == null || teks.trim().isEmpty()) {
            return 0;
        }
        // Split berdasarkan baris kosong (paragraf)
        String[] paragraf = teks.split("\\n\\s*\\n");
        int jumlah = 0;
        for (String p : paragraf) {
            if (!p.trim().isEmpty()) {
                jumlah++;
            }
        }
        // Jika tidak ada paragraf terpisah, berarti 1 paragraf
        return jumlah == 0 ? 1 : jumlah;
    }
    
    // Mencari kata tertentu dalam teks
    public int cariKata(String teks, String kataDicari) {
        if (teks == null || teks.trim().isEmpty() || 
            kataDicari == null || kataDicari.trim().isEmpty()) {
            return 0;
        }
        
        // Regex untuk mencari kata (case insensitive)
        String regex = "\\b" + Pattern.quote(kataDicari) + "\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(teks);
        
        int jumlah = 0;
        while (matcher.find()) {
            jumlah++;
        }
        return jumlah;
    }
}
