package Maps;

import java.util.HashSet;
import java.util.Set;

public class Check_Double_Exist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> setArray = new HashSet<>();

        for(int num : arr)
        {
            setArray.add(num);
        }

        for(int i =0; i< arr.length ;i++)
        {
            int target = arr[i] * 2;
            if(setArray.contains(target))
            {
                return true;
            }
        }

        return false;
    }
}
