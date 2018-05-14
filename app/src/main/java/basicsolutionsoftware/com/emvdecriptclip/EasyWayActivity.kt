package basicsolutionsoftware.com.emvdecriptclip

import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.v7.app.AppCompatActivity
import io.github.binaryfoo.RootDecoder
import kotlinx.android.synthetic.main.activity_easy_way.*
import java.util.*

class EasyWayActivity : AppCompatActivity() {

    val decoder = RootDecoder()
    val randomEMVData = ArrayList<Int>()
    val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_way)
        setButtonAction()
        setRandomEMVData()
    }

    fun setButtonAction(){

        button_process.setOnClickListener {
            var textEVMData = getInputTextEVMData()

            val decodedData = decoder.decode(textEVMData, "EMV", "constructed")
            val dataStringBuilder = StringBuilder()

            for (item in decodedData){
                val rawData = item.rawData
                val rawDataFormatted = formatRawData(rawData)
                dataStringBuilder.append(rawDataFormatted)
                dataStringBuilder.append(System.getProperty("line.separator"))
                dataStringBuilder.append(getString(R.string.space))
                dataStringBuilder.append(item.fullDecodedData)
                dataStringBuilder.append(System.getProperty("line.separator"))
                dataStringBuilder.append(System.getProperty("line.separator"))
            }

            data_tv.setText(dataStringBuilder.toString())

        }

        ic_random.setOnClickListener {

            var randomEMV = randomEMVData.get(random.nextInt(2 - 0) + 0)

            emv_data_edt.setText(randomEMV)

        }
    }

    fun setRandomEMVData(){
        randomEMVData.add(R.string.emv_text_1)
        randomEMVData.add(R.string.emv_text_2)
    }

    fun getInputTextEVMData(): String {
        return emv_data_edt.getText().toString()
    }

    fun formatRawData(fullDecodedData:String): String {
        var indexFirstParenthesis = fullDecodedData.indexOf("(")
        var indexLastParenthesis = fullDecodedData.indexOf(")")

        var rawData = fullDecodedData.substring(indexFirstParenthesis+1, indexLastParenthesis)

        return rawData.toUpperCase()
    }

}