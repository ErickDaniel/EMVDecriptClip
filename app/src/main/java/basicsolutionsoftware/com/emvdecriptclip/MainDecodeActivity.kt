package basicsolutionsoftware.com.emvdecriptclip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_decode.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class MainDecodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_decode)
        setCardActions()
    }

    fun setCardActions(){
        easy_way.setOnClickListener { startActivity(intentFor<EasyWayActivity>().singleTop()) }
        //hard_way.setOnClickListener { startActivity(intentFor<HardWayActivity>().singleTop()) }
    }

}