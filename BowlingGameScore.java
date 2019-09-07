/*-------------------------------------------------------------------------------
			
			Source Name:      BowlingGameScore.java
            Work:             Compute BowlingScore and show who is the winner.
         	Student name:     YoungMinKim
         	Student number:   20166450
         	Version:          JavaSE-10
         	Date:             2019/06/09
                        
--------------------------------------------------------------------------------- */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//Make First Panel which is shown at first.
class panel01 extends JFrame{
	
	JPanel c =new JPanel();
	
	//need when user check the Box.
	int list1;
	int list2;
	
	//set the CheckBox.
	JCheckBox begginer1= new JCheckBox("begginer");
	JCheckBox intermediate1= new JCheckBox("intermediate");
	JCheckBox advanced1= new JCheckBox("advanced");
	JCheckBox highadvanced1= new JCheckBox("high_advanced");
	
	JCheckBox begginer2= new JCheckBox("begginer");
	JCheckBox intermediate2= new JCheckBox("intermediate");
	JCheckBox advanced2= new JCheckBox("advanced");
	JCheckBox highadvanced2= new JCheckBox("high_advanced");
	
	//to go next Panel.
	JButton next= new JButton("Next->");
	
	//let user can choose <User1,User2> of ability.
	JLabel start_msg1 = new JLabel("<Choose User1>");
	JLabel start_msg2 = new JLabel("<Choose User2>");
	
	//Constructor of panel01
    public panel01() {
    	
		setTitle("Bowling Game");
		setSize(800,400);  // Size of panel
		setVisible(true);
		c.setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(c);
		
		//No Layout! I will designate it on my own.
		c.setLayout(null);
		
		start_msg1.setLocation(40,40);
		start_msg1.setSize(400,40);

		start_msg2.setLocation(40,150);
		start_msg2.setSize(400,40);
		
		begginer1.setLocation(40,100);
		begginer1.setSize(100,40);
		
		intermediate1.setLocation(200,100);
		intermediate1.setSize(150,40);
		
		advanced1.setLocation(400,100);
		advanced1.setSize(100,40);
		
		highadvanced1.setLocation(600,100);
		highadvanced1.setSize(150,40);
		
		begginer2.setLocation(40,200);
		begginer2.setSize(100,40);
		
		intermediate2.setLocation(200,200);
		intermediate2.setSize(150,40);
		
		advanced2.setLocation(400,200);
		advanced2.setSize(100,40);
		
		highadvanced2.setLocation(600,200);
		highadvanced2.setSize(150,40);
		
		next.setLocation(300,300);
		next.setSize(100,40);
		
		
		c.add(start_msg1);
		c.add(start_msg2);
		c.add(begginer1);
		c.add(intermediate1);
		c.add(advanced1);
		c.add(highadvanced1);
		c.add(begginer2);
		c.add(intermediate2);
		c.add(advanced2);
		c.add(highadvanced2);
		c.add(next);
		
		MyItemListener listener =new MyItemListener();
		
		begginer1.addItemListener(listener);
		intermediate1.addItemListener(listener);
		advanced1.addItemListener(listener);
		begginer2.addItemListener(listener);
		intermediate2.addItemListener(listener);
		advanced2.addItemListener(listener);
		
		
	    next.addActionListener(new ActionListener() {
	        //define function when the button is pressed.
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	// make new panel
	            new panel2(list1,list2);  //should give information of list1, list2. for user's ability.
	        }
	        
	    });
	    

	}
    
    //if the button is pressed.
    class MyItemListener implements ItemListener{
    	public void itemStateChanged(ItemEvent e) {
    		if(e.getStateChange()== ItemEvent.SELECTED) {
    			
    			//If the user checked the CheckBox, list1,list2 is given as an integer. 
    			if(e.getItem()== begginer1)
    				list1=1;
    			else if(e.getItem()== intermediate1) 
    				list1=2;
    			else if(e.getItem()== advanced1) 
    				list1=3;
    			else if(e.getItem()== highadvanced1) 
    				list2=4;
    			else if(e.getItem()== begginer2) 
    				list2=1;
    			else if(e.getItem()== intermediate2) 
    				list2=2;
    			else if(e.getItem()== advanced2) 
    				list2=3;
    			else if(e.getItem()== highadvanced2) 
    				list2=4;
    		}
    		
    	}
    }
	
}


