package is.ru.stringcalculator;

public class Calculator{

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			if(text.contains(",")){
				if(text.contains("\n")){
					text = text.replaceAll("\n", ",");
				}
				String[] numbers = text.split(",");
				String[] negatives = checkNeg(numbers);
				if(negatives.length != 0){
					String message;
					String negs = negatives[0];
					for(int i = 1; i < negatives.length; i++){
						negs = negs + ", " + negatives[i];
					}
					message = "Negatives not allowed: " + negs;
					throw new IllegalArgumentException(message);
				}
				return sum(numbers);	
			}
			return Integer.parseInt(text);
		}
	}


	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int sum(String [] numbers){
		int result = 0;
		for(String number : numbers){
			result += toInt(number);
		}
		return result;
	}

	private static String[] checkNeg(String [] numbers){
		int countNeg = 0;
		for(String number : numbers){
			if(toInt(number) < 0){
				countNeg++;
			}
		}
		String[] negatives = new String[countNeg];
		countNeg = 0;
		for(String number : numbers){
			if(toInt(number) < 0){
				negatives[countNeg] = number;
				countNeg++;
			}
		}
		return negatives;
	}
}