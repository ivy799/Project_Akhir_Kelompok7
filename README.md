# EXSA

EXSA adalah aplikasi yang bertujuan untuk memperkenalkan dan mempromosikan kekayaan budaya serta barang khas dari berbagai daerah di Indonesia. 

## Group Name : HepstarExplorers
Nama Anggota :

1. H071231072 – Ahmad Rafly Putra Hasrun
2. H071231078 – Muhammad Raihan
3. H071231093 – Muh. Tegar Adyaksa

## Tema yang dipilih : Travel and Culture
## Nama Pendamping :  Kak ‘ Abd.Rafiq Anwar
## Tim Juri :

  1.  Kak Mukram
  2.  Kak Djul

## Executive Summary
EXSA adalah aplikasi yang bertujuan untuk memperkenalkan dan mempromosikan kekayaan budaya serta barang khas dari berbagai daerah di Indonesia. 

### 1. Latar Belakang
Kurangnya informasi yang sering dialami oleh wisatawan saat mengunjungi daerah baru menjadi masalah yang perlu diatasi. Hal ini dapat menghambat wisatawan dalam mengeksplorasi dan memahami lebih dalam tentang kekayaan budaya serta barang khas darisuatu daerah di Indonesia.


### 2. Masalah yang diatasi
1. Kurangnya Informasi : 
    Banyak wisatawan asing kesulitan dalam mendapatkan informasi yang tepat dan akurat mengenai tempat wisata, dll sehinng sulit untuk mengekplore indonesia. Informasi yang tersedia sering kali tersebar di berbagai sumber yang tidak terstruktur, atau tidak tersedia dalam bahasa yang mudah dipahami oleh wisatawan. Hal ini menyebabkan ketidakmampuan wisatawan untuk merencanakan perjalanan mereka dengan baik, sehingga mereka mungkin melewatkan pengalaman-pengalaman penting atau menghadapi kesulitan selama perjalanan.


2. Keterbatasan Bahasa : 
    Indonesia adalah negara dengan bahasa yang beragam, dan Bahasa Indonesia menjadi bahasa resmi yang digunakan secara luas. Namun, banyak wisatawan asing yang tidak fasih berbahasa Indonesia, sehingga mereka kesulitan untuk berkomunikasi dengan penduduk lokal, memahami petunjuk atau informasi yang disediakan dalam bahasa Indonesia, dan berinteraksi dengan layanan publik. Keterbatasan ini seringkali menghambat wisatawan dalam mengeksplorasi dan menikmati pengalaman mereka di Indonesia.



3. Kurangnya Pemahaman Tradisi Lokal : 
    Indonesia memiliki tradisi dan budaya yang sangat beragam, yang menjadi daya tarik tersendiri bagi wisatawan. Namun, banyak wisatawan asing yang tidak memiliki pemahaman yang cukup tentang tradisi lokal, sehingga mereka mungkin melakukan tindakan yang dianggap tidak sopan atau tidak menghargai budaya setempat. Kurangnya pemahaman ini tidak hanya mengurangi kualitas pengalaman wisatawan, tetapi juga bisa menimbulkan ketegangan antara wisatawan dan penduduk lokal.


### 3. Alasan Pemilihan Projek ini
Alasan kami memilih project ini adalah karena Indonesia memiliki potensi besar dalam hal pariwisata budaya dan ekonomi kreatif. Aplikasi ini dapat membantu membuka peluang baru bagi wisatawan dan pelaku usaha lokal dan Kurangnya informasi yang mudah diakses tentang budaya dan barang khas Indonesia merupakan masalah yang nyata yang dihadapi oleh wisatawan. Aplikasi ini hadir untuk menjawab kebutuhan tersebut

## Fitur Aplikasi
A. General
  1. *Login User*
  2. *Register User*
  3. *Logout User*
  4. *Search Bar*

B. User
  1. Memiliki daftar kota 
  2. Memiliki daftar kota yang direkomendasikan dengan gambar
  3. Memiliki fitur untuk menampilkan informasi seputar sejarah,budaya, tradisi, dan kuliner dari kota yg dipilih
  4. Menampilkan Daftar tempat wisata populer / menarik yang di suatu kota serta detailnya
  5. Menampilkan Daftar UMKM yang direkomendasikan di suatu kota serta detailnya
  6. Memiliki fitur untuk mengubah data akun pengguna
  7. Memiliki fitur untuk berpindah scene dengan tombol navigasi

