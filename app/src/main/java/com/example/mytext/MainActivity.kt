package com.example.mytext

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

// --- List of all 31 Colors ---
val myCustomPalette = listOf(
    Color(0xFF1AD8FF), Color(0xFF10D0F8), Color(0xFF086073), Color(0xFF07FD49), Color(0xFF0AB337),
    Color(0xFFF50808), Color(0xFFFF0683), Color(0xFFEF083A), Color(0xFFB6072D), Color(0xFF0E39FA),
    Color(0xFF0425B8), Color(0xFF030E3B), Color(0xFF3A3A3D), Color(0xFFF94007), Color(0xFFEC4310),
    Color(0xFFF5FD0B), Color(0xFFFF8B06), Color(0xFF19E81C), Color(0xFFFE007F), Color(0xFFFFA305),
    Color(0xFF9D6606), Color(0xFF0DD2FB), Color(0xFFFB0606), Color(0xFFA8F906), Color(0xFF38FF06),
    Color(0xFF0AC0F8), Color(0xFF0648FE), Color(0xFF491AF5), Color(0xFF8907F4), Color(0xFFFC0432),
    Color(0xFFFFFFFF), Color(0xFF000000)
)

data class MyFont(val name: String, val family: FontFamily)
enum class AppTool { FONT, COLOR, STYLE, CASE, COMBO, BG, MAGIC, EXPORT }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(primary = Color(0xFFE91E63))) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF8F9FA)) {
                    TextArtApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextArtApp() {
    val context = LocalContext.current
    var titleText by remember { mutableStateOf("रूह-ए-इश्क Mafia King") }
    var currentTool by remember { mutableStateOf(AppTool.FONT) }

    var fontSize by remember { mutableFloatStateOf(15f) }
    var textColor by remember { mutableStateOf(Color.Black) }
    var bgColor by remember { mutableStateOf(Color.White) }
    var useGradient by remember { mutableStateOf(false) }
    var useShadow by remember { mutableStateOf(false) }
    var useGlow by remember { mutableStateOf(false) }
    var textCase by remember { mutableIntStateOf(0) }
    var selectedFancyStyle by remember { mutableStateOf("None") }
    var activeComboMode by remember { mutableIntStateOf(0) }
    var fontA by remember { mutableStateOf<FontFamily>(FontFamily.Default) }
    var fontB by remember { mutableStateOf<FontFamily>(FontFamily.Serif) }

    // --- State for Selection Mode ---
    var isSelectionMode by remember { mutableStateOf(false) }
    val selectedIndices = remember { mutableStateMapOf<Int, Boolean>() }

    val fullFontList = remember {
        listOf(
            MyFont("Default", FontFamily.Default),
            MyFont("Kalam Bold", FontFamily(Font(R.font.kalam_bold))),
            MyFont("Amita", FontFamily(Font(R.font.amita_regular))),
            MyFont("Rozha One", FontFamily(Font(R.font.rozha_one_regular))),
            MyFont("Bebas Neue", FontFamily(Font(R.font.bebas_neue_regular))),
            MyFont("Pacifico", FontFamily(Font(R.font.pacifico_regular))),
            MyFont("Poppins Bold", FontFamily(Font(R.font.poppins_bold))),
            MyFont("Bloodlust", FontFamily(Font(R.font.bloodlustital))),
            MyFont("Monoton", FontFamily(Font(R.font.monoton_regular))),
            MyFont("Beautiful One", FontFamily(Font(R.font.beautiful_one))),
            MyFont("Blaize One", FontFamily(Font(R.font.blaize_one))),
            MyFont("Blazed PP", FontFamily(Font(R.font.blazed_pp))),
            MyFont("Bloodlust Rotal", FontFamily(Font(R.font.bloodl_ustrotal))),
            MyFont("Bloodlust Acad", FontFamily(Font(R.font.bloodlustacadital))),
            MyFont("Bloodlust Grad", FontFamily(Font(R.font.bloodlustgradital))),
            MyFont("Bloodlust Out", FontFamily(Font(R.font.bloodlustoutital))),
            MyFont("Broadcast", FontFamily(Font(R.font.broadcast_titling))),
            MyFont("Cabin Bold", FontFamily(Font(R.font.cabin_condensed_bold))),
            MyFont("Cabin Medium", FontFamily(Font(R.font.cabin_condensed_medium))),
            MyFont("Cabin Regular", FontFamily(Font(R.font.cabin_condensed_regular))),
            MyFont("Cabin SemiBold", FontFamily(Font(R.font.cabin_condensed_semibold))),
            MyFont("Calligraphy", FontFamily(Font(R.font.calligraphy_flf))),
            MyFont("Calvino Bold Ital", FontFamily(Font(R.font.calvino_bold_italic_trial))),
            MyFont("Calvino Bold", FontFamily(Font(R.font.calvino_bold_trial))),
            MyFont("Calvino Book Ital", FontFamily(Font(R.font.calvino_book_italic_trial))),
            MyFont("Calvino Book", FontFamily(Font(R.font.calvino_book_trial))),
            MyFont("Calvino Extra Bold", FontFamily(Font(R.font.calvino_extra_bold_trial))),
            MyFont("Calvino Grande Light Ital", FontFamily(Font(R.font.calvino_grande_extralight_italic_trial))),
            MyFont("Calvino Grande Light", FontFamily(Font(R.font.calvino_grande_extralight_trial))),
            MyFont("Calvino Grande Regular", FontFamily(Font(R.font.calvino_grande_light_trial))),
            MyFont("Calvino Light Ital", FontFamily(Font(R.font.calvino_light_italic_trial))),
            MyFont("Calvino Regular", FontFamily(Font(R.font.calvino_regular_trial))),
            MyFont("Calvino SemiBold Ital", FontFamily(Font(R.font.calvino_semibold_italic_trial))),
            MyFont("Calvino Thin Ital", FontFamily(Font(R.font.calvino_thin_italic_trial))),
            MyFont("Calvino Thin", FontFamily(Font(R.font.calvino_thin_trial))),
            MyFont("Dancing Script", FontFamily(Font(R.font.dancing_script_variable_font_wght))),
            MyFont("Eat At Joes", FontFamily(Font(R.font.eat_at_joes))),
            MyFont("Fade To Grey", FontFamily(Font(R.font.fade_to_grey))),
            MyFont("Flames One", FontFamily(Font(R.font.flames_one))),
            MyFont("Goldman Bold", FontFamily(Font(R.font.goldman_bold))),
            MyFont("Goldman Regular", FontFamily(Font(R.font.goldman_regular))),
            MyFont("Guewara One", FontFamily(Font(R.font.guewara_one))),
            MyFont("Hind Bold", FontFamily(Font(R.font.hind_bold))),
            MyFont("Hind Medium", FontFamily(Font(R.font.hind_medium))),
            MyFont("Hind Regular", FontFamily(Font(R.font.hind_regular))),
            MyFont("Hind SemiBold", FontFamily(Font(R.font.hind_semibold))),
            MyFont("Kalam Light", FontFamily(Font(R.font.kalam_light))),
            MyFont("Kalam Regular", FontFamily(Font(R.font.kalam_regular))),
            MyFont("Lato Black", FontFamily(Font(R.font.lato_black))),
            MyFont("Lato Bold", FontFamily(Font(R.font.lato_bold))),
            MyFont("Lato Bold Ital", FontFamily(Font(R.font.lato_bold_italil))),
            MyFont("Lato Ital", FontFamily(Font(R.font.lato_italic))),
            MyFont("Lato Light", FontFamily(Font(R.font.lato_light))),
            MyFont("Lato Light Ital", FontFamily(Font(R.font.lato_light_italic))),
            MyFont("Lato Regular", FontFamily(Font(R.font.lato_regular))),
            MyFont("Lato Thin", FontFamily(Font(R.font.lato_thin))),
            MyFont("Lato Thin Ital", FontFamily(Font(R.font.lato_thin_italic))),
            MyFont("Lieselotte", FontFamily(Font(R.font.lieselotte_personal_use))),
            MyFont("Marlboro One", FontFamily(Font(R.font.marlboro_one))),
            MyFont("Montserrat Bold", FontFamily(Font(R.font.montserrat_bold))),
            MyFont("Montserrat Regular", FontFamily(Font(R.font.montserrat_regular))),
            MyFont("Moria Cabin", FontFamily(Font(R.font.moria_cabin_demo_regular))),
            MyFont("MrsMonster 3D", FontFamily(Font(R.font.mrsmonster3dital))),
            MyFont("MrsMonster Acad", FontFamily(Font(R.font.mrsmonsteracad))),
            MyFont("MrsMonster BoldOut", FontFamily(Font(R.font.mrsmonsterboldout))),
            MyFont("MrsMonster BoldOut Ital", FontFamily(Font(R.font.mrsmonsterboldoutital))),
            MyFont("MrsMonster Cond", FontFamily(Font(R.font.mrsmonstercond))),
            MyFont("MrsMonster Cond Ital", FontFamily(Font(R.font.mrsmonstercondital))),
            MyFont("MrsMonster Expand", FontFamily(Font(R.font.mrsmonsterexpand))),
            MyFont("MrsMonster Expand Ital", FontFamily(Font(R.font.mrsmonsterexpandital))),
            MyFont("MrsMonster Ital", FontFamily(Font(R.font.mrsmonsterital))),
            MyFont("MrsMonster Left", FontFamily(Font(R.font.mrsmonsterleft))),
            MyFont("MrsMonster Out", FontFamily(Font(R.font.mrsmonsterout))),
            MyFont("MrsMonster Out Ital", FontFamily(Font(R.font.mrsmonsteroutital))),
            MyFont("MrsMonster Rotal", FontFamily(Font(R.font.mrsmonsterrotal))),
            MyFont("MrsMonster Rotate", FontFamily(Font(R.font.mrsmonsterrotate))),
            MyFont("MrsMonster Rotate2", FontFamily(Font(R.font.mrsmonsterrotate2))),
            MyFont("Mukta Bold", FontFamily(Font(R.font.mukta_bold))),
            MyFont("Mukta Medium", FontFamily(Font(R.font.mukta_medium))),
            MyFont("Mukta Regular", FontFamily(Font(R.font.mukta_regular))),
            MyFont("Mukta SemiBold", FontFamily(Font(R.font.mukta_semi_bold))),
            MyFont("Open Sans Ital", FontFamily(Font(R.font.open_sans_italic_variable_font_wdth))),
            MyFont("Playball", FontFamily(Font(R.font.playball_regular))),
            MyFont("Poppins Medium", FontFamily(Font(R.font.poppins_medium))),
            MyFont("Poppins Regular", FontFamily(Font(R.font.poppins_regular))),
            MyFont("Poppins SemiBold", FontFamily(Font(R.font.poppins_semi_bold))),
            MyFont("Raleway Dots", FontFamily(Font(R.font.raleway_dots_regular))),
            MyFont("Righteous", FontFamily(Font(R.font.righteous_regular))),
            MyFont("Road Rage", FontFamily(Font(R.font.road_rage))),
            MyFont("Roboto Cond Bold", FontFamily(Font(R.font.roboto_condensed_bold))),
            MyFont("Roboto Cond Bold Ital", FontFamily(Font(R.font.roboto_condensed_bold_italic))),
            MyFont("Roboto Cond Ital", FontFamily(Font(R.font.roboto_condensed_italic))),
            MyFont("Roboto Cond Light", FontFamily(Font(R.font.roboto_condensed_light))),
            MyFont("Roboto Cond Light Ital", FontFamily(Font(R.font.roboto_condensed_light_italic))),
            MyFont("Roboto Cond Regular", FontFamily(Font(R.font.roboto_condensed_regular))),
            MyFont("Roboto Mono Bold", FontFamily(Font(R.font.roboto_mono_bold))),
            MyFont("Roboto Mono Bold Ital", FontFamily(Font(R.font.roboto_mono_bold_italic))),
            MyFont("Roboto Mono Ital", FontFamily(Font(R.font.roboto_mono_italic))),
            MyFont("Roboto Mono Light", FontFamily(Font(R.font.roboto_mono_light))),
            MyFont("Roboto Mono Light Ital", FontFamily(Font(R.font.roboto_mono_light_italic))),
            MyFont("Roboto Mono Medium", FontFamily(Font(R.font.roboto_mono_medium))),
            MyFont("Roboto Mono Medium Ital", FontFamily(Font(R.font.roboto_mono_medium_italic))),
            MyFont("Roboto Mono Regular", FontFamily(Font(R.font.roboto_mono_regular))),
            MyFont("Roboto Mono Thin", FontFamily(Font(R.font.roboto_mono_thin))),
            MyFont("Roboto Mono Thin Ital", FontFamily(Font(R.font.roboto_mono_thin_italic))),
            MyFont("Roboto Slab Bold", FontFamily(Font(R.font.roboto_slab_bold))),
            MyFont("Roboto Slab Light", FontFamily(Font(R.font.roboto_slab_light))),
            MyFont("Roboto Slab Regular", FontFamily(Font(R.font.roboto_slab_regular))),
            MyFont("Roboto Slab Thin", FontFamily(Font(R.font.roboto_slab_thin))),
            MyFont("Redoka One", FontFamily(Font(R.font.rredoka_one_regular))),
            MyFont("Satisfy One", FontFamily(Font(R.font.satisfy_one))),
            MyFont("Starlight One", FontFamily(Font(R.font.starlight_one))),
            MyFont("Telex", FontFamily(Font(R.font.telex_regular))),
            MyFont("Unispace Bold", FontFamily(Font(R.font.unispace_bold))),
            MyFont("Unispace Bold Ital", FontFamily(Font(R.font.unispace_bold_italic))),
            MyFont("Unispace Ital", FontFamily(Font(R.font.unispace_italic))),
            MyFont("Unispace One", FontFamily(Font(R.font.unispace_one))),
            MyFont("Wedgie Regular", FontFamily(Font(R.font.wedgie_regular))),
            MyFont("Where My Keys", FontFamily(Font(R.font.where_my_keys)))
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if(isSelectionMode) "Select Styles" else "Text Designer Pro", fontWeight = FontWeight.Bold) },
                actions = {
                    // Top Share is now only for APP SHARING (Simple Link)
                    IconButton(onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, "Hey! Use this amazing app to create fancy fonts: [Link]")
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share App"))
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "Share App")
                    }
                    IconButton(onClick = { Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.SaveAlt, "Save")
                    }
                }
            )
        },
        bottomBar = {
            Column(modifier = Modifier.background(Color.White).fillMaxWidth()) {
                Box(modifier = Modifier.padding(horizontal = 12.dp).height(70.dp)) {
                    // Logic to collect selected stylized texts for sharing
                    val selectedTexts = if (isSelectionMode) {
                        selectedIndices.filter { it.value }.map { (idx, _) ->
                            getProcessedText(titleText, textCase, selectedFancyStyle)
                        }.joinToString("\n\n")
                    } else {
                        getProcessedText(titleText, textCase, selectedFancyStyle)
                    }

                    when (currentTool) {
                        AppTool.FONT -> FontSelector(onSizeChange = { fontSize = it })
                        AppTool.COLOR -> ColorSelector(onColorPick = { textColor = it }, onGradientToggle = { useGradient = it })
                        AppTool.STYLE -> StyleSelector(useShadow, useGlow, { useShadow = it }, { useGlow = it })
                        AppTool.CASE -> CaseSelector { textCase = it }
                        AppTool.COMBO -> ComboSelector(fullFontList, { fontA = it }, { fontB = it }, { activeComboMode = it })
                        AppTool.BG -> BackgroundSelector { bgColor = it }
                        AppTool.MAGIC -> FancySelector { selectedFancyStyle = it }
                        AppTool.EXPORT -> ExportPanel(
                            textToShare = selectedTexts,
                            isSelecting = isSelectionMode,
                            onToggleSelection = { isSelectionMode = it },
                            onClear = { selectedIndices.clear(); isSelectionMode = false }
                        )
                    }
                }

                ScrollableTabRow(selectedTabIndex = currentTool.ordinal, edgePadding = 16.dp, containerColor = Color.White, divider = {}) {
                    AppTool.entries.forEach { tool ->
                        Tab(
                            selected = currentTool == tool,
                            onClick = { currentTool = tool },
                            icon = { Icon(when (tool) {
                                AppTool.FONT -> Icons.Default.TextFields
                                AppTool.COLOR -> Icons.Default.Palette
                                AppTool.STYLE -> Icons.Default.AutoFixHigh
                                AppTool.CASE -> Icons.Default.FormatSize
                                AppTool.COMBO -> Icons.Default.Category
                                AppTool.BG -> Icons.Default.Wallpaper
                                AppTool.MAGIC -> Icons.Default.Stars
                                AppTool.EXPORT -> Icons.Default.IosShare
                            }, null) },
                            text = { Text(tool.name, fontSize = 10.sp) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            OutlinedTextField(
                value = titleText,
                onValueChange = { titleText = it },
                label = { Text("Write your title...") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                itemsIndexed(fullFontList) { index, fontItem ->
                    val processedText = getProcessedText(titleText, textCase, selectedFancyStyle)
                    val isSelected = selectedIndices[index] ?: false

                    Card(
                        modifier = Modifier.fillMaxWidth().clickable {
                            if (isSelectionMode) selectedIndices[index] = !isSelected
                        },
                        colors = CardDefaults.cardColors(containerColor = bgColor),
                        elevation = CardDefaults.cardElevation(4.dp),
                        border = if (isSelectionMode && isSelected) BorderStroke(2.dp, Color(0xFFE91E63)) else null
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (isSelectionMode) {
                                Checkbox(
                                    checked = isSelected,
                                    onCheckedChange = { selectedIndices[index] = it },
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                            Box(modifier = Modifier.padding(20.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                                val words = processedText.split(" ")
                                Row {
                                    words.forEachIndexed { i, word ->
                                        val finalFont = when(activeComboMode) {
                                            1 -> if (i % 2 == 0) fontA else fontB
                                            2 -> if (i == 0) fontA else fontB
                                            else -> fontItem.family
                                        }
                                        Text(
                                            text = "$word ",
                                            fontFamily = finalFont,
                                            fontSize = fontSize.sp,
                                            color = if (useGradient) Color.Unspecified else textColor,
                                            style = TextStyle(
                                                brush = if (useGradient) Brush.linearGradient(listOf(textColor, Color.Cyan)) else null,
                                                shadow = if (useShadow) Shadow(Color.Black.copy(0.5f), Offset(5f, 5f), 10f)
                                                else if (useGlow) Shadow(textColor.copy(0.8f), Offset(0f, 0f), 25f) else null
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
    }
}

// --- SELECTORS (Remain Same) ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FontSelector(onSizeChange: (Float) -> Unit) {
    Column {
        Text("Text Size: Medium Slider", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        var sliderPos by remember { mutableFloatStateOf(35f) }
        Slider(value = sliderPos, onValueChange = { sliderPos = it; onSizeChange(it) }, valueRange = 20f..100f,
            track = { SliderDefaults.Track(sliderState = it, modifier = Modifier.height(10.dp)) })
    }
}

@Composable
fun ColorSelector(onColorPick: (Color) -> Unit, onGradientToggle: (Boolean) -> Unit) {
    var gradCheck by remember { mutableStateOf(false) }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Gradient Mode", fontSize = 12.sp)
            Checkbox(checked = gradCheck, onCheckedChange = { gradCheck = it; onGradientToggle(it) })
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(myCustomPalette) { Box(Modifier.size(45.dp).clip(CircleShape).background(it).border(1.dp, Color.LightGray, CircleShape).clickable { onColorPick(it) }) }
        }
    }
}

@Composable
fun CaseSelector(onCaseChange: (Int) -> Unit) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = { onCaseChange(1) }) { Text("UPPER") }
        Button(onClick = { onCaseChange(2) }) { Text("lower") }
        Button(onClick = { onCaseChange(3) }) { Text("Title") }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboSelector(fonts: List<MyFont>, setA: (FontFamily) -> Unit, setB: (FontFamily) -> Unit, setMode: (Int) -> Unit) {
    Column {
        Row {
            AssistChip(onClick = { setMode(1) }, label = { Text("A-B-A-B") })
            Spacer(Modifier.width(8.dp)); AssistChip(onClick = { setMode(2) }, label = { Text("First-Rest") })
            Spacer(Modifier.width(8.dp)); AssistChip(onClick = { setMode(0) }, label = { Text("Reset") })
        }
        LazyRow {
            items(fonts) {
                Button(onClick = { setA(it.family) }, Modifier.padding(4.dp)) { Text("A:${it.name}", fontSize = 9.sp) }
                Button(onClick = { setB(it.family) }, Modifier.padding(4.dp)) { Text("B:${it.name}", fontSize = 9.sp) }
            }
        }
    }
}

@Composable
fun StyleSelector(shadow: Boolean, glow: Boolean, onShadow: (Boolean) -> Unit, onGlow: (Boolean) -> Unit) {
    Row {
        Column(horizontalAlignment = Alignment.CenterHorizontally) { Text("Shadow", fontSize = 10.sp); Switch(shadow, onShadow) }
        Spacer(Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) { Text("Glow", fontSize = 10.sp); Switch(glow, onGlow) }
    }
}

@Composable
fun BackgroundSelector(onBgPick: (Color) -> Unit) {
    Column {
        Text("Select Background Color:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(myCustomPalette) { Box(Modifier.size(45.dp).background(it).border(1.dp, Color.Gray).clickable { onBgPick(it) }) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FancySelector(onStyle: (String) -> Unit) {
    val styles = listOf("None", "Bubble", "Square", "Stars")
    LazyRow { items(styles) { AssistChip(onClick = { onStyle(it) }, label = { Text(it) }, modifier = Modifier.padding(4.dp)) } }
}

@Composable
fun ExportPanel(textToShare: String, isSelecting: Boolean, onToggleSelection: (Boolean) -> Unit, onClear: () -> Unit) {
    val context = LocalContext.current
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        // COPY BUTTON
        IconButton(onClick = {
            val clipboard = context.getSystemService(android.content.Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
            clipboard.setPrimaryClip(android.content.ClipData.newPlainText("Fancy Text", textToShare))
            Toast.makeText(context, "Copied!", Toast.LENGTH_SHORT).show()
        }) { Icon(Icons.Default.ContentCopy, null) }

        // MAIN SHARE / SEND BUTTON
        IconButton(onClick = {
            if (!isSelecting) {
                // First click: Start Selection
                onToggleSelection(true)
            } else {
                // Second click: If something is selected, Share it
                if (textToShare.isNotBlank()) {
                    val sendIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, textToShare)
                    }
                    context.startActivity(Intent.createChooser(sendIntent, "Share Styles"))
                    onClear() // Exit selection after sharing
                } else {
                    Toast.makeText(context, "Select at least one style!", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
            // Icon changes from Share to Send in Selection Mode
            Icon(if (isSelecting) Icons.Default.Send else Icons.Default.Share,
                contentDescription = null,
                tint = if(isSelecting) Color(0xFFE91E63) else LocalContentColor.current)
        }

        // CANCEL BUTTON (Only shows during selection)
        if (isSelecting) {
            IconButton(onClick = onClear) { Icon(Icons.Default.Close, null) }
        }
    }
}

fun getProcessedText(input: String, caseType: Int, fancy: String): String {
    val text = when (caseType) {
        1 -> input.uppercase()
        2 -> input.lowercase()
        3 -> input.split(" ").joinToString(" ") { it.replaceFirstChar { char -> if (char.isLowerCase()) char.titlecase(Locale.getDefault()) else char.toString() } }
        else -> input
    }
    return when (fancy) {
        "Bubble" -> "Ⓞ $text Ⓞ"
        "Stars" -> "✨ $text ✨"
        "Square" -> "[ $text ]"
        else -> text
    }
}