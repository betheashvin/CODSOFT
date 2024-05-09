import java.util.Scanner;
public class Task2 {

    public static void main(String[] args) {
        userInput();
    }

    public static void userInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of subjects you wish to enter marks for: ");
        int numOfSub= scan.nextInt();
        float[] marks = new float[numOfSub];
        for(int i=0; i<numOfSub; i++)
        {
            System.out.println("Enter the number of marks for subject " + (i+1) + " :");
            marks[i] = scan.nextFloat();
            while(marks[i]<0 && marks[i]>100)
            {
                System.out.println("Kindly re-enter the number of marks for subject " + i+1 + " :");
                marks[i] = scan.nextFloat();
            }
        }

        System.out.println("The total marks are as follows: ");
        for (int i=0; i<numOfSub; i++)
        {
            System.out.println("Subject " + i+1 + " : " + marks[i]);
        }

        calcAvg(marks, numOfSub);

    }

    public static void calcAvg(float[] arr, int size)
    {
        float sum=0;
        for (int i=0; i<size; i++)
            sum += arr[i];

        float avg = sum/size;

        System.out.println("The average percentage is " + avg + ".");
        calcGrade(avg);
    }

    public static void calcGrade(float avg)
    {
        if (avg>=90)
            System.out.println("Th grade is A+.");
        else if (avg>=80)
            System.out.println("Th grade is A.");
        else if (avg>=70)
            System.out.println("Th grade is B.");
        else if (avg>=60)
            System.out.println("Th grade is C.");
        else if (avg>=50)
            System.out.println("Th grade is D.");
        else if (avg<50)
            System.out.println("Th grade is F.");
    }
}
