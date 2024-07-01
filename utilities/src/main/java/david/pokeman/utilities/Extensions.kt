package david.pokeman.utilities

import android.content.Context
import android.widget.Toast

@JvmName("Extensions")

fun String.getPicUrl(): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.extractId()}.png"

fun String.extractId() = this.substringAfter("pokemon").replace("/", "").toInt()

fun String.toFormattedPrice(): String = "KES $this"

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()