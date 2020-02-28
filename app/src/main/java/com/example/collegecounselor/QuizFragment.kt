package com.example.collegecounselor


import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentLoginBinding
import com.example.collegecounselor.databinding.FragmentQuizBinding
import kotlinx.android.synthetic.main.fragment_quiz.*

/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {
    lateinit var binding: FragmentQuizBinding
    lateinit var CurrentQuestion: Question
    private var questionIndex = 0
    val maxNumberOfQuestion = 10
    private var Score = 0
    lateinit var Answers: ArrayList<String>
    lateinit var selectedAnswers: String
    var questionNumber: String = "0"
    var Scoreall: Int = 0
    var textscore: String = "0"
    var usedhint: Int = 0
    var TotalHint: String = "0"
    var lavel = 0
    var questions = ArrayList<Question>()

    lateinit var sharedPreferences: SharedPreferences

    private fun check(){
        if (lavel==1){
             questions = arrayListOf<Question>(
                Question(
                    "1Which is the Independence day of Bangladesh?",
                    arrayListOf("26 March", "21 Feb", "14th April", "16 December")
                ),
                Question(
                    "1Who is the first man landed on moon?",
                    arrayListOf("Neil Armstrong", "Edwin Aldrin", "Michael Collins", "Yuri Gregory")
                ),
                Question(
                    "1Socrates is best known for - ",
                    arrayListOf("Philosophy", "Mathmetics", "Physiology", "Astrology")
                ),
                Question(
                    "1How many states does USA have? ",
                    arrayListOf("50", "45", "55", "49")
                ),
                Question(
                    "1Which is not an Europian Country? ",
                    arrayListOf("Combodia", "Estonia", "Lithunia", "Moldova")
                ),
                Question(
                    "1Who is the first President of USA? ",
                    arrayListOf(
                        "George Washington",
                        "William Henry Harrison",
                        "Abraham Lincoln",
                        "Franklin D. Roosevelt"
                    )
                ),
                Question(
                    "1Which one is the largest ocean? ",
                    arrayListOf("Pacific", "Atlantic", "Mediterian", "Arctic")
                ),
                Question(
                    "1What country has a town named Marathon? ",
                    arrayListOf("USA", "GREECE", "ITALY", "FRANCE")
                ),
                Question(
                    "1What well-known mountain pass connects Pakistan and Afghanistan? ",
                    arrayListOf("Khyber Pass", "Malakand Pass", "Ahmad Pass", "Shandar Pass")
                ),
                Question(
                    "1What country was formerly known as Ceylon?",
                    arrayListOf("Sri Lanka", "Sweden", "Vietnam", "Switzerland")
                )
            )
        }
        if (lavel==2){
            questions = arrayListOf<Question>(
                Question(
                    "2In which view Headers and Footers are visible?",
                    arrayListOf("Print Layout View", "Normal View", "Page Layout Viewl", "Draft View")
                ),
                Question(
                    "2The process of removing unwanted part of an image is called?",
                    arrayListOf("Cropping", "Hiding", "Bordering", "Cutting")
                ),
                Question(
                    "2To apply center alignment to a paragraph we can press",
                    arrayListOf("Ctrl + E", "Ctrl + C", "Ctrl + C + A", "Ctrl + S")
                ),
                Question(
                    "2The space left between the margin and the start of a paragraph is called?",
                    arrayListOf("Indentation", "Spacing", "Gutter", "Alignment")
                ),
                Question(
                    "2Text-styling feature of MS word is? ",
                    arrayListOf("WordArt", "WordColor", "WordFont", "WordFill")
                ),
                Question(
                    "2fWhich items are placed at the end of a document? ",
                    arrayListOf(
                        "End Note", "Footer","Foot Note", "eader"
                    )
                ),
                Question(
                    "2To change line height to 1.5 we use shortcut key : ",
                    arrayListOf("Ctrl + 5", "Ctrl + 2", "Ctrl+1", "Ctrl + 3")
                ),
                Question(
                    "2A number of letter that appears little above the normal text is called : ",
                    arrayListOf("Superscript", "GREECESubscript", "Supertext", "Toptext")
                ),
                Question(
                    "2A number of letter that appears little below the normal text is called :",
                    arrayListOf("Subscript", "Superscript", "Supertext", "Toptext")
                ),
                Question(
                    "2e can insert a page number at",
                    arrayListOf("Header and Footer Both", "Footer", "Header", "None")
                )
            )
        }

        if (lavel==3){
            questions = arrayListOf<Question>(
                Question(
                    " Bangladesh?",
                    arrayListOf("3 26 March", "21 Feb", "14th April", "16 December")
                ),
                Question(
                    " moon?",
                    arrayListOf("3Neil Armstrong", "Edwin Aldrin", "Michael Collins", "Yuri Gregory")
                ),
                Question(
                    "3 best  - ",
                    arrayListOf("3Philosophy", "Mathmetics", "Physiology", "Astrology")
                ),
                Question(
                    "3USA have? ",
                    arrayListOf("50", "45", "55", "49")
                ),
                Question(
                    "3Europian Country? ",
                    arrayListOf("Combodia", "Estonia", "Lithunia", "Moldova")
                ),
                Question(
                    "3first President? ",
                    arrayListOf(
                        "George Washington",
                        "William Henry Harrison",
                        "Abraham Lincoln",
                        "Franklin D. Roosevelt"
                    )
                ),
                Question(
                    "3Which one is the largest ocean? ",
                    arrayListOf("Pacific", "Atlantic", "Mediterian", "Arctic")
                ),
                Question(
                    "3What country has a town named Marathon? ",
                    arrayListOf("USA", "GREECE", "ITALY", "FRANCE")
                ),
                Question(
                    "3What well-known mountain pass connects Pakistan and Afghanistan? ",
                    arrayListOf("Khyber Pass", "Malakand Pass", "Ahmad Pass", "Shandar Pass")
                ),
                Question(
                    "3What country was formerly known as Ceylon?",
                    arrayListOf("Sri Lanka", "Sweden", "Vietnam", "Switzerland")
                )
            )
        }
        if (lavel==4){
            questions = arrayListOf<Question>(
                Question(
                    "1Which is the Independence day of Bangladesh?",
                    arrayListOf("26 March", "21 Feb", "14th April", "16 December")
                ),
                Question(
                    "1Who is the first man landed on moon?",
                    arrayListOf("Neil Armstrong", "Edwin Aldrin", "Michael Collins", "Yuri Gregory")
                ),
                Question(
                    "1Socrates is best known for - ",
                    arrayListOf("Philosophy", "Mathmetics", "Physiology", "Astrology")
                ),
                Question(
                    "1How many states does USA have? ",
                    arrayListOf("50", "45", "55", "49")
                ),
                Question(
                    "1Which is not an Europian Country? ",
                    arrayListOf("Combodia", "Estonia", "Lithunia", "Moldova")
                ),
                Question(
                    "1Who is the first President of USA? ",
                    arrayListOf(
                        "George Washington",
                        "William Henry Harrison",
                        "Abraham Lincoln",
                        "Franklin D. Roosevelt"
                    )
                ),
                Question(
                    "1Which one is the largest ocean? ",
                    arrayListOf("Pacific", "Atlantic", "Mediterian", "Arctic")
                ),
                Question(
                    "1What country has a town named Marathon? ",
                    arrayListOf("USA", "GREECE", "ITALY", "FRANCE")
                ),
                Question(
                    "1What well-known mountain pass connects Pakistan and Afghanistan? ",
                    arrayListOf("Khyber Pass", "Malakand Pass", "Ahmad Pass", "Shandar Pass")
                ),
                Question(
                    "1What country was formerly known as Ceylon?",
                    arrayListOf("Sri Lanka", "Sweden", "Vietnam", "Switzerland")
                )
            )
        }
    }




    private fun SetQuestion() {
        binding.hintBut.visibility = if (view?.visibility == View.INVISIBLE) {
            View.VISIBLE
        } else {
            View.VISIBLE
        }

        binding.hintBut.visibility = if (usedhint == 2) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
        binding.Button1.setBackgroundResource(R.drawable.btnyellow);
        binding.Button2.setBackgroundResource(R.drawable.btnyellow);
        binding.Button3.setBackgroundResource(R.drawable.btnyellow);
        binding.Button4.setBackgroundResource(R.drawable.btnyellow);


        questionNumber = (questionIndex + 1).toString()

        CurrentQuestion = questions[questionIndex]
        Answers = ArrayList(CurrentQuestion.theAnswer)
        Answers.shuffle()

        Log.d("AnswerGroup", Answers[0] + " " + Answers[1] + " " + Answers[2] + " " + Answers[3])
        Log.d("Answercurrect", CurrentQuestion.theAnswer[0])
    }


    private fun randomQuestion() {
        questions.shuffle()
        SetQuestion()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_quiz, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)
        arguments?.let {
            val args = QuizFragmentArgs.fromBundle(it)
            lavel = args.unlocscore.toInt()

            Log.d(" value :",lavel .toString())
        }

        sharedPreferences = activity!!.getSharedPreferences("SP_GAME", MODE_PRIVATE)

        check()
        randomQuestion()
        binding.quiz = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        arguments?.let {
            val args = QuizFragmentArgs.fromBundle(it)
            lavel = args.unlocscore.toInt()

            Log.d(" value :",lavel .toString())
        }





        Button_1.setOnClickListener {
            chackAnswer(Button_1.text.toString())
        }
        Button_2.setOnClickListener {
            chackAnswer(Button_2.text.toString())
        }
        Button_3.setOnClickListener {
            chackAnswer(Button_3.text.toString())
        }
        Button_4.setOnClickListener {
            chackAnswer(Button_4.text.toString())
        }

        hint_but.setOnClickListener {

            // chackAnswer(CurrentQuestion.theAnswer[0].toString())
//            Log.d("Button1 value :", Button_1.text.toString())
//            Log.d("Button2 value :", Button_2.text.toString())
            if (CurrentQuestion.theAnswer[2] == Button_1.text.toString() || CurrentQuestion.theAnswer[3] == Button_1.text.toString()) {
                Button_1.setBackgroundResource(R.color.colorAccent)
            }
            if (CurrentQuestion.theAnswer[2] == Button_2.text.toString() || CurrentQuestion.theAnswer[3] == Button_2.text.toString()) {
                Button_2.setBackgroundResource(R.color.colorAccent)
            }
            if (CurrentQuestion.theAnswer[2] == Button_3.text.toString() || CurrentQuestion.theAnswer[3] == Button_3.text.toString()) {
                Button_3.setBackgroundResource(R.color.colorAccent)
            }
            if (CurrentQuestion.theAnswer[2] == Button_4.text.toString() || CurrentQuestion.theAnswer[3] == Button_4.text.toString()) {
                Button_4.setBackgroundResource(R.color.colorAccent)
            }
            Log.d("Button3 value :", CurrentQuestion.theAnswer[2].toString())
            Log.d("Button4 value :", CurrentQuestion.theAnswer[3].toString())
            hint_but.visibility = if (view?.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }
            usedhint++

            TotalHint = usedhint.toString()
        }

    }

    private fun chackAnswer(Answer: String) {
        if (Answer.equals(CurrentQuestion.theAnswer[0])) {
            Scoreall = (Scoreall + 10)
            textscore = (Scoreall).toString()
            Score += 1
        } else {
            Scoreall = (Scoreall - 5)
            textscore = (Scoreall).toString()
        }
        questionIndex++
        if (questionIndex < maxNumberOfQuestion) {
            SetQuestion()
            binding.invalidateAll()
        } else {
            getScore()
        }

        var editor = sharedPreferences.edit()
        editor.putString("TEXT_SCORE", textscore)
        editor.commit()
    }


    private fun getScore() {
        Log.d("SCORE", Score.toString())
        if (Score >= 3) {
             Navigation.findNavController(view!!).navigate(R.id.action_quizFragment_to_wonFragment)
//            val activity = QuizFragmentDirections.actionQuizFragmentToUnlockFragment(Score)
//            view!!.findNavController().navigate(activity)

        } else {
            Navigation.findNavController(view!!).navigate(R.id.action_quizFragment_to_lossFragment)
        }

    }


}
