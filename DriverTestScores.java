import java.util.Collections;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class DriverTestScores extends Application{
	
	private static int maxCount=100;
	private static int count = 0;
	private static TestScores [] students = new TestScores[maxCount];
	
	public static void main (String [] args){
		launch(args);
		int studentCatalog = 0;
		while(studentCatalog<count){
			System.out.println(students[studentCatalog]);
			studentCatalog++;
		}
	}
	
	
	@Override
	public void start(Stage primaryStage){
		
		Label StudentNameLabel = new Label ("Student's Name:");
		Label [] TestScoreLabel = new Label [4];
			TestScoreLabel[0] = new Label ("Test 1- 	Score: ");
			TestScoreLabel[1] = new Label ("Test 2- 	Score: ");
			TestScoreLabel[2] = new Label ("Test 3- 	Score: ");
			TestScoreLabel[3] = new Label ("Test 4- 	Score: ");
		Label [] TestWeightLabel = new Label [4];
			TestWeightLabel[0] = new Label ("Weight: ");
			TestWeightLabel[1] = new Label ("Weight: ");
			TestWeightLabel[2] = new Label ("Weight: ");
			TestWeightLabel[3] = new Label ("Weight: ");
		TextField StudentNameTextField = new TextField();
		TextField [] TestScoreTextField = new TextField[4];
			TestScoreTextField[0] = new TextField();
			TestScoreTextField[1] = new TextField();
			TestScoreTextField[2] = new TextField();
			TestScoreTextField[3] = new TextField();
		TextField [] TestWeightTextField = new TextField[4];
			TestWeightTextField [0] = new TextField();
			TestWeightTextField [1] = new TextField();
			TestWeightTextField [2] = new TextField();
			TestWeightTextField [3] = new TextField();
		
		Label InvalidStudentNameLabel = new Label ("Blank Student's Name");
		InvalidStudentNameLabel.setTextFill(Color.rgb(255,0,0));
		InvalidStudentNameLabel.setVisible(false);
		
		Label [] InvalidTestScoreLabel = new Label [4];
		for(int G = 0;G<InvalidTestScoreLabel.length; G++){
			InvalidTestScoreLabel[G] = new Label ("Blank Test "+(G+1)+" Score");
			InvalidTestScoreLabel[G].setTextFill(Color.rgb(255,0,0));
			InvalidTestScoreLabel[G].setVisible(false);
		}
		Label [] InvalidTestWeightLabel = new Label [4];
		for(int g = 0;g<InvalidTestWeightLabel.length; g++){
			InvalidTestWeightLabel[g] = new Label ("Blank Test "+(g+1)+" Weight");
			InvalidTestWeightLabel[g].setTextFill(Color.rgb(255,0,0));
			InvalidTestWeightLabel[g].setVisible(false);
		}
		
		Label InvalidTestWeightTotalLabel = new Label ("Test Weights must add up to 1.00");
		InvalidTestWeightTotalLabel.setTextFill(Color.rgb(255, 0, 0));
		InvalidTestWeightTotalLabel.setVisible(false);
		Label InvalidTestScoreTotalLabel = new Label ("Test scores must be 110 or lower");
		InvalidTestScoreTotalLabel.setTextFill(Color.rgb(255, 0, 0));
		InvalidTestScoreTotalLabel.setVisible(false);
		Label ErrorTestTotalLabel = new Label ("Error");
		ErrorTestTotalLabel.setTextFill(Color.rgb(255, 0, 0));
		ErrorTestTotalLabel.setVisible(false);
		
		
		Button CalculateBtn = new Button ("Calculate");
		CalculateBtn.setOnAction(new EventHandler<ActionEvent>(){
			
			//String TestScoreTester = "(?=.*[0-9]";
			//String TestWeightTester = "\\.+(?=.*[0-9])";
			
			boolean StudentNameStatus = false;
			boolean [] TestScoreStatus = new boolean [4];
			boolean [] TestWeightStatus = new boolean [4];
			boolean TestScoreTotalStatus = false;
			boolean TestWeightTotalStatus = false;
			//boolean TestTotalCheck = false;
			
			
			@Override
			public void handle(ActionEvent event) {
				
				StudentNameStatus =validateBlank(StudentNameTextField);
					if (StudentNameStatus==false){InvalidStudentNameLabel.setVisible(true);}
					else{InvalidStudentNameLabel.setVisible(false);}
				
				for(int i = 0; i<TestScoreStatus.length; i++){	
				TestScoreStatus[i] =validateBlank(TestScoreTextField[i]);
					if (TestScoreStatus[i]==false){InvalidTestScoreLabel[i].setVisible(true);}
					else{InvalidTestScoreLabel[i].setVisible(false);}
				}
					
				for(int I = 0; I<TestWeightStatus.length; I++){	
				TestWeightStatus[I] =validateBlank(TestWeightTextField[I]);
					if (TestWeightStatus[I]==false){InvalidTestWeightLabel[I].setVisible(true);}
					else{InvalidTestWeightLabel[I].setVisible(false);}
				}
					
					if(StudentNameStatus){
					if(TestScoreStatus[0-3]){
					if(TestWeightStatus[0-3]){
				
				//if(TestWeightTextField[0].getText().matches(TestWeightTester)){
				//	TestTotalCheck=true; ErrorTestTotalLabel.setVisible(false);
				//}
				//else{
				//	TestTotalCheck=false; ErrorTestTotalLabel.setVisible(true);
				//}
				
				//if(TestTotalCheck){
					
				float [] TestScoreInput = new float [4];
				String [] TestScoreCheck = new String [4];
				float [] TestWeightInput = new float [4];
				String [] TestWeightCheck = new String [4];
				
				String StudentNameInput = StudentNameTextField.getText();
				
				for(int X = 0; X<TestScoreTextField.length; X++)
					{TestScoreCheck[X] = TestScoreTextField[X].getText();}
				for(int Y = 0; Y<TestWeightTextField.length; Y++)
					{TestWeightCheck[Y] = TestWeightTextField[Y].getText();}
				
				for(int x = 0; x<TestScoreInput.length; x++)
					{TestScoreInput[x] = Float.parseFloat(TestScoreCheck[x]);}
				for(int y = 0; y<TestWeightInput.length; y++)
					{TestWeightInput[y] = Float.parseFloat(TestWeightCheck[y]);}
		
				float WeightTotal = 0;
					for(int B=0; B<TestWeightInput.length; B++){WeightTotal+=TestWeightInput[B];}
					
					if(TestScoreInput[0]<=110&&TestScoreInput[1]<=110&&TestScoreInput[2]<=110&&TestScoreInput[3]<=110){	
						TestScoreTotalStatus=true;
						InvalidTestScoreTotalLabel.setVisible(false);
					}
					else{
						TestScoreTotalStatus=false;	
						InvalidTestScoreTotalLabel.setVisible(true);
					}	
					if (WeightTotal == 1.00){
						TestWeightTotalStatus=true;
						InvalidTestWeightTotalLabel.setVisible(false);
					}
					else{
						TestWeightTotalStatus=false;
						InvalidTestWeightTotalLabel.setVisible(true);
					}
					
					if(TestScoreTotalStatus){
					if(TestWeightTotalStatus){			
					
						
				students[count] = new TestScores(TestScoreInput, TestWeightInput, StudentNameInput);
				
				StudentNameTextField.setText("");
				for(int a = 0; a<TestScoreTextField.length; a++)
				{TestScoreTextField[a].setText("");}
				for(int b = 0; b<TestWeightTextField.length; b++)
				{TestWeightTextField[b].setText("");}
				
				JOptionPane.showMessageDialog(null, students[count]);
				count++;			
	
		}}
		//}
		}}}
			}
		});
	
		primaryStage.setTitle("Grade Calculator");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
	
		grid.add(StudentNameLabel,0,1);
		grid.add(InvalidTestWeightTotalLabel, 3, 6);
		grid.add(InvalidTestScoreTotalLabel, 1, 6);
		grid.add(ErrorTestTotalLabel, 0, 6);
		grid.add(CalculateBtn, 0, 7);
		grid.add(InvalidStudentNameLabel, 1, 0);
		grid.add(StudentNameTextField, 1, 1);
		for(int K =0; K<TestScoreLabel.length; K++)
			{grid.add(TestScoreLabel[K], 0, K+2);}
		for(int L = 0; L<TestScoreTextField.length; L++)
			{grid.add(TestScoreTextField[L], 1, L+2);}
		for(int J = 0; J<InvalidTestScoreLabel.length; J++)
			{grid.add(InvalidTestScoreLabel[J], 1, J+7);}
		for(int k =0; k<TestWeightLabel.length; k++)
			{grid.add(TestWeightLabel[k], 2, k+2);}
		for(int l = 0; l<TestWeightTextField.length; l++)
			{grid.add(TestWeightTextField[l], 3, l+2);}
		for(int j = 0; j<InvalidTestWeightLabel.length; j++)
			{grid.add(InvalidTestWeightLabel[j], 3, j+7);}
		
		Scene scene = new Scene(grid, 750, 500);
		scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}	
	
	//validate method provided by Prof. Tanes Kanchanawanchai
		public boolean validateBlank(TextField tfBlank){
			boolean passBlank = false;
			ObservableList<String> styleClass = tfBlank.getStyleClass();
			
			if(tfBlank.getText().trim().length()==0){
				if(! styleClass.contains("error")){
					styleClass.add("error");
				}
			}
			else{
				styleClass.removeAll(Collections.singleton("error"));
				passBlank = true;
			}
			return passBlank;
		}
}