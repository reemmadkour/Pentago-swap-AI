package student_player;

import java.util.ArrayList;

import boardgame.Board;
import boardgame.Move;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260726480");
    }
public class moveandscore{
	public PentagoMove move;
	public int score;
	/*public moveandscore(PentagoMove move, int score) {
		this.move=move;
		this.score=score;
	}*/
	
	public void setMove(PentagoMove move) {
		this.move=move;
	}
	public void setScore(int score) {
		this.score=score;
	}
}
    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move chooseMove(PentagoBoardState boardState) {
        // You probably will make separate functions in MyTools.
        // For example, maybe you'll need to load some pre-processed best opening
        // strategies...
        MyTools.getSomething();
        int me= boardState.getTurnPlayer();
        
        moveandscore ans= minimax(boardState,me,me);
        return ans.move;
       	
        
      //  Move myMove = boardState.getRandomMove();
      /*  ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
        int BestScore= - (Integer.MAX_VALUE);
        for(Move v: legalmoves) {
        	score= minimax
        	*/
        	
       
    }
    
    
    
    public moveandscore minimax(PentagoBoardState boardState,int player,int me) {
    	ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
    	int BestScore;
    	PentagoMove initmove=null;
   	moveandscore best = new moveandscore();
    
    	best.setMove(initmove);
    
        if (player==me) {  BestScore= - (Integer.MAX_VALUE);
        }
        else{ BestScore=  (Integer.MAX_VALUE);}
    	if(boardState.getWinner()!=Board.NOBODY) { 
    		best.setScore(BestScore);
    		if (boardState.getWinner()==me) {
    			BestScore=1000 ;
    			best.setScore(BestScore);	
    			
    		}
    		else if (boardState.getWinner()==Board.DRAW){
    			BestScore= 0;
    			best.setScore(BestScore);
    		}
    		else {
    			BestScore =-1000;
    			best.setScore(BestScore);
    		}
    	}
    	
    else {
       
   
        for(PentagoMove v: legalmoves) {
         	PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
         	newBoard.processMove(v);
         	if(player==0) {player=1;}
         	else {player=1;}
         	int score= minimax(newBoard,player,me).score;
         	if(player==me) {
         		if(score>best.score) {
         			best.setMove(v);
         			best.setScore(score);
         		}
         	}
         	else {
         		if(score<best.score) {
         			best.setMove(v);
         			best.setScore(score);
         		}
         	}
         	
        }
         }

         // Return your move to be processed by the server.
         return best;
    
    }
}