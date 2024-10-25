package id.ac.polbeng.susisalina.uts_susisalina

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.susisalina.uts_susisalina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            val lengthInput = binding.inputLength.text.toString()
            val widthInput = binding.inputWidth.text.toString()
            val heightInput = binding.inputHeight.text.toString()

            if (lengthInput.isNotEmpty() && widthInput.isNotEmpty() && heightInput.isNotEmpty()) {
                val length = lengthInput.toDoubleOrNull()
                val width = widthInput.toDoubleOrNull()
                val height = heightInput.toDoubleOrNull()

                if (length != null && width != null && height != null) {
                    // Hitung volume dan luas permukaan
                    val volume = length * width * height
                    val area = 2 * (length * width + length * height + width * height)

                    // Tampilkan hasil
                    binding.resultTextView.text = "Volume: $volume, Luas Permukaan: $area"
                } else {
                    Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
