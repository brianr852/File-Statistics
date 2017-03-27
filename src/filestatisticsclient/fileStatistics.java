/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestatisticsclient;

import java.util.*;
import java.text.*;

public class fileStatistics
{
  private ArrayList<Integer> grades;
  
  private final int MIN_GRADE_FOR_A = 9;
  private final int MIN_GRADE_FOR_B = 8;
  private final int MIN_GRADE_FOR_C = 7;
  private final int MIN_GRADE_FOR_D = 6;
  
  
  public fileStatistics (Scanner in)
  {
    this.grades = new ArrayList<Integer>();

    // Read grades and add them to gradeList.  Much cleaner.
    while (in.hasNext()) 
    {
      try
      {
        
        int grade = in.nextInt();
        System.out.println(grade);
        this.grades.add(grade);
      }
      
      catch( InputMismatchException ime)
      {
        System.out.println( "The input line \"" + in.nextLine() + "\" does not contain integer -ignoring");
      }
    }
    System.out.println("---> In the constructor: " + this.grades.size() + " grades read in. ");
    in.close();
}
  
  public double gradeAverage ()
  {
    int sum = 0;
 
    for ( Integer temp : this.grades )
      sum += temp;
    return (double) (sum)  / this.grades.size();
    
  }
  
  
  public double passRate()
  {
    int pass = 0;
    for ( Integer temp : this.grades )
    {
      if (temp >= 60) 
        pass ++;
        
    }
    return (double) (pass) / this.grades.size(); 
  }
  
  
  public double highestGrade()
  {
    int maxGrade = this.grades.get(0);
    for ( int index = 1; index < this.grades.size(); index++ )
    {
      int tempGrade = this.grades.get(index);
      if ( tempGrade > maxGrade )
      maxGrade = tempGrade;
    }
    return maxGrade;
  }
  
  
  
  public char [] getLetterGrades()
  {
    char [] letterGrade = new char [this.grades.size()];
    
    for ( int i = 0; i < this.grades.size(); i++ )
    {
      switch(this.grades.get(i) / 10 )
      {
        case 10 :
        case MIN_GRADE_FOR_A :
        letterGrade[i] = 'A';
        break;
        case MIN_GRADE_FOR_B:
        letterGrade[i] = 'B';
        break;
        case MIN_GRADE_FOR_C:
        letterGrade[i] = 'C';
        break;
        case MIN_GRADE_FOR_D:
        letterGrade[i] = 'D';
        break;
        default:
          letterGrade[i] = 'F';
      }
    }
    return letterGrade;
    
    
    
  }
  
  
  public ArrayList<Integer> getGrades()
  {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    
    for ( Integer currentGrades : this.grades )
    {
      temp.add(currentGrades);
    }
    
    return temp ;
  }
    
    
    public String toString ()
    {
      return "There are " + this.grades.size() + " grades. ";
    }
  
}