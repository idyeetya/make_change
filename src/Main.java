import java.util.HashMap;

public class Main {
    public static int[] coinlist = {25, 10, 5, 1};
    public static void main(String[] args) {
        //System.out.println(make_change(10, 26));
        HashMap<int[], Integer> coinvals = new HashMap<int[], Integer>();
        System.out.println(weirdmake_change(100, 26, coinvals));
    }
    /*
    public static int make_change(int cents, int n)
    {
        int counter = 0;
        if (cents == 0)
        {
            n--;
            return 1;
        }
        for(int x : coinlist) {
            if (cents >= x && x < n) {
                    counter += (make_change(cents - x, x + 1));
            }
        }

        return counter;
    }
    */
    public static int weirdmake_change(int cents, int n, HashMap<int[] , Integer> savedvals)
    {
        int counter = 0;
        if (cents == 0)
        {
            n--;
            return 1;
        }
        for(int x : coinlist) {
            if (cents >= x && x < n) {
                int[] temparr = {cents-x, n};
                if(savedvals.containsKey(temparr))
                {
                    counter += savedvals.get(temparr);
                }
                else
                {
                    int value = (weirdmake_change(cents - x, x + 1, savedvals));
                    counter += value;
                    int[] temparrtwo = {cents-x, n};
                    if(cents-x > 0 && savedvals.containsKey(temparrtwo) == false)
                    {
                        savedvals.put(temparrtwo, value);
                    }
                }
            }
        }

        return counter;
    }
}
