public class Circulate {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7,8,9};
        //增强for循环
        for(int x:a){
            System.out.print(x+"\t");
            if(x%5==0){
                break;
            }
            System.out.print("------\t");
        }
        System.out.println("\n*****");
        /*1.执行增强for循环的循环体
          2.直到有if条件，break跳出循环体
          3.执行循环体外的程序
        */
    }
}
