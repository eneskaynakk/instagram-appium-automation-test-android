## Özellikler
- Java kullanılarak yazılmıştır.
- Appium ile instagram mobil otomasyon testi.
- Cucumber ile BDD (Behavior Driven Development) testi.
- TestNG entegrasyonu ile test yönetimi.
- Allure Raporlama desteği.
- Jira ile test senaryolarının takibi.
- Log4j2 ile detaylı test loglama ve hata ayıklama.
- Commons Email ile hata alınan sayfaların ekran görüntülerini e-posta ile gönderme.

## Gereksinimler
Projeyi çalıştırabilmek için aşağıdaki araçlara ihtiyacınız var:
- Java 11
- Appium 2.17.0
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse vb.)
- Android Studio
- Jira
- Appium Inspector (İsteğe bağlı)

## Maven, Appium ve Allure Kurulum Adımları
### 1. Maven Kurulumu
1. Maven indirin.
2. Dosyaları açın ve sistem değişkenlerine MAVEN_HOME ekleyin.
3. PATH değişkenine MAVEN_HOME/bin yolunu ekleyin.
4. Maven'ın doğru kurulduğunu kontrol etmek için terminale şu komutu yazın:
    ```bash
    mvn -version

### 2. Appium Kurulumu
1. Appium'u indirmek için terminale şu komutu yazın:
    ```bash
    npm install -g appium
2. Appium'un indirilip indirilmediğini öğrenmek için terminale şu komutu yazın:
    ```bash
    appium -v
    
3. UiAutomator2 Driver kurulumu için terminale şu komutu yazın:
    ```bash
    appium driver install uiautomator2

4. UiAutomator2 Driver'ın kurulup kurulmadığını öğrenmek için terminale şu komutu yazın:
   ```bash
    appium driver list

### 3. Allure Report Kurulumu
1. *Allure Report* indirin.
2. İndirilen dosyanın yolunu sistem değişkenlerinde path'e ekleyin.
3. Kurulumu kontrol etmek için terminale şu komutu yazın:
    ```bash
    allure --version

## Nasıl Çalıştırılır?
1. Projeyi klonlayın:
    ```bash
    git clone https://github.com/eneskaynakk/amazon-test-automation.git
    cd projeadi
    
2. Maven bağımlılıklarını yükleyin:
    ```bash
    mvn clean install
    
3. Testleri çalıştırın:
    ```bash
    mvn test
    
## Raporlama
Test çalıştırmalarından sonra Allure raporlarını görüntülemek için aşağıdaki adımları takip edin:  
1. Maven testleri tamamlandıktan sonra allure-results klasörüne rapor dosyaları oluşturulacaktır.  
2. Raporu görüntülemek için terminale şu komutu yazın:  
    ```bash
    allure serve allure-results

## Config Dosyası
Test çalıştırmadan önce aşağıdaki adımları takip edin:  
1. resources klasörünün altında qa.properties adında dosya oluşturun.
2. Dosyanın içerisine aşağıdaki değişkenlerin değerlerini kendi değerlerinize göre uyarlayın:
   ```bash
   platformName = Android
   automationName = UiAutomator2
   deviceName = sdk_gphone64_x86_64
   udId = emulator-5554
   platformVersion = 15
   appPackage = com.instagram.android
   appActivity = com.instagram.android.activity.MainTabActivity

   #Login Credentials
   email = instagramMail
   password = instagramPassword

   #Gmail Credentials
   yourEmail = yourMail
   sendEmail = sendMail
   appPasswords = appPasswords

   #Jira Credentials
   jiraUrl = jiraUrl
   jiraEmail = jiraEmail
   jiraApiToken = jiraApiToken
   jiraKey = jiraKey
   
