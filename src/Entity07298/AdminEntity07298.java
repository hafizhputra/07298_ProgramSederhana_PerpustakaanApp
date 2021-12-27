package Entity07298;

public class AdminEntity07298 extends UserAbstractEntity07298 {
    private int id;

    public AdminEntity07298(String nama, String password) {
        super(nama, password);
    }public int getId() {
        return id;
    }public void setId(int id) {
        this.id = id;
    }
}
