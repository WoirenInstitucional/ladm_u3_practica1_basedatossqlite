package mx.tecnm.tepic.ladm_u3_practica1_basedatossqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    var idSeleccionadoEnLista=-1
    var listaID=ArrayList<String>()
    val arreglo = RDConductor(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)



        btnBuscarConductor.setOnClickListener {

        listConductor.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo.consultar())
        this.registerForContextMenu(listConductor)
        }

        listConductor.setOnItemClickListener { adapterView, view, i, l ->  idSeleccionadoEnLista=i
            Toast.makeText(this,"Se selecciono el elemento "+idSeleccionadoEnLista, Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflaterOB=menuInflater
        //cargar  un XML y CONSTRUIR un objeto Kotlin a partir de esa carga= INFLATE
        inflaterOB.inflate(R.menu.menuopc,menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if(idSeleccionadoEnLista==-1){
            mensaje("Error! Debes dar click primero en un item pra actualizar o borrar")
            return true
        }

        when(item.itemId){
            R.id.itemactualizar->{

                Toast.makeText(this,arreglo.listaID.get(idSeleccionadoEnLista),Toast.LENGTH_LONG)

                var itent= Intent(this,MainActivity7::class.java)

                itent.putExtra("idactualizar",arreglo.listaID.get(idSeleccionadoEnLista))
                itent.putExtra("ct",Bundle.CREATOR.javaClass)
                startActivity(itent)
                finish()
            }
            R.id.itemeliminar->{
                var idEliminar=arreglo.listaID.get(idSeleccionadoEnLista)
                AlertDialog.Builder(this)
                    .setTitle("ATENCIÓN")
                    .setMessage("ESTAS SEGURO QUE DESEA ELIMINAR EL ID: "+idEliminar+"?")
                    .setPositiveButton("ELIMINAR"){d,i->arreglo.eliminar(idEliminar)
                        listConductor.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo.consultar())
                    }
                    .setNeutralButton("NO"){d,i->}
                    .show()
            }
            R.id.itemsalir->{

            }
        }
        idSeleccionadoEnLista=-1
        return true

    }

    private fun mensaje(s:String){
        AlertDialog.Builder(this)
            .setTitle("ATENCIÓN")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->d.dismiss()}
            .show()
    }

}