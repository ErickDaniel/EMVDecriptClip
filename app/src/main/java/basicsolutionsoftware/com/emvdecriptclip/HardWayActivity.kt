package basicsolutionsoftware.com.emvdecriptclip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_easy_way.*
import java.util.*

class HardWayActivity : AppCompatActivity() {

    val randomEMVData = ArrayList<Int>()
    val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_way)
        setButtonActions()
        setRandomEMVData()
    }

    fun setButtonActions(){

        button_process.setOnClickListener {

            var textEVMData = getInputTextEVMData()
            processEMVData(textEVMData)

        }

        ic_random.setOnClickListener {

            var randomEMV = randomEMVData.get(random.nextInt(2 - 0) + 0)

            emv_data_edt.setText(randomEMV)

        }
    }

    fun processEMVData(textEMVData:String){

        val tags = EMVTags().tags
        var indexOfTag = 0
        var tagFound = ""
        for (tag in tags){
            indexOfTag = textEMVData.indexOf(tag.tag)
            if(indexOfTag != -1){
                tagFound = tag.tag
                break
            }
        }

        if(indexOfTag != -1){
            Log.i("HardWayTag", Integer.toString(indexOfTag) + tagFound)
        }

        processEMVData(textEMVData)

    }

    fun setRandomEMVData(){
        randomEMVData.add(R.string.emv_text_1)
        randomEMVData.add(R.string.emv_text_2)
    }

    fun getInputTextEVMData(): String {
        return emv_data_edt.getText().toString()
    }

}