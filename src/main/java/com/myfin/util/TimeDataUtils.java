package com.myfin.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Zihang Gao
 */
public class TimeDataUtils {
    private final String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

    public ArrayList<String> parseMonthList(String startMonth) {
        ArrayList<String> result = new ArrayList<>();
        int flag = 0;
        int startMonthPosition = 0;
                
        for (int i = 0; i < monthList.length; i++){
            if(monthList[i].equals(startMonth)){
                result.add(monthList[i]);
                flag = 1;
                startMonthPosition = i;
            } else if (flag == 1){
                result.add(monthList[i]);
            }
        }

        result.addAll(Arrays.asList(monthList).subList(0, startMonthPosition));
        
        return result;
    }
    
}
