


	//doubleChar
	public String doubleChar(String str) {
  
  		String newStr = "";
  
  		for (int i = 0; str.length() > i; i ++) {
  	  
    			String letter = str.substring(i,i+1);
    			newStr +=  letter + letter;
    		
  		}	
  
  		return newStr;
	}
	
	
	//countHi
	public int countHi(String str) {
  
  	int numHi = 0;
  
  	for (int i = 0; str.length() > i; i++) {
    
   		if (str.substring(i,i+1) == "hi") {
      			numHi += 1;
    		} 
  	}
  
  	return numHi;
	}
	
	
	
	
	
