package house.duan.asm_api;

public class carmodel {
     private String _id;

     private String ten;

     private  int namXS;

     private  String hang;

     private  double gia;

    public carmodel(String _id, String ten, int namXS, String hang, double gia) {
        this._id = _id;
        this.ten = ten;
        this.namXS = namXS;
        this.hang = hang;
        this.gia = gia;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamXS() {
        return namXS;
    }

    public void setNamXS(int namXS) {
        this.namXS = namXS;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
