package ng.com.nokt.xando

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var activePlayer = 1
    var cellList= mutableListOf<Int>()
    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()

    fun btnClicked(view:View){
        var cellSelected = 0
        val buttonClicked = view as Button

        when(buttonClicked.id){
            R.id.btn1->cellSelected=1
            R.id.btn2->cellSelected=2
            R.id.btn3->cellSelected=3
            R.id.btn4->cellSelected=4
            R.id.btn5->cellSelected=5
            R.id.btn6->cellSelected=6
            R.id.btn7->cellSelected=7
            R.id.btn8->cellSelected=8
            R.id.btn9->cellSelected=9
        }
        gameLogic(cellSelected, buttonClicked)
        buttonsDisabled(cellSelected)
        gameOver()

    }

    fun gameLogic(cellSelected:Int, buttonSelected:Button){
        if(activePlayer == 1){
            buttonSelected.text = "X"
            buttonSelected.isEnabled = false
            playerOne.add(cellSelected)
            buttonSelected.setBackgroundColor(Color.GREEN)
            buttonSelected.setTextSize(24f)
            checkWinner()
            activePlayer = 2
        }else{
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.BLUE)
            buttonSelected.setTextColor(Color.WHITE)
            buttonSelected.setTextSize(24f)
            buttonSelected.isEnabled = false
            playerTwo.add(cellSelected)
            checkWinner()
            activePlayer = 1
        }
    }

    fun checkWinner(){
        var winner = 0
        if(playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)){
            winner = 1
        }
        if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)){
            winner = 1
        }
        if(playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)){
            winner = 1
        }
        if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)){
            winner = 1
        }
        if(playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)){
            winner = 1
        }
        if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)){
            winner = 1
        }
        if(playerOne.contains(7) && playerOne.contains(5) && playerOne.contains(3)){
            winner = 1
        }
        if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)){
            winner = 1
        }

        //Player 2 conditions

        if(playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)){
            winner = 2
        }
        if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)){
            winner = 2
        }
        if(playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)){
            winner = 2
        }
        if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)){
            winner = 2
        }
        if(playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)){
            winner = 2
        }
        if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)){
            winner = 2
        }
        if(playerTwo.contains(7) && playerTwo.contains(5) && playerTwo.contains(3)){
            winner = 2
        }
        if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)){
            winner = 2
        }

        if(winner != 0){
            if(winner == 1){
                Toast.makeText(this, "Player One Won!!", Toast.LENGTH_LONG).show();
                winDialog("Player One")
            }else if(winner ==2 ){
                Toast.makeText(this, "Player Two Won!!", Toast.LENGTH_LONG).show();
                winDialog("Player Two")
            }
        }
    }

    fun winDialog(winner:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("${winner} Wins!")
        builder.setMessage("Do you want to play again?")
        builder.setIcon(R.drawable.ic_winner)
        builder.setPositiveButton("Yes!"){ _, _ ->
            finish()
            startActivity(intent)
        }
        builder.setNegativeButton("No"){ dialogInterface, _ ->
            dialogInterface.dismiss()
            finish()
        }

        val alertDialog:AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

   private fun gameOver(){
       if (cellList.size == 9){
           AlertDialog.Builder(this).setTitle("Game Over!").setIcon(R.drawable.ic_gameover).setMessage("Do you want to play again?")
               .setNegativeButton("No"){_,_ ->
                   finish()
               }.setPositiveButton("Yes"){_,_ ->
                   finish()
                   startActivity(intent)
               }.setCancelable(false).create().show()
       }

    }

    private fun buttonsDisabled(cellSelected: Int){
        if (!cellList.contains(cellSelected)){
            cellList.add(cellSelected)
        }

    }
}