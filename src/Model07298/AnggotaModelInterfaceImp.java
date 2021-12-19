package Model07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;

import java.sql.*;

public class AnggotaModelInterfaceImp implements AnggotaModelInterface07298{

    @Override
    public void add(AnggotaEntity07298 anggota) {
        try{
            String sql = "INSERT INTO anggota (anggota_nama, anggota_password, anggota_notelp, anggota_alamat) values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, anggota.getNama());
            stat.setString(2, anggota.getPassword());
            stat.setString(3, anggota.getNoTelp());
            stat.setString(4, anggota.getAlamat());
            stat.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try{
            String sql = "UPDATE anggota SET anggota_aktif = false WHERE anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int login(String nama, String password) {
        int login = 0;
        try{
            String sql = "SELECT * FROM anggota WHERE anggota_nama = ? AND anggota_password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                login = rs.getInt("anggota_id");
            }else{
                login = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return login;
    }

    @Override
    public ArrayList<AnggotaEntity07298> getAll() {
        ArrayList<AnggotaEntity07298> arrAnggota = new ArrayList<>();
        try{
            String sql = "SELECT * FROM anggota WHERE anggota_aktif = true";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                AnggotaEntity07298 anggota = new AnggotaEntity07298(rs.getString("anggota_nama"),
                    rs.getString("anggota_password"),
                    rs.getString("anggota_notelp"),
                    rs.getString("anggota_alamat"));
                anggota.setId(rs.getInt("anggota_id"));
                arrAnggota.add(anggota);
            }
        }catch(Exception e){
            e.printStackTrace();
        }return arrAnggota;
    }

    @Override
    public AnggotaEntity07298 getById(int id) {
        AnggotaEntity07298 anggota = null;
        try{
            String sql = "SELECT * FROM anggota WHERE anggota_aktif = true AND anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                anggota = new AnggotaEntity07298(rs.getString("anggota_nama"),
                    rs.getString("anggota_password"),
                    rs.getString("anggota_notelp"),
                    rs.getString("anggota_alamat"));
                anggota.setId(rs.getInt("anggota_id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }return anggota;
    }

    @Override
    public void resetPassword(int id) {
        try {
            String sql = "UPDATE anggota SET anggota_password = '1234' WHERE anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateNoTelp(String noTelp, int id) {
        try {
            String sql = "UPDATE anggota SET anggota_notelp = ? WHERE anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAlamat(String alamat, int id) {
        try {
            String sql = "UPDATE anggota SET anggota_alamat = ? WHERE anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, alamat);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePassword(String password, int id) {
        try {
            String sql = "UPDATE anggota SET anggota_password = ? WHERE anggota_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
