package br.edu.ifsp.scl.sc3035018.trucoscoreboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3035018.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var teamAPoints: Int = 0
    private var teamBPoints: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with(amb){
            btnAddPointsA.setOnClickListener {
                teamAPoints++
                updateScore()
            }

            btnAddPointsB.setOnClickListener {
                teamBPoints++
                updateScore()
            }

            btnAdd3PointsA.setOnClickListener {
                teamAPoints += 3
                updateScore()
            }

            btnAdd3PointsB.setOnClickListener {
                teamBPoints += 3
                updateScore()
            }

            btnReload.setOnClickListener {
                teamAPoints = 0
                teamBPoints = 0
                updateScore()
            }
        }
    }
    private fun updateScore() {
        with(amb) {
            counterA.text = teamAPoints.toString()
            counterB.text = teamBPoints.toString()

            toast11.text = when {
                teamAPoints == 11 && teamBPoints == 11 -> "Ambas as equipes estão em mão de 11!"
                teamAPoints == 11 -> "Equipe A está em mão de 11!"
                teamBPoints == 11 -> "Equipe B está em mão de 11!"
                else -> ""
            }

            val gameOver = teamAPoints >= 12 || teamBPoints >= 12

            winner.text = when {
                teamAPoints >= 12 -> "Equipe A venceu a partida!"
                teamBPoints >= 12 -> "Equipe B venceu a partida!"
                else -> ""
            }

            btnAddPointsA.isEnabled = !gameOver
            btnAddPointsB.isEnabled = !gameOver
            btnAdd3PointsA.isEnabled = !gameOver
            btnAdd3PointsB.isEnabled = !gameOver
        }
    }
}