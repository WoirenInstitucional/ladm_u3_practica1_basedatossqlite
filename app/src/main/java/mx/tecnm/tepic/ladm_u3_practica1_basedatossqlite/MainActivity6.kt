package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity6 : AppCompatActivity() {

    var baseDatos=BD(this,"AGENCIA",null,1)
    var id=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var extra=intent.extras
        id=extra!!.getString("idactualizar")!!

        try {
            var base=baseDatos.readableDatabase
            var respuesta=base.query("VEHICULO", arrayOf("PLACA","MARCA","MODELO","ANNO","CONDUCTORVEHICULO"),"IDVEHICULO=?",
                arrayOf(id),null,null,null,null)
            if(respuesta.moveToFirst()){
                txtPlaca.setText(respuesta.getString(0))
                txtMarca.setText(respuesta.getString(1))
                txtModelo.setText(respuesta.getString(2))
                txtAno.setText(respuesta.getString(3))
                txtidconductor.setText(respuesta.getString(4))
            }else{
                mensaje("ERROR! no se encontro ID")
            }
            base.close()
        }catch (e: SQLiteException){
            mensaje(e.message!!)
        }
        btnregistroVehiculo.setOnClickListener {
            actualizar(id)
        }

    }


    private fun mensaje(s:String){
        AlertDialog.Builder(this)
            .setTitle("ATENCIÓN")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->d.dismiss()}
            .show()
    }

    private fun actualizar (id:String){
        try {

            var trans=baseDatos.writableDatabase
            var valores= ContentValues()

            valores.put("PLACA",txtPlaca.text.toString())
            valores.put("MARCA",txtMarca.text.toString())
            valores.put("MODELO",txtModelo.text.toString())
            valores.put("ANNO",txtAno.text.toString())
            valores.put("CONDUCTORVEHICULO",txtidconductor.text.toString())

            var res=trans.update("VEHICULO",valores,"IDVEHICULO=?", arrayOf(id))

            if(res>0){
                mensaje("Se actualizo correctamente el Vehiculo")
                var itent= Intent(this,MainActivity::class.java)
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