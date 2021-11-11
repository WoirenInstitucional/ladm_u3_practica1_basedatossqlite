package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        btnregistroVehiculo.setOnClickListener{

            val CV = CVehiculo(this)

            CV.placa=txtPlaca.text.toString()
            CV.marca=txtMarca.text.toString()
            CV.modelo=txtModelo.text.toString()
            CV.anno=txtAno.text.toString()
            CV.conductorvehiculo=txtidconductor.text.toString()

            val res = CV.insertarVehiculo()

            if (res){
                Toast.makeText(this,"Se capturaron los datos del vehiculo exitosamente", Toast.LENGTH_LONG).show()
                txtPlaca.setText("")
                txtMarca.setText("")
                txtModelo.setText("")
                txtAno.setText("")
                txtidconductor.setText("")
            }else{
                Toast.makeText(this,"Error, no se pudieron guardar los datos", Toast.LENGTH_LONG).show()
            }

        }


    }

}