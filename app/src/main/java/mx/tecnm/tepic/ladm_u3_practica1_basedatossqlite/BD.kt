package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BD (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(p: SQLiteDatabase) {
            //Se ejecuta cuando se instala la app en el cel y lo corre por 1era vez
            //En kotlin puedes hacer el CRUD de 2 maneras diferentes:
            //  1.-Tradicional: con instrucciones SQL (insert into, update, delete from, select from)
            //  2.-Metodos: la POD que maneja métodos que ejecutan instrucciones SQL

            p.execSQL("CREATE TABLE CONDUCTOR (IDCONDUCTOR INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,NOMBRE VARCHAR(200),DOMICILIO VARCHAR(200), NOLICENCIA VARCHAR(200),VENCE VARCHAR(200))")

            p.execSQL("CREATE TABLE VEHICULO (IDVEHICULO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,PLACA VARCHAR(200),MARCA VARCHAR(200),MODELO VARCHAR(200),ANNO VARCHAR(200),CONDUCTORVEHICULO INTEGER,FOREIGN KEY(CONDUCTORVEHICULO) REFERENCES CONDUCTOR(IDCONDUCTOR))")


        }

        override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
            //Se ejecuta cuando hay un cambio de version
        }
    }