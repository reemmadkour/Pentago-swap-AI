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
/**
 * @author reemm
 *
 */
public class StudentPlayer extends PentagoPlayer {

    public StudentPlayer() {
        super("260726480");
    }

    
    /**
     * @author reem Madkour
     * this class represents objects that have both a move and it's associated score.
     *
     */
    public class moveandscore{
	public PentagoMove move;
	public int score;
	
	public void setMove(PentagoMove move) {
		this.move=move;
	}
	public void setScore(int score) {
		this.score=score;
	}
}

    
    
    /**
     * @param PentagoBoardState boardState: current board state
     * @param Move v : given move to evaluate benefit from
     * @param int me : identifier for my player
     * @return move evaluation
     * 
     * This method simulates the application of the given move on the given board state and assesses its 
     * benefit for 'me'. it does this through evaluating how many pieces of my color are in a row, column and diagonal
     * after the application of the move.
     */
    public int evalMove(PentagoBoardState boardState, PentagoMove v,int me) {
	Piece mycolor= null;
	me=boardState.getTurnPlayer();
	if (me==0) {mycolor=Piece.WHITE;}
	else {mycolor=Piece.BLACK;}
	
	PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
 	newBoard.processMove(v);
 	int totalscore=0;
 	
 	//if game over, evaluation drastically increases for me
 	if(newBoard.getWinner()!=Board.NOBODY) { 
    	
    		
    		
    		if (newBoard.getWinner()==me) {
    			totalscore=100;
    			return totalscore;
    		}
    		else if (newBoard.getWinner()==Board.DRAW){
    		totalscore=0;
    		return totalscore;
    		}
    		else {
    			totalscore=-100;
        		return totalscore;
    		}
    		
    		
    	}
    	
 	
 	//checking row and column score 
 	
	for(int x=0;x<6;x++) {
		
		int rowscore=0;
		int colscore=0;
		
		for(int y=0;y<6;y++) {
			if (newBoard.getPieceAt(x, y)!=Piece.EMPTY) {
				if(newBoard.getPieceAt(x, y)==mycolor) {
					if((Math.abs(x-y))==1) {rowscore=rowscore+2;} //if the peice is consecutive 
					
					else {	rowscore=rowscore+1;} //if piece in same row but not consecutive
				}
				else {
					
					rowscore=rowscore-10;  //if opponent piece in the same row 
					
				}
				
				if(newBoard.getPieceAt(y, x)==mycolor) {
					if((Math.abs(x-y))==1) {colscore=colscore+2;}  //if the piece is consecutive 
					
					else{colscore=colscore+1;} //if piece in same column but not consecutive
				}
				else {
					
					colscore=colscore-10;  //if opponent piece in the same column
					
				}
				
			}
		}
		
		totalscore=totalscore+rowscore+colscore;   //add up the score
	}
	
	//list out all winning possible diagonals
 	
	int[][] diag1 = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5}};
	int[][] diag2 = {{1,0},{2,1},{3,2},{4,3},{5,4}};
	int[][] diag3 = {{0,1},{1,2},{2,3},{3,4},{4,5}};
	int[][] diag4 = {{0,5},{1,4},{2,3},{3,2},{4,1},{5,0}};
	int[][] diag5 = {{0,4},{1,3},{2,2},{3,1},{4,0}};
	int[][] diag6 = {{1,5},{2,4},{3,3},{4,2},{5,1}};
	//scores counters for diagonals
	int done=0;
	int dtwo=0;
	int dthree=0;
	int dfour=0;
	int dfive=0;
	int dsix=0;
	
	//consecutiveness indicators
	int consec=0;
	int consec2=0;
	int consec3=0;
	int consec4=0;
	int consec5=0;
	int consec6=0;
	
	for(int i=0;i<6;i++) {
		
		if (newBoard.getPieceAt(diag1[i][0], diag1[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag1[i][0], diag1[i][1])==mycolor) {
				done=done+1;
				if(consec==1) {done=done+1;}   //additional point if consecutive
				consec=1;
			}
			else {
				if(!(i==5||i==0)) {
				done=done-10; }  //opponent piece in diagonal
				consec=0;  //break consecutivity
				
			}
	}
		else{consec=0;}
	}
	
	//same procedure for all the diagonals
	
	for(int i=0;i<6;i++) {
		
		if (newBoard.getPieceAt(diag4[i][0], diag4[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag4[i][0], diag4[i][1])==mycolor) {
				dfour=dfour+1;
				if(consec4==1) {dfour=dfour+1;}
				consec4=1;
			}
			else {
				if(!(i==5||i==0)) {
				dfour=dfour-10;
				}
				consec4=0;
			}
	}
		else{consec4=0;}
	}
	
	
	
	for(int i=0;i<5;i++) {
		if (newBoard.getPieceAt(diag2[i][0], diag2[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag2[i][0], diag2[i][1])==mycolor) {
				dtwo=dtwo+1;
				if(consec2==1) {dtwo=dtwo+1;}
				consec2=1;
			}
			else {
				
				dtwo=dtwo-10;
				consec2=0;
				
			}
	}
		else{consec2=0;}
	}
	
	
	
	for(int i=0;i<5;i++) {
		if (newBoard.getPieceAt(diag3[i][0], diag3[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag3[i][0], diag3[i][1])==mycolor) {
				dthree=dthree+1;
				if(consec3==1) {dthree=dthree+1;}
				consec3=1;
			}
			else {
				
				dthree=dthree-10;
				consec3=0;
				
			}
	}
		else{consec3=0;}
	}
	
	for(int i=0;i<5;i++) {
		if (newBoard.getPieceAt(diag5[i][0], diag5[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag5[i][0], diag5[i][1])==mycolor) {
				dfive=dfive+1;
				if(consec5==1) {dfive=dfive+1;}
				consec5=1;
			}
			else {
				
				dfive=dfive-10;
				consec5=0;
				
			}
	}
		
		else{consec5=0;}
	}
	
	
	for(int i=0;i<5;i++) {
		if (newBoard.getPieceAt(diag6[i][0], diag6[i][1])!=Piece.EMPTY) {
			if(newBoard.getPieceAt(diag6[i][0], diag6[i][1])==mycolor) {
				dsix=dsix+1;
				if(consec6==1) {dsix=dsix+1;}
				consec6=1;
			}
			else {
				
				dsix=dsix-10;
				consec6=0;
				
			}
	}
		else {consec6=0;}
	}
	
	
	//add up total score
	totalscore= totalscore+done+dtwo+dthree+dfour+dfive+dsix;
	return totalscore;
	

	}
	




    
    /* (non-Javadoc)
     * @see pentago_swap.PentagoPlayer#chooseMove(pentago_swap.PentagoBoardState)
     * customized move choosing for my player
     * 
     */
    public Move chooseMove(PentagoBoardState boardState) {
        
      //finding what player i am
        int me= boardState.getTurnPlayer();

        //initial move
        PentagoMove c1= new PentagoMove(1,1,Quadrant.TL,Quadrant.TR,me);
    
        if(boardState.isLegal(c1)&&(boardState.getTurnNumber()<4)) {return c1;}
      
        
        //if still between first and 14th turn dont call minmax yet,
        //just call eval function on possible next moves
        else if(boardState.getTurnNumber()<14) { 
    
        	
        	
        	ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
        	int BestScore=Integer.MIN_VALUE;
        	
        	PentagoMove initmove=legalmoves.get(0);
         	moveandscore bestab = new moveandscore();
            bestab.setMove(initmove);
        
        	//find best eval score for all the possible legal moves
        	for (PentagoMove v: legalmoves) {
        		int score=evalMove(boardState,v,me);
        		if (score>BestScore) {
        			bestab.setMove(v);
        			BestScore=score;}
        	}
        		
        		      			
       return bestab.move;  }
      
        //otherwise, if we are past the 14th turn, call minimax to completion ( no depth limit)
        else {
        moveandscore ans= minimax(boardState,me,me,Integer.MIN_VALUE,Integer.MAX_VALUE);
      
        return ans.move;
        }
    }
      
        	
       
    
    
    
    
    /**
     * @param boardState
     * @param player: current recursive call player
     * @param me : who the maximizing player is, doesnt change throughout the full call
     * @param alpha :alpha
     * @param beta :beta
     * 
     * this method performs a full minimax with alpha-beta pruning without a depth limit
     * @return
     */
    public moveandscore minimax(PentagoBoardState boardState,int player,int me,int alpha,int beta) {
    	
    	//find opponent number
    	int opp;
    	if(me==0) {opp=1;}
     	else {opp=0;}
    	
    	//get possible next moves
    	ArrayList<PentagoMove> legalmoves = boardState.getAllLegalMoves();
    	int BestScore;
    	PentagoMove initmove=null;
     	moveandscore bestab = new moveandscore();
    
    	bestab.setMove(initmove);
    
      
    	BestScore=0;
      
    	
    	//if we reached a leaf, ie : game over, return the value of the result.
    	if(boardState.getWinner()!=Board.NOBODY) { 
    
    		bestab.setScore(BestScore);
    		
    		if (boardState.getWinner()==me) {
    			BestScore=10 ;
    			bestab.setScore(BestScore);	
    			
    		}
    		else if (boardState.getWinner()==Board.DRAW){
    			BestScore= 0;
    			bestab.setScore(BestScore);
    		}
    		else {
    			BestScore =-10;
    			bestab.setScore(BestScore);
    		}
    		
    		 return bestab;
    	}
    
    	
    	//if we are not at a leaf, we call minimax for the next player for each move
    else {
       
    
        for(PentagoMove v: legalmoves) {
         	
        	PentagoBoardState newBoard= (PentagoBoardState) boardState.clone();
         	
        	newBoard.processMove(v);
      	
        	// if the current player is me, maximizing is needed on the score from the minimizer
        	if(player==me) {
        		
        		//get minimizer score
        		int score= minimax(newBoard,opp,me,alpha,beta).score;
        		
        		//only update alpha if the score is greater, otherwise everything stays the same
        		if(score>alpha) {
         			alpha=score;
         			
         			bestab.setMove(v);
         			bestab.setScore(score);
         		}
         	}
         	
        	//if the current player is the opponent, then we are in the mnimizer and wil take the smallest score
        	//from the mazimizer
        	else {
        		int score= minimax(newBoard,me,me,alpha,beta).score;
        		
        		//only update if the new score is less than beta
         		if(score<beta) {
         			beta=score;
         			
         			bestab.setMove(v);
         			bestab.setScore(score);
         		}
         	}
        	
        	//alpha cutoff, this means we can't do better so we stop searching
         	 if (alpha >= beta) break; 
         	
        }
         }
    	
    	
    	
    	if(player==me) {bestab.setScore(alpha);}
    	else {bestab.setScore(beta);
    	}
    	
       
         return bestab;
    
    }
}