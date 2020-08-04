package prolab2_3;

/**
 *
 * @author BerkayEfe
 */
import java.sql.*;
import java.util.ArrayList;

public class VeriTabanı {

    private Connection con;
    private Statement statement;
    private ResultSet resulSet;
    private PreparedStatement preparedStatement;
    private BilgiMesajı bilgiMesajı;
    private HataMesajı hataMesajı;
    private UyarıMesajı uyarıMesajı;

    public VeriTabanı() {
        bilgiMesajı = new BilgiMesajı();
        hataMesajı = new HataMesajı();
        uyarıMesajı = new UyarıMesajı();
        baglantiYap();
        
    }

    private void baglantiYap() {
        
        try {

            con = DriverManager.getConnection("jdbc:ucanaccess://prolab.accdb");
            // veri tabanina baglanti saglaniyor.
            statement = con.createStatement();
            //baglantidan ifade olusturuldu.
        } catch (Exception ee) {
            System.out.println("Veri tabanına bağlantı sağlanamadı" + ee);
            uyarıMesajı.mesajVer("Fatal error : Veri tabanına bağlanılamadı\n "
                    + "prolab.accdb dosyasinin varligindan emin olun", "Baglanti yok ");
            System.exit(0); // sistemden cikiliyor
        }
    }

    public void getir() {
        try {

            resulSet = statement.executeQuery("select * from Program");

            while (resulSet.next()) {
                System.out.println(resulSet.getString(3));
            }

        } catch (Exception e) {
        }

    }

