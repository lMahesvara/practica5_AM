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

class DrinksActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)

        agregarProductos()

        var listview: ListView = findViewById(R.id.litview) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }

    fun agregarProductos() {
        menu.add(
            Product(
                "Sodas 20oz.",
                R.drawable.sodas,
                "",
                2.99
            )
        )
        menu.add(
            Product(
                "Jarritos",
                R.drawable.jarritos,
                "",
                2.35
            )
        )
        menu.add(
            Product(
                "Aguas Frescas",
                R.drawable.jarritos,
                "",
                2.99
            )
        )
        menu.add(
            Product(
                "Domestic Beer",
                R.drawable.domesticbeer,
                "",
                3.55
            )
        )
        menu.add(
            Product(
                "Mexican Beer",
                R.drawable.mexicanbeer,
                "",
                3.99
            )
        )
        menu.add(
            Product(
                "Micheladas",
                R.drawable.michelada,
                "",
                6.75
            )
        )
        menu.add(
            Product(
                "Caguama",
                R.drawable.caguama,
                "",
                8.99
            )
        )
        menu.add(
            Product(
                "Caguama Michelada",
                R.drawable.caguamamichelada,
                "",
                10.99
            )
        )
        menu.add(
            Product(
                "Cubetazos",
                R.drawable.cubetazo,
                "",
                21.99
            )
        )
        menu.add(
            Product(
                "Lata Beer",
                R.drawable.domesticbeer,
                "",
                2.99
            )
        )
        menu.add(
            Product(
                "Charolazo",
                R.drawable.charolazo,
                "",
                15.75
            )
        )
        menu.add(
            Product(
                "Charolazo con Camarones",
                R.drawable.charolazo,
                "",
                21.99
            )
        )
        menu.add(
            Product(
                "La mamalona",
                R.drawable.caguamamichelada,
                "(Micheada 2 cervezas)",
                12.99
            )
        )
        menu.add(
            Product(
                "La mamalona con camarones",
                R.drawable.caguamamichelada,
                "",
                14.99
            )
        )
        menu.add(
            Product(
                "Cubetazo (6 cervezas)",
                R.drawable.cubetazo,
                "",
                21.99
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