## Penjelasan Penerapan Prinsip OOP
1. Pada loginScene.java, terdapat class loginScene yang mewarisi class SceneUtil,dan mengimplementasikan method show dari interface Show. Selain itu, semua variabel bertipe private. (Inheritance, Abstraction, Encapsulation, dan Polimorfisme)
    ● Inheritance: loginScene mewarisi SceneUtil.
    ● Abstraction: Mengimplementasikan method abstract show dari interface Show.
    ● Encapsulation: Semua variabel dalam loginScene bertipe private.
    ● Polimorfisme: Membuat implementasi berbeda untuk method abstract show dari interface Show.


2. Pada scene2.java, terdapat class scene2 yang mewarisi class SceneUtil, dan mengimplementasikan method show dari interface Show. Selain itu, semua variabel bertipe private. (Inheritance, Abstraction, Encapsulation, dan Polimorfisme)
    ● Inheritance: scene2 mewarisi SceneUtil.
    ● Abstraction: Mengimplementasikan method show dari interface Show.
    ● Encapsulation: Semua variabel dalam scene2 bertipe private.
    ● Polimorfisme: Membuat implementasi berbeda untuk method abstract show dari interface Show.


3. Pada scene3.java, terdapat class scene3 yang mewarisi class SceneUtil, dan mengimplementasikan method show dari interface Show. Selain itu, semua variabel bertipe private. (Inheritance, Abstraction, Encapsulation, dan Polimorfisme).
    ● Inheritance: scene3 mewarisi SceneUtil.
    ● Abstraction: Mengimplementasikan method show dari interface Show.
    ● Encapsulation: Semua variabel dalam scene3 bertipe private.
    ● Polimorfisme: Membuat implementasi berbeda untuk method abstract show dari interface Show.


4. Pada scene4A.java, terdapat class scene4A yang mewarisi class scene3. Semua variabel dalam scene4A bertipe private, dan menggunakan method show. (Inheritance,Encapsulation, dan Polimorfisme)
    ● Inheritance: scene4A mewarisi scene3.
    ● Encapsulation: Semua variabel dalam scene4A bertipe private.
    ● Polimorfisme: Menggunakan method show dari class scene3.


5. Pada profile.java, terdapat class profile yang mewarisi class sceneUtil. Semua variabel dalam class profile bertipe private, dan menggunakan method show. (Inheritance, Encapsulation, dan Polimorfisme)
    ● Inheritance: scene profile mewarisi sceneUtil.
    ● Encapsulation: Semua variabel dalam sceneProfile bertipe private.
    ● Polimorfisme: Membuat implementasi berbeda method abstract show dari interface Show.

6. Pada DataKotaController.java, terdapat class DataKotaController yang mewarisi class DBconfig. (Inheritance)Inheritance: DataKotaController mewarisi DBconfig.

7. Pada UserDataController.java, terdapat class UserDataController yang mewarisi class DBconfig. (Inheritance)Inheritance: UserDataController mewarisi DBconfig.

## Mentoring
- Abd.Rafiq Anwar - 16.20 – 17.30 wita 16/05/2024
- Abd.Rafiq Anwar - 16.30– 17.30 wita 22/05/2024
- Abd.Rafiq Anwar - 14.30 – 17.30 wita 29/05/2024
- Abd.Rafiq Anwar - 16.25 – 20.30 wita 30/05/2024
- Abd.Rafiq Anwar - 15.30 – 16.00 wita 31/05/2024

## Link Repository GitHub
[https://github.com/ivy799/Project_Akhir_Kelompok7](https://github.com/ivy799/Project_Akhir_Kelompok7)

## Screenshots
### *Login Scene*
![Login Scene](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/login.png)

### *Register Scene*
![Register Scene](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/register.png)

### *Home Scene*
![Home Scene](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/home.png)

### *Profile Scene*
![Profile Scene](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/profil.png)

### *Detail Kota*
![Detail Kota](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/scene1.png)

### *Detail Wisata*
![Detail Wisata](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/scene2A.png)

### *Detail UMKM*
![Detail UMKM](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/scene2B.png)

## Pengujian Pada Aplikasi
![Table1](https://github.com/ivy799/Project_Akhir_Kelompok7/blob/main/readme/table.jpg)

