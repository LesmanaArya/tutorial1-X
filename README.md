Link deployment Koyeb : https://eshop-offline-universitasindonesia123.koyeb.app/ <br/>
Reflection 1
1. Clean code yang diterapkan di tugas kali ini adalah:
   1. Meaningful Names. Nama-nama package seperti model, controller, dan sebagainya sudah disesuaikan dengan penamaan model MVC Spring Boot sehingga diharapkan lebih terorganisir dengan baik dan mudah dibaca. Nama method sudah dinamai sesuai dengan fungsinya, seperti editProduct berarti untuk meng-edit, deleteProductByName berarti menghapus produk berdasarkan nama, dan seterusnya
   2. Function, function di tugas ini sebisa mungkin hanya melakukan satu hal saja,misalkan method deleteProduct berarti hanya delete saja, addProduct, berarti hanyaadd saja. Masing-masing method juga tidak menimbulkan side effect untuk method lain,misalkan method addProduct tidak akan mempengaruhi deleteProduct karena dia hanya menambahproduct saja dan tidak mengganggu delete, begitupun dengan delete yang hanya menghapus produk saja dan tidak mempengaruhi addProduct
   3. Comment, bagian ini saya rasa masih kurang karena masih sedikitnya komen yang saya tuliskan di kode ini, dan beberapa mungkin terlalu singkat, saya juga masih berusaha untuk memahami prinsip "don't comment bad code"
   4. Object and Data Structure, mayoritas dari variabel implementasi dan atribut dari produk sudah private dan hanya bisa diakses menggunakan getter setter. Struktur data yang digunakan adalah Arraylist yang terbilang mudah untuk dilakukan operasi add, search, dan delete
   5. Error Handling, masih sangat kurang karena belum bisa memvalidasi jumlah barang ketika dimasukkan string atau ketika jumlahnya negatif, dan masih ada method yang menerapkan return null
Untuk secure coding masih banyak yang belum terimplementasi dengan baik, belum ada validasi input
ataupun method autentikasi dan verifikasi seperti login dan pengecekan role. Overall, kode ini
dapat diimprove dengan memaksimalkan kembali yang sudah dipelajari seperti menghandle input,
menghindari return objek null, dan menambahkan method verifikasi. Semoga bisa diimprove di tugas - tugas berikutnya

----
Reflection 2
1. Saya lebih memahami cara membuat unit test dan lebih menyadari manfaatnya yang memudahkan kita untuk mengetes kode kita.
Dalam satu class, berapa banyak unit test yang harus kita buat menurut saya tergantung dari seberapa kompleks
fitur dan method yang terlibat, yang penting pastikan bahwa test kita setidaknya bisa mencakup mayoritas
implementasi kode yang kita buat. Jika test kita sudah mencakup 100% code coverage, maka artinya sebagian besar atau mungkin
hampir pasti sepenuhnya kode kita sudah berjalan dan sudah di-handle kemungkinan errornya, tetapi bisa saja ada sebagian kecil
kemungkinan yang belum ter-handle
2. Menurut saya hal tersebut menurunkan cleanliness dari code kita. Hal tersebut karena untuk menghitung banyaknya
item bisa dilakukan di file createProductFunctional.java, karena class tersebut juga dibuat untuk mengecek apakah
produk yang kita buat berhasil ditambahkan atau tidak di home page, kita langsung tampilkan saja berapa banyak
item yang sudah ada lalu verifikasi dengan unit test kita tanpa perlu buat class baru. Jika buat class baru apalagi setup procedure dan
instance variable nya sama seperti file createProductFunctional.java, saya rasa akan sayang dan malah
menambah sesuatu yang sebenarnya bisa dipermudah
<br />

---
Reflection 3
1. Ada beberapa aspek unit test yang terlewat, yaitu di package Controller mengenai mapping url ke halaman html. Hal ini merupakan hal yang penting
karena memastikan bahwa url yang kita cari itu ada dan halamannya ditampilkan dengan benar. Saya membuat test nya menggunakan mock. Selain itu
membuat unit test tambahan lain yaitu tes executable eshop, dan tes productRepository bagian jika kita menambah produk
dengan nama sama, hal ini bertujuan agar meningkatkan code coverage.
2. Saat saya psuh readme ini, Sonarcloud saya masih gagal. Saya bisa bilang bahwa implementasi saya sekarang
masih kurang karena masih ada workflow yang gagal

