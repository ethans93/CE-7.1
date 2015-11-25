public class TestScores {

		private String StudentName;
		private float AverageScore;
		private String LetterGrade;
		private double GPA;
		private static float [] TS = new float [4];
		private static float [] TW = new float [4];
		
		
		public TestScores(float TestScoreInput[], float TestWeightInput[], String StudentName){
			for(int W = 0; W<TS.length; W++){
				this.TS[W]=TestScoreInput[W];
			}
			for(int Y = 0; Y<TW.length; Y++){
				this.TW[Y]=TestWeightInput[Y];
			}
			this.StudentName=StudentName;
			this.AverageScore = (((TS[0]*(TW[0]*100))+(TS[1]*(TW[1]*100))+(TS[2]*(TW[2]*100))+(TS[3]*(TW[3]*100)))/100);
			this.LetterGrade=LetterGrade;
				if(AverageScore<=100&&AverageScore>=93){LetterGrade = "A";}
				else if(AverageScore<93&&AverageScore>=91){LetterGrade = "A-";}
				else if(AverageScore<91&&AverageScore>=89){LetterGrade = "B+";}
				else if(AverageScore<89&&AverageScore>=84){LetterGrade = "B";}
				else if(AverageScore<84&&AverageScore>=82){LetterGrade = "B-";}
				else if(AverageScore<82&&AverageScore>=80){LetterGrade = "C+";}
				else if(AverageScore<80&&AverageScore>=75){LetterGrade = "C";}
				else if(AverageScore<75&&AverageScore>=73){LetterGrade = "C-";}
				else if(AverageScore<73&&AverageScore>=71){LetterGrade = "D+";}
				else if(AverageScore<71&&AverageScore>=67){LetterGrade = "D";}
				else if(AverageScore<67&&AverageScore>=65){LetterGrade = "D-";}
				else if(AverageScore<65&&AverageScore>=0){LetterGrade = "F";}
			this.GPA=GPA;
				if(LetterGrade.equals("A")){GPA=4.00;};
				if(LetterGrade.equals("A-")){GPA=3.70;};
				if(LetterGrade.equals("B+")){GPA=3.33;};
				if(LetterGrade.equals("B")){GPA=3.00;};
				if(LetterGrade.equals("B-")){GPA=2.70;};
				if(LetterGrade.equals("C+")){GPA=2.30;};
				if(LetterGrade.equals("C")){GPA=2.00;};
				if(LetterGrade.equals("C-")){GPA=1.70;};
				if(LetterGrade.equals("D+")){GPA=1.30;};
				if(LetterGrade.equals("D")){GPA=1.00;};
				if(LetterGrade.equals("D-")){GPA=0.70;};
				if(LetterGrade.equals("F")){GPA=0;};	
		}
		
			
		public static float getScores( float [] TestScoresInput){
			for(int Q = 0; Q<TestScoresInput.length; Q++){
				TS[Q]=TestScoresInput[Q];
			}
			return TS[0-3];
		}
		public void setScores (float [] TestScoresInput){
			for(int R = 0; R<TestScoresInput.length; R++){
				this.TS[R]=TestScoresInput[R];
			}
		}
		public static float getWeights( float [] TestWeightInput){
			for(int E = 0; E<TestWeightInput.length; E++){
				TW[E]=TestWeightInput[E];
			}
			return TW[0-3];
		}
		public void setWeights (float [] TestWeightInput){
			for(int T = 0; T<TestWeightInput.length; T++){
				this.TW[T]=TestWeightInput[T];
			}
		}
		
		public String toString(){
			return "Student Name: "+this.StudentName
					+"\n Test 1 - Score: "+TS[0]+"		Weight: "+TW[0]
					+"\n Test 2 - Score: "+TS[1]+"		Weight: "+TW[1]
					+"\n Test 3 - Score: "+TS[2]+"		Weight: "+TW[2]
					+"\n Test 4 - Score: "+TS[3]+"		Weight: "+TW[3]
					+"\n\n AverageScore: "+AverageScore
					+"\n Letter Grade: "+LetterGrade
					+"\n GPA: "+GPA+"\n\n";
		}
}