package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AlertDialog

class RDConductor(p:MainActivity4) {

    val pnt = p

    var listaID=ArrayList<String>()

    fun consultar(): ArrayList<String>{

        val tabla = BD(pnt,"AGENCIA",null,1).readableDatabase

        val resConsulta = ArrayList<String>()

        val cursor = tabla.query("CONDUCTOR", arrayOf("*"),null,null,null,null,null)

        listaID.clear()

        if (cursor.moveToFirst()){
            //por lo menos hay 1 resultado
            var dato = ""
            do{
                var dato = cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)

                listaID.add(cursor.getInt(0).toString())

                resConsulta.add(dato)
            }while(cursor.moveToNext())
        }else{
            //no hay resultado de la consulta
            resConsulta.add("No hay datos en la BD")
        }

        tabla.close()
        return resConsulta

    }

    fun consultarxID(nombre: String): ArrayList<String>{

        val tabla = BD(pnt,"AGENCIA",null,1).readableDatabase

        val resConsulta = ArrayList<String>()

        val cursor = tabla.query("CONDUCTOR", arrayOf("*"),"NOMBRE=?",null,null,null,null)


        listaID.clear()

        if (cursor.moveToFirst()){
            //por lo menos hay 1 resultado
            var dato = ""
            do{
                var dato = cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)

                listaID.add(cursor.getInt(0).toString())

                resConsulta.add(dato)
            }while(cursor.moveToNext())
        }else{
            //no hay resultado de la consulta
            resConsulta.add("No hay datos en la BD")
        }

        tabla.close()
        return resConsulta

    }


    fun eliminar(idEliminar:String):Boolean{
        val tabla = BD(pnt,"AGENCIA",null,1)
        try {
            var trans=tabla.writableDatabase
            var resultado=trans.delete("CONDUCTOR","IDCONDUCTOR=?",
                arrayOf(idEliminar))
            trans.close()
            return resultado != 0

        }catch (e: SQLiteException){
            mensaje(e.message!!)
        }
        return false
    }

    private fun mensaje(s:String){
        AlertDialog.Builder(pnt)
            .setTitle("ATENCIÓN")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->d.dismiss()}
            .show()
    }

}