//Make second Panel2 which is shown when User press <Next->> button.
class panel2 extends JFrame{
	
	JPanel c =new JPanel();
	
	JLabel start_msg1 = new JLabel("<User1>");
	JLabel start_msg2 = new JLabel("<User2>");
	
	JLabel [] number =new JLabel[10];
	//round number.
	String [] number1 = {"1","2","3","4","5","6","7","8","9","10"};
	
	public panel2(int list1,int list2) {
		
		Bowling user_score1= new Bowling();
		Bowling user_score2= new Bowling();
		
		//score of each time of when the challenger get score.
		Vector<Integer> score_1=user_score1.score(list1);
		Vector<Integer> score_2=user_score2.score(list2);
		
		//to show each time score.
		JLabel [] s1 =new JLabel[score_1.size()];
		JLabel [] s2 =new JLabel[score_2.size()];
		
		//add total score every round.
		int[] total_score1=user_score1.total_score(score_1);
		int[] total_score2=user_score2.total_score(score_2);
		
		//make Label about information of who is the winner.
		JLabel win = new JLabel(user_score1.winner(total_score1, total_score2));
		
		setTitle("Bowling Game"); //title name
		setContentPane(c);
		c.setLayout(null);
		setSize(800,400);
		c.setBackground(Color.ORANGE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this is for location of label.
		int sum1=90;
		int sum2=90;

		//show <User1>.
		start_msg1.setLocation(40,40);
		start_msg1.setSize(100,40);
		
		//show <User2>.
		start_msg2.setLocation(40,150);
		start_msg2.setSize(100,40);
		
		add(start_msg1);
		add(start_msg2);
		
		//show the round number of user1.
		for(int i=0; i<10;i++) {
			number[i] = new JLabel(number1[i]);
			number[i].setLocation(120+i*60,40);
			number[i].setSize(40,40);
			c.add(number[i]);
		}
		
		//show the round number of user2.
		for(int i=0; i<10;i++) {
			number[i] = new JLabel(number1[i]);
			number[i].setLocation(120+i*60,150);
			number[i].setSize(40,40);
			c.add(number[i]);
		}
		
		//show User 1 score of each time.
		for(int i=0; i<score_1.size();i++) {
			sum1+=30;
			if(score_1.get(i)==10)
				s1[i] = new JLabel("X");
			else if(score_1.get(i)==0)
				s1[i] = new JLabel("-");
			else
				s1[i] = new JLabel(Integer.toString(score_1.get(i)));
			
			if(i!=0) {
				if(i != score_1.size()-1 && score_1.get(i-1)==10) {
					sum1+=30;
					s1[i].setLocation(sum1,60);
				}
				else {
					s1[i].setLocation(sum1,60);
				}
			}
			else {
				s1[i].setLocation(sum1,60);
			}
			
			s1[i].setSize(40,40);
			c.add(s1[i]);
		}
		
		
		//show User 2 score of each time.
		for(int i=0; i<score_2.size();i++) {
			sum2+=30;
			
			//if the score is 10 , denote as a "X".
			if(score_2.get(i)==10)
				s2[i] = new JLabel("X");
			//if the score is 10 , denote as a "-".
			else if(score_2.get(i)==0)
				s2[i] = new JLabel("-");
			else
				s2[i] = new JLabel(Integer.toString(score_2.get(i)));
			
			if(i!=0) {
				if(i != score_2.size()-1 && score_2.get(i-1)==10) {
					sum2+=30;
					s2[i].setLocation(sum2,170);
				}
				else if(i != score_2.size()-1 && score_2.get(i-1)==10) {
					sum2+=30;
					s2[i].setLocation(sum2,170);
				}
				else {
					s2[i].setLocation(sum2,170);
				}
			}
			else {
				s2[i].setLocation(sum2,170);
			}
			s2[i].setSize(40,40);
			c.add(s2[i]);
		}
		
		//show the User 1 Total Score of every round.
		for(int i=0; i<10;i++) {
			number[i] = new JLabel(Integer.toString(total_score1[i]));
			number[i].setLocation(120+i*60,80);
			number[i].setSize(40,40);
			c.add(number[i]);
		}
		
		//show the User 2 Total Score of every round.
		for(int i=0; i<10;i++) {
			number[i] = new JLabel(Integer.toString(total_score2[i]));
			number[i].setLocation(120+i*60,190);
			number[i].setSize(40,40);
			c.add(number[i]);
		}
		
		//show who is the winner.
		win.setLocation(250,250);
		win.setSize(500,100);
		
		add(win);
	}
}



//class to compute the bowling Score following the bowling rules.
class Bowling{
	int scoreuser1;
	int scoreuser2;
	int total_score1[] = new int[10];
	int total_score2[] = new int[10];
	Vector<Integer> roundscore1 = new Vector<Integer>();
	Vector<Integer> roundscore2 = new Vector<Integer>();
	
