import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class pomodoro_timer {
    public static int test=0;
        public static void main(String[] args) throws InterruptedException{
            System.out.println("Введите время работы и отдыха в формате -w 1 -b 1");
            // просто System.in считывает по одному символу. nextLine() - Считать строку, nextInt() - число.
            String[] cmd = new Scanner(System.in).nextLine().split(" ");

            int work = 1;
            int breake = 1;
            int sizebreak = 30; // длина заполнения прогресс-бара
            int sizework = 60;
            boolean help = false;
            int count = 1;

            for(int i=0; i < cmd.length;i++){
                switch (cmd[i]) {
                    case "--help" -> {
                        System.out.println("""
                                       
                                \nPomodoro - сделай свое время более эффективным.                        
                                	-w <time>: время работы, сколько хочешь работать.                      
                                	-b <time>: время отдыха, сколько хочешь отдыхать.
                        
                                	-count <count>: количество итераций.
                      
                                	--help: меню помощи.""");
                        help = true; // если true - выходим из проги
                    }
                    case "-w" -> work = Integer.parseInt(cmd[++i]); // -w пробел, забрать ЧИСЛО
                    case "-b" -> breake = Integer.parseInt(cmd[++i]);
                    case "-count" -> count = Integer.parseInt(cmd[++i]);
                }
            }
            if(help == false){
                long startTime = System.currentTimeMillis();

                for (int i = 1; i <= count; i++) {
                    timer(work, breake, sizebreak, sizework);
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Pomodor таймер истек: " + (endTime-startTime)/(1000 * 60)+ " min");
            // 1000 милисекунд в секунде
            }

        }

        public static void timer(int work, int breake, int sizebreak, int sizework) throws InterruptedException{

            printProgress("Work Progress::  ", work, sizework);

            printProgress("Break Progress:: ", breake, sizebreak);
        }

        private static void printProgress(String process, int time, int size) throws InterruptedException {
            int length;
            int rep;
            length = 60* time / size;
            rep = 60* time /length;
            int stretchb = size /(3* time);
            for(int i=1; i <= rep; i++){
                double x = i;
                x = 1.0/3.0 *x;
                x *= 10;
                x = Math.round(x);
                x /= 10;
                double w = time *stretchb;
                double percent = (x/w) *1000;
                x /=stretchb;
                x *= 10;
                x = Math.round(x);
                x /= 10;
                percent = Math.round(percent);
                percent /= 10;
                System.out.print(process + percent+"% " + (" ").repeat(5 - (String.valueOf(percent).length())) +"[" + ("#").repeat(i) + ("-").repeat(rep - i)+"]    ( " + x +"min / " + time +"min )"+  "\r");
                if(test == 0){
                    TimeUnit.SECONDS.sleep(length);
                }
            }
            System.out.println();
        }
}
