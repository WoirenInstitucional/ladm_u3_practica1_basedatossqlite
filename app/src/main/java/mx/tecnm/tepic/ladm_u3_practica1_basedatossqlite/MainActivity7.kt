package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity7 : AppCompatActivity() {

    var baseDatos=BD(this,"AGENCIA",null,1)
    var id=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        var extra=intent.extras
        id=extra!!.getString("idactualizar")!!

        try {
            var base=baseDatos.readableDatabase
            var respuesta=base.query("CONDUCTOR", arrayOf("NOMBRE","DOMICILIO","NOLICENCIA","VENCE"),"IDCONDUCTOR=?",
                arrayOf(id),null,null,null,null)
            if(respuesta.moveToFirst()){
                txtNombre.setText(respuesta.getString(0))
                txtDomicilio.setText(respuesta.getString(1))
                txtNoLicencia.setText(respuesta.getString(2))
                txtVence.setText(respuesta.getString(3))
            }else{
                mensaje("ERROR! no se encontro ID")
            }
            base.close()
        }catch (e: SQLiteException){
            mensaje(e.message!!)
        }

        btnregistroConductor.setOnClickListener {
            actualizar(id)
        }
    }


    fun mensaje(s:String){
        AlertDialog.Builder(this)
            .setTitle("ATENCIÓN")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->d.dismiss()}
            .show()
    }

    fun actualizar (id:String){
        try {

            var trans=baseDatos.writableDatabase
            var valores= ContentValues()

            valores.put("NOMBRE",txtNombre.text.toString())
            valores.put("DOMICILIO",txtDomicilio.text.toString())
            valores.put("NOLICENCIA",txtNoLicencia.text.toString())
            valores.put("VENCE",txtVence.text.toString())

            var res=trans.update("CONDUCTOR",valores,"IDCONDUCTOR=?", arrayOf(id))

            if(res>0){
                mensaje("Se actualizo correctamente el Conductor")
                var itent= Intent(this,MainActivity3::class.java)
                startActivity(itent)
                finish()
            }else{
                mensaje("No se pudo actualizar")
            }

        }catch (e:SQLiteException){
            mensaje(e.message!!)
        }

    }

}