	String str;
	
	int pin_cnt1,pin_cnt2,len1,len2;

	//Compute each user score using percentage of ability and return Vector<> which stored score.
	Vector<Integer> score(int list){
		
		for (int round=1; round<=10;round++) {
			
			pin_cnt1=10;
			for(int i=0; i<2; i++) {
				if(list==1) 
					scoreuser1=parcentage100(pin_cnt1);
				else if(list==2) 
					scoreuser1=parcentage150(pin_cnt1);
				else if(list==3) 
					scoreuser1=parcentage200(pin_cnt1);
				else 
					scoreuser1=parcentage280(pin_cnt1);

				if(scoreuser1>=0 && scoreuser1<=9) {
					pin_cnt1=pin_cnt1-scoreuser1;
					roundscore1.add(scoreuser1);
				}
				else {
					roundscore1.add(scoreuser1);
					if(round!=10) {
						break;
					}
					
				}
			}
			
			len1 = roundscore1.size();
			
			//if round is 10 round and the user does strike or spare, the Chance will be given one more time.
			if(round==10 && (roundscore1.get(len1-1)==10 || roundscore1.get(len1-2)==10 || (roundscore1.get(len1-1)+roundscore1.get(len1-2)==10))) {
				pin_cnt1=10;
				if(list==1) {
					scoreuser1=parcentage100(pin_cnt1);
				}
				else if(list==2) {
					scoreuser1=parcentage150(pin_cnt1);
				}
				else {
					scoreuser1=parcentage200(pin_cnt1);
				}
				roundscore1.add(scoreuser1);
				len1+=1;
			}
		
		}
		
		
		return roundscore1;
	}
	
	//Compute the total score in Int array using Vector<>. and return int array.
	int[] total_score(Vector<Integer> score_) {
		
		int b=0;
		
		for(int j=0; j<10;j++) {
			if(j!=0) {
				total_score1[j]+=total_score1[j-1];
			}
			if(score_.get(b)<10 && (score_.get(b)+score_.get(b+1))<10) {
				total_score1[j]+=score_.get(b)+score_.get(b+1);
				b+=2;
			}
			else if(score_.get(b)<10 && (score_.get(b)+score_.get(b+1))==10) {
				total_score1[j]+=score_.get(b)+score_.get(b+1)+score_.get(b+2);
				b+=2;
			}
			else if(j==9 && score_.get(b)==10) {
				total_score1[j]+=score_.get(b)+score_.get(b+1)+score_.get(b+2);
				b+=1;		
			}
			else if(score_.get(b)==10) {
				total_score1[j]+=score_.get(b)+score_.get(b+1)+score_.get(b+2);
				b+=1;		
			}
		}
		System.out.print("\n");
		System.out.print("\nUser1 Á¡¼öÆÇ: ");
		for(int k=0;k<10;k++) {
			System.out.print(total_score1[k]+" ");
		}
		
		return total_score1;
	}
	
