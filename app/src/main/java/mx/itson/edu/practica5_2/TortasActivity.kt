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

class TortasActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tortas)

        agregarProductos()

        var listview: ListView = findViewById(R.id.litview) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }

    fun agregarProductos() {
        menu.add(
            Product(
                "Torta Regular",
                R.drawable.torta,
                "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat. \u200B",
                11.99
            )
        )
        menu.add(
            Product(
                "Torta - Milanesa de Res o Pollo",
                R.drawable.tortamilanesa,
                "Breaded Steak or Chicken",
                12.99
            )
        )
        menu.add(
            Product(
                "Torta Cubana",
                R.drawable.tortacubana,
                "Chorizo, asada, jamon, pastor y queso Mexican sausage, steak, marinated pork, ham, and cheese\n" +
                        "\n",
                13.59
            )
        )
        menu.add(
            Product(
                "Torta Mixta",
                R.drawable.tortamixta,
                "Chorizo, asada y pastor./ Mexican sausage, steak and marinated pork.",
                12.99
            )
        )
        menu.add(
            Product(
                "Small Mexican Torta",
                R.drawable.smallmexican,
                "Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.\n" +
                        "\n",
                12.99
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