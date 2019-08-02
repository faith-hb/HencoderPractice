package com.doyou.practicelayout1

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val marginBottom = dpToPixel(150f)
    private val minWidth = dpToPixel(80f)
    private val minHeight = dpToPixel(100f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var layoutP = targetLayout.layoutParams
                layoutP.width = (minWidth + (container.width - minWidth) * topSeekW.progress / 100).toInt()
                layoutP.height = (minHeight + (container.height - minHeight - marginBottom) * topSeekH.progress / 100).toInt()
                targetLayout.layoutParams = layoutP
                Log.d(TAG, "topSeekBar pro = $progress" + "->height = " + layoutP.height)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        }
        topSeekW.setOnSeekBarChangeListener(listener)
        topSeekH.setOnSeekBarChangeListener(listener)
    }

    fun dpToPixel(dp: Float): Float {
        val metrics = Resources.getSystem().displayMetrics
        return dp * metrics.density
    }
}
