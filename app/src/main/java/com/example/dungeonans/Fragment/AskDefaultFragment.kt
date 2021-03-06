package com.example.dungeonans.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.dungeonans.Activity.UserProfileActivity
import com.example.dungeonans.R

class AskDefaultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.ask_default_fragment,container,false)

        var showAllPostBtn : Button = view.findViewById(R.id.showAllPostBtn)
        showAllPostBtn.setOnClickListener{
            changeFragmentLogic(AskShowAllPostFragment(), "0")
        }

        var showUnAnsweredBtn : Button = view.findViewById(R.id.showUnAnsweredPostBtn)
        showUnAnsweredBtn.setOnClickListener{
            changeFragmentLogic(AskShowAllPostFragment(), "1")
        }

        var showAnsweredBtn : Button = view.findViewById(R.id.showAnsweredPostBtn)
        showAnsweredBtn.setOnClickListener{
            changeFragmentLogic(AskShowAllPostFragment(), "2")
        }

        renderUi(view)
        return view
    }

    private fun changeFragmentLogic(fragment : Fragment, parameter : String) {
        var parentFragment = parentFragment as AskFragment
        parentFragment.changeFragment(fragment, parameter)
    }

    private fun renderUi(view: View) {
        var bestUserLayout : LinearLayout = view.findViewById(R.id.bestUserLayout)
        for (index in 0 until 5) {
            var userCardView = layoutInflater.inflate(R.layout.best_user_cardview,null)
            userCardView.setOnClickListener {
                var intent = Intent(context, UserProfileActivity::class.java)
                startActivity(intent)
            }
            bestUserLayout.addView(userCardView)
        }
    }
}