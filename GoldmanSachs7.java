/**
 * QUES 7 -> Find Missing and Repeating (GFG)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
import java.util.*;

class Solve {
    public int[] findTwoElement(int arr[], int n) {
        int [] hash=new int[n+1];
        Arrays.fill(hash, 0);
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        
        int repeating=-1;
        int missing=-1;
        
        for(int i=1; i<=n; i++){
            if(hash[i] == 2){
                repeating=i;
            }
            
            else if(hash[i] == 0){
                missing=i;
            }
            
            if(repeating!=-1 && missing!=-1){
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}