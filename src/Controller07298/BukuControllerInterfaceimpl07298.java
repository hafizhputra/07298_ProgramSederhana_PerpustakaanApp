package Controller07298;

import java.util.ArrayList;

import Entity07298.BukuEntity07298;

public class BukuControllerInterfaceimpl07298 implements BukuControllerInterface07298 {
    @Override
    public void insertBuku07298(String isbn, String judul, String penerbit, int terbit, int halaman) {
        BukuEntity07298 buku = new BukuEntity07298();
        buku.setIsbn(isbn);
        buku.setJudul(judul);
        buku.setPenerbit(penerbit);
        buku.setTerbit(terbit);
        buku.setHalaman(halaman);
        AllObjectModel07298.bukuModel.add(buku);
    }
    @Override
    public void deleteBuku07298(String isbn) {
        AllObjectModel07298.bukuModel.delete(isbn);
    }
    @Override
    public void updateBuku07298(int pilihan, String data, String isbn) {
      if(pilihan == 1){
        AllObjectModel07298.bukuModel.updateJudul(data, isbn);
      }else if(pilihan == 2){
        AllObjectModel07298.bukuModel.updatePenerbit(data, isbn);
      }
    }
    @Override
    public ArrayList<BukuEntity07298> showAllData07298() {
        return AllObjectModel07298.bukuModel.getAll();
    }
    @Override
    public BukuEntity07298 getData07298(String isbn) {
        return AllObjectModel07298.bukuModel.getById(isbn); 
    }
}
