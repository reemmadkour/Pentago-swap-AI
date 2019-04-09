package student_player;

import java.util.ArrayList;

import boardgame.Board;
import boardgame.Move;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoBoardState.Piece;
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

public int evalMove(PentagoBoardState boardState, PentagoMove v,int me) {
	Piece mycolor= null;
	
	if (me==0) {mycolor=Piece.WHITE;}
	else {mycolor=Piece.BLACK;}
	
	PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
 	newBoard.processMove(v);
 	int totalscore=0;
	for(int x=0;x<6;x++) {
		
		int rowscore=0;
		int colscore=0;
		
		for(int y=0;y<6;y++) {
			if (boardState.getPieceAt(x, y)!=Piece.EMPTY) {
				if(boardState.getPieceAt(x, y)==mycolor) {
					rowscore=rowscore+1;
				}
				else {
					
					rowscore=rowscore-2;
					
				}
				
				if(boardState.getPieceAt(y, x)==mycolor) {
					colscore=colscore+1;
				}
				else {
					
					colscore=colscore-2;
					
				}
				
			}
		}
		
		totalscore=totalscore+rowscore+colscore;
	}
 	
	int[][] diag1 = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5}};
	int[][] diag2 = {{1,0},{2,1},{3,2},{4,3},{5,4}};
	int[][] diag3 = {{0,1},{1,2},{2,3},{3,4},{4,5}};
	int[][] diag4 = {{0,5},{1,4},{2,3},{3,2},{4,1},{5,0}};
	int[][] diag5 = {{0,4},{1,3},{2,2},{3,1},{4,0}};
	int[][] diag6 = {{1,5},{2,4},{3,3},{4,2},{5,1}};
	int done=0;
	int dtwo=0;
	int dthree=0;
	int dfour=0;
	int dfive=0;
	int dsix=0;
	for(int i=0;i<6;i++) {
		if (boardState.getPieceAt(diag1[i][0], diag1[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag1[i][0], diag1[i][1])==mycolor) {
				done=done+1;
			}
			else {
				
				done=done-2;
				
			}
	}
	}
	
	for(int i=0;i<6;i++) {
		if (boardState.getPieceAt(diag4[i][0], diag4[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag4[i][0], diag4[i][1])==mycolor) {
				dfour=dfour+1;
			}
			else {
				
				dfour=dfour-2;
				
			}
	}
	}
	
	
	
	for(int i=0;i<5;i++) {
		if (boardState.getPieceAt(diag2[i][0], diag2[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag2[i][0], diag2[i][1])==mycolor) {
				dtwo=dtwo+1;
			}
			else {
				
				dtwo=dtwo-2;
				
			}
	}
	}
	
	
	
	for(int i=0;i<5;i++) {
		if (boardState.getPieceAt(diag3[i][0], diag3[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag3[i][0], diag3[i][1])==mycolor) {
				dthree=dthree+1;
			}
			else {
				
				dthree=dthree-2;
				
			}
	}
	}
	
	for(int i=0;i<5;i++) {
		if (boardState.getPieceAt(diag5[i][0], diag5[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag5[i][0], diag5[i][1])==mycolor) {
				dfive=dfive+1;
			}
			else {
				
				dfive=dfive-2;
				
			}
	}
	}
	
	
	for(int i=0;i<5;i++) {
		if (boardState.getPieceAt(diag6[i][0], diag6[i][1])!=Piece.EMPTY) {
			if(boardState.getPieceAt(diag6[i][0], diag6[i][1])==mycolor) {
				dsix=dsix+1;
			}
			else {
				
				dsix=dsix-2;
				
			}
	}
	}
	
	totalscore= totalscore+done+dtwo+dthree+dfour+dfive+dsix;
	return totalscore;
	
	
	/*int xmove=v.getMoveCoord().getX();
	int ymove=v.getMoveCoord().getY();
	int score=0;
	
	for(int x=0;x<6;x++) {
		for(int y=0;y<6;y++) {
			if (boardState.getPieceAt(x, y)!=Piece.EMPTY) {
				if(boardState.getPieceAt(x, y)==mycolor) {
					if(x==xmove) {score=score+1;}
					if(y==ymove) {score=score+1;}
					if(Math.abs(x-xmove)==Math.abs(y-ymove)) {score=score+1;}
				}
				else {
					
					if(x==xmove) {score=score-2;}
					if(y==ymove) {score=score-2;}
					if(Math.abs(x-xmove)==Math.abs(y-ymove)) {score=score-2;}
					
				}
				
				
			}
				
			}
		}
	
	return score;*/
	}
	




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
        PentagoMove c6= new PentagoMove(2,3,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c7= new PentagoMove(2,2,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c8= new PentagoMove(3,3,Quadrant.TL,Quadrant.TR,me);
       
        PentagoMove c9= new PentagoMove(0,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c10= new PentagoMove(5,5,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c11= new PentagoMove(0,2,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c12= new PentagoMove(0,3,Quadrant.TL,Quadrant.TR,me);
        
        PentagoMove c13= new PentagoMove(0,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c14= new PentagoMove(2,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c15= new PentagoMove(3,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c16= new PentagoMove(5,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c17= new PentagoMove(5,3,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c18= new PentagoMove(5,0,Quadrant.TL,Quadrant.TR,me);
        PentagoMove c19= new PentagoMove(0,5,Quadrant.TL,Quadrant.TR,me);
        
        
        
        
        if(boardState.isLegal(c1)) {return c1;}
       // else if (boardState.isLegal(c2)) {return c2;}
        else if (boardState.isLegal(c3)) {return c3;}
        //else if (boardState.isLegal(c4)) {return c4;}
        else if(boardState.getTurnNumber()<9) { 
        	
        	if(boardState.isLegal(c5)) {return c5;}
        	//else if (boardState.isLegal(c6)) {return c6;}
        	//else if (boardState.isLegal(c7)) {return c7;}
        	//else if (boardState.isLegal(c8)) {return c8;}
        	
        	//else if (boardState.isLegal(c9)) {return c9;}
        	
        	
        	ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
        	int BestScore=Integer.MIN_VALUE;
        	
        	PentagoMove initmove=legalmoves.get(0);
         	moveandscore bestab = new moveandscore();
            bestab.setMove(initmove);
        
        	
        	for (PentagoMove v: legalmoves) {
        		int score=evalMove(boardState,v,me);
        		if (score>BestScore) {
        			bestab.setMove(v);
        			BestScore=score;}
        			//PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
                 	
                //	newBoard.processMove(v);
        			
        			
        			
        		}
        //	}
        	return bestab.move;  }
        /*	else if (boardState.isLegal(c10)) {return c10;}
        	else if (boardState.isLegal(c11)) {return c11;}
        	else if (boardState.isLegal(c12)) {return c12;}
        	
        	else if (boardState.isLegal(c13)) {return c13;}
        	else if (boardState.isLegal(c14)) {return c14;}
        	else if (boardState.isLegal(c15)) {return c15;}
        	else if (boardState.isLegal(c16)) {return c16;}
        	else if (boardState.isLegal(c17)) {return c17;}
        	else if (boardState.isLegal(c18)) {return c18;}
        	else if (boardState.isLegal(c19)) {return c19;}*/
        	
        	
        	
        	//else return boardState.getRandomMove();}
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