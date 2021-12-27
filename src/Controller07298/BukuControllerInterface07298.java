package Controller07298;
import java.util.ArrayList;

import Entity07298.BukuEntity07298;

public interface BukuControllerInterface07298 {
   void insertBuku07298(String isbn, String judul, String penerbit, int terbit, int halaman);
   void deleteBuku07298(String isbn);
   void updateBuku07298(int pilihan, String data, String isbn);
   ArrayList<BukuEntity07298> showAllData07298();
   BukuEntity07298 getData07298(String isbn);   
}
