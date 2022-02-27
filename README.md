# Innova Patika Java Spring Bootcamp Bitirme Projesi

Bu repositoryde bitirme projesinin backend tarafi bulunmaktadir.
Projenin frontend reposuna gitmek icin [**buraya**](https://github.com/muratkistan/innova-patika-final-bank-frontend) tiklayabilirsiniz.

## API KULLANIMI

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
| GET      | `/users/id` | Veritabanında verilen id değeri ile eşleşen kullanıcı getirir.Eşleşme olmadığında hata objesi döndürür. |
| GET      | `/users/exists/identityNumber` | Verilen TC numaralı kullanıcın veritabanında olup olmadığını kontrol eder.Var ise true yok ise false döndürür. |
| POST      | `/users/add` | Validasyon işlemlerinden geçen kullanıcıyı veritabanına kaydeder. |
| PUT     | `/users/update/id` | Kullanıcının kayıtlı olup olmadığı kontrol edilir kayıtlı ise update işlemi yapılır.Kayıtlı değil ise hata objesi döndürür. |
| DELETE      | `/users/delete/id` | Kullanıcının kayıtlı olup olmadığı kontrol edilir kayıtlı ise delete işlemi gerçekleştirilir.Kayıtlı değil ise hata objesi dönülür. |



### CREDIT-SERVICE

```
 path : localhost:9191/credits/**  or CREDIT-SERVICE/credits/**
```

| Http Method | Erişim Noktası     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| GET      | `/credits/getAll` | Veritabanındaki bütün kredi bilgilerini getirir. |
| GET      | `/credits/identityNumber` | Veritabanından verilen TC numarası ile eşleşen kullanıcı getirir.Eşleşme olmadığında hata objesi döndürür. |
| POST      | `/credits/calculate` | Validasyon işlemlerinden geçen kullanıcının kredi skoru veritabanından çekilir.  Kullanıcının kredi skoru veritabanına kayıtlı değil ise yeni bir kullanıcı olduğu için  kullanıcıya asgari oranda skor verilir , kredisi hesaplanır ve kullanıcıya dönülür. Verilen  minimum skor skorlar tablosuna kaydedilir ve kullanıcı yeni bir kullanıcı olduğu için bilgileri veri tabanına kaydedilmesi için  user-service ' e gönderilir.|





## Projenin Mikroservis Mimarisi
![mikroprojenotransparan](https://user-images.githubusercontent.com/67208557/155883337-61aade45-0a95-4f4d-aa65-8ae6c68a96fe.png)