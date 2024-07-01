package david.pokeman.oldmutual.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import david.pokeman.oldmutual.ui.theme.Purple80

@Composable
fun TextWithShadow(value: String) {
	val colorOffset = Offset(1f, 2f)
	Text(
		text = value,
		fontSize = 24.sp,
		fontWeight = FontWeight.Medium,
		style = TextStyle(shadow = Shadow(color = Purple80, offset = colorOffset, blurRadius = 2f))
	)
}