	//The user who is the total score is bigger is the winner.
	String winner(int[] total_score_1,int[] total_score_2) {
		if (total_score_1[9]<total_score_2[9]) {
			str="ÃÑÇÕ "+total_score_2[9]+" À¸·Î »ç¿ëÀÚ2´ÔÀÌ ½Â¸®ÇÏ¼Ì½À´Ï´Ù.";
		}
		else if(total_score_2[9]<total_score_1[9]) {
			str="ÃÑÇÕ "+total_score_1[9]+" À¸·Î »ç¿ëÀÚ1´ÔÀÌ ½Â¸®ÇÏ¼Ì½À´Ï´Ù.";
		}
		else {
			str="¹«½ÂºÎÀÔ´Ï´Ù.";
		}
		return str;
	}
	
	
	//For very high advanced ability.
	static int parcentage280(int pin_cnt) {
		int rand= (int)(Math.random()*101);
		int rand_num;
		if(pin_cnt==10) {
			if(rand>=10 && rand<=100)
				rand_num=pin_cnt;
			else
				rand_num=pin_cnt-1;
		}
		else
			rand_num=(int)(Math.random()*(pin_cnt+1));
		
		return rand_num;
	}
	
	//For advance ability.
	static int parcentage200(int pin_cnt) {
		int rand= (int)(Math.random()*101);
		int rand_num;
		//the rest of pin is 10 count,
		if(pin_cnt==10) {
			if(rand>=30 && rand<=100)
				rand_num=pin_cnt;
			else if(rand>=20 && rand<30)
				rand_num=pin_cnt-1;
			else if(rand>=10 && rand<20)
				rand_num=pin_cnt-2;
			else if(rand>=7 && rand<10)
				rand_num=pin_cnt-3;
			else
				rand_num=rand;
		}
		//the rest of pin is less than 10 count,
		else
			rand_num=(int)(Math.random()*(pin_cnt+1));
		
		return rand_num;
	}
	
	
	//For intermidiate ability.
	static int parcentage150(int pin_cnt) {
		int rand= (int)(Math.random()*101);
		int rand_num;
		if(pin_cnt==10) {
			if(rand>=80 && rand<=100)
				rand_num=pin_cnt;
			else if(rand>=50 && rand<80)
				rand_num=pin_cnt-1;
			else if(rand>=20 && rand<50)
				rand_num=pin_cnt-2;
			else if(rand>=7 && rand<20)
				rand_num=pin_cnt-3;
			else
				rand_num=rand;
		}
		else
			rand_num=(int)(Math.random()*(pin_cnt+1));
		
		return rand_num;
	}
	
	//For beginner ability.
	static int parcentage100(int pin_cnt) {
		int rand= (int)(Math.random()*101);
		int rand_num;
		if(pin_cnt==10) {
			if(rand>=95 && rand<=100)
				rand_num=pin_cnt;
			else if(rand>=80 && rand<95)
				rand_num=pin_cnt-1;
			else if(rand>=70 && rand<80)
				rand_num=pin_cnt-2;
			else if(rand>=60 && rand<70)
				rand_num=pin_cnt-3;
			else if(rand>=6 && rand<60)
				rand_num=pin_cnt-4;
			else
				rand_num=rand;
		}
		else
			rand_num=(int)(Math.random()*(pin_cnt+1));
		
		return rand_num;
	}
}



//main class.
public class BowlingGameScore extends JFrame{
	
	public static void main(String[] args){
		
		//start!!
		panel01 p1 = new panel01();
		
	}   
}