---
Reflection 4
1. * SRP. Hal ini diterapkan dengan memisahkan antara CarController dengan ProductController menjadi kelas sendiri-sendiri. Semua yang berhubungan dengan Car tidak akan berpengaruh dan mengakses apa-apa saja yang ada pada Product dan begitupun sebaliknya
   * OCP. Hal ini diterapkan dengan mengorganisir project kita membuat package Repository dan Service. Semua fitur yang ada disana dibuat atau dikembangkan tanpa mengubah source code aslinya. Misalkan kita menerapkan findCarByName pada createCar, kita tinggal panggil saja method findCarByName lalu kembangkan sesuai keinginan kita tanpa perlu merubah code aslinya. Begitupun semua class yang ada di package Service yang isinya hanya memanggil class Repository yang kita inginkan untuk dikembangkan sesuai kebutuhan tetapi tidak merubah isi dari kodingan Repository
   * LSP. Untuk saat ini, belum ada konsep inheritance disini selain dari implementation Interface, sehingga saya belum terpikir implementasi LSP pada kodingan saat ini
   * ISP. Hal ini diterapkan dengan membuat Package Service yang di dalamnya berisi CarServiceImpl dan ProductServiceImpl, artinya Interface dari objek yang ada di project ini sudah di breakdown menjadi jenis class produknya masing-masing. Isi dari tiap class tersebut juga sudah di breakdown menjadi method-method implementasi dari masing-masing method yang ada di ProductRepository dan CarRepository sehingga client dapat memilih method yang hanya dia perlukan
   * DIP. Hal ini diterapkan dengan membuat Interface CarService dan ProductService yang nantinya akan dibuat implementasinya yang ada di package Service, yaitu CarServiceImpl dan ProductServiceImpl. Kedua ServiceImpl itulah yang nantinya akan digunakan untuk mengoperasikan Controller, sehingga kedua class tersebut akan bergantung pada abstraksi dari Interface
2. Penerapan SOLID principles akan mempermudah organisir project kita, terutama kalau projectnya dalam bentuk tim. Setiap bagian tim bekerja sesuai bagiannya masing-masing dan jika Solid Principle diterapkan dengan baik, proses untuk merging atau menggabungkan keseluruhan bagian akan jadi lebih mudah. Misalnya pemisahan antara Controller sesuai dengan url masing-masing bagian, pembuatan seperti package Repository dan Service seperti pada projek ini yang kita dapat mengembangkan penggunaan dari suatu method tanpa perlu merubah source code method aslinya, serta penerapan Interface yang berarti semua bagian bergantung pada class Abstract atau Interface sehingga jika ada perubahan, tidak perlu susah-susah mengurus perubahan superclass nya karena ia bersifat abstract
3. Akan sulit untuk mengorganisir project terutama jika dalam bentuk tim dan memiliki banyak sekali bagian seperti banyak jenis produk, banyak Controller dan method yang harus dibuat, dan sebagainya. Jika tidak diterapkan SOLID principle seperti misalnya semua Controller digabung jadi satu, kita akan mudah lupa bagian Controller yang ini milik siapa dan kegunaannya apa, settingnya seperti apa dan sebagainya. Selain itu, mungkin kodingan kita akan pusing untuk dimengerti oleh orang lain karena tidak terorganisir. Apalagi jika kita sedikit-sedikit merubah source code asli, tentu akan jadi lebih pusing lagi dalam mengorganisirnya

---
1. TDD Flow menurut saya adalah hal yang penting, walau kesannya seperti rumit serta seakan-akan sangat panjang. TDD Flow berguna untuk memperkecil raung untuk mendeteksi error karena kita diharuskan untuk membangun project secara berkala mulai dari model, repository, dan service sehingga jika ada error akan mudah untuk deteksinya dibanding langsung membuat semua. Saya sendiri masih belum begitu terbiasa dengan TDD karena biasanya unit test selalu dibuat di akhir dan setelah semua bagian project selesai
2. Unit test yang dibuat sejauh ini menurut saya sudah memenuhi prinsip SOLID karena menurut saya, pengimplementasian TDD sejatinya merupakan cara untuk menerapkan SOLID Principle di project kita terutama pada bagian happy dan unhappy test
