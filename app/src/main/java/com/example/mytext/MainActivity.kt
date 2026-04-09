package com.example.mytext



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


enum class SelectedTool { SIZE, STYLE, COLOR }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyFontAppPreview()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFontAppPreview() {
    var titleText by remember { mutableStateOf("") }
    var fontSize by remember { mutableFloatStateOf(28f) }
    var textColor by remember { mutableStateOf(Color.Black) }
    var backgroundColor by remember { mutableStateOf(Color.Transparent) }
    var borderColor by remember { mutableStateOf(Color.Transparent) }
    var selectedWeight by remember { mutableStateOf(FontWeight.Normal) }
    var isItalic by remember { mutableStateOf(false) }
    var currentTool by remember { mutableStateOf(SelectedTool.SIZE) }
    var activeColorTarget by remember { mutableStateOf("Text") }

    val fontList = remember {
        listOf(
            Pair("Default", FontFamily.Default),
            Pair("Serif", FontFamily.Serif),
            Pair("Cursive", FontFamily.Cursive),
            Pair("Monospace", FontFamily.Monospace),
            Pair("Adventure", FontFamily(Font(R.font.adventure_one))),
            Pair("Bebas Neue", FontFamily(Font(R.font.bebas_neue_regular))),
            Pair("Dancing Script", FontFamily(Font(R.font.dancing_script_variable_font_wght))),
            Pair("Pacifico", FontFamily(Font(R.font.pacifico_regular))),
            Pair("Road Rage", FontFamily(Font(R.font.road_rage))),
            Pair("Unispace", FontFamily(Font(R.font.unispace_one))),
            Pair("Monoton", FontFamily(Font(R.font.monoton_regular))),
            Pair("Satisfy", FontFamily(Font(R.font.satisfy_one))),
            Pair("Playball", FontFamily(Font(R.font.playball_regular))),
            Pair("Cabin Cond Bold", FontFamily(Font(R.font.cabin_condensed_bold))),
            Pair("Cabin Cond Medium", FontFamily(Font(R.font.cabin_condensed_medium))),
            Pair("Cabin Cond Regular", FontFamily(Font(R.font.cabin_condensed_regular))),
            Pair("Cabin Cond SemiBold", FontFamily(Font(R.font.cabin_condensed_semibold))),
            Pair("Calligraphy FLF", FontFamily(Font(R.font.calligraphy_flf))),
            Pair("Calvino Bold Ital", FontFamily(Font(R.font.calvino_bold_italic_trial))),
            Pair("Calvino Bold", FontFamily(Font(R.font.calvino_bold_trial))),
            Pair("Calvino Book Ital", FontFamily(Font(R.font.calvino_book_italic_trial))),
            Pair("Calvino Book", FontFamily(Font(R.font.calvino_book_trial))),
            Pair("Calvino Extra Bold", FontFamily(Font(R.font.calvino_extra_bold_trial))),
            Pair("Calvino Grande EL Ital", FontFamily(Font(R.font.calvino_grande_extralight_italic_trial))),
            Pair("Calvino Grande EL", FontFamily(Font(R.font.calvino_grande_extralight_trial))),
            Pair("Calvino Grande Light", FontFamily(Font(R.font.calvino_grande_light_trial))),
            Pair("Calvino Light Ital", FontFamily(Font(R.font.calvino_light_italic_trial))),
            Pair("Calvino Regular", FontFamily(Font(R.font.calvino_regular_trial))),
            Pair("Calvino SemiBold Ital", FontFamily(Font(R.font.calvino_semibold_italic_trial))),
            Pair("Calvino Thin Ital", FontFamily(Font(R.font.calvino_thin_italic_trial))),
            Pair("Calvino Thin", FontFamily(Font(R.font.calvino_thin_trial))),
            Pair("Eat At Joes", FontFamily(Font(R.font.eat_at_joes))),
            Pair("Fade To Grey", FontFamily(Font(R.font.fade_to_grey))),
            Pair("Flames One", FontFamily(Font(R.font.flames_one))),
            Pair("Goldman Bold", FontFamily(Font(R.font.goldman_bold))),
            Pair("Goldman Regular", FontFamily(Font(R.font.goldman_regular))),
            Pair("Guewara One", FontFamily(Font(R.font.guewara_one))),
            Pair("Lato Black", FontFamily(Font(R.font.lato_black))),
            Pair("Lato Bold", FontFamily(Font(R.font.lato_bold))),
            Pair("Lato Bold Ital", FontFamily(Font(R.font.lato_bold_italil))),
            Pair("Lato Italic", FontFamily(Font(R.font.lato_italic))),
            Pair("Lato Light", FontFamily(Font(R.font.lato_light))),
            Pair("Lato Light Ital", FontFamily(Font(R.font.lato_light_italic))),
            Pair("Lato Regular", FontFamily(Font(R.font.lato_regular))),
            Pair("Lato Thin", FontFamily(Font(R.font.lato_thin))),
            Pair("Lato Thin Ital", FontFamily(Font(R.font.lato_thin_italic))),
            Pair("Lieselotte", FontFamily(Font(R.font.lieselotte_personal_use))),
            Pair("Marlboro One", FontFamily(Font(R.font.marlboro_one))),
            Pair("Montserrat Bold", FontFamily(Font(R.font.montserrat_bold))),
            Pair("Montserrat Regular", FontFamily(Font(R.font.montserrat_regular))),
            Pair("Moria Cabin Regular", FontFamily(Font(R.font.moria_cabin_demo_regular))),
            Pair("Mrs Monster 3D Ital", FontFamily(Font(R.font.mrsmonster3dital))),
            Pair("Mrs Monster Acad", FontFamily(Font(R.font.mrsmonsteracad))),
            Pair("Mrs Monster Bold Out", FontFamily(Font(R.font.mrsmonsterboldout))),
            Pair("Mrs Monster Bold Out Ital", FontFamily(Font(R.font.mrsmonsterboldoutital))),
            Pair("Mrs Monster Cond", FontFamily(Font(R.font.mrsmonstercond))),
            Pair("Mrs Monster Cond Ital", FontFamily(Font(R.font.mrsmonstercondital))),
            Pair("Mrs Monster Expand", FontFamily(Font(R.font.mrsmonsterexpand))),
            Pair("Mrs Monster Expand Ital", FontFamily(Font(R.font.mrsmonsterexpandital))),
            Pair("Mrs Monster Ital", FontFamily(Font(R.font.mrsmonsterital))),
            Pair("Mrs Monster Left", FontFamily(Font(R.font.mrsmonsterleft))),
            Pair("Mrs Monster Out", FontFamily(Font(R.font.mrsmonsterout))),
            Pair("Mrs Monster Out Ital", FontFamily(Font(R.font.mrsmonsteroutital))),
            Pair("Mrs Monster Rotal", FontFamily(Font(R.font.mrsmonsterrotal))),
            Pair("Mrs Monster Rotate", FontFamily(Font(R.font.mrsmonsterrotate))),
            Pair("Mrs Monster Rotate 2", FontFamily(Font(R.font.mrsmonsterrotate2))),
            Pair("Open Sans Ital", FontFamily(Font(R.font.open_sans_italic_variable_font_wdth))),
            Pair("Raleway Dots Regular", FontFamily(Font(R.font.raleway_dots_regular))),
            Pair("Righteous Regular", FontFamily(Font(R.font.righteous_regular))),
            Pair("Roboto Cond Bold", FontFamily(Font(R.font.roboto_condensed_bold))),
            Pair("Roboto Cond Bold Ital", FontFamily(Font(R.font.roboto_condensed_bold_italic))),
            Pair("Roboto Cond Ital", FontFamily(Font(R.font.roboto_condensed_italic))),
            Pair("Roboto Cond Light", FontFamily(Font(R.font.roboto_condensed_light))),
            Pair("Roboto Cond Light Ital", FontFamily(Font(R.font.roboto_condensed_light_italic))),
            Pair("Roboto Cond Regular", FontFamily(Font(R.font.roboto_condensed_regular))),
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
            Pair("Starlight One", FontFamily(Font(R.font.starlight_one))),
            Pair("Telex Regular", FontFamily(Font(R.font.telex_regular))),
            Pair("Unispace Bold", FontFamily(Font(R.font.unispace_bold))),
            Pair("Unispace Bold Ital", FontFamily(Font(R.font.unispace_bold_italic))),
            Pair("Unispace Ital", FontFamily(Font(R.font.unispace_italic))),
            Pair("Wedgie Regular", FontFamily(Font(R.font.wedgie_regular))),
            Pair("Where My Keys", FontFamily(Font(R.font.where_my_keys))),
            Pair("Aca Flft", FontFamily(Font(R.font.aca_flft))),
            Pair("Acha Fout", FontFamily(Font(R.font.acha_fout))),
            Pair("Acha Fsex", FontFamily(Font(R.font.acha_fsex))),
            Pair("Adrip One", FontFamily(Font(R.font.adrip_one))),
            Pair("Adventure Cutline", FontFamily(Font(R.font.adventure_cutline))),
            Pair("Albam One", FontFamily(Font(R.font.albam_one))),
            Pair("Albam Two", FontFamily(Font(R.font.albam_two))),
            Pair("Albam Three", FontFamily(Font(R.font.albam_three))),
            Pair("Always Optimistic", FontFamily(Font(R.font.always_optimistic))),
            Pair("Beautiful One", FontFamily(Font(R.font.beautiful_one))),
            Pair("Blaize One", FontFamily(Font(R.font.blaize_one))),
            Pair("Blazed PP", FontFamily(Font(R.font.blazed_pp))),
            Pair("Bloodlust", FontFamily(Font(R.font.bloodlust))),
            Pair("Bloodlust Rotal", FontFamily(Font(R.font.bloodl_ustrotal))),
            Pair("Bloodlust Acadital", FontFamily(Font(R.font.bloodlustacadital))),
            Pair("Bloodlust Gradital", FontFamily(Font(R.font.bloodlustgradital))),
            Pair("Bloodlust Ital", FontFamily(Font(R.font.bloodlustital))),
            Pair("Bloodlust Outital", FontFamily(Font(R.font.bloodlustoutital))),
            Pair("Broadcast Titling", FontFamily(Font(R.font.broadcast_titling)))
        )
    }

