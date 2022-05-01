

FRONTEND İÇİN [**TIKLAYINIZ**](https://github.com/muratkistan/innova-patika-final-bank-frontend)

# PROJE HAKKINDA
### user-service
```bash
-  Banka hesabı açmak isteyen kullanıcıdan bilgileri alınarak validasyon işlemlerine tabi tutulur.
-  Validasyon işlemlerinden geçen kullanıcı PostgreSql veritabanına kaydedilir.
-  Daha sonradan kullanıcı silme, düzenleme işlemleri yapılabilir.
```
### credit-service
```bash
-  Kredi başvurusu yapmak isteyen kullanıcıdan kredi bilgileri alınır.
-  Validasyon işlemlerinden geçen kullanıcının kredi skor bilgileri ilgili servisten alınır.
-  Kriterlere göre kullanıcının kredi sonucu hesaplanır.
-  Kredi sonucu kullanıcıya bildirilir.
-  Kredi bilgileri MongoDB veritabanına kaydedilir
```
# PROJENİN MİKROSERVİS MİMARİSİ


![micro](https://user-images.githubusercontent.com/67208557/155906931-ccb5b120-40e0-4af6-85f0-8d4c8f152070.PNG)



# SERVİSLER

## EUREKA-SERVER

```
  path : localhost:8761
```

![eureka](https://user-images.githubusercontent.com/67208557/155900672-6c75af20-f481-4098-8738-ae338fba112d.PNG)


### API-GATEWAY

```
  path : localhost:9191
```




### USER-SERVICE




```
 path : localhost:9191/users/**  or USER-SERVICE/users/**
```

| Http Method | Erişim Noktası     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| GET      | `/users/getAll` | Veritabanındaki bütün kullanıcıları getirir. |
| GET      | `/users/{id}` | Veritabanında verilen id değeri ile eşleşen kullanıcı getirir.Eşleşme olmadığında hata objesi döndürür. |
| GET      | `/users/exists/{identityNumber}` | Verilen TC numaralı kullanıcının veritabanında olup olmadığını kontrol eder.Var ise true yok ise false döndürür. |
| POST      | `/users/add` | Validasyon işlemlerinden geçen kullanıcıyı veritabanına kaydeder. |
| PUT     | `/users/update/{id}` | Kullanıcının kayıtlı olup olmadığı kontrol edilir kayıtlı ise update işlemi yapılır.Kayıtlı değil ise hata objesi döndürür. |
| DELETE      | `/users/delete/{id}` | Kullanıcının kayıtlı olup olmadığı kontrol edilir kayıtlı ise delete işlemi gerçekleştirilir.Kayıtlı değil ise hata objesi dönülür. |





### CREDIT-SERVICE


```
 path : localhost:9191/credits/**  or CREDIT-SERVICE/credits/**
```

| Http Method | Erişim Noktası     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| GET      | `/credits/getAll` | Veritabanındaki bütün kredi bilgilerini getirir. |
| GET      | `/credits/{identityNumber}` | Veritabanından verilen TC numarası ile eşleşen kullanıcı getirir.Eşleşme olmadığında hata objesi döndürür. |
| POST      | `/credits/calculate` | Validasyon işlemlerinden geçen kullanıcının kredi bilgisi hesaplanır ve sonuç kullanıcıya dönülür. 

### KREDİ HESAPLAMA
![Untitled Diagram drawio](https://user-images.githubusercontent.com/67208557/166145954-787c9fe5-805e-46da-8f79-3c2ce9eab63d.png)


### COMMON-SERVICE

User ve Kredi servisleri için ortak olan objelerin bulunduğu servis.




