import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void occurrence()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = scanner.nextLine();
        s=s.toLowerCase();
        System.out.printf("\n%s \n",s);
        char[] charArr=s.toCharArray();//s will be array of chars
        int[] arrayOfOccurrence = new int[26];
        for (int i=0;i<s.length();i++)
        {
            arrayOfOccurrence[charArr[i]-'a']++;
        }
        for (int i=0;i<26;i++)
        {
            if(arrayOfOccurrence[i]>0)
            {
                char a = (char) (i + 'a' );
                System.out.printf("occurrence of %c = %d \n",a,arrayOfOccurrence[i] );
            }

        }

    }

    public static void lengthofletter()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = scanner.nextLine();
        String[] tokens = s.split(" ");
        int[] arr=new int[8];
        for(String token : tokens)
        {
            arr[token.length()]++;
        }
        for (int i = 0 ; i<8;i++)
        {
            System.out.printf("of %d letter = %d\n",i,arr[i]);
        }

    }
    public  static  void wordOccurrence()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string : ");
        String s = scanner.nextLine();
        s.replaceAll("[^a-zA-z0-9']"," ").toLowerCase();
        String[] tokens = s.split(" ");
        Set<String> check = new HashSet<>();
        for(int i=0;i<tokens.length;i++)
        {
            int c=1;
            for(!(check.contains(tokens[i])))
            {
                check.add(tokens[i]);
                for (int j=1;j<tokens.length;j++)
                {if (tokens[i].equals(tokens[j]))
                {
                    c++; j++;
                }}
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//	char a ='a';
//     int s;
//     s='z'-a;
//     System.out.println(s);
//     int i=6;
//     char c = (char) ('a'+i);
//     System.out.println(c);
    occurrence();
    lengthofletter();

    }
}
