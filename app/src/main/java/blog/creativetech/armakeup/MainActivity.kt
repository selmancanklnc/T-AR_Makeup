package blog.creativetech.armakeup

import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.transition.Visibility
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import blog.creativetech.armakeup.arface.AugmentedFaceFragment
import blog.creativetech.armakeup.arface.AugmentedFaceListener
import blog.creativetech.armakeup.arface.AugmentedFaceNode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.chip_eye1
import kotlinx.android.synthetic.main.activity_main.chip_eye2
import kotlinx.android.synthetic.main.activity_main.chip_eye3
import kotlinx.android.synthetic.main.activity_main.chip_eye4
import kotlinx.android.synthetic.main.activity_main.eyes_group
import kotlinx.android.synthetic.main.activity_main.face_view
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;


class MainActivity : AppCompatActivity(), AugmentedFaceListener {

    private var contourChanged = false
    private var contourColor = floatArrayOf(0.686f, 0.5f, 0.38f, 1f)
    private var eyeshadowChanged = false
    private var eyeshadowColor = floatArrayOf(0.686f, 0.5f, 0.38f, 1f)
    private var dudakChanged = false
    private var dudakColor = floatArrayOf(0.972f, 0.925f, 0.941f, 1f)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)





        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        val Panels: View = findViewById(R.id.Panels)
        val Panels_far: View = findViewById(R.id.Panel_far)
        val Panel_Ruj: View = findViewById(R.id.Panel_Ruj)

        val chip_contour1: Button = findViewById(R.id.chip_contour1)
        val chip_contour2: Button = findViewById(R.id.chip_contour2)
        val chip_contour3: Button = findViewById(R.id.chip_contour3)
        val chip_contour4: Button = findViewById(R.id.chip_contour4)

        val chip_eye1: Button = findViewById(R.id.chip_eye1)
        val chip_eye2: Button = findViewById(R.id.chip_eye2)
        val chip_eye3: Button = findViewById(R.id.chip_eye3)
        val chip_eye4: Button = findViewById(R.id.chip_eye4)

        val dudak_1: Button = findViewById(R.id.dudak_1)
        val dudak_2: Button = findViewById(R.id.dudak_2)
        val dudak_3: Button = findViewById(R.id.dudak_3)
        val dudak_4: Button = findViewById(R.id.dudak_4)


       //GÖZ FARINI AÇ
        button.setOnClickListener {

            Panels.visibility = View.INVISIBLE
            chip_contour1.visibility = View.INVISIBLE
            chip_contour2.visibility = View.INVISIBLE
            chip_contour3.visibility = View.INVISIBLE
            chip_contour4.visibility = View.INVISIBLE


            Panels_far.visibility = View.VISIBLE
            chip_eye1.visibility = View.VISIBLE
            chip_eye2.visibility = View.VISIBLE
            chip_eye3.visibility = View.VISIBLE
            chip_eye4.visibility = View.VISIBLE


            Panel_Ruj.visibility = View.INVISIBLE
            dudak_1.visibility = View.INVISIBLE
            dudak_2.visibility = View.INVISIBLE
            dudak_3.visibility = View.INVISIBLE
            dudak_4.visibility = View.INVISIBLE


        }

        //KONTUR'U AÇ
        button2.setOnClickListener {

            Panels.visibility = View.VISIBLE
            chip_contour1.visibility = View.VISIBLE
            chip_contour2.visibility = View.VISIBLE
            chip_contour3.visibility = View.VISIBLE
            chip_contour4.visibility = View.VISIBLE


            Panels_far.visibility = View.INVISIBLE
            chip_eye1.visibility = View.INVISIBLE
            chip_eye2.visibility = View.INVISIBLE
            chip_eye3.visibility = View.INVISIBLE
            chip_eye4.visibility = View.INVISIBLE


            Panel_Ruj.visibility = View.INVISIBLE
            dudak_1.visibility = View.INVISIBLE
            dudak_2.visibility = View.INVISIBLE
            dudak_3.visibility = View.INVISIBLE
            dudak_4.visibility = View.INVISIBLE


        }

        //RUJ'U AÇ
        button3.setOnClickListener {


            Panel_Ruj.visibility = View.VISIBLE
            dudak_1.visibility = View.VISIBLE
            dudak_2.visibility = View.VISIBLE
            dudak_3.visibility = View.VISIBLE
            dudak_4.visibility = View.VISIBLE


            Panels.visibility = View.INVISIBLE
            chip_contour1.visibility = View.INVISIBLE
            chip_contour2.visibility = View.INVISIBLE
            chip_contour3.visibility = View.INVISIBLE
            chip_contour4.visibility = View.INVISIBLE


            Panels_far.visibility = View.INVISIBLE
            chip_eye1.visibility = View.INVISIBLE
            chip_eye2.visibility = View.INVISIBLE
            chip_eye3.visibility = View.INVISIBLE
            chip_eye4.visibility = View.INVISIBLE
        }


        (face_view as AugmentedFaceFragment).setAugmentedFaceListener(this)
        contour_groups.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                chip_contour1.id -> changeContour(floatArrayOf(0.325f, 0.223f, 0.133f, 1f))
                chip_contour2.id -> changeContour(floatArrayOf(0.878f, 0f, 0f, 1f))
                chip_contour3.id -> changeContour(floatArrayOf(0.537f, 0.082f, 0.274f, 1f))
                chip_contour4.id -> changeContour(floatArrayOf(0.760f, 0.286f, 0.066f, 1f))
            }
        }

        eyes_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                chip_eye1.id -> changeEyeshadow(floatArrayOf(0.325f, 0.223f, 0.133f, 1f))
                chip_eye2.id -> changeEyeshadow(floatArrayOf(0.878f, 0f, 0f, 1f))
                chip_eye3.id -> changeEyeshadow(floatArrayOf(0.537f, 0.082f, 0.274f, 1f))
                chip_eye4.id -> changeEyeshadow(floatArrayOf(0.760f, 0.286f, 0.066f, 1f))

            }
        }

        dudaks_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                dudak_1.id -> changeDudakshadow(floatArrayOf(0.325f, 0.223f, 0.133f, 1f))
                dudak_2.id -> changeDudakshadow(floatArrayOf(0.878f, 0f, 0f, 1f))
                dudak_3.id -> changeDudakshadow(floatArrayOf(0.537f, 0.082f, 0.274f, 1f))
                dudak_4.id -> changeDudakshadow(floatArrayOf(0.760f, 0.286f, 0.066f, 1f))
            }
        }
    }


    override fun onFaceAdded(face: AugmentedFaceNode) {
        face.setFaceMeshTexture(arrayListOf("models/contour.png", "models/eyeShadow.png", "models/dudak.png"))
        face.setContourColor(contourColor)
        face.setEyeshadowColor(eyeshadowColor)
        face.setDudakColor(dudakColor)

    }

    override fun onFaceUpdate(face: AugmentedFaceNode) {
        if (contourChanged) {
            contourChanged = false
            face.setContourColor(contourColor)
        }
        if (eyeshadowChanged) {
            eyeshadowChanged = false
            face.setEyeshadowColor(eyeshadowColor)
        }
        if (dudakChanged) {
            dudakChanged = false
            face.setDudakColor(dudakColor)
        }
    }

    private fun changeEyeshadow(color: FloatArray) {
        eyeshadowColor = color
        eyeshadowChanged = true
    }

    private fun changeContour(color: FloatArray) {
        contourColor = color
        contourChanged = true
    }
    private fun changeDudakshadow(color: FloatArray) {
        dudakColor = color
        dudakChanged = true
    }

}