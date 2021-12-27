package Model07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;
import Entity07298.PeminjamanEntity07298;

import java.sql.*;
import java.time.LocalDate;

public class PeminjamanModelInterfaceimpl07298 implements PeminjamanModelInterface07298{
    private String generateIdPeminjaman(){
    String newId = null;
    String data;
    try {
      String sql = "SELECT peminjaman_id FROM peminjaman ORDER BY peminjaman_id DESC LIMIT 1";
      Statement stat =conn.createStatement();
      ResultSet rs = stat.executeQuery(sql);
      if(rs.next()){
         data = rs.getString("peminjaman_id");
      }else{
      data = "PJM000";
      }
      int angka = Integer.parseInt(data.substring(3));
      angka++;
      newId = "PJM"+String.format("%03d",angka);
    }catch(Exception e){
            e.printStackTrace();
    }return newId;
    }
    
    @Override
    public void add(PeminjamanEntity07298 peminjaman) {
         try {
        String sql = "INSERT INTO PEMINJAMAN(peminjaman_id,buku_isbn,anggota_id,peminjaman_tgl,status) Values(?,?,?,?,?)";
        PreparedStatement stat = conn.prepareStatement (sql);
        stat.setString(1, generateIdPeminjaman());
        stat.setString(2,peminjaman.getBuku().getIsbn());
        stat.setInt(3, peminjaman.getAnggota().getId());
        stat.setDate(4, Date.valueOf(LocalDate.now()));
        stat.setBoolean(5, false);
        stat.executeUpdate();
    }catch (Exception e){
      e.printStackTrace();
    } 
    }
 

    @Override
    public void verifPengembalian(String idPeminjaman) {
          try {
        String sql = "UPDATE PEMINJAMAN SET pengembalian_tgl = ?,status = true WHERE peminjaman_id = ? ";
        PreparedStatement stat = conn.prepareStatement (sql);
        stat.setString(2, idPeminjaman);
        stat.setDate(1, Date.valueOf(LocalDate.now()));
        stat.executeUpdate();
    }catch (Exception e){
      e.printStackTrace();
    }
    }
    
    @Override
    public ArrayList<PeminjamanEntity07298> getAll() {
        ArrayList<PeminjamanEntity07298> arrPeminjaman = new ArrayList<>();
          try {
             String sql = "SELECT p.*,  b.buku_judul, a.anggota_nama, a.anggota_password\n"
                          + "FROM peminjaman p\n" 
                          + "JOIN anggota a on p.anggota_id = a.anggota_id\n"
                          + "JOIN buku b on p.buku_isbn = b.buku_isbn\n" 
                          + "ORDER BY peminjaman_id";
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery(sql);
             while(rs.next()){
                PeminjamanEntity07298 peminjaman = new PeminjamanEntity07298();
                peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
                BukuEntity07298 buku = new BukuEntity07298();
                buku.setJudul(rs.getString("buku_judul"));
                buku.setIsbn(rs.getString("buku_isbn"));
                peminjaman.setBuku(buku);
                AnggotaEntity07298 anggota = new AnggotaEntity07298(rs.getString("anggota_nama"),
                                                          rs.getString("anggota_password"));
                peminjaman.setAnggota(anggota);
                peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
                peminjaman.setTglpengembalian(rs.getDate("pengembalian_tgl"));
                peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
                arrPeminjaman.add(peminjaman);
             }
    }catch(SQLException e){
            e.printStackTrace();
    }return arrPeminjaman;
    }

    @Override
    public ArrayList<PeminjamanEntity07298> getByPeminjam(int id) {
        ArrayList<PeminjamanEntity07298> peminjamanByUser = new ArrayList<>();
        try {
          String sql = "SELECT p.*, b.buku_judul FROM peminjaman p "
                  + "Join buku b on p.buku_isbn = b.buku_isbn "
                  + "WHERE anggota_id = ? "
                  + "ORDER BY peminjaman_tgl ";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setInt(1, id);
        ResultSet rs = stat.executeQuery();
        while(rs.next()){
            PeminjamanEntity07298 peminjaman = new PeminjamanEntity07298();
            peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
            BukuEntity07298 buku = new BukuEntity07298();
            buku.setJudul(rs.getString("buku_judul"));
            peminjaman.setBuku(buku);
            peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
            peminjaman.setTglpengembalian(rs.getDate("pengembalian_tgl"));
            peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
            peminjamanByUser.add(peminjaman);
         }
    }catch(SQLException e){
      e.printStackTrace();
    }return peminjamanByUser;
    }
    
}
