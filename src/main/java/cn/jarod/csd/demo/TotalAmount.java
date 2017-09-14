package cn.jarod.csd.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static javax.xml.bind.DatatypeConverter.parseDate;

public class TotalAmount {



    public TotalAmount(BudgetRepo stubBudgetRepo) {
    }

    public double query(String s, String s1) throws ParseException {

        LocalDate startDate = createLocalDate(s);
        LocalDate endDate = createLocalDate(s1);
        int monthNum = getMonthSpace(s,s1);
        if (monthNum>0){
            double amount = 0;
            int sdays = startDate.lengthOfMonth()-startDate.getDayOfMonth() + 1;
            List<Budget> budgetList =  new BudgetRepo().findAll();
            for (Budget b : budgetList){
                double avgamount = b.getAmount()/startDate.lengthOfMonth();
                amount = sdays*avgamount;
            }

            int edays = endDate.getDayOfMonth()-endDate.lengthOfMonth() + 1;
            for (Budget b : budgetList){
                double avgamount = b.getAmount()/endDate.lengthOfMonth();
                amount += edays*avgamount;
            }

            List<String> monthList = getMonthBetween(s,s1);
            for (int m =1 ; m<(monthList.size()-1); m++){
                for (Budget b : budgetList){
                    if (b.getMonth().equals(monthList.get(m))){
                        amount += b.getAmount();
                    }
                }
            }
            return amount;
        }else if(monthNum == 0 )
        {
            int d_day = Integer.parseInt(s1.substring(5,6))-Integer.parseInt(s1.substring(5,6));
            if (d_day>=0){
                List<Budget> budgetList =  new BudgetRepo().findAll();
                for (Budget b : budgetList){
                    if (b.getMonth().equals(s.substring(0,6))){
                        int day = getDays(s);
                        double avgamount = b.getAmount()/day;
                        return d_day*avgamount;
                    }
                }
                return 0;
            }else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    private LocalDate createLocalDate(String str){
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(5,6));
        int day = Integer.parseInt(str.substring(7,8));
        return LocalDate.of(year,month,day);
    }

    public int getDays(String str) {
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(5,6));
        LocalDate localDate =  LocalDate.of(year,month,1);
        return localDate.lengthOfMonth();
    }

    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }

    private static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }


}
