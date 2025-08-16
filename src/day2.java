//finding missing no
import java.util.Arrays;
import java.util.List;

public class day2 {
    static List<Integer> find(int[] arr)
    {
        int duplicate=-1; int missing=-1;
        for(int i=0;i<arr.length-1;i++)
        {
            int index=Math.abs(arr[i])-1;
            if(arr[index]<0)
            {
                duplicate=index+1;
            }
            else
            {
                arr[index]=-arr[index];
            }
        }
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>0)
            {
                missing=i+1;
                break;
            }
        }
        return Arrays.asList(missing);
    }
    public static void main(String args[])
    {
        int[] arr={1,2,4,5};
        System.out.println(find(arr));
    }
}
