package student_player;

import java.util.ArrayList;

import boardgame.Board;
import boardgame.Move;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoBoardState.Quadrant;
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
        System.out.println("init");
        PentagoMove c1= new PentagoMove(1,1,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c2= new PentagoMove(1,4,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c3= new PentagoMove(4,1,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c4= new PentagoMove(4,4,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c5= new PentagoMove(3,2,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c6= new PentagoMove(3,2,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c7= new PentagoMove(2,2,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c8= new PentagoMove(3,3,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c9= new PentagoMove(0,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c10= new PentagoMove(5,5,Quadrant.TL,Quadrant.TR,me);
        
        if(boardState.isLegal(c1)) {return c1;}
        else if (boardState.isLegal(c2)) {return c2;}
        else if (boardState.isLegal(c3)) {return c3;}
        else if (boardState.isLegal(c4)) {return c4;}
        else if(boardState.getTurnNumber()<9) { 
        	if(boardState.isLegal(c5)) {return c5;}
        	else if (boardState.isLegal(c6)) {return c6;}
        	else if (boardState.isLegal(c7)) {return c7;}
        	else if (boardState.isLegal(c8)) {return c8;}
        	else if (boardState.isLegal(c9)) {return c9;}
        	else if (boardState.isLegal(c10)) {return c10;}
        	
        	else return boardState.getRandomMove();}
        else {
        moveandscore ans= minimax(boardState,me,me,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("gotominin");
        return ans.move;
        }
    }
      //  Move myMove = boardState.getRandomMove();
      /*  ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
        int BestScore= - (Integer.MAX_VALUE);
        for(Move v: legalmoves) {
        	score= minimax
        	*/
        	
       
    
    
    
    
    public moveandscore minimax(PentagoBoardState boardState,int player,int me,int alpha,int beta) {
    	
    	ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
    	int BestScore;
    	PentagoMove initmove=null;
     	moveandscore bestab = new moveandscore();
    
    	bestab.setMove(initmove);
    
        if (player==me) {  BestScore= -(Integer.MAX_VALUE);
                                                            }
        else{ BestScore=  (Integer.MAX_VALUE);}
        
        
    	if(boardState.getWinner()!=Board.NOBODY) { 
    	//	System.out.println("reached leaf");
    		bestab.setScore(BestScore);
    		
    		if (boardState.getWinner()==me) {
    			BestScore=1000 ;
    			bestab.setScore(BestScore);	
    			
    		}
    		else if (boardState.getWinner()==Board.DRAW){
    			BestScore= 0;
    			bestab.setScore(BestScore);
    		}
    		else {
    			BestScore =-1000;
    			bestab.setScore(BestScore);
    		}
    	}
    	
    else {
       
   
        for(PentagoMove v: legalmoves) {
         	
        	PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
         	
        	newBoard.processMove(v);
         	
        	int tempplayer=player;
         
        	if(player==0) {player=1;}
         	else {player=0;}
         	
        	int score= minimax(newBoard,player,me,alpha,beta).score;
         	
        	if(tempplayer==me) {
         		
        		if(score>alpha) {
         			alpha=score;
         			// if (alpha >= beta) break; 
         			bestab.setMove(v);
         			bestab.setScore(score);
         		}
         	}
         	
        	else {
         		if(score<beta) {
         			beta=score;
         			// if (alpha >= beta) break; 
         			bestab.setMove(v);
         			bestab.setScore(score);
         		}
         	}
         	 if (alpha >= beta) break; 
         	
        }
         }
    	//moveandscore bestab = new moveandscore();
    	//bestab.setMove(bestab.move);
    	if(player==me) {bestab.setScore(alpha);}
    	else {bestab.setScore(beta);
    	}
    	
         // Return your move to be processed by the server.
         return bestab;
    
    }
}