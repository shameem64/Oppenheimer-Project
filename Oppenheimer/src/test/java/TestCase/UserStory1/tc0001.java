package TestCase.UserStory1;

import org.testng.annotations.Test;
import APIFunctions.InsertSingleWorkingHeroRecord;


public class tc0001 {
	
	@Test
	public static void PostSingleRecord() {
		
		String Reponse = InsertSingleWorkingHeroRecord.PostSingleRecord(		
			"{\r\n"
				+ "  \"birthday\": \"04041982\",\r\n"
				+ "  \"gender\": \"f\",\r\n"
				+ "  \"name\": \"TestName\",\r\n"
				+ "  \"natid\": \"ABCD\",\r\n"
				+ "  \"salary\": \"7000\",\r\n"
				+ "  \"tax\": \"70\"\r\n"
				+ "}",201); 
		InsertSingleWorkingHeroRecord.VerifyResponse(Reponse, "Inserted");
	}

}
