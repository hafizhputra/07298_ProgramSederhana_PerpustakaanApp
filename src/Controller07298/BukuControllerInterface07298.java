package Controller07298;

import java.util.ArrayList;

import Entity07298.BukuEntity07298;

public interface BukuControllerInterface07298 {
    void insertBuku(String isbn, String judul, String penerbit, int terbit, int halaman);
    void deleteBuku(String isbn);
    void updateBuku(int pilihan, String isbn, String data);
    ArrayList<BukuEntity07298> showAllData();
    BukuEntity07298 getData(String isbn);
}
