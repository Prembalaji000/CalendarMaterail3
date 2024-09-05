import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


class CalendarActivity : ComponentActivity(){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            DatePickerSample()
        }
    }
}


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSample() {
//    val datePickerState =
//        rememberDatePickerState(
//            selectableDates =
//            object : SelectableDates {
//                // Blocks Sunday and Saturday from being selected.
//                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
//                    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        val dayOfWeek =
//                            Instant.ofEpochMilli(utcTimeMillis)
//                                .atZone(ZoneId.of("UTC"))
//                                .toLocalDate()
//                                .dayOfWeek
//                        dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY
//                    } else {
//                        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
//                        calendar.timeInMillis = utcTimeMillis
//                        calendar[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY &&
//                                calendar[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY
//                    }
//                }
//
//                // Allow selecting dates from year 2023 forward.
//                override fun isSelectableYear(year: Int): Boolean {
//                    return year > 2022
//                }
//            }
//        )
//
//    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//        DatePicker(state = datePickerState)
//        Text(
//            "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
//        DatePicker(state = state, modifier = Modifier.padding(16.dp))
//
//        Text(
//            "Entered date timestamp: ${state.selectedDateMillis ?: "no input"}",
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )
//    }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        val datePickerState = rememberDatePickerState()
        DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

//        Text(
//            "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )
    }
//    val snackState = remember { SnackbarHostState() }
//    val snackScope = rememberCoroutineScope()
//    SnackbarHost(hostState = snackState, Modifier.zIndex(1f))
//
//    val state = rememberDateRangePickerState()
//    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
//        // Add a row with "Save" and dismiss actions.
//        Row(
//            modifier =
//            Modifier.fillMaxWidth()
//                .background(DatePickerDefaults.colors().containerColor)
//                .padding(start = 12.dp, end = 12.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            IconButton(onClick = { /* dismiss the UI */ }) {
//                Icon(Icons.Filled.Close, contentDescription = "Localized description")
//            }
//            TextButton(
//                onClick = {
//                    snackScope.launch {
//                        val range = state.selectedStartDateMillis!!..state.selectedEndDateMillis!!
//                        snackState.showSnackbar("Saved range (timestamps): $range")
//                    }
//                },
//                enabled = state.selectedEndDateMillis != null
//            ) {
//                Text(text = "Save")
//            }
//        }
//        DateRangePicker(state = state, modifier = Modifier.weight(1f))
//    }

}
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun CalendarView(selectedDate : MutableState<LocalDate>){
//    val today = LocalDate.now()
//
//    val weeks = getWeeksFromToday(today, 52)
//
//    val pagerState = rememberPagerState(
//        initialPage = 0,
//        initialPageOffsetFraction = 0f
//    )
//    Column(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        val displayText = when {
//            selectedDate.value == today -> "Today"
//            selectedDate.value == today.plusDays(1) -> "Tomorrow"
//            else -> {
//                val dateFormat = if (selectedDate.value.year == today.year) {
//                    DateTimeFormatter.ofPattern("d MMM", Locale.getDefault())
//                } else {
//                    DateTimeFormatter.ofPattern("d MMM yyyy", Locale.getDefault())
//                }
//                selectedDate.value.format(dateFormat)
//            }
//        }
//        Text(text = displayText,
//            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
//        )
//        val weekName = selectedDate.value.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
//        Text(text = weekName,
//            modifier = Modifier.padding(start = 20.dp, bottom = 16.dp)
//        )
//
//        Row (
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp)
//        ){
//            listOf("sun", "mon", "tue", "wed", "thu", "fri", "sat").forEach { day ->
//                Text(
//                    text = day,
//                    modifier = Modifier.weight(1f),
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//
//        HorizontalPager(beyondBoundsPageCount = weeks.size,
//            state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
//            val weekDates = weeks[page]
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp)  // Add horizontal padding
//            ) {
//                weekDates.forEach { date ->
//                    val interactionSource = remember { MutableInteractionSource()}
//                    Box (modifier = Modifier
//                        .weight(1f)
//                        .height(48.dp)
//                        .clip(CircleShape)
//                        .clickable {
//                            selectedDate.value = date
//                        }
//                        .background(if (date == selectedDate.value) MaterialTheme.colorScheme.primaryContainer else Color.Transparent),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = date.dayofMonth.toString(),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun getWeeksFromToday(today : LocalDate, weeksCount : Int) {
//    val weeks = mutableListOf<List<LocalDate>>()
//    var currentStartOfWeek = today
//    while (currentStartOfWeek.dayOfWeek != DayOfWeek.SUNDAY) {
//        currentStartOfWeek = currentStartOfWeek.minusDays(1)
//    }
//    repeat(weeksCount){
//        val week = (0 until 7).map { currentStartOfWeek.plusDays(it.toLong()) }
//        weeks.add(week)
//        currentStartOfWeek = currentStartOfWeek.plusWeeks(1)
//    }
//    weeks.forEach { week->
//        Log.e("TAG", "Week: ${week.joinToString { "," }}")
//    }
//}