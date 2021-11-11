package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.ContentValues

class CVehiculo(p:MainActivity2) {

    var placa = ""
    var marca = ""
    var modelo = ""
    var anno = ""
    var conductorvehiculo = ""
    val pnt = p

    fun insertarVehiculo():Boolean{

        val tablaVehiculo = BD(pnt, "AGENCIA",null,1).writableDatabase
        val dato = ContentValues()

        dato.put("placa",placa)
        dato.put("marca",marca)
        dato.put("modelo",modelo)
        dato.put("anno",anno)
        dato.put("conductorvehiculo",conductorvehiculo)

        val resultado = tablaVehiculo.insert("VEHICULO",null, dato)
        tablaVehiculo.close()

        if (resultado == -1L){
            return false
        }

        return true
    }
}