    val weights = listOf(
        "Thin" to FontWeight.Thin,
        "Regular" to FontWeight.Normal,
        "Medium" to FontWeight.Medium,
        "Bold" to FontWeight.Bold,
        "Black" to FontWeight.Black
    )

    val colorList = listOf(
        Color.Black, Color.White, Color.Red, Color.Blue, Color(0xFF4CAF50),
        Color.Magenta, Color.Cyan, Color.Gray, Color(0xFFFF9800),
        Color(0xFF9C27B0), Color(0xFFFFEB3B), Color.Transparent
    )

    Scaffold(
        bottomBar = {
            Column(modifier = Modifier.background(Color.White)) {
                HorizontalDivider()
                Box(modifier = Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) {
                    when (currentTool) {
                        SelectedTool.SIZE -> {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(onClick = { if (fontSize > 10) fontSize -= 2f }) { Icon(Icons.Default.Remove, null) }

                                // --- MEDIUM SLIDER FIXED ---
                                Slider(
                                    value = fontSize,
                                    onValueChange = { fontSize = it },
                                    valueRange = 10f..120f,
                                    modifier = Modifier.weight(1f).height(20.dp),
                                    track = { sliderState ->
                                        SliderDefaults.Track(
                                            sliderState = sliderState,
                                            modifier = Modifier.height(6.dp) // <--- Medium thickness
                                        )
                                    }
                                )

                                IconButton(onClick = { if (fontSize < 120) fontSize += 2f }) { Icon(Icons.Default.Add, null) }
                                Text("${fontSize.toInt()}sp")
                            }
                        }
                        SelectedTool.COLOR -> {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    listOf("Text", "BG", "Border").forEach { target ->
                                        FilterChip(selected = activeColorTarget == target, onClick = { activeColorTarget = target }, label = { Text(target) })
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    items(colorList) { color ->
                                        Box(
                                            modifier = Modifier.size(35.dp).clip(CircleShape).background(if (color == Color.Transparent) Color.LightGray.copy(0.3f) else color)
                                                .border(2.dp, if ((activeColorTarget == "Text" && textColor == color) || (activeColorTarget == "BG" && backgroundColor == color) || (activeColorTarget == "Border" && borderColor == color)) Color.Blue else Color.LightGray, CircleShape)
                                                .clickable {
                                                    when (activeColorTarget) {
                                                        "Text" -> textColor = color
                                                        "BG" -> backgroundColor = color
                                                        "Border" -> borderColor = color
                                                    }
                                                }
                                        )
                                    }
                                }
                            }
                        }
                        SelectedTool.STYLE -> {
                            Column {
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    items(weights) { (name, weight) ->
                                        FilterChip(selected = selectedWeight == weight, onClick = { selectedWeight = weight }, label = { Text(name) })
                                    }
                                }
                                FilterChip(selected = isItalic, onClick = { isItalic = !isItalic }, label = { Text("Italic") }, leadingIcon = { if(isItalic) Icon(Icons.Default.Check, null) })
                            }
                        }
                    }
                }
                NavigationBar(containerColor = Color.White) {
                    NavigationBarItem(selected = currentTool == SelectedTool.SIZE, onClick = { currentTool = SelectedTool.SIZE }, icon = { Icon(Icons.Default.TextFields, null) }, label = { Text("Size") })
                    NavigationBarItem(selected = currentTool == SelectedTool.STYLE, onClick = { currentTool = SelectedTool.STYLE }, icon = { Icon(Icons.Default.FormatBold, null) }, label = { Text("Style") })
                    NavigationBarItem(selected = currentTool == SelectedTool.COLOR, onClick = { currentTool = SelectedTool.COLOR }, icon = { Icon(Icons.Default.Palette, null) }, label = { Text("Color") })
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            OutlinedTextField(value = titleText, onValueChange = { titleText = it }, label = { Text("Enter Title") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(fontList) { fontItem ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(text = fontItem.first, fontSize = 11.sp, color = Color.Gray)
                            Box(
                                modifier = Modifier.fillMaxWidth().background(backgroundColor, RoundedCornerShape(8.dp)).border(1.dp, borderColor, RoundedCornerShape(8.dp)).padding(24.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = titleText.ifEmpty { "Text Generator" },
                                    modifier = Modifier
                                        .fillMaxWidth()            // 1. पूरी चौड़ाई लें
                                        .padding(horizontal = 4.dp, vertical = 2.dp), // 2. साइड से थोड़ी जगह छोड़ने के लिए
                                    textAlign = TextAlign.Start,   // 3. Text को Left side में करने के लिए
                                    style = TextStyle(
                                        fontFamily = fontItem.second,
                                        fontSize = fontSize.sp,
                                        color = textColor,
                                        fontWeight = selectedWeight,
                                        fontStyle = if (isItalic) FontStyle.Italic else FontStyle.Normal
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}