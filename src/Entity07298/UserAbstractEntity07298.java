package Entity07298;

public abstract class UserAbstractEntity07298 {
    protected String nama;
    protected String password;
    
    public UserAbstractEntity07298(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }public String getNama() {
        return nama;
    }public void setNama(String nama) {
        this.nama = nama;
    }public String getPassword() {
        return password;
    }public void setPassword(String password) {
        this.password = password;
    }   
}
