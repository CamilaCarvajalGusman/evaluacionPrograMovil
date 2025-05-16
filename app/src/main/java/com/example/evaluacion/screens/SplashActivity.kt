
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.evaluacion.navigation.AppNavigation
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val viewModel: RecordatorioViewModel = viewModel()
            AppNavigation(navController, viewModel)
        }
    }
}

@Composable
fun SplashScreenContent(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate("registro") {
            popUpTo("inicio") { inclusive = true }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(10.dp),
        contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "RecordatoriosApp",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Camila Adriana Carvajal Gusman",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Recuperatorio de Programación de Dispositivos Móviles",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}