    public void kullaniciEkle(String adSoyad, String sifre, String email,
            String dogumTarihi) {

        String sorgu = "Insert Into Kullanici(ad_soyad,sifre,dogum_tarihi,email) values(?,?,?,?)";
        Date date = dateNesnesiOlustur(dogumTarihi);

        try {

            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, adSoyad);
            preparedStatement.setString(2, sifre);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, email);
            try {
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                uyarıMesajı.mesajVer("Bu email sisteme kayıtlı", "MEVCUT KAYIT");
            }

            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println("kullanici eklenirken veri tabanı sorunu :" + ex);
        }

    }

    public String[] girisYap(String email, String parola) {
        String[] kullaniciVerisi = new String[3];
        String kayitliParola;
        String sorgu = "select * from Kullanici where email ='" + email + "';";
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);
            resulSet.next();
            try {

                kullaniciVerisi[0] = resulSet.getString("kullaniciID");
                kullaniciVerisi[1] = resulSet.getString("ad_soyad");
                kullaniciVerisi[2] = resulSet.getString("dogum_tarihi");
                kayitliParola = resulSet.getString("sifre");
                if (kayitliParola.equals(parola)) {
                    // sifreler eslesirse giris yapilacak.
                    bilgiMesajı.mesajVer("Hoşgeldiniz " + kullaniciVerisi[1],
                            "giris yapildi");
                    return kullaniciVerisi;
                } else {
                    uyarıMesajı.mesajVer("Şire ya da email yanlış", "DOĞRULAMA HATASI");
                }
                 statement.close();
            } catch (Exception e) {
                String mesaj = email + " maili ile ilgili bir kayıt bulunamadı.";
                uyarıMesajı.mesajVer(mesaj, "Kullanıcı yok");
                 statement.close();
            }
            statement.close();
        } catch (SQLException ex) {
            hataMesajı.mesajVer("giriş yapılırken sql sorgu hatası: " + ex, "hata");
            
        }
        return new String[3]; // bos string dizisi donduruluyor.
    }

    public boolean emailKayitliMi(String email) {

        String sorgu = "SELECT * FROM Kullanici WHERE email ='" + email + "';";
        try {

            resulSet = statement.executeQuery(sorgu);
            resulSet.next();
            try {

                resulSet.getString(email);

            } catch (Exception e) {
                return false;
            }
            // resulSet.close(); // baglanti kapatiliyor.
            statement.close();
        } catch (SQLException ex) {
            System.out.println("email sorgulanıken hata" + ex);
            return false;
        }
        return true;
    }

    public ArrayList<ArrayList<String>> ismeGoreFilmAra(String filmIsmi) {
        String sorgu = "SELECT * FROM Program WHERE ad LIKE '*" + filmIsmi + "*' AND"
                + " tip = 'Film' ; "; // filmleri cektik

        ArrayList<ArrayList<String>> sonucList = new ArrayList<>();
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);// sorgu calistirildi.
            while (resulSet.next()) {
                ArrayList<String> filmOzellikleriArrayList = new ArrayList<>();
                String id = resulSet.getString("programID");
                String ad = resulSet.getString("ad");
                String uzunluk = resulSet.getString("uzunluk");
                String bolumSayisi = resulSet.getString("bolum_sayisi");
                String tip = resulSet.getString("tip");
                filmOzellikleriArrayList.add(id);
                filmOzellikleriArrayList.add(ad);
                filmOzellikleriArrayList.add(uzunluk);
                filmOzellikleriArrayList.add(bolumSayisi);
                filmOzellikleriArrayList.add(tip);

                sonucList.add(filmOzellikleriArrayList);
                statement.close();
            }
        } catch (SQLException ex) {
            System.out.println("filmler aranirken hata olustu..." + ex);
        }
        return sonucList;
    }
    

    public ArrayList<ArrayList<String>> ismeGoreDiziveTVShowAra(String filmIsmi) {
        String sorgu = "SELECT * FROM Program WHERE ad LIKE '*" + filmIsmi + "*' AND"
                + " ( tip = 'Dizi' OR tip = 'TV Show'); "; // filmleri cektik

        ArrayList<ArrayList<String>> sonucList = new ArrayList<>();
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);// sorgu calistirildi.
            while (resulSet.next()) {
                ArrayList<String> filmOzellikleriArrayList = new ArrayList<>();
                String id = resulSet.getString("programID");
                String ad = resulSet.getString("ad");
                String uzunluk = resulSet.getString("uzunluk");
                String bolumSayisi = resulSet.getString("bolum_sayisi");
                String tip = resulSet.getString("tip");
                filmOzellikleriArrayList.add(id);
                filmOzellikleriArrayList.add(ad);
                filmOzellikleriArrayList.add(uzunluk);
                filmOzellikleriArrayList.add(bolumSayisi);
                filmOzellikleriArrayList.add(tip);

                sonucList.add(filmOzellikleriArrayList);
                statement.close();
            }
        } catch (SQLException ex) {
            System.out.println("filmler aranirken hata olustu..." + ex);
        }
        return sonucList;
    }

    public String[] kullaniciVerileriniGetir(String email) {
        String[] kullaniciBilgileri = new String[3];// adSoyad email DogumTarihi
        String sorgu = "select * from Kullanici where email ='" + email + "';";

        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);
            resulSet.next();

            kullaniciBilgileri[0] = resulSet.getString("kullaniciID");
            kullaniciBilgileri[1] = resulSet.getString("ad_soyad");
            kullaniciBilgileri[2] = resulSet.getString("dogum_tarihi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Kullanici Bilgileri getirilirken sorun olustu " + e);
        }
        return kullaniciBilgileri;
    }

    public ArrayList<ArrayList<String>> tureGoreAramaYap(String programIsmi,
            String turIsmi) {
        String sorgu = "SELECT * FROM  Program WHERE  ad LIKE '*" + programIsmi + "*' "
                + "AND programID IN (SELECT programID  FROM   ProgramTur "
                + "WHERE turID IN (SELECT turID FROM Tur  WHERE ad = '" + turIsmi
                + "' ));";
        //System.out.println(sorgu);
        ArrayList<ArrayList<String>> sonucList = new ArrayList<>();
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);// sorgu calistirildi.
            while (resulSet.next()) {
                ArrayList<String> programVeOzellikleriArrayList = new ArrayList<>();
                String id = resulSet.getString("programID");
                String ad = resulSet.getString("ad");
                String uzunluk = resulSet.getString("uzunluk");
                String bolumSayisi = resulSet.getString("bolum_sayisi");
                String tip = resulSet.getString("tip");
                programVeOzellikleriArrayList.add(id);
                programVeOzellikleriArrayList.add(ad);
                programVeOzellikleriArrayList.add(uzunluk);
                programVeOzellikleriArrayList.add(bolumSayisi);
                programVeOzellikleriArrayList.add(tip);

                sonucList.add(programVeOzellikleriArrayList);
                statement.close();
            }

        } catch (SQLException ex) {
            System.out.println("ture gore arama yapilirken hata olustu..." + ex);
        }
        return sonucList;

    }

    public void kullaniciProgramTablosunaVeriEkle(int programID, int kullaniciID,
            String tarih, int sure, int kalinanBolum, int verilenPuan) {
        /*System.out.println("id:" + programID + " kullaniciID:" + kullaniciID + " tarih:"
                + tarih + " sure :" + sure + " kalinanBolum:" + kalinanBolum + " verilenPuan:" + verilenPuan);*/
        String sorgu = "Insert Into KullaniciProgram(programID,kullaniciID,"
                + "tarih,sure,kalinan_bolum,verilen_puan) values(?,?,?,?,?,?)";
        Date date = dateNesnesiOlustur(tarih);

        try {

            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, programID);
            preparedStatement.setInt(2, kullaniciID);
            preparedStatement.setDate(3, date);
            preparedStatement.setInt(4, sure);
            preparedStatement.setInt(5, kalinanBolum);
            preparedStatement.setInt(6, verilenPuan);
            try {
                preparedStatement.executeUpdate();
                preparedStatement.close();
                //System.out.println("basariyle eklendi 11");
            } catch (Exception e) {
                preparedStatement.close();

                String sqlSorgusu = "UPDATE KullaniciProgram SET verilen_puan =? "
                        + ",sure = ? ,kalinan_bolum = ?,tarih = ? WHERE kullaniciID=? "
                        + "and programID=? ";
                preparedStatement = con.prepareStatement(sqlSorgusu);
                preparedStatement.setInt(1, verilenPuan);
                preparedStatement.setInt(2, sure);
                preparedStatement.setInt(3, kalinanBolum);
                preparedStatement.setDate(4, date);
                preparedStatement.setInt(5, kullaniciID);
                preparedStatement.setInt(6, programID);

                preparedStatement.executeUpdate();
                //System.out.println("guncelleme basariyla calisti.");
                preparedStatement.close();
            }

        } catch (SQLException ex) {
            System.out.println("kullaniciProgram tablosuna veri eklenirken sorun :" + ex);
        }

    }

    public ArrayList<ArrayList<String>> kullanicininIzlemisOlduguProgramlarinIdsiniGetir(String kullaniciID) {
        ArrayList<ArrayList<String>> sonucList = new ArrayList<>();

        String sorgu = "SELECT programID,sure,kalinan_bolum FROM  KullaniciProgram WHERE kullaniciId =  " + kullaniciID;
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);// sorgu calistirildi.
            while (resulSet.next()) {
                ArrayList<String> programVeOzellikleriArrayList = new ArrayList<>();
                String id = resulSet.getString("programID");
                String sure = resulSet.getString("sure");
                String kalinanBolum = resulSet.getString("kalinan_bolum");

                programVeOzellikleriArrayList.add(id);
                programVeOzellikleriArrayList.add(sure);
                programVeOzellikleriArrayList.add(kalinanBolum);
                sonucList.add(programVeOzellikleriArrayList);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("kullanicinin izledigi filmler cekilirken hata olustu hata olustu..." + ex);
        }
        return sonucList;
    }

    public ArrayList<String> idyeGoreProgramOzellikleriniGetir(String programID) {
        String sorgu = "SELECT * FROM Program WHERE programID = " + programID + ";"; // filmleri cektik
        //System.out.println(sorgu);
        ArrayList<String> filmOzellikleriArrayList = new ArrayList<>();
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);// sorgu calistirildi.
            resulSet.next();
            String id = resulSet.getString("programID");
            String ad = resulSet.getString("ad");
            String uzunluk = resulSet.getString("uzunluk");
            String bolumSayisi = resulSet.getString("bolum_sayisi");
            String tip = resulSet.getString("tip");
            filmOzellikleriArrayList.add(ad);
            filmOzellikleriArrayList.add(uzunluk);
            filmOzellikleriArrayList.add(bolumSayisi);
            filmOzellikleriArrayList.add(tip);
            statement.close();
        } catch (SQLException ex) {
            System.out.println("id ye gorefilmler aranirken hata olustu..." + ex);
        }
        return filmOzellikleriArrayList;
    }

    public ArrayList<ArrayList<String>> turIsmineGoreEnCokPuanAlanIkiFilmiGetir(String turIsmi) {
        ArrayList<ArrayList<String>> sonuc = new ArrayList<>();

        String sorgu = "SELECT TOP 2  p.ad,kp.programID,SUM(verilen_puan) as toplam FROM "
                + "KullaniciProgram kp , ProgramTur pt, Program p ,Tur t WHERE  "
                + "kp.programID = pt.programId and p.programId = pt.programID and "
                + "p.tip='Film' and t.TurID =pt.TurID and t.ad=?\n"
                + "GROUP BY kp.programID,p.ad\n"
                + "ORDER BY SUM(verilen_puan) desc";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, turIsmi);
            resulSet = preparedStatement.executeQuery();
            while (resulSet.next()) {
                ArrayList<String> programOzellikerli = new ArrayList<>();
                try {
                    String id = resulSet.getString("programID");
                    String programAd = resulSet.getString("ad");
                    String puan = resulSet.getString("toplam");
                    
                    programOzellikerli.add(id);
                    programOzellikerli.add(programAd);
                    programOzellikerli.add(puan);
                } catch (Exception e) {
                    programOzellikerli.add("0");
                    programOzellikerli.add("Film Bulunamadi");
                    programOzellikerli.add("0");
                    
                }
                 sonuc.add(programOzellikerli);
            }
           
        } catch (Exception e) {

            System.out.println("en çok puan alan filmleri getirirken sorgu hatası" + e);
        }
        return sonuc;
    }

    public ArrayList<String> turTablosundanTurIsimleriniGetir() {
        ArrayList<String> sonuc = new ArrayList<>();
        String sorgu = "Select ad from Tur";
        try {
            statement = con.createStatement();
            resulSet = statement.executeQuery(sorgu);
            while (resulSet.next()) {

                sonuc.add(resulSet.getString("ad"));

            }
        } catch (Exception e) {
            System.out.println("program turlerinin isimleri  getirilirken  sorgu hatası : " + e);
        }
        return sonuc;
    }

    private Date dateNesnesiOlustur(String tarih) {
        String[] tarihler = tarih.split("/");
        //  bolu isaretine gore tarihler parcalanaiyor.
        int yil = Integer.parseInt(tarihler[2]) - 1900;// 1900 date classinin ozelligi oyle istiyor.
        int ay = Integer.parseInt(tarihler[1]) - 1;
        int gun = Integer.parseInt(tarihler[0]);
        return new Date(yil, ay, gun);

    }
}
