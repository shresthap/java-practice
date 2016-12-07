package string;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class StringBuilderBufferTest {

    public static void main(String[] args){
//        System.out.println("args: " + args.length);
//        System.out.println("args: " + args.equals(null));
//        String testA;
//        test.BasicUnitTest basicUnitTesta = new test.BasicUnitTest();
//        test.BasicUnitTest basicUnitTestb ;
//        String testa = "a";
//        testStringBufferBuilder();
        testThreadedStringBufferBuilder();

    }


    public static void testStringBufferBuilder(){
        String stringConcat = "";
        long t0 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            stringConcat += "Some String";
        }
        System.out.println("Strings: " + (System.currentTimeMillis() - t0));

//        StringBuffer buffer = new StringBuffer();
//        t0 = System.currentTimeMillis();
//        for(int i = 0; i<100000; i++){
//            buffer.append("Some String");
//        }
//        System.out.println("Buffer: " + (System.currentTimeMillis() - t0));
////
//        StringBuilder builder = new StringBuilder();
//        t0 = System.currentTimeMillis();
//        for(int i = 0; i<100000; i++){
//            builder.append("Some String");
//        }
//        System.out.println("Builder: " + (System.currentTimeMillis() - t0));
    }


    public static void testThreadedStringBufferBuilder(){
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0 ; i < 10; i++){
            executorService.execute(new AppendableRunnable(buffer));
        }
        shutdownAndWaitTermination(executorService);
        System.out.println(" Thread Buffer : "+ AppendableRunnable.time);

        //With Builder
        AppendableRunnable.time = 0;
        executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < 10; i++){
            executorService.execute(new AppendableRunnable(builder));
        }
        shutdownAndWaitTermination(executorService);
        System.out.println(" Thread Builder: "+ AppendableRunnable.time);

    }

    static void shutdownAndWaitTermination(ExecutorService pool){
        pool.shutdown();
        try{
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)){
                pool.shutdown();
                if(!pool.awaitTermination(60, TimeUnit.SECONDS)){
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (Exception e ){

        }
    }

    static class AppendableRunnable<T extends Appendable> implements Runnable {
        static long time = 0;
        T appendable;
        public AppendableRunnable(T appendable){
            this.appendable = appendable;
        }

//        public AppendableRunnable(StringBuffer buffer) {
//        }

        @Override
        public void run(){
            long t0 = System.currentTimeMillis();
            for(int j = 0; j < 100000; j++){
                try{
                    appendable.append("Some String");
                } catch (IOException e){

                }
                time += (System.currentTimeMillis() - t0);
            }

        }
    }
}
