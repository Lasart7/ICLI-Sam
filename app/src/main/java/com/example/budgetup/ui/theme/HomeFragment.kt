package com.example.budgetup.ui.theme

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize views and set data
        val tvWelcome = view.findViewById<TextView>(R.id.tvWelcome)
        val tvTotalBalance = view.findViewById<TextView>(R.id.tvTotalBalance)
        val tvIncome = view.findViewById<TextView>(R.id.tvIncome)
        val tvExpense = view.findViewById<TextView>(R.id.tvExpense)

        // Setup RecyclerViews for cards and activity
        val rvCards = view.findViewById<RecyclerView>(R.id.rvCards)
        rvCards.layoutManager = LinearLayoutManager(context)
        // Set adapter for cards

        val rvActivity = view.findViewById<RecyclerView>(R.id.rvActivity)
        rvActivity.layoutManager = LinearLayoutManager(context)
        // Set adapter for activity

        return view
    }
}