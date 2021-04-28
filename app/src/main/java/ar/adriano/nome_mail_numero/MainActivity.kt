package ar.adriano.nome_mail_numero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun MensageSend(view: View) {

        val editTextNome = findViewById<EditText>(R.id.editTextTextPersonName)
        val Nome = editTextNome.text.toString()
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val mail = editTextEmail.text.toString()
        val editTextNumero = findViewById<EditText>(R.id.editTextPhone)
        val Numero = editTextNumero.text.toString()

        if(Nome.isBlank() || mail.isBlank()||Numero.isBlank()){
            editTextNome.error = getString(R.string.mensagem_vazia)
            return
        }

        val intent = Intent(this,ReceberSmS::class.java)
        intent.putExtra(Companion.iNFOnOME, Nome)
        startActivity(intent)

        val intent_A = Intent(this,ReceberSmS::class.java)
        intent.putExtra(Companion.MailPessao,mail)
        startActivity(intent)

        val intent_B = Intent(this,ReceberSmS::class.java)
        intent.putExtra(Companion.NumeroPessoa,Numero)
        startActivity(intent)
    }

    companion object {
        const val iNFOnOME = "NOME"
        const val MailPessao = "mail"
        const val NumeroPessoa = "NumeroPessoa"
    }
}