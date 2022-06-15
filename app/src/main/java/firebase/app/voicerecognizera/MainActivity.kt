package firebase.app.voicerecognizera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import firebase.app.voicerecognizera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intentRecognizer = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL
        ,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)

        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(object : RecognitionListener{
            override fun onReadyForSpeech(p0: Bundle?) {

            }

            override fun onBeginningOfSpeech() {

            }

            override fun onRmsChanged(p0: Float) {

            }

            override fun onBufferReceived(p0: ByteArray?) {

            }

            override fun onEndOfSpeech() {

            }

            override fun onError(p0: Int) {

            }

            override fun onResults(p0: Bundle?) {
                var matches:ArrayList<String> = p0?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                var string = ""
                if (!matches.isNullOrEmpty()){
                    string = matches.get(0)
                    binding.txtView.text = string

                }
            }

            override fun onPartialResults(p0: Bundle?) {

            }

            override fun onEvent(p0: Int, p1: Bundle?) {

            }

        })

        binding.btnStart.setOnClickListener{
        speechRecognizer.startListening(intentRecognizer)
        }
        binding.btnStop.setOnClickListener{
            speechRecognizer.stopListening()

        }




    }
}