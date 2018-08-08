/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.pbs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author ryan.clark
 */
public class Call {
    private String branch, outcome, date;

    public Call(String input) throws ParseException {
        String[] inputSplit = input.split(",");
        
        this.branch = inputSplit[1];
        this.date = inputSplit[2];
        this.outcome = inputSplit[6];
        
        this.branch = trimBranch();
        Date formattedDate = getDate();
        
    } 
    
    public String trimBranch(){
        char[] characters = new char[branch.length()];
        int charPos = 0;
        for(int i = 0; i< branch.length();i++){
            
            if(branch.charAt(i)>= 48 && branch.charAt(i) <= 57 ){
                
            }else{
                characters[charPos] = branch.charAt(i);
                charPos++;
            }
        }
     
        return String.valueOf(characters).trim();
    }
    
    public Date getDate() throws ParseException{
        this.date.replace("/", "-");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = dateFormat.parse(this.date);
        
        return date;
    }
    
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
    
    
}
