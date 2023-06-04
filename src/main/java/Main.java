import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        while(true) {
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()) {
                int qty = sc.nextInt();
                if (qty>1) {
                    Calculator unit = new Calculator();
                    unit.qty = qty;
                    unit.input();
                    break;
                }
            }
            System.out.println("Ошибка! Повторите ввод!");
        }
    }
}
    class Calculator{
        ArrayList<String> list = new ArrayList<>();
        int qty;
        double price=0;

        private double price() {
            double inputPrice;
            while(true){
                Scanner sc = new Scanner(System.in);
                if(!sc.hasNextDouble()) {
                    System.out.println("Ошибка! Не числовое значение! Повторите ввод!");
                } else {
                    inputPrice = sc.nextDouble();
                    if(inputPrice<=0) {
                        System.out.println("Ошибка! Некорректная цена! Повторите ввод!");
                    } else {
                        price += inputPrice;
                        break;
                    }
                }
            }
            return price;
        }

        private String declension(double sum) {
            sum = Math.floor(sum);
            for(int i=11; i<=14; i++) {
                if ((sum - i) % 100 == 0) {
                    return " рублей.";
                }
            }
            if(sum%10 ==1) {
                return " рубль.";
            } else if(sum%10 ==2 || sum%10==3 || sum%10== 4) {
                return " рубля.";
            }
            return " рублей.";
        }

        public void input() {
            double inputSum, sum;
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите название товара:");
                String product = sc.nextLine();
                System.out.println("Введите цену товара:");
                inputSum = price();
                list.add(product);
                System.out.println("Товар добавлен!\nХотите добавить ещё один товар?");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("завершить")) {
                    break;
                }
            }
            System.out.println("Добавленные товары:");
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
            sum = inputSum/qty;
            String rub = declension(sum);
            String result = String.format("%.2f", sum);
            System.out.println("Счет на каждого человека: " + result + rub);
        }
    }