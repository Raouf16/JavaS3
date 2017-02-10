package com.github.KatiaSersour.EE5_7;
import java.util.Scanner;

public class Quiz {

		interface IntQuestion {
			public String getQuestion();
			public int getCorrectAnswer();
	    }
	    
		static class AdditionQuestion implements IntQuestion {
		       int a, b; 
		       public AdditionQuestion() {
		           a = (int)(Math.random() * 50);
		           b = (int)(Math.random() * 50);
		       }
		       public String getQuestion() {
		           return  a + " + " + b + " =?";
		       }
		       public int getCorrectAnswer() {
		           return a + b;
		       }
	    }

		static class SubtractionQuestion implements IntQuestion {
		       int a, b; 
		       public SubtractionQuestion() {
		           a = (int)(Math.random() * 50);
		           b = (int)(Math.random() * 50);
		           if (b > a) { 
		               int temp = a;
		               a = b;
		               b = temp;
		            }
		       }
		       public String getQuestion() {
		           return  a + " - " + b + " =?";
		       }
		       public int getCorrectAnswer() {
		           return a - b;
		       }
	    }

	      

	    private static IntQuestion[] questions;  
	    private static int[] reponses;  

	    public static void creerQuestionnaire() {
	        questions = new IntQuestion[10];
	        for ( int i = 0; i < 4; i++ ) {
		            questions[i] = new AdditionQuestion();
	        }
	        
	        for ( int i = 4; i < 8; i++ ) {
	        	questions[i] = new SubtractionQuestion();
	        }
	        questions[8] = new IntQuestion() {
	              public String getQuestion() {
	                  return "Combien y a-t-ils de joueurs dans un match de foot?";
	              }
	              public int getCorrectAnswer() {
	                  return 11;
	              }
	        };
	        questions[9] = new IntQuestion() {
	              public String getQuestion() {
	                  return "Combien coute un voyage à Bora Bora";
	              }
	              public int getCorrectAnswer() {
	                  return 200;
	              }
	        };
	   }        
	    
	    
		private static void administrerQuiz(){
	        reponses = new int[10];
	        Scanner sc;
	        for (int i = 0; i < 10; i++) {
	        	System.out.print("question N°"+ (i+1) +": "+ questions[i].getQuestion());
				sc = new Scanner(System.in);
			    reponses[i] = sc.nextInt();
	        }
	    }
	    
	    public static void evaluerQuiz(){
			int score=0;
			int i;
			System.out.println("les bonnes réponses sont:");
			for(i=0;i<10;i++){
			    if(reponses[i]==questions[i].getCorrectAnswer()){
			    	System.out.println("question N°"+ (i+1) + ": "+ questions[i].getQuestion() +", la reponse est: "+ questions[i].getCorrectAnswer() +". Votre réponse est correcte.");
			    	score+=10;		    
			}else{
			    	System.out.println("question N°"+ (i+1) + ": "+ questions[i].getQuestion()+ ", la reponse est: "+ questions[i].getCorrectAnswer() + ". Vous avez trouvez "+reponses[i]+", votre réponse n'est pas correcte.");
			    }
			}
			System.out.println("votre score est de "+score+" points");
		}
	    
	    public static void main(String[] args) {
			creerQuestionnaire();
			administrerQuiz();
			evaluerQuiz();
		}
	    
}
