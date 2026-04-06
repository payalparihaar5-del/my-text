package com.example.mytext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FontPreviewScreen()
                }
            }
        }
    }
}

@Composable
fun FontPreviewScreen() {
    var titleText by remember { mutableStateOf("") }

    val fontList = listOf(
        Pair("Default", FontFamily.Default),
        Pair("Serif", FontFamily.Serif),
        Pair("Cursive", FontFamily.Cursive),
        Pair("Default", FontFamily.Default),
    Pair("Monospace", FontFamily.Monospace),
    Pair("Aca Flft", FontFamily(Font(R.font.aca_flft))),
    Pair("Acha Fout", FontFamily(Font(R.font.acha_fout))),
    Pair("Acha Fsex", FontFamily(Font(R.font.acha_fsex))),
    Pair("Adrip One", FontFamily(Font(R.font.adrip_one))),
    Pair("Adventure Cutline", FontFamily(Font(R.font.adventure_cutline))),
    Pair("Adventure One", FontFamily(Font(R.font.adventure_one))),
    Pair("Albam One", FontFamily(Font(R.font.albam_one))),
    Pair("Albam Three", FontFamily(Font(R.font.albam_three))),
    Pair("Albam Two", FontFamily(Font(R.font.albam_two))),
    Pair("Always Optimistic", FontFamily(Font(R.font.always_optimistic))),
    Pair("Beautiful One", FontFamily(Font(R.font.beautiful_one))),
    Pair("Bebas Neue Regular", FontFamily(Font(R.font.bebas_neue_regular))),
    Pair("Blaize One", FontFamily(Font(R.font.blaize_one))),
    Pair("Blazed Pp", FontFamily(Font(R.font.blazed_pp))),
    Pair("Bloodl Ustrotal", FontFamily(Font(R.font.bloodl_ustrotal))),
    Pair("Bloodlust", FontFamily(Font(R.font.bloodlust))),
    Pair("Bloodlustacadital", FontFamily(Font(R.font.bloodlustacadital))),
    Pair("Bloodlustgradital", FontFamily(Font(R.font.bloodlustgradital))),
    Pair("Bloodlustital", FontFamily(Font(R.font.bloodlustital))),
    Pair("Bloodlustoutital", FontFamily(Font(R.font.bloodlustoutital))),
    Pair("Broadcast Titling", FontFamily(Font(R.font.broadcast_titling))),
    Pair("Cabin Condensed Bold", FontFamily(Font(R.font.cabin_condensed_bold))),
    Pair("Cabin Condensed Medium", FontFamily(Font(R.font.cabin_condensed_medium))),
    Pair("Cabin Condensed Regular", FontFamily(Font(R.font.cabin_condensed_regular))),
    Pair("Cabin Condensed Semibold", FontFamily(Font(R.font.cabin_condensed_semibold))),
    Pair("Calligraphy Flf", FontFamily(Font(R.font.calligraphy_flf))),
    Pair("Calvino Bold Italic", FontFamily(Font(R.font.calvino_bold_italic_trial))),
    Pair("Calvino Bold", FontFamily(Font(R.font.calvino_bold_trial))),
    Pair("Calvino Book Italic", FontFamily(Font(R.font.calvino_book_italic_trial))),
    Pair("Calvino Book", FontFamily(Font(R.font.calvino_book_trial))),
    Pair("Calvino Extra Bold", FontFamily(Font(R.font.calvino_extra_bold_trial))),
    Pair("Calvino Grande Extralight Italic", FontFamily(Font(R.font.calvino_grande_extralight_italic_trial))),
    Pair("Calvino Grande Extralight", FontFamily(Font(R.font.calvino_grande_extralight_trial))),
    Pair("Calvino Grande Light", FontFamily(Font(R.font.calvino_grande_light_trial))),
    Pair("Calvino Light Italic", FontFamily(Font(R.font.calvino_light_italic_trial))),
    Pair("Calvino Regular", FontFamily(Font(R.font.calvino_regular_trial))),
    Pair("Calvino Semibold Italic", FontFamily(Font(R.font.calvino_semibold_italic_trial))),
    Pair("Calvino Thin Italic", FontFamily(Font(R.font.calvino_thin_italic_trial))),
    Pair("Calvino Thin", FontFamily(Font(R.font.calvino_thin_trial))),
    Pair("Dancing Script", FontFamily(Font(R.font.dancing_script_variable_font_wght))),
    Pair("Eat At Joes", FontFamily(Font(R.font.eat_at_joes))),
    Pair("Fade To Grey", FontFamily(Font(R.font.fade_to_grey))),
    Pair("Flames One", FontFamily(Font(R.font.flames_one))),
    Pair("Goldman Bold", FontFamily(Font(R.font.goldman_bold))),
    Pair("Goldman Regular", FontFamily(Font(R.font.goldman_regular))),
    Pair("Guewara One", FontFamily(Font(R.font.guewara_one))),
    Pair("Lato Black", FontFamily(Font(R.font.lato_black))),
    Pair("Lato Bold", FontFamily(Font(R.font.lato_bold))),
    Pair("Lato Bold Italil", FontFamily(Font(R.font.lato_bold_italil))),
    Pair("Lato Italic", FontFamily(Font(R.font.lato_italic))),
    Pair("Lato Light", FontFamily(Font(R.font.lato_light))),
    Pair("Lato Light Italic", FontFamily(Font(R.font.lato_light_italic))),
    Pair("Lato Regular", FontFamily(Font(R.font.lato_regular))),
    Pair("Lato Thin", FontFamily(Font(R.font.lato_thin))),
    Pair("Lato Thin Italic", FontFamily(Font(R.font.lato_thin_italic))),
    Pair("Lieselotte", FontFamily(Font(R.font.lieselotte_personal_use))),
    Pair("Marlboro One", FontFamily(Font(R.font.marlboro_one))),
    Pair("Monoton Regular", FontFamily(Font(R.font.monoton_regular))),
    Pair("Montserrat Bold", FontFamily(Font(R.font.montserrat_bold))),
    Pair("Montserrat Regular", FontFamily(Font(R.font.montserrat_regular))),
    Pair("Moria Cabin Regular", FontFamily(Font(R.font.moria_cabin_demo_regular))),
    Pair("Mrsmonster 3D Ital", FontFamily(Font(R.font.mrsmonster3dital))),
    Pair("Mrsmonster Acad", FontFamily(Font(R.font.mrsmonsteracad))),
    Pair("Mrsmonster Bold Out", FontFamily(Font(R.font.mrsmonsterboldout))),
    Pair("Mrsmonster Bold Out Ital", FontFamily(Font(R.font.mrsmonsterboldoutital))),
    Pair("Mrsmonster Cond", FontFamily(Font(R.font.mrsmonstercond))),
    Pair("Mrsmonster Cond Ital", FontFamily(Font(R.font.mrsmonstercondital))),
    Pair("Mrsmonster Expand", FontFamily(Font(R.font.mrsmonsterexpand))),
    Pair("Mrsmonster Expand Ital", FontFamily(Font(R.font.mrsmonsterexpandital))),
    Pair("Mrsmonster Ital", FontFamily(Font(R.font.mrsmonsterital))),
    Pair("Mrsmonster Left", FontFamily(Font(R.font.mrsmonsterleft))),
    Pair("Mrsmonster Out", FontFamily(Font(R.font.mrsmonsterout))),
    Pair("Mrsmonster Out Ital", FontFamily(Font(R.font.mrsmonsteroutital))),
    Pair("Mrsmonster Rotal", FontFamily(Font(R.font.mrsmonsterrotal))),
    Pair("Mrsmonster Rotate", FontFamily(Font(R.font.mrsmonsterrotate))),
    Pair("Mrsmonster Rotate 2", FontFamily(Font(R.font.mrsmonsterrotate2))),
    Pair("Open Sans Italic", FontFamily(Font(R.font.open_sans_italic_variable_font_wdth))),
    Pair("Pacifico Regular", FontFamily(Font(R.font.pacifico_regular))),
    Pair("Playball Regular", FontFamily(Font(R.font.playball_regular))),
    Pair("Raleway Dots", FontFamily(Font(R.font.raleway_dots_regular))),
    Pair("Righteous Regular", FontFamily(Font(R.font.righteous_regular))),
    Pair("Road Rage", FontFamily(Font(R.font.road_rage))),
    Pair("Roboto Condensed Bold", FontFamily(Font(R.font.roboto_condensed_bold))),
    Pair("Roboto Condensed Bold Ital", FontFamily(Font(R.font.roboto_condensed_bold_italic))),
    Pair("Roboto Condensed Ital", FontFamily(Font(R.font.roboto_condensed_italic))),
    Pair("Roboto Condensed Light", FontFamily(Font(R.font.roboto_condensed_light))),
    Pair("Roboto Condensed Light Ital", FontFamily(Font(R.font.roboto_condensed_light_italic))),
    Pair("Roboto Condensed Regular", FontFamily(Font(R.font.roboto_condensed_regular))),
    Pair("Roboto Mono Bold", FontFamily(Font(R.font.roboto_mono_bold))),
    Pair("Roboto Mono Bold Ital", FontFamily(Font(R.font.roboto_mono_bold_italic))),
    Pair("Roboto Mono Ital", FontFamily(Font(R.font.roboto_mono_italic))),
    Pair("Roboto Mono Light", FontFamily(Font(R.font.roboto_mono_light))),
    Pair("Roboto Mono Light Ital", FontFamily(Font(R.font.roboto_mono_light_italic))),
    Pair("Roboto Mono Medium", FontFamily(Font(R.font.roboto_mono_medium))),
    Pair("Roboto Mono Medium Ital", FontFamily(Font(R.font.roboto_mono_medium_italic))),
    Pair("Roboto Mono Regular", FontFamily(Font(R.font.roboto_mono_regular))),
    Pair("Roboto Mono Thin", FontFamily(Font(R.font.roboto_mono_thin))),
    Pair("Roboto Mono Thin Ital", FontFamily(Font(R.font.roboto_mono_thin_italic))),
    Pair("Roboto Slab Bold", FontFamily(Font(R.font.roboto_slab_bold))),
    Pair("Roboto Slab Light", FontFamily(Font(R.font.roboto_slab_light))),
    Pair("Roboto Slab Regular", FontFamily(Font(R.font.roboto_slab_regular))),
    Pair("Roboto Slab Thin", FontFamily(Font(R.font.roboto_slab_thin))),
    Pair("Redoka One", FontFamily(Font(R.font.rredoka_one_regular))),
    Pair("Satisfy One", FontFamily(Font(R.font.satisfy_one))),
    Pair("Starlight One", FontFamily(Font(R.font.starlight_one))),
    Pair("Telex Regular", FontFamily(Font(R.font.telex_regular))),
    Pair("Unispace Bold", FontFamily(Font(R.font.unispace_bold))),
    Pair("Unispace Bold Ital", FontFamily(Font(R.font.unispace_bold_italic))),
    Pair("Unispace Ital", FontFamily(Font(R.font.unispace_italic))),
    Pair("Unispace One", FontFamily(Font(R.font.unispace_one))),
    Pair("Wedgie Regular", FontFamily(Font(R.font.wedgie_regular))),
    Pair("Where My Keys", FontFamily(Font(R.font.where_my_keys)))





    )

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(fontList) { fontItem ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = fontItem.first, fontSize = 12.sp)
                        Text(
                            text = titleText.ifEmpty { "Sample Text" },
                            fontFamily = fontItem.second,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}
