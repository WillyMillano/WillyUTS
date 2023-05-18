package com.example.willyuts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.willyuts.Komik
import com.example.willyuts.R
import com.example.willyuts.detailKomikActivity
import com.example.willyuts.komikAdapter

class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, detailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,

            )

        image = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
        )

        title = arrayOf(
            "Earvin ",
            "Ivan",
            "Kurek",
            "leon",
            "nishida",
            "facundo",
            "Ricardo",
            "Rivan",
            "Maxholt",
            "Drimity",
        )

        description = arrayOf(
            "pemain bola voli Prancis, anggota tim bola voli nasional Prancis dan klub Italia Modena Volley, ",
            "pemain bola voli Italia asal Rusia, kapten tim bola voli nasional pria Italia",
            "pemain bola voli profesional asal Polandia. Dia adalah anggota tim nasional Polandia, ",
            "pemain bola voli profesional Kuba-Polandia. Dia adalah anggota tim nasional Kuba ",
            "pemain bola voli kidal Jepang. Saat ini, ia bermain untuk JTEKT Stings di V.League Division 1. ",
            "pemain bola voli profesional Argentina. Dia adalah anggota tim nasional Argentina d",
            "pemain bola voli profesional Brasil. Ia merupakan anggota timnas Brasil, Juara Olimpiade 2016",
            "pemain bola voli putra Indonesia. Ia merupakan pevoli pertama yang berkarir di liga Jepang,",
            "pemain bola voli profesional Amerika. Dia adalah anggota tim nasional AS, dan peraih medali perunggu di Olimpiade Rio 2016. ",
            "pemain bola voli Rusia keturunan Ukraina, anggota tim nasional Rusia dan klub Jepang",


            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}