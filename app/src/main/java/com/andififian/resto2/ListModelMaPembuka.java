package com.andififian.resto2;

public class ListModelMaPembuka {
    String id, menu_makanan, harga, gambar_makanan, nama_makanan, desc_makanan;
    public ListModelMaPembuka(){};
    public ListModelMaPembuka(String id, String menu_makanan, String harga, String gambar_makanan, String nama_makanan, String desc_makanan) {
        this.id = id;
        this.menu_makanan = menu_makanan;
        this.harga = harga;
        this.gambar_makanan = gambar_makanan;
        this.nama_makanan = nama_makanan;
        this.desc_makanan = desc_makanan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenu_makanan() {
        return menu_makanan;
    }

    public void setMenu_makanan(String menu_makanan) {
        this.menu_makanan = menu_makanan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getGambar_makanan() {
        return gambar_makanan;
    }

    public void setGambar_makanan(String gambar_makanan) {
        this.gambar_makanan = gambar_makanan;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public String getDesc_makanan() {
        return desc_makanan;
    }

    public void setDesc_makanan(String desc_makanan) {
        this.desc_makanan = desc_makanan;
    }
}
