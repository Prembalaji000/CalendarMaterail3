//package com.example.calendarprac
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LearnAndroidComposeTheme {
//                var selectedDate = remember { mutableStateOf(LocalDate.now()) }
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    CalendarView(selectedDate = selectedDate)
//
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
//@Composable
//fun CalendarView(selectedDate: MutableState<LocalDate>) {
//    val today = LocalDate.now()
//    Log.e("TAG", "CalendarView: $today")
//
//    val weeks = getWeeksFromToday(today, 52)
//
//    val pagerState = rememberPagerState(
//        initialPage = 0,
//        initialPageOffsetFraction = 0f
//    )
//
//    Column(modifier = Modifier.fillMaxWidth()) {
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
//
//        Text(
//            text = displayText,
//            style = MaterialTheme.typography.headlineLarge.copy( fontWeight = FontWeight.Bold),
//            color = MaterialTheme.colorScheme.primary,
//            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
//        )
//
//        val weekName = selectedDate.value.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
//        Text(
//            text = weekName,
//            color = MaterialTheme.colorScheme.secondary,
//            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light),
//            modifier = Modifier.padding(start = 20.dp, bottom = 16.dp)
//        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp)
//        ) {
//            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
//                Text(
//                    text = day,
//                    modifier = Modifier.weight(1f),
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//
//        HorizontalPager(    pageCount = weeks.size,
//            state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
//            val weekDates = weeks[page]
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp)  // Add horizontal padding
//            ) {
//                weekDates.forEach { date ->
//                    val interactionSource = remember { MutableInteractionSource() }
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .height(48.dp)  // Add a fixed height
//                            .clip(CircleShape)
//                            .clickable(
//                            ) { selectedDate.value = date }
//                            .background(if (date == selectedDate.value) MaterialTheme.colorScheme.primaryContainer else Color.Transparent),
//
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = date.dayOfMonth.toString(),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//fun getWeeksFromToday(today: LocalDate, weeksCount: Int): List<List<LocalDate>> {
//    val weeks = mutableListOf<List<LocalDate>>()
//    var currentStartOfWeek = today
//    while (currentStartOfWeek.dayOfWeek != DayOfWeek.SUNDAY) {
//        currentStartOfWeek = currentStartOfWeek.minusDays(1)
//    }
//    repeat(weeksCount) {
//        val week = (0 until 7).map { currentStartOfWeek.plusDays(it.toLong()) }
//        weeks.add(week)
//        currentStartOfWeek = currentStartOfWeek.plusWeeks(1)
//    }
//    weeks.forEach { week ->
//        Log.e("TAG", "Week: ${week.joinToString(", ")}")
//    }
//    return weeks
//}
