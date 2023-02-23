package mx.itson.edu.practica5_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class SopasActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sopas)

        agregarProductos()

        var listview: ListView = findViewById(R.id.litview) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }

    fun agregarProductos() {
        menu.add(
            Product(
                "Pozole",
                R.drawable.pozole,
                "Weekends only",
                5.99
            )
        )
        menu.add(
            Product(
                "Menudo",
                R.drawable.menudo,
                "Wednesday to Sunday",
                5.99
            )
        )
        menu.add(
            Product(
                "Caldo de Res",
                R.drawable.caldores,
                "",
                5.99
            )
        )
        menu.add(
            Product(
                "Caldo de Camaron",
                R.drawable.caldocamaron,
                "Shrimp soup",
                12.99
            )
        )
        menu.add(
            Product(
                "Sopa de mariscos",
                R.drawable.caldocamaron,
                "Seafood soup",
                12.99
            )
        )
        menu.add(
            Product(
                "Coctel de camaron",
                R.drawable.caldocamaron,
                "Shrimp cocktail",
                14.99
            )
        )

    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, producto: ArrayList<Product>) {
            this.productos = producto
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.product_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}