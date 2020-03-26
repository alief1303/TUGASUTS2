package com.example.tugasuts

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakultasData()
        fakultasParts.layoutManager = LinearLayoutManager(this)
        fakultasParts.setHasFixedSize(true)
        fakultasParts.adapter = FakultasAdapter(testData, { fakultasItem: FakultasData -> fakultasItemClicked(fakultasItem)})
    }

    private fun fakultasItemClicked(fakultasItem: FakultasData) {
        val showDetailActivityIntent = Intent(this, FakultasDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, fakultasItem.namaFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, fakultasItem.deskripsiFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, fakultasItem.listProdi.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.fotoFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL,fakultasItem.email)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI,fakultasItem.web)
        startActivity(showDetailActivityIntent)
    }

    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("Fakultas Ilmu Komputer", "1. Sistem Informasi\n2. Teknik Informatika", "Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n ", R.drawable.fik, "upnjatim@upnjatim.ac.id",  "https://fik.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Teknik\n", "1. Teknik Kimia\n2. Teknik Industri\n3. Teknik Pangan\n4. Teknik Lingkungan\n5. Teknik Sipil", "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN", R.drawable.ft, "upnjatim@upnjatim.ac.id", "http://ft.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Ekonomi dan Bisnis\n", "1. Ekonomi Pembangunan\n2. Manajemen\n3. Akuntansi", "Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN", R.drawable.feb, "upnjatim@upnjatim.ac.id", "http://febis.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Pertanian\n", "1. Agroteknologi\n2. Agribisnis", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN", R.drawable.pertanian,"upnjatim@upnjatim.ac.id","http://faperta.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Hukum \n", "1. Ilmu Hukum\n", "Fakultas Hukum merupakan salah satu dari 7 Fakultas di UPN", R.drawable.fh,"upnjatim@upnjatim.ac.id", "http://fhukum.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Arsitektur dan Desain \n", "1. Arsitektur\n2.Desain Komnikasi Visual", "Fakultas Arsitek dan Desain merupakan salah satu dari 7 Fakultas di UPN", R.drawable.fad, "upnjatim@upnjatim.ac.id", "http://fad.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Ilmu Sosial dan Politik\n", "1. Administrasi Negara\n2. Administrasi Niaga\n3.Hubungan Internasional\n4.Ilmu Komunikasi", "Fakultas Ilmu Sosial dan Politik merupakan salah satu dari 7 Fakultas di UPN", R.drawable.fisip, "upnjatim@upnjatim.ac.id", "http://fisip.upnjatim.ac.id/"))
        partList.add(FakultasData("Muhammad Dian Nur Alief\n", "1. Tempat, Tanggal Lahir: Denpasar, 13 Maret 2000\n2. Alamat: perum.Gria UmaSari No.10\n3. No.HP: 081329549737\n4. Email: alieflalala21@gmail.com\n5. Url Github: https://github.com/alief1303\n6. Riwayat Pendidikan: \n\t SD: MI Al-Ma'ruf\n\t SMP: SMP Al-Firdaus Boarding School \n\t SMA: MBI Amanatul Ummah\n7. Penghargaan: - ", "", R.drawable.w,"muh.alief1303@gmail.com",""))
        return partList

    }
}

