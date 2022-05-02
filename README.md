# java-course-day2

Kod från dag 2 i "Utveckling i modern Java"


#### Tider:
8.30-16.30 med en timmes lunch. Dagen delas upp efter kursdeltagarnas önskemål.


### Kursmaterial
Kursmaterialet för denna dagen består av detta git-repo

### Dagens innehåll

Målet med dagen är att bygga en liten mikrotjänst för att spara bilder med hjälp av Dropwizard (https://www.dropwizard.io/en/latest/) och MinIO (https://docs.min.io/docs/minio-quickstart-guide.html, en object storage vars API är kompatibelt med Amazon S3 storage.)

#### Installera lokal MinIO-server

- Ladda ned från följande länk: https://dl.min.io/server/minio/release/windows-amd64/minio.exe
- Lägg till sökvägen till den nedladdade .exe-filen i Path under systemvariabler för att kunna köra programmet oberoende av vilken katalog du står i.
- Gå till den katalog där du vill skapa din bucket (en bucket är en samling objekt som hör ihop) och starta minIO-servern genom att köra ```minio server .```
- Som output tillbaka får du något i stil med :   
  ![MINIO1](minio1.PNG)
- Gå till adressen för Console, i det här fallet http://127.0.0.1:59225 (porten för webbgränssnittet ändras dynamiskt mellan varje gång man startar)
- Välj nu "Create Bucket +" i övre högra hörnet.
- Fyll i ett namn på din bucket, t.ex images
- Om du går tillbaka till filsystemet så ser man nu att det finns en katalog som heter samma sak som den bucket du skapade i steget ovan.

