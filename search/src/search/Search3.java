import java.util.*;

public class Search3 {
   static List<String[]> list;
    private void content(){
        Map<String,String> file=new HashMap<>();
        file.put("d1","i like to watch the sunset with my friend");
        file.put("d2","the best places to watch the sunset");
        file.put("d3","my friend watch the sun come up");
        list=new LinkedList<>();
        for(String s:file.keySet()){
            String[] words= file.get(s).split(" ");
            arraySort(words);
            list.add(words);
        }
    }
    public void result(String[] s1,String[] s2,String[] s3){
        List<String> answer=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<s1.length && j<s2.length && k<s3.length){
            if(s1[i].equals(s2[j]) && s1[i].equals(s3[k])){
                answer.add(s1[i]);
                i++;
                j++;
                k++;
            }
            else if(isBiggerThan(s1[i],s2[j])&&isBiggerThan(s1[i],s3[k])){
                j++;
                k++;
            }else if(isBiggerThan(s2[j],s1[i])&&isBiggerThan(s2[j],s3[k])){
                i++;
                k++;
            }else if (isBiggerThan(s3[k],s1[i])&&isBiggerThan(s3[j],s2[j])){
                i++;
                j++;
            }
        }
        for(String s:answer){
            System.out.println(s);
        }
    }
    public static String[] arraySort(String[] input){
        for (int i=0;i<input.length-1;i++){
            for (int j=0;j<input.length-i-1;j++) {
                if(isBiggerThan(input[j],input[j+1])){
                    String temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
//        for(String s:input){
//            System.out.print(s+" ");
//        }
            return input;
        }

        /*如果first大于second，则返回true，否则返回false
         *
         */
        private static boolean isBiggerThan(String first, String second){
            if(first==null||second==null||"".equals(first) || "".equals(second)){
                System.out.println("字符串不能为空！");
                return false;
            }
            char[] arrayfirst=first.toCharArray();
            char[] arraysecond=second.toCharArray();
            int minSize = Math.min(arrayfirst.length, arraysecond.length);
            for (int i=0;i<minSize;i++) {
                if((int)arrayfirst[i]>(int)arraysecond[i]){
                    return true;
                }else if((int)arrayfirst[i] < (int)arraysecond[i]){
                    return false;
                }
            }
            if(arrayfirst.length>arraysecond.length){
                return true;
            }else {
                return false;
            }
        }

    public static void main(String[] args){
        Search3 search3=new Search3();
        search3.content();
        search3.result(list.get(0),list.get(1),list.get(2));
        for(String s:list.get(0)){
            System.out.print(s+" ");
        }
    }
}
