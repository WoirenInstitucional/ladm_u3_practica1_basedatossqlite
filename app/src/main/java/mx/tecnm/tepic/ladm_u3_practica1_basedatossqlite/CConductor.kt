package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.ContentValues

class CConductor(p:MainActivity5) {

    val pnt = p
    var nombre = ""
    var domicilio = ""
    var nolicencia = ""
    var vence = ""

    fun insertarConductor():Boolean{

        val tabla = BD(pnt, "AGENCIA",null,1).writableDatabase
        val dato = ContentValues()

        dato.put("nombre",nombre)
        dato.put("domicilio",domicilio)
        dato.put("nolicencia",nolicencia)
        dato.put("vence",vence)

        val resultado = tabla.insert("CONDUCTOR",null, dato)
        tabla.close()
        if (resultado == -1L){
            return false
        }

        return true
    }
}