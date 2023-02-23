package mx.itson.edu.practica5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnAntojitos: Button = findViewById(R.id.btn_antojitos)
        var btnEspecialidades: Button = findViewById(R.id.btn_especialidades)
        var btnCombinaciones: Button = findViewById(R.id.btn_combinaciones)
        var btnTortas: Button = findViewById(R.id.btn_tortas)
        var btnSopas: Button = findViewById(R.id.btn_sopas)
        var btnDrinks: Button = findViewById(R.id.btn_drinks)

        btnAntojitos.setOnClickListener{
            var intent: Intent = Intent(this,ProductosActivity::class.java)
            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener{
            var intent: Intent = Intent(this, EspecialidadesActivity::class.java)
            startActivity(intent)
        }

        btnCombinaciones.setOnClickListener{
            var intent: Intent = Intent(this, CombinacionesActivity::class.java)
            startActivity(intent)
        }

        btnTortas.setOnClickListener{
            var intent: Intent = Intent(this, TortasActivity::class.java)
            startActivity(intent)
        }

        btnSopas.setOnClickListener{
            var intent: Intent = Intent(this, SopasActivity::class.java)
            startActivity(intent)
        }

        btnDrinks.setOnClickListener{
            var intent: Intent = Intent(this, DrinksActivity::class.java)
            startActivity(intent)
        }
    }
}