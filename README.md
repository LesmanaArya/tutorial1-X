Reflection 1 <br />
Clean code yang diterapkan di tugas kali ini adalah: <br />
a) Meaningful Names. Nama-nama package seperti model, 
controller, dan sebagainya sudah disesuaikan dengan 
penamaan model MVC Spring Boot sehingga diharapkan 
lebih terorganisir dengan baik dan mudah dibaca. 
Nama method sudah dinamai sesuai dengan fungsinya, 
seperti editProduct berarti untuk meng-edit, 
deleteProductByName berarti menghapus produk berdasarkan nama, dan seterusnya <br />
<br />
b) Function, function di tugas ini sebisa mungkin hanya melakukan satu hal saja,
misalkan method deleteProduct berarti hanya delete saja, addProduct, berarti hanya
add saja. Masing-masing method juga tidak menimbulkan side effect untuk method lain,
misalkan method addProduct tidak akan mempengaruhi deleteProduct karena dia hanya menambah
product saja dan tidak mengganggu delete, begitupun dengan delete yang hanya menghapus produk saja
dan tidak mempengaruhi addProduct
<br />
<br />
c) Comment, bagian ini saya rasa masih kurang karena masih sedikitnya komen yang saya
tuliskan di kode ini, dan beberapa mungkin terlalu singkat, saya juga masih berusaha untuk
memahami prinsip "don't comment bad code"
<br />
<br />
d) Object and Data Structure, mayoritas dari variabel implementasi dan atribut dari produk
sudah private dan hanya bisa diakses menggunakan getter setter. Struktur data yang digunakan
adalah Arraylist yang terbilang mudah untuk dilakukan operasi add, search, dan delete
<br />
<br />
e) Error Handling, masih sangat kurang karena belum bisa memvalidasi jumlah barang ketika dimasukkan string atau ketika jumlahnya negatif,
dan masih ada method yang menerapkan return null
<br />
<br />
Untuk secure coding masih banyak yang belum terimplementasi dengan baik, belum ada validasi input
ataupun method autentikasi dan verifikasi seperti login dan pengecekan role. Overall, kode ini
dapat diimprove dengan memaksimalkan kembali yang sudah dipelajari seperti menghandle input,
menghindari return objek null, dan menambahkan method verifikasi. Semoga bisa diimprove di tugas - tugas berikutnya
<br />

----
Reflection 2 <br />
1. Saya lebih memahami cara membuat unit test dan lebih menyadari manfaatnya yang memudahkan kita untuk mengetes kode kita.
Dalam satu class, berapa banyak unit test yang harus kita buat menurut saya tergantung dari seberapa kompleks
fitur dan method yang terlibat, yang penting pastikan bahwa test kita setidaknya bisa mencakup mayoritas
implementasi kode yang kita buat. Jika test kita sudah mencakup 100% code coverage, maka artinya sebagian besar atau mungkin
hampir pasti sepenuhnya kode kita sudah berjalan dan sudah di-handle kemungkinan errornya, tetapi bisa saja ada sebagian kecil
kemungkinan yang belum ter-handle
<br />
<br />
2. Menurut saya hal tersebut menurunkan cleanliness dari code kita. Hal tersebut karena untuk menghitung banyaknya
item bisa dilakukan di file createProductFunctional.java, karena class tersebut juga dibuat untuk mengecek apakah
produk yang kita buat berhasil ditambahkan atau tidak di home page, kita langsung tampilkan saja berapa banyak
item yang sudah ada lalu verifikasi dengan unit test kita tanpa perlu buat class baru. Jika buat class baru apalagi setup procedure dan
instance variable nya sama seperti file createProductFunctional.java, saya rasa akan sayang dan malah
menambah sesuatu yang sebenarnya bisa dipermudah