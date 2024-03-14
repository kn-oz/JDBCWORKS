Feature: Select Query Execute

  Background: DataBase baglantisi kurar.
    * Database baglantisi kurulur.
@query01
  Scenario: Database içindeki "deposits" toblosunda "amount" değeri
  100$ ile 500$ arasında olan user_id'leri doğrulayınız.


    * Database baglantisi kurulur.
    * Query hazirlanir ve execute edilir.
    * Sonuclar islenir.
    * Database baglantisi kapatilir.

@query02
  Scenario: Database içindeki "cron_schedules" tablosundaki ilk 2 kaydın "name" bilgisini doğrulayınız.

    * Query02 hazirlanir ve execute edilir.
    * Result02 Sonuclar islenir.
    * Database baglantisi kapatilir.


