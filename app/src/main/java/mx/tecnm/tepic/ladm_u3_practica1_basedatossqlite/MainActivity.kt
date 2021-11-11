package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.txtPlaca
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity : AppCompatActivity() {

    var lista : ListView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = findViewById(R.id.menuprincipal)
        lista!!.setOnItemClickListener { parent, view, objetoSeleccionado, id ->
            when(objetoSeleccionado){
                0 -> {
                    //1 surf
                    //Main3Activity
                    var activity5 = Intent(this,MainActivity5::class.java)
                    startActivity(activity5)
                }
                1 -> {
                    var activity2 = Intent(this,MainActivity2::class.java)
                    startActivity(activity2)
                }
                2 -> {
                    //3
                    var activity4 = Intent(this,MainActivity4::class.java)
                    startActivity(activity4)
                }
                3 -> {
                    //4
                    //Main4Activity
                    var activity3 = Intent(this,MainActivity3::class.java)
                    startActivity(activity3)
                }

                else -> {
                    //default
                    finish()
                }
            }
        }

    }

}