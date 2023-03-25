class Solution {
    public int myAtoi(String s) {
        int flag=1;
        boolean flag2=false;
        int result=0;
        for (char c:s.toCharArray())
        {
            if (c==' ')
            {   
                if (flag2)
                    return result*flag;
                else 
                    continue;
                }
            if (c=='+')
            {
                if (!flag2)
                {    
                    flag2=true;
                    continue;
                }
                else 
                    return result*flag;
                
            }
            if (c=='-' )
            {    
                if (!flag2)
                {
                    flag =-1;
                    flag2 =true;
                    continue;
                }
                else 
                {
                    return result*flag;
                }
            }
            if (!Character.isDigit(c))
            {    
                return result*flag;
            }
            else
            {
                flag2=true;
                try {
                    int sum=Math.multiplyExact(result,10);
                    sum=Math.addExact(sum,Character.getNumericValue(c));
                    result=sum;
                }
                catch (ArithmeticException ae)
                {
                    if (flag==-1)
                        return Integer.MIN_VALUE;
                    else 
                        return Integer.MAX_VALUE;
                }
            }
        }
            return result*flag;
    }
}
