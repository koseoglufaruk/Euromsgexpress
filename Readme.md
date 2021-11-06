Otomaston Testi kodları Java proglamlama dili ve 
Selenium kütüphanesi kullanılarak yazılmıştır.
BDD Cucumber Framework kullanılmıştır.
Google Chrome browser üzerinden gerçekletirilmiştir.

Otomasyon testi sonucunda rapor oluşturmak isteniyorsa terminal açılır ve

"mvn verify"

yazılır.

Otomasyon testi sonucunda eğer FAIL bir test senaryosu varsa, 
test senaryosunun başarısız olma sebebinin test environment olmadığından
emin olmak için başarısız olan test senaryoları otomatik olarak yeniden 
test edilecektir.

Otomasyon testi sonunda 

"target" 

dosyasının altındaki
"cucumber-html-reports" 

dosyası içerisindeki

"html" uzantılı herhangi bir dosyaya sağ tıklanarak Chrome browser
ile birlikte açılır.




