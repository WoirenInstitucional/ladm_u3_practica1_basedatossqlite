package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        btnregistroConductor.setOnClickListener {
            val CC = CConductor(this)

            CC.nombre=txtNombre.text.toString()
            CC.domicilio=txtDomicilio.text.toString()
            CC.nolicencia=txtNoLicencia.text.toString()
            CC.vence=txtVence.text.toString()

            val res = CC.insertarConductor()

            if (res){
                Toast.makeText(this,"Se capturaron los datos del conductor exitosamente", Toast.LENGTH_LONG).show()
                txtNombre.setText("")
                txtDomicilio.setText("")
                txtNoLicencia.setText("")
                txtVence.setText("")
            }else{
                Toast.makeText(this,"Error, no se pudieron guardar los datos", Toast.LENGTH_LONG).show()
            }
        